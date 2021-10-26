/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Rol;
import Modelos.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
            String query = "select u.legajo as legajoUsuario, u.nombre, u.contrasenia, u.idRol, r.nombre as nombreRol from usuario u join rol r on u.idRol = r.idRol";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                int legajo = rs.getInt("legajoUsuario");
                String nombre = rs.getString("nombre");
                String contrasenia = rs.getString("contrasenia");
                int idRol = rs.getInt("idRol");
                String nombreRol = rs.getString("nombreRol");
                Rol rol = new Rol(idRol, nombreRol);
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
    
    public Usuario obtenerUsuarioPorLegajo(int legajo){
        ArrayList<Usuario> listaUsuario = obtenerUsuarios();
        Usuario usuario = null;
        for (Usuario X : listaUsuario) {
            if(X.getLegajo() == legajo){
                usuario = X;
            }
        }
        return usuario;
    }
    
    public ArrayList<Integer> obtenerLegajos(){
        ArrayList<Integer> ListaLegajos = new ArrayList<Integer>();
        try {
            abrirConexion();
            String query = "select legajo from usuario";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                int legajo = rs.getInt("legajo");                
                ListaLegajos.add(legajo);
            }
        } catch (SQLException ex) {
            System.out.println(ex);;
        }finally{
            cerrarConexion();
        }
        return ListaLegajos;
        
    }
    
    public boolean agregarUsuario(Usuario usuario) {        
        
        boolean insert = false;
        try {
            abrirConexion();
            String query = "INSERT INTO usuario(nombre,contrasenia,idRol) VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,usuario.getNombreUsuario());
            ps.setString(2,usuario.getContrasenia());
            ps.setInt(3,usuario.getRolUsuario().getIdRol());
            ps.execute();
            insert = true;
        } catch (SQLException ex) {
            System.out.println(ex);
        }finally{
            cerrarConexion();
        }
        return insert;
    }
    
    public boolean actualizarUsuario(String nombre, String contrasenia, int idRol, int legajo){
        boolean actualizar = false;
        
        try{
            abrirConexion();
            String query = "update usuario set nombre=?, contrasenia=?, idRol=? where legajo=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, nombre);
            ps.setString(2, contrasenia);
            ps.setInt(3, idRol);
            ps.setInt(4, legajo);
            ps.execute();
            actualizar=true;
        }catch(SQLException ex){
            System.out.println(ex);
        }
        finally{
            cerrarConexion();
        }
        
        return actualizar;
    }    
    
    public boolean eliminarUsuario(int legajo){
        boolean eliminar = false;
        try{
            abrirConexion();
            String query = "delete from usuario where legajo=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, legajo);
            ps.execute();
            eliminar=true;            
        }catch(SQLException ex){
            System.out.println(ex);
        }
        finally{
        cerrarConexion();
    }
        
        
        return eliminar;
    }
}
