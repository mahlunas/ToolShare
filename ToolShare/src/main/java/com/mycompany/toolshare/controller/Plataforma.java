/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.toolshare.controller;

import com.mycompany.toolshare.model.Ferramenta;
import com.mycompany.toolshare.model.Transacao;
import com.mycompany.toolshare.model.Usuario;
import com.mycompany.toolshare.model.StatusFerramenta;
import com.mycompany.toolshare.model.StatusTransacao;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author lunas
 */
public class Plataforma {
    private static List<Ferramenta> ferramentas = new ArrayList<>();
    private static List<Transacao> transacoes = new ArrayList<>();
    
    //Controles de Usuarios
    public Usuario cadastrarUsuario(ArrayList<Usuario> usuarios, Scanner scanner){
        System.out.println("Cadastro de Usuario");
            
        String cpf;
        
        System.out.println("CPF:");
        cpf = scanner.nextLine();
        boolean unico = verificaDuplicidadeCpf(cpf, usuarios);
        if(unico == true){
            System.out.println("Nome:");
            String nome = scanner.nextLine();
        
            System.out.println("Contato:");
            String contato = scanner.nextLine();
            Usuario user = new Usuario(nome, contato, cpf);
            return user;
        }else {
            return null;
        }       
    }
    
    public void listarUsuario(ArrayList<Usuario> usuarios){
        if(usuarios.isEmpty()){
            System.out.println("Nenhum usuario cadastrado");
        } else{
            for(Usuario u : usuarios){
                imprimeUsuario(u);
            }
        }
    }
    
    public boolean verificaDuplicidadeCpf(String cpf, ArrayList<Usuario> usuarios){
        Usuario busca = buscaUsuario(cpf, usuarios);
        if(busca != null){
            System.out.println("CPF ja cadastrado.");
            return false;
        }
        return true;
    }
    
    private Usuario buscaUsuario(String cpf, ArrayList<Usuario> usuarios){
        for(Usuario u: usuarios){
            if(cpf.equals(u.getCpf())){
                return u;
            }
        }
        return null;
    }
    
    public void consultaUsuario(ArrayList<Usuario> usuarios, Scanner scanner){
        System.out.println("Insira o numero do CPF:");
        String cpf = scanner.nextLine();
        
        Usuario busca = buscaUsuario(cpf, usuarios);
        if(busca == null){
            System.out.println("Usuario nao cadastrado");
        } else {
            imprimeUsuario(busca);
        }
    }
    
    private void imprimeUsuario(Usuario user){
        System.out.println("- Nome:" + user.getNome() + " | CPF:" + user.getNome() + " | Contato:" + user.getContato());
    }
    
    public void editarCadastro(ArrayList<Usuario> usuarios, Scanner scanner){
        System.out.println("Insira o CPF:");
        String cpf = scanner.nextLine();
        
        Usuario user = buscaUsuario(cpf, usuarios);
        if(user != null){
            System.out.println("Esolha o campo que deseja alterar:");
            System.out.println("1 - Nome   |   2 - Contato1");
            int op = scanner.nextInt();
            
            System.out.println("Insira o novo valor");
            String novoValor = scanner.nextLine();
            if(op == 1){
                user.setNome(novoValor);
            }else if(op == 2){
                user.setContato(novoValor);
            } else {
                System.out.println("O campo selecionado nao existe");
            }
        } else {
            System.out.println("Usuario nao encontrado!");
        } 
    }
    
    public Usuario excluirUsuario(ArrayList<Usuario>usuarios, Scanner scanner){
        System.out.println("Digite o CPF que deseja excluir");
        String cpf = scanner.nextLine();
        
        Usuario user = buscaUsuario(cpf, usuarios);
        
        return user;
    }
    
    //Controle de Ferramentas
    public void cadastrarFerramenta(Ferramenta ferramenta){
        boolean qtdFProprietario = ferramenta.proprietario.adicionarFerramentas(ferramenta);
        if(qtdFProprietario){
            ferramentas.add(ferramenta);
        }
        
    }
    
