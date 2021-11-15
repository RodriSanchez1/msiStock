/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

import Modelos.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author ginin
 */
public class menuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form Carga_Producto
     */
    private Usuario usu;

    public menuPrincipal() {
        initComponents();

        deshabilitarBotones();

    }

    public menuPrincipal(Usuario usu) {
        initComponents();
        this.usu = usu;
        deshabilitarBotones();
        System.out.println(usu.getRolUsuario().getIdRol());

        switch (usu.getRolUsuario().getIdRol()) {
            case 1: {
                btnAdmin.setEnabled(true);
                break;
            }
            case 2: {
                btnVend1.setEnabled(true);
                btnVend2.setEnabled(true);
                break;
            }
            case 3: {
                btnVend1.setEnabled(true);
                btnVend2.setEnabled(true);
                break;
            }
            case 4: {
                btnRep1.setEnabled(true);
                break;
            }
            case 5: {
                btnAuxRec1.setEnabled(true);
                break;
            }
            case 6: {
                btnAuxAlmaUbicarPro.setEnabled(true);
                btnAuxAlmaModificarUbi.setEnabled(true);
                btnAuxAlmaElimRemito.setEnabled(true);
                btnAuxAlmaABMPro.setEnabled(true);
                break;
            }
            case 7: {
                btnEncDep4.setEnabled(true);
                btnEncDep6.setEnabled(true);
                btnEncDep7.setEnabled(true);
                break;
            }
            default:
                JOptionPane.showMessageDialog(this, "Error al redireccionar. Intente de nuevo.");
                break;
        }
    }

    public void deshabilitarBotones() {
        btnAdmin.setEnabled(false);
        btnAuxAlmaUbicarPro.setEnabled(false);
        btnAuxAlmaModificarUbi.setEnabled(false);
        btnAuxRec1.setEnabled(false);
        btnAuxAlmaElimRemito.setEnabled(false);
        btnEncDep4.setEnabled(false);
        btnEncDep6.setEnabled(false);
        btnEncDep7.setEnabled(false);
        btnAuxAlmaABMPro.setEnabled(false);
        btnRep1.setEnabled(false);
        btnVend1.setEnabled(false);
        btnVend2.setEnabled(false);
    }

    /**
     * vamo a ve que ondara esto878hh8u9uh This method is called from within the
     * constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAuxAlmaUbicarPro = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        btnAuxAlmaModificarUbi = new javax.swing.JButton();
        btnAdmin = new javax.swing.JButton();
        btnAuxRec1 = new javax.swing.JButton();
        btnAuxAlmaElimRemito = new javax.swing.JButton();
        btnEncDep4 = new javax.swing.JButton();
        btnEncDep6 = new javax.swing.JButton();
        btnEncDep7 = new javax.swing.JButton();
        btnAuxAlmaABMPro = new javax.swing.JButton();
        btnVend1 = new javax.swing.JButton();
        btnVend2 = new javax.swing.JButton();
        btnRep1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAuxAlmaUbicarPro.setBackground(new java.awt.Color(102, 0, 0));
        btnAuxAlmaUbicarPro.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnAuxAlmaUbicarPro.setForeground(new java.awt.Color(255, 255, 0));
        btnAuxAlmaUbicarPro.setText("Ubicar Productos");
        btnAuxAlmaUbicarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAuxAlmaUbicarProActionPerformed(evt);
            }
        });
        getContentPane().add(btnAuxAlmaUbicarPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, 30));

        jButton10.setBackground(new java.awt.Color(51, 51, 51));
        jButton10.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Salir");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 620, 170, 50));

        btnAuxAlmaModificarUbi.setBackground(new java.awt.Color(102, 0, 0));
        btnAuxAlmaModificarUbi.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnAuxAlmaModificarUbi.setForeground(new java.awt.Color(255, 255, 0));
        btnAuxAlmaModificarUbi.setText("Modificar ubicacion de productos");
        btnAuxAlmaModificarUbi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAuxAlmaModificarUbiActionPerformed(evt);
            }
        });
        getContentPane().add(btnAuxAlmaModificarUbi, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 270, 30));

        btnAdmin.setBackground(new java.awt.Color(102, 0, 0));
        btnAdmin.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnAdmin.setForeground(new java.awt.Color(255, 255, 0));
        btnAdmin.setText("Administrar usuarios");
        btnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, 180, 30));

        btnAuxRec1.setBackground(new java.awt.Color(102, 0, 0));
        btnAuxRec1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnAuxRec1.setForeground(new java.awt.Color(255, 255, 0));
        btnAuxRec1.setText("Generar remito interno de entrada");
        btnAuxRec1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAuxRec1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnAuxRec1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 280, 30));

        btnAuxAlmaElimRemito.setBackground(new java.awt.Color(102, 0, 0));
        btnAuxAlmaElimRemito.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnAuxAlmaElimRemito.setForeground(new java.awt.Color(255, 255, 0));
        btnAuxAlmaElimRemito.setText("Eliminar remitos internos");
        btnAuxAlmaElimRemito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAuxAlmaElimRemitoActionPerformed(evt);
            }
        });
        getContentPane().add(btnAuxAlmaElimRemito, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 300, 220, 30));

        btnEncDep4.setBackground(new java.awt.Color(102, 0, 0));
        btnEncDep4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnEncDep4.setForeground(new java.awt.Color(255, 255, 0));
        btnEncDep4.setText("Generar listado de faltantes");
        btnEncDep4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncDep4ActionPerformed(evt);
            }
        });
        getContentPane().add(btnEncDep4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 450, 230, 30));

        btnEncDep6.setBackground(new java.awt.Color(102, 0, 0));
        btnEncDep6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnEncDep6.setForeground(new java.awt.Color(255, 255, 0));
        btnEncDep6.setText("Calcular porcentaje de venta");
        btnEncDep6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncDep6ActionPerformed(evt);
            }
        });
        getContentPane().add(btnEncDep6, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 450, 240, 30));

        btnEncDep7.setBackground(new java.awt.Color(102, 0, 0));
        btnEncDep7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnEncDep7.setForeground(new java.awt.Color(255, 255, 0));
        btnEncDep7.setText("Generar reportes de movimientos");
        btnEncDep7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncDep7ActionPerformed(evt);
            }
        });
        getContentPane().add(btnEncDep7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 280, 30));

        btnAuxAlmaABMPro.setBackground(new java.awt.Color(102, 0, 0));
        btnAuxAlmaABMPro.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnAuxAlmaABMPro.setForeground(new java.awt.Color(255, 255, 0));
        btnAuxAlmaABMPro.setText("Administrar Productos");
        btnAuxAlmaABMPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAuxAlmaABMProActionPerformed(evt);
            }
        });
        getContentPane().add(btnAuxAlmaABMPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 300, 30));

        btnVend1.setBackground(new java.awt.Color(102, 0, 0));
        btnVend1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnVend1.setForeground(new java.awt.Color(255, 255, 0));
        btnVend1.setText("Generar remito interno de salida");
        btnVend1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVend1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnVend1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, 270, 30));

        btnVend2.setBackground(new java.awt.Color(102, 0, 0));
        btnVend2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnVend2.setForeground(new java.awt.Color(255, 255, 0));
        btnVend2.setText("Dsiponibilidad de producto");
        btnVend2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVend2ActionPerformed(evt);
            }
        });
        getContentPane().add(btnVend2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 540, 230, 30));

        btnRep1.setBackground(new java.awt.Color(102, 0, 0));
        btnRep1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnRep1.setForeground(new java.awt.Color(255, 255, 0));
        btnRep1.setText("Modificar ubicacion de productos");
        btnRep1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRep1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnRep1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 630, 290, 30));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 0), 2, true), "Auxiliar de Almacenamiento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(255, 255, 0))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 730, 150));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 0), 2, true), "Administrador", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(255, 255, 0))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, 310, 80));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 0), 2, true), "Auxiliar de recepcion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(255, 255, 0))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 350, 80));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));
        jLabel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 0), 2, true), "Encargado de Deposito", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(255, 255, 0))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 790, 80));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 0));
        jLabel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 0), 2, true), "Repositor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(255, 255, 0))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, 340, 80));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 0));
        jLabel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 0), 2, true), "Vendedor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(255, 255, 0))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 560, 80));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotoneraMenu.png"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAuxAlmaUbicarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAuxAlmaUbicarProActionPerformed
        Ubicar_ProductoLista ubicarProducto = new Ubicar_ProductoLista();
        ubicarProducto.setVisible(true);
    }//GEN-LAST:event_btnAuxAlmaUbicarProActionPerformed

    private void btnAuxAlmaModificarUbiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAuxAlmaModificarUbiActionPerformed
       Modificar_Ubicacion_Producto mu = new  Modificar_Ubicacion_Producto();
       mu.setVisible(true);
    }//GEN-LAST:event_btnAuxAlmaModificarUbiActionPerformed

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed
        CrearUsario crearUsario = new CrearUsario();
        crearUsario.setVisible(true);
    }//GEN-LAST:event_btnAdminActionPerformed

    private void btnAuxRec1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAuxRec1ActionPerformed
        movInterno movInterno = new movInterno(usu);
        movInterno.setVisible(true);
    }//GEN-LAST:event_btnAuxRec1ActionPerformed

    private void btnEncDep4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncDep4ActionPerformed
        Listado_Faltantes_Productos listadoFaltantes = new Listado_Faltantes_Productos();
        listadoFaltantes.setVisible(true);
    }//GEN-LAST:event_btnEncDep4ActionPerformed

    private void btnEncDep6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncDep6ActionPerformed
        new Porcentaje_Venta_OnlinePresencial().setVisible(true);
    }//GEN-LAST:event_btnEncDep6ActionPerformed

    private void btnEncDep7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncDep7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEncDep7ActionPerformed

    private void btnAuxAlmaABMProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAuxAlmaABMProActionPerformed
        Carga_Producto cargaProducto = new Carga_Producto();
        cargaProducto.setVisible(true);
    }//GEN-LAST:event_btnAuxAlmaABMProActionPerformed

    private void btnVend1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVend1ActionPerformed
        movInterno movInterno = new movInterno(usu);
        movInterno.setVisible(true);
    }//GEN-LAST:event_btnVend1ActionPerformed

    private void btnVend2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVend2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVend2ActionPerformed

    private void btnRep1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRep1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRep1ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        this.dispose();
        new VentanaLogin().setVisible(true);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void btnEncDep6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncDep6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEncDep6ActionPerformed

    private void btnAuxAlmaElimRemitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAuxAlmaElimRemitoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAuxAlmaElimRemitoActionPerformed

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
            java.util.logging.Logger.getLogger(menuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton btnAdmin;
    private javax.swing.JButton btnAuxAlmaABMPro;
    private javax.swing.JButton btnAuxAlmaElimRemito;
    private javax.swing.JButton btnAuxAlmaModificarUbi;
    private javax.swing.JButton btnAuxAlmaUbicarPro;
    private javax.swing.JButton btnAuxRec1;
    private javax.swing.JButton btnEncDep4;
    private javax.swing.JButton btnEncDep6;
    private javax.swing.JButton btnEncDep7;
    private javax.swing.JButton btnRep1;
    private javax.swing.JButton btnVend1;
    private javax.swing.JButton btnVend2;
    private javax.swing.JButton jButton10;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
