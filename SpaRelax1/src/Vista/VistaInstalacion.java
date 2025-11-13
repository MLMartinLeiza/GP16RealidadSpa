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
        instalacionData = new InstalacionData();
        modeloTabla = new DefaultTableModel();
        armarTabla();
        
        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        setTitle("Gestión de Instalaciones");

        setLocation(150, 50);
        
    }

    private void limpiarCampos() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtdetalleUso.setText("");
        txtPrecio.setText("");
        chkActivo.setSelected(false);
    }

    private void guardarInstalacion() {
        try {
            String nombre = txtNombre.getText().trim();
            String detalle = txtdetalleUso.getText().trim();
            String precioTxt = txtPrecio.getText().trim();
            boolean estado = chkActivo.isSelected();

            if (nombre.isEmpty() || detalle.isEmpty() || precioTxt.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Complete todos los campos obligatorios");
                return;
            }

            double precio = Double.parseDouble(precioTxt);
            if (precio <= 0) {
                JOptionPane.showMessageDialog(this, "El precio debe ser mayor a 0.");
                return;
            }

            Instalacion ins = new Instalacion(nombre, detalle, precio, estado);
            instalacionData.insertarInstalacion(ins);
            txtCodigo.setText(String.valueOf(ins.getCodInstal()));
            listarInstalaciones();
            limpiarCampos();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El precio debe ser numérico.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al guardar instalación: " + e.getMessage());
        }
    }

    private void buscarInstalacion() {
        try {
            int codigo = Integer.parseInt(txtCodigo.getText().trim());
            Instalacion ins = instalacionData.buscarInstalacionPorCodigo(codigo);

            if (ins != null) {
                txtNombre.setText(ins.getNombre());
                txtdetalleUso.setText(ins.getDetalleUso());
                txtPrecio.setText(String.valueOf(ins.getPrecio30m()));
                chkActivo.setSelected(ins.isEstado());
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró instalación con ese código.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un código válido para buscar.");
        }
    }

    private void modificarInstalacion() {
        try {
            int codigo = Integer.parseInt(txtCodigo.getText());
            String nombre = txtNombre.getText().trim();
            String detalle = txtdetalleUso.getText().trim();
            String precioTxt = txtPrecio.getText().trim();
            boolean estado = chkActivo.isSelected();

            if (nombre.isEmpty() || detalle.isEmpty() || precioTxt.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Complete todos los campos antes de modificar.");
                return;
            }

            double precio = Double.parseDouble(precioTxt);
            if (precio <= 0) {
                JOptionPane.showMessageDialog(this, "El precio debe ser mayor a 0.");
                return;
            }

            Instalacion ins = new Instalacion(codigo, nombre, detalle, precio, estado);
            boolean actualizado = instalacionData.actualizarInstalacion(ins);

            if (actualizado) {
                JOptionPane.showMessageDialog(this, "Instalación modificada correctamente.");
                listarInstalaciones();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo modificar la instalación.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un código y un precio válidos.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al modificar instalación: " + e.getMessage());
        }
    }

    private void listarInstalaciones() {
        modeloTabla.setRowCount(0);

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

    private void armarTabla() {
        modeloTabla.addColumn("Código");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Detalle");
        modeloTabla.addColumn("Precio");
        modeloTabla.addColumn("Estado");
        tablaInstalaciones.setModel(modeloTabla);
    }

    private void altaLogica() {
        try {
            int codigo = Integer.parseInt(txtCodigo.getText());
            instalacionData.altaLogica(codigo);
            listarInstalaciones();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un código válido para dar de alta.");
        }
    }

    private void bajaLogica() {
        try {
            int codigo = Integer.parseInt(txtCodigo.getText());
            instalacionData.bajaLogica(codigo);
            listarInstalaciones();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un código válido para dar de baja.");
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
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaInstalaciones = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtdetalleUso = new javax.swing.JTextArea();
        btnAlta = new javax.swing.JButton();
        btnBaja = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cmbDuracion = new javax.swing.JComboBox<>();

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

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        jLabel3.setText("Codigo");

        jLabel6.setText("Duración");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnNuevo)
                        .addGap(34, 34, 34)
                        .addComponent(btnGuardar)
                        .addGap(38, 38, 38)
                        .addComponent(btnBuscar)
                        .addGap(48, 48, 48)
                        .addComponent(btnModificar)
                        .addGap(54, 54, 54)
                        .addComponent(btnListar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(104, 104, 104))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Nombre)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(150, 150, 150)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5))
                                    .addComponent(btnAlta))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chkActivo)
                                    .addComponent(btnBaja))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3))))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCodigo)
                            .addComponent(cmbDuracion, 0, 100, Short.MAX_VALUE))
                        .addGap(49, 49, 49))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Nombre)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(chkActivo)
                            .addComponent(jLabel3)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBaja)
                            .addComponent(jLabel6)
                            .addComponent(cmbDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnAlta)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnBuscar)
                    .addComponent(btnListar)
                    .addComponent(btnModificar))
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

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void chkActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkActivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkActivoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarInstalacion();
    }//GEN-LAST:event_btnBuscarActionPerformed

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

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        modificarInstalacion();
    }//GEN-LAST:event_btnModificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Nombre;
    private javax.swing.JButton btnAlta;
    private javax.swing.JButton btnBaja;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JCheckBox chkActivo;
    private javax.swing.JComboBox<String> cmbDuracion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
