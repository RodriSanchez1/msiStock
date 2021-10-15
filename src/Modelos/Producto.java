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
    private String rubro;
    private String marca;
    private String formatoVenta; //esto es otra clase y va por composicion.
    private String tamanio;

    public Producto(int codigo, String nombreProducto, int stockMinimo, String rubro, String marca, String formatoVenta, String tamanio) {
        this.codigo = codigo;
        this.nombreProducto = nombreProducto;
        this.stockMinimo = stockMinimo;
        this.rubro = rubro;
        this.marca = marca;
        this.formatoVenta = formatoVenta;
        this.tamanio = tamanio;
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

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getFormatoVenta() {
        return formatoVenta;
    }

    public void setFormatoVenta(String formatoVenta) {
        this.formatoVenta = formatoVenta;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }
    
    
    
    
}
