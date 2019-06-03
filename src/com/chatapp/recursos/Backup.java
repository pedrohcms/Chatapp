package com.chatapp.recursos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Pedro Henrique Correa Mota da Silva
 */
public class Backup {
    
    private String caminho;
    private static boolean adicionar_arquivo = true;
      
    public Backup(String caminho, boolean adicionar_arquivo){
       this.caminho = caminho;
       this.adicionar_arquivo = adicionar_arquivo;
    }
   
    public void escreverNoArquivo(String text) throws IOException{
       FileWriter escritor = new FileWriter(caminho, adicionar_arquivo);
       PrintWriter escreve_linha = new PrintWriter(escritor);
       escreve_linha.printf("%s" + "%n", text);
       escreve_linha.close();
    }
    
}
