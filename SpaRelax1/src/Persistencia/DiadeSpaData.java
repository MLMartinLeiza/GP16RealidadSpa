/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.DiadeSpa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class DiadeSpaData {
     private Connection con = null;

    public DiadeSpaData(Conexion conexion) {
          con = Conexion.getConexion();
    }

   public void guardarMasajista(DiadeSpa d) {
        String sql = "INSERT INTO masajista (fechaHora, preferencias, CodCli, monto, estado) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setTimestamp(1, Timestamp.valueOf(LocalDateTime.MIN));
            ps.setString(2, d.getPreferencias());
            ps.setInt(3, d.getCodCli());
            ps.setBoolean(4, d.isMonto());
            ps.setBoolean(5, d.isEstado());
          
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                d.setCodPack(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Dia de spa guardado con exito");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar dia de spa " + ex.getMessage());
        }
    }
}

