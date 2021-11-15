/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Flor
 */
public class LugarUbicacion {
    private int codigo;
    private String nombre;
    private Sector sector;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

  

    public LugarUbicacion(int codigo, String nombre, Sector sector) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.sector = sector;
    }
    
     public LugarUbicacion(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        
    }

    public LugarUbicacion() {
    }

    @Override
    public String toString() {
        return  nombre ;
    }
     public String toString2() {
        return "LugarUbicacion{" + "codigo=" + codigo + ", nombre=" + nombre + ", sector=" + sector + '}';
    }
    
    
}
