/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.FormatoVenta;
import Modelos.Rubro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ControladorFormatoVenta {
      private Connection con = null;
    
    private void abrirConexion() {

        try {
            //con = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=easyStock", "sa", "fa");
            con = DriverManager.getConnection("jdbc:sqlserver://db-instance-rs.cetddq7pslga.sa-east-1.rds.amazonaws.com;databaseName=easyStock", "admin", "admin1234");
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
    
     public ArrayList<FormatoVenta> obtenerFormatoVenta(){
        ArrayList<FormatoVenta> lstFormatoVenta  = new ArrayList<>();
        try {
            abrirConexion();
            String query = "select * from formatoVenta";
            Statement st = con. createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
                int codFormato = rs.getInt("codFormato");
                String descripcion = rs.getString("descripcion");
                FormatoVenta formato = new FormatoVenta (codFormato, descripcion);
                lstFormatoVenta.add(formato);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }finally{
         cerrarConexion();
     }
        return lstFormatoVenta;
    }
}
