package com.chatapp.recursos;

/**
 * 
 * @author Pedro Henrique Correa Mota da Silva
 */
public class Criptografia {
   
    public static String encriptar(String textopuro){
        int letra;
        String msg_encriptada = "";
        for(int i = 0; i < textopuro.length(); i++){
           letra = (int)(textopuro.charAt(i)+1)*2;
           msg_encriptada += (char)letra; 
        }
        return msg_encriptada;
    }
    
    public static String decriptar(String textoencriptado){
        int letra;
        String msg_decriptada = "";
        for(int i = 0; i < textoencriptado.length(); i++){
           letra = (int)(textoencriptado.charAt(i)-1)/2;
           msg_decriptada += (char)letra; 
        }
        return msg_decriptada;
    }
    
}
