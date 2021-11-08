/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package msiapp;

import Controladores.controladorUsuario;
import Modelos.Usuario;
import Ventana.Carga_Producto;
import Ventana.CrearUsario;
import Ventana.Disponibilidad_Producto;
import Ventana.Eliminar_Remito;
import Ventana.Ingresar_Producto;
import Ventana.Listado_Faltantes_Productos;
import Ventana.Listado_Productos;
import Ventana.Modificar_Eliminar_Producto;
import Ventana.Modificar_Remito_Entrada;
import Ventana.Modificar_Remito_Salida;
import Ventana.Modificar_Ubicacion_Producto;
import Ventana.Porcentaje_Venta_OnlinePresencial;
import Ventana.Ubicar_Producto;
import Ventana.VentanaLogin;
import Ventana.menuPrincipal;
import Ventana.movInterno;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ginin
 */
public class MSIapp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

       // new CrearUsario().setVisible(true);
        new movInterno("admin").setVisible(true);
        new VentanaLogin().setVisible(true);
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver no encontrado!");
            return;
        }

        
    }

}
