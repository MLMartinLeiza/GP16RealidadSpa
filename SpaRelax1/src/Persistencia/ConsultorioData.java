package Persistencia;

import Modelo.Consultorio;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ConsultorioData {

    private Connection con = null;

    public ConsultorioData() {
        con = Conexion.getConexion();
    }

    public void insertarConsultorio(Consultorio c) {
        String query = "INSERT INTO consultorio(usos, equipamiento, apto) VALUES(?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, c.getUsos());
            ps.setString(2, c.getEquipamiento());
            ps.setBoolean(3, c.isApto());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                c.setNroConsultorio(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Consultorio guardado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo obtener el ID");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla consultorio");
        }
    }

    public void actualizarConsultorio(Consultorio c) {
        String query = "UPDATE consultorio SET usos=?, equipamiento=?, apto=? WHERE nroConsultorio=?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, c.getUsos());
            ps.setString(2, c.getEquipamiento());
            ps.setBoolean(3, c.isApto());
            ps.setInt(4, c.getNroConsultorio());
            int actualizado = ps.executeUpdate();

            if (actualizado == 1) {
                JOptionPane.showMessageDialog(null, "Consultorio actualizado");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el consultorio");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla consultorio");
        }
    }

    public Consultorio buscarConsultorio(int nroConsultorio) {
        Consultorio c = null;
        String query = "SELECT * FROM consultorio WHERE nroConsultorio=?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, nroConsultorio);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                c = new Consultorio();
                c.setNroConsultorio(rs.getInt("nroConsultorio"));
                c.setUsos(rs.getString("usos"));
                c.setEquipamiento(rs.getString("equipamiento"));
                c.setApto(rs.getBoolean("apto"));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el consultorio");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla consultorio");
        }
        return c;
    }

    public void bajaLogica(int nroConsultorio) {
        String query = "UPDATE consultorio SET apto=0 WHERE nroConsultorio=?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, nroConsultorio);
            int actualizado = ps.executeUpdate();

            if (actualizado == 1) {
                JOptionPane.showMessageDialog(null, "Estado actualizado");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el consultorio");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla consultorio");
        }
    }

    public void altaLogica(int nroConsultorio) {
        String query = "UPDATE consultorio SET apto=1 WHERE nroConsultorio=?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, nroConsultorio);
            int actualizado = ps.executeUpdate();

            if (actualizado == 1) {
                JOptionPane.showMessageDialog(null, "Consultorio dado de alta correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el consultorio");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla consultorio");
        }
    }

    public void eliminarConsultorio(int nroConsultorio) {
        String query = "DELETE FROM consultorio WHERE nroConsultorio=?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, nroConsultorio);
            int eliminado = ps.executeUpdate();

            if (eliminado == 1) {
                JOptionPane.showMessageDialog(null, "Consultorio eliminado");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el consultorio");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla consultorio");
        }
    }

    public List<Consultorio> listarConsultorios() {
        List<Consultorio> lista = new ArrayList<>();
        String query = "SELECT * FROM consultorio";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Consultorio c = new Consultorio();
                c.setNroConsultorio(rs.getInt("nroConsultorio"));
                c.setUsos(rs.getString("usos"));
                c.setEquipamiento(rs.getString("equipamiento"));
                c.setApto(rs.getBoolean("apto"));
                lista.add(c);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla consultorio");
        }
        return lista;
    }
}