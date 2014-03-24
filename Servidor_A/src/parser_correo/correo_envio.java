/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package parser_correo;

import java.util.LinkedList;

/**
 *
 * @author scolindres
 */
public class correo_envio {
    public String usuario;
    public LinkedList<String> destinatarios;
    public String asunto;
    public String fecha;
    public String contenido;
    public String archivos;

    public correo_envio(String usuario, LinkedList<String> destinatarios, String asunto, String fecha, String contenido, String archivos) {
        this.usuario = usuario;
        this.destinatarios = destinatarios;
        this.asunto = asunto;
        this.fecha = fecha;
        this.contenido = contenido;
        this.archivos = archivos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public LinkedList<String> getDestinatarios() {
        return destinatarios;
    }

    public void setDestinatarios(LinkedList<String> destinatarios) {
        this.destinatarios = destinatarios;
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

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getArchivos() {
        return archivos;
    }

    public void setArchivos(String archivos) {
        this.archivos = archivos;
    }
    
    
}
