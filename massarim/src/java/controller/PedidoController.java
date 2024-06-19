/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.PedidoDTO;
import model.bean.UsuarioDTO;
import model.dao.PedidoDAO;
import model.dao.UsuarioDAO;

/**
 *
 * @author Admin
 */
@WebServlet(name = "PedidoController", urlPatterns = {"/pedido", "/pedidoConfirmado","/confirmarPedido","/historico-pedidos","/todos-pedidos","/atualizarPedido"})
public class PedidoController extends HttpServlet {

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
        String url = request.getServletPath();
        if (url.equals("/pedidoConfirmado")){
            String nextPage = "/WEB-INF/jsp/pedidoConfirmado.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        }else if(url.equals("/historico-pedidos")) {
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
            PedidoDAO pedidoDAO = new PedidoDAO();
            List<PedidoDTO> pedidos = pedidoDAO.readPedidoUnico(idDoUsuario);
            request.setAttribute("pedidos", pedidos);
            String nextPage = "/WEB-INF/jsp/historicoPedido.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        }else if(url.equals("/todos-pedidos")){
            PedidoDAO pedidoDAO = new PedidoDAO();
            List<PedidoDTO> pedidos = pedidoDAO.readPedido();
            request.setAttribute("pedidos", pedidos);
            String nextPage = "/WEB-INF/jsp/todosPedidos.jsp";
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
        if (url.equals("/confirmarPedido")) {
            System.out.println("chegou dopost");
            PedidoDTO pedido = new PedidoDTO();
            pedido.setRua(request.getParameter("endereco-rua"));
            pedido.setNumero(Integer.parseInt(request.getParameter("endereco-numero")));
            pedido.setTipoPagamento(request.getParameter("tipo-pagamento"));
            pedido.setStatusPedido(request.getParameter("statusPedido"));
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
            pedido.setFkIdUsuario(idDoUsuario);


            PedidoDAO createDAO = new PedidoDAO();
            createDAO.create(pedido);

            response.sendRedirect("./pedidoConfirmado");
        }else if (url.equals("/atualizarPedido")) {
            int idPedido = Integer.parseInt(request.getParameter("idPedido"));
            String statusPedido = request.getParameter("statusPedido");
            PedidoDAO pedidoDAO = new PedidoDAO();
            pedidoDAO.atualizarStatus(idPedido, statusPedido);
            response.sendRedirect("./excluir-produto");
        }else{
                String nextPage = "/WEB-INF/jsp/checkout.jsp";
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
                dispatcher.forward(request, response);
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
