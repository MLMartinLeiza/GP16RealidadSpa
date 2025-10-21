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

    public Cliente buscarCliente(String nombreCliente) {
        Cliente clienteEncontrado = null;

        String query = "SELECT * FROM cliente WHERE nombreCompleto=?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, nombreCliente);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                clienteEncontrado = new Cliente();

                clienteEncontrado.setCodCli(rs.getInt("codCli"));
                clienteEncontrado.setDni(rs.getInt("dni"));
                clienteEncontrado.setNombreCompleto(rs.getString("nombreCompleto"));
                clienteEncontrado.setTelefono(rs.getString("telefono"));
                clienteEncontrado.setEdad(rs.getInt("edad"));
                clienteEncontrado.setAfecciones(rs.getString("afecciones"));
                clienteEncontrado.setEstado(rs.getBoolean("estado"));

            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el cliente");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cliente");
        }
        return clienteEncontrado;
    }

    public void bajaLogica(int codCli) {
        String query = "UPDATE cliente SET estado=0 WHERE codCli=?";

        try {
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, codCli);
            int actualizado = ps.executeUpdate();

            if (actualizado == 1) {
                JOptionPane.showMessageDialog(null, "Estado actualizado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar estado");
            }

            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cliente");
        }
    }

    public void altaLogica(int codCli) {
        String query = "UPDATE cliente SET estado=1 WHERE codCli=?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codCli);

            int actualizado = ps.executeUpdate();

            if (actualizado == 1) {
                JOptionPane.showMessageDialog(null, "Estado actualizado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar estado");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cliente");
        }
    }

    public void eliminarCliente(int codCli) {
        String query = "DELETE FROM cliente WHERE codCli=?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codCli);

            int eliminado = ps.executeUpdate();

            if (eliminado == 1) {
                JOptionPane.showMessageDialog(null, "Cliente eliminado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliinar cliente");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cliente");
        }
    }
}
