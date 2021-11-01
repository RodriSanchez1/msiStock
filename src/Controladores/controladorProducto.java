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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class controladorProducto {

    private Connection con = null;

    private void abrirConexion() {

        try {
           // con = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=easyStock", "sa", "fa");
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

    public void agregarProducto(Producto p) {
        try {
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
        } catch (Exception e) {
            System.out.println("algo falló");
        }
    }

    public ArrayList<Producto> obtenerProductos() {
        ArrayList<Producto> lista = new ArrayList();
        try {
            abrirConexion();
            String query = "SELECT * FROM producto";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int codProducto = rs.getInt("codProducto");
                String nombre = rs.getString("nombre");
//                int idMarca = rs.getInt("idMarca");
//                int idRubro = rs.getInt("idRubro");
//                String volumen = rs.getString("volumen");
//                int idFormato = rs.getInt("idFormato");
//                int stockMinimo = rs.getInt("stockMinimo");
                Producto producto = new Producto(codProducto, nombre);
                lista.add(producto);
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);;
        } finally {
            cerrarConexion();
        }
        return lista;
    }

}
