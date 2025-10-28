/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Servicio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ServicioData {
    
    private Connection con = null;

  
    public ServicioData(Conexion conexion) {
        con = Conexion.getConexion();
    }
             public Servicio buscarServicio(int idServicio) {
        String sql = "SELECT * FROM servicio WHERE idServicio = ?";
        Servicio s = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, s.getIdServicio());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                s = new Servicio();
                s.setNombre(rs.getString("nombre"));
                s.setDescripcion(rs.getString("Descripcion"));
                s.setPrecio(rs.getDouble("Precio"));
                s.setEstado(rs.getBoolean("Estado"));
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar el consultorio " + ex.getMessage());
        }
        return s;
    }   
             
}
