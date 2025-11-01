/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Consultorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ConsultorioData {
    
 private Connection con = null;

    public ConsultorioData(Conexion conexion) {
          con = Conexion.getConexion();
    }
    
    
    
    public void insertarConsultorio(Consultorio c) {
        String query = "INSERT INTO consultorio (usos, equipamiento, apto) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
           
            ps.setString(1, c.getUsos());
            ps.setString(2, c.getEquipamiento());
            ps.setBoolean(3, true);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                c.setNroConsultorio(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Consultorio Guardado Existosamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo obtener el ID");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de Consultorio");
        }
    }

    
    public void ActualizarConsultorio (Consultorio c) {
        String query = "UPDATE consultorio SET usos=?, equipamiento=?, apto=? "
                + "WHERE nroConsultorio=?";
        
     try {
         PreparedStatement ps = con.prepareStatement(query);
         ps.setString(1, c.getUsos());
         ps.setString(2, c.getEquipamiento());
         ps.setBoolean(3, c.isApto());
         ps.setInt(4, c.getNroConsultorio());
         
         int actualizado= ps.executeUpdate();
          if (actualizado == 1) {
                JOptionPane.showMessageDialog(null, "Consultorio actualizado");
            }

            ps.close();
         
         
         
     } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, "Error al acceder a la tabla consultorio");
     }
    
         
         
     }
     
      public void bajaLogica (int nroConsultorio){
     String query = "UPDATE consultorio SET apto = 0 WHERE nroConsultorio=?";
     
     
     try {
         PreparedStatement ps = con.prepareStatement(query);
         ps.setInt(1, nroConsultorio);
         int baja = ps.executeUpdate();
         
         if (baja == 1) {
                JOptionPane.showMessageDialog(null, "Estado actualizado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar estado");
            }

            ps.close();
             
     } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, "Error al acceder a la tabla consultorio");
     }
      
     
     
     
     
     
      
    }
    
public void altaLogica (int nroConsultorio){
         String query = "UPDATE consultorio SET apto=1 WHERE nroConsultorio=?";
         
     try {
         PreparedStatement ps = con.prepareStatement(query);
         ps.setInt(1, nroConsultorio);
         
         int actualizado = ps.executeUpdate();
         
         if (actualizado == 1) {
                JOptionPane.showMessageDialog(null, "Consultorio dado de alta correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro al Consultorio con ese numero");
            }
            ps.close(); 
         
     } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, "Error al acceder a la tabla consultorio");
     }
         
     }
           public Consultorio buscarConsultorio(int nroConsultorio) {
        String sql = "SELECT * FROM consultorio WHERE nroConsultorio = ?";
        Consultorio c = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, c.getNroConsultorio());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
               c = new Consultorio();
               c.setUsos(rs.getString("Usos"));
               c.setEquipamiento(rs.getString("Eqipamiento"));
               c.setApto(rs.getBoolean("Apto"));
                
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar servicio " + ex.getMessage());
        }
        return c;
    }   
}

