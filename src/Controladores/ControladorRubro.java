/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Marca;
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
public class ControladorRubro {
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
    
     public ArrayList<Rubro> obtenerRubro(){
        ArrayList<Rubro> lstRubro  = new ArrayList<>();
        try {
            abrirConexion();
            String query = "select * from rubro";
            Statement st = con. createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
                int idRubro = rs.getInt("idRubro");
                String descripcion = rs.getString("descripcion");
                Rubro rubro = new Rubro (idRubro, descripcion);
                lstRubro.add(rubro);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }finally{
         cerrarConexion();
     }
        return lstRubro;
    }
}
