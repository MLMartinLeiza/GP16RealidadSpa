package Persistencia;

import Modelo.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class SesionData {
    private Connection con = null;
    private MasajistaData masajistaData;
    private ConsultorioData consultorioData;
    private ServicioData servicioData;

    public SesionData(Conexion conexion) {
        con = conexion.getConexion();
        masajistaData = new MasajistaData(conexion);
        consultorioData = new ConsultorioData(conexion);
        servicioData = new ServicioData(conexion);
    }

    public void guardarSesion(Sesion sesion) {
        // corregir esto
        String sql = "INSERT INTO sesion (fecha_hora_inicio, fecha_hora_fin, codTratamiento, nroConsultorio, matricula, codPack, estado, codInstal) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setTimestamp(1, Timestamp.valueOf(sesion.getFechaHoraInicio()));
            ps.setTimestamp(2, Timestamp.valueOf(sesion.getFechaHoraFin()));
            ps.setInt(3, sesion.getMasajista().getMatricula());
            ps.setInt(4, sesion.getTratamiento().getIdServicio());
            ps.setInt(5, sesion.getConsultorio().getIdConsultorio());
            ps.setBoolean(6, sesion.isEstado());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                sesion.setCodSesion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Sesión guardada correctamente.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar sesión: " + ex.getMessage());
        }
    }

    public List<Sesion> listarSesiones() {
        List<Sesion> sesiones = new ArrayList<>();
        String sql = "SELECT * FROM sesion WHERE estado = 1";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Sesion s = new Sesion();
                s.setCodSesion(rs.getInt("codSesion"));
                s.setFechaHoraInicio(rs.getTimestamp("fechaHoraInicio").toLocalDateTime());
                s.setFechaHoraFin(rs.getTimestamp("fechaHoraFin").toLocalDateTime());
                s.setMasajista(masajistaData.buscarMasajistaPorMatricula(rs.getInt("idMasajista")));
                s.setTratamiento(servicioData.buscarServicio(rs.getInt("idServicio")));
                s.setConsultorio(consultorioData.buscarConsultorio(rs.getInt("idConsultorio")));
                s.setEstado(rs.getBoolean("estado"));
                sesiones.add(s);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar sesiones: " + ex.getMessage());
        }
        return sesiones;
    }
}
