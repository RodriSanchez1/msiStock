/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

import Controladores.controladorProducto;
import Controladores.controladorRemitoInterno;
import DTO.dtoDetalleRemito;
import DTO.dtoStockUbicacion;
import Modelos.DetalleRemito;
import Modelos.FormaVenta;
import Modelos.Producto;
import Modelos.Remito;
import Modelos.Stock;
import Modelos.TipoMovimiento;
import Modelos.Usuario;
import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.text.TableView;

/**
 *
 * @author ginin
 */
public class movInterno extends javax.swing.JFrame {

    controladorRemitoInterno controlador = new controladorRemitoInterno();

    private static final int PRODUCT_COLUMN = 0;
    private static final int BOOLEAN_COLUMN = 1;
    private static final int CANTIDAD_COLUMN = 2;
    private static final int DISPONIBILIDAD_COLUMN = 3;
    private static final int DISPONIBILIDAD_UBICACION_COLUMN = 4;
    private static final int UBICACION_COLUMN = 5;
    private DefaultTableModel model;
    Usuario user = null;
    boolean tipoMovimiento = false; //Entrada
    ArrayList<dtoStockUbicacion> listaStock;

    /**
     * Creates new form Carga_Producto
     *
     * @param rol
     */
    public movInterno(String rol) {
        System.out.println(rol);
        initComponents();
        fillComboTipoRemito();
        fillTableDetalleRemito();
        setNroRemito();
        Date date = new Date();
        jDateChooser1.setDate(date);
        Date fecha = jDateChooser1.getDate();
        System.out.println(fecha);
        addTableListener();
        if (!tipoMovimiento) {
            listaStock = controlador.obtenerStock();
            cmbTipoMovimiento.setSelectedIndex(1);

        }
        cmbTipoMovimiento.setEnabled(false);

    }

    private void addTableListener() {
        tableDetalleRemito.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
//                if (e.getType() == TableModelEvent.UPDATE) {
//                    //DefaultTableModel modelo = (DefaultTableModel) tableDetalleRemito.getModel();
//                    model.addRow(new Object[]{null, false, 0});
//                }
                int row = e.getFirstRow();
                int column = e.getColumn();
                if (column == BOOLEAN_COLUMN) {
                    TableModel model = (TableModel) e.getSource();
                    String columnName = model.getColumnName(column);
                    Boolean checked = (Boolean) model.getValueAt(row, column);
                    if (checked) {
                        System.out.println(columnName + ": " + true);
                    } else {
                        System.out.println(columnName + ": " + false);
                    }
                }
                if (column == PRODUCT_COLUMN && !tipoMovimiento || column == BOOLEAN_COLUMN && !tipoMovimiento) {
                    System.out.println("Entro para modificar disponibilidad");
                    TableModel model = (TableModel) e.getSource();
                    Producto producto = (Producto) model.getValueAt(row, PRODUCT_COLUMN);
                    FormaVenta formaVenta = (boolean) model.getValueAt(row, BOOLEAN_COLUMN) ? new FormaVenta(1, "online") : new FormaVenta(2, "presencial");
                    int cantidadTotal = 0;
                    for (dtoStockUbicacion stock : listaStock) {
                        if (producto != null && stock.getCodProducto() == producto.getCodigo() && stock.getIdFormaVenta() == formaVenta.getIdFormaVenta()) {
                            //System.out.println(stock.getCantidad());
                            cantidadTotal += stock.getCantidad();
                        }
                    }

                    model.setValueAt(cantidadTotal, row, DISPONIBILIDAD_COLUMN);

                    TableColumn testColumn = tableDetalleRemito.getColumnModel().getColumn(5);
                    JComboBox<String> comboBox = new JComboBox<>();
                    controladorProducto controlador = new controladorProducto();
                    DefaultComboBoxModel cmb = new DefaultComboBoxModel();
                    ArrayList<dtoStockUbicacion> lista;
                    for (dtoStockUbicacion dtoStock : listaStock) {
                        if (dtoStock.getCodProducto() == producto.getCodigo() && dtoStock.getIdFormaVenta() == formaVenta.getIdFormaVenta()) {
                            cmb.addElement(dtoStock);
                        }
                    }
                    comboBox.setModel(cmb);

                    //tableDetalleRemito.setValueAt(new DefaultCellEditor(comboBox), row, UBICACION_COLUMN);
                    testColumn.setCellEditor(new DefaultCellEditor(comboBox));
                }
                if (column == UBICACION_COLUMN && !tipoMovimiento) {
                    TableModel model = (TableModel) e.getSource();
                    Producto producto = (Producto) model.getValueAt(row, PRODUCT_COLUMN);
                    FormaVenta formaVenta = (boolean) model.getValueAt(row, BOOLEAN_COLUMN) ? new FormaVenta(1, "online") : new FormaVenta(2, "presencial");
                    dtoStockUbicacion dto = (dtoStockUbicacion) model.getValueAt(row, UBICACION_COLUMN);
                    int cantidadTotal = 0;
                    if (dto != null) {
                        for (dtoStockUbicacion stock : listaStock) {
                            if (producto != null && stock.getCodProducto() == producto.getCodigo()
                                    && stock.getIdFormaVenta() == formaVenta.getIdFormaVenta()
                                    && stock.getIdEstanteria() == dto.getIdEstanteria()) {
                                //System.out.println(stock.getCantidad());
                                cantidadTotal = stock.getCantidad();
                            }
                        }
                    }

                    model.setValueAt(cantidadTotal, row, DISPONIBILIDAD_UBICACION_COLUMN);
                }
            }
        });
    }
