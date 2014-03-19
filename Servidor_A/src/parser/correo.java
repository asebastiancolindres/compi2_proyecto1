/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package parser;

/**
 *
 * @author sebastian
 */
public class correo {
    
    public int no;
    public String usuario;
    public String nombre_usuario;  
    public String asunto;
    public String fecha;
    public String de;
    public String nombre_de;
    public String contenido;
    public String archivo;

    public correo(int no, String usuario, String nombre_usuario, String asunto, String fecha, String de, String nombre_de, String contenido, String archivo) {
        this.no = no;
        this.usuario = usuario;
        this.nombre_usuario = nombre_usuario;
        this.asunto = asunto;
        this.fecha = fecha;
        this.de = de;
        this.nombre_de = nombre_de;
        this.contenido = contenido;
        this.archivo = archivo;
    }
    

   
    
    
}
