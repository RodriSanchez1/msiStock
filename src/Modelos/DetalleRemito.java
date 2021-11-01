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
public class DetalleRemito {
    private int nroRemito;
    private int idDetalle;
    private int cantidad;
    private Stock stock;

    public int getNroRemito() {
        return nroRemito;
    }

    public void setNroRemito(int nroRemito) {
        this.nroRemito = nroRemito;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public DetalleRemito(int nroRemito, int idDetalle, int cantidad, Stock stock) {
        this.nroRemito = nroRemito;
        this.idDetalle = idDetalle;
        this.cantidad = cantidad;
        this.stock = stock;
    }

    public DetalleRemito() {
    }

    @Override
    public String toString() {
        return "DetalleRemito{" + "nroRemito=" + nroRemito + ", idDetalle=" + idDetalle + ", cantidad=" + cantidad + ", stock=" + stock + '}';
    }
    
    
    
}
