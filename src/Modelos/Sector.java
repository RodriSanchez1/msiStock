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
public class Sector {
    private int id;
    private String nombre;
    private Estanteria estanteria;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

  

    public Sector(int id, String nombre, Estanteria estanteria) {
        this.id = id;
        this.nombre = nombre;
        this.estanteria = estanteria;
    }

    public Sector() {
    }

    @Override
    public String toString() {
        return nombre ;
    }
    public String toString2() {
        return "Sector{" + "id=" + id + ", nombre=" + nombre + ", estanteria=" + estanteria + '}';
    }
    
    
}
