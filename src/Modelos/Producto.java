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
    private int rubro;
    private int marca;
    private int formatoVenta; //esto es otra clase y va por composicion.
    private String tamanio;
    private int formaVenta;

    public Producto(int codigo, String nombreProducto, int stockMinimo, int rubro, int marca, int formatoVenta, String tamanio, int formaVenta) {
        this.codigo = codigo;
        this.nombreProducto = nombreProducto;
        this.stockMinimo = stockMinimo;
        this.rubro = rubro;
        this.marca = marca;
        this.formatoVenta = formatoVenta;
        this.tamanio = tamanio;
        this.formaVenta = formaVenta;
    }

    public Producto() {
    }

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

    public int getRubro() {
        return rubro;
    }

    public void setRubro(int rubro) {
        this.rubro = rubro;
    }

    public int getMarca() {
        return marca;
    }

    public void setMarca(int marca) {
        this.marca = marca;
    }

    public int getFormatoVenta() {
        return formatoVenta;
    }

    public void setFormatoVenta(int formatoVenta) {
        this.formatoVenta = formatoVenta;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public int getFormaVenta() {
        return formaVenta;
    }

    public void setFormaVenta(int formaVenta) {
        this.formaVenta = formaVenta;
    }
    
    
    
    
}