//    public class EditBoolean extends AbstractCellEditor implements TableCellEditor {
//
//        private JComboBox cmb;
//
//        public EditBoolean() {
//            // This is the component that will handle the editing of the cell value
//           cmb = new JComboBox<>();
//        }
//
//        // This method is called when editing is completed.
//        // It must return the new value to be stored in the cell.
//        @Override
//        public Object getCellEditorValue() {
//            return cmb;
//        }
//
//        // This method is called when a cell value is edited by the user.
//        @Override
//        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
//            if(column == 2 && row == 4){
//
//               
//               
//            }
//            return cmb;
//       }
//}
//     private void fillComboHabitaciones() {
//        ControladorHabitacion controlador = new ControladorHabitacion();
//        DefaultComboBoxModel model = new DefaultComboBoxModel();
//        ArrayList<Habitacion> lista = controlador.obtenerHabitaciones();
//        for (Habitacion habitacion : lista) {
//            model.addElement(habitacion);
//        }
//        cmbHabitaciones.setModel(model);
//    }

    private void fillComboTipoRemito() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        ArrayList<TipoMovimiento> lista = new ArrayList<>();
        lista.add(new TipoMovimiento(1, "Entrada"));
        lista.add(new TipoMovimiento(2, "Salida"));
        for (TipoMovimiento item : lista) {
            model.addElement(item);
        }
        cmbTipoMovimiento.setModel(model);
    }

    private void fillTableDetalleRemito() {
        // ArrayList<Servicio> lista = controlador.obtenerServiciosXHabitacion((Habitacion) cmbHabitaciones.getSelectedItem());
        model = new DefaultTableModel() {
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return Boolean.class;
                    case 2:
                        return Integer.class;
                    case 3:
                        return Integer.class;
                    case 4:
                        return Integer.class;
                    case 5:
                        return String.class;
                    default:
                        return String.class;
                }
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return column == PRODUCT_COLUMN || column == BOOLEAN_COLUMN || column == CANTIDAD_COLUMN || column == UBICACION_COLUMN;
            }
        ;
        };
        if (tipoMovimiento) {
            model.setColumnIdentifiers(new String[]{"Producto", "Online", "Cantidad"});
            model.addRow(new Object[]{null, false, 0});
        } else {
            model.setColumnIdentifiers(new String[]{"Producto", "Online", "Cantidad", "Disponible", "Disponible en ubicacion", "Ubicacion"});
            model.addRow(new Object[]{null, false, 0, 0, 0, null});
        }
        tableDetalleRemito.setModel(model);
        TableColumn testColumn = tableDetalleRemito.getColumnModel().getColumn(0);
        JComboBox<String> comboBox = new JComboBox<>();
        controladorProducto controlador = new controladorProducto();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        ArrayList<Producto> lista = controlador.obtenerProductos();
        for (Producto producto : lista) {
            model.addElement(producto);
        }
        comboBox.setModel(model);
        testColumn.setCellEditor(new DefaultCellEditor(comboBox));

