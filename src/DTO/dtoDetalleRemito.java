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
    private int idStock;
    private int idEstanteria;

    public dtoDetalleRemito(int cantidad, Producto producto, FormaVenta formaVenta) {
        this.cantidad = cantidad;
        this.producto = producto;
        this.formaVenta = formaVenta;
    }

    public dtoDetalleRemito(int cantidad, Producto producto, FormaVenta formaVenta, int idStock, int idEstanteria) {
        this.cantidad = cantidad;
        this.producto = producto;
        this.formaVenta = formaVenta;
        this.idStock = idStock;
        this.idEstanteria = idEstanteria;
    }

    public int getIdEstanteria() {
        return idEstanteria;
    }

    public void setIdEstanteria(int idEstanteria) {
        this.idEstanteria = idEstanteria;
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

    public int getIdStock() {
        return idStock;
    }

    public void setIdStock(int idStock) {
        this.idStock = idStock;
    }

    @Override
    public String toString() {
        return "dtoDetalleRemito{" + "cantidad=" + cantidad + ", producto=" + producto + ", formaVenta=" + formaVenta + '}';
    }
    

    
}
