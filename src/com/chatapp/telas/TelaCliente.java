package com.chatapp.telas;

import com.chatapp.recursos.EntradaSaida;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Pedro Henrique Correa Mota da Silva
 */
public class TelaCliente extends javax.swing.JFrame {
    
    public static Socket s;
    public static DataInputStream din;
    public static DataOutputStream dout;
    
    public TelaCliente() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        area_texto_cliente = new javax.swing.JTextArea();
        linha_texto_cliente = new javax.swing.JTextField();
        botao_enviar_cliente = new javax.swing.JButton();
        botao_limpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cliente");

        jPanel1.setBackground(new java.awt.Color(140, 163, 186));
        jPanel1.setMaximumSize(new java.awt.Dimension(714, 504));

        area_texto_cliente.setEditable(false);
        area_texto_cliente.setBackground(new java.awt.Color(44, 44, 111));
        area_texto_cliente.setColumns(20);
        area_texto_cliente.setRows(5);
        area_texto_cliente.setForeground(new java.awt.Color(255, 255, 255));
        area_texto_cliente.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(area_texto_cliente);

        linha_texto_cliente.setBackground(new java.awt.Color(45, 45, 116));
        linha_texto_cliente.setCaretColor(new java.awt.Color(0, 0, 0));
        linha_texto_cliente.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        linha_texto_cliente.setForeground(new java.awt.Color(255, 255, 255));

        botao_enviar_cliente.setBackground(new java.awt.Color(0, 0, 63));
        botao_enviar_cliente.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        botao_enviar_cliente.setForeground(new java.awt.Color(255, 255, 255));
        botao_enviar_cliente.setText("ENVIAR");
        botao_enviar_cliente.setBorder(null);
        botao_enviar_cliente.setBorderPainted(false);
        botao_enviar_cliente.setMaximumSize(new java.awt.Dimension(78, 26));
        botao_enviar_cliente.setMinimumSize(new java.awt.Dimension(78, 26));
        botao_enviar_cliente.setPreferredSize(new java.awt.Dimension(78, 26));
        botao_enviar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_enviar_clienteActionPerformed(evt);
            }
        });

        botao_limpar.setBackground(new java.awt.Color(0, 0, 63));
        botao_limpar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        botao_limpar.setForeground(new java.awt.Color(255, 255, 255));
        botao_limpar.setText("LIMPAR");
        botao_limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_limparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                    .addComponent(linha_texto_cliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botao_enviar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_limpar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(botao_limpar)
                        .addGap(28, 28, 28)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botao_enviar_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(linha_texto_cliente))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botao_enviar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_enviar_clienteActionPerformed
        EntradaSaida es = new EntradaSaida();
        es.enviaMensagem(linha_texto_cliente, area_texto_cliente, dout, "Cliente");
    }//GEN-LAST:event_botao_enviar_clienteActionPerformed

    private void botao_limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_limparActionPerformed
        area_texto_cliente.setText("");
    }//GEN-LAST:event_botao_limparActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCliente().setVisible(true);
            }
        });
        EntradaSaida es = new EntradaSaida();
        try {
          s = new Socket("127.0.0.1",1201);
            din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());

            String msgin = "";
            while(!msgin.equals("exit")){
                msgin = din.readUTF();
                es.recebeMensagem(area_texto_cliente, msgin);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }     
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTextArea area_texto_cliente;
    private javax.swing.JButton botao_enviar_cliente;
    private javax.swing.JButton botao_limpar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField linha_texto_cliente;
    // End of variables declaration//GEN-END:variables
}
