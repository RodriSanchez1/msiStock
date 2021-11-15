/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import Modelos.FormaVenta;
import Modelos.Producto;

/**
 *
 * @author rodri
 */
public class dtoListadoFaltantes {

    private Producto producto;
    private int stockTotal;
    private FormaVenta formaVenta;

    public dtoListadoFaltantes(Producto producto, int stockTotal, FormaVenta formaVenta) {
        this.producto = producto;
        this.stockTotal = stockTotal;
        this.formaVenta = formaVenta;
    }

    public FormaVenta getFormaVenta() {
        return formaVenta;
    }

    public void setFormaVenta(FormaVenta formaVenta) {
        this.formaVenta = formaVenta;
    }
    

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getStockTotal() {
        return stockTotal;
    }

    public void setStockTotal(int stockTotal) {
        this.stockTotal = stockTotal;
    }

    public dtoListadoFaltantes() {
    }
    
}
