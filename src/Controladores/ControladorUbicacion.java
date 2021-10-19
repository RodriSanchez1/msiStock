/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Producto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Flor
 */
public class ControladorUbicacion {
    
    private final String url = "jdbc:sqlserver://db-instance-rs.cetddq7pslga.sa-east-1.rds.amazonaws.com;databaseName=easyStock";
    private final String usuario = "admin";
    private final String contra = "admin1234";
    
   
 

    public void ubicarProducto( Stock stock){
        try{
            Connection conexion = DriverManager.getConnection(url, usuario, contra);
            PreparedStatement ps = conexion.prepareStatement("");
            
        }catch(Exception e){
             JFrame jframe = new JFrame();
                JOptionPane.showMessageDialog( jframe , "El producto a ubicar no se encuentra en la base de datos");
            
        }        
    }
    
}
