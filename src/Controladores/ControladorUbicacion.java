/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DTO.dtoActualizarUbicacion;
import Modelos.Estanteria;
import Modelos.FormaVenta;
import Modelos.LugarUbicacion;
import Modelos.Producto;
import Modelos.Sector;
import Modelos.Stock;
import Modelos.Ubicacion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Flor
 */
public class ControladorUbicacion {
    
   // private final String url = "jdbc:sqlserver://db-instance-rs.cetddq7pslga.sa-east-1.rds.amazonaws.com;databaseName=easyStock";
    private final String url = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=Easy_stock2";
    private final String usuario = "sa";
    private final String contra = "1995";
    //private final String usuario = "admin";
    //private final String contra = "admin1234";
    
   
    public void crearUbicacion(Ubicacion ubi){
         System.out.println("comenzo el proceso");
         try{
            Connection conexion = DriverManager.getConnection(url, usuario, contra);
            PreparedStatement ps = conexion.prepareStatement("insert into ubicacion (id_estanteria) values (?)", Statement.RETURN_GENERATED_KEYS);
            
        ps.setInt(1, ubi.getEstanteria().getId());
        
            try{   
                 ps.executeUpdate();
               ResultSet rs = ps.getGeneratedKeys();
                 rs.next();
                int idAutoIncrement = rs.getInt(1);
                ubi.setId(idAutoIncrement);
            } catch (Exception e){
                 JFrame jframe = new JFrame();
                JOptionPane.showMessageDialog( jframe , "Debe seleccionar una estantería");
            }
            ps.close();
            conexion.close();
            
        }catch(Exception e){
             Logger.getLogger(ControladorUbicacion.class.getName()).log(Level.SEVERE, null, e);     
        }  
    }
 

    public void ubicarProducto( Stock stock ){
        try{
            Connection conexion = DriverManager.getConnection(url, usuario, contra);
            PreparedStatement ps = conexion.prepareStatement("insert into stock (cod_producto, cantidad, id_ubicacion, id_forma_venta) values (?, ?,?, ?)");
            
            ps.setInt(1, stock.getProducto().getCodigo());
            ps.setInt (2, stock.getCantidad());
            ps.setInt(3, stock.getUbicacion().getId());
            ps.setInt(4, stock.getFormaVenta().getIdFormaVenta());
            
            try{
                 ps.executeUpdate();
            } catch (Exception e){
                 JFrame jframe = new JFrame();
                JOptionPane.showMessageDialog( jframe , "Error en la carga de algún dato");
            }
            ps.close();
            conexion.close();
            
        }catch(Exception e){
             Logger.getLogger(ControladorUbicacion.class.getName()).log(Level.SEVERE, null, e);     
        } 
        
    
    }
    
    public ArrayList <LugarUbicacion> obtenerLugarUbicacion(){
        ArrayList <LugarUbicacion> lista = new ArrayList<>();
   
        
        try{
             Connection conexion = DriverManager.getConnection(url, usuario, contra);
             String Consulta = "select cod_almacenamiento, nombre from lugar_almacenamiento ";
             Statement st = conexion.createStatement();
             ResultSet rs = st.executeQuery(Consulta);
             
             while(rs.next()){
                 int cod = rs.getInt("cod_almacenamiento");
                 String nombreUBi = rs.getString("nombre");
           
                 LugarUbicacion lugar = new LugarUbicacion(cod, nombreUBi);
                 lista.add(lugar);
               
             }
            
            
        } catch(SQLException e){
              Logger.getLogger(ControladorUbicacion.class.getName()).log(Level.SEVERE, null, e);     
        
        }
        return lista;
    }
    
