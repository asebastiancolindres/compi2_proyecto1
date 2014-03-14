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
public class listaMensajes {
    
    public String correo_d;
    public String nombre_d;

    public String getCorreo_d() {
        return correo_d;
    }

    public void setCorreo_d(String correo_d) {
        this.correo_d = correo_d;
    }

    public String getNombre_d() {
        return nombre_d;
    }

    public void setNombre_d(String nombre_d) {
        this.nombre_d = nombre_d;
    }
    public String asunto;
    public String fecha;
    public String emisor;
    public String nombre;
    public String contenido;
    public String archivo;

    
    public listaMensajes(String correo_d, String nombre_d, String asunto, String fecha, String emisor, String nombre, String contenido, String archivo) {
        this.correo_d = correo_d;
        this.nombre_d = nombre_d;
        this.asunto = asunto;
        this.fecha = fecha;
        this.emisor = emisor;
        this.nombre = nombre;
        this.contenido = contenido;
        this.archivo = archivo;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }
 
    
    
}
