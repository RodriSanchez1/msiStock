/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Alex
 */
public class Producto {
    private int codigo;
    private String nombreProducto;
    private int stockMinimo;
    private Marca marca;
    private Rubro rubro;
    private FormatoVenta formatoVenta; 
    private String tamanio;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }


    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public Producto(int codigo, String nombreProducto, int stockMinimo, Marca marca, Rubro rubro, FormatoVenta formatoVenta, String tamanio) {
        this.codigo = codigo;
        this.nombreProducto = nombreProducto;
        this.stockMinimo = stockMinimo;
        this.marca = marca;
        this.rubro = rubro;
        this.formatoVenta = formatoVenta;
        this.tamanio = tamanio;
    }

    public Producto() {
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", nombreProducto=" + nombreProducto + ", stockMinimo=" + stockMinimo + ", marca=" + marca + ", rubro=" + rubro + ", formatoVenta=" + formatoVenta + ", tamanio=" + tamanio + '}';
    }

 

    
    
}
