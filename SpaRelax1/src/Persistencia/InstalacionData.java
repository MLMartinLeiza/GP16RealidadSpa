package Persistencia;

import Modelo.Instalacion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class InstalacionData {

    private Connection con = null;

    public InstalacionData() {
        con = Conexion.getConexion();
    }

    public void insertarInstalacion(Instalacion ins) {
        String sql = "INSERT INTO instalacion (nombre, detalle_Uso, precio_30m, estado) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, ins.getNombre());
            ps.setString(2, ins.getDetalleUso());
            ps.setDouble(3, ins.getPrecio30m());
            ps.setBoolean(4, ins.isEstado());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                ins.setCodInstal(rs.getInt(1));
            }

            JOptionPane.showMessageDialog(null, "Instalación guardada correctamente.");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar instalación: " + ex.getMessage());
        }
    }

    public boolean actualizarInstalacion(Instalacion ins) {
        String sql = "UPDATE instalacion SET nombre = ?, detalle_Uso = ?, precio_30m = ?, estado = ? WHERE codInstal = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, ins.getNombre());
            ps.setString(2, ins.getDetalleUso());
            ps.setDouble(3, ins.getPrecio30m());
            ps.setBoolean(4, ins.isEstado());
            ps.setInt(5, ins.getCodInstal());

            int exito = ps.executeUpdate();
            return exito == 1;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar instalación: " + ex.getMessage());
            return false;
        }
    }

    public Instalacion buscarInstalacionPorCodigo(int codigo) {
        String sql = "SELECT * FROM instalacion WHERE codInstal = ?";
        Instalacion ins = null;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                ins = new Instalacion();
                ins.setCodInstal(rs.getInt("codInstal"));
                ins.setNombre(rs.getString("nombre"));
                ins.setDetalleUso(rs.getString("detalleUso"));
                ins.setPrecio30m(rs.getDouble("precio30m"));
                ins.setEstado(rs.getBoolean("estado"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar instalación: " + ex.getMessage());
        }

        return ins;
    }

    public boolean bajaLogica(int codigo) {
        String sql = "UPDATE instalacion SET estado = 0 WHERE codInstal = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, codigo);
            int exito = ps.executeUpdate();
            return exito == 1;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al dar de baja la instalación: " + ex.getMessage());
            return false;
        }
    }

    public boolean altaLogica(int codigo) {
        String sql = "UPDATE instalacion SET estado = 1 WHERE codInstal = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, codigo);
            int exito = ps.executeUpdate();
            return exito == 1;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al dar de alta la instalación: " + ex.getMessage());
            return false;
        }
    }

    public boolean eliminarInstalacion(int codigo) {
        String sql = "DELETE FROM instalacion WHERE codInstal = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, codigo);
            int exito = ps.executeUpdate();
            return exito == 1;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar instalación: " + ex.getMessage());
            return false;
        }
    }

    public List<Instalacion> listarInstalaciones() {
        List<Instalacion> lista = new ArrayList<>();
        String sql = "SELECT * FROM instalacion";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Instalacion ins = new Instalacion();
                ins.setCodInstal(rs.getInt("codInstal"));
                ins.setNombre(rs.getString("nombre"));
                ins.setDetalleUso(rs.getString("detalleUso"));
                ins.setPrecio30m(rs.getDouble("precio30m"));
                ins.setEstado(rs.getBoolean("estado"));
                lista.add(ins);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar instalaciones: " + ex.getMessage());
        }

        return lista;
    }
}
