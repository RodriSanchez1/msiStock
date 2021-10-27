/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Flor
 */
public class dtoActualizarUbicacion {
    
    private int codArticulo;
    private String nombreArticulo;
    private String nombreLugar;
    private String nombreSector;
    private String nombreEstante;
    private int cantidad;

    public int getCodArticulo() {
        return codArticulo;
    }

    public void setCodArticulo(int codArticulo) {
        this.codArticulo = codArticulo;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public String getNombreLugar() {
        return nombreLugar;
    }

    public void setNombreLugar(String nombreLugar) {
        this.nombreLugar = nombreLugar;
    }

    public String getNombreSector() {
        return nombreSector;
    }

    public void setNombreSector(String nombreSector) {
        this.nombreSector = nombreSector;
    }

    public String getNombreEstante() {
        return nombreEstante;
    }

    public void setNombreEstante(String nombreEstante) {
        this.nombreEstante = nombreEstante;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public dtoActualizarUbicacion(int codArticulo, String nombreArticulo, String nombreLugar, String nombreSector, String nombreEstante, int cantidad) {
        this.codArticulo = codArticulo;
        this.nombreArticulo = nombreArticulo;
        this.nombreLugar = nombreLugar;
        this.nombreSector = nombreSector;
        this.nombreEstante = nombreEstante;
        this.cantidad = cantidad;
    }

    public dtoActualizarUbicacion() {
    }
     public dtoActualizarUbicacion(int codArticulo, String nombreArticulo, String nombreLugar, String nombreSector, String nombreEstante) {
        this.codArticulo = codArticulo;
        this.nombreArticulo = nombreArticulo;
        this.nombreLugar = nombreLugar;
        this.nombreSector = nombreSector;
        this.nombreEstante = nombreEstante;
       
    }
        public dtoActualizarUbicacion( String nombreArticulo, String nombreLugar, String nombreSector, String nombreEstante) {
       
        this.nombreArticulo = nombreArticulo;
        this.nombreLugar = nombreLugar;
        this.nombreSector = nombreSector;
        this.nombreEstante = nombreEstante;
       
    }
        public dtoActualizarUbicacion( String nombreArticulo,  int cantidad, String nombreLugar, String nombreSector, String nombreEstante) {
        
        this.nombreArticulo = nombreArticulo;
          this.cantidad = cantidad;
        this.nombreLugar = nombreLugar;
        this.nombreSector = nombreSector;
        this.nombreEstante = nombreEstante;
      
    }

    @Override
    public String toString() {
        return "dtoActualizarUbicacion{" + "codArticulo=" + codArticulo + ", nombreArticulo=" + nombreArticulo + ", nombreLugar=" + nombreLugar + ", nombreSector=" + nombreSector + ", nombreEstante=" + nombreEstante + ", cantidad=" + cantidad + '}';
    }
     
}
    

