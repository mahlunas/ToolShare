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
    private static List<Transacao> transacoes = new ArrayList<>();
    
    //Controles de Usuarios
    public Usuario cadastrarUsuario(ArrayList<Usuario> usuarios, Scanner scanner){
        System.out.println("Cadastro de Usuario");
            
        System.out.println("CPF:");
        String cpf = scanner.nextLine();
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
    
    public Usuario buscaUsuario(String cpf, ArrayList<Usuario> usuarios){
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
        System.out.println("- Nome:" + user.getNome() + " | CPF:" + user.getCpf() + " | Contato:" + user.getContato());
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
    public Ferramenta cadastrarFerramenta(ArrayList<Ferramenta> ferramentas, Scanner scanner, ArrayList<Usuario> usuarios){
        System.out.println("Cadastro de Ferramenta");
        
        System.out.println("Insira seu CPF:");
        String cpf = scanner.nextLine();
        Usuario user = buscaUsuario(cpf, usuarios);
        if(user.getContador()>=5){
            System.out.println("Limite de ferramentas cadastradas atingidas");
            return null;
        }
        
        System.out.println("Insira o nome da ferramenta:");
        String nome = scanner.nextLine();
        boolean unico = verificaFerramentaDuplicada(nome, ferramentas);
        if(!unico){
            System.out.println("Nome inserida ja esta cadastrado");
            return null;
        }
        
        System.out.println("Insira a descricao:");
        String descricao = scanner.nextLine();
        
        System.out.println("Insira a categoria (ELETRICA | MANUAL | JARDIM):");
        String categoria = scanner.nextLine().toLowerCase();
        
        Double precoPorDia, valorMin;
        do{
            System.out.println("Insira o preco diario do alguel:");
            precoPorDia = scanner.nextDouble();
            
            valorMin = verificaCategoria(categoria);
        }while(precoPorDia < valorMin);
        
        
        Ferramenta ferramenta = new Ferramenta(nome, descricao, precoPorDia, categoria, user);
        user.adicionarFerramenta(ferramenta);
        return ferramenta;
    }
    
    public Double verificaCategoria(String categoria){
        switch(categoria){
            case "eletrica":
                return 15.0;
            case "manual":
                return 8.0;
            case "jardim":
                return 12.0;
            default:
                return 0.0;
        }
    }
    
    public boolean verificaFerramentaDuplicada(String nome, ArrayList<Ferramenta> ferramentas){
        for(Ferramenta f : ferramentas){
            if(nome.equals(f.getNome())){
                return false;
            }
        }
        return true;
    }
    
    public Ferramenta buscaFerramenta(String nomeFerramenta, ArrayList<Ferramenta> ferramentas){
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
    
    public void consultaFerramenta(ArrayList<Ferramenta> ferramentas, Scanner scanner){
        System.out.println("Insira o nome da ferramenta desejada:");
        String nome = scanner.nextLine();
        Ferramenta f = buscaFerramenta(nome, ferramentas);
        if(f == null){
            System.out.println("Ferramenta não encontrada");
        } else {
            imprimeFerramenta(f);
        }
    }
    
    public void alteraStatus(ArrayList<Ferramenta> ferramentas, Scanner scanner){
        System.out.println("Insira o nome da ferramenta desejada:");
        String nome = scanner.nextLine();
        Ferramenta f = buscaFerramenta(nome, ferramentas);
        //verifica se a ferramenta esta cadastrada
        if(f == null){
            System.out.println("Ferramenta não encontrada");
        } else {
            System.out.println("Insira seu CPF:");
            String cpf = scanner.nextLine();
            //verifica se é o proprietario
            if(f.getProprietario().getCpf().equals(cpf)){
                System.out.println("Insira o status desejado");
                String status = scanner.nextLine();
                f.alterarStatus(status, f);
            } else {
                System.out.println("Acesso negado. Usuario não é o proprietario da ferramenta");
            }
        }
    }
    
    public void alterarPreco(ArrayList<Ferramenta> ferramentas ,Scanner scanner){
        System.out.println("Digite o nome da ferramenta que deseja alterar o valor:");
        String nome = scanner.nextLine();
        Ferramenta f = buscaFerramenta(nome, ferramentas);
        if(f == null){
            System.out.println("Usuario não encontrado!");
            return;
        }
        
        System.out.println("Insira o novo valor:");
        Double novoValor = scanner.nextDouble();
        Double valorMin = verificaCategoria(f.getCategoria());
        if(novoValor < valorMin){
            System.out.println("Valor abaixo do valor minimo! (" + valorMin + ")");
        } else{
            System.out.println("Preco alterado com sucesso!");
            f.setPrecoPorDia(novoValor);
        }
    }
    
    //Controle de Transacoes
    
    public Transacao cadastrarTransacao(ArrayList<Transacao> transacoes, ArrayList<Usuario> usuarios, ArrayList<Ferramenta> ferramentas, Scanner scanner){
        System.out.println("Digite o nome do locador:");
        String nomeUsuario = scanner.nextLine();
        Usuario user = buscaUsuario(nomeUsuario, usuarios);
        if(user != null){
            System.out.println("Digite o nome da ferramenta desejada:");
            String nomeFerramenta = scanner.nextLine();
            Ferramenta f = buscaFerramenta(nomeFerramenta, ferramentas);
            
            if(f != null){
                LocalDate data = LocalDate.now();
                
                Transacao t = new Transacao(user, f, data);
                return t;
            }
        }
        
        System.out.println("Erro ao realizar o cadastro da Transacao");
        return null;
    }
    
    public void devolverFerramenta(ArrayList<Transacao> transacoes, ArrayList<Usuario> usuarios, ArrayList<Ferramenta> ferramentas, Scanner scanner){
        System.out.println("Digite o nome do usuario da transacao:");
        String nomeUsuario = scanner.nextLine();
        
        System.out.println("Digite o nome da ferramenta da transacao");
        String nomeFerramenta = scanner.nextLine();
        
        Transacao t = buscaTransacao(nomeUsuario, nomeFerramenta, transacoes, usuarios, ferramentas);
        
        if(t != null){
            int diasAlugados = calculaDias(t.getDataInicio(), t);
            t.setDataFim(LocalDate.now());
            System.out.println("dias alugados:" + diasAlugados);
            Double valorAluguel = t.getFerramenta().getPrecoPorDia() * diasAlugados;
            calculaDias(t.getDataFim(), t);
            Double valorTotal = valorAluguel + calcularMulta(transacoes, usuarios, ferramentas, scanner);
            System.out.println("Valor Total:" + valorTotal);
            t.setStatus(StatusTransacao.DESATIVADO);
        } else{
            System.out.println("Transacao nao encontrada!");
        }
        
    }
    
    public void consultaAluguelAtivo(ArrayList<Transacao> transacoes){
        for(Transacao t : transacoes){
            if(t.getStatus() == StatusTransacao.ATIVO){
                imprimeTransacao(t);
            }
        }
    }
    
    public void listarHistorico(ArrayList<Transacao> transacoes){
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
    
    public Double calcularMulta(ArrayList<Transacao> transacoes, ArrayList<Usuario> usuarios, ArrayList<Ferramenta> ferramentas, Scanner scanner){
        System.out.println("Digite o nome do usuario da transacao:");
        String nomeUsuario = scanner.nextLine();
        
        System.out.println("Digite o nome da ferramenta da transacao");
        String nomeFerramenta = scanner.nextLine();
        
        Transacao t = buscaTransacao(nomeUsuario, nomeFerramenta, transacoes, usuarios, ferramentas);
        if( t!= null){
             t.setDiasAtraso(calculaDias(t.getDataInicio(), t));
            Double valorMulta = t.getDiasAtraso() * 0.1;
            System.out.println("valorMulta:" + valorMulta);
            return valorMulta;
        }
        
        return 0.0;
    }
    
    private int calculaDias(LocalDate data, Transacao t){
        LocalDate dataFinal = t.getDataInicio().plusDays(t.getDiasAtraso());
        int qtdDias =(int) ChronoUnit.DAYS.between(data, dataFinal);
        return Math.abs(qtdDias);
    }
    
    private Transacao buscaTransacao(String nomeUsuario, String nomeFerramenta, ArrayList<Transacao> transacoes, ArrayList<Usuario> usuarios, ArrayList<Ferramenta> ferramentas){
        for(Transacao t : transacoes){
            Usuario user = buscaUsuario(nomeUsuario, usuarios);
            if(user != null && user.getNome().equals(t.getUsuario().getNome())){
                Ferramenta f = buscaFerramenta(nomeFerramenta, ferramentas);
                if(f != null && f.getNome().equals(t.getFerramenta().getNome())){
                    if(t.getStatus().equals(StatusTransacao.ATIVO)){
                        return t; 
                    }
                }
            }
        }
        
        return null;
    }
}
