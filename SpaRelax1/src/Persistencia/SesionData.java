package Persistencia;

import Modelo.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class SesionData {

    private Connection con = null;

    public SesionData() {
        con = Conexion.getConexion();
    }

    public void insertarSesion(Sesion s) {
        String query = "INSERT INTO sesion "
                + "(fecha_hora_inicio, fecha_hora_fin, codTratamiento, nroConsultorio, "
                + " matricula, codPack, estado, codInstal) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ps.setTimestamp(1, Timestamp.valueOf(s.getFechaHoraInicio()));

            if (s.getFechaHoraFin() != null) {
                ps.setTimestamp(2, Timestamp.valueOf(s.getFechaHoraFin()));
            } else {
                ps.setNull(2, Types.TIMESTAMP);
            }

            if (s.getTratamiento() != null) {
                ps.setInt(3, s.getTratamiento().getCodTratam());
            } else {
                ps.setNull(3, Types.INTEGER);
            }

            if (s.getConsultorio() != null) {
                ps.setInt(4, s.getConsultorio().getNroConsultorio());
            } else {
                ps.setNull(4, Types.INTEGER);
            }

            if (s.getMasajista() != null) {
                ps.setInt(5, s.getMasajista().getMatricula());
            } else {
                ps.setNull(5, Types.INTEGER);
            }

            if (s.getDiaDeSpa() != null) {
                ps.setInt(6, s.getDiaDeSpa().getCodPack());
            } else {
                ps.setNull(6, Types.INTEGER);
            }

            ps.setBoolean(7, s.isEstado());

            if (s.getInstalacion() != null) {
                ps.setInt(8, s.getInstalacion().getCodInstal());
            } else {
                ps.setNull(8, Types.INTEGER);
            }

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                s.setCodSesion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Sesión guardada exitosamente");
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla sesion");
        }
    }

    public void actualizarSesion(Sesion s) {
        String query = "UPDATE sesion SET fecha_hora_inicio=?, fecha_hora_fin=?, codTratamiento=?, nroConsultorio=?, matricula=?, codPack=?, estado=?, codInstal=? WHERE codSesion=?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setTimestamp(1, Timestamp.valueOf(s.getFechaHoraInicio()));

            if (s.getFechaHoraFin() != null) {
                ps.setTimestamp(2, Timestamp.valueOf(s.getFechaHoraFin()));
            } else {
                ps.setNull(2, Types.TIMESTAMP);
            }

            ps.setInt(3, s.getTratamiento().getCodTratam());
            ps.setInt(4, s.getConsultorio().getNroConsultorio());
            ps.setInt(5, s.getMasajista().getMatricula());

            if (s.getDiaDeSpa() != null) {
                ps.setInt(6, s.getDiaDeSpa().getCodPack());
            } else {
                ps.setNull(6, Types.INTEGER);
            }

            ps.setBoolean(7, s.isEstado());

            if (s.getInstalacion() != null) {
                ps.setInt(8, s.getInstalacion().getCodInstal());
            } else {
                ps.setNull(8, Types.INTEGER);
            }

            ps.setInt(9, s.getCodSesion());

            int actualizado = ps.executeUpdate();
            if (actualizado == 1) {
                JOptionPane.showMessageDialog(null, "Sesión actualizada correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la sesión para actualizar");
            }

            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla sesion");
        }
    }

    public Sesion buscarSesion(int codSesion) {
        Sesion s = null;
        String sql = "SELECT * FROM sesion WHERE codSesion = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codSesion);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                s = new Sesion();

                Timestamp ini = rs.getTimestamp("fecha_hora_inicio");
                if (ini != null) {
                    s.setFechaHoraInicio(ini.toLocalDateTime());
                }

                Timestamp fin = rs.getTimestamp("fecha_hora_fin");
                if (fin != null) {
                    s.setFechaHoraFin(fin.toLocalDateTime());
                }

                s.setEstado(rs.getBoolean("estado"));
                s.setCodSesion(rs.getInt("codSesion"));

                int codPack = rs.getInt("codPack");
                String strPack = rs.getString("codPack");
                if (strPack != null) {
                    DiaDeSpa d = new DiaDeSpa();
                    d.setCodPack(codPack);
                    s.setDiaDeSpa(d);
                }

                int codTrat = rs.getInt("codTratamiento");
                String strTrat = rs.getString("codTratamiento");
                if (strTrat != null) {
                    Tratamiento t = new Tratamiento();
                    t.setCodTratam(codTrat);
                    s.setTratamiento(t);
                }

                int nroCons = rs.getInt("nroConsultorio");
                String strCons = rs.getString("nroConsultorio");
                if (strCons != null) {
                    Consultorio c = new Consultorio();
                    c.setNroConsultorio(nroCons);
                    s.setConsultorio(c);
                }

                int matricula = rs.getInt("matricula");
                String strMat = rs.getString("matricula");
                if (strMat != null) {
                    Masajista m = new Masajista();
                    m.setMatricula(matricula);
                    s.setMasajista(m);
                }

                int codInstal = rs.getInt("codInstal");
                String strInst = rs.getString("codInstal");
                if (strInst != null) {
                    Instalacion i = new Instalacion();
                    i.setCodInstal(codInstal);
                    s.setInstalacion(i);
                }
            }

            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar sesión");
        }

        return s;
    }

    public void bajaLogica(int codSesion) {
        String query = "UPDATE sesion SET estado=0 WHERE codSesion=?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codSesion);
            int actualizado = ps.executeUpdate();

            if (actualizado == 1) {
                JOptionPane.showMessageDialog(null, "Sesión dada de baja");
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar estado");
            }

            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla sesion");
        }
    }

    public void altaLogica(int codSesion) {
        String query = "UPDATE sesion SET estado=1 WHERE codSesion=?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codSesion);
            int actualizado = ps.executeUpdate();

            if (actualizado == 1) {
                JOptionPane.showMessageDialog(null, "Sesión dada de alta");
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar estado");
            }

            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla sesion");
        }
    }

    public void eliminarSesion(int codSesion) {
        String query = "DELETE FROM sesion WHERE codSesion=?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codSesion);
            int eliminado = ps.executeUpdate();

            if (eliminado == 1) {
                JOptionPane.showMessageDialog(null, "Sesión eliminada");
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar sesión");
            }

            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla sesion");
        }
    }

    public List<Sesion> listarSesiones() {
        List<Sesion> sesiones = new ArrayList<>();
        String query = "SELECT * FROM sesion WHERE estado=1";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Sesion s = new Sesion();
                s.setCodSesion(rs.getInt("codSesion"));
                Timestamp inicio = rs.getTimestamp("fecha_hora_inicio");
                if (inicio != null) {
                    s.setFechaHoraInicio(inicio.toLocalDateTime());
                }
                Timestamp fin = rs.getTimestamp("fecha_hora_fin");
                if (fin != null) {
                    s.setFechaHoraFin(fin.toLocalDateTime());
                }
                s.setEstado(rs.getBoolean("estado"));
                sesiones.add(s);
            }

            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla sesion");
        }
        return sesiones;
    }
}
