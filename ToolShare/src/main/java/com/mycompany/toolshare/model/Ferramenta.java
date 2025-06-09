/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.toolshare.model;

import java.util.ArrayList;

/**
 *
 * @author lunas
 */
public class Ferramenta {
    private String nome;
    private String descricao;
    private Double precoPorDia;
    private String categoria;
    private StatusFerramenta status;
    private Usuario proprietario;
    
    public Ferramenta(){}
    
    public Ferramenta (String nome, String descricao, Double precoPorDia, String categoria, Usuario proprietario) {
        this.nome = nome;
        this.descricao = descricao;
        this.precoPorDia = precoPorDia;
        this.categoria = categoria;
        this.status = StatusFerramenta.DISPONIVEL;
        this.proprietario = proprietario;
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
    
    public Usuario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Usuario proprietario) {
        this.proprietario = proprietario;
    }
    
    public void alterarStatus(String novoStatus, Ferramenta f){
        try{
            f.status = StatusFerramenta.valueOf(novoStatus.toUpperCase());
            System.out.println("Status alterado com sucesso. Novo status:" + novoStatus);
        } catch (IllegalArgumentException e){
            System.out.println("Status inválido:" + novoStatus);
        }
    }
    
    @Override
    public String toString(){
        return "- Nome:" + nome + 
               " | Descricao:" + descricao + 
               " | Categoria:" + categoria + 
               " | Status:" + status;
    }
}
