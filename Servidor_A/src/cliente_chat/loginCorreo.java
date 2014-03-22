/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cliente_chat;


import cliente_correo.*;
import server_correo.server;
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
import parser_correo.correo;
import parser_correo.parser;

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
public LinkedList<correo>  listaC;
    Thread t = null;
    server servidor = new server();
     cliente cliente = new cliente();
   //  clientThread ct = 
    /**
     * Creates new form loginCorreo
     */
    public loginCorreo() {
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

        mainChat.setMinimumSize(new java.awt.Dimension(792, 354));

        jLabel5.setText("Contactos");

        listContactos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listContactosMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(listContactos);

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        txtMensaje.setColumns(20);
        txtMensaje.setRows(5);
        jScrollPane3.setViewportView(txtMensaje);

        labelDestinatario.setText("Solicitudes amistades Pendientes");

        jLabel3.setText("Conversación");

        txtConversacion.setColumns(20);
        txtConversacion.setRows(5);
        jScrollPane4.setViewportView(txtConversacion);

        listSolicitudes.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(listSolicitudes);

        javax.swing.GroupLayout mainChatLayout = new javax.swing.GroupLayout(mainChat.getContentPane());
        mainChat.getContentPane().setLayout(mainChatLayout);
        mainChatLayout.setHorizontalGroup(
            mainChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainChatLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane6)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                    .addComponent(btnEnviar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(mainChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                    .addComponent(labelDestinatario)
                    .addComponent(jScrollPane5))
                .addContainerGap())
        );
        mainChatLayout.setVerticalGroup(
            mainChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainChatLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(mainChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(labelDestinatario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainChatLayout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEnviar)
                        .addContainerGap())
                    .addComponent(jScrollPane3)))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Usuario:");

        txtUser.setText("Usuario1@servidorA.com");

        jLabel2.setText("Correo:");

        btnIniciarSesion.setText("Iniciar Sesion");
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });

        comboEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Disponible", "Ocupado" }));

        jLabel4.setText("Estado:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4)
                        .addComponent(jLabel2)))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                    .addComponent(txtPass)
                    .addComponent(comboEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnIniciarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(btnIniciarSesion)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
        // TODO add your handling code here:
        login(txtUser.getText(), txtPass.getText(), comboEstado.getSelectedItem().toString() );
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    private void listContactosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listContactosMouseClicked
        // TODO add your handling code here:
        //    System.out.println("click: "+listBandeja.getSelectedIndex());
        //    System.out.println("click: "+listBandeja.getSelectedValue().toString());
        int no;

        no = listContactos.getSelectedIndex();

   //     System.out.println("click"+listaM.get(no-1).correo_d);
        String content = "<sesion id=\"correo\" peticion=\"correo\" de=\""+listaC.get(no-1).de+"\" fecha=\""+listaC.get(no-1).fecha +"\">\n" +
        "<usuario>"+listaC.get(no-1).usuario+"</usuario>\n" +
        "</sesion>";
        System.err.println("content: "+content);
        writeUTF(content);
    }//GEN-LAST:event_listContactosMouseClicked

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        // TODO add your handling code here:
//writeUTF(txtContenido.getText());
//txtAdjunto.append(txtContenido.getText()+"\n");
//redactarCorreo.setVisible(true);
//redactarCorreo.setTitle("Redactar "+txtUser.getText());

    }//GEN-LAST:event_btnEnviarActionPerformed

    public void crearCuenta(String contentCuenta){
        
        System.out.println("Cuenta: "+contentCuenta);
    }
    
    public void writeUTF(String content){
    try {
            os.writeUTF(content);
        } catch (IOException ex) {
            Logger.getLogger(loginCorreo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void login(String user, String pass, String estado){
    
        String xmlLogin = "<sesion id=\"correo\" tipo=\"inicio\">" +
                          "<Usuario>"+user+"</usuario>" +
                          "<clave>"+pass+"</clave>" +
                          "<estado>"+estado+"</estado>" +
                          "</sesion>";
        
     //  String msj;
       System.out.println(xmlLogin);
       mainChat.setVisible(true);
        //writeUTF(xmlLogin);
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
              txtMensaje.append(content+"\n");
               break;
           case 1:
               JOptionPane.showMessageDialog(null, parser.msjCuenta, "Inicio Sesion",JOptionPane.INFORMATION_MESSAGE);
            //  jLabel3.setText("uno"+t.getName());
               break;
           case 2:
               JOptionPane.showMessageDialog(null, parser.msjCuenta, "Inicio Sesion",JOptionPane.INFORMATION_MESSAGE);
               
               this.setVisible(false);
               mainChat.setVisible(true);
             //  jLabel3.setText("dos"+t.getName());
               mainChat.setTitle(txtUser.getText());
               String peticion = "<sesion id=\"correo\" peticion=\"Lista correos\">\n"+
                                "<usuario>"+txtUser.getText()+"</usuario>\n"+
                                "</sesion>";
               writeUTF(peticion);
               break;
           case 4:
            listaC = parser.listaCorreos;
         System.out.println("####CORREOS ----");

            Iterator<correo> itM = listaC.iterator(); /*
             * Listar los errores que se han guardado en la variable lista
             */
            String[] correos = new String[1000];
            int c =0;
            while (itM.hasNext()) {
                c++;
                correo correo = itM.next();
               // System.out.println("nombre: " + listaM.getNombre_d() + " asunto :" + listaM.getAsunto() + " de: " + listaM.getEmisor());
              // txtBandeja.append(listaM.getNombre_d()+"-"+listaM.getAsunto()+"-"+listaM.getFecha()+"\n");
             correos[c]= correo.nombre_de+"-"+correo.asunto+"-"+correo.fecha;
               
            }
           
           //  listModel.addElement("uno");
           //  listModel.add(0, strings);
             listContactos.setListData(correos);
               break;
           case 6:
               labelDestinatario.setText("Mensaje de "+parser.correo.nombre_de);
            //   txtContenido.setText(parser.correo.contenido);
               break;
           default:
               txtMensaje.append(content+"\n");
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
                System.out.println("response: "+responseLine);

            } catch (IOException e) {
                System.out.println("Could not read from server");
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
