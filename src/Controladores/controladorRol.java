/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Rol;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class controladorRol {
    
    private Connection con = null;
    private void abrirConexion() {
        try {
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
    
    public ArrayList<Rol> obtenerRoles(){
        ArrayList<Rol> ListaRoles = new ArrayList<Rol>();
        try {
            abrirConexion();
            String query = "select * from rol";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                int idRol = rs.getInt("idRol");                
                String nombre = rs.getString("nombre");
                Rol rol = new Rol (idRol, nombre);
                ListaRoles.add(rol);
            }
        } catch (SQLException ex) {
            System.out.println(ex);;
        }finally{
            cerrarConexion();
        }
        return ListaRoles;
    }
    
}
