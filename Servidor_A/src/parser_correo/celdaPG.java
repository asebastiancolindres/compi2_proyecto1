/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package parser_correo;

/**
 *
 * @author sebastian
 */
public class celdaPG {
    public String fila;
    public String columna;
    public String color;

    public celdaPG(String fila, String columna, String color) {
        this.fila = fila;
        this.columna = columna;
        this.color = color;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public String getColumna() {
        return columna;
    }

    public void setColumna(String columna) {
        this.columna = columna;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

   
    
    
}
