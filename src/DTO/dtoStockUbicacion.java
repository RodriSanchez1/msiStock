/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author rodri
 */
public class dtoStockUbicacion {
    private int idStock;
    private int codProducto;
    private int idFormaVenta;
    private int idUbicacion;
    private int cantidad;
    private int idEstanteria;
    private String descripcionEstanteria;
    private int idSector;
    private String descripcionSector;
    private int idLugarAlmacenamiento;
    private String descripcionLugarAlmacenamiento;

    public dtoStockUbicacion() {
    }

    public dtoStockUbicacion(int idStock, int codProducto, int idFormaVenta, int idUbicacion, int idEstanteria, String descripcionEstanteria, int cantidad, int idSector, String descripcionSector, int idLugarAlmacenamiento, String descripcionLugarAlmacenamiento) {
        this.idStock = idStock;
        this.codProducto = codProducto;
        this.idFormaVenta = idFormaVenta;
        this.idUbicacion = idUbicacion;
        this.idEstanteria = idEstanteria;
        this.descripcionEstanteria = descripcionEstanteria;
        this.cantidad = cantidad;
        this.idSector = idSector;
        this.descripcionSector = descripcionSector;
        this.idLugarAlmacenamiento = idLugarAlmacenamiento;
        this.descripcionLugarAlmacenamiento = descripcionLugarAlmacenamiento;
    }

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

    public int getIdFormaVenta() {
        return idFormaVenta;
    }

    public void setIdFormaVenta(int idFormaVenta) {
        this.idFormaVenta = idFormaVenta;
    }

    public int getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(int idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public int getIdEstanteria() {
        return idEstanteria;
    }

    public void setIdEstanteria(int idEstanteria) {
        this.idEstanteria = idEstanteria;
    }

    public String getDescripcionEstanteria() {
        return descripcionEstanteria;
    }

    public void setDescripcionEstanteria(String descripcionEstanteria) {
        this.descripcionEstanteria = descripcionEstanteria;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdSector() {
        return idSector;
    }

    public void setIdSector(int idSector) {
        this.idSector = idSector;
    }

    public String getDescripcionSector() {
        return descripcionSector;
    }

    public void setDescripcionSector(String descripcionSector) {
        this.descripcionSector = descripcionSector;
    }

    public int getIdLugarAlmacenamiento() {
        return idLugarAlmacenamiento;
    }

    public void setIdLugarAlmacenamiento(int idLugarAlmacenamiento) {
        this.idLugarAlmacenamiento = idLugarAlmacenamiento;
    }

    public String getDescripcionLugarAlmacenamiento() {
        return descripcionLugarAlmacenamiento;
    }

    public void setDescripcionLugarAlmacenamiento(String descripcionLugarAlmacenamiento) {
        this.descripcionLugarAlmacenamiento = descripcionLugarAlmacenamiento;
    }
        
}
