/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DTO.dtoUbicacion;
import Modelos.Estanteria;
import Modelos.FormaVenta;
import Modelos.LugarUbicacion;
import Modelos.Producto;
import Modelos.Remito;
import Modelos.Sector;
import Modelos.Stock;
import Modelos.Ubicacion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Flor
 */
public class ControladorUbicacion {

    // private final String url = "jdbc:sqlserver://db-instance-rs.cetddq7pslga.sa-east-1.rds.amazonaws.com;databaseName=easyStock";
//    private final String url = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=easyStock";
//    private final String usuario = "sa";
//    private final String contra = "1995";
    //private final String usuario = "admin";
    //private final String contra = "admin1234";
    public void crearUbicacion(Ubicacion ubi) {

        try {
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=easyStock; integratedsecurity=true");
            // Connection conexion = DriverManager.getConnection(url, usuario, contra);
            PreparedStatement ps = conexion.prepareStatement("insert into ubicacion ( cantidad, idEstanteria,idStock) values ( ?, ?,?)", Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, ubi.getCantidad());
            ps.setInt(2, ubi.getEstanteria().getId());
            ps.setInt(3,ubi.getIdStock());
            try {
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                int idAutoIncrement = rs.getInt(1);
                ubi.setId(idAutoIncrement);
            } catch (Exception e) {
                JFrame jframe = new JFrame();
                JOptionPane.showMessageDialog(jframe, "Debe seleccionar una estanter??a");
            }
            ps.close();
            conexion.close();

        } catch (Exception e) {
            Logger.getLogger(ControladorUbicacion.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void ubicarProducto(Stock stock) {
        try {
            //Connection conexion = DriverManager.getConnection(url, usuario, contra);
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=easyStock; integratedsecurity=true");
            PreparedStatement ps = conexion.prepareStatement("insert into stock (cod_producto, cantidad, id_ubicacion, id_forma_venta) values (?, ?,?, ?)");

            ps.setInt(1, stock.getProducto().getCodigo());
            // ps.setInt (2, stock.getCantidad());
            ps.setInt(3, stock.getUbicacion().getId());
            ps.setInt(4, stock.getFormaVenta().getIdFormaVenta());

            try {
                ps.executeUpdate();
            } catch (Exception e) {
                JFrame jframe = new JFrame();
                JOptionPane.showMessageDialog(jframe, "Error en la carga de alg??n dato");
            }
            ps.close();
            conexion.close();

        } catch (Exception e) {
            Logger.getLogger(ControladorUbicacion.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public ArrayList<LugarUbicacion> obtenerLugarUbicacion() {
        ArrayList<LugarUbicacion> lista = new ArrayList<>();

        try {
            //Connection conexion = DriverManager.getConnection(url, usuario, contra);
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=easyStock; integratedsecurity=true");
            String Consulta = "select codAlmacenamiento, nombre from lugarAlmacenamiento ";
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(Consulta);

            while (rs.next()) {
                int cod = rs.getInt("codAlmacenamiento");
                String nombreUBi = rs.getString("nombre");

                LugarUbicacion lugar = new LugarUbicacion(cod, nombreUBi);
                lista.add(lugar);

            }

        } catch (SQLException e) {
            Logger.getLogger(ControladorUbicacion.class.getName()).log(Level.SEVERE, null, e);

        }
        return lista;
    }

    public ArrayList<Sector> obtenerSector(int idLugarUbicacion) {
        ArrayList<Sector> lista = new ArrayList<>();

        try {
            //Connection conexion = DriverManager.getConnection(url, usuario, contra);
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=easyStock; integratedsecurity=true");
            String Consulta = "select idSector, nombre from sector where "
                    + "lugarAlmacenamiento = " + idLugarUbicacion + "";
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(Consulta);

            while (rs.next()) {
                int cod = rs.getInt("idSector");
                String nombreUBi = rs.getString("nombre");

                Sector sector = new Sector(cod, nombreUBi, null);
                lista.add(sector);

            }

        } catch (SQLException e) {
            Logger.getLogger(ControladorUbicacion.class.getName()).log(Level.SEVERE, null, e);

        }
        return lista;
    }

    public ArrayList<Estanteria> obtenerEstanteria(int idSector) {
        ArrayList<Estanteria> lista = new ArrayList<>();

        try {
            //Connection conexion = DriverManager.getConnection(url, usuario, contra);
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=easyStock; integratedsecurity=true");
            String Consulta = "select idEstanteria, descripcion from Estanteria where idSector = " + idSector + "";
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(Consulta);

            while (rs.next()) {
                int cod = rs.getInt("idEstanteria");
                String nombreUBi = rs.getString("descripcion");

                Estanteria estanteria = new Estanteria(cod, nombreUBi);
                lista.add(estanteria);

            }

        } catch (SQLException e) {
            Logger.getLogger(ControladorUbicacion.class.getName()).log(Level.SEVERE, null, e);

        }
        return lista;
    }

    public ArrayList<FormaVenta> obtenerFormaVenta() {
        ArrayList<FormaVenta> lista = new ArrayList<>();

        try {
            //Connection conexion = DriverManager.getConnection(url, usuario, contra);
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=easyStock; integratedsecurity=true");
            String Consulta = "select idFormaVenta, descripcion from formaVenta ";
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(Consulta);

            while (rs.next()) {
                int cod = rs.getInt("idFormaVenta");
                String nombreUBi = rs.getString("descripcion");

                FormaVenta forma = new FormaVenta(cod, nombreUBi);
                lista.add(forma);

            }

        } catch (SQLException e) {
            Logger.getLogger(ControladorUbicacion.class.getName()).log(Level.SEVERE, null, e);

        }
        return lista;
    }

    public ArrayList<dtoUbicacion> buscarProducto(int id) {
        ArrayList<dtoUbicacion> lista = new ArrayList<>();

        try {
            //Connection conexion = DriverManager.getConnection(url, usuario, contra);
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=easyStock; integratedsecurity=true");
            String Consulta = "select fv.descripcion 'formaVenta', u.cantidad 'cantidad', lu.nombre 'lugar' , se.nombre 'sector', e.descripcion 'estante',\n" +
"                     u.idUbicacion 'idUbicacion', u.idEstanteria 'idEstanteria', s.idStock 'idStock' from producto p join stock s on p.codProducto = s.codProducto\n" +
"					 join formaVenta fv on fv.idFormaVenta = s.idFormaVenta\n" +
"                     join ubicacion u on s.idStock = u.idStock \n" +
"                     join Estanteria e on e.idEstanteria = u.idEstanteria\n" +
"                     join sector se on se.idSector = e.idSector\n" +
"                     join lugarAlmacenamiento lu on se.lugarAlmacenamiento = lu.codAlmacenamiento\n" +
"                    where u.cantidad not like 0 and  p.codProducto = " + id;
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(Consulta);

            while (rs.next()) {
                int idUbicacion = rs.getInt("idUbicacion");
                
                String nombreLugar = rs.getString("lugar");
                String nombreSector = rs.getString("sector");
                String estanteria = rs.getString("estante");
                int cant = rs.getInt("cantidad");
                String formaVenta = rs.getString("formaVenta");
                int idEstanteria = rs.getInt("idEstanteria");
                int idStock = rs.getInt("idStock");
                

                dtoUbicacion dto = new dtoUbicacion(idUbicacion,id, nombreLugar, nombreSector, estanteria, cant, formaVenta, idEstanteria,idStock);
                lista.add(dto);

            }

        } catch (SQLException e) {
            Logger.getLogger(ControladorUbicacion.class.getName()).log(Level.SEVERE, null, e);

        }

        return lista;
    }

    public boolean modificarUbicacionAlmacen(Stock stock, int cod) {
        boolean x = false;
        try {
            //Connection conexion = DriverManager.getConnection(url, usuario, contra);
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=easyStock; integratedsecurity=true");
            PreparedStatement ps = conexion.prepareStatement("update produccion set fecha = ? , cantidadProduccion = ? where id = ?");

            // ps.setString(1, stock.getFecha());
            ps.executeUpdate();
            ps.close();
            conexion.close();

            x = true;
            if (x = true) {
                JFrame jframe = new JFrame();
                JOptionPane.showMessageDialog(jframe, "Se actualiz?? la producci??n correctamente.");
            }
        } catch (Exception e) {
            x = false;
            JFrame jframe = new JFrame();
            JOptionPane.showMessageDialog(jframe, "Error, No se pudo actualizar la ubicaci??n del producto.");
        }
        return x;
    }

    public void crearUbicacion2(Ubicacion ubi) {
        System.out.println("comenzo el proceso");
        try {
            //Connection conexion = DriverManager.getConnection(url, usuario, contra);
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=easyStock; integratedsecurity=true");
            PreparedStatement ps = conexion.prepareStatement("insert into ubicacion (id_estanteria) values (?)", Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, ubi.getEstanteria().getId());

            try {
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                int idAutoIncrement = rs.getInt(1);
                ubi.setId(idAutoIncrement);
            } catch (Exception e) {
                JFrame jframe = new JFrame();
                JOptionPane.showMessageDialog(jframe, "Debe seleccionar una estanter??a");
            }
            ps.close();
            conexion.close();

        } catch (Exception e) {
            Logger.getLogger(ControladorUbicacion.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public ArrayList<dtoUbicacion> buscarProductoParaUbicar(int id) {
        ArrayList<dtoUbicacion> lista = new ArrayList<>();

        try {
            //Connection conexion = DriverManager.getConnection(url, usuario, contra);
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=easyStock; integratedsecurity=true");

            // Connection conexion = DriverManager.getConnection(url, usuario, contra);
            String Consulta = "select u.idUbicacion 'idUbicacion', p.nombre 'articulo' , u.cantidad  'cantidad', u.idStock 'idStock', s.idFormaVenta 'idFormaVenta', u.idEstanteria 'idEstanteria' from stock s join ubicacion u on s.idStock = u.idStock\n"
                    + " join producto p on p.codProducto = s.codProducto where u.idEstanteria is null and s.codProducto = " + id + " and cantidad > 0";
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(Consulta);

            while (rs.next()) {

                Integer idubi = rs.getInt("idUbicacion");
                Integer idEstanteria = rs.getInt("idEstanteria");
                String nombreProd = rs.getString("articulo");
                int cant = rs.getInt("cantidad");
                int idStock = rs.getInt("idStock");
                int idFormaVenta = rs.getInt("idFormaVenta");

                dtoUbicacion dto = new dtoUbicacion(idubi, id,idEstanteria, nombreProd, cant,idStock,idFormaVenta);
                lista.add(dto);

            }

        } catch (SQLException e) {
            Logger.getLogger(ControladorUbicacion.class.getName()).log(Level.SEVERE, null, e);

        }

        return lista;
    }

    public boolean modificarUbicacion(int id, int estanteria, int cant) {
        boolean x = false;
        try {
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=easyStock; integratedsecurity=true");

            //Connection conexion = DriverManager.getConnection(url, usuario, contra);
            PreparedStatement ps = conexion.prepareStatement("update ubicacion set idEstanteria = " + estanteria + " , cantidad = " + cant + " where idUbicacion = " + id + "");

            ps.executeUpdate();
            ps.close();
            conexion.close();

            x = true;
            if (x = true) {
                JFrame jframe = new JFrame();
                JOptionPane.showMessageDialog(jframe, "se Guard?? la ubicaci??n correctamente.");
            }
        } catch (Exception e) {
            x = false;
            JFrame jframe = new JFrame();
            JOptionPane.showMessageDialog(jframe, "Error, No se pudo cargar la ubicaci??n del producto.");
        }
        return x;
    }

    public boolean modificarUbicacion2(int id, int cant) {
        boolean x = false;
        try {
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=easyStock; integratedsecurity=true");

             //Connection conexion = DriverManager.getConnection(url, usuario, contra);
            PreparedStatement ps = conexion.prepareStatement("update ubicacion set cantidad = " + cant + " where idUbicacion = " + id + "");

            ps.executeUpdate();
            ps.close();
            conexion.close();

            x = true;
            if (x = true) {
                JFrame jframe = new JFrame();
                JOptionPane.showMessageDialog(jframe, "se Guard?? la ubicaci??n correctamente.");
            }
        } catch (Exception e) {
            x = false;
            JFrame jframe = new JFrame();
            JOptionPane.showMessageDialog(jframe, "Error, No se pudo cargar la ubicaci??n del producto.");
        }
        return x;
    }

}
