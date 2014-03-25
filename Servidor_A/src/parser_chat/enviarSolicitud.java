/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package parser_chat;

/**
 *
 * @author sebastian
 */
public class enviarSolicitud {
    
    public String destinatario_usuario;
    public String emisor_usuario;
    public String emisor_nombre;
    public String respuesta;

    public enviarSolicitud(String destinatario_usuario, String emisor_usuario, String emisor_nombre, String respuesta) {
        this.destinatario_usuario = destinatario_usuario;
        this.emisor_usuario = emisor_usuario;
        this.emisor_nombre = emisor_nombre;
        this.respuesta = respuesta;
    }

    public String getDestinatario_usuario() {
        return destinatario_usuario;
    }

    public void setDestinatario_usuario(String destinatario_usuario) {
        this.destinatario_usuario = destinatario_usuario;
    }

    public String getEmisor_usuario() {
        return emisor_usuario;
    }

    public void setEmisor_usuario(String emisor_usuario) {
        this.emisor_usuario = emisor_usuario;
    }

    public String getEmisor_nombre() {
        return emisor_nombre;
    }

    public void setEmisor_nombre(String emisor_nombre) {
        this.emisor_nombre = emisor_nombre;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

   
}
