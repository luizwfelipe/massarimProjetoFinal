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
import model.bean.EnderecoDTO;

/**
 *
 * @author Admin
 */
public class EnderecoDAO{
    public List<EnderecoDTO> readEndereco(){
        List<EnderecoDTO> listaEndereco = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.conectar();
            stmt = conexao.prepareStatement("SELECT * FROM endereco");
            rs = stmt.executeQuery();
            while (rs.next()) {
                EnderecoDTO endereco = new EnderecoDTO();
                endereco.setIdEndereco(rs.getInt("idEndereco"));
                endereco.setCep(rs.getString("cep"));
                endereco.setRua(rs.getString("rua"));
                endereco.setNumero(rs.getInt("numero"));
                endereco.setComplemento(rs.getString("complemento"));
                endereco.setReferencia(rs.getString("referencia"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(rs.getString("estado"));
                listaEndereco.add(endereco);
            }
            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaEndereco;
    }
    

    public void create(EnderecoDTO endereco){
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("INSERT INTO endereco (cep, rua, numero, complemento, referencia, bairro, cidade, estado, fkIdUsuario) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

            stmt.setString(1, endereco.getCep());
            stmt.setString(2, endereco.getRua());
            stmt.setInt(3, endereco.getNumero());
            stmt.setString(4, endereco.getComplemento());
            stmt.setString(5, endereco.getReferencia());
            stmt.setString(6, endereco.getBairro());
            stmt.setString(7, endereco.getCidade());
            stmt.setString(8, endereco.getEstado());
            stmt.setInt(9, endereco.getFkIdUsuario());

            stmt.executeUpdate();
            stmt.close();
            conexao.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public List<EnderecoDTO> readEnderecoUnico(int idDoUsuario){
        List<EnderecoDTO> listaEndereco = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.conectar();
            stmt = conexao.prepareStatement("SELECT * FROM endereco WHERE fkIdUsuario = ?");
            stmt.setInt(1, idDoUsuario);
            rs = stmt.executeQuery();
            while (rs.next()) {
                EnderecoDTO endereco = new EnderecoDTO();
                endereco.setIdEndereco(rs.getInt("idEndereco"));
                endereco.setFkIdUsuario(rs.getInt("fkIdUsuario"));
                endereco.setCep(rs.getString("cep"));
                endereco.setRua(rs.getString("rua"));
                endereco.setNumero(rs.getInt("numero"));
                endereco.setComplemento(rs.getString("complemento"));
                endereco.setReferencia(rs.getString("referencia"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(rs.getString("estado"));
                listaEndereco.add(endereco);
            }
            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaEndereco;
    }
}