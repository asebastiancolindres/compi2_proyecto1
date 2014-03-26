/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package parser_chat;

/**
 *
 * @author scolindres
 */
public class mensaje {
    
    public String emisor;
    public String emisor_nombre;
    public String destinatario;
    public String contenido;
    public String fecha;

    public mensaje(String emisor, String emisor_nombre, String destinatario, String contenido, String fecha) {
        this.emisor = emisor;
        this.emisor_nombre = emisor_nombre;
        this.destinatario = destinatario;
        this.contenido = contenido;
        this.fecha = fecha;
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    public String getEmisor_nombre() {
        return emisor_nombre;
    }

    public void setEmisor_nombre(String emisor_nombre) {
        this.emisor_nombre = emisor_nombre;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
}
