/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cliente_chat;


import server_chat.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import parser_chat.*;


/**
 *
 * @author sebastian
 */
public class loginChat extends javax.swing.JFrame implements Runnable {

    // The client socket
   public Socket clientSocket = null;
    // The output stream
    public DataOutputStream os = null;
    // The input stream
   public DataInputStream is = null;
    public String responseLine = "";
    public LinkedList<contacto>  listaC;
    public LinkedList<solicitud>  listaS;
    Thread t = null;
    server servidor = new server();
     cliente cliente = new cliente();
   //  clientThread ct = 
    /**
     * Creates new form loginCorreo
     */
    public loginChat() {
        initComponents();
        String r = "<sesion peticion=\"envio\" >\n" +
"<usuario> Usuario1@servidorA.com </usuario>\n" +
"<destinatarios>\n" +
"<destinatario> Usuario1@servidorA.com </destinatario>\n" +
"<destinatario> Usuario2@servidorA.com </destinatario>\n" +
"<destinatario> Usuario3@servidorA.com </destinatario>\n" +
"</destinatarios>\n" +
"<asunto> asunto 1</asunto>\n" +
"<fecha> 10-03-2014,12:40:02 </fecha>\n" +
"<contenido> xxxxxxxx </contenido>\n" +
"<archivo></archivo>\n" +
"</sesion>";
        
       // txtCorreo.setText(r);
        
         int portNumber = 4444;
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

        mainChat = new javax.swing.JFrame();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        listContactos = new javax.swing.JList();
        btnEnviar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtMensaje = new javax.swing.JTextArea();
        labelDestinatario = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtConversacion = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        listSolicitudes = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnIniciarSesion = new javax.swing.JButton();
        txtPass = new javax.swing.JPasswordField();
        comboEstado = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        mainChat.setMinimumSize(new java.awt.Dimension(792, 354));

        jLabel5.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jLabel5.setText("CONTACTS");

        listContactos.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        listContactos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listContactosMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(listContactos);

        btnEnviar.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        btnEnviar.setText("SEND");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        txtMensaje.setColumns(20);
        txtMensaje.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        txtMensaje.setRows(5);
        jScrollPane3.setViewportView(txtMensaje);

        labelDestinatario.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        labelDestinatario.setText("FRIEND REQUESTS");

        jLabel3.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jLabel3.setText("CONVERSATIONS");

        txtConversacion.setColumns(20);
        txtConversacion.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        txtConversacion.setRows(5);
        jScrollPane4.setViewportView(txtConversacion);

        listSolicitudes.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        listSolicitudes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listSolicitudesMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(listSolicitudes);

        javax.swing.GroupLayout mainChatLayout = new javax.swing.GroupLayout(mainChat.getContentPane());
        mainChat.getContentPane().setLayout(mainChatLayout);
        mainChatLayout.setHorizontalGroup(
            mainChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainChatLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane6)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                    .addComponent(btnEnviar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainChatLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(12, 12, 12)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(mainChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                        .addComponent(jScrollPane5))
                    .addComponent(labelDestinatario, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        mainChatLayout.setVerticalGroup(
            mainChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainChatLayout.createSequentialGroup()
                .addGroup(mainChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainChatLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(labelDestinatario))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainChatLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainChatLayout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEnviar)
                        .addContainerGap())
                    .addComponent(jScrollPane3)))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jLabel1.setText("USER:");

        txtUser.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        txtUser.setText("Usuario1@servidorA.com");

        jLabel2.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jLabel2.setText("PASS:");

        btnIniciarSesion.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        btnIniciarSesion.setText("LOG IN");
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });

        txtPass.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N

        comboEstado.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        comboEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Disponible", "Ocupado" }));

        jLabel4.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jLabel4.setText("STATE:");

        jLabel6.setFont(new java.awt.Font("Courier New", 1, 36)); // NOI18N
        jLabel6.setText("CHAT");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1)))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUser)
                            .addComponent(txtPass)
                            .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(btnIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel6)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnIniciarSesion)
                .addGap(136, 136, 136))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
        // TODO add your handling code here:
        login(txtUser.getText(), txtPass.getText(), comboEstado.getSelectedItem().toString() );
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    private void listContactosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listContactosMouseClicked
        // TODO add your handling code here:
        //    //System.out.println("click: "+listBandeja.getSelectedIndex());
        //    //System.out.println("click: "+listBandeja.getSelectedValue().toString());
        int no;

        no = listContactos.getSelectedIndex();

   //     //System.out.println("click"+listaM.get(no-1).correo_d);
