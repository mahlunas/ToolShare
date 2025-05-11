/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.toolshare;

import com.mycompany.toolshare.model.Ferramenta;
import com.mycompany.toolshare.model.Transacao;
import com.mycompany.toolshare.model.Usuario;
import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.toolshare.controller.Plataforma;
import com.mycompany.toolshare.view.Menu;
import com.mycompany.toolshare.controller.Carregamento;
/**
 *
 * @author lunas
 */
public class ToolShare {
        private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        private static ArrayList<Ferramenta> ferramentas = new ArrayList<Ferramenta>();
        private static ArrayList<Transacao> transacoes = new ArrayList<Transacao>();
        private static Usuario usuario = null;
        private static Ferramenta ferramenta = null;
        private static Transacao transacao = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Plataforma plataforma = new Plataforma();
        Menu menu = new Menu();
        int opPrincipal, opMenus, encerrarMenu;
        Carregamento.Carregar(transacoes, usuarios, ferramentas, plataforma);
        do{
            menu.menuPrincipal();
            opPrincipal = scanner.nextInt();
            
            switch(opPrincipal){
                //menu de usuarios
                case 1:
                    do{
                        menu.menuDeUsuarios();
                        opMenus = scanner.nextInt();
                        
                        switch(opMenus){
                            //cadastrar
                            case 1:
                                usuario = plataforma.cadastrarUsuario(usuarios, scanner);
                                if(usuario != null){
                                    usuarios.add(usuario);
                                    System.out.println("Usuario cadastrado com sucesso!");
                                }
                            break;
                            //consultar cpf
                            case 2:
                                plataforma.cadastrarUsuario(usuarios, scanner);
                            break;
                            //editar cadastro
                            case 3:
                                plataforma.editarCadastro(usuarios, scanner);
                            break;
                            //excluir usuario
                            case 4:
                                usuario = plataforma.excluirUsuario(usuarios, scanner);
                                if(usuario != null){
                                    usuarios.remove(usuario);
                                    System.out.println("Usuario removido");
                                }
                            break;
                            //listar todos os usuarios
                            case 5:
                                plataforma.listarUsuario(usuarios);
                            break;
                        }
                        
                    }while(opMenus != 6);
                break;
                //menu de ferramentas
                case 2:
                    do{
                        menu.menuDeFerramentas();
                        opMenus = scanner.nextInt();
                        switch(opMenus){
                            case 1:
                                ferramenta = plataforma.cadastrarFerramenta(ferramentas, scanner, usuarios);
                                if(ferramenta != null){
                                    ferramentas.add(ferramenta);
                                    System.out.println("Ferramenta cadastrada com sucesso");
                                }
                            break;
                            case 2:
                                plataforma.consultaFerramenta(ferramentas, scanner);
                            break;
                            case 3:
                                plataforma.alterarPreco(ferramentas, scanner);
                            break;
                            case 4:
                                plataforma.alteraStatus(ferramentas, scanner);
                            break;
                            case 5:
                                plataforma.listaFerramentas(ferramentas);
                            break;
                        }
                    }while(opMenus != 6);
                break;
                //menu de alugueis
                case 3:
                    do{
                        menu.menuDeAlugueis();
                        opMenus = scanner.nextInt();
                        
                        switch(opMenus){
                            case 1:
                                transacao = plataforma.cadastrarTransacao(transacoes, usuarios, ferramentas, scanner);
                                if(transacao != null){
                                    transacoes.add(transacao);
                                    System.out.println("Transacao cadastrada com sucesso");
                                }
                            break;
                            case 2:
                                plataforma.devolverFerramenta(transacoes, usuarios, ferramentas, scanner);
                            break;
                            case 3:
                                plataforma.consultaAluguelAtivo(transacoes);
                            break;
                            case 4:
                               Double x = plataforma.calcularMulta(transacoes, usuarios, ferramentas, scanner);
                            break;
                            case 5:
                                plataforma.listarHistorico(transacoes);
                            break;
                        }
                        encerrarMenu = opMenus;
                    }while(encerrarMenu != 6);
                break;
                
                case 4:
                  
                break;    
            }
        }while(opPrincipal!=5);
    }
}
