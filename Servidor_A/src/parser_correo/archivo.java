/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package parser_correo;

import java.util.LinkedList;

/**
 *
 * @author sebastian
 */
public class archivo {
    
    public String tipo;
    public String tamanio;
    public LinkedList<celdaPG> celdas;

    public archivo(String tipo, String tamanio, LinkedList<celdaPG> celdas) {
        this.tipo = tipo;
        this.tamanio = tamanio;
        this.celdas = celdas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public LinkedList<celdaPG> getCeldas() {
        return celdas;
    }

    public void setCeldas(LinkedList<celdaPG> celdas) {
        this.celdas = celdas;
    }
    
    
}
