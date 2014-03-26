/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server_chat;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import parser_chat.Errores;
import parser_chat.contacto;
import parser_chat.correo;
import parser_chat.parser;
import parser_chat.scanner;
import parser_chat.solicitud;
import parser_chat.usuario;





import static servidor_a.ini.*; /*ini*/


/**
 *
 * @author sebastian
 */
public  class compilador {
    
     
    
    public String crearCuenta(String content){
   //  System.out.println("cotnent:"+content); 
        
        String exito = "<sesion id=\"correo\">\n" +
                        "<Registro> Usuario registrado </Registro>\n" +
                        "</sesion>";
         
         usuario user = compilar(content).usuario;
     
         if(user.getUsuario() != null){
            LinkedList<usuario> listaUsuarios= getListaUsuarios();
                      
                      
         if (comprobarUsuario(listaUsuarios, user.getUsuario())==0){
             
             actualizarListaUsuarios(listaUsuarios, user);
             insertLog("Usuario Registrado: "+user.getUsuario());  
             crearArchivoMsj(user.getUsername());
                return exito;
         }else{
             
             insertLog("Error Registrar: "+user.getUsuario());  
             return "<sesion id=\"correo\">\n" +
                    "<Error> Usuario ya existe </Error>\n" +
                    "</sesion>";
         }
                // System.out.pringettln("existe");            
         }else{
              return "<sesion id=\"correo\">\n" +
                    "<Error> Error procesar parser </Error>\n" +
                    "</sesion>";
         }
         

    }
    
