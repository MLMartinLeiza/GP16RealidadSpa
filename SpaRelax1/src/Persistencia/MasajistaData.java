/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Masajista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Santy
 */
public class MasajistaData {
      private Connection con = null;

    public MasajistaData(Conexion conexion) {
          con = Conexion.getConexion();
    }

    
      public void guardarMasajista(Masajista m) {
        String sql = "INSERT INTO masajista (nombre_apellido, telefono, especialidad, estado) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, m.getNombre_apellido());
            ps.setString(3, m.getTelefono());
            ps.setString(4, m.getEspecialidad());
            ps.setBoolean(5, m.isEstado());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                m.setMatricula(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Masajista agregado con éxito");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar masajista: " + ex.getMessage());
        }
    }
      
          public Masajista buscarMasajistaPorMatricula(int matricula) {
        String sql = "SELECT * FROM masajista WHERE matricula = ?";
        Masajista m = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, matricula);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                m = new Masajista();
                m.setMatricula(rs.getInt("matricula"));
                m.setNombre_apellido(rs.getString("nombre_apellido"));
                m.setTelefono(rs.getString("telefono"));
                m.setEspecialidad(rs.getString("especialidad"));
                m.setEstado(rs.getBoolean("estado"));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró masajista con esa matrícula");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar masajista: " + ex.getMessage());
        }
        return m;
    }   
}