//        for (Servicio row : lista) {
//            model.addRow(new Object[]{row.getConcepto(),row.getImporte()});
//        }
    }

    private void setNroRemito() {
        nroRemito.setText(String.valueOf(controlador.obtenerNroRemitoSiguiente()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDetalleRemito = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        nroRemito = new javax.swing.JLabel();
        cmbTipoMovimiento = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Light", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Movimiento interno de stock");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 380, -1));

        jButton3.setBackground(new java.awt.Color(102, 0, 0));
        jButton3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 0));
        jButton3.setText("Cancelar");
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 530, 110, 30));

        jButton2.setBackground(new java.awt.Color(102, 0, 0));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 0));
        jButton2.setText("Aceptar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 530, 110, 30));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 0));
        jLabel2.setText("Número de remito:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 0));
        jLabel3.setText("Tipo Movimiento:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        tableDetalleRemito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableDetalleRemito);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 840, 210));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 0, 0));
        jLabel6.setText("Fecha:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, -1, 20));

        nroRemito.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        nroRemito.setText("0");
        getContentPane().add(nroRemito, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 40, 20));

        cmbTipoMovimiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Salida" }));
        cmbTipoMovimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoMovimientoActionPerformed(evt);
            }
        });
        getContentPane().add(cmbTipoMovimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 100, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 0, 0));
        jLabel9.setText("Usuario:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        jLabel4.setText("user");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, -1, -1));
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, 110, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mas.png"))); // NOI18N
        jButton1.setText("Agregar producto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 260, 160, 30));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/menos (2).png"))); // NOI18N
        jButton4.setText("  Eliminar producto");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 260, 160, 30));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/easyCarga.png"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        Remito nvoRemito = new Remito();
        Date fecha = jDateChooser1.getDate();
        TipoMovimiento tipoMovimiento = (TipoMovimiento) cmbTipoMovimiento.getSelectedItem();

        ArrayList<dtoDetalleRemito> listaDetalle = new ArrayList();
        try {
            if (tableDetalleRemito.getRowCount() != 0) {
                for (int i = 0; i < tableDetalleRemito.getRowCount(); i++) {
                    Producto producto = null;
                    producto = (Producto) tableDetalleRemito.getValueAt(i, 0);
                    System.out.println(producto);
                    if (null == producto) {
                        throw new Error("Seleccione un producto");
                    }
                    boolean isOnline = (boolean) tableDetalleRemito.getValueAt(i, 1);
                    FormaVenta formaVenta;
                    formaVenta = isOnline ? new FormaVenta(1, "online") : new FormaVenta(2, "presencial");
                    int cantidad = (Integer) tableDetalleRemito.getValueAt(i, 2);
                    if (cantidad <= 0) {
                        throw new Error("La cantidad debe ser mayor a 0");
                    }
                    if (!this.tipoMovimiento) {
                        dtoStockUbicacion dto = (dtoStockUbicacion) tableDetalleRemito.getValueAt(i, UBICACION_COLUMN);
                        if (null == dto) {
                            throw new Error("Seleccione una ubicacion");
                        }
                        int cantidadXUbicacion = (Integer) tableDetalleRemito.getValueAt(i, DISPONIBILIDAD_UBICACION_COLUMN);
                        if (cantidad > cantidadXUbicacion || cantidadXUbicacion == 0) {
                            throw new Error("Debe ingresar una cantidad menor a la cantidad en ubicacion");
                        }
                        listaDetalle.add(new dtoDetalleRemito(cantidad, producto, formaVenta, dto.getIdStock(), dto.getIdEstanteria()));
                    } else {
                        listaDetalle.add(new dtoDetalleRemito(cantidad, producto, formaVenta));
                    }

                }
            } else {
                throw new Error("Debe agregar por lo menos un producto");
            }

            controladorRemitoInterno controlador = new controladorRemitoInterno();
            if (this.tipoMovimiento) {
                controlador.insertarNuevoRemitoEntrada(fecha, tipoMovimiento.getId(), 1, listaDetalle);
            } else {
                controlador.insertarNuevoRemitoSalida(fecha, tipoMovimiento.getId(), 1, listaDetalle);
                listaStock = controlador.obtenerStock();
            }
            model.setRowCount(0);
            ImageIcon icon = new ImageIcon("src/Imagenes/mas.png");
            JOptionPane.showMessageDialog(null, "Remito cargado exitosamente",
                    "Confirmación", JOptionPane.INFORMATION_MESSAGE, icon);
        } catch (Error e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        } catch (SQLException ex) {
            Logger.getLogger(movInterno.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(listaDetalle);


    }//GEN-LAST:event_jButton2ActionPerformed

    private void cmbTipoMovimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoMovimientoActionPerformed
        // TDO add your handling code here:
    }//GEN-LAST:event_cmbTipoMovimientoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (tipoMovimiento) {
            model.addRow(new Object[]{null, false, 0});
        } else {
            model.addRow(new Object[]{null, false, 0, 0, 0, null});
        }

     }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int numRows = tableDetalleRemito.getSelectedRows().length;
        for (int i = 0; i < numRows; i++) {
            model.removeRow(tableDetalleRemito.getSelectedRow());
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JComboBox<String> cmbTipoMovimiento;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nroRemito;
    private javax.swing.JTable tableDetalleRemito;
    // End of variables declaration//GEN-END:variables
}
