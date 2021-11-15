/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DTO.dtoListadoFaltantes;
import Modelos.FormaVenta;
import Modelos.FormatoVenta;
import Modelos.Marca;
import Modelos.Producto;
import Modelos.Rubro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class controladorProducto {

    private Connection con = null;

    private void abrirConexion() {

        try {
            con = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=easyStock; integratedsecurity=true");
            //con = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=easyStock", "sa", "fa");
            // con = DriverManager.getConnection("jdbc:sqlserver://db-instance-rs.cetddq7pslga.sa-east-1.rds.amazonaws.com;databaseName=easyStock", "admin", "admin1234"); 
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

//    public void agregarProducto(Producto p) {
//        try {
//            abrirConexion();
//            PreparedStatement st = con.prepareStatement("Insert into producto(codigo, nombre, idMarca, idRubro, volumen, idFormato, stockMinimo)values (?,?,?,?,?,?,?)");
//            st.setInt(1, p.getCodigo());
//            st.setString(2, p.getNombreProducto());
//            st.setInt(3, p.getMarca().getIdMarca());
//            st.setInt(4, p.getRubro().getIdRubro());
//            st.setString(5, p.getTamanio());
//            st.setInt(6, p.getFormatoVenta().getCodigo());
//            st.setInt(7, p.getStockMinimo());
//
//            st.executeUpdate();
//            st.close();
//            cerrarConexion();
//            System.out.println("Se agrego correctamente");
//        } catch (Exception e) {
//            System.out.println("algo falló");
//        }
//    }
    public ArrayList<Producto> obtenerProductos() {
        ArrayList<Producto> lista = new ArrayList();
        try {
            abrirConexion();
            String query = "select p.codProducto as 'codigoProducto', p.nombre as 'nombreProd', p.stockMinimo as 'stockMinimo',"
                    + "p.volumen as 'tamanio', p.idMarca as 'idMarca', m.nombre as 'nombreMarca',\n"
                    + "p.idRubro as 'idRubro', r.descripcion as 'nombreRubro', p.idFormato as 'idformato', f.descripcion as 'nombreFormato'\n"
                    + "from producto p join marca m on p.idMarca = m.idMarca \n"
                    + "join rubro r on p.idRubro = r.idRubro\n"
                    + "join formatoVenta f on f.codFormato = p.idFormato";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int codProducto = rs.getInt("codigoProducto");
                String nombre = rs.getString("nombreProd");
                int idMarca = rs.getInt("idMarca");
                String nombreMarca = rs.getString("nombreMarca");
                int idRubro = rs.getInt("idRubro");
                String nombreRubro = rs.getString("nombreRubro");
                String volumen = rs.getString("tamanio");
                int idFormato = rs.getInt("idFormato");
                String nombreFormato = rs.getString("nombreFormato");
                int stockMinimo = rs.getInt("stockMinimo");
                Marca marca = new Marca(idMarca, nombreMarca);
                Rubro rubro = new Rubro(idRubro, nombreRubro);
                FormatoVenta formato = new FormatoVenta(idFormato, nombreFormato);
                Producto producto = new Producto(codProducto, nombre, stockMinimo, marca, rubro, formato, volumen);
                lista.add(producto);
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            cerrarConexion();
        }
        return lista;
    }
        public ArrayList<Producto> obtenerProductosParaUbicar() {
        ArrayList<Producto> lista = new ArrayList();
        try {
            abrirConexion();
            String query = "select p.codProducto as 'codigoProducto', p.nombre as 'nombreProd', p.stockMinimo as 'stockMinimo',"
                    + "p.volumen as 'tamanio', p.idMarca as 'idMarca', m.nombre as 'nombreMarca',\n"
                    + "p.idRubro as 'idRubro', r.descripcion as 'nombreRubro', p.idFormato as 'idformato', f.descripcion as 'nombreFormato'\n"
                    + "from producto p join marca m on p.idMarca = m.idMarca \n"
                    + "join rubro r on p.idRubro = r.idRubro\n"
                    + "join formatoVenta f on f.codFormato = p.idFormato join stock s on s.codProducto = p.codProducto join ubicacion u on s.idStock = u.idStock"
                    + " where u.idEstanteria is null and u.cantidad > 0";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int codProducto = rs.getInt("codigoProducto");
                String nombre = rs.getString("nombreProd");
                int idMarca = rs.getInt("idMarca");
                String nombreMarca = rs.getString("nombreMarca");
                int idRubro = rs.getInt("idRubro");
                String nombreRubro = rs.getString("nombreRubro");
                String volumen = rs.getString("tamanio");
                int idFormato = rs.getInt("idFormato");
                String nombreFormato = rs.getString("nombreFormato");
                int stockMinimo = rs.getInt("stockMinimo");
                Marca marca = new Marca(idMarca, nombreMarca);
                Rubro rubro = new Rubro(idRubro, nombreRubro);
                FormatoVenta formato = new FormatoVenta(idFormato, nombreFormato);
                Producto producto = new Producto(codProducto, nombre, stockMinimo, marca, rubro, formato, volumen);
                lista.add(producto);
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            cerrarConexion();
        }
        return lista;
    }

                public ArrayList<Producto> obtenerProductosParaModificarUbicacion() {
        ArrayList<Producto> lista = new ArrayList();
        try {
            abrirConexion();
            String query = "select distinct p.codProducto as 'codigoProducto', p.nombre as 'nombreProd', p.stockMinimo as 'stockMinimo',"
                    + "p.volumen as 'tamanio', p.idMarca as 'idMarca', m.nombre as 'nombreMarca',\n"
                    + "p.idRubro as 'idRubro', r.descripcion as 'nombreRubro', p.idFormato as 'idformato', f.descripcion as 'nombreFormato'\n"
                    + "from producto p join marca m on p.idMarca = m.idMarca \n"
                    + "join rubro r on p.idRubro = r.idRubro\n"
                    + "join formatoVenta f on f.codFormato = p.idFormato join stock s on s.codProducto = p.codProducto join ubicacion u on s.idStock = u.idStock"
                    + " where u.idEstanteria is not null and u.cantidad > 0";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int codProducto = rs.getInt("codigoProducto");
                String nombre = rs.getString("nombreProd");
                int idMarca = rs.getInt("idMarca");
                String nombreMarca = rs.getString("nombreMarca");
                int idRubro = rs.getInt("idRubro");
                String nombreRubro = rs.getString("nombreRubro");
                String volumen = rs.getString("tamanio");
                int idFormato = rs.getInt("idFormato");
                String nombreFormato = rs.getString("nombreFormato");
                int stockMinimo = rs.getInt("stockMinimo");
                Marca marca = new Marca(idMarca, nombreMarca);
                Rubro rubro = new Rubro(idRubro, nombreRubro);
                FormatoVenta formato = new FormatoVenta(idFormato, nombreFormato);
                Producto producto = new Producto(codProducto, nombre, stockMinimo, marca, rubro, formato, volumen);
                lista.add(producto);
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            cerrarConexion();
        }
        return lista;
    }
    public boolean agregarProducto(Producto p) throws SQLException {  //Arranco botón Agregar Producto.
        boolean insert = false;
        try {
            abrirConexion();
            con.setAutoCommit(false);
            String query = "Insert into producto(nombre, idMarca, idRubro, volumen, idFormato, stockMinimo)values (?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, p.getNombreProducto());
            st.setInt(2, p.getMarca().getIdMarca());
            st.setInt(3, p.getRubro().getIdRubro());
            st.setString(4, p.getTamanio());
            st.setInt(5, p.getFormatoVenta().getCodigo());
            st.setInt(6, p.getStockMinimo());
            
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            rs.next();
            int codProducto = rs.getInt(1);
            
            query = "INSERT INTO stock(codProducto,idFormaVenta) VALUES ("+codProducto+",1)";
            st = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            st.executeUpdate();
            rs = st.getGeneratedKeys();
            rs.next();
            int idStock = rs.getInt(1);
            query = "INSERT INTO ubicacion(idStock,cantidad) VALUES ("+idStock+",0)";
            st = con.prepareStatement(query);
            st.execute();
            
            query = "INSERT INTO stock(codProducto,idFormaVenta) VALUES ("+codProducto+",2)";
            st = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            st.executeUpdate();
            rs = st.getGeneratedKeys();
            rs.next();
            idStock = rs.getInt(1);
            query = "INSERT INTO ubicacion(idStock,cantidad) VALUES ("+idStock+",0)";
            st = con.prepareStatement(query);
            st.execute();
            
            st.close();
            con.commit();
            cerrarConexion();
            insert = true;
            System.out.println("Se agrego correctamente");
        } catch (Exception e) {
            con.rollback();
            System.out.println(e);
            insert = false;
        }

        return insert;
    }

    public boolean actualizarProducto(Producto p) { //Arranco botón actualizar producto 
        boolean retorno = false;
        try {
            abrirConexion();
            String query = "Update producto set nombre = ?, idMarca = ?, idRubro = ?, volumen = ?, idFormato = ?, stockMinimo = ? "
                    + "Where codProducto = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, p.getNombreProducto());
            ps.setInt(2, p.getMarca().getIdMarca());
            ps.setInt(3, p.getRubro().getIdRubro());
            ps.setString(4, p.getTamanio());
            ps.setInt(5, p.getFormatoVenta().getCodigo());
            ps.setInt(6, p.getStockMinimo());
            ps.setInt(7, p.getCodigo());
            ps.execute();

            retorno = true;
            System.out.println("Se modificó correctamente");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            cerrarConexion();
        }

        return retorno;

    }

    public void eliminarProducto(int codigo) { //Arranco botón Eliminar Producto
        try {
            abrirConexion();
            PreparedStatement st = con.prepareStatement("Delete producto where codProducto = " + codigo + "");
            st.executeUpdate();
            st.close();
            cerrarConexion();
            System.out.println("Se eliminó correctamente");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Producto obtenerUnProducto(int codigo) {
        ArrayList<Producto> lst = obtenerProductos();
        Producto producto = new Producto();
        for (Producto pr : lst) {
            if (codigo == pr.getCodigo()) {
                producto = pr;
            } else {
                System.out.println("No existe ningun producto con el codigo ingresado");
            }
        }
        return producto;
    }

    public ArrayList<dtoListadoFaltantes> obtenerListadoFaltantes() {
        ArrayList<dtoListadoFaltantes> lista = new ArrayList();
        try {
            abrirConexion();
            String query = " select p.codProducto as 'codigoProducto', p.nombre as 'nombreProd',m.idMarca 'idMarca', m.nombre 'nombreMarca',p.stockMinimo as 'stockMinimo',\n" +
                            "(select sum(u.cantidad) from ubicacion u where u.idStock = s.idStock ) 'cantidad',fv.idFormaVenta 'idFormaVenta',"
                    + "fv.descripcion 'Forma de venta'\n" +
                            "from producto p join marca m on p.idMarca = m.idMarca \n" +
                            "join rubro r on p.idRubro = r.idRubro\n" +
                            "join formatoVenta f on f.codFormato = p.idFormato join stock s on s.codProducto = p.codProducto\n" +
                            "join formaVenta fv on fv.idFormaVenta = s.idFormaVenta\n" +
                            "where (select sum(u.cantidad) from ubicacion u where u.idStock = s.idStock ) < p.stockMinimo";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int codProducto = rs.getInt("codigoProducto");
                String nombre = rs.getString("nombreProd");
                int idMarca = rs.getInt("idMarca");
                String nombreMarca = rs.getString("nombreMarca");
                int stockMinimo = rs.getInt("stockMinimo");
                Marca marca = new Marca(idMarca, nombreMarca);
                Producto producto = new Producto(codProducto, nombre, stockMinimo, marca);
                int cantidad= rs.getInt("cantidad");
                int idFormaVenta = rs.getInt("idFormaVenta");
                String descripcionFormaVenta = rs.getString("Forma de venta");
                FormaVenta formaVenta = new FormaVenta(idFormaVenta, descripcionFormaVenta);
                dtoListadoFaltantes dto = new dtoListadoFaltantes(producto, cantidad, formaVenta);
                lista.add(dto);
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            cerrarConexion();
        }
        return lista;
    }

}
