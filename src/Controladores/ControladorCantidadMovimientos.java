/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DTO.dtoCantidadMovimiento;
import Modelos.DetalleRemito;
import Modelos.Remito;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class ControladorCantidadMovimientos {

    private Connection con = null;

    private void abrirConexion() {

        try {
            //con = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=easyStock; integratedsecurity=true");
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

    public ControladorCantidadMovimientos() {
    
    }
    

    public ArrayList<dtoCantidadMovimiento> ObtenerCantidad(Date fecha1, Date fecha2) {
        ArrayList<dtoCantidadMovimiento> lstCant = new ArrayList<>();
        java.sql.Date sqlFecha1 = new java.sql.Date(fecha1.getTime());
         java.sql.Date sqlFecha2 = new java.sql.Date(fecha2.getTime());
        try {
            abrirConexion();
            String query = "Select r.nroRemito, r.fecha, SUM(d.cantidad),"
                    + "tm.nombre from remito r join detalle_remito d \n"
                    + "on r.nroRemito=d.nroRemito join tipoMovimiento tm on tm.idTipoMovimiento = r.idTipoMovimiento "
                    + "WHERE r.fecha between '" + sqlFecha1 + "' and '" + sqlFecha2 + "' \n"
                    + " GROUP BY r.nroRemito,r.fecha,tm.nombre";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int nroRemito = rs.getInt(1);
                Date fecha = rs.getDate(2);
                int cantidad = rs.getInt(3);
                String nombre = rs.getString(4);

                dtoCantidadMovimiento nuevo = new dtoCantidadMovimiento(nroRemito, fecha, cantidad, nombre);
                lstCant.add(nuevo);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            cerrarConexion();
        }

        return lstCant;
    }

}
