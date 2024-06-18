/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Admin
 */
public class PedidoProdutoDTO {
    private int idPedidoProduto;
    private int fkIdPedido;
    private int fkIdProduto;
    private int quantidade;
    private float precoUnidade;

    public PedidoProdutoDTO() {
    }

    public PedidoProdutoDTO(int idPedidoProduto, int fkIdPedido, int fkIdProduto, int quantidade, float precoUnidade) {
        this.idPedidoProduto = idPedidoProduto;
        this.fkIdPedido = fkIdPedido;
        this.fkIdProduto = fkIdProduto;
        this.quantidade = quantidade;
        this.precoUnidade = precoUnidade;
    }

    public int getIdPedidoProduto() {
        return idPedidoProduto;
    }

    public void setIdPedidoProduto(int idPedidoProduto) {
        this.idPedidoProduto = idPedidoProduto;
    }

    public int getFkIdPedido() {
        return fkIdPedido;
    }

    public void setFkIdPedido(int fkIdPedido) {
        this.fkIdPedido = fkIdPedido;
    }

    public int getFkIdProduto() {
        return fkIdProduto;
    }

    public void setFkIdProduto(int fkIdProduto) {
        this.fkIdProduto = fkIdProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPrecoUnidade() {
        return precoUnidade;
    }

    public void setPrecoUnidade(float precoUnidade) {
        this.precoUnidade = precoUnidade;
    }

    public int quantidade() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