    public void crearArchivoMsj(String username) {

     //   String[] nombre = usuario.split("@");
        
        String sFichero = dir_mensajes+username+ ".xml";
        File fichero = new File(sFichero);

        if (!fichero.exists()) {
            
            
            try {
                // A partir del objeto File creamos el fichero físicamente
                if (fichero.createNewFile()) {
                     insertLog("El archivo de mensajes de "+ username +" se ha creado correctamente");
                } else {
                     insertLog("No ha podido ser creado el archivo");
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
           
        }

    }
    
    public LinkedList<usuario> getListaUsuarios(){
    
      parser p =  compilar(leerArchivo(usuarios_xml));
        
      return p.listaUsuarios;    
    }
    
     public int comprobarUsuario(LinkedList<usuario> lista, String usuario){
        
       
         
       //    if (s.listaU.size() > 0) {
            System.out.println("####USUARIOS ----");

            Iterator<usuario> itU = lista.iterator(); /*
             * Listar los errores que se han guardado en la variable lista
             */

            while (itU.hasNext()) {
                usuario listaU = itU.next();
              //  System.out.println("User: " + listaU.usuario + " Nombre :" + listaU.nombre + " Clave: " + listaU.clave);
                System.out.println("User: " + listaU.usuario + " USer2 :" + usuario );
               
                if (listaU.getUsuario().equals(usuario)) {
                    return 1;
                }
            }
            return 0;
        //}
       // return 1;
    }
     
     public void actualizarListaUsuarios(LinkedList<usuario> lista, usuario usuario){
        
        String contenido="<usuarios>\n";
        

    Iterator<usuario> itU = lista.iterator(); /*
             * Listar los errores que se han guardado en la variable lista
             */
             System.out.println("Nuevos Usuarios");
            while (itU.hasNext()) {
                usuario listaU = itU.next();
                contenido+="<usuario>\n<usuario>" + listaU.usuario + "</usuario>\n<nombre>" + listaU.nombre + "</nombre>\n<fecha>" + listaU.fecha+"</fecha>\n<clave>"+listaU.clave+"</clave>\n</usuario>\n";
              
            }
            contenido+="<usuario>\n<usuario>" + usuario.usuario + "</usuario>\n<nombre>" + usuario.nombre + "</nombre>\n<fecha>" + usuario.fecha+"</fecha>\n<clave>"+usuario.clave+"</clave>\n</usuario>\n";
            contenido+="</usuarios>";
            
            System.out.println("update lista: "+contenido);
            escribirArchivo(usuarios_xml, contenido);
    }
    
     public void escribirArchivo(String archivo, String contenido){
         FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(archivo);
            pw = new PrintWriter(fichero);
 
            
                pw.print(contenido);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
     
    public static String leerArchivo(String archivo){
     String contenido="";
        try{
            // Abrimos el archivo
            FileInputStream fstream = new FileInputStream(archivo);
            // Creamos el objeto de entrada
            DataInputStream entrada = new DataInputStream(fstream);
            // Creamos el Buffer de Lectura
            BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
            String strLinea;
           
            // Leer el archivo linea por linea
            while ((strLinea = buffer.readLine()) != null)   {
                // Imprimimos la línea por pantalla
                contenido+=strLinea;
              //  System.out.println (strLinea);
            }
            // Cerramos el archivo
            entrada.close();
        }catch (Exception e){ //Catch de excepciones
            System.err.println("Ocurrio un error: " + e.getMessage());
        }
        System.out.println("usuarios:"+contenido);
        
        return contenido;
    
    }
    
    public parser compilar(String content){
        LinkedList<Errores> lista = new LinkedList<Errores>();
        parser s=null;
        String Salida = "####Despues de la gramatica: \n";

        System.out.println("*************************************");
        System.out.println("####Archivo de entrada: \n" + content);
        try {
            scanner scan = new scanner(new BufferedReader(new StringReader(content)));
            scan.lista = lista;
            s = new parser(scan);
            s.lista = scan.lista;
            s.Salida = Salida;
            s.parse();
            
        } catch (Exception ex) {
        }
        System.out.println("####Errores ----");
        Iterator<Errores> it = lista.iterator(); /*
         * Listar los errores que se han guardado en la variable lista
         */
        while (it.hasNext()) {
            Errores error = it.next();
            
            insertLog("Linea: " + error.Linea + " Columna :" + error.Columna + " Descr: " + error.Descripcion); 
            System.out.println("Linea: " + error.Linea + " Columna :" + error.Columna + " Descr: " + error.Descripcion);
        }  
          
        
        return s;
    }
    
    
    public void insertLog(String log){
    
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy , HH:mm:ss");
        Date date = new Date();
      //  System.out.println(dateFormat.format(date));
        String lineaLog = dateFormat.format(date)+" , "+log;
        
        escribirLog(dir+"BitacoraServidorA.txt", lineaLog);
    }
    
     public void escribirLog(String archivo, String contenido){
         FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(archivo, true);
            pw = new PrintWriter(fichero);
 
            
                pw.println(contenido);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
    
     
     public String iniciarSesion(String content){
    
         System.out.println("entro"+content);
       usuario user = compilar(content).usuario;
     
         if(user.getUsuario() != null){
                    
                      LinkedList<usuario> listaUsuarios= getListaUsuarios();
                      
         if (comprobarSesion(listaUsuarios, user.getUsuario(), user.getClave())==1){
             
                    insertLog("Session iniciada: "+user.getUsuario());   
                    return user.getUsuario();
               //  return "<sesion id=\"correo\">\n" +
                  //      "<Registro> Session iniciada </Registro>\n" +
                 //       "</sesion>";
         }else{
             insertLog("Usuario : "+user.getUsuario() +"intento iniciar session");  
             return "";
           //  return "<sesion id=\"correo\">\n" +
                 //   "<Error> Verifique credenciales </Error>\n" +
                 //   "</sesion>";
         }
                // System.out.println("existe");            
         }else{
             return "";
            //  return "<sesion id=\"correo\">\n" +
                //    "<Error> Error procesar parser </Error>\n" +
               //     "</sesion>";
         }
        
       // return content;
    
    }
     
     public  int comprobarSesion(LinkedList<usuario> lista, String usuario, String clave){
        
       //    if (s.listaU.size() > 0) {
            System.out.println("####USUARIOS ----");

            Iterator<usuario> itU = lista.iterator(); /*
             * Listar los errores que se han guardado en la variable lista
             */

            while (itU.hasNext()) {
                usuario listaU = itU.next();
              //  System.out.println("User: " + listaU.usuario + " Nombre :" + listaU.nombre + " Clave: " + listaU.clave);
                System.out.println("User: " + listaU.usuario + " User2 :" + usuario );
               
                if (listaU.getUsuario().equals(usuario) && listaU.getClave().equals(clave)) {
                    return 1;
                }
            }
            return 0;
        //}
       // return 1;
    }
     
     public usuario getUsuario(String username){
         
         LinkedList<usuario> lista= getListaUsuarios();
         usuario usuario;
          Iterator<usuario> itU = lista.iterator(); /*
             * Listar los errores que se han guardado en la variable lista
             */

            while (itU.hasNext()) {
                usuario listaU = itU.next();
              //  System.out.println("User: " + listaU.usuario + " Nombre :" + listaU.nombre + " Clave: " + listaU.clave);
                System.out.println("User: " + listaU.usuario + " User2 :" + username );
            //   String usuario, String username, String nombre, String fecha, String clave
                if (listaU.getUsuario().equals(username)) {
                    usuario = new usuario(listaU.getUsuario(), listaU.getUsername(), listaU.getNombre(), listaU.getFecha(), listaU.getClave(), listaU.getEstado());
                    return usuario;
                }
            }
         
         return null;
     
     }
     
     
     public contacto getContacto(String username){
         
         String username2[]  = username.split("@");
         LinkedList<contacto> lista= getListaContactos(username2[0]);
         contacto contacto;
          Iterator<contacto> itC = lista.iterator(); /*
             * Listar los errores que se han guardado en la variable lista
             */

            while (itC.hasNext()) {
                contacto listaC = itC.next();
              //  System.out.println("User: " + listaU.usuario + " Nombre :" + listaU.nombre + " Clave: " + listaU.clave);
              System.out.println("User: " + listaC.usuario + " User2 :" + username );
            //   String usuario, String username, String nombre, String fecha, String clave
                if (listaC.getUsuario().equals(username)) {
                     System.out.println("Encotro: User: " + listaC.usuario + " User2 :" + username );
                    contacto = new contacto(listaC.getUsuario(), listaC.getNombre(), listaC.getEstado(), listaC.getInSession());
                    return contacto;
                }
            }
         
         return null;
     
     }
     
     public LinkedList<contacto> getListaContactos(String username){
        
        
        
        //LinkedList<correo> listaCorreos = compilar(content).listaCorreos;
        String content = leerArchivo(dir_contactos+username+ ".xml");
         System.out.println("archivo: "+dir_contactos+username+", contenido:"+content);
        if (content.length()>0){
       LinkedList<contacto> listaContactos= compilar(content).listaContactos;
         return listaContactos;
        }else{
        return null;
        }  

    }
     
     
      public LinkedList<solicitud> getListaSolicitudes(String username){
        
        
        
        //LinkedList<correo> listaCorreos = compilar(content).listaCorreos;
        String content = leerArchivo(dir_solicitudes+username+ ".xml");
          System.out.println("archivo: "+dir_solicitudes+username+", contenido2:"+content);
        if (content.length()>0){
       LinkedList<solicitud> listaSolicitudes= compilar(content).listaSolicitudes;
         return listaSolicitudes;
        }else{
        return null;
        }  

    }
     
     public LinkedList<correo> getListaCorreo(String username){
        
        
        
        //LinkedList<correo> listaCorreos = compilar(content).listaCorreos;
        
// LinkedList<correo> listaCorreos= compilar(leerArchivo(dir_mensajes+username+ ".xml")).listaCorreos;
        
      // String listaM = getCorreos(listaCorreos, usuario, nombre);
        
     //   return listaCorreos;
         return null;
    
    }
    
    public String getCorreos(LinkedList<correo> listaCorreos, String usuario, String nombre){
    
        System.out.println("####MENSAJES ----");

            Iterator<correo> itC = listaCorreos.iterator(); /*
             * Listar los errores que se han guardado en la variable lista
             */

            String xml="<sesion id=\"correo\" tipo=\"lista\">\n";
/*
 public int no;
    public String usuario;
    public String nombre_usuario;  
    public String asunto;
    public String fecha;
    public String de;
    public String nombre_de;
    public String contenido;
    public String archivo;*/
            
            while (itC.hasNext()) {
                correo listaC = itC.next();
              //  System.out.println("User: " + listaU.usuario + " Nombre :" + listaU.nombre + " Clave: " + listaU.clave);
               // System.out.println("User: " + listaU.usuario + " User2 :" + usuario );
               //xml+=listaM.getAsunto()+"-"+listaM.getContenido();
                xml += "<correo>\n" +
                    "<usuario>"+usuario+"</usuario>\n" +
                    "<nombre>"+nombre+"</nombre>\n" +
                    "<asunto> "+listaC.asunto+"</asunto>\n" +
                    "<fecha>"+listaC.fecha+"</fecha>\n" +
                    "<de>"+listaC.de+"</de>\n" +
                    "<nombre>"+listaC.nombre_de+"</nombre>\n" +
                    "</correo>\n";
                
//if (listaU.getUsuario().equals(usuario) && listaU.getClave().equals(clave)) {
               //     return 1;
                }
            xml+="</sesion>";
            
           // return 0;
    
    return xml;
    }
    
    public String getCorreo(LinkedList<correo> listaCorreos, String usuario, String de_username, String de_fecha){
    
      //  System.out.println("####MENSAJES ----");

            Iterator<correo> itC = listaCorreos.iterator(); /*
             * Listar los errores que se han guardado en la variable lista
             */

            String xml="";
/*
 public int no;
    public String usuario;
    public String nombre_usuario;  
    public String asunto;
    public String fecha;
    public String de;
    public String nombre_de;
    public String contenido;
    public String archivo;*/
            
            while (itC.hasNext()) {
                correo listaC = itC.next();
              //  System.out.println("User: " + listaU.usuario + " Nombre :" + listaU.nombre + " Clave: " + listaU.clave);
               // System.out.println("User: " + listaU.usuario + " User2 :" + usuario );
               //xml+=listaM.getAsunto()+"-"+listaM.getContenido();
               if ( listaC.de.contains(de_username)&& listaC.fecha.contains(de_fecha)){
               xml += "<correo>\n" +
                    "<usuario>"+usuario+"</usuario>\n" +
                    "<asunto>"+listaC.asunto+"</asunto>\n" +
                    "<fecha>"+listaC.fecha+"</fecha>\n" +
                    "<de>"+listaC.de+"</de>\n" +
                    "<contenido>"+listaC.contenido+"</contenido>\n" +
                    "<archivo>"+listaC.archivo+"</archivo>\n" +
                    "</correo>";
               }
                
                
                
//if (listaU.getUsuario().equals(usuario) && listaU.getClave().equals(clave)) {
               //     return 1;
                }
           // xml+="</sesion>";
            
           // return 0;
    
    return xml;
    }
    
   public void actualizarContactos(LinkedList<contacto> lista, usuario usuario, String username){
    /*   
<contactos>
<contacto>
<usuario> Usuario2@servidorA.com </usuario>
<nombre> nombre2 </nombre>
<estado> Ocupado </estado>
</contacto>
</contactos>
*/
        
       String contenido="<contactos>\n";
        

    /*
             * Listar los errores que se han guardado en la variable lista
             */
        //     System.out.println("Nuevos Usuarios");
       contenido+="<contacto>\n<usuario>" + usuario.usuario+ "</usuario>\n<nombre>" + usuario.nombre+ "</nombre>\n<estado>Disponible</estado>\n</contacto>\n";
            if (lista!=null){ 
                Iterator<contacto> itC = lista.iterator(); 
            
            while (itC.hasNext()) {
                contacto listaC = itC.next();
                contenido+="<contacto>\n<usuario>" + listaC.getUsuario() + "</usuario>\n<nombre>" + listaC.getNombre() + "</nombre>\n<estado>" +listaC.getEstado()+"</estado>\n</contacto>\n";
        
               // contenido+="<correo>\n<asunto>" + listaC.asunto + "</asunto>\n<fecha>" + listaC.fecha + "</fecha>\n<de>" + listaC.de+"</de>\n<nombre>"+listaC.nombre_de+"</nombre>\n<contenido>"+listaC.contenido+"</contenido>\n<archivo></archivo>\n</correo>\n";
              
            }
            }
           // contenido+="<usuario>\n<usuario>" + correo_envio + "</usuario>\n<nombre>" + correo_envio.nombre + "</nombre>\n<fecha>" + correo_envio.fecha+"</fecha>\n<clave>"+correo_envio.clave+"</clave>\n</usuario>\n";
            contenido+="</contactos>";
            
            System.out.println("update lista: "+contenido);
            escribirArchivo(dir_contactos+username+ ".xml", contenido);
    }

   
    public void actualizarSolicitudes(LinkedList<solicitud> lista, usuario usuario, String username){
    /*   
<contactos>
<contacto>
<usuario> Usuario2@servidorA.com </usuario>
<nombre> nombre2 </nombre>
<estado> Ocupado </estado>
</contacto>
</contactos>
*/
        
       String contenido="<solicitudes>\n";
        

    /*
             * Listar los errores que se han guardado en la variable lista
             */
        //     System.out.println("Nuevos Usuarios");
       contenido+="<solicitud>\n<usuario>" + usuario.usuario+ "</usuario>\n<nombre>" + usuario.nombre+ "</nombre>\n</solicitud>\n";
       if (lista!=null){     
       Iterator<solicitud> itC = lista.iterator(); 
            while (itC.hasNext()) {
                solicitud listaC = itC.next();
                contenido+="<solicitud>\n<usuario>" + listaC.getUsuario() + "</usuario>\n<nombre>" + listaC.getNombre() + "</nombre>\n</solicitud>\n";
        
               // contenido+="<correo>\n<asunto>" + listaC.asunto + "</asunto>\n<fecha>" + listaC.fecha + "</fecha>\n<de>" + listaC.de+"</de>\n<nombre>"+listaC.nombre_de+"</nombre>\n<contenido>"+listaC.contenido+"</contenido>\n<archivo></archivo>\n</correo>\n";
              
            }
       }
           // contenido+="<usuario>\n<usuario>" + correo_envio + "</usuario>\n<nombre>" + correo_envio.nombre + "</nombre>\n<fecha>" + correo_envio.fecha+"</fecha>\n<clave>"+correo_envio.clave+"</clave>\n</usuario>\n";
            contenido+="</solicitudes>";
            
            System.out.println("update lista: "+contenido);
            escribirArchivo(dir_solicitudes+username+ ".xml", contenido);
    }
    
    public void actualizarSolicitudes2(LinkedList<solicitud> lista, String username){
    /*   
<contactos>
<contacto>
<usuario> Usuario2@servidorA.com </usuario>
<nombre> nombre2 </nombre>
<estado> Ocupado </estado>
</contacto>
</contactos>
*/
        
       
        

    /*
             * Listar los errores que se han guardado en la variable lista
             */
           System.out.println("Lista Size"+lista.size());
       //contenido+="<solicitud>\n<usuario>" + usuario.usuario+ "</usuario>\n<nombre>" + usuario.nombre+ "</nombre>\n</solicitud>\n";
       if (lista.size()>0){  
           String contenido="<solicitudes>\n";
       Iterator<solicitud> itC = lista.iterator(); 
            while (itC.hasNext()) {
                solicitud listaC = itC.next();
                contenido+="<solicitud>\n<usuario>" + listaC.getUsuario() + "</usuario>\n<nombre>" + listaC.getNombre() + "</nombre>\n</solicitud>\n";
        
               // contenido+="<correo>\n<asunto>" + listaC.asunto + "</asunto>\n<fecha>" + listaC.fecha + "</fecha>\n<de>" + listaC.de+"</de>\n<nombre>"+listaC.nombre_de+"</nombre>\n<contenido>"+listaC.contenido+"</contenido>\n<archivo></archivo>\n</correo>\n";
              
            }
             contenido+="</solicitudes>";
             System.out.println("update lista: "+contenido);
            escribirArchivo(dir_solicitudes+username+ ".xml", contenido);
       }else{
            escribirArchivo(dir_solicitudes+username+ ".xml", "");
       }
           // contenido+="<usuario>\n<usuario>" + correo_envio + "</usuario>\n<nombre>" + correo_envio.nombre + "</nombre>\n<fecha>" + correo_envio.fecha+"</fecha>\n<clave>"+correo_envio.clave+"</clave>\n</usuario>\n";
           
            
            
    }

    public int verificarContacto(String contacto1, String contacto2){
    
         String username2[]  = contacto1.split("@");
         LinkedList<contacto> lista= getListaContactos(username2[0]);
        // contacto contacto;
          Iterator<contacto> itC = lista.iterator(); /*
             * Listar los errores que se han guardado en la variable lista
             */

            while (itC.hasNext()) {
                contacto listaC = itC.next();
              //  System.out.println("User: " + listaU.usuario + " Nombre :" + listaU.nombre + " Clave: " + listaU.clave);
              System.out.println("User: " + listaC.usuario + " User2 :" + contacto2 );
            //   String usuario, String username, String nombre, String fecha, String clave
                if (listaC.getUsuario().equals(contacto2)) {
                     System.out.println("Encotro: User: " + listaC.usuario + " User2 :" + contacto2 );
                  //  contacto = new contacto(listaC.getUsuario(), listaC.getNombre(), listaC.getEstado(), listaC.getInSession());
                    return 1;
                }
            }
        
    return 0;
    }
     
    
}
