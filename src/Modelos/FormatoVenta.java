/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Flor
 */
public class FormatoVenta {
    private int codigo;
    private String descripcion;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public FormatoVenta(int codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public FormatoVenta() {
    }
    

    @Override
    public String toString() {
        return "FormatoVenta{" + "codigo=" + codigo + ", descripcion=" + descripcion + '}';
    }
    
    
}
