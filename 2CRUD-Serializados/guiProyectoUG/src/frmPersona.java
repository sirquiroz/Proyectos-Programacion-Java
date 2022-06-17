
import entidades.Ciudad;
import entidades.Combo;
import entidades.Persona;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.mCiudad;
import model.mPersona;
import util.Validacion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Miguel Quiroz
 */
public class frmPersona extends javax.swing.JFrame {

    /**
     * Creates new form frmPersona
     */
    DefaultTableModel listado;

    public frmPersona() {
        String[] cls = {"Cedula", "Nombre", "Apellido", "Edad", "Ciudad"};
        listado = new DefaultTableModel(cls, 0);
        initComponents();
        new mCiudad().llenaCombo(cmbCiudades);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnConsultar = new javax.swing.JButton();
        txtCedula = new javax.swing.JTextField();
        btnNewCiudad = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        cmbCiudades = new javax.swing.JComboBox<>();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setText("Nombre");

        jLabel2.setText("Cedula");

        jLabel3.setText("Apellido");

        jLabel4.setText("Edad");

        jLabel5.setText("Ciudad");

        btnConsultar.setText("Consultar");
        btnConsultar.setNextFocusableComponent(txtCedula);
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        txtCedula.setNextFocusableComponent(txtNombre);
        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });

        btnNewCiudad.setText("Add Ciudad");
        btnNewCiudad.setNextFocusableComponent(btnNuevo);
        btnNewCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewCiudadActionPerformed(evt);
            }
        });

        txtNombre.setNextFocusableComponent(txtApellido);
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtApellido.setNextFocusableComponent(txtEdad);
        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });

        txtEdad.setNextFocusableComponent(cmbCiudades);
        txtEdad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEdadKeyTyped(evt);
            }
        });

        cmbCiudades.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbCiudades.setNextFocusableComponent(btnNewCiudad);

        btnNuevo.setText("Nuevo");
        btnNuevo.setNextFocusableComponent(btnModificar);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.setNextFocusableComponent(btnEliminar);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.setNextFocusableComponent(btnListar);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnListar.setText("Listar");
        btnListar.setNextFocusableComponent(btnConsultar);
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        jTable1.setModel(listado);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEdad)
                            .addComponent(txtCedula)
                            .addComponent(txtNombre)
                            .addComponent(txtApellido)
                            .addComponent(cmbCiudades, 0, 163, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNewCiudad)
                            .addComponent(btnConsultar)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNuevo)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(btnListar)))
                .addGap(77, 77, 77)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbCiudades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNewCiudad)))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnListar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        //validar que los campos esten llenos y vaciar
        JTextField[] campos = {txtCedula, txtNombre, txtApellido, txtEdad};
        if (new Validacion().camposLlenos(campos)) {
            Persona obj = new Persona();
            obj.setApellido(txtApellido.getText());
            obj.setNombre(txtNombre.getText());
            obj.setCedula(txtCedula.getText());
            obj.setEdad(Integer.parseInt(txtEdad.getText()));
            Combo cmb = (Combo) cmbCiudades.getSelectedItem();
            obj.setObjCiudad(new Ciudad(cmb.getTexto()));
            if (new mPersona().insertar(obj)) {
                JOptionPane.showMessageDialog(null, "Guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "NO Guardado");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El campo es obligatorio");
        }
    }//GEN-LAST:event_btnNuevoActionPerformed
    public void limpiar() {
        txtApellido.setText("");
        txtNombre.setText("");
        txtCedula.setText("");
        txtEdad.setText("");
        cmbCiudades.setSelectedIndex(0);
    }
    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        JTextField[] campos = {txtCedula};
        if (new Validacion().camposLlenos(campos)) {
            Persona obj = (Persona) new mPersona().consultar(txtCedula.getText());
            if (obj != null) {
                txtNombre.setText(obj.getNombre());
                txtApellido.setText(obj.getApellido());
                txtEdad.setText(obj.getEdad() + "");
                cmbCiudades.setSelectedItem(new Combo(0, obj.getObjCiudad().getNombre()));
            } else {
                JOptionPane.showMessageDialog(null, "Persona no existe");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese la cedula");
        }
    }//GEN-LAST:event_btnConsultarActionPerformed
    boolean refreshCiudades = false;
    private void btnNewCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewCiudadActionPerformed
        String texto = JOptionPane.showInputDialog(null, "Ingrese la ciudad", "", JOptionPane.PLAIN_MESSAGE);
        if (texto != null && texto.trim().length() > 2) {
            new mCiudad().insertar(new Ciudad(texto));
            refreshCiudades = true;
        }
    }//GEN-LAST:event_btnNewCiudadActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        if (refreshCiudades) {
            new mCiudad().llenaCombo(cmbCiudades);
            refreshCiudades = false;
        }
    }//GEN-LAST:event_formWindowActivated

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        new mPersona().listar(listado);
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        JTextField[] campos = {txtCedula, txtNombre, txtApellido, txtEdad};
        if (new Validacion().camposLlenos(campos)) {
            Persona obj = new Persona();
            obj.setApellido(txtApellido.getText());
            obj.setNombre(txtNombre.getText());
            obj.setCedula(txtCedula.getText());
            obj.setEdad(Integer.parseInt(txtEdad.getText()));
            Combo cmb = (Combo) cmbCiudades.getSelectedItem();
            obj.setObjCiudad(new Ciudad(cmb.getTexto()));
            if (new mPersona().modificar(obj)) {
                JOptionPane.showMessageDialog(null, "Actualizado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "NO Actualizado");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El campo es obligatorio");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        JTextField[] campos = {txtCedula};
        if (new Validacion().camposLlenos(campos)) {
            int eleccion = JOptionPane.showConfirmDialog(null, "Desea Eliminar el registro?", "Eliminar Registro", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (eleccion == JOptionPane.YES_OPTION) {
                Persona obj = new Persona();
                obj.setCedula(txtCedula.getText());
                if (new mPersona().eliminar(obj)) {
                    JOptionPane.showMessageDialog(null, "Eliminado");
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "NO Eliminado");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "El campo es obligatorio");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped
        new Validacion().soloNumero(evt);
    }//GEN-LAST:event_txtCedulaKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        new Validacion().soloLetra(evt);
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped
       new Validacion().soloLetra(evt);
    }//GEN-LAST:event_txtApellidoKeyTyped

    private void txtEdadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEdadKeyTyped
        new Validacion().soloNumero(evt);
    }//GEN-LAST:event_txtEdadKeyTyped

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
            java.util.logging.Logger.getLogger(frmPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPersona().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNewCiudad;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cmbCiudades;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}