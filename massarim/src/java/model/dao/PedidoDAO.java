/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.PedidoDTO;

/**
 *
 * @author Senai
 */
public class PedidoDAO {
    public List<PedidoDTO> readPedido() {
        List<PedidoDTO> listaPedido = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.conectar();
            stmt = conexao.prepareStatement("SELECT * FROM pedido");
            rs = stmt.executeQuery();
            while (rs.next()) {
                PedidoDTO pedidos = new PedidoDTO();
                pedidos.setIdPedido(rs.getInt("idProduto"));
                pedidos.setFkIdUsuario(rs.getInt("fkIdUsuario"));
                pedidos.setRua(rs.getString("rua"));
                pedidos.setNumero(rs.getInt("numero"));
                pedidos.setTipoPagamento(rs.getString("tipoPagamento"));
                listaPedido.add(pedidos);
            }
            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaPedido;
    }
     public void create(PedidoDTO p) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            
            stmt = conexao.prepareStatement("INSERT INTO pedido (fkIdUsuario, rua, numero, tipoPagamento) VALUES (?, ?, ?, ?)");
            
            stmt.setInt(1, p.getFkIdUsuario());
            stmt.setString(2, p.getRua());
            stmt.setInt(3, p.getNumero());
            stmt.setString(4, p.getTipoPagamento());
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
