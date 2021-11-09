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
public class dtoUbicacion {
    private Integer idUbi;
    private int codArticulo;
    private String nombreArticulo;
    private String nombreLugar;
    private String nombreSector;
    private String nombreEstante;
    private int cantidad;
    private int idStock;

    public Integer getIdUbi() {
        return idUbi;
    }

    public void setIdUbi(Integer idUbi) {
        this.idUbi = idUbi;
    }

    public int getIdStock() {
        return idStock;
    }

    public void setIdStock(int idStock) {
        this.idStock = idStock;
    }

    public dtoUbicacion(Integer idUbi, int codArticulo, String nombreArticulo, String nombreLugar, String nombreSector, String nombreEstante, int cantidad, int idStock) {
        this.idUbi = idUbi;
        this.codArticulo = codArticulo;
        this.nombreArticulo = nombreArticulo;
        this.nombreLugar = nombreLugar;
        this.nombreSector = nombreSector;
        this.nombreEstante = nombreEstante;
        this.cantidad = cantidad;
        this.idStock = idStock;
    }
    

    public int getIdubi() {
        return idUbi;
    }

    public void setidUbi(int idStock) {
        this.idUbi = idStock;
    }

    
    
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
    
    
    public dtoUbicacion(int idUbi, int codArticulo, String nombreArticulo, int cantidad,int idStock) {
        this.idUbi= idUbi; 
        this.codArticulo = codArticulo;
        this.nombreArticulo = nombreArticulo;
        this.cantidad = cantidad;
        this.idStock = idStock;
    }

    public dtoUbicacion(int codArticulo, String nombreArticulo, String nombreLugar, String nombreSector, String nombreEstante, int cantidad) {
        this.codArticulo = codArticulo;
        this.nombreArticulo = nombreArticulo;
        this.nombreLugar = nombreLugar;
        this.nombreSector = nombreSector;
        this.nombreEstante = nombreEstante;
        this.cantidad = cantidad;
    }

    public dtoUbicacion() {
    }
     public dtoUbicacion(int codArticulo, String nombreArticulo, String nombreLugar, String nombreSector, String nombreEstante) {
        this.codArticulo = codArticulo;
        this.nombreArticulo = nombreArticulo;
        this.nombreLugar = nombreLugar;
        this.nombreSector = nombreSector;
        this.nombreEstante = nombreEstante;
       
    }
        public dtoUbicacion( String nombreArticulo, String nombreLugar, String nombreSector, String nombreEstante) {
       
        this.nombreArticulo = nombreArticulo;
        this.nombreLugar = nombreLugar;
        this.nombreSector = nombreSector;
        this.nombreEstante = nombreEstante;
       
    }
        public dtoUbicacion( String nombreArticulo,  int cantidad, String nombreLugar, String nombreSector, String nombreEstante) {
        
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
    

