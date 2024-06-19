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
import model.bean.CategoriaDTO;

/**
 *
 * @author Admin
 */
public class CategoriaDAO {
    public List<CategoriaDTO> read() {
        List<CategoriaDTO> categorias = new ArrayList();
        
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conexao.prepareStatement("SELECT * FROM categorias");
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                CategoriaDTO categoria = new CategoriaDTO();
                categoria.setIdCategorias(rs.getInt("idCategorias"));
                categoria.setNome(rs.getString("nome"));
                
                categorias.add(categoria);
            }
        } catch(SQLException e) {
            
        }
        
        return categorias;
    }
    public void create(CategoriaDTO c) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            
            stmt = conexao.prepareStatement("INSERT INTO categorias (nome) VALUES (?)");
            
            stmt.setString(1, c.getNome());
            
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void delete(int idCategorias) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("DELETE FROM categorias WHERE idCategorias = ?");
            stmt.setInt(1, idCategorias);
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
