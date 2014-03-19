/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cliente;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import parser.parser;
import server.*;

/**
 *
 * @author sebastian
 */
public class loginCorreo extends javax.swing.JFrame implements Runnable {

    // The client socket
   public Socket clientSocket = null;
    // The output stream
    public DataOutputStream os = null;
    // The input stream
   public DataInputStream is = null;
    public String responseLine = "";

    Thread t = null;
    server servidor = new server();
     cliente cliente = new cliente();
   //  clientThread ct = 
    /**
     * Creates new form loginCorreo
     */
    public loginCorreo() {
        initComponents();
         int portNumber = 2222;
        // The default host.
        String host = "localhost";
        try {
            clientSocket = new Socket(host, portNumber);
            os = new DataOutputStream(clientSocket.getOutputStream());
            is = new DataInputStream(clientSocket.getInputStream());
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + host);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to the host "
                    + host);
        }

        t = new Thread(this);
        t.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainCorreo = new javax.swing.JFrame();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        listBandeja2 = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAdjunto = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtContenido = new javax.swing.JTextArea();
        destinatario = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnIniciarSesion = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();

        mainCorreo.setMinimumSize(new java.awt.Dimension(792, 334));

        jLabel5.setText("Bandeja de Entrada");

        listBandeja2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listBandeja2MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(listBandeja2);

        jButton1.setText("Redactar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtAdjunto.setColumns(20);
        txtAdjunto.setRows(5);
        jScrollPane3.setViewportView(txtAdjunto);

        txtContenido.setColumns(20);
        txtContenido.setRows(5);
        jScrollPane2.setViewportView(txtContenido);

        destinatario.setText("destinatario");

        javax.swing.GroupLayout mainCorreoLayout = new javax.swing.GroupLayout(mainCorreo.getContentPane());
        mainCorreo.getContentPane().setLayout(mainCorreoLayout);
        mainCorreoLayout.setHorizontalGroup(
            mainCorreoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainCorreoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainCorreoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainCorreoLayout.createSequentialGroup()
                        .addGroup(mainCorreoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainCorreoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(destinatario)
                    .addGroup(mainCorreoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                        .addComponent(jScrollPane3)))
                .addContainerGap())
        );
        mainCorreoLayout.setVerticalGroup(
            mainCorreoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainCorreoLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(mainCorreoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(destinatario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainCorreoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainCorreoLayout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addGroup(mainCorreoLayout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Usuario:");

        txtUser.setText("usuario@servidorA.com");

        jLabel2.setText("Correo:");

        btnIniciarSesion.setText("Iniciar Sesion");
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });

        jLabel3.setForeground(java.awt.Color.blue);
        jLabel3.setText("Crear Cuenta");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel3))
                    .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                    .addComponent(txtPass))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnIniciarSesion)
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
        // TODO add your handling code here:
        login(txtUser.getText(), txtPass.getText());
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        
        new crearCuenta().setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void listBandeja2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listBandeja2MouseClicked
        // TODO add your handling code here:
        //    System.out.println("click: "+listBandeja.getSelectedIndex());
        //    System.out.println("click: "+listBandeja.getSelectedValue().toString());
        int no;

        no = listBandeja.getSelectedIndex();

   //     System.out.println("click"+listaM.get(no-1).correo_d);
     //   String content = "<sesión id=\"correo\" peticion=\"correo\" de=\""+listaM.get(no-1).emisor+"\" fecha=\""+listaM.get(no-1).fecha +"\">\n" +
     //   "<usuario>"+listaM.get(no-1).correo_d+"</usuario>\n" +
     //   "</sesion>";
     //   System.err.println("content: "+content);
    }//GEN-LAST:event_listBandeja2MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jButton1ActionPerformed

    public void crearCuenta(String contentCuenta){
        
        System.out.println("Cuenta: "+contentCuenta);
    }
    
    public void writeUTF(String content){
    try {
            os.writeUTF(content);
        } catch (IOException ex) {
            Logger.getLogger(Login2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void login(String user, String pass){
    
        String xmlLogin = "<sesion id=\"correo\" tipo=\"inicio\">" +
                          "<Usuario>"+user+"</usuario>" +
                          "<clave>"+pass+"</clave>" +
                          "</sesion>";
        
     //  String msj;
       
        writeUTF(xmlLogin);
       //msj = servidor.iniciarSesion(xmlLogin);
       
      // msj = cliente.procesarMsjCuenta(msj);
      
     //  JOptionPane.showMessageDialog(null,msj, "Inicio Sesion",JOptionPane.INFORMATION_MESSAGE);
       
      // if (msj.contains("iniciada"))
           // new correo(user).setVisible(true);
    //   System.out.println(respuesta);
        //System.out.println("xmlLogin: "+xmlLogin);
        
     }
    
    public void compilar(String content){
    
       parser parser = cliente.compilar(content);
     
       
       switch (parser.respuesta){
       
           case 0:
               JOptionPane.showMessageDialog(null, "error parser", "Error",JOptionPane.INFORMATION_MESSAGE);
               break;
           case 1:
               JOptionPane.showMessageDialog(null, parser.msjCuenta, "Inicio Sesion",JOptionPane.INFORMATION_MESSAGE);
              jLabel3.setText("uno"+t.getName());
               break;
           case 2:
               JOptionPane.showMessageDialog(null, parser.msjCuenta, "Inicio Sesion",JOptionPane.INFORMATION_MESSAGE);
               
               this.setVisible(false);
               mainCorreo.setVisible(true);
             //  jLabel3.setText("dos"+t.getName());
               
               String peticion = "<sesion id=\"correo\" peticion=\"Lista correos\">\n"+
                                "<usuario>"+txtUser.getText()+"</usuario>\n"+
                                "</sesion>";
               writeUTF(peticion);
               break;
               
           default:
               break;
               
       
       }
        
    
    }
    
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
            java.util.logging.Logger.getLogger(loginCorreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginCorreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginCorreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginCorreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginCorreo().setVisible(true);
            }
        });
    }
    
     public void run() {

     //responseLine;
        while (true) {
            try {
                responseLine = is.readUTF();
               // if (responseLine.contains("exito")) {
              //      System.err.println("exito");
               // }
                compilar(responseLine);
              //  mostrarMensaje(responseLine);
                System.out.println(responseLine);

            } catch (IOException e) {
                System.out.println("Could not read from server");
            }
            //jTextArea1.append(responseLine);

        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JLabel destinatario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JList listBandeja;
    private javax.swing.JList listBandeja1;
    private javax.swing.JList listBandeja2;
    private javax.swing.JFrame mainCorreo;
    private javax.swing.JTextArea txtAdjunto;
    private javax.swing.JTextArea txtContenido;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
