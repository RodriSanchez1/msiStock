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
public class Usuario {
    private int legajo;
    private String nombreUsuario;
    private String contrasenia;
    private Rol rol;

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Usuario(int legajo, String nombreUsuario, String contrasenia, Rol rol) {
        this.legajo = legajo;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.rol = rol;
    }

    public Usuario() {
    }

    @Override
    public String toString() {
        return "Usuario{" + "legajo=" + legajo + ", nombreUsuario=" + nombreUsuario + ", contrasenia=" + contrasenia + ", rol=" + rol + '}';
    }


    
}

