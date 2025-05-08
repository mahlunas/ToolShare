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

/**
 *
 * @author lunas
 */
public class ToolShare {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Usuario user = new Usuario("marcelle", "18996961088", "40506832880");
        
        Ferramenta ferramenta = new Ferramenta("martelo", "martelo", 5.0, "manual");
        
        Transacao transacao = new Transacao(user, ferramenta, LocalDate.of(2025,5,1));
        transacao.setDataFim(LocalDate.of(2025,5,4));
        
        //transacao.calculaDias();
        
        transacao.devolverFerramenta(LocalDate.now());
        System.out.println("Usuario:" + transacao.usuario.nome);
        System.out.println("Ferramenta:" + transacao.ferramenta.nome);
    }
}
