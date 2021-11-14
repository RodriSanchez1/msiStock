/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DTO.dtoDetalleRemito;
import DTO.dtoStockUbicacion;
import Modelos.FormaVenta;
import Modelos.Stock;
import Modelos.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author rodri
 */
public class controladorRemitoInterno {

    private Connection con = null;

    private void abrirConexion() {

        try {
            con = DriverManager.getConnection("jdbc:sqlserver://db-instance-rs.cetddq7pslga.sa-east-1.rds.amazonaws.com;databaseName=easyStock", "admin", "admin1234");
            //con = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=easyStock; integratedsecurity=true");
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

    public int obtenerNroRemitoSiguiente() {
        int id = 0;
        try {
            abrirConexion();
            String query = "select MAX(nroRemito) from remito";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex);;
        } finally {
            cerrarConexion();
        }
        return id + 1;
    }

    public boolean insertarNuevoRemitoEntrada(Date fecha, int TipoMovimiento, int legajoUser, ArrayList<dtoDetalleRemito> detalleRemito) throws SQLException {
        boolean succes = true;
        //Connection conexion = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=easyStock; integratedsecurity=true");
        Connection conexion = DriverManager.getConnection("jdbc:sqlserver://db-instance-rs.cetddq7pslga.sa-east-1.rds.amazonaws.com;databaseName=easyStock", "admin", "admin1234");
        
        java.sql.Date sqlDate = new java.sql.Date(fecha.getTime());
        System.out.println("Entro aca");
        // PreparedStatement stock = null, remito = null, detalleRemito = null;
        try {
            conexion.setAutoCommit(false);
            CallableStatement cstmt = conexion.prepareCall("{call stInsertarNuevoRemito(?, ?, ?,?   )}");

            cstmt.registerOutParameter("id", java.sql.Types.INTEGER);
            cstmt.setDate("fecha", sqlDate);
            cstmt.setInt("idTipoMovimiento", TipoMovimiento);
            cstmt.setInt("legajoUser", legajoUser);
            cstmt.execute();
            int idNuevoRemito = cstmt.getInt("id");
            cstmt.close();

            for (dtoDetalleRemito dRemito : detalleRemito) {
                cstmt = conexion.prepareCall("{call stManejadorStock(?,?,?,?,?)}");
                cstmt.registerOutParameter("idStock", java.sql.Types.INTEGER);
                cstmt.setInt("codProducto", dRemito.getProducto().getCodigo());
                cstmt.setInt("cantidad", dRemito.getCantidad());
                cstmt.setInt("idFormaVenta", dRemito.getFormaVenta().getIdFormaVenta());
                cstmt.setInt("tipoMovimiento", TipoMovimiento);
                cstmt.execute();
                int idStock = cstmt.getInt("idStock");
                cstmt.close();
                String query = "INSERT INTO detalle_remito(nroRemito,idStock,cantidad) values (?,?,?)";
                PreparedStatement ps = conexion.prepareStatement(query);
                ps.setInt(1, idNuevoRemito);
                ps.setInt(2, idStock);
                ps.setInt(3, dRemito.getCantidad());
                ps.executeUpdate();
                ps.close();
            }

            conexion.commit();
            System.out.println("Remito agregadp");

        } catch (SQLException e) {
            System.out.println(e);
            conexion.rollback();
        } finally {

            conexion.close();
        }

        return succes;
    }
        public boolean insertarNuevoRemitoSalida(Date fecha, int TipoMovimiento, int legajoUser, ArrayList<dtoDetalleRemito> detalleRemito) throws SQLException {
        boolean succes = true;
        Connection conexion = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=easyStock; integratedsecurity=true");
        java.sql.Date sqlDate = new java.sql.Date(fecha.getTime());
        try {
            conexion.setAutoCommit(false);
            CallableStatement cstmt = conexion.prepareCall("{call stInsertarNuevoRemito(?, ?, ?,?   )}");

            cstmt.registerOutParameter("id", java.sql.Types.INTEGER);
            cstmt.setDate("fecha", sqlDate);
            cstmt.setInt("idTipoMovimiento", TipoMovimiento);
            cstmt.setInt("legajoUser", legajoUser);
            cstmt.execute();
            int idNuevoRemito = cstmt.getInt("id");
            cstmt.close();

            for (dtoDetalleRemito dRemito : detalleRemito) {
                cstmt = conexion.prepareCall("{call stManejadorStockSalida(?,?,?,?,?,?)}");
               // cstmt.registerOutParameter("idStock", java.sql.Types.INTEGER);
                cstmt.setInt("codProducto", dRemito.getProducto().getCodigo());
                cstmt.setInt("cantidad", dRemito.getCantidad());
                cstmt.setInt("idFormaVenta", dRemito.getFormaVenta().getIdFormaVenta());
                cstmt.setInt("tipoMovimiento", TipoMovimiento);
                cstmt.setInt("idEstanteria", dRemito.getIdEstanteria());
                cstmt.setInt("idStock", dRemito.getIdStock());
                cstmt.execute();
                //int idStock = cstmt.getInt("idStock");
                cstmt.close();
                String query = "INSERT INTO detalle_remito(nroRemito,idStock,cantidad) values (?,?,?)";
                PreparedStatement ps = conexion.prepareStatement(query);
                ps.setInt(1, idNuevoRemito);
                ps.setInt(2, dRemito.getIdStock());
                ps.setInt(3, dRemito.getCantidad());
                ps.executeUpdate();
                ps.close();
            }

            conexion.commit();
            System.out.println("Remito agregado");

        } catch (SQLException e) {
            System.out.println(e);
            conexion.rollback();
        } finally {

            conexion.close();
        }

        return succes;
    }

//    public ArrayList<Stock> obtenerStock() {
//        ArrayList<Stock> listaStock = new ArrayList();
//        try {
//            abrirConexion();
//            String query = "select * from stock";
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery(query);
//            while (rs.next()) {
//                int codProducto = rs.getInt(2);
//                int cantidad = rs.getInt(3);
//                int idFormaVenta = rs.getInt(5);
//                FormaVenta formaVenta = idFormaVenta == 1 ? new FormaVenta(1, "online") : new FormaVenta(2, "presencial");
//
//                Stock stock = new Stock(codProducto, cantidad,formaVenta);
//                listaStock.add(stock);
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex);;
//        } finally {
//            cerrarConexion();
//        }
//        return listaStock;
//    }
        public ArrayList<dtoStockUbicacion> obtenerStock() {
        ArrayList<dtoStockUbicacion> listaStock = new ArrayList();
        try {
            abrirConexion();
            String query = "SELECT st.idStock,st.codProducto,st.idFormaVenta,ub.idUbicacion, \n" +
                            "ub.cantidad,es.idEstanteria,es.descripcion,se.idSector,se.nombre,la.codAlmacenamiento,la.nombre\n" +
                            "FROM stock st join ubicacion ub on st.idStock = ub.idStock \n" +
                            "	join Estanteria es on es.idEstanteria=ub.idEstanteria \n" +
                            "	join sector se on se.idSector = es.idSector \n" +
                            "	join lugarAlmacenamiento la on la.codAlmacenamiento = se.lugarAlmacenamiento";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int idStock = rs.getInt(1);
                int codProducto = rs.getInt(2);
                int idFormaVenta = rs.getInt(3);
                int idUbicacion = rs.getInt(4);
                int cantidad = rs.getInt(5);
                int idEstanteria = rs.getInt(6);
                String descripcionEstanteria = rs.getString(7);
                int idSector = rs.getInt(8);
                String descripcionSector  = rs.getString(9);
                int idSectorAlmacenamineto = rs.getInt(10);
                String descripcionLugarAlmacenamiento = rs.getString(11);
                
                FormaVenta formaVenta = idFormaVenta == 1 ? new FormaVenta(1, "online") : new FormaVenta(2, "presencial");

                dtoStockUbicacion stock = new dtoStockUbicacion(idStock, codProducto, idFormaVenta, idUbicacion, idEstanteria, descripcionEstanteria, cantidad, idSector, descripcionSector, idSectorAlmacenamineto, descripcionLugarAlmacenamiento);
                listaStock.add(stock);
            }
        } catch (SQLException ex) {
            System.out.println(ex);;
        } finally {
            cerrarConexion();
        }
        return listaStock;
    }
}
