package Ventana;

import Controladores.ControladorFormatoVenta;
import Controladores.ControladorMarca;
import Controladores.ControladorRubro;
import Controladores.controladorProducto;
import Modelos.FormatoVenta;
import Modelos.Marca;
import Modelos.Producto;
import Modelos.Rubro;
import java.util.ArrayList;
import javax.persistence.Convert;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author ginin
 */
public class Carga_Producto extends javax.swing.JFrame {

    private controladorProducto controlador;

    public Carga_Producto() {
        initComponents();
        controlador = new controladorProducto();
        cargarMarca();
        cargarFormatoVenta();
        cargarRubro();
    }
    
            //Cargo ComboBox Marca
    public void cargarMarca() {
        Controladores.ControladorMarca controla = new ControladorMarca();
        ArrayList<Marca> lst = controla.obtenerMarca();
        DefaultComboBoxModel model = new DefaultComboBoxModel();

        for (Marca m : lst) {
            model.addElement(m);
        }
        cboMarcaProducto.setModel(model);
    }
    
            //Cargo ComboBox Rubro
    public void cargarRubro() {
        Controladores.ControladorRubro controla = new ControladorRubro();
        ArrayList<Rubro> lst = controla.obtenerRubro();
        DefaultComboBoxModel model = new DefaultComboBoxModel();

        for (Rubro r : lst) {
            model.addElement(r);
        }
        cboRubroProducto.setModel(model);
    }
    
            //Cargo ComboBox FormatoVenta
    public void cargarFormatoVenta() {
        Controladores.ControladorFormatoVenta controla = new ControladorFormatoVenta();
        ArrayList<FormatoVenta> lst = controla.obtenerFormatoVenta();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        
        for (FormatoVenta f : lst) {
            model.addElement(f);
        }
        cboFormatoVentaProducto.setModel(model);
    }
    
