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
public class FormaVenta {
    private int  idFormaVenta;
    private String descripcion;

    public int getIdFormaVenta() {
        return idFormaVenta;
    }

    public void setIdFormaVenta(int idFormaVenta) {
        this.idFormaVenta = idFormaVenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public FormaVenta(int idFormaVenta, String descripcion) {
        this.idFormaVenta = idFormaVenta;
        this.descripcion = descripcion;
    }

    public FormaVenta() {
    }

    @Override
    public String toString() {
        return "FormaVenta{" + "idFormaVenta=" + idFormaVenta + ", descripcion=" + descripcion + '}';
    }
    
    
}
