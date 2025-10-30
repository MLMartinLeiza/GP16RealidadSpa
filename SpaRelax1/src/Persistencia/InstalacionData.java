/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Instalacion;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;


public class InstalacionData {
    private Connection con = null;
    
    public InstalacionData(Conexion conexion){
        con = Conexion.getConexion();
    }
    
    public void guardarInstalacion(Instalacion ins) {
        String sql = "INSERT INTO instalacion (nombre, detalleUso, precio30m, estado) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, ins.getNombre());
            ps.setString(2, ins.getDetalleDeUso());
            ps.setDouble(3, ins.getPrecio30m());
            ps.setBoolean(4, ins.isEstado());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                ins.setCodInstall(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Instalación guardada con éxito.");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar instalación: " + e.getMessage());
        }
    }
            
            
}