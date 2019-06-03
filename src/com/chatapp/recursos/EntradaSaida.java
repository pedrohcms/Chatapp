package com.chatapp.recursos;

import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Pedro Henrique Correa Mota da Silva
 */
public class EntradaSaida {
    
    private Backup bk;
    
    public EntradaSaida(){
    
        bk = new Backup(".."+File.separator+"Chatapp-master"+File.separator+"build"+File.separator+"classes"+File.separator+
                "com"+File.separator+"chatapp"+File.separator+"recursos"+File.separator+
                "backup.txt" ,true);
    }
    
    public void enviaMensagem(JTextField linha_texto, JTextArea area_texto, DataOutputStream dout, String nome)
    {
        String msgout = "";
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        
        msgout = formatter.format(date)+" "+ nome +": "+ linha_texto.getText().trim();
        
        area_texto.setText(area_texto.getText().trim()+"\n"+ msgout);
        linha_texto.setText("");
        try {
            bk.escreverNoArquivo(msgout);
            msgout = Criptografia.encriptar(msgout);
            dout.writeUTF(msgout);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }    
    }
    
    public void recebeMensagem(JTextArea area_texto, String msgin){
        msgin = Criptografia.decriptar(msgin);
        
        try{
            bk.escreverNoArquivo(msgin);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        
        msgin = area_texto.getText().trim()+"\n"+ msgin;
        area_texto.setText(msgin);
    }
    
}