    private Ferramenta buscaFerramenta(String nomeFerramenta){
        for(Ferramenta f : ferramentas){
            if(nomeFerramenta.equals(f.getNome())){
                return f;
            }
        }
        return null;
    }
    
    private void imprimeFerramenta(Ferramenta f){
        System.out.println("- Nome:" + f.getNome() + " | Descricao:" + f.getDescricao() + " | Categoria:" + f.getCategoria() + " | Status:" + f.getStatus());
    }
    
    public void listaFerramentas(ArrayList<Ferramenta> ferramentas){
        for(Ferramenta f : ferramentas){
            if(f.getStatus() == StatusFerramenta.DISPONIVEL){
                imprimeFerramenta(f);
            }
        }
    }
    
    public void consultaFerramenta(String nome){
        Ferramenta f = buscaFerramenta(nome);
        if(f == null){
            System.out.println("Ferramenta não encontrada");
        } else {
            imprimeFerramenta(f);
        }
    }
    
    public void alteraStatus(String ferramenta, Usuario user, String status){
        Ferramenta f = buscaFerramenta(ferramenta);
        //verifica se a ferramenta esta cadastrada
        if(f == null){
            System.out.println("Ferramenta não encontrada");
        } else {
            //verifica se é o proprietario
            if(f.getProprietario().getCpf().equals(user.getCpf())){
                f.alterarStatus(status);
            } else {
                System.out.println("Acesso negado. Usuario não é o proprietario da ferramenta");
            }
        }
    }
    
    public void alterarPreco(Double novoValor, Ferramenta f){
        Double valorMin = f.verificaCategoria(f.getCategoria());
        if(novoValor < valorMin){
            System.out.println("Valor abaixo do valor minimo! (" + valorMin + ")");
        } else{
            System.out.println("Preco alterado com sucesso!");
            f.setPrecoPorDia(novoValor);
        }
    }
    
    //Controle de Transacoes
    
    public void cadastrarTransacao(Transacao novaTransacao){
        
    }
    
    public void devolverFerramenta(Transacao transacao){
        int diasAlugados = calculaDias(transacao.getDataInicio(),transacao);
        transacao.setDataFim(LocalDate.now());
        System.out.println("dias alugados:" + diasAlugados);
        Double valorAluguel = transacao.getFerramenta().getPrecoPorDia() * diasAlugados;
        calculaDias(transacao.getDataFim(), transacao);
        Double valorTotal = valorAluguel + calcularMulta(transacao);
        System.out.println("Valor Total:" + valorTotal);
    }
    
    public void consultaAluguelAtivo(){
        for(Transacao t : transacoes){
            if(t.getStatus() == StatusTransacao.ATIVO){
                imprimeTransacao(t);
            }
        }
    }
    
    public void listarHistorico(){
        for(Transacao t : transacoes){
            imprimeTransacao(t);
        }
    }
    
    private void imprimeTransacao(Transacao t){
        System.out.println("- Locador:" + t.getUsuario().getNome() + " | Locatorio:" + t.getFerramenta().getProprietario().getNome());
        System.out.println("  Ferramenta:" + t.getFerramenta().getNome() + " | Categoria:" + t.getFerramenta().getCategoria() + " | Preco por dia:" + t.getFerramenta().getPrecoPorDia());
        System.out.println("  Descricao:" + t.getFerramenta().getDescricao());
        System.out.println("  Data aluguel:" + t.getDataInicio() + " | Data devolucao:" + t.getDataFim());
    }
    
    private Double calcularMulta(Transacao t){
        t.setDiasAtraso(calculaDias(t.getDataInicio(), t));
        Double valorMulta = t.getDiasAtraso() * 0.1;
        System.out.println("valorMulta:" + valorMulta);
        return valorMulta;
    }
    
    private int calculaDias(LocalDate data, Transacao t){
        LocalDate dataFinal = t.getDataInicio().plusDays(t.getDiasAtraso());
        int qtdDias =(int) ChronoUnit.DAYS.between(data, dataFinal);
        return Math.abs(qtdDias);
    }
}
