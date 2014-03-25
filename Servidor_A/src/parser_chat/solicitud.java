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
public class solicitud {
    
    public String usuario;
    public String nombre;
    public int activa;

    public solicitud(String usuario, String nombre, int activa) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.activa = activa;
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

    public int getActiva() {
        return activa;
    }

    public void setActiva(int activa) {
        this.activa = activa;
    }
    
    
}
