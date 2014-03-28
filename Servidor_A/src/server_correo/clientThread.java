/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server_correo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Iterator;
import java.util.LinkedList;
import javax.sound.midi.SysexMessage;
import javax.swing.JTextArea;
import parser_correo.correo;
import parser_correo.parser;
import parser_correo.usuario;

/**
 *
 * @author sebastian
 */
 /* The chat client thread. This client thread opens the input and the output
 * streams for a particular client, ask the client's name, informs all the
 * clients connected to the server about the fact that a new client has joined
 * the chat room, and as long as it receive data, echos that data back to all
 * other clients. The thread broadcast the incoming messages to all clients and
 * routes the private message to the particular client. When a client leaves the
 * chat room this thread informs also all the clients about that and terminates.
 */
class clientThread extends Thread {

  private String clientName = null;
  private DataInputStream is = null;
  private DataOutputStream os = null;
  private Socket clientSocket = null;
  private final clientThread[] threads;
  private int maxClientsCount;
  public compilador servidor = new compilador();
  private usuario usuario;
  private LinkedList<correo> listaCorreos;

  public clientThread(Socket clientSocket, clientThread[] threads) {
    this.clientSocket = clientSocket;
    this.threads = threads;
    maxClientsCount = threads.length;
  }
  
  public String getNombre(){
      
      return threads[0].clientName;
  }
  
   

