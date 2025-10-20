package Persistencia;

import Modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ClienteData {

    private Connection con = null;

    public ClienteData() {
        con = Conexion.getConexion();
    }

    public void insertarCliente(Cliente c) {
        String query = "INSERT INTO cliente(dni, nombreCompleto, telefono, edad, afecciones, estado) VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, c.getDni());
            ps.setString(2, c.getNombreCompleto());
            ps.setString(3, c.getTelefono());
            ps.setInt(4, c.getEdad());
            ps.setString(5, c.getAfecciones());
            ps.setBoolean(6, c.isEstado());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                c.setCodCli(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Cliente Guardado Exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo obtener ID");
            }
            ps.close();
            System.out.println("Guardado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cliente");
        }
    }

    public void actualizarCliente(Cliente c) {
        String query = "UPDATE cliente SET dni=?, nombreCompleto=?, telefono=?, edad=?, afecciones=?, estado=? "
                + "WHERE codCli=?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, c.getDni());
            ps.setString(2, c.getNombreCompleto());
            ps.setString(3, c.getTelefono());
            ps.setInt(4, c.getEdad());
            ps.setString(5, c.getAfecciones());
            ps.setBoolean(6, c.isEstado());
            ps.setInt(7, c.getCodCli());

            int actualizado = ps.executeUpdate();

            if (actualizado == 1) {
                JOptionPane.showMessageDialog(null, "Cliente actualizado");
            }
            
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cliente");
        }
    }
}
