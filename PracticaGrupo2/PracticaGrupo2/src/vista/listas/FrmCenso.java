package vista.listas;

import controlador.TDA.listas.LinkedList;
import controlador.personas.PersonaController;
import javax.swing.JOptionPane;
import vista.listas.tablas.ModeloTablaRegistro;


public class FrmCenso extends javax.swing.JDialog {

     //Objetos
    PersonaController pc = new PersonaController();
    ModeloTablaRegistro mtr = new ModeloTablaRegistro();
    
    
    public FrmCenso(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        limpiar();
    }
    
    public FrmCenso(){
        initComponents();
        this.setLocationRelativeTo(null);
        limpiar();
    }
    
    //Cargo mi tabla en la vista
    private void cargarTabla(){
        mtr.setListaTablaPersona(pc.getListaPersona());
        JTableRegistro.setModel(mtr);
        JTableRegistro.updateUI();
    }
    
    
    //Verifico si el texto sin espacios esta vacio
    private boolean validar(){
        return !TxtNombre.getText().trim().isEmpty() &&
               !TxtApellido.getText().trim().isEmpty() &&
               !TxtEdad.getText().trim().isEmpty() &&
               !TxtDireccion.getText().trim().isEmpty() &&
               !TxtCorreo.getText().trim().isEmpty() &&
               !TxtCedula.getText().trim().isEmpty() &&
               !TxtTelefono.getText().trim().isEmpty();
    }
    
    private void limpiar(){
        TxtNombre.setText("");
        TxtApellido.setText("");
        cbxRol.setSelectedItem(-1);//Limpio Combo
        cbxGenero.setSelectedItem(-1);//Limpio COmbo
        TxtEdad.setText("");
        TxtDireccion.setText("");
        TxtCorreo.setText("");
        TxtCedula.setText("");
        TxtTelefono.setText("");
        
        pc.setPersona(null);
        pc.setListaPersona(new LinkedList<>());
        cargarTabla();
        //Actualizar tabla -BDD desaparece
        JTableRegistro.clearSelection();
        pc.setIndex(-1);
    }
    