     public ArrayList <Sector> obtenerSector(int idLugarUbicacion){
        ArrayList <Sector> lista = new ArrayList<>();
   
        
        try{
             Connection conexion = DriverManager.getConnection(url, usuario, contra);
             String Consulta = "select id_sector, nombre from sector where "
                     + "lugar_almacenamiento = " + idLugarUbicacion + "";
             Statement st = conexion.createStatement();
             ResultSet rs = st.executeQuery(Consulta);
             
             while(rs.next()){
                 int cod = rs.getInt("id_sector");
                 String nombreUBi = rs.getString("nombre");
                 
                 Sector sector = new Sector(cod, nombreUBi, null);
                 lista.add(sector);
               
             }
            
            
        } catch(SQLException e){
              Logger.getLogger(ControladorUbicacion.class.getName()).log(Level.SEVERE, null, e);     
        
        }
        return lista;
    }
      public ArrayList <Estanteria> obtenerEstanteria(int idSector){
        ArrayList <Estanteria> lista = new ArrayList<>();
   
        
        try{
             Connection conexion = DriverManager.getConnection(url, usuario, contra);
             String Consulta = "select id_estanteria, descripcion from Estanteria where id_sector = " + idSector + "";
             Statement st = conexion.createStatement();
             ResultSet rs = st.executeQuery(Consulta);
             
             while(rs.next()){
                 int cod = rs.getInt("id_estanteria");
                 String nombreUBi = rs.getString("descripcion");
                 
                 Estanteria estanteria = new Estanteria (cod, nombreUBi);
                 lista.add(estanteria);
               
             }
            
            
        } catch(SQLException e){
              Logger.getLogger(ControladorUbicacion.class.getName()).log(Level.SEVERE, null, e);     
        
        }
        return lista;
    }
       public ArrayList <FormaVenta> obtenerFormaVenta(){
        ArrayList <FormaVenta> lista = new ArrayList<>();
   
        
        try{
             Connection conexion = DriverManager.getConnection(url, usuario, contra);
             String Consulta = "select id_forma_venta, descripcion from forma_venta ";
             Statement st = conexion.createStatement();
             ResultSet rs = st.executeQuery(Consulta);
             
             while(rs.next()){
                 int cod = rs.getInt("id_forma_venta");
                 String nombreUBi = rs.getString("descripcion");
           
                 FormaVenta forma = new FormaVenta(cod, nombreUBi);
                 lista.add(forma);
               
             }
            
            
        } catch(SQLException e){
              Logger.getLogger(ControladorUbicacion.class.getName()).log(Level.SEVERE, null, e);     
        
        }
        return lista;
    }
    
    public ArrayList<dtoActualizarUbicacion> buscarProducto(int id) {
        ArrayList<dtoActualizarUbicacion> lista = new ArrayList<>();

        try {
            Connection conexion = DriverManager.getConnection(url, usuario, contra);

            String Consulta = "select p.nombre 'articulo', s.cantidad, 'cantidad', lu.nombre 'lugar' , se.nombre 'sector', e.descripcion 'estante'\n"
                    + "from producto p join stock s on p.cod_producto = s.cod_producto\n"
                    + "join ubicacion u on s.id_ubicacion = u.id_ubicacion \n"
                    + "join Estanteria e on e.id_estanteria = u.id_estanteria\n"
                    + "join sector se on se.id_sector = e.id_sector\n"
                    + "join lugar_almacenamiento lu on se.lugar_almacenamiento = lu.cod_almacenamiento\n"
                    + "where p.cod_producto = " + id + " and lu.nombre like '%Depósit%'";
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(Consulta);

            while (rs.next()) {

                String nombreProd = rs.getString("articulo");
                int cant = rs.getInt("cantidad");
                String nombreLugar = rs.getString("lugar");
                String nombreSector = rs.getString("sector");
                String estanteria = rs.getString("estante");
                
              

                dtoActualizarUbicacion dto = new dtoActualizarUbicacion(nombreProd, cant, nombreLugar, nombreSector, estanteria);
                lista.add(dto);

            }

        } catch (SQLException e) {
            Logger.getLogger(ControladorUbicacion.class.getName()).log(Level.SEVERE, null, e);

        }

        return lista;
    }
    
    public boolean modificarUbicacionAlmacen(Stock stock , int cod){
        boolean x = false;
         try {
            Connection conexion = DriverManager.getConnection(url, usuario, contra);
            PreparedStatement ps = conexion.prepareStatement("update produccion set fecha = ? , cantidadProduccion = ? where id = ?");
            
           // ps.setString(1, stock.getFecha());
             
              ps.executeUpdate();
                ps.close();
            conexion.close();

            x = true;
            if (x = true){
                 JFrame jframe = new JFrame();
               JOptionPane.showMessageDialog( jframe , "Se actualizó la producción correctamente.");  
            }
        }
        catch(Exception e)
        {
           x = false;
            JFrame jframe = new JFrame();
            JOptionPane.showMessageDialog( jframe , "Error, No se pudo actualizar la ubicación del producto.");
        }
        return x;
    }
    
    
    
      public void crearUbicacion2(Ubicacion ubi){
         System.out.println("comenzo el proceso");
         try{
            Connection conexion = DriverManager.getConnection(url, usuario, contra);
            PreparedStatement ps = conexion.prepareStatement("insert into ubicacion (id_estanteria) values (?)", Statement.RETURN_GENERATED_KEYS);
            
        ps.setInt(1, ubi.getEstanteria().getId());
        
            try{   
                 ps.executeUpdate();
               ResultSet rs = ps.getGeneratedKeys();
                 rs.next();
                int idAutoIncrement = rs.getInt(1);
                ubi.setId(idAutoIncrement);
            } catch (Exception e){
                 JFrame jframe = new JFrame();
                JOptionPane.showMessageDialog( jframe , "Debe seleccionar una estantería");
            }
            ps.close();
            conexion.close();
            
        }catch(Exception e){
             Logger.getLogger(ControladorUbicacion.class.getName()).log(Level.SEVERE, null, e);     
        }  
    }
}
