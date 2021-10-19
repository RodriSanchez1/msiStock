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
public class Stock {
    private int idStock;
    private int codProducto;
    private int cantidad;
    private Ubicacion ubicacion;
    private FormaVenta formaVenta;

    public int getIdStock() {
        return idStock;
    }

    public void setIdStock(int idStock) {
        this.idStock = idStock;
    }

    public int getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

   
    public Stock(int idStock, int codProducto, int cantidad, Ubicacion ubicacion, FormaVenta formaVenta) {
        this.idStock = idStock;
        this.codProducto = codProducto;
        this.cantidad = cantidad;
        this.ubicacion = ubicacion;
        this.formaVenta = formaVenta;
    }

    public Stock() {
    }

    @Override
    public String toString() {
        return "Stock{" + "idStock=" + idStock + ", codProducto=" + codProducto + ", cantidad=" + cantidad + ", ubicacion=" + ubicacion + ", formaVenta=" + formaVenta + '}';
    }
    
    
}
