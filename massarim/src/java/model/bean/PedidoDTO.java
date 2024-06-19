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
public class PedidoDTO {
    private int idPedido;
    private String rua;
    private int numero;
    private String tipoPagamento;
    private int fkIdUsuario;

    public PedidoDTO() {
    }

    public PedidoDTO(int idPedido, String rua, int numero, String tipoPagamento, int fkIdUsuario) {
        this.idPedido = idPedido;
        this.rua = rua;
        this.numero = numero;
        this.tipoPagamento = tipoPagamento;
        this.fkIdUsuario = fkIdUsuario;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public int getFkIdUsuario() {
        return fkIdUsuario;
    }

    public void setFkIdUsuario(int fkIdUsuario) {
        this.fkIdUsuario = fkIdUsuario;
    }

}