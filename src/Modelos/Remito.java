/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.Date;



/**
 *
 * @author Flor
 */
public class Remito {
    private int nroRemito;
    private Date fecha;
    private String tipoMovimiento; //capaz hay que cambiarlo a int despues de hacer la otra clase.+
    private int legajoUsuario;

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

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public int getLegajoUsuario() {
        return legajoUsuario;
    }

    public void setLegajoUsuario(int legajoUsuario) {
        this.legajoUsuario = legajoUsuario;
    }

    public Remito(int nroRemito, Date fecha, String tipoMovimiento, int legajoUsuario) {
        this.nroRemito = nroRemito;
        this.fecha = fecha;
        this.tipoMovimiento = tipoMovimiento;
        this.legajoUsuario = legajoUsuario;
    }

    public Remito() {
    }

    @Override
    public String toString() {
        return "Remito{" + "nroRemito=" + nroRemito + ", fecha=" + fecha + ", tipoMovimiento=" + tipoMovimiento + ", legajoUsuario=" + legajoUsuario + '}';
    }
    
    
    
}
