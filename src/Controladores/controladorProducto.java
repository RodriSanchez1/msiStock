/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Marca;
import Modelos.Producto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class controladorProducto {
    
    private Connection con = null;
    
    private void abrirConexion() {

        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=easyStock", "sa", "fa");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void cerrarConexion() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void agregarProducto(Producto p){
        try{
            abrirConexion();
            PreparedStatement st = con.prepareStatement("Insert into producto(codigo, nombre, idMarca, idRubro, volumen, idFormato, stockMinimo)values (?,?,?,?,?,?,?)");
            st.setInt(1, p.getCodigo());
            st.setString(2, p.getNombreProducto());
            st.setInt(3, p.getMarca().getIdMarca());
            st.setInt(4, p.getRubro().getIdRubro());
            st.setString(5, p.getTamanio());
            st.setInt(6, p.getFormatoVenta().getCodigo());
            st.setInt(7, p.getStockMinimo());
            
            
            st.executeUpdate();
            st.close();
            cerrarConexion();
            System.out.println("Se agrego correctamente");
        }catch(Exception e){
            System.out.println("algo falló");
        }
    }
    
   
    
    
}
