/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

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

    public boolean agregarProducto(Producto p) {  //Arranco botón Agregar Producto.
        boolean insert = false;
        try {
            abrirConexion();
            String query = "Insert into producto(nombre, idMarca, idRubro, volumen, idFormato, stockMinimo)values (?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, p.getNombreProducto());
            st.setInt(2, p.getMarca().getIdMarca());
            st.setInt(3, p.getRubro().getIdRubro());
            st.setString(4, p.getTamanio());
            st.setInt(5, p.getFormatoVenta().getCodigo());
            st.setInt(6, p.getStockMinimo());

            st.execute();
            cerrarConexion();
            insert = true;
            System.out.println("Se agrego correctamente");
        } catch (Exception e) {
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
        }finally{
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
            }else{
                System.out.println("No existe ningun producto con el codigo ingresado");
            }
        }
        return producto;
    }

}
