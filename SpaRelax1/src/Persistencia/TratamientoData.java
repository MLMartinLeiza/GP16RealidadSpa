package Persistencia;

import Modelo.Tratamiento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class TratamientoData {

    private Connection con = null;

    public TratamientoData() {
        con = Conexion.getConexion();
    }

    public void insertarTratamiento(Tratamiento t) {
        String query = "INSERT INTO tratamiento(nombre, detalle, duracion, costo, activo) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, t.getNombre());
            ps.setString(2, t.getDetalle());
            ps.setInt(3, t.getDuracion());
            ps.setDouble(4, t.getCosto());
            ps.setBoolean(5, t.isEstado());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                t.setCodTratam(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Tratamiento Guardado Existosamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo obtener el ID");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla tratamiento");
        }
    }

    public void actualizarTratamiento(Tratamiento t) {
        String query = "UPDATE tratamiento SET nombre=?, detalle=?, duracion=?, costo=?, activo=? WHERE codTratam=?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, t.getNombre());
            ps.setString(2, t.getDetalle());
            ps.setInt(3, t.getDuracion());
            ps.setDouble(4, t.getCosto());
            ps.setBoolean(5, t.isEstado());
            ps.executeUpdate();

            int actualizado = ps.executeUpdate();

            if (actualizado == 1) {
                JOptionPane.showMessageDialog(null, "Tratamiento actualizado");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla tratamiento");
        }
    }
}
