/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.toolshare.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author lunas
 */
public class Transacao {
    public Usuario usuario;
    public Ferramenta ferramenta;
    public LocalDate dataInicio;
    public LocalDate dataFim;
    public int diasAtraso;
    public Double multa;
    
    public Transacao(Usuario usuario, Ferramenta ferramenta, LocalDate dataInicio){
        this.usuario = usuario;
        this.ferramenta = ferramenta;
        this.dataInicio = dataInicio;
        this.ferramenta.alterarStatus("alugada");
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Ferramenta getFerramenta() {
        return ferramenta;
    }

    public void setFerramenta(Ferramenta ferramenta) {
        this.ferramenta = ferramenta;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public int getDiasAtraso() {
        return diasAtraso;
    }

    public void setDiasAtraso(int diasAtraso) {
        this.diasAtraso = diasAtraso;
    }

    public Double getMulta() {
        return multa;
    }
    
    public int calculaDias(LocalDate data){
        int qtdDias =(int) ChronoUnit.DAYS.between(data, dataFim);
        System.out.println(qtdDias);
        return Math.abs(qtdDias);
    }
    
    private Double calcularMulta(){
        diasAtraso = calculaDias(dataInicio);
        Double valorMulta = diasAtraso * 1.0;
        System.out.println("valorMulta:" + valorMulta);
        return valorMulta;
    }
    
    public void devolverFerramenta(LocalDate dataEntrega){
        int diasAlugados = calculaDias(dataInicio);
        System.out.println("dias alugados:" + diasAlugados);
        Double valorAluguel = ferramenta.getPrecoPorDia() * diasAlugados;
        calculaDias(dataEntrega);
        Double valorTotal = valorAluguel + calcularMulta();
        System.out.println("Valor Total:" + valorTotal);
    }
}
