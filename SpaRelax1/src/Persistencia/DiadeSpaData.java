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

   public void guardarDiadeSpa(DiadeSpa d) {
        String sql = "INSERT INTO diadespa(fechaHora, preferencias, CodCli, monto, estado) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setTimestamp(1, Timestamp.valueOf(LocalDateTime.MIN));
            ps.setString(2, d.getPreferencias());
            ps.setInt(3, d.getCodCli());
            ps.setDouble(4, d.getMonto());
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
    public DiadeSpa buscarDiadeSpaporCodigo(int matricula) {
        String sql = "SELECT * FROM diadespa WHERE codPack = ?";
        DiadeSpa d = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, matricula);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                d = new DiadeSpa();
                d.setCodCli(rs.getInt("CodigoPack"));
                Timestamp ts = rs.getTimestamp("FechaHora");
                d.setPreferencias(rs.getString("Preferencias"));
                d.setMonto(rs.getDouble("Monto"));
                d.setEstado(rs.getBoolean("Estado"));

                
                
               
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró Dia de Spa ");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar Dia de Spa: " + ex.getMessage());
        }
        return d;
    }   
    
     public void ActializarDiadeSpa(DiadeSpa d) {
        String query = "UPDATE diadespa SET fechaHora=?, preferencias=? codCli=? monto=? estado=? WHERE codPack = ?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            
            Timestamp ts = Timestamp.valueOf(d.getfechaHora());
            ps.setString(0, d.getPreferencias());
            ps.setDouble(0, d.getMonto());
            ps.setBoolean(0, true);
            
            int logrado = ps.executeUpdate();
            

            if (logrado == 1) {
                JOptionPane.showMessageDialog(null, "Dia de Spa actualizada");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de Dia de Spa");
        }
    }
     public void bajaLogica(int codPack) {
        String query = "UPDATE diadespa SET estado=0 WHERE codPack=?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codPack);
            int actualizado = ps.executeUpdate();

            if (actualizado == 1) {
                JOptionPane.showMessageDialog(null, "Estado actualizado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar estado");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Dia de Spa");

        }
    }
   
    public void altaLogica(int codPack) {
        String query = "UPDATE diadespa SET estado=1 WHERE codPack=?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codPack);
            int actualizado = ps.executeUpdate();

            if (actualizado == 1) {
                JOptionPane.showMessageDialog(null, "Estado actualizado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar estado");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Dia de Spa");
        }
    }
    public void eliminarDiadeSpa(int codPack) {
        String query = "DELETE FROM diadespa WHERE codPack?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codPack);
            int eliminado = ps.executeUpdate();

            if (eliminado == 1) {
                JOptionPane.showMessageDialog(null, "Dia de spa eliminado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar Dia de Spa");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Dia de Spa");
        }
    }
    
}

