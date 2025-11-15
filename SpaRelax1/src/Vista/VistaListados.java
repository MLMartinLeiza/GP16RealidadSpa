package Vista;

import Persistencia.DiadeSpaData;
import Persistencia.MasajistaData;
import Persistencia.SesionData;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class VistaListados extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo;
    private MasajistaData masajistaData;
    private DiadeSpaData diaSpaData;
    private SesionData sesionData;

    public VistaListados() {
        initComponents();
        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        modelo = new DefaultTableModel();

        modelo = new DefaultTableModel();
        tblListas.setModel(modelo);

        masajistaData = new MasajistaData();
        diaSpaData = new DiadeSpaData();
        sesionData = new SesionData();

        cargarComboTipoListado();
        cargarComboHoras();
        cargarComboEspecialidad();
        cargarComboTipoTratamiento();

    }

    private void cargarComboTipoListado() {
        cmbTipoListado.removeAllItems();
        cmbTipoListado.addItem("Día de Spa completo");
        cmbTipoListado.addItem("Masajistas por especialidad");
        cmbTipoListado.addItem("Días de Spa por fecha");
    }

    private void cargarComboHoras() {
        List<String> horarios = new ArrayList<>();

        horarios.add("08:00");
        horarios.add("08:30");
        horarios.add("09:00");
        horarios.add("09:30");
        horarios.add("10:00");
        horarios.add("10:30");
        horarios.add("11:00");
        horarios.add("11:30");
        horarios.add("12:00");
        horarios.add("12:30");
        horarios.add("13:00");
        horarios.add("13:30");
        horarios.add("14:00");
        horarios.add("14:30");
        horarios.add("15:00");
        horarios.add("15:30");
        horarios.add("16:00");
        horarios.add("16:30");
        horarios.add("17:00");
        horarios.add("17:30");
        horarios.add("18:00");
        horarios.add("18:30");
        horarios.add("19:00");
        horarios.add("19:30");

        cmbHoraDesde.removeAllItems();
        cmbHoraHasta.removeAllItems();

        for (String h : horarios) {
            cmbHoraDesde.addItem(h);
            cmbHoraHasta.addItem(h);
        }
    }

    private void cargarComboEspecialidad() {
        cmbTipoEspecialidad.removeAllItems();
        cmbTipoEspecialidad.addItem("facial");
        cmbTipoEspecialidad.addItem("corporal");
        cmbTipoEspecialidad.addItem("relajación");
        cmbTipoEspecialidad.addItem("estético");
    }

    private void cargarComboTipoTratamiento() {
        cmbTipoTratamiento.removeAllItems();
        cmbTipoTratamiento.addItem("facial");
        cmbTipoTratamiento.addItem("corporal");
        cmbTipoTratamiento.addItem("relajación");
        cmbTipoTratamiento.addItem("estético");
    }

    private void limpiarTabla() {
        int filas = modelo.getRowCount() - 1;
        for (int i = filas; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    private void limpiarCampos() {
        dateDesde.setDate(null);
        dateHasta.setDate(null);
        if (cmbHoraDesde.getItemCount() > 0) {
            cmbHoraDesde.setSelectedIndex(0);
        }
        if (cmbHoraHasta.getItemCount() > 0) {
            cmbHoraHasta.setSelectedIndex(0);
        }
        if (cmbTipoEspecialidad.getItemCount() > 0) {
            cmbTipoEspecialidad.setSelectedIndex(0);
        }
        if (cmbTipoTratamiento.getItemCount() > 0) {
            cmbTipoTratamiento.setSelectedIndex(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbTipoListado = new javax.swing.JComboBox<>();
        btnListar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        dateDesde = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        dateHasta = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        cmbHoraDesde = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cmbHoraHasta = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cmbTipoEspecialidad = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cmbTipoTratamiento = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListas = new javax.swing.JTable();

        jLabel1.setText("Listados");

        jLabel2.setText("Tipo de listado:");

        cmbTipoListado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cmbTipoListado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoListadoActionPerformed(evt);
            }
        });

        btnListar.setText("Listar");

        jLabel4.setText("Fecha desde:");

        jLabel5.setText("Hasta:");

        jLabel6.setText("Hora desde:");

        jLabel7.setText("Hasta:");

        jLabel8.setText("Especialidad:");

        jLabel3.setText("Tratamiento:");

        tblListas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblListas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbHoraDesde, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dateDesde, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbHoraHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(cmbTipoListado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnListar)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cmbTipoEspecialidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbTipoTratamiento, 0, 250, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(420, 420, 420)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cmbTipoListado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(cmbTipoEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(dateDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(cmbTipoTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(dateHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbHoraDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cmbHoraHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListar))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbTipoListadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoListadoActionPerformed

    }//GEN-LAST:event_cmbTipoListadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnListar;
    private javax.swing.JComboBox<String> cmbHoraDesde;
    private javax.swing.JComboBox<String> cmbHoraHasta;
    private javax.swing.JComboBox<String> cmbTipoEspecialidad;
    private javax.swing.JComboBox<String> cmbTipoListado;
    private javax.swing.JComboBox<String> cmbTipoTratamiento;
    private com.toedter.calendar.JDateChooser dateDesde;
    private com.toedter.calendar.JDateChooser dateHasta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListas;
    // End of variables declaration//GEN-END:variables
}
