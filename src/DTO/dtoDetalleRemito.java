/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import Modelos.FormaVenta;
import Modelos.Producto;
import Modelos.TipoMovimiento;

/**
 *
 * @author rodri
 */
public class dtoDetalleRemito {
    private int cantidad;
    private Producto producto;
    private FormaVenta formaVenta;

    public dtoDetalleRemito(int cantidad, Producto producto, FormaVenta formaVenta) {
        this.cantidad = cantidad;
        this.producto = producto;
        this.formaVenta = formaVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public FormaVenta getFormaVenta() {
        return formaVenta;
    }

    public void setFormaVenta(FormaVenta formaVenta) {
        this.formaVenta = formaVenta;
    }

    @Override
    public String toString() {
        return "dtoDetalleRemito{" + "cantidad=" + cantidad + ", producto=" + producto + ", formaVenta=" + formaVenta + '}';
    }
    

    
}
