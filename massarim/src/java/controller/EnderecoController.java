/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.bean.EnderecoDTO;
import model.dao.EnderecoDAO;

/**
 *
 * @author Admin
 */
@WebServlet(name = "EnderecoController", urlPatterns = {"/endereco", "/cadastrarEndereco", "/meusEnderecos", "/escolherEndereco"})
public class EnderecoController extends HttpServlet {
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
        String url = request.getServletPath();
        if (url.equals("/endereco") || url.equals("/meusEnderecos")){
            int idDoUsuario = 0;
            Cookie[] cookies = request.getCookies();
            if (cookies != null){
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("logar")){
                        idDoUsuario = Integer.parseInt(cookie.getValue());
                        break;
                    }
                }
            }
            EnderecoDAO dao = new EnderecoDAO();
            List<EnderecoDTO> enderecos = dao.readEnderecoUnico(idDoUsuario);
            request.setAttribute("enderecos", enderecos);

            String nextPage = url.equals("/endereco")?"/WEB-INF/jsp/endereco.jsp":"/WEB-INF/jsp/meusEnderecos.jsp";
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
        if (url.equals("/cadastrarEndereco")) {
            EnderecoDTO novoEndereco = new EnderecoDTO();
            novoEndereco.setCep(request.getParameter("cep"));
            novoEndereco.setRua(request.getParameter("rua"));
            novoEndereco.setNumero(Integer.parseInt(request.getParameter("numero")));
            novoEndereco.setComplemento(request.getParameter("complemento"));
            novoEndereco.setReferencia(request.getParameter("referencia"));
            novoEndereco.setBairro(request.getParameter("bairro"));
            novoEndereco.setCidade(request.getParameter("cidade"));
            novoEndereco.setEstado(request.getParameter("estado"));
            int idDoUsuario = 0;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("logar")) {
                        idDoUsuario = Integer.parseInt(cookie.getValue());
                        break;
                    }
                }
            }
            novoEndereco.setFkIdUsuario(idDoUsuario);

            EnderecoDAO dao = new EnderecoDAO();
            dao.create(novoEndereco);
            response.sendRedirect("./endereco");
        }else if (url.equals("/escolherEndereco")) {
            EnderecoDTO enderecoSelecionado = new EnderecoDTO();
            enderecoSelecionado.setRua(request.getParameter("rua"));
            enderecoSelecionado.setNumero(Integer.parseInt(request.getParameter("numero")));
            HttpSession session = request.getSession();
            session.setAttribute("enderecoSelecionado", enderecoSelecionado);
            response.sendRedirect("./pagamento");
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
