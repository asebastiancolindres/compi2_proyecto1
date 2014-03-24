/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cliente_correo;

import servidor_a.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import parser_correo.Errores;
import parser_correo.correo;
import parser_correo.parser;
import parser_correo.scanner;


/**
 *
 * @author sebastian
 */
public class cliente {
    public static String DS  = File.separator;
    public static String dir = System.getProperty("user.dir")+DS+"src"+DS+"archivosXML"+DS;
    
    //parser s;
    public String procesarMsjCuenta(String msj){
    
        parser s = compilar(msj);
        
        return s.msjCuenta;
        
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
    
   /* public LinkedList<listaMensajes> getListaMensajes(String content){
    
       parser s = compilar(content);
        
        return s.listaM;
        
    }*/
    
    public parser compilar(String content){
        LinkedList<Errores> lista = new LinkedList<Errores>();
        
        String Salida = "####Despues de la gramatica: \n";
        parser s= null;
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
    
    
}
