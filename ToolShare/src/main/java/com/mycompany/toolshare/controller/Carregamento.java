/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.toolshare.controller;

import com.mycompany.toolshare.model.Ferramenta;
import com.mycompany.toolshare.model.Transacao;
import com.mycompany.toolshare.model.Usuario;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author lunas
 */
public class Carregamento {
    public static void Carregar(ArrayList<Transacao> transacoes, ArrayList<Usuario> usuarios, ArrayList<Ferramenta> ferramentas, Plataforma plataforma){
        carregarUsuario(usuarios);
        carregarFerramenta(ferramentas, usuarios, plataforma);
        carregarTransacao(transacoes, usuarios, ferramentas, plataforma);
    }
    
    public static void carregarUsuario(ArrayList<Usuario> usuarios){
        usuarios.add(new Usuario("Marcelle", "1899999999", "00000000001"));
        usuarios.add(new Usuario("João", "1198888888", "00000000002"));
        usuarios.add(new Usuario("Ana", "2197777777", "00000000003"));
        usuarios.add(new Usuario("Carlos", "3196666666", "00000000004"));
        usuarios.add(new Usuario("Beatriz", "4195555555", "00000000005"));
    }
    
    public static void carregarFerramenta(ArrayList<Ferramenta> ferramentas, ArrayList<Usuario> usuarios, Plataforma plataforma){
        Ferramenta ferramenta;
        Usuario usuario;
        
        usuario = plataforma.buscaUsuario("00000000001", usuarios);
        ferramenta = new Ferramenta("Martelo", "Martelo", 18.0, "manual", usuario);
        usuario.adicionarFerramenta(ferramenta);
        ferramentas.add(ferramenta);
        
        usuario = plataforma.buscaUsuario("00000000002", usuarios);
        ferramenta = new Ferramenta("Furadeira", "Furadeira elétrica", 25.0, "eletrica", usuario);
        usuario.adicionarFerramenta(ferramenta);
        ferramentas.add(ferramenta);

        usuario = plataforma.buscaUsuario("00000000003", usuarios);
        ferramenta = new Ferramenta("Chave de Fenda", "Chave de fenda média", 10.0, "manual", usuario);
        usuario.adicionarFerramenta(ferramenta);
        ferramentas.add(ferramenta);

        usuario = plataforma.buscaUsuario("00000000004", usuarios);
        ferramenta = new Ferramenta("Serra Circular", "Serra circular portátil", 40.0, "eletrica", usuario);
        usuario.adicionarFerramenta(ferramenta);
        ferramentas.add(ferramenta);

        usuario = plataforma.buscaUsuario("00000000005", usuarios);
        ferramenta = new Ferramenta("Alicate", "Alicate universal", 12.0, "manual", usuario);
        usuario.adicionarFerramenta(ferramenta);
        ferramentas.add(ferramenta);
        
        usuario = plataforma.buscaUsuario("00000000002", usuarios);
        ferramenta = new Ferramenta("Furadeira de Impacto", "Furadeira de impacto 500W", 25.0, "eletrica", usuario);
        usuario.adicionarFerramenta(ferramenta);
        ferramentas.add(ferramenta);

        usuario = plataforma.buscaUsuario("00000000003", usuarios);
        ferramenta = new Ferramenta("Lixadeira", "Lixadeira orbital com velocidade ajustável", 30.0, "eletrica", usuario);
        usuario.adicionarFerramenta(ferramenta);
        ferramentas.add(ferramenta);

        usuario = plataforma.buscaUsuario("00000000004", usuarios);
        ferramenta = new Ferramenta("Chave inglesa", "Chave inglesa grande", 15.0, "manual", usuario);
        usuario.adicionarFerramenta(ferramenta);
        ferramentas.add(ferramenta);

        usuario = plataforma.buscaUsuario("00000000001", usuarios);
        ferramenta = new Ferramenta("Serra Tico-Tico", "Serra Tico-Tico elétrica 220V", 40.0, "eletrica", usuario);
        usuario.adicionarFerramenta(ferramenta);
        ferramentas.add(ferramenta);

        usuario = plataforma.buscaUsuario("00000000005", usuarios);
        ferramenta = new Ferramenta("Martelo", "Martelo cabeça dupla", 10.0, "manual", usuario);
        usuario.adicionarFerramenta(ferramenta);
        ferramentas.add(ferramenta);


    }
    
    public static void carregarTransacao(ArrayList<Transacao> transacoes, ArrayList<Usuario> usuarios, ArrayList<Ferramenta> ferramentas, Plataforma plataforma){
        Usuario usuario;
        Ferramenta ferramenta;
        Transacao transacao;

        usuario = plataforma.buscaUsuario("00000000001", usuarios);
        ferramenta = plataforma.buscaFerramenta("Martelo", ferramentas);
        transacao = new Transacao(usuario, ferramenta, LocalDate.of(2025, 5, 1), 5);
        transacoes.add(transacao);

        usuario = plataforma.buscaUsuario("00000000002", usuarios);
        ferramenta = plataforma.buscaFerramenta("Chave de Fenda", ferramentas);
        transacao = new Transacao(usuario, ferramenta, LocalDate.of(2025, 5, 2), 10);
        transacoes.add(transacao);

        usuario = plataforma.buscaUsuario("00000000003", usuarios);
        ferramenta = plataforma.buscaFerramenta("Alicate", ferramentas);
        transacao = new Transacao(usuario, ferramenta, LocalDate.of(2025, 5, 3), 3);
        transacoes.add(transacao);

        usuario = plataforma.buscaUsuario("00000000004", usuarios);
        ferramenta = plataforma.buscaFerramenta("Serra Circular", ferramentas);
        transacao = new Transacao(usuario, ferramenta, LocalDate.of(2025, 5, 4), 4);
        transacoes.add(transacao);

        usuario = plataforma.buscaUsuario("00000000005", usuarios);
        ferramenta = plataforma.buscaFerramenta("Furadeira", ferramentas);
        transacao = new Transacao(usuario, ferramenta, LocalDate.of(2025, 5, 5), 6);
        transacoes.add(transacao);
        
        usuario = plataforma.buscaUsuario("00000000002", usuarios);
        ferramenta = plataforma.buscaFerramenta("Lixadeira", ferramentas);
        transacao = new Transacao(usuario, ferramenta, LocalDate.of(2025, 5, 6), 8);
        transacoes.add(transacao);
    }
}