  public void run() {
    int maxClientsCount = this.maxClientsCount;
    clientThread[] threads = this.threads;
 String name="";
 String res ="";
 String msj = "";
 parser parser;
    try {
      /*
       * Create input and output streams for this client.
       */
      is = new DataInputStream(clientSocket.getInputStream());
      os = new DataOutputStream(clientSocket.getOutputStream());
      String login;
     
      while (true) {
       // os.writeUTF("Enter your name.");
        login = is.readUTF().trim();
        System.out.println("login: "+login);
        res = servidor.iniciarSesion(login);
        System.out.println("res: "+res);
        if (res==""){
             System.err.println("login incorrecto: ");
             msj = "<sesion id=\"correo\">\n" +
                    "<Error> Verifique credenciales </Error>\n" +
                    "</sesion>";
             
          os.writeUTF(msj);
      //  }
       // if (name.indexOf('@') == -1) {          
        //  break;
        } else {
             
          
          
            break;
        }
      }
      
        usuario = servidor.getUsuario(res);
        //listaCorreos = servidor.getListaCorreo(usuario.getUsername());
          name = usuario.usuario;
            System.out.println("login correcto: "+name);
             msj = "<sesion id=\"correo\">\n" +
                   "<Registro> Session iniciada </Registro>\n" +
                   "</sesion>";
              
      //  listaCorreos = servidor.get
             os.writeUTF(msj);
             String res_login=is.readUTF();
          System.out.println("respuesta login: "+res_login);
          
          parser = servidor.compilar(res_login);
          System.out.println("res: "+parser.respuesta);
          if(parser.respuesta==3){
            String respuestaLC = servidor.getListaCorreos(usuario.usuario, usuario.nombre, usuario.username);
         System.out.println("respuesta para cliente: "+respuestaLC);
         if (respuestaLC.length()>1) 
         os.writeUTF(respuestaLC);
          
          }
      /* Welcome the new the client. */
    //  os.writeUTF("Welcome " + name
       //   + " to our chat room.\nTo leave enter /quit in a new line.");
      synchronized (this) {
        for (int i = 0; i < maxClientsCount; i++) {
          if (threads[i] != null && threads[i] == this) {
           // clientName = "@" + name;
              clientName = usuario.getUsuario();
          //  os.writeUTF("aprobado");
          //  new Login2().setVisible(true);
            
            break;
          }
        }
        
        
        
     /*   for (int i = 0; i < maxClientsCount; i++) {
          if (threads[i] != null && threads[i] != this) {
            threads[i].os.writeUTF("*** A new user " + name
                + " entered the chat room !!! ***");
          }
        }
        
         for (int i = 0; i < maxClientsCount; i++) {
          if (threads[i] != null)
             System.err.println("Cliente = "+threads[i].clientName);
             
        }*/
      }
      /* Start the conversation. */
      while (true) {
          
        String line = is.readUTF();
        listaCorreos = servidor.getListaCorreo(usuario.getUsername());
        // System.err.println("line="+line);
        if (line.startsWith("/quit")) {
          break;
        }
        /* If the message is private sent it to the given client. */
      //  if (line.startsWith("@")) {
           
          String[] words = line.split("~");
        //  line.split
          if (words.length > 1 && words[1] != null) {
            words[1] = words[1].trim();
            if (!words[1].isEmpty()) {
              synchronized (this) {
                for (int i = 0; i < maxClientsCount; i++) {
                  if (threads[i] != null && threads[i] != this
                      && threads[i].clientName != null
                      && threads[i].clientName.equals(words[0])) {
                    threads[i].os.writeUTF("<" + name + "> " + words[1]);
                    /*
                     * Echo this message to let the client know the private
                     * message was sent.
                     */
                    this.os.writeUTF(">" + name + "> " + words[1]);
                    break;
                  }
                }
              }
            }
          } else {
              
              
              // String entrada = is.readUTF();
              parser = servidor.compilar(line);
System.out.println("respuesta: "+parser.respuesta+"\n");
              switch (parser.respuesta) {
                  
                  case 3:
               String respuestaLC = servidor.getListaCorreos(usuario.usuario, usuario.nombre, usuario.username);
         System.out.println("respuesta para cliente: "+respuestaLC);
         if (respuestaLC.length()>1) 
         os.writeUTF(respuestaLC);
              break;

                  case 5:

                      System.out.println("get Correo: \n" + line);
              // if(parser.respuesta==5){

                      String content = servidor.getCorreo(listaCorreos, usuario.usuario, parser.correo.de, parser.correo.fecha);

                      System.out.println("correo click es: \n" + content);
//    this.os.writeUTF(parser.);
                      this.os.writeUTF(content);
                      break;
                      
                  case 7:
                      System.out.println("compilado correcto: \n");
                      
                     // System.out.println("Archivo es: "+servidor.getArchivoContent(parser.listaArchivos));
                      Iterator<String> itD = parser.correo_envio.destinatarios.iterator(); 
   
            System.out.println("TEXTO: " + parser.correo_envio.contenido); 
             String response ="<correo>\n";
             LinkedList<usuario> lU = servidor.getListaUsuarios();
            while (itD.hasNext()) {
                String listaD = itD.next();
                System.out.println("Destinatario: " + listaD.toString());  
              
                
                
                 Iterator<usuario> itU = lU.iterator();
                 int c=0;
                 while (itU.hasNext()) {
                      
                usuario u = itU.next();
                System.out.println("buscar compare: " + u.usuario+"="+ listaD.toString());
                if (u.usuario.equals(listaD)){
                   response+="<enviado>\n" +
                            "<destinatario>"+listaD+"</destinatario>\n" +
                            "</enviado>\n";
                   usuario usuario = servidor.getUsuario(listaD);
                   LinkedList<correo> listaCorreos = servidor.getListaCorreo(usuario.username);
                   servidor.actualizarCorreos(listaCorreos, parser.correo_envio, listaD, this.usuario.nombre, usuario.username);
                   c=0;
                   break;
                   
                   }else{
                    c++;    
                    }
                 }
                 if (c>0){
                  response+="<enviado>\n" +
                            "<destinatario>"+listaD+"</destinatario>\n" +
                             "<error> destinatario no valido </error>\n" +
                            "</enviado>\n";
                  //c=0;
                 }
                 
                 
                
                
                
                synchronized (this) {
                for (int i = 0; i < maxClientsCount; i++) {
                  if (threads[i] != null && threads[i] != this
                      && threads[i].clientName != null
                      && threads[i].clientName.equals(listaD.toString())) {
                    threads[i].os.writeUTF("<correo> mensaje recibido </correo>");
                    
                    /*
                     * Echo this message to let the client know the private
                     * message was sent.
                     */
                    System.out.println("comparar: "+this.clientName+"="+listaD);
                   
                    
                    break;
                  }else{
                   if (this.clientName.equals(listaD.toString())){
                     System.out.println("comparar: "+this.clientName+"="+listaD);
                       this.os.writeUTF("<correo> mensaje recibido </correo>");
                       break;
                   }
                  }
                }
              }
                
                
               }
            
            response+="</correo>";
             this.os.writeUTF(response);
     System.out.println("respuesta envio : "+response);
                      break;
                      
              }
               
               
              
             
              
              System.out.println("compilar2: "+line);
          /* The message is public, broadcast it to all other clients. */
        //  synchronized (this) {
          //  for (int i = 0; i < maxClientsCount; i++) {
           //   if (threads[i] != null && threads[i].clientName != null) {
           //     threads[i].os.writeUTF("<" + name + "> " + line);
           //   }
          //  }
         // }
        }
      }
      synchronized (this) {
        for (int i = 0; i < maxClientsCount; i++) {
          if (threads[i] != null && threads[i] != this
              && threads[i].clientName != null) {
            threads[i].os.writeUTF("*** The user " + name
                + " is leaving the chat room !!! ***");
          }
        }
      }
      os.writeUTF("*** Bye " + name + " ***");

      /*
       * Clean up. Set the current thread variable to null so that a new client
       * could be accepted by the server.
       */
      synchronized (this) {
        for (int i = 0; i < maxClientsCount; i++) {
          if (threads[i] == this) {
            threads[i] = null;
          }
        }
      }
      /*
       * Close the output stream, close the input stream, close the socket.
       */
      is.close();
      os.close();
      clientSocket.close();
    } catch (IOException e) {
    }
  }
}
