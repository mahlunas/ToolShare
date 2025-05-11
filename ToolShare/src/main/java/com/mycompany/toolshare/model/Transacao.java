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
    private Usuario usuario;
    private Ferramenta ferramenta;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private int diasAtraso;
    private Double multa;
    private StatusTransacao status;
    
    public Transacao(Usuario usuario, Ferramenta ferramenta, LocalDate dataInicio, int diasAluguel){
        this.usuario = usuario;
        this.ferramenta = ferramenta;
        this.dataInicio = dataInicio;
        this.dataFim = dataInicio.plusDays(diasAluguel);
        this.ferramenta.alterarStatus("alugada", ferramenta);
        this.status = StatusTransacao.ATIVO;
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
    
    public StatusTransacao getStatus() {
        return status;
    }

    public void setStatus(StatusTransacao status) {
        this.status = status;
    }
}
