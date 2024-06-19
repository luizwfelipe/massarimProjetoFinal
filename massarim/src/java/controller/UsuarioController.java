/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.CategoriaDTO;
import model.bean.UsuarioDTO;
import model.dao.CategoriaDAO;
import model.dao.UsuarioDAO;

/**
 *
 * @author Admin
 */
@WebServlet(name = "UsuarioController", urlPatterns = {"/cadastrar", "/cadastro", "/login", "/logar", "/cadastro-de-administrador", "/cadastrarAdministrador", "/remover-usuario", "/excluir-usuario"})
public class UsuarioController extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = request.getServletPath();
        UsuarioDAO usuariosDAO = new UsuarioDAO();
        List<UsuarioDTO> usuarios = usuariosDAO.readUsuarios();
        request.setAttribute("usuarios", usuarios);
        if (url.equals("/cadastrar")){
            String nextPage = "/WEB-INF/jsp/cadastro.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        }else if (url.equals("/login")){
            String nextPage = "/WEB-INF/jsp/login.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        }else if (url.equals("/cadastro-de-administrador")){
            String nextPage = "/WEB-INF/jsp/cadastroAdm.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        }else if (url.equals("/remover-usuario")){
            String nextPage = "/WEB-INF/jsp/removerUsuario.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            request.setAttribute("usuarios", usuarios);
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
        if (url.equals("/excluir-usuario")) {
                int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                usuarioDAO.delete(idUsuario);
                response.sendRedirect("./remover-usuario");
        }else if (url.equals("/cadastrar")) {
            System.out.println("chegou dopost");
            UsuarioDTO user = new UsuarioDTO();
            user.setNome(request.getParameter("nome").equals("") ? "" : request.getParameter("nome"));
            user.setSenha(request.getParameter("senha"));
            user.setEmail(request.getParameter("email"));
            user.setCpf(request.getParameter("cpf"));
            user.setTelefone(request.getParameter("telefone"));
            user.setDataNascimento(Date.valueOf(request.getParameter("dataNascimento")));


            UsuarioDAO userCreate = new UsuarioDAO();
            userCreate.cadastrarUsuario(user);

            response.sendRedirect("./login");
        } else if (url.equals("/cadastrarAdministrador")) {
            UsuarioDTO user = new UsuarioDTO();
            user.setNome(request.getParameter("nome").equals("") ? "" : request.getParameter("nome"));
            user.setSenha(request.getParameter("senha"));
            user.setEmail(request.getParameter("email"));
            user.setCpf(request.getParameter("cpf"));
            user.setTelefone(request.getParameter("telefone"));
            user.setDataNascimento(Date.valueOf(request.getParameter("dataNascimento")));


            UsuarioDAO adminCreate = new UsuarioDAO();
            adminCreate.cadastrarAdministrador(user);

            response.sendRedirect("./login");
        }else if (url.equals("/logar")) {
            
            UsuarioDTO user = new UsuarioDTO();
            user.setEmail(request.getParameter("email"));
            user.setSenha(request.getParameter("senha"));

            UsuarioDAO userLogin = new UsuarioDAO();
            user = userLogin.login(user);
            if (user.getIdUsuario() > 0) {
                Cookie cookie = new Cookie("logar",Integer.toString(user.getIdUsuario()));
                response.addCookie(cookie);
                if (user.getAdmin() == 1) {
                     Cookie cookieAdministrativo = new Cookie("logarAdministrador", Integer.toString(user.getIdUsuario()));
                    response.addCookie(cookieAdministrativo);
                    response.sendRedirect("./painel-adm");
                } else {
                    response.sendRedirect("./home");
                }
            } else {
                
                //mudar para uma notificação!!!
                request.setAttribute("erroMensagem", "Erro ao realizar Login");
                String nextPage = "/WEB-INF/jsp/problemaLogin.jsp";
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
                dispatcher.forward(request, response);
            }
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
