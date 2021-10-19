/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author rodri
 */
public class controladorRemitoInterno {
        private Connection con = null;

    private void abrirConexion() {

        try {
            //con = DriverManager.getConnection("jdbc:sqlserver://db-instance-rs.cetddq7pslga.sa-east-1.rds.amazonaws.com;databaseName=easyStock", "admin", "admin1234");
            con =  DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=easyStock; integratedsecurity=true");
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

    public int obtenerNroRemitoSiguiente(){
        int id = 0;
        try {
            abrirConexion();
            String query = "select MAX nroRemito from remito";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            if(rs.next()){
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex);;
        }finally{
            cerrarConexion();
        }
        return id+1;
    } 
}