            //Metodo para borrar los campos. 
    public void limpiarCampos() {
        txtCodigoProducto.setText("");
        txtNombreProducto.setText("");
        txtStockMinimoProducto.setText("");
        txtTamañoProducto.setText("");
        cboMarcaProducto.setSelectedIndex(-1);
        cboRubroProducto.setSelectedIndex(-1);
        cboFormatoVentaProducto.setSelectedIndex(-1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnModificarProducto = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtNombreProducto = new javax.swing.JTextField();
        txtTamañoProducto = new javax.swing.JTextField();
        txtStockMinimoProducto = new javax.swing.JTextField();
        txtCodigoProducto = new javax.swing.JTextField();
        btnCargarProducto = new javax.swing.JButton();
        btnEliminarProducto = new javax.swing.JButton();
        cboMarcaProducto = new javax.swing.JComboBox<>();
        cboFormatoVentaProducto = new javax.swing.JComboBox<>();
        cboRubroProducto = new javax.swing.JComboBox<>();
        BtnCancelarAltaProducto1 = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnModificarProducto2 = new javax.swing.JButton();
        Fondo = new javax.swing.JLabel();

        btnModificarProducto.setBackground(new java.awt.Color(102, 0, 0));
        btnModificarProducto.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnModificarProducto.setForeground(new java.awt.Color(255, 255, 0));
        btnModificarProducto.setText("Modificar");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Light", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Administrar Productos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 290, 80));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel3.setText("Tamaño:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 0, 0));
        jLabel4.setText("Rubro:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 0, 0));
        jLabel5.setText("Marca:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 0, 0));
        jLabel6.setText("Stock minimo:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 0, 0));
        jLabel7.setText("Nombre:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 0, 0));
        jLabel10.setText("Formato de venta:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 390, -1, -1));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 0, 0));
        jLabel11.setText("Codigo:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));
        getContentPane().add(txtNombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 160, 30));

        txtTamañoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTamañoProductoActionPerformed(evt);
            }
        });
        getContentPane().add(txtTamañoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 280, 160, 30));

        txtStockMinimoProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockMinimoProductoKeyTyped(evt);
            }
        });
        getContentPane().add(txtStockMinimoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 160, 30));

        txtCodigoProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoProductoKeyTyped(evt);
            }
        });
        getContentPane().add(txtCodigoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 160, 30));

        btnCargarProducto.setBackground(new java.awt.Color(102, 0, 0));
        btnCargarProducto.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnCargarProducto.setForeground(new java.awt.Color(255, 255, 0));
        btnCargarProducto.setText("Cargar");
        btnCargarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarProductoActionPerformed(evt);
            }
        });
        getContentPane().add(btnCargarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 540, 100, 30));

        btnEliminarProducto.setBackground(new java.awt.Color(102, 0, 0));
        btnEliminarProducto.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnEliminarProducto.setForeground(new java.awt.Color(255, 255, 0));
        btnEliminarProducto.setText("Eliminar");
        btnEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 540, 100, 30));

        cboMarcaProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", " " }));
        getContentPane().add(cboMarcaProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 350, 160, 30));

        cboFormatoVentaProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", " " }));
        getContentPane().add(cboFormatoVentaProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 430, 160, 30));

        cboRubroProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", " " }));
        getContentPane().add(cboRubroProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 160, 30));

        BtnCancelarAltaProducto1.setBackground(new java.awt.Color(102, 0, 0));
        BtnCancelarAltaProducto1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        BtnCancelarAltaProducto1.setForeground(new java.awt.Color(255, 255, 0));
        BtnCancelarAltaProducto1.setText("Cancelar");
        BtnCancelarAltaProducto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarAltaProducto1ActionPerformed(evt);
            }
        });
        getContentPane().add(BtnCancelarAltaProducto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, 100, 30));

        btnBuscar.setBackground(new java.awt.Color(102, 0, 0));
        btnBuscar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 0));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 100, 30));

        btnModificarProducto2.setBackground(new java.awt.Color(102, 0, 0));
        btnModificarProducto2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnModificarProducto2.setForeground(new java.awt.Color(255, 255, 0));
        btnModificarProducto2.setText("Modificar");
        btnModificarProducto2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarProducto2ActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificarProducto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 540, 100, 30));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/easyCarga.png"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTamañoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTamañoProductoActionPerformed
        
    }//GEN-LAST:event_txtTamañoProductoActionPerformed
        
            //Arranco botón Cargar Producto.
    private void btnCargarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarProductoActionPerformed

        String nombre = txtNombreProducto.getText();
        String tamnio = txtTamañoProducto.getText();
        int stockMinimo = 0;
        try {
            stockMinimo = Integer.parseInt(txtStockMinimoProducto.getText());
            Marca marca = (Marca) cboMarcaProducto.getSelectedItem();
            Rubro rubro = (Rubro) (cboRubroProducto).getSelectedItem();
            FormatoVenta formatoVenta = (FormatoVenta) (cboFormatoVentaProducto).getSelectedItem();
            Producto nuevo = new Producto(nombre, stockMinimo, marca, rubro, formatoVenta, tamnio);
            controlador.agregarProducto(nuevo);
            JOptionPane.showMessageDialog(null, "El producto se agregó correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hay un error al cargar el nuevo producto");
        }
        limpiarCampos();
    }//GEN-LAST:event_btnCargarProductoActionPerformed
            //Arranco botón Buscar Producto
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            
            int codigo = Integer.parseInt(txtCodigoProducto.getText());
            if(Integer.parseInt(txtCodigoProducto.getText()) != controlador.obtenerUnProducto(codigo).getCodigo()){
                 JOptionPane.showMessageDialog(null, "No existe");
              }
                Producto producto = controlador.obtenerUnProducto(codigo);
                txtNombreProducto.setText(producto.getNombreProducto());
                txtStockMinimoProducto.setText(String.valueOf(producto.getStockMinimo()));
                txtTamañoProducto.setText(producto.getTamanio());
                cboMarcaProducto.getModel().setSelectedItem(producto.getMarca());
                cboRubroProducto.getModel().setSelectedItem(producto.getRubro());
                cboFormatoVentaProducto.getModel().setSelectedItem(producto.getFormatoVenta());
         
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el codigo del producto que desea buscar");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed
        //Arranco botón Eliminar Producto
    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
        int cod = 0;
        try {
            cod = Integer.parseInt(txtCodigoProducto.getText());
            JOptionPane.showMessageDialog(null, "El producto fue eliminado correctamente. ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El producto no pudo ser eliminado");
        }
        controlador.eliminarProducto(cod);
        limpiarCampos();

    }//GEN-LAST:event_btnEliminarProductoActionPerformed
            //Arranco botón Modificar Producto
    private void btnModificarProducto2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarProducto2ActionPerformed
        String nombre = txtNombreProducto.getText().trim();
        try {
            int codigo = Integer.parseInt(txtCodigoProducto.getText().trim());
            Marca marca = (Marca) cboMarcaProducto.getSelectedItem();
            Rubro rubro = (Rubro) cboRubroProducto.getSelectedItem();
            FormatoVenta formato = (FormatoVenta) cboFormatoVentaProducto.getSelectedItem();
            String volumen = txtTamañoProducto.getText().trim();
            int stockMinimo = Integer.parseInt(txtStockMinimoProducto.getText().trim());
            Producto p = new Producto(codigo, nombre, stockMinimo, marca, rubro, formato, volumen);
            if (controlador.actualizarProducto(p)) {
                JOptionPane.showMessageDialog(this, "Se actualizó correctamente el prodcuto");
                limpiarCampos();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnModificarProducto2ActionPerformed

    private void txtCodigoProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoProductoKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && (car < ',' || car > '.')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCodigoProductoKeyTyped

    private void txtStockMinimoProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockMinimoProductoKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && (car < ',' || car > '.')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtStockMinimoProductoKeyTyped
    //Arranco Boton Cancelar
    private void BtnCancelarAltaProducto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarAltaProducto1ActionPerformed
        limpiarCampos();
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
            java.util.logging.Logger.getLogger(Carga_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Carga_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Carga_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Carga_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Carga_Producto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancelarAltaProducto1;
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCargarProducto;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnModificarProducto;
    private javax.swing.JButton btnModificarProducto2;
    private javax.swing.JComboBox<String> cboFormatoVentaProducto;
    private javax.swing.JComboBox<String> cboMarcaProducto;
    private javax.swing.JComboBox<String> cboRubroProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtCodigoProducto;
    private javax.swing.JTextField txtNombreProducto;
    private javax.swing.JTextField txtStockMinimoProducto;
    private javax.swing.JTextField txtTamañoProducto;
    // End of variables declaration//GEN-END:variables
}
