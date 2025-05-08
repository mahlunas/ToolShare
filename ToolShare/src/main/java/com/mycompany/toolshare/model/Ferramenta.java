/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.toolshare.model;

/**
 *
 * @author lunas
 */
public class Ferramenta {
    public String nome;
    public String descricao;
    public Double precoPorDia;
    public String categoria;
    private StatusFerramenta status;
    
    public Ferramenta (String nome, String descricao, Double precoPorDia, String categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.precoPorDia = precoPorDia;
        this.categoria = categoria;
        this.status = StatusFerramenta.DISPONIVEL;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPrecoPorDia() {
        return precoPorDia;
    }

    public void setPrecoPorDia(Double precoPorDia) {
        this.precoPorDia = precoPorDia;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public StatusFerramenta getStatus(){
        return status;
    }
    
    public void alterarStatus(String novoStatus){
        try{
            this.status = StatusFerramenta.valueOf(novoStatus.toUpperCase());
        } catch (IllegalArgumentException e){
            System.out.println("Status inválido:" + novoStatus);
        }
    }
}
