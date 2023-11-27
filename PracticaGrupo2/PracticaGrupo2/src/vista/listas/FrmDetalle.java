
package vista.listas;

import controlador.TDA.listas.LinkedList;
import controlador.personas.DetalleController;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import vista.listas.tablas.ModeloTablaDetalle;
import vista.listas.tablas.Util.UtilVista;

public class FrmDetalle extends javax.swing.JDialog {

    //Objectos
    DetalleController dtc = new DetalleController();
    ModeloTablaDetalle mtd = new ModeloTablaDetalle();
    
    
    public FrmDetalle(){
        initComponents();
        limpiar();
        this.setLocationRelativeTo(null);
    }
    public FrmDetalle(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        limpiar();
        this.setLocationRelativeTo(null);
    }
    
    //Cargo mi tabla en la vista
    private void cargarTabla(){
        mtd.setDetalles(dtc.getDetalles());
        jTableDetalle.setModel(mtd);
        jTableDetalle.updateUI();
        
    }
    
    //Verifico el texto sin espacios si esta vacio
    private boolean validar(){
        return !txtFechaCenso.getText().trim().isEmpty() &&
               !txtMotivo.getText().trim().isEmpty() &&
               !txtFechaDS.getText().trim().isEmpty() &&
               !txtECAnterior.getText().trim().isEmpty() &&
               !txtECActual.getText().trim().isEmpty();
    }
    
    //Limpio los datos 
    private void limpiar(){
        txtFechaCenso.setText("");
        txtMotivo.setText("");
        txtFechaDS.setText("");
        txtECAnterior.setText("");
        txtECActual.setText("");
        
        dtc.setDt(null);
        dtc.setDetalles(new LinkedList<>());
        
        try {
            UtilVista.cargarComboCliente(cbxPersonas);

        } catch (Exception e) {
        }
        
        cargarTabla();
        
        //Actualizar
        jTableDetalle.clearSelection();
        dtc.setIndex(-1);
    }
    
    private void guardar(){
        if(validar()){
            try {
                dtc.getDt().setId_persona(UtilVista.getComboBoxCliente(cbxPersonas));
                dtc.getDt().setFechaCenso(txtFechaCenso.getText());
                dtc.getDt().setMotivo(txtMotivo.getText());
                dtc.getDt().setFechaDivorcio(txtFechaDS.getText());
                dtc.getDt().setEstadoCivilAnterior(txtECAnterior.getText());
                dtc.getDt().setEstadoCivilActual(txtECActual.getText());
                
                //Guardar
                if(dtc.getDt().getId() == null){
                   if(dtc.save()){
                    limpiar();
                        JOptionPane.showMessageDialog(null, "Se ha guardado correctamente", 
                            "OK", JOptionPane.INFORMATION_MESSAGE);
                   
                    }else{
                        JOptionPane.showMessageDialog(null, "No se ha podido guardar", 
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                    } 
                }else{
                    if(dtc.update(dtc.getIndex())){
                    limpiar();
                        JOptionPane.showMessageDialog(null, "Se ha editado correctamente", 
                            "OK", JOptionPane.INFORMATION_MESSAGE);
                   
                    }else{
                        JOptionPane.showMessageDialog(null, "No se ha podido editar", 
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                    } 
                }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,e.getMessage() , 
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Llene todos los campos", 
                    "Error", JOptionPane.ERROR_MESSAGE);
            
        }
    }
    
    private void cargarVista(){
        //Cargo-modifico-envio
        
        dtc.setIndex(jTableDetalle.getSelectedRow());
        if(dtc.getIndex().intValue() < 0){
            JOptionPane.showMessageDialog(null, "Selecciona una fila", 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            try {
                dtc.setDt(mtd.getDetalles().get(dtc.getIndex()));
                cbxPersonas.setSelectedItem(dtc.getDt().getId_persona());
                txtFechaCenso.setText(dtc.getDt().getFechaCenso());
                txtMotivo.setText(dtc.getDt().getMotivo());
                txtFechaDS.setText(dtc.getDt().getFechaDivorcio());
                txtECAnterior.setText(dtc.getDt().getEstadoCivilAnterior());
                txtECActual.setText(dtc.getDt().getEstadoCivilActual());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), 
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    

    
    
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jCDivorcio = new com.toedter.calendar.JCalendar();
        jLabel7 = new javax.swing.JLabel();
        txtFechaCenso = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMotivo = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        txtFechaDS = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtECAnterior = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtECActual = new javax.swing.JTextField();
        jCCenso = new com.toedter.calendar.JCalendar();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableDetalle = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        cbxPersonas = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        jLabel1.setText("Detalles del Censo");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 220, -1));

        jCDivorcio.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCDivorcioPropertyChange(evt);
            }
        });
        jPanel1.add(jCDivorcio, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 80, 380, 200));

        jLabel7.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel7.setText("Fecha Censo:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 130, 20));
        jPanel1.add(txtFechaCenso, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 190, -1));

        jLabel6.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel6.setText("Motivo:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 100, 20));

        txtMotivo.setColumns(20);
        txtMotivo.setRows(5);
        jScrollPane1.setViewportView(txtMotivo);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 640, 90));

        jLabel4.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel4.setText("Fecha Divorcio/Separamiento:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 80, 280, 30));
        jPanel1.add(txtFechaDS, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 140, 190, -1));

        jLabel5.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel5.setText("Estado Civil Anterior: ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 200, 20));
        jPanel1.add(txtECAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 410, 380, -1));

        jLabel3.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel3.setText("Clientes:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 200, 20));
        jPanel1.add(txtECActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 460, 380, -1));

        jCCenso.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCCensoPropertyChange(evt);
            }
        });
        jPanel1.add(jCCenso, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 380, 200));

        jTableDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTableDetalle);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 310, 730, 220));

        btnGuardar.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 630, -1, -1));

        btnLimpiar.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        btnLimpiar.setText("Seleccionar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 630, -1, -1));

        btnActualizar.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 630, -1, -1));

        btnCancelar.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 630, -1, -1));

        btnRegresar.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 590, -1, -1));

        cbxPersonas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jPanel1.add(cbxPersonas, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 520, 140, -1));

        jLabel8.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel8.setText("Estado Civil Actual: ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 200, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1542, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        cargarVista();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        guardar();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jCCensoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCCensoPropertyChange
        //Si no es igual al null, es decir tiene un dato
        if(evt.getOldValue() != null){
            //Especifico el formato de la fecha
            SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
            txtFechaCenso.setText(date.format(jCCenso.getCalendar().getTime()));
        }
    }//GEN-LAST:event_jCCensoPropertyChange

    private void jCDivorcioPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCDivorcioPropertyChange
        
        if(evt.getOldValue() != null){
            
            SimpleDateFormat date2 = new SimpleDateFormat("dd/MM/yyyy");
            txtFechaDS.setText(date2.format(jCDivorcio.getCalendar().getTime()));
        }
    }//GEN-LAST:event_jCDivorcioPropertyChange

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        Menu newFrame = new Menu();
        newFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmDetalle dialog = new FrmDetalle(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbxPersonas;
    private com.toedter.calendar.JCalendar jCCenso;
    private com.toedter.calendar.JCalendar jCDivorcio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableDetalle;
    private javax.swing.JTextField txtECActual;
    private javax.swing.JTextField txtECAnterior;
    private javax.swing.JTextField txtFechaCenso;
    private javax.swing.JTextField txtFechaDS;
    private javax.swing.JTextArea txtMotivo;
    // End of variables declaration//GEN-END:variables
}
