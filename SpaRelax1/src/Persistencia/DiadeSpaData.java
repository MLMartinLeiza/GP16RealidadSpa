package Persistencia;

import Modelo.DiadeSpa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DiadeSpaData {

    private Connection con = null;

    public DiadeSpaData() {
        con = Conexion.getConexion();
    }

    public void insertarDiadeSpa(DiadeSpa d) {
        String query = "INSERT INTO dia_de_spa(fecha_hora, preferencias, codCli, monto, estado) VALUES(?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setTimestamp(1, Timestamp.valueOf(d.getFechaHora()));
            ps.setString(2, d.getPreferencias());
            ps.setInt(3, d.getCodCli());
            ps.setDouble(4, d.getMonto());
            ps.setBoolean(5, d.isEstado());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                d.setCodPack(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Día de Spa guardado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo obtener ID del Día de Spa");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla dia_de_spa");
        }
    }

    public void actualizarDiadeSpa(DiadeSpa d) {
        String query = "UPDATE dia_de_spa SET fecha_hora=?, preferencias=?, codCli=?, monto=?, estado=? WHERE codPack=?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setTimestamp(1, Timestamp.valueOf(d.getFechaHora()));
            ps.setString(2, d.getPreferencias());
            ps.setInt(3, d.getCodCli());
            ps.setDouble(4, d.getMonto());
            ps.setBoolean(5, d.isEstado());
            ps.setInt(6, d.getCodPack());

            int actualizado = ps.executeUpdate();

            if (actualizado == 1) {
                JOptionPane.showMessageDialog(null, "Día de Spa actualizado");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el Día de Spa para actualizar");
            }

            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla dia_de_spa");
        }
    }

    public DiadeSpa buscarDiadeSpaPorCodigo(int codPack) {
        DiadeSpa d = null;
        String query = "SELECT * FROM dia_de_spa WHERE codPack=?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codPack);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                d = new DiadeSpa();
                d.setCodPack(rs.getInt("codPack"));
                Timestamp ts = rs.getTimestamp("fecha_hora");
                if (ts != null) {
                    d.setFechaHora(ts.toLocalDateTime());
                } else {
                    d.setFechaHora(LocalDateTime.now());
                }
                d.setPreferencias(rs.getString("preferencias"));
                d.setCodCli(rs.getInt("codCli"));
                d.setMonto(rs.getDouble("monto"));
                d.setEstado(rs.getBoolean("estado"));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró Día de Spa con ese código");
            }

            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla dia_de_spa");
        }
        return d;
    }

    public void bajaLogica(int codPack) {
        String query = "UPDATE dia_de_spa SET estado=0 WHERE codPack=?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codPack);
            int actualizado = ps.executeUpdate();

            if (actualizado == 1) {
                JOptionPane.showMessageDialog(null, "Estado actualizado (baja lógica)");
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar estado");
            }

            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla dia_de_spa");
        }
    }

    public void altaLogica(int codPack) {
        String query = "UPDATE dia_de_spa SET estado=1 WHERE codPack=?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codPack);
            int actualizado = ps.executeUpdate();

            if (actualizado == 1) {
                JOptionPane.showMessageDialog(null, "Estado actualizado (alta lógica)");
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar estado");
            }

            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla dia_de_spa");
        }
    }

    public void eliminarDiadeSpa(int codPack) {
        String query = "DELETE FROM dia_de_spa WHERE codPack=?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codPack);
            int eliminado = ps.executeUpdate();

            if (eliminado == 1) {
                JOptionPane.showMessageDialog(null, "Día de Spa eliminado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar Día de Spa");
            }

            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla dia_de_spa");
        }
    }

    public List<DiadeSpa> listarDiadeSpa() {
        String query = "SELECT * FROM dia_de_spa WHERE estado=1";
        List<DiadeSpa> lista = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                DiadeSpa d = new DiadeSpa();
                d.setCodPack(rs.getInt("codPack"));
                Timestamp ts = rs.getTimestamp("fecha_hora");
                if (ts != null) {
                    d.setFechaHora(ts.toLocalDateTime());
                } else {
                    d.setFechaHora(LocalDateTime.now());
                }
                d.setPreferencias(rs.getString("preferencias"));
                d.setCodCli(rs.getInt("codCli"));
                d.setMonto(rs.getDouble("monto"));
                d.setEstado(rs.getBoolean("estado"));
                lista.add(d);
            }

            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla dia_de_spa");
        }
        return lista;
    }
}
