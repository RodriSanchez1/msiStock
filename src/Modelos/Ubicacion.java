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
    private Estanteria estanteria; 
    private int cantidad;
    private int idStock;

    public int getIdStock() {
        return idStock;
    }

    public void setIdStock(int idStock) {
        this.idStock = idStock;
    }
    
    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Estanteria getEstanteria() {
        return estanteria;
    }

    public Ubicacion(int id, Estanteria estanteria, int cantidad, int idStock) {
        this.id = id;
        this.estanteria = estanteria;
        this.cantidad = cantidad;
        this.idStock = idStock;
    }


    

    public Ubicacion(int id, Estanteria estanteria, int cantidad) {
        this.id = id;
        this.estanteria = estanteria;
        this.cantidad = cantidad;
    }

    public Ubicacion(int id, int cantidad) {
        this.id = id;
        this.cantidad = cantidad;
    }

    
  
   
  public Ubicacion( Estanteria estanteria) {
        
        this.estanteria = estanteria;
    }

    public Ubicacion() {
    }

    @Override
    public String toString() {
        return "Ubicacion{" + "id=" + id + ", estanteria=" + estanteria + '}';
    }
    
}
