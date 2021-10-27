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
    private Producto producto;
    private int cantidad;
    private Ubicacion ubicacion;
    private FormaVenta formaVenta;

    public int getIdStock() {
        return idStock;
    }

    public void setIdStock(int idStock) {
        this.idStock = idStock;
    }

    public Producto getProducto() {
        return producto;
    }



    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

  

    public FormaVenta getFormaVenta() {
        return formaVenta;
    }

   

    public Stock(int idStock, Producto producto, int cantidad, Ubicacion ubicacion, FormaVenta formaVenta) {
        this.idStock = idStock;
        this.producto = producto;
        this.cantidad = cantidad;
        this.ubicacion = ubicacion;
        this.formaVenta = formaVenta;
    }

    @Override
    public String toString() {
        return "Stock{" + "idStock=" + idStock + ", producto=" + producto + ", cantidad=" + cantidad + ", ubicacion=" + ubicacion + ", formaVenta=" + formaVenta + '}';
    }

  
}
