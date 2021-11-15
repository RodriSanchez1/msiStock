/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;


import Modelos.DetalleRemito;
import Modelos.Remito;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class dtoCantidadMovimiento {
    private Remito remito;
    private DetalleRemito detalle;
    private int nroRemito;
    private Date fecha;
    private int cantidad; 
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNroRemito() {
        return nroRemito;
    }

    public void setNroRemito(int nroRemito) {
        this.nroRemito = nroRemito;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public dtoCantidadMovimiento(int nroRemito, Date fecha, int cantidad, String nombre) {
        this.nroRemito = nroRemito;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.nombre = nombre;
    }

    
    
    public dtoCantidadMovimiento() {
    }

    public dtoCantidadMovimiento(Remito remito, DetalleRemito detalle) {
        this.remito = remito;
        this.detalle = detalle;
    }

    public Remito getRemito() {
        return remito;
    }

    public void setRemito(Remito remito) {
        this.remito = remito;
    }

    public DetalleRemito getDetalle() {
        return detalle;
    }

    public void setDetalle(DetalleRemito detalle) {
        this.detalle = detalle;
    }

    @Override
    public String toString() {
        return "dtoCantidadMovimiento{" + "remito=" + remito + ", detalle=" + detalle + '}';
    }
    
    
}
