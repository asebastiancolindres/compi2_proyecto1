/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser_correo;

/**
 *
 * @author lucita
 */
public class Errores {

    public Integer Linea;
    public Integer Columna;
    public String Descripcion;

    public Errores(Integer Linea, Integer Columna, String Descripcion) {
        this.Linea = Linea;
        this.Columna = Columna;
        this.Descripcion = Descripcion;
    }

    /**
     * Get the value of Descripcion
     *
     * @return the value of Descripcion
     */
    public String getDescripcion() {
        return Descripcion;
    }

    /**
     * Set the value of Descripcion
     *
     * @param Descripcion new value of Descripcion
     */
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    /**
     * Get the value of Columna
     *
     * @return the value of Columna
     */
    public Integer getColumna() {
        return Columna;
    }

    /**
     * Set the value of Columna
     *
     * @param Columna new value of Columna
     */
    public void setColumna(Integer Columna) {
        this.Columna = Columna;
    }


    /**
     * Get the value of Linea
     *
     * @return the value of Linea
     */
    public Integer getLinea() {
        return Linea;
    }

    /**
     * Set the value of Linea
     *
     * @param Linea new value of Linea
     */
    public void setLinea(Integer Linea) {
        this.Linea = Linea;
    }


}
