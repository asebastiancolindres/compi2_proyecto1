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
public class contacto {
    
    public String usuario;
    public String nombre;
    public String estado;
    public int inSession;

    public contacto(String usuario, String nombre, String estado, int inSession) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.estado = estado;
        this.inSession = inSession;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getInSession() {
        return inSession;
    }

    public void setInSession(int inSession) {
        this.inSession = inSession;
    }
    
    
    
    
}
