/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server_chat;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import parser_chat.*;

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
  private LinkedList<contacto> listaContactos;

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
        System.out.println("login2: "+login);
        res = servidor.iniciarSesion(login);
        System.out.println("res: "+res);
        if (res==""){
             System.err.println("login incorrecto: ");
             msj = "<login>\n" +
                    "<Error> Verifique credenciales </Error>\n" +
                    "</login>";
             
          os.writeUTF(msj);
      //  }
       // if (name.indexOf('@') == -1) {          
        //  break;
        } else {
             
         
          
            break;
        }
      }
      
        usuario = servidor.getUsuario(res);
        
  //      listaContactos = servidor.
      //  listaCorreos = servidor.getListaCorreo(usuario.getUsername());
          name = usuario.usuario;
            System.err.println("login correcto: "+name);
             msj = "<login>\n" +
                   "<inicio> Session iniciada </inicio>\n" +
                   "</login>";
          
             
              
      //  listaCorreos = servidor.get
             os.writeUTF(msj);
       //   System.out.println("respuesta login: "+is.readUTF());
          
      //    parser = servidor.compilar(is.readUTF());
     //     System.out.println("res: "+parser.respuesta);
    //      if(parser.respuesta==3){
    //        String respuestaLC = servidor.getListaCorreos(usuario.usuario, usuario.nombre, usuario.username);
    //     System.out.println("respuesta para cliente: "+respuestaLC);
    //     if (respuestaLC.length()>1) 
     //    os.writeUTF(respuestaLC);
          
       //   }
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
     //   listaCorreos = servidor.getListaCorreo(usuario.getUsername());
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
              // System.out.println("compilado correcto: \n"+parser.eSolicitud.getDestinatario_usuario());
               System.out.println("comparar1: "+this.clientName+"="+parser.eSolicitud.getDestinatario_usuario());
                           
                synchronized (this) {
                for (int i = 0; i < maxClientsCount; i++) {
                     System.out.println("comparar2: "+threads[i].clientName+"="+parser.eSolicitud.getDestinatario_usuario());
                   
                  if (threads[i] != null && threads[i] != this
                      && threads[i].clientName != null
                      && threads[i].clientName.equals(parser.eSolicitud.getDestinatario_usuario())) {
                  
                      
                      threads[i].os.writeUTF(line);
                    
                    
                    /*
                     * Echo this message to let the client know the private
                     * message was sent.
                     */
                   
                    
                    break;
                  }else{
                      
                      JOptionPane.showMessageDialog(null, "solicitud Enviada", "Inicio Sesion", JOptionPane.INFORMATION_MESSAGE);

                 //  if (this.clientName.equals(parser.eSolicitud.getEmisor_usuario())){
                    // System.out.println("comparar: "+this.clientName+"="+listaD);
                     //  this.os.writeUTF(line);
                       usuario usuario1 = servidor.getUsuario(parser.eSolicitud.getDestinatario_usuario());
                    LinkedList<solicitud> listaSolicitudes1 = servidor.getListaSolicitudes(usuario1.username);
                    usuario usuario2 = servidor.getUsuario(parser.eSolicitud.getEmisor_usuario());
                   
                       servidor.actualizarSolicitudes(listaSolicitudes1, usuario2, usuario1.getUsername());
                   
                       break;
                  // }
                  }
                }
              }
                
                
               
              break;
                  case 4:
                  System.out.println("respuesta es: "+parser.eSolicitud.getRespuesta());
                  if(parser.eSolicitud.getRespuesta().equals("Si")){
                      
                   usuario usuario1 = servidor.getUsuario(parser.eSolicitud.getDestinatario_usuario());
                    LinkedList<contacto> listaContactos1 = servidor.getListaContactos(usuario1.username);
                   
                    usuario usuario2 = servidor.getUsuario(parser.eSolicitud.getEmisor_usuario());
              //     contacto contacto2 = servidor.getContacto(parser.eSolicitud.getEmisor_usuario());
                   LinkedList<contacto> listaContactos2 = servidor.getListaContactos(usuario2.username);
                    
                    servidor.actualizarContactos(listaContactos1, usuario2, usuario1.getUsername());
                    servidor.actualizarContactos(listaContactos2, usuario1, usuario2.getUsername());
                   
                    for (int i = 0; i < maxClientsCount; i++) {
                  if ( (threads[i].clientName.equals(parser.eSolicitud.getDestinatario_usuario())||threads[i].clientName.equals(parser.eSolicitud.getEmisor_usuario()))) {
                  threads[i].os.writeUTF(line);      
                  }
                    }
                //   contacto contacto1 = servidor.getContacto(parser.eSolicitud.getDestinatario_usuario());
               //    LinkedList<contacto> listaContactos1 = servidor.getListaContactos(usuario1.username);
                   
               //    usuario usuario2 = servidor.getUsuario(parser.eSolicitud.getEmisor_usuario());
              //     contacto contacto2 = servidor.getContacto(parser.eSolicitud.getEmisor_usuario());
                //   LinkedList<contacto> listaContactos2 = servidor.getListaContactos(usuario2.username);
                   
                   
            // servidor.actualizarContactos(listaContactos1, contacto2, usuario1.getUsername());
             // servidor.actualizarContactos(listaContactos2, contacto1, usuario2.getUsername());
                  }else{
                  
                  }
                      
                      break;
                  case 5:

                      System.out.println("get Correo: \n" + line);
              // if(parser.respuesta==5){

               //       String content = servidor.getCorreo(listaCorreos, usuario.usuario, parser.correo.de, parser.correo.fecha);
String content="";
                      System.out.println("correo click es: \n" + content);
//    this.os.writeUTF(parser.);
                      this.os.writeUTF(content);
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
