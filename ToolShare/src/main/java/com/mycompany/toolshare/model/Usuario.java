/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.toolshare.model;

import java.time.LocalDate;

/**
 *
 * @author lunas
 */
public class Usuario {
    private String nome;
    private String contato;
    private String cpf;
    public LocalDate dataNascimento;
    private Ferramenta[] ferramentas = new Ferramenta[5];
    private int contador = 0;
    
    public Usuario (String nome, String contato, String cpf, LocalDate nascimento){
        this.nome = nome;
        this.contato = contato;
        this.cpf = cpf;
        this.dataNascimento = nascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public int getContador(){
        return contador;
    }

    public Ferramenta getFerramentas(int index) {
        if(index >= 0 && index < ferramentas.length){
            return ferramentas[index];
        }
        return null;
    }

    public void setFerramentas(Ferramenta ferramenta, int index) {
        if(index >= 0 && index < ferramentas.length){
            ferramentas[index] = ferramenta;
        } else {
            System.out.println("Indice invalido");
        }
    }
    
    public boolean adicionarFerramenta(Ferramenta ferramenta){
        if(contador < ferramentas.length){
            ferramentas[contador] = ferramenta;
            contador ++;
            return true;
        } else {
            System.out.println("Limite de ferramentas atingido");
            return false;
        }
    }
    
    public boolean maiorDeIdade() {
        return getDataNascimento().plusYears(18).isBefore(LocalDate.now());
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    @Override
    public String toString(){
        return "- Nome:" + nome + 
               " | CPF:" + cpf + 
               " | Contato:" + contato + 
               " | Data de Nascimento:" + dataNascimento;
    }
}
