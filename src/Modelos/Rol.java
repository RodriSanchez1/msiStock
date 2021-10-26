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
public class Rol {
    public int idRol;
    public String nombre;

    public Rol(int idRol, String rol) {
        this.idRol = idRol;
        this.nombre = rol;
    }

    public Rol() {
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getRol() {
        return nombre;
    }

    public void setRol(String rol) {
        this.nombre = rol;
    }

    @Override
    public String toString() {
        return   idRol + "-" + nombre;
    }
    
    
}
