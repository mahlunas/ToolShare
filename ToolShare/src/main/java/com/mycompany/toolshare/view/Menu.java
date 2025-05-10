/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.toolshare.view;

/**
 *
 * @author lunas
 */
public class Menu {
    public void menuPrincipal(){
        System.out.println("======== TOOLSHARE ========");
        System.out.println("1 - Gerenciar Usuarios");
        System.out.println("2 - Gerenciar Ferramentas");
        System.out.println("3 - Gerenciar Alugueis");
        System.out.println("4 - Relatorios");
        System.out.println("5 - Sair");
    }
    
    public void menuDeUsuarios(){
        System.out.println("==== GERENCIAR USUARIOAS ====");
        System.out.println("1 - Cadastrar Novov Usuario");
        System.out.println("2 - Consultar por CPF");
        System.out.println("3 - Editar Cadastro");
        System.out.println("4 - Excluir Usuario");
        System.out.println("5 - Listar Todos");
        System.out.println("6 - Voltar");
    }
    
    public void menuDeFerramentas(){
        System.out.println("========== GERENCIAR FERRAMENTAS ==========");
        System.out.println("1 - Cadastrar Nova Ferramenta");
        System.out.println("2 - Buscar por Nome/Codigo");
        System.out.println("3 - Alterar Preco");
        System.out.println("4 - Atualizar Status (Disponvel/Manutencao");
        System.out.println("5 - Listar Disponiveis");
        System.out.println("6 - Voltar");
    }
    
    public void menuDeAlugueis(){
        System.out.println("==== GERENCIAR ALUGUEIS ====");
        System.out.println("1 - Realizar Aluguel");
        System.out.println("2 - Realizar Devolucao");
        System.out.println("3 - Consultar Aluguel Ativo");
        System.out.println("4 - Calcular Multa por Atraso");
        System.out.println("5 - Listar Historico");
        System.out.println("6 - Voltar");
    }
}
