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
public class Ubicacion {
    private int id;
    private Estanteria estanteria; //PARA MI VA LUGAR DE UBICACION ACA

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Estanteria getEstanteria() {
        return estanteria;
    }

    public void setEstanteria(Estanteria estanteria) {
        this.estanteria = estanteria;
    }

    public Ubicacion(int id, Estanteria estanteria) {
        this.id = id;
        this.estanteria = estanteria;
    }

    public Ubicacion() {
    }

    @Override
    public String toString() {
        return "Ubicacion{" + "id=" + id + ", estanteria=" + estanteria + '}';
    }
    
}
