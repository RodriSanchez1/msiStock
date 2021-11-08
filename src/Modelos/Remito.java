/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.ArrayList;
import java.util.Date;



/**
 *
 * @author Flor
 */
public class Remito {
    private int nroRemito;
    private Date fecha;
    private int tipoMovimiento; 
    private int legajoUsuario;
    private ArrayList<DetalleRemito> detalle;

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

    public int getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(int tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public int getLegajoUsuario() {
        return legajoUsuario;
    }

    public void setLegajoUsuario(int legajoUsuario) {
        this.legajoUsuario = legajoUsuario;
    }

    public Remito(int nroRemito, Date fecha, int tipoMovimiento, int legajoUsuario, ArrayList<DetalleRemito> detalle) {
        this.nroRemito = nroRemito;
        this.fecha = fecha;
        this.tipoMovimiento = tipoMovimiento;
        this.legajoUsuario = legajoUsuario;
        this.detalle = detalle;
    }

    public Remito() {
    }

    @Override
    public String toString() {
        return "Remito{" + "nroRemito=" + nroRemito + ", fecha=" + fecha + ", tipoMovimiento=" + tipoMovimiento + ", legajoUsuario=" + legajoUsuario + ", detalle=" + detalle + '}';
    }

   
    
    
}
