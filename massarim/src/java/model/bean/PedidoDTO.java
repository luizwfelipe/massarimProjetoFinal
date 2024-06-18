/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.sql.Date;

/**
 *
 * @author Senai
 */
public class PedidoDTO {
    private int idPedido;
    private int fkIdUsuario;
    private int fkIdEndereco;
    private float precoTotal;
    private Date dataPedido;
    private String tipoPagamento;

    public PedidoDTO() {
    }

    public PedidoDTO(int idPedido, int fkIdUsuario, int fkIdEndereco, float precoTotal, Date dataPedido, String tipoPagamento) {
        this.idPedido = idPedido;
        this.fkIdUsuario = fkIdUsuario;
        this.fkIdEndereco = fkIdEndereco;
        this.precoTotal = precoTotal;
        this.dataPedido = dataPedido;
        this.tipoPagamento = tipoPagamento;
    }

    public int getIdPedido(){
        return idPedido;
    }

    public void setIdPedido(int idPedido){
        this.idPedido = idPedido;
    }

    public int getFkIdUsuario() {
        return fkIdUsuario;
    }

    public void setFkIdUsuario(int fkIdUsuario){
        this.fkIdUsuario = fkIdUsuario;
    }

    public int getFkIdEndereco() {
        return fkIdEndereco;
    }

    public void setFkIdEndereco(int fkIdEndereco){
        this.fkIdEndereco = fkIdEndereco;
    }

    public float getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(float precoTotal){
        this.precoTotal = precoTotal;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido){
        this.dataPedido = dataPedido;
    }

    public String getTipoPagamento(){
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento){
        this.tipoPagamento = tipoPagamento;
    }
    
    
}
