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
public class CategoriaDTO {
    private int idCategorias;
    private String nome;

    public CategoriaDTO() {
    }

    public CategoriaDTO(int idCategorias, String nome) {
        this.idCategorias = idCategorias;
        this.nome = nome;
    }

    public int getIdCategorias() {
        return idCategorias;
    }

    public void setIdCategorias(int idCategorias) {
        this.idCategorias = idCategorias;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
