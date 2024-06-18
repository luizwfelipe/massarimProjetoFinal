/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Senai
 */
public class ProdutoDTO {
    private int idProduto;
    private String nome;
    private int fkIdCategoria;
    private String descricao;
    private float preco;
    private int estoque;
    private String imagem;
    private String  imagemBase64;

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getFkIdCategoria() {
        return fkIdCategoria;
    }

    public void setFkIdCategoria(int fkIdCategoria) {
        this.fkIdCategoria = fkIdCategoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getImagemBase64() {
        return imagemBase64;
    }

    public void setImagemBase64(String imagemBase64) {
        this.imagemBase64 = imagemBase64;
    }

    public ProdutoDTO(int idProduto, String nome, int fkIdCategoria, String descricao, float preco, int estoque, String imagem, String imagemBase64) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.fkIdCategoria = fkIdCategoria;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
        this.imagem = imagem;
        this.imagemBase64 = imagemBase64;
    }

    public ProdutoDTO() {
    }

}
