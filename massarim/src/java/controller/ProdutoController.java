/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.bean.CategoriaDTO;
import model.bean.ProdutoDTO;
import model.dao.CategoriaDAO;
import model.dao.ProdutoDAO;
import model.dao.UsuarioDAO;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ProdutoController", urlPatterns = {"/produtos", "/cadastrar-produto", "/home", "/cadastrarProduto", "/buscar-produtos", "/produto-massarim", "/revisao","/excluir-produto","/excluirProduto"})
@MultipartConfig
public class ProdutoController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        ProdutoDAO produtosDAO = new ProdutoDAO();
        CategoriaDAO categoriasDAO = new CategoriaDAO();
        List<CategoriaDTO> categorias = categoriasDAO.read();
        request.setAttribute("categorias", categorias);
        String url = request.getServletPath();
        if (url.equals("/cadastrar-produto")){
            String nextPage = "/WEB-INF/jsp/cadastroProdutos.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        } else if (url.equals("/home")){
            List<ProdutoDTO> produto = produtosDAO.readProdutos();
            request.setAttribute("produto", produto);
            String nextPage = "/WEB-INF/jsp/index.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        } else if (url.equals("/buscar-produtos")){
            String busca = request.getParameter("busca") != null ? request.getParameter("busca") : "";
            if (busca.equals("")) {
                String categoria = request.getParameter("cat");
                List<ProdutoDTO> produto = produtosDAO.buscaCategoria(Integer.parseInt(categoria));
                request.setAttribute("produto", produto);
            } else {
                busca = "%" + busca + "%";
                List<ProdutoDTO> produto = produtosDAO.buscaProdutos(busca);
                request.setAttribute("produto", produto);
            }

            String nextPage = "/WEB-INF/jsp/produtos.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        } else if (url.equals("/produto-massarim")) {
            String nextPage = "/WEB-INF/jsp/produto-massarim.jsp";
            int idProduto = Integer.parseInt(request.getParameter("focado"));
            ProdutoDAO proDAO = new ProdutoDAO();
            ProdutoDTO produto = proDAO.focarProduto(idProduto);

            request.setAttribute("produto", produto);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        } else if (url.equals("/revisao")) {
            Cookie[] cookies = request.getCookies();
            boolean passa = false;
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("logar") && !(cookie.getName().equals(""))) {
                    passa = true;
                }
            }
            if (passa){
                String nextPage = "/WEB-INF/jsp/revisao.jsp";
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
                dispatcher.forward(request, response);
            }else {
                String nextPage = "/WEB-INF/jsp/login.jsp";
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
                dispatcher.forward(request, response);
            }

        }else if(url.equals("/excluir-produto")){
            List<ProdutoDTO> produto = produtosDAO.readProdutos();
            request.setAttribute("produto", produto);
            String nextPage = "/WEB-INF/jsp/excluir.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getServletPath();
        if (url.equals("/excluirProduto")){
                int idProduto = Integer.parseInt(request.getParameter("idProduto"));
                ProdutoDAO produtoDAO = new ProdutoDAO();
                produtoDAO.delete(idProduto);
                response.sendRedirect("./excluir-produto");
        }else if (url.equals("/cadastrarProduto")) {
            ProdutoDTO newProduto = new ProdutoDTO();
            newProduto.setNome(request.getParameter("nome"));
            newProduto.setEstoque(Integer.parseInt(request.getParameter("estoque")));
            newProduto.setDescricao(request.getParameter("descricao"));
            newProduto.setFkIdCategoria(Integer.parseInt(request.getParameter("fkIdCategoria")));
            newProduto.setPreco(Float.parseFloat(request.getParameter("preco")));
            newProduto.setTamanho(request.getParameter("tamanho"));
            Part filePart = request.getPart("imagem");
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            if (fileName != null && !fileName.isEmpty()) {
                String basePath = getServletContext().getRealPath("/") + "assets";
                File uploads = new File(basePath);
                if (!uploads.exists()) {
                    uploads.mkdirs();
                }
                File file = new File(uploads, fileName);

                try (InputStream input = filePart.getInputStream()) {
                    Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                newProduto.setImagem("assets/" + fileName);
            } else {
                newProduto.setImagem(null);
            }
            ProdutoDAO produtosD = new ProdutoDAO();
            produtosD.create(newProduto);
            response.sendRedirect("./cadastrar-produto");
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
