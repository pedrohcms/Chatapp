package com.chatapp.telas;

import com.chatapp.recursos.EntradaSaida;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Pedro Henrique Correa Mota da Silva
 */
public class TelaServidor extends javax.swing.JFrame {

    private static ServerSocket ss;
    private static Socket s;
    private static DataInputStream din;
    private static DataOutputStream dout;
    private static EntradaSaida es;
    
    public TelaServidor() {
        initComponents();
        es = new EntradaSaida();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        area_texto_servidor = new javax.swing.JTextArea();
        linha_texto_servidor = new javax.swing.JTextField();
        botao_enviar_servidor = new javax.swing.JButton();
        botao_limpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Servidor");

        area_texto_servidor.setEditable(false);
        area_texto_servidor.setColumns(20);
        area_texto_servidor.setRows(5);
        jScrollPane2.setViewportView(area_texto_servidor);

        linha_texto_servidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linha_texto_servidorActionPerformed(evt);
            }
        });

        botao_enviar_servidor.setText("ENVIAR");
        botao_enviar_servidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_enviar_servidorActionPerformed(evt);
            }
        });

        botao_limpar.setText("LIMPAR");
        botao_limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_limparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
                    .addComponent(linha_texto_servidor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botao_enviar_servidor)
                    .addComponent(botao_limpar))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botao_limpar)
                        .addGap(27, 27, 27)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botao_enviar_servidor, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(linha_texto_servidor))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void linha_texto_servidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linha_texto_servidorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_linha_texto_servidorActionPerformed

    private void botao_enviar_servidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_enviar_servidorActionPerformed
       es.enviaMensagem(linha_texto_servidor, area_texto_servidor, dout, "Servidor");
    }//GEN-LAST:event_botao_enviar_servidorActionPerformed

    private void botao_limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_limparActionPerformed
        area_texto_servidor.setText("");
    }//GEN-LAST:event_botao_limparActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaServidor().setVisible(true);
            }
        });
        try{
            ss = new ServerSocket(1201);
            s = ss.accept();
            din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());
            
            String msgin = "";
            while(!msgin.equals("exit")){
                msgin = din.readUTF();
                es.recebeMensagem(area_texto_servidor, msgin);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTextArea area_texto_servidor;
    private javax.swing.JButton botao_enviar_servidor;
    private javax.swing.JButton botao_limpar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField linha_texto_servidor;
    // End of variables declaration//GEN-END:variables
}
