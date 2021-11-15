/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Alex
 */
public class ControladorPorcentajes {
    private Connection con = null;

    private void abrirConexion() {

        try {
           // con = DriverManager.getConnection("jdbc:sqlserver://db-instance-rs.cetddq7pslga.sa-east-1.rds.amazonaws.com;databaseName=easyStock", "admin", "admin1234");
           con = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=easyStock; integratedsecurity=true");
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
    
    public Integer obtenerVentasOnline(){
        
        int ventasOnline = 0;
        
        try {
            abrirConexion();
            String query = "select count(*) as 'Cantidad Online' "
                    + "from remito r join detalle_remito dr on r.nroRemito = dr.nroRemito"
                    + " join stock s on dr.idStock = s.idStock "
                    + " join formaVenta fv on s.idFormaVenta = fv.idFormaVenta "
                    + " where fv.idFormaVenta = 1";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                ventasOnline = rs.getInt("Cantidad Online");
                
            }
        } catch (SQLException ex) {
            System.out.println(ex);;
        } finally {
            cerrarConexion();
        }
        
        return ventasOnline;
    }
     public Integer obtenerVentasPresencial(){
        
        int ventasPresencial = 0;
        
        try {
            abrirConexion();
            String query = "select count(*) as 'Cantidad Presencial' "
                    + "from remito r join detalle_remito dr on r.nroRemito = dr.nroRemito"
                    + " join stock s on dr.idStock = s.idStock "
                    + " join formaVenta fv on s.idFormaVenta = fv.idFormaVenta "
                    + " where fv.idFormaVenta = 2";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                ventasPresencial = rs.getInt("Cantidad Presencial");
                
            }
        } catch (SQLException ex) {
            System.out.println(ex);;
        } finally {
            cerrarConexion();
        }
        
        return ventasPresencial;
    }
}
