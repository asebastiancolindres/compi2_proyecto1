/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servidor_a;

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
import parser.Errores;
import parser.listaMensajes;
import parser.listaUsuarios;
import parser.parser;
import parser.scanner;

/**
 *
 * @author sebastian
 */
public class Servidor_A {
    
    public static parser s;
    
    public static String DS  = File.separator;
    public static String dir = System.getProperty("user.dir")+DS+"src"+DS+"archivosXML"+DS;
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        new loginCorreo().setVisible(true);
        

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
    
          compilar(content);
     
         if(s.usuario.getUsuario() != null){
                      String usuario = s.usuario.getUsuario();
                      String clave = s.usuario.getClave();
                      
                      getListaUsuarios();
         if (comprobarSesion(usuario, clave)==1){
             
                    insertLog("Session iniciada: "+usuario);            
                 return "<sesion id=\"correo\">\n" +
                        "<Registro> Session iniciada </Registro>\n" +
                        "</sesion>";
         }else{
             insertLog("Usuario : "+usuario +"intento iniciar session");  
             return "<sesion id=\"correo\">\n" +
                    "<Error> Verifique credenciales </Error>\n" +
                    "</sesion>";
         }
                // System.out.println("existe");            
         }else{
              return "<sesion id=\"correo\">\n" +
                    "<Error> Error procesar parser </Error>\n" +
                    "</sesion>";
         }
        
       // return content;
    
    }
    
    public  String crearCuenta(String content){
   //  System.out.println("cotnent:"+content); 
        
        String exito = "<sesion id=\"correo\">\n" +
                        "<Registro> Usuario registrado </Registro>\n" +
                        "</sesion>";

         compilar(content);
     
         if(s.usuario.getUsuario() != null){
                      String usuario = s.usuario.getUsuario();
                      String nombre = s.usuario.getNombre();
                      String fecha = s.usuario.getFecha();
                      String clave = s.usuario.getClave();
                      
                      listaUsuarios lu = new listaUsuarios();
                      lu.setNombre(nombre);
                      lu.setFecha(fecha);
                      lu.setClave(clave);
                      lu.setUsuario(usuario);
                      
            getListaUsuarios();
         if (comprobarUsuario(usuario)==0){
             
             s.listaU.add(lu);
             actualizarListaUsuarios();
             insertLog("Usuario Registrado: "+usuario);  
             crearArchivoMsj(nombre);
                 return exito;
         }else{
             
             insertLog("Error Registrar: "+usuario);  
             return "<sesion id=\"correo\">\n" +
                    "<Error> Usuario ya existe </Error>\n" +
                    "</sesion>";
         }
                // System.out.println("existe");            
         }else{
              return "<sesion id=\"correo\">\n" +
                    "<Error> Error procesar parser </Error>\n" +
                    "</sesion>";
         }
         

    }
    
    public void crearArchivoMsj(String usuario) {

        String[] nombre = usuario.split("@");
        
        String sFichero = dir + "mensajes"+DS+nombre[0]+ ".xml";
        File fichero = new File(sFichero);

        if (!fichero.exists()) {
            
            
            try {
                // A partir del objeto File creamos el fichero físicamente
                if (fichero.createNewFile()) {
                     insertLog("El archivo de mensajes de "+ nombre +" se ha creado correctamente");
                } else {
                     insertLog("No ha podido ser creado el archivo");
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
           
        }

    }
    
    public void actualizarListaUsuarios(){
        
        String contenido="<usuarios>\n";
        

    Iterator<listaUsuarios> itU = s.listaU.iterator(); /*
             * Listar los errores que se han guardado en la variable lista
             */
             System.out.println("Nuevos Usuarios");
            while (itU.hasNext()) {
                listaUsuarios listaU = itU.next();
                contenido+="<usuario>\n<usuario>" + listaU.usuario + "</usuario>\n<nombre>" + listaU.nombre + "</nombre>\n<fecha>" + listaU.fecha+"</fecha>\n<clave>"+listaU.clave+"</clave>\n</usuario>\n";
              
            }
            contenido+="</usuarios>";
            
            System.err.println("cont: "+contenido);
            escribirArchivo(dir+"UsuariosServidorA.xml", contenido);
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
    
    public static int comprobarUsuario(String usuario){
        
       //    if (s.listaU.size() > 0) {
            System.out.println("####USUARIOS ----");

            Iterator<listaUsuarios> itU = s.listaU.iterator(); /*
             * Listar los errores que se han guardado en la variable lista
             */

            while (itU.hasNext()) {
                listaUsuarios listaU = itU.next();
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
    
    public static int comprobarSesion(String usuario, String clave){
        
       //    if (s.listaU.size() > 0) {
            System.out.println("####USUARIOS ----");

            Iterator<listaUsuarios> itU = s.listaU.iterator(); /*
             * Listar los errores que se han guardado en la variable lista
             */

            while (itU.hasNext()) {
                listaUsuarios listaU = itU.next();
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
    
    public void getListaUsuarios(){
    
        compilar(leerArchivo(dir+"UsuariosServidorA.xml"));
        
        
        
        
    
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
        
        return contenido;
    
    }
    
    public String getListaMensajes(String content){
        
        compilar(content);
        
        String usuario = s.lUsuario;
         String[] nombre = usuario.split("@");
        
        compilar(leerArchivo(dir + "mensajes"+DS+nombre[0]+ ".xml"));
        
        String listaM = getMensajes(usuario, nombre[0]);
        
        return listaM;
    
    }
    
    public String getMensajes(String usuario, String nombre){
    
        System.out.println("####MENSAJES ----");

            Iterator<listaMensajes> itM = s.listaM.iterator(); /*
             * Listar los errores que se han guardado en la variable lista
             */

            String xml="<sesion id=\"correo\" tipo=\"lista_\">\n";


            
            while (itM.hasNext()) {
                listaMensajes listaM = itM.next();
              //  System.out.println("User: " + listaU.usuario + " Nombre :" + listaU.nombre + " Clave: " + listaU.clave);
               // System.out.println("User: " + listaU.usuario + " User2 :" + usuario );
               //xml+=listaM.getAsunto()+"-"+listaM.getContenido();
                xml += "<correo>\n" +
                    "<usuario>"+usuario+"</usuario>\n" +
                    "<nombre>"+nombre+"</nombre>\n" +
                    "<asunto> "+listaM.getAsunto()+"</asunto>\n" +
                    "<fecha>"+listaM.getFecha()+"</fecha>\n" +
                    "<de>"+listaM.getEmisor()+"</de>\n" +
                    "<nombre>"+listaM.getNombre()+"</nombre>\n" +
                    "</correo>\n";
                
//if (listaU.getUsuario().equals(usuario) && listaU.getClave().equals(clave)) {
               //     return 1;
                }
            xml+="</sesion>";
            
           // return 0;
    
    return xml;
    }
    
    public String getMensaje(String content){
        
        compilar(content);
        
        
        
    return content;
    }
    
    public void compilar(String content){
        LinkedList<Errores> lista = new LinkedList<Errores>();
        
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
          
        
        //return 0;
    }
    
}
