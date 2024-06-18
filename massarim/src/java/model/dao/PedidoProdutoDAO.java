/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;


import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.bean.PedidoProdutoDTO;

/**
 *
 * @author Admin
 */
public class PedidoProdutoDAO {
    public void create (PedidoProdutoDTO p){
        try{
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            stmt = conexao.prepareStatement("INSERT INTO pedidoProduto (fkIdPedido, fkIdProduto, quantidade, precoUnidade) VALUES (?, ?, ?, ?)");
            stmt.setInt(1, p.getFkIdPedido());
            stmt.setInt(2, p.getFkIdProduto());
            stmt.setInt(3, p.getQuantidade());
            stmt.setFloat(4, p.getPrecoUnidade());
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }
}
