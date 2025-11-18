package Persistencia;

import Modelo.Masajista;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MasajistaData {

    private Connection con = null;

    public MasajistaData() {
        con = Conexion.getConexion();
    }

    public void insertarMasajista(Masajista m) {
        String query = "INSERT INTO masajista(nombre_apellido, telefono, especialidad, estado) VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, m.getNombreApellido());
            ps.setString(2, m.getTelefono());
            ps.setString(3, m.getEspecialidad());
            ps.setBoolean(4, m.isEstado());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                m.setMatricula(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Masajista guardado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo obtener el ID");
            }
            ps.close();
        } catch (SQLException e) {
          JOptionPane.showMessageDialog(null, "Error SQL completo: " + e.getMessage());        }
    }

    public void actualizarMasajista(Masajista m) {
        String query = "UPDATE masajista SET nombre_apellido=?, telefono=?, especialidad=?, estado=? WHERE matricula=?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, m.getNombreApellido());
            ps.setString(2, m.getTelefono());
            ps.setString(3, m.getEspecialidad());
            ps.setBoolean(4, m.isEstado());
            ps.setInt(5, m.getMatricula());
            int actualizado = ps.executeUpdate();

            if (actualizado == 1) {
                JOptionPane.showMessageDialog(null, "Masajista actualizado");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el masajista");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla masajista");
        }
    }

    public Masajista buscarMasajistaPorMatricula(int matricula) {
        Masajista m = null;
        String query = "SELECT * FROM masajista WHERE matricula=?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, matricula);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                m = new Masajista();
                m.setMatricula(rs.getInt("matricula"));
                m.setNombreApellido(rs.getString("nombre_apellido"));
                m.setTelefono(rs.getString("telefono"));
                m.setEspecialidad(rs.getString("especialidad"));
                m.setEstado(rs.getBoolean("estado"));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el masajista");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla masajista");
        }
        return m;
    }

    public void bajaLogica(int matricula) {
        String query = "UPDATE masajista SET estado=0 WHERE matricula=?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, matricula);
            int actualizado = ps.executeUpdate();

            if (actualizado == 1) {
                JOptionPane.showMessageDialog(null, "Masajista dado de baja");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el masajista");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla masajista");
        }
    }

    public void altaLogica(int matricula) {
        String query = "UPDATE masajista SET estado=1 WHERE matricula=?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, matricula);
            int actualizado = ps.executeUpdate();

            if (actualizado == 1) {
                JOptionPane.showMessageDialog(null, "Masajista dado de alta");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el masajista");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla masajista");
        }
    }

    public void eliminarMasajista(int matricula) {
        String query = "DELETE FROM masajista WHERE matricula=?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, matricula);
            int eliminado = ps.executeUpdate();

            if (eliminado == 1) {
                JOptionPane.showMessageDialog(null, "Masajista eliminado");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el masajista");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla masajista");
        }
    }

    public List<Masajista> listarMasajistas() {
        List<Masajista> lista = new ArrayList<>();
        String query = "SELECT * FROM masajista";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Masajista m = new Masajista();
                m.setMatricula(rs.getInt("matricula"));
                m.setNombreApellido(rs.getString("nombre_apellido"));
                m.setTelefono(rs.getString("telefono"));
                m.setEspecialidad(rs.getString("especialidad"));
                m.setEstado(rs.getBoolean("estado"));
                lista.add(m);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla masajista");
        }
        return lista;
    }

    public List<Masajista> listarMasajistasPorEspecialidad(String especialidad) {
        List<Masajista> masajistas = new ArrayList<>();

        String query = "SELECT * FROM masajista WHERE especialidad = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, especialidad);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Masajista m = new Masajista();

                m.setMatricula(rs.getInt("matricula"));
                m.setNombreApellido(rs.getString("nombre_apellido"));
                m.setTelefono(rs.getString("telefono"));
                m.setEspecialidad(rs.getString("especialidad"));
                m.setEstado(rs.getBoolean("estado"));

                masajistas.add(m);
            }

            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar masajistas por especialidad");
        }

        return masajistas;
    }

}
