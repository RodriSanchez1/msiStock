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
 * @author Alex
 */
public class controladorUsuario {

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

    public ArrayList<Usuario> obtenerUsuarios(){
        ArrayList<Usuario> ListaUsuarios = new ArrayList<Usuario>();
        try {
            abrirConexion();
            String query = "select * from usuario";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                int legajo = rs.getInt("legajo");
                String nombre = rs.getString("nombre");
                String contrasenia = rs.getString("contrasenia");
                int rol = rs.getInt("idRol");
                Usuario usuario = new Usuario (legajo, nombre, contrasenia, rol);
                ListaUsuarios.add(usuario);
            }
        } catch (SQLException ex) {
            System.out.println(ex);;
        }finally{
            cerrarConexion();
        }
        return ListaUsuarios;
    }
    
}
