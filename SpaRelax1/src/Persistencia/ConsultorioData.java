/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Consultorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ConsultorioData {
    
 private Connection con = null;

    public ConsultorioData() {
          con = Conexion.getConexion();
    }
    
    private void ActualizarConsultorio (Consultorio c) {
        String query = "UPDATE Consultorio SET usos=?, Equipamiento=?, apto=? "
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
    
 
 

    
    
}
