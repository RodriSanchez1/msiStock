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
public class Rubro {
    private int idRubro;
    private String nombre;

    public int getIdRubro() {
        return idRubro;
    }

    public void setIdRubro(int idRubro) {
        this.idRubro = idRubro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Rubro(int idRubro, String nombre) {
        this.idRubro = idRubro;
        this.nombre = nombre;
    }

    public Rubro() {
    }

    @Override
    public String toString() {
        return "Rubro{" + "idRubro=" + idRubro + ", nombre=" + nombre + '}';
    }
    
    
}
