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
import javax.swing.JOptionPane;
import model.bean.UsuarioDTO;

/**
 *
 * @author Senai
 */
public class UsuarioDAO {
      public List<UsuarioDTO> readUsuarios() {
        List<UsuarioDTO> listaUsuarios = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.conectar();
            stmt = conexao.prepareStatement("SELECT * FROM usuario");
            rs = stmt.executeQuery();
            while (rs.next()) {
                UsuarioDTO usuarios = new UsuarioDTO();
                usuarios.setIdUsuario(rs.getInt("idUsuario"));
                usuarios.setNome(rs.getString("nome"));
                usuarios.setSenha(rs.getString("senha"));
                usuarios.setEmail(rs.getString("email"));
                usuarios.setCpf(rs.getString("cpf"));
                usuarios.setTelefone(rs.getString("telefone"));
                usuarios.setDataNascimento(rs.getDate("dataNascimento"));
                usuarios.setAdmin(rs.getInt("admin"));
                listaUsuarios.add(usuarios);
            }
            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaUsuarios;
    }
    
    public void cadastrarUsuario(UsuarioDTO user){
        try{
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            
            stmt = conexao.prepareStatement("INSERT INTO usuario (nome, senha, email, cpf, telefone, dataNascimento, admin) VALUES (?, ?, ?, ?, ?, ?, 2)");
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getSenha());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getCpf());
            stmt.setString(5, user.getTelefone());
            stmt.setDate(6, user.getDataNascimento());
            
            
            stmt.executeUpdate();
            
            stmt.close();
            conexao.close();
            
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void cadastrarAdministrador(UsuarioDTO user){
        try{
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            
            stmt = conexao.prepareStatement("INSERT INTO usuario (nome, senha, email, cpf, telefone, dataNascimento, admin) VALUES (?, ?, ?, ?, ?, ?, 1)");
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getSenha());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getCpf());
            stmt.setString(5, user.getTelefone());
            stmt.setDate(6, user.getDataNascimento());
            
            
            stmt.executeUpdate();
            
            stmt.close();
            conexao.close();
            
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
   public UsuarioDTO login(UsuarioDTO user) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conexao.prepareStatement("SELECT idUsuario, admin FROM usuario WHERE email = ? AND senha = ?");
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getSenha());
            
            rs = stmt.executeQuery();
            if(rs.next()){
                user.setIdUsuario(rs.getInt("idUsuario"));
                user.setAdmin(rs.getInt("admin"));
            }
            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return user;
    }

    
    public void update(UsuarioDTO u) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("UPDATE usuario SET nome = ?, login = ?, senha = ?, telefone = ? WHERE idUsuario = ? ");

            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getSenha());
            stmt.setString(3, u.getEmail());
            stmt.setString(4, u.getCpf());
            stmt.setString(5, u.getTelefone());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "informações atualizadas com sucesso!");

            stmt.close();
            conexao.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void delete(int idUsuario) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("DELETE FROM usuario WHERE idUsuario = ?");
            stmt.setInt(1, idUsuario);
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public boolean existe(String email) throws SQLException {
    Connection conexao = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    boolean existe = false;
   
    try {
        conexao = Conexao.conectar();
        stmt = conexao.prepareStatement("SELECT * FROM usuario WHERE email = ?");
        stmt.setString(1, email);
        rs = stmt.executeQuery();
        if (rs.next()) {
            int count = rs.getInt(1);
            existe = true;
        }
        rs.close();
        stmt.close();
        conexao.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
   
    return existe;
}
}

