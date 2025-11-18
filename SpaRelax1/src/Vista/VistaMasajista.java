/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Masajista;
import Persistencia.MasajistaData;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class VistaMasajista extends javax.swing.JInternalFrame {
    
    private DefaultTableModel modelo;
    private MasajistaData masajistaData;
   
    public VistaMasajista() {
        
        initComponents();
        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        modelo = new DefaultTableModel();   
        masajistaData = new MasajistaData();
        
        armarCabeceraTabla();
        limpiarCampos();
        
        btnActualizar.setEnabled(false);
        btnAlta.setEnabled(false);
        btnBaja.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnInsertar.setEnabled(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMasajistas = new javax.swing.JTable();
        btnInsertar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        chkActivo = new javax.swing.JCheckBox();
        txtNombreApellido = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtEspecialidad = new javax.swing.JTextField();
        btnBaja = new javax.swing.JButton();
        btnAlta = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        txtMatriculaBusqueda = new javax.swing.JTextField();
        btnBuscarMatricula = new javax.swing.JButton();

        jLabel7.setText("jLabel7");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("MASAJISTA");

        jLabel3.setText("Nombre y Apellido:");

        jLabel4.setText("Telefono:");

        jLabel5.setText("Especialidad:");

        tblMasajistas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblMasajistas);

        btnInsertar.setText("Insertar");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        jLabel6.setText("Estado:");

        chkActivo.setText("Activo");

        btnBaja.setText("Baja");
        btnBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBajaActionPerformed(evt);
            }
        });

        btnAlta.setText("Alta");
        btnAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        btnBuscarMatricula.setText("Buscar por Matricula");
        btnBuscarMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarMatriculaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombreApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chkActivo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnInsertar)
                                .addGap(68, 68, 68))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btnBuscarMatricula)
                                .addGap(18, 18, 18)
                                .addComponent(txtMatriculaBusqueda))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnActualizar)
                                .addGap(26, 26, 26)
                                .addComponent(btnBaja)
                                .addGap(33, 33, 33)
                                .addComponent(btnAlta)))
                        .addGap(59, 59, 59)
                        .addComponent(btnListar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminar)))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNombreApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(chkActivo)
                            .addComponent(btnInsertar))))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMatriculaBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarMatricula))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnBaja)
                    .addComponent(btnAlta)
                    .addComponent(btnEliminar)
                    .addComponent(btnListar))
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarMatriculaActionPerformed
        borrarFilaTabla();
        int matricula = 0;
        try {
            matricula = Integer.parseInt(txtMatriculaBusqueda.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese una matrícula válida (solo números).");
            return;
        }

        Masajista masajista = masajistaData.buscarMasajistaPorMatricula(matricula); 
        
        if (masajista != null) {
            txtNombreApellido.setText(masajista.getNombreApellido());
            txtTelefono.setText(masajista.getTelefono());
            txtEspecialidad.setText(masajista.getEspecialidad());
            chkActivo.setSelected(masajista.isEstado());
            
            cargarFilaTabla(masajista);

            btnActualizar.setEnabled(true);
            btnAlta.setEnabled(true);
            btnBaja.setEnabled(true);
            btnEliminar.setEnabled(true);
            btnInsertar.setEnabled(false);
        } else {
            limpiarCampos();
        }
    }//GEN-LAST:event_btnBuscarMatriculaActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
    int matricula = 0;
        try {
            matricula = Integer.parseInt(txtMatriculaBusqueda.getText().trim());
            if(matricula <= 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Debe buscar un Masajista válido antes de actualizar.");
            return;
        }
        
        String nombreApellido = txtNombreApellido.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String especialidad = txtEspecialidad.getText().trim();
        boolean estado = chkActivo.isSelected();

        if (nombreApellido.isEmpty() || telefono.isEmpty() || especialidad.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.");
            return;
        }
        
        Masajista masajista = new Masajista(matricula, nombreApellido, telefono, especialidad, estado);

        masajistaData.actualizarMasajista(masajista); 
        
        borrarFilaTabla();
        btnBuscarMatriculaActionPerformed(null);    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaActionPerformed
    int matricula = 0;
    try {
        matricula = Integer.parseInt(txtMatriculaBusqueda.getText().trim());
        if(matricula <= 0) throw new NumberFormatException();
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Debe ingresar una matrícula válida.");
        return;
    }
    
    masajistaData.bajaLogica(matricula); 
    btnBuscarMatriculaActionPerformed(null);    
    }//GEN-LAST:event_btnBajaActionPerformed

    private void btnAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaActionPerformed
        int matricula = 0;
    try {
        matricula = Integer.parseInt(txtMatriculaBusqueda.getText().trim());
        if(matricula <= 0) throw new NumberFormatException();
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Debe ingresar una matrícula válida.");
        return;
    }
    
    masajistaData.altaLogica(matricula); 
    btnBuscarMatriculaActionPerformed(null);
    }//GEN-LAST:event_btnAltaActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
          borrarFilaTabla();
    
    try {
        List<Masajista> lista = masajistaData.listarMasajistas(); 

        for (Masajista m : lista) {
            cargarFilaTabla(m);
        }
        limpiarCampos();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al listar masajistas: " + e.getMessage());
    }
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int matricula = 0;
    try {
        matricula = Integer.parseInt(txtMatriculaBusqueda.getText().trim());
        if(matricula <= 0) throw new NumberFormatException();
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Debe ingresar una matrícula válida.");
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar permanentemente el Masajista con matrícula " + matricula + "?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
    
    if (confirm == JOptionPane.YES_OPTION) {
        masajistaData.eliminarMasajista(matricula); 
        limpiarCampos();
        borrarFilaTabla();
        btnListarActionPerformed(null); 
    }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        String nombreApellido = txtNombreApellido.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String especialidad = txtEspecialidad.getText().trim();
        boolean estado = chkActivo.isSelected();

        if (nombreApellido.isEmpty() || telefono.isEmpty() || especialidad.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.");
            return;
        }

        Masajista masajista = new Masajista(nombreApellido, telefono, especialidad, estado);

        try {
            masajistaData.insertarMasajista(masajista); 
            limpiarCampos();
            btnListarActionPerformed(null); 
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al insertar Masajista: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnInsertarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAlta;
    private javax.swing.JButton btnBaja;
    private javax.swing.JButton btnBuscarMatricula;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnListar;
    private javax.swing.JCheckBox chkActivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMasajistas;
    private javax.swing.JTextField txtEspecialidad;
    private javax.swing.JTextField txtMatriculaBusqueda;
    private javax.swing.JTextField txtNombreApellido;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

private void armarCabeceraTabla() {
    List<Object> titulos = new ArrayList<>();

    titulos.add("Matrícula");
    titulos.add("Nombre y Apellido");
    titulos.add("Teléfono");
    titulos.add("Especialidad");
    titulos.add("Estado");

    for (Object o : titulos) {
        modelo.addColumn(o);
    }

    tblMasajistas.setModel(modelo); 
}

private void borrarFilaTabla() {
    int indice = modelo.getRowCount() - 1;

    for (int i = indice; i >= 0; i--) {
        modelo.removeRow(i);
    }
}

private void cargarFilaTabla(Masajista m) {
    modelo.addRow(new Object[]{
        m.getMatricula(), 
        m.getNombreApellido(), 
        m.getTelefono(), 
        m.getEspecialidad(), 
        m.isEstado()
    });
}

private void limpiarCampos() {
txtNombreApellido.setText("");
    txtTelefono.setText("");
    txtEspecialidad.setText("");
    chkActivo.setSelected(false);
    txtMatriculaBusqueda.setText("");
    
    txtNombreApellido.setEnabled(true); 
    txtTelefono.setEnabled(true);
    txtEspecialidad.setEnabled(true);
    
    // Restaurar estado de botones
    btnActualizar.setEnabled(false);
    btnAlta.setEnabled(false);
    btnBaja.setEnabled(false);
    btnEliminar.setEnabled(false);
    btnInsertar.setEnabled(true);
}
}