//        String content = "<sesion id=\"correo\" peticion=\"correo\" de=\""+listaC.get(no-1).de+"\" fecha=\""+listaC.get(no-1).fecha +"\">\n" +
     //   "<usuario>"+listaC.get(no-1).usuario+"</usuario>\n" +
     //   "</sesion>";
     //   System.err.println("content: "+content);
     //   writeUTF(content);
    }//GEN-LAST:event_listContactosMouseClicked

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        // TODO add your handling code here:

        writeUTF(txtMensaje.getText());
//txtAdjunto.append(txtContenido.getText()+"\n");
//redactarCorreo.setVisible(true);
//redactarCorreo.setTitle("Redactar "+txtUser.getText());

    }//GEN-LAST:event_btnEnviarActionPerformed

    private void listSolicitudesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listSolicitudesMouseClicked
        // TODO add your handling code here:
       // listarSolicitudes();
         int no;
//String username[] = txtUser.getText().split("@");
           //    listaS = cliente.getListaSolicitudes(username[0]);
        no = listSolicitudes.getSelectedIndex();
        //System.out.println("click: "+no);
        int reply = JOptionPane.showConfirmDialog(null, "Desea agregara a "+listaS.get(no-1).nombre+"("+listaS.get(no-1).usuario+")", "Solicitud de Amistad", JOptionPane.YES_NO_OPTION);
                String resp="<solicitud_amistad>\n";
                           
                           
                if (reply == JOptionPane.YES_OPTION) {
                  
                    resp+= "<respuesta> Si </respuesta>\n";
                }
                else {
                  // JOptionPane.showMessageDialog(null, "GOODBYE");
                    resp+= "<respuesta> No </respuesta>\n";
                 //  System.exit(0);
                }
    usuario usuario = servidor.getUsuario(txtUser.getText());             
            resp+="<destinatario>"+listaS.get(no-1).usuario +"</destinatario>\n" +
                            "<emisor>\n" +
                            "<usuario>"+txtUser.getText()+"</usuario>\n" +
                            "<nombre> "+usuario.getNombre()+" </nombre>\n" +
                            "</emisor>\n" +
                            "</solicitud_amistad>";
        //    listSolicitudes.remove(no);
           // listSolicitudes.removeSelectionInterval(no-1, no-1);
            listaS.remove(no-1);
            listSolicitudes.updateUI();
             //System.out.println("Lista Size1: "+listaS.size());
            servidor.actualizarSolicitudes2(listaS, usuario.getUsername());
            
               writeUTF(resp);
        
               listSolicitudes.repaint();
            System.err.println(resp);
           // listarSolicitudes();
    }//GEN-LAST:event_listSolicitudesMouseClicked

    public void crearCuenta(String contentCuenta){
        
        //System.out.println("Cuenta: "+contentCuenta);
    }
    
    public void writeUTF(String content){
    try {
            os.writeUTF(content);
        } catch (IOException ex) {
            Logger.getLogger(loginChat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void login(String user, String pass, String estado){
    
        String xmlLogin = "<login>" +
                          "<Usuario>"+user+"</usuario>" +
                          "<clave>"+pass+"</clave>" +
                          "<estado>"+estado+"</estado>" +
                          "</login>";
        
     //  String msj;
       //System.out.println(xmlLogin);
     //  mainChat.setVisible(true);
        writeUTF(xmlLogin);
       //msj = servidor.iniciarSesion(xmlLogin);
       
      // msj = cliente.procesarMsjCuenta(msj);
      
     //  JOptionPane.showMessageDialog(null,msj, "Inicio Sesion",JOptionPane.INFORMATION_MESSAGE);
       
      // if (msj.contains("iniciada"))
           // new correo(user).setVisible(true);
    //   //System.out.println(respuesta);
        ////System.out.println("xmlLogin: "+xmlLogin);
        
     }
    
    public void compilar(String content){
    
       parser parser = cliente.compilar(content);
     
       
       switch (parser.respuesta){
       
           case 0:
               JOptionPane.showMessageDialog(null, "error parser", "Error",JOptionPane.INFORMATION_MESSAGE);
           //   txtMensaje.append(content+"\n");
               break;
           case 1:
               JOptionPane.showMessageDialog(null, parser.msjCuenta, "Inicio Sesion",JOptionPane.INFORMATION_MESSAGE);
            //  jLabel3.setText("uno"+t.getName());
               break;
           case 2:
               JOptionPane.showMessageDialog(null, parser.msjCuenta, "Inicio Sesion", JOptionPane.INFORMATION_MESSAGE);

               this.setVisible(false);
               mainChat.setVisible(true);
               mainChat.setTitle(txtUser.getText());
               
               listarContactos();
               listarSolicitudes();
               
               break;
           case 3:
              //  JOptionPane.showMessageDialog(null, parser.msjCuenta, "Inicio Sesion", JOptionPane.INFORMATION_MESSAGE);
                
                int reply = JOptionPane.showConfirmDialog(null, "Desea agregara a "+parser.eSolicitud.getEmisor_nombre() +"("+parser.eSolicitud.getEmisor_usuario()+")", "Solicitud de Amistad", JOptionPane.YES_NO_OPTION);
                String resp="<solicitud_amistad>\n";
                           
                           
                if (reply == JOptionPane.YES_OPTION) {
                  
                    resp+= "<respuesta> Si </respuesta>\n";
                }
                else {
                  // JOptionPane.showMessageDialog(null, "GOODBYE");
                    resp+= "<respuesta> No </respuesta>\n";
                 //  System.exit(0);
                }
                
            resp+="<destinatario>"+parser.eSolicitud.getDestinatario_usuario() +"</destinatario>\n" +
                            "<emisor>\n" +
                            "<usuario>"+parser.eSolicitud.getEmisor_usuario()+"</usuario>\n" +
                            "<nombre> "+parser.eSolicitud.getEmisor_nombre()+" </nombre>\n" +
                            "</emisor>\n" +
                            "</solicitud_amistad>";
               
               writeUTF(resp);
               
           case 4:
               listarContactos();
               listarSolicitudes();
               break;
           case 5:
               
               
               if(parser.mensaje.getEmisor().equals(txtUser.getText())){
                   txtConversacion.append(parser.mensaje.getEmisor_nombre()+"(yo) :"+parser.mensaje.getContenido()+"\n");
               }else{
                   txtConversacion.append(parser.mensaje.getEmisor_nombre()+":"+parser.mensaje.getContenido()+"\n");
               }
              // labelDestinatario.setText("Mensaje de "+parser.correo.nombre_de);
            //   txtContenido.setText(parser.correo.contenido);
               break;
          
               
           case 8:
                JOptionPane.showMessageDialog(null, "Mensaje Recibido", txtUser.getText() ,JOptionPane.INFORMATION_MESSAGE);
              
                String peticion_n = "<sesion id=\"correo\" peticion=\"Lista correos\">\n"+
                                "<usuario>"+txtUser.getText()+"</usuario>\n"+
                                "</sesion>";
               writeUTF(peticion_n);
                break;
               
               case 9:
                JOptionPane.showMessageDialog(null, parser.rCorreo, txtUser.getText(),JOptionPane.INFORMATION_MESSAGE);
               break;
                    default:
            //   txtMensaje.append(content+"\n");
                JOptionPane.showMessageDialog(null, "Error Lexico/Sintactico", "Error", JOptionPane.INFORMATION_MESSAGE);
               break;
               
       
       }
        
    
    }
    
    public void listarContactos(){
        String username[] = txtUser.getText().split("@");
               listaC = cliente.getListaContactos(username[0]);
               
               if(listaC!= null){
               Iterator<contacto> itC = listaC.iterator(); 
  
               String[] contactos = new String[1000];
               int c = 0;
               while (itC.hasNext()) {
                   c++;
                   contacto contacto = itC.next();
                   contactos[c] = contacto.nombre + "-" + contacto.usuario + "-" + contacto.estado;

               }
               listContactos.setListData(contactos);
               }
    }
    
    public void listarSolicitudes(){
        String username[] = txtUser.getText().split("@");
               listaS = cliente.getListaSolicitudes(username[0]);
               if(listaS != null){
               Iterator<solicitud> itS = listaS.iterator(); 
  
               String[] solicitudes = new String[1000];
               int c = 0;
               while (itS.hasNext()) {
                   c++;
                   solicitud solicitud = itS.next();
                   solicitudes[c] = solicitud.nombre + "-" + solicitud.usuario;

               }
               listSolicitudes.setListData(solicitudes);
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
            java.util.logging.Logger.getLogger(loginChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginChat().setVisible(true);
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
                //System.out.println("response: "+responseLine);
                compilar(responseLine);
              //  mostrarMensaje(responseLine);
                

            } catch (IOException e) {
                //System.out.println("Could not read from server");
            }
            //jTextArea1.append(responseLine);

        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JComboBox comboEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel labelDestinatario;
    private javax.swing.JList listContactos;
    private javax.swing.JList listSolicitudes;
    private javax.swing.JFrame mainChat;
    private javax.swing.JTextArea txtConversacion;
    private javax.swing.JTextArea txtMensaje;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
