package Ventana;

import Controladores.ControladorCantidadMovimientos;
import Controladores.controladorProducto;
import DTO.dtoCantidadMovimiento;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ginin
 */
public class CantidadDeMovimientos extends javax.swing.JFrame {

    private controladorProducto controlador;
    private Controladores.ControladorCantidadMovimientos controlCantidad;
    DefaultTableModel modelo;

    public CantidadDeMovimientos() {
        initComponents();
        controlador = new controladorProducto();
        controlCantidad = new ControladorCantidadMovimientos();

    }

    //Cargo ComboBox Marca
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnModificarProducto = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        BtnCancelarAltaProducto1 = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableCantidad = new javax.swing.JTable();
        fecha2 = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        fecha1 = new com.toedter.calendar.JDateChooser();
        Fondo = new javax.swing.JLabel();

        btnModificarProducto.setBackground(new java.awt.Color(102, 0, 0));
        btnModificarProducto.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnModificarProducto.setForeground(new java.awt.Color(255, 255, 0));
        btnModificarProducto.setText("Modificar");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Light", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Cantidad de movimientos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 290, 80));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 0, 0));
        jLabel11.setText("Fecha 2:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, -1, -1));

        BtnCancelarAltaProducto1.setBackground(new java.awt.Color(102, 0, 0));
        BtnCancelarAltaProducto1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        BtnCancelarAltaProducto1.setForeground(new java.awt.Color(255, 255, 0));
        BtnCancelarAltaProducto1.setText("Cancelar");
        BtnCancelarAltaProducto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarAltaProducto1ActionPerformed(evt);
            }
        });
        getContentPane().add(BtnCancelarAltaProducto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 540, 100, 30));

        btnBuscar.setBackground(new java.awt.Color(102, 0, 0));
        btnBuscar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 0));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, 100, 30));

        jtableCantidad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "Fecha", "Cantidad "
            }
        ));
        jScrollPane1.setViewportView(jtableCantidad);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 590, 190));
        getContentPane().add(fecha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 210, 30));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 0, 0));
        jLabel12.setText("Fecha 1:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, -1, -1));
        getContentPane().add(fecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 210, 30));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/easyCarga.png"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Arranco botón Buscar Producto
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {

            java.util.Date var1 = fecha1.getDate();
            java.util.Date var2 = fecha2.getDate();
            ArrayList<dtoCantidadMovimiento> lst = controlCantidad.ObtenerCantidad(var1, var2);

            modelo = new DefaultTableModel();

            modelo.setColumnIdentifiers(new String[]{"Codigo de Remito", "Fecha de creación", "Cantidad de Productos", "Tipo de Movimiento"});

            for (dtoCantidadMovimiento dto : lst) {
                modelo.addRow(new Object[]{dto.getNroRemito(), dto.getFecha(), dto.getCantidad(), dto.getNombre()});
                // cantProd = dto.getCantidad();
            }
            jtableCantidad.setModel(modelo);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            
            JOptionPane.showMessageDialog(null, "Debe ingresar las fechas correspondientes");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    //Arranco Boton Cancelar
    private void BtnCancelarAltaProducto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarAltaProducto1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_BtnCancelarAltaProducto1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CantidadDeMovimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CantidadDeMovimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CantidadDeMovimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CantidadDeMovimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CantidadDeMovimientos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancelarAltaProducto1;
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnModificarProducto;
    private com.toedter.calendar.JDateChooser fecha1;
    private com.toedter.calendar.JDateChooser fecha2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtableCantidad;
    // End of variables declaration//GEN-END:variables
}
