package Vista;

import Modelo.Instalacion;
import Persistencia.InstalacionData;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VistaInstalacion extends javax.swing.JInternalFrame {

    private InstalacionData instalacionData;
    private DefaultTableModel modeloTabla;

    public VistaInstalacion() {
        initComponents();
        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        instalacionData = new InstalacionData();
        modeloTabla = new DefaultTableModel();
        armarCabeceraTabla();
        estadoInicialBotones();
        listarInstalaciones();
    }

    // -------------------------------------------------------------------------
    // MÉTODOS AUXILIARES
    // -------------------------------------------------------------------------

    private void armarCabeceraTabla() {
        modeloTabla.addColumn("Código");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Detalle de Uso");
        modeloTabla.addColumn("Precio (30m)");
        modeloTabla.addColumn("Estado");
        tablaInstalaciones.setModel(modeloTabla);
    }

    private void borrarFilaTabla() {
        int filas = modeloTabla.getRowCount() - 1;
        for (int i = filas; i >= 0; i--) {
            modeloTabla.removeRow(i);
        }
    }

    private void limpiarCampos() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtdetalleUso.setText("");
        txtPrecio.setText("");
        chkActivo.setSelected(false);
        estadoInicialBotones();
    }

    private void estadoInicialBotones() {
        btnGuardar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnAlta.setEnabled(false);
        btnBaja.setEnabled(false);
    }

    private boolean validarCampos() {
        if (txtNombre.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un nombre.");
            return false;
        }
        if (txtdetalleUso.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un detalle de uso.");
            return false;
        }
        if (txtPrecio.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un precio.");
            return false;
        }
        try {
            double precio = Double.parseDouble(txtPrecio.getText().trim());
            if (precio <= 0) {
                JOptionPane.showMessageDialog(this, "El precio debe ser mayor a cero.");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El precio debe ser numérico.");
            return false;
        }
        return true;
    }


    private void guardarInstalacion() {
        if (!validarCampos()) return;

        String nombre = txtNombre.getText().trim();
        String detalle = txtdetalleUso.getText().trim();
        double precio = Double.parseDouble(txtPrecio.getText().trim());
        boolean estado = chkActivo.isSelected();

        Instalacion ins = new Instalacion(nombre, detalle, precio, estado);

        try {
            instalacionData.insertarInstalacion(ins);
            JOptionPane.showMessageDialog(this, "Instalación guardada correctamente.");
            listarInstalaciones();
            limpiarCampos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al guardar la instalación.");
        }
    }

    private void buscarInstalacion() {
        String codigoTxt = txtCodigo.getText().trim();
        if (codigoTxt.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el código de la instalación para buscar.");
            return;
        }

        try {
            int codigo = Integer.parseInt(codigoTxt);
            borrarFilaTabla();

            Instalacion ins = instalacionData.buscarInstalacionPorCodigo(codigo);

            if (ins != null) {
                txtNombre.setText(ins.getNombre());
                txtdetalleUso.setText(ins.getDetalleUso());
                txtPrecio.setText(String.valueOf(ins.getPrecio30m()));
                chkActivo.setSelected(ins.isEstado());

                modeloTabla.addRow(new Object[]{
                    ins.getCodInstal(),
                    ins.getNombre(),
                    ins.getDetalleUso(),
                    ins.getPrecio30m(),
                    ins.isEstado() ? "Activo" : "Inactivo"
                });

                btnModificar.setEnabled(true);
                btnEliminar.setEnabled(true);
                btnAlta.setEnabled(true);
                btnBaja.setEnabled(true);
                btnGuardar.setEnabled(false);

            } else {
                JOptionPane.showMessageDialog(this, "No se encontró ninguna instalación con ese código.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El código debe ser un número.");
        }
    }

    private void modificarInstalacion() {
        if (!validarCampos()) return;

        try {
            int codigo = Integer.parseInt(txtCodigo.getText().trim());
            String nombre = txtNombre.getText().trim();
            String detalle = txtdetalleUso.getText().trim();
            double precio = Double.parseDouble(txtPrecio.getText().trim());
            boolean estado = chkActivo.isSelected();

            Instalacion ins = new Instalacion(codigo, nombre, detalle, precio, estado);

            boolean actualizado = instalacionData.actualizarInstalacion(ins);
            if (actualizado) {
                JOptionPane.showMessageDialog(this, "Instalación actualizada correctamente.");
                listarInstalaciones();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró la instalación para actualizar.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un código válido para modificar.");
        }
    }

    private void eliminarInstalacion() {
        try {
            int codigo = Integer.parseInt(txtCodigo.getText().trim());
            boolean eliminado = instalacionData.eliminarInstalacion(codigo);

            if (eliminado) {
                JOptionPane.showMessageDialog(this, "Instalación eliminada correctamente.");
                listarInstalaciones();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró la instalación con ese código.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un código válido para eliminar.");
        }
    }

    private void altaLogica() {
        try {
            int codigo = Integer.parseInt(txtCodigo.getText().trim());
            boolean alta = instalacionData.altaLogica(codigo);
            if (alta) {
                JOptionPane.showMessageDialog(this, "Instalación dada de alta correctamente.");
                listarInstalaciones();
                limpiarCampos();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un código válido para dar de alta.");
        }
    }

    private void bajaLogica() {
        try {
            int codigo = Integer.parseInt(txtCodigo.getText().trim());
            boolean baja = instalacionData.bajaLogica(codigo);
            if (baja) {
                JOptionPane.showMessageDialog(this, "Instalación dada de baja correctamente.");
                listarInstalaciones();
                limpiarCampos();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un código válido para dar de baja.");
        }
    }

    private void listarInstalaciones() {
        borrarFilaTabla();

        List<Instalacion> lista = instalacionData.listarInstalaciones();
        for (Instalacion ins : lista) {
            modeloTabla.addRow(new Object[]{
                ins.getCodInstal(),
                ins.getNombre(),
                ins.getDetalleUso(),
                ins.getPrecio30m(),
                ins.isEstado() ? "Activo" : "Inactivo"
            });
        }
    }
 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Nombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        chkActivo = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaInstalaciones = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtdetalleUso = new javax.swing.JTextArea();
        btnAlta = new javax.swing.JButton();
        btnBaja = new javax.swing.JButton();

        jLabel1.setBackground(new java.awt.Color(204, 0, 153));
        jLabel1.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        jLabel1.setText("Instalaciones");

        Nombre.setFont(new java.awt.Font("Dubai Light", 1, 14)); // NOI18N
        Nombre.setText("Nombre:");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(102, 102, 102));
        jLabel4.setFont(new java.awt.Font("Dubai Light", 1, 14)); // NOI18N
        jLabel4.setText("Precio:");

        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });

        chkActivo.setFont(new java.awt.Font("Dubai Light", 1, 14)); // NOI18N
        chkActivo.setText("Activo");
        chkActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkActivoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dubai Light", 1, 14)); // NOI18N
        jLabel5.setText("Estado");

        jLabel6.setFont(new java.awt.Font("Dubai Light", 1, 14)); // NOI18N
        jLabel6.setText("Codigo");

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
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

        tablaInstalaciones.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaInstalaciones);

        jLabel2.setFont(new java.awt.Font("Dubai Light", 1, 14)); // NOI18N
        jLabel2.setText("Detalles de uso");

        txtdetalleUso.setColumns(20);
        txtdetalleUso.setRows(5);
        jScrollPane2.setViewportView(txtdetalleUso);

        btnAlta.setText("Alta");
        btnAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaActionPerformed(evt);
            }
        });

        btnBaja.setText("Baja");
        btnBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBajaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(btnNuevo)
                .addGap(47, 47, 47)
                .addComponent(btnGuardar)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addGap(18, 18, 18)
                .addComponent(btnModificar)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar)
                .addGap(31, 31, 31)
                .addComponent(btnListar)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(279, 279, 279)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(159, 159, 159)
                                        .addComponent(btnAlta)
                                        .addGap(85, 85, 85)
                                        .addComponent(btnBaja))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Nombre)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(chkActivo)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(54, 54, 54))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(chkActivo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nombre))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAlta)
                            .addComponent(btnBaja))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnBuscar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnListar))
                .addGap(77, 77, 77))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardarInstalacion();
    }//GEN-LAST:event_btnGuardarActionPerformed
    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void chkActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkActivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkActivoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        modificarInstalacion();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminarInstalacion();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        listarInstalaciones();
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaActionPerformed
        altaLogica();
    }//GEN-LAST:event_btnAltaActionPerformed

    private void btnBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaActionPerformed
        bajaLogica();
    }//GEN-LAST:event_btnBajaActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
    }//GEN-LAST:event_txtNombreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Nombre;
    private javax.swing.JButton btnAlta;
    private javax.swing.JButton btnBaja;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JCheckBox chkActivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaInstalaciones;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextArea txtdetalleUso;
    // End of variables declaration//GEN-END:variables


}
