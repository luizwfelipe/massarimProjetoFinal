package model.dao;

import conexao.Conexao;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.ProdutoDTO;

public class ProdutoDAO {
    public List<ProdutoDTO> readProdutos() {
        List<ProdutoDTO> listaProduto = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.conectar();
            stmt = conexao.prepareStatement("SELECT * FROM produto");
            rs = stmt.executeQuery();
            while (rs.next()) {
                ProdutoDTO produtos = new ProdutoDTO();
                produtos.setIdProduto(rs.getInt("idProduto"));
                produtos.setNome(rs.getString("nome"));
                produtos.setFkIdCategoria(rs.getInt("fkIdCategoria"));
                produtos.setDescricao(rs.getString("descricao"));
                produtos.setPreco(rs.getFloat("preco"));
                produtos.setEstoque(rs.getInt("estoque"));
                produtos.setImagem(rs.getString("imagem"));
                listaProduto.add(produtos);
            }
            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaProduto;
    }
    
    public void create(ProdutoDTO p) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            
            stmt = conexao.prepareStatement("INSERT INTO produto (nome, fkIdCategoria, preco, descricao, estoque, imagem) VALUES (?, ?, ?, ?, ?, ?)");
            
            stmt.setString(1, p.getNome());
            stmt.setInt(2, p.getFkIdCategoria());
            stmt.setFloat(3, p.getPreco());
            stmt.setString(4, p.getDescricao());
            stmt.setInt(5, p.getEstoque());
            stmt.setString(6, p.getImagem());
            
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public ProdutoDTO focarProduto(int focado){
        ProdutoDTO prod = new ProdutoDTO();
        
        try{
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conexao.prepareStatement("SELECT * FROM produto WHERE idProduto = ?");
            stmt.setInt(1, focado);
            
            rs = stmt.executeQuery();
            
            if(rs.next()) {
                prod.setIdProduto(rs.getInt("idProduto"));
                prod.setNome(rs.getString("nome"));
                prod.setFkIdCategoria(rs.getInt("fkIdCategoria"));
                prod.setDescricao(rs.getString("descricao"));
                prod.setPreco(rs.getFloat("preco"));
                prod.setEstoque(rs.getInt("estoque"));
                prod.setImagem(rs.getString("imagem"));

        
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return prod;
    }
    
    public List<ProdutoDTO> buscaProdutos(String busca){
        List<ProdutoDTO> resultadoBusca = new ArrayList();

        try{
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conexao.prepareStatement("SELECT * FROM produto WHERE nome LIKE ? OR descricao LIKE ?");
            stmt.setString(1, busca);
            stmt.setString(2, busca);
            
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                ProdutoDTO prod = new ProdutoDTO();
                prod.setIdProduto(rs.getInt("idProduto"));
                prod.setNome(rs.getString("nome"));
                prod.setFkIdCategoria(rs.getInt("fkIdCategoria"));
                prod.setDescricao(rs.getString("descricao"));
                prod.setPreco(rs.getFloat("preco"));
                prod.setEstoque(rs.getInt("estoque"));
                prod.setImagem(rs.getString("imagem"));
                
                resultadoBusca.add(prod);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return resultadoBusca;
    }
    
    public List<ProdutoDTO> buscaCategoria (int categoria) {
        List<ProdutoDTO> resultadoBusca = new ArrayList();

        try{
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conexao.prepareStatement("SELECT * FROM produto WHERE fkIdCategoria = ?");
            stmt.setInt(1, categoria);
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                ProdutoDTO prod = new ProdutoDTO();
                prod.setIdProduto(rs.getInt("idProduto"));
                prod.setNome(rs.getString("nome"));
                prod.setFkIdCategoria(rs.getInt("fkIdCategoria"));
                prod.setDescricao(rs.getString("descricao"));
                prod.setPreco(rs.getFloat("preco"));
                prod.setEstoque(rs.getInt("estoque"));
                prod.setImagem(rs.getString("imagem"));
                
                resultadoBusca.add(prod);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return resultadoBusca;
    }
    
    public ProdutoDTO buscarProduto(int idP){
        ProdutoDTO produto = new ProdutoDTO();
        
        try{
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conexao.prepareStatement("SELECT * FROM produto WHERE  idProduto = ?");
            stmt.setInt(1, idP);
            
            rs = stmt.executeQuery();
            
            if(rs.next()) {
                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setNome(rs.getString("nome"));
                produto.setFkIdCategoria(rs.getInt("fkIdCategoria"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getFloat("preco"));
                produto.setImagem(rs.getString("imagem"));
            } else {
                produto.setIdProduto(0);
            }
        }catch(SQLException e ) {
            e.printStackTrace();
        }
        
        return produto;
    }
     public void delete(int idProduto) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("DELETE FROM produto WHERE idProduto = ?");
            stmt.setInt(1, idProduto);
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
  
}



