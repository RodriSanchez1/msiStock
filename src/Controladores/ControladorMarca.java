/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Marca;
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
public class ControladorMarca {
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
    
     public ArrayList<Marca> obtenerMarca(){
        ArrayList<Marca> lstMarca = new ArrayList<>();
        try {
            abrirConexion();
            String query = "select * from marca";
            Statement st = con. createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
                int idMarca = rs.getInt("idMarca");
                String nombre = rs.getString("nombre");
                Marca marca = new Marca (idMarca, nombre);
                lstMarca.add(marca);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }finally{
         cerrarConexion();
     }
        return lstMarca;
    }
}