    //Guardo la informacion 
    private void guardar(){
        if(validar()){
            try {
                pc.getPersona().setNombres(TxtNombre.getText());
                pc.getPersona().setApellidos(TxtApellido.getText());
                pc.getPersona().setRol(cbxRol.getSelectedItem().toString());
                pc.getPersona().setGenero(cbxGenero.getSelectedItem().toString());
                pc.getPersona().setEdad(Integer.parseInt(TxtEdad.getText()));
                pc.getPersona().setDireccion(TxtDireccion.getText());
                pc.getPersona().setCorreo(TxtCorreo.getText());
                pc.getPersona().setCedula(TxtCedula.getText());
                pc.getPersona().setTelefono(TxtTelefono.getText());
                
                //Guardar
                if(pc.getPersona().getId() == null){
                   if(pc.save()){
                    limpiar();
                        JOptionPane.showMessageDialog(null, "Se ha guardado correctamente", 
                            "OK", JOptionPane.INFORMATION_MESSAGE);
                   
                    }else{
                        JOptionPane.showMessageDialog(null, "No se ha podido guardar", 
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                    } 
                }else{
                    if(pc.update(pc.getIndex())){
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
    
    private void actualizar(){
        pc.getPersona().setNombres(TxtNombre.getText());
        pc.getPersona().setApellidos(TxtApellido.getText());
        pc.getPersona().setRol(cbxRol.getSelectedItem().toString());
        pc.getPersona().setGenero(cbxGenero.getSelectedItem().toString());
        pc.getPersona().setEdad(Integer.parseInt(TxtEdad.getText()));
        pc.getPersona().setDireccion(TxtDireccion.getText());
        pc.getPersona().setCorreo(TxtCorreo.getText());
        pc.getPersona().setCedula(TxtCedula.getText());
        pc.getPersona().setTelefono(TxtTelefono.getText());
        cargarTabla();
    }
    
    private void cargarVista(){
        
        //Cargo-modifico-envio
        
        pc.setIndex(JTableRegistro.getSelectedRow());
        if(pc.getIndex().intValue() < 0){
            JOptionPane.showMessageDialog(null, "Selecciona una fila", 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            try {
                pc.setPersona(mtr.getListaTablaPersona().get(pc.getIndex()));
                TxtNombre.setText(pc.getPersona().getNombres());
                TxtApellido.setText(pc.getPersona().getApellidos());
                cbxRol.setSelectedItem(pc.getPersona().getRol());
                cbxGenero.setSelectedItem(pc.getPersona().getGenero());
                TxtEdad.setText(pc.getPersona().getEdad().toString());
                TxtDireccion.setText(pc.getPersona().getDireccion());
                TxtCorreo.setText(pc.getPersona().getCorreo());
                TxtCedula.setText(pc.getPersona().getCedula());
                TxtTelefono.setText(pc.getPersona().getTelefono());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), 
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TxtCorreo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TxtCedula = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TxtEdad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TxtDireccion = new javax.swing.JTextField();
        TxtNombre = new javax.swing.JTextField();
        TxtApellido = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableRegistro = new javax.swing.JTable();
        btnActualizar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        TxtTelefono = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbxGenero = new javax.swing.JComboBox<>();
        cbxRol = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        jLabel1.setText("Registro General");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 200, -1));

        jLabel2.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel2.setText("Telefono: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 260, 100, 20));

        TxtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtCorreoActionPerformed(evt);
            }
        });
        jPanel1.add(TxtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 160, 240, -1));

        jLabel3.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel3.setText("Nombres: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 100, 20));

        TxtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtCedulaActionPerformed(evt);
            }
        });
        jPanel1.add(TxtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 210, 240, -1));

        jLabel4.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel4.setText("Edad:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 100, 20));

        TxtEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtEdadActionPerformed(evt);
            }
        });
        jPanel1.add(TxtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 240, -1));

        jLabel5.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel5.setText("Dirección: ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 100, 20));

        jLabel6.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel6.setText("Correo: ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, 90, 20));

        jLabel7.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel7.setText("Cedula: ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, 100, 20));

        TxtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtDireccionActionPerformed(evt);
            }
        });
        jPanel1.add(TxtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, 240, -1));

        TxtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNombreActionPerformed(evt);
            }
        });
        jPanel1.add(TxtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 240, -1));

        TxtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtApellidoActionPerformed(evt);
            }
        });
        jPanel1.add(TxtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 240, -1));

        JTableRegistro.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(JTableRegistro);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 770, 120));

        btnActualizar.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 660, -1, -1));

        btnLimpiar.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        btnLimpiar.setText("Seleccionar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 600, -1, -1));

        btnCancelar.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 660, -1, -1));

        btnGuardar.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, -1, -1));

        TxtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtTelefonoActionPerformed(evt);
            }
        });
        jPanel1.add(TxtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 260, 240, -1));

        jLabel8.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel8.setText("Género:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 100, 20));

        jLabel9.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel9.setText("Rol:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 100, 20));

        cbxGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));
        jPanel1.add(cbxGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 240, -1));

        cbxRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Censador", "Cliente" }));
        jPanel1.add(cbxRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 240, -1));

        jLabel10.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel10.setText("Apellidos:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 100, 20));

        btnRegresar.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 650, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtCorreoActionPerformed

    private void TxtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtCedulaActionPerformed

    private void TxtEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtEdadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtEdadActionPerformed

    private void TxtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtDireccionActionPerformed

    private void TxtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtNombreActionPerformed

    private void TxtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtApellidoActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        guardar();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
       cargarVista();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void TxtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtTelefonoActionPerformed

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
            java.util.logging.Logger.getLogger(FrmCenso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCenso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCenso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCenso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmCenso dialog = new FrmCenso(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable JTableRegistro;
    private javax.swing.JTextField TxtApellido;
    private javax.swing.JTextField TxtCedula;
    private javax.swing.JTextField TxtCorreo;
    private javax.swing.JTextField TxtDireccion;
    private javax.swing.JTextField TxtEdad;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JTextField TxtTelefono;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbxGenero;
    private javax.swing.JComboBox<String> cbxRol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
