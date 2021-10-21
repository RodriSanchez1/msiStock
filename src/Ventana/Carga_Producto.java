
package Ventana;
import Controladores.ControladorMarca;
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
        controlador= new controladorProducto();
    }
    
    public void cargarMarca(){
       Controladores.ControladorMarca controla = new ControladorMarca();
       ArrayList<Marca> lst = controla.obtenerMarca();
       DefaultComboBoxModel model = new DefaultComboBoxModel();
       
        for (Marca m : lst) {
            model.addElement(m);
        }
        cboMarcaProducto.setModel(model);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        BtnCancelarAltaProducto = new javax.swing.JButton();
        cboMarcaProducto = new javax.swing.JComboBox<>();
        cboFormatoVentaProducto = new javax.swing.JComboBox<>();
        cboRubroProducto = new javax.swing.JComboBox<>();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Light", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Ingresar nuevo Producto");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 290, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel3.setText("Tamaño:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 0, 0));
        jLabel4.setText("Rubro:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 0, 0));
        jLabel5.setText("Marca:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 0, 0));
        jLabel6.setText("Stock minimo:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 0, 0));
        jLabel7.setText("Nombre:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, -1, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 0, 0));
        jLabel10.setText("Formato de venta:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, -1, -1));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 0, 0));
        jLabel11.setText("Codigo:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));
        getContentPane().add(txtNombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 160, 30));

        txtTamañoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTamañoProductoActionPerformed(evt);
            }
        });
        getContentPane().add(txtTamañoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 280, 160, 30));
        getContentPane().add(txtStockMinimoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 160, 30));
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
        getContentPane().add(btnCargarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 500, 100, 30));

        BtnCancelarAltaProducto.setBackground(new java.awt.Color(102, 0, 0));
        BtnCancelarAltaProducto.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        BtnCancelarAltaProducto.setForeground(new java.awt.Color(255, 255, 0));
        BtnCancelarAltaProducto.setText("Cancelar");
        getContentPane().add(BtnCancelarAltaProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 500, 100, 30));

        cboMarcaProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", " " }));
        getContentPane().add(cboMarcaProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 350, 160, 30));

        cboFormatoVentaProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Lote", "Unidad", "Pack", "Caja Completa" }));
        getContentPane().add(cboFormatoVentaProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 440, 160, 30));

        cboRubroProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Pintureria", "Herramienta", "Plomeria", "Electricidad", "Construccion" }));
        getContentPane().add(cboRubroProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 160, 30));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/easyCarga.png"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTamañoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTamañoProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTamañoProductoActionPerformed

    private void btnCargarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarProductoActionPerformed
        
        String nombre = txtNombreProducto.getText();
        String tamnio = txtTamañoProducto.getText();
        int codigo = 0;
        int stockMinimo= 0;
        try {
            codigo = Integer.parseInt(txtCodigoProducto.getText());
            stockMinimo = Integer.parseInt(txtStockMinimoProducto.getText());
            Marca marca = (Marca)cboMarcaProducto.getSelectedItem();
            int rubro = (cboRubroProducto).getSelectedIndex();
            int formatoVenta = (cboFormatoVentaProducto).getSelectedIndex();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hay un error al cargar el nuevo producto");
        }
        Marca marca = new Marca(0, nombre);
        Rubro rubro = new Rubro(0, nombre);
        FormatoVenta formatoVenta = new FormatoVenta(0, tamnio);
        Producto nuevo = new Producto(codigo, nombre, stockMinimo, marca, rubro, formatoVenta, tamnio);
        controlador.agregarProducto(nuevo);
        
        JOptionPane.showMessageDialog(null, "El producto se cambio correctamente");
        
    }//GEN-LAST:event_btnCargarProductoActionPerformed

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
    private javax.swing.JButton BtnCancelarAltaProducto;
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton btnCargarProducto;
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
