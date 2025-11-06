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
        String query = "INSERT INTO instalacion(nombre, detalle_uso, precio_30min, estado) VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, ins.getNombre());
            ps.setString(2, ins.getDetalleUso());
            ps.setDouble(3, ins.getPrecio30m());
            ps.setBoolean(4, ins.isEstado());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                ins.setCodInstal(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Instalación guardada exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo obtener el ID");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla instalacion");
        }
    }

    public void actualizarInstalacion(Instalacion ins) {
        String query = "UPDATE instalacion SET nombre=?, detalle_uso=?, precio_30min=?, estado=? WHERE codInstal=?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, ins.getNombre());
            ps.setString(2, ins.getDetalleUso());
            ps.setDouble(3, ins.getPrecio30m());
            ps.setBoolean(4, ins.isEstado());
            ps.setInt(5, ins.getCodInstal());
            int actualizado = ps.executeUpdate();

            if (actualizado == 1) {
                JOptionPane.showMessageDialog(null, "Instalación actualizada");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la instalación");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla instalacion");
        }
    }

    public Instalacion buscarInstalacion(String nombre) {
        Instalacion ins = null;
        String query = "SELECT * FROM instalacion WHERE nombre=?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                ins = new Instalacion();
                ins.setCodInstal(rs.getInt("codInstal"));
                ins.setNombre(rs.getString("nombre"));
                ins.setDetalleUso(rs.getString("detalle_uso"));
                ins.setPrecio30m(rs.getDouble("precio_30min"));
                ins.setEstado(rs.getBoolean("estado"));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la instalación");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla instalacion");
        }
        return ins;
    }

    public void bajaLogica(int codInstal) {
        String query = "UPDATE instalacion SET estado=0 WHERE codInstal=?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codInstal);
            int actualizado = ps.executeUpdate();

            if (actualizado == 1) {
                JOptionPane.showMessageDialog(null, "Estado actualizado");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la instalación");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla instalacion");
        }
    }

    public void altaLogica(int codInstal) {
        String query = "UPDATE instalacion SET estado=1 WHERE codInstal=?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codInstal);
            int actualizado = ps.executeUpdate();

            if (actualizado == 1) {
                JOptionPane.showMessageDialog(null, "Estado actualizado");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la instalación");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla instalacion");
        }
    }

    public void eliminarInstalacion(int codInstal) {
        String query = "DELETE FROM instalacion WHERE codInstal=?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codInstal);
            int eliminado = ps.executeUpdate();

            if (eliminado == 1) {
                JOptionPane.showMessageDialog(null, "Instalación eliminada");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la instalación");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla instalacion");
        }
    }

    public List<Instalacion> listarInstalaciones() {
        List<Instalacion> lista = new ArrayList<>();
        String query = "SELECT * FROM instalacion WHERE estado=1";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Instalacion ins = new Instalacion();
                ins.setCodInstal(rs.getInt("codInstal"));
                ins.setNombre(rs.getString("nombre"));
                ins.setDetalleUso(rs.getString("detalle_uso"));
                ins.setPrecio30m(rs.getDouble("precio_30min"));
                ins.setEstado(rs.getBoolean("estado"));
                lista.add(ins);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla instalacion");
        }
        return lista;
    }

    public void insertarInstalacion(Vista.VistaInstalacion ins) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
