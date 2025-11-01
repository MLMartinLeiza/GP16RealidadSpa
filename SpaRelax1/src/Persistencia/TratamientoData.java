package Persistencia;

import Modelo.Tratamiento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class TratamientoData {

    private Connection con = null;

    public TratamientoData() {
        con = Conexion.getConexion();
    }

    public void insertarTratamiento(Tratamiento t) {
        String query = "INSERT INTO tratamiento(nombre, detalle, duracion, costo, activo) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, t.getNombre());
            ps.setString(2, t.getDetalle());
            ps.setInt(3, t.getDuracion());
            ps.setDouble(4, t.getCosto());
            ps.setBoolean(5, t.isEstado());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                t.setCodTratam(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Tratamiento Guardado Existosamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo obtener el ID");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla tratamiento");
        }
    }

    public void actualizarTratamiento(Tratamiento t) {
        String query = "UPDATE tratamiento SET nombre=?, detalle=?, duracion=?, costo=?, activo=? WHERE codTratam=?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, t.getNombre());
            ps.setString(2, t.getDetalle());
            ps.setInt(3, t.getDuracion());
            ps.setDouble(4, t.getCosto());
            ps.setBoolean(5, t.isEstado());
            ps.setInt(6, t.getCodTratam());

            int actualizado = ps.executeUpdate();

            if (actualizado == 1) {
                JOptionPane.showMessageDialog(null, "Tratamiento actualizado");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla tratamiento");
        }
    }

    public Tratamiento buscarTratamiento(String nombTrat) {
        Tratamiento tratamEncontrado = null;
        String query = "SELECT * FROM tratamiento WHERE nombre=?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, nombTrat);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                tratamEncontrado = new Tratamiento();
                tratamEncontrado.setCodTratam(rs.getInt("codTratam"));
                tratamEncontrado.setNombre(rs.getString("nombre"));
                tratamEncontrado.setDetalle(rs.getString("detalle"));
                tratamEncontrado.setDuracion(rs.getInt("duracion"));
                tratamEncontrado.setCosto(rs.getDouble("costo"));
                tratamEncontrado.setEstado(rs.getBoolean("activo"));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró tratamiento");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla tratamiento");
        }
        return tratamEncontrado;
    }

    public void bajaLogica(int codTratam) {
        String query = "UPDATE tratamiento SET activo=0 WHERE codTratam=?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codTratam);
            int actualizado = ps.executeUpdate();

            if (actualizado == 1) {
                JOptionPane.showMessageDialog(null, "Estado actualizado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar estado");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla tratamiento");

        }
    }

    public void altaLogica(int codTratam) {
        String query = "UPDATE tratamiento SET activo=1 WHERE codTratam=?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codTratam);
            int actualizado = ps.executeUpdate();

            if (actualizado == 1) {
                JOptionPane.showMessageDialog(null, "Estado actualizado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar estado");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla tratamiento");
        }
    }

    public void eliminarTratamiento(int codTratam) {
        String query = "DELETE FROM tratamiento WHERE codTratam=?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codTratam);
            int eliminado = ps.executeUpdate();

            if (eliminado == 1) {
                JOptionPane.showMessageDialog(null, "Tratamiento eliminado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar tratamiento");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla tratamiento");
        }
    }

    public List<Tratamiento> listarTratamientos() {
        List<Tratamiento> tratamientos = new ArrayList<>();
        String query = "SELECT * FROM tratamiento WHERE activo=?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Tratamiento tratamiento = new Tratamiento();
                tratamiento.setCodTratam(rs.getInt("codTratam"));
                tratamiento.setNombre(rs.getString("nombre"));
                tratamiento.setDetalle(rs.getString("detalle"));
                tratamiento.setDuracion(rs.getInt("duracion"));
                tratamiento.setCosto(rs.getDouble("costo"));
                tratamiento.setEstado(rs.getBoolean("activo"));
                tratamientos.add(tratamiento);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla tratamiento");
        }
        return tratamientos;
    }

}
