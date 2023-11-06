package bomberito.accesoADatos;

import bomberito.entidades.Brigada;
import bomberito.entidades.Siniestro;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;

public class SiniestroData {

    private Connection con = null;

    public SiniestroData() {
        con = Conexion.getConexion();
    }

    public List<Siniestro> HistorialSin() {
        List<Siniestro> historial = new ArrayList<>();
        String sql = "SELECT * FROM siniestro";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Siniestro sin = new Siniestro();
                BrigadaData bri = new BrigadaData();
                sin.setIdSiniestro(rs.getInt("idSiniestro"));
                sin.setTipo(rs.getString("tipo"));
                java.sql.Date fechaSiniestroSQL = rs.getDate("fechaSiniestro");
                if (fechaSiniestroSQL != null) {
                    sin.setFechaSiniestro(fechaSiniestroSQL.toLocalDate());
                }
                sin.setCoordX(rs.getInt("coordX"));
                sin.setCoordY(rs.getInt("coordY"));
                sin.setDetalles(rs.getString("detalles"));
                java.sql.Date fechaResolucionSQL = rs.getDate("fechaResolucion");
                if (fechaResolucionSQL != null) {
                    sin.setFechaResolucion(fechaResolucionSQL.toLocalDate());
                }
                int puntuacion = rs.getInt("puntuacion");
                if (!rs.wasNull()) {
                    sin.setPuntuacion(puntuacion);
                }
                int idBrigada = rs.getInt("codBrigada");
                if (!rs.wasNull()) {
                    Brigada brigada = new Brigada();
                    brigada = bri.traerBrigadaID(idBrigada);
                    sin.setCodBrigada(brigada);
                }
                
                sin.setActivo(rs.getBoolean("activo"));
                Time horaSinDB = rs.getTime("horaSin");
                LocalTime horaSin = horaSinDB != null ? horaSinDB.toLocalTime() : LocalTime.MIN;
                sin.setHoraSin(horaSin);
                historial.add(sin);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Siniestro");
            System.out.println(ex);
        }
        return historial;
    }

    public void NuevoSiniestro(Siniestro sin) {
        String sql = "INSERT INTO siniestro(tipo, fechaSiniestro, coordX, coordY, detalles,activo,horaSin)"
                + "VALUE(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, sin.getTipo());
            ps.setDate(2, Date.valueOf(sin.getFechaSiniestro()));
            ps.setInt(3, sin.getCoordX());
            ps.setInt(4, sin.getCoordY());
            ps.setString(5, sin.getDetalles());
            ps.setBoolean(6, sin.isActivo());
            ps.setTime(7, Time.valueOf(sin.getHoraSin()));
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                sin.setIdSiniestro(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Siniestro guardado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Siniestro");

        }
    }

    public List<Siniestro> traerSiniestrosParaAsignar() {
        List<Siniestro> siniestres = new ArrayList<>();
        String sql = "SELECT * FROM siniestro WHERE codBrigada IS NULL";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Siniestro sin = new Siniestro();
                sin.setIdSiniestro(rs.getInt("IdSiniestro"));
                sin.setTipo(rs.getString("tipo"));
                sin.setFechaSiniestro(rs.getDate("fechaSiniestro").toLocalDate());
                sin.setCoordX(rs.getInt("coordX"));
                sin.setCoordY(rs.getInt("coordY"));
                sin.setDetalles(rs.getString("detalles"));

                siniestres.add(sin);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Siniestro");
        }
        return siniestres;
    }

    public void AsignarBrigada(Siniestro sin) {
        String sql = "UPDATE siniestro SET codBrigada = ? WHERE idSiniestro = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, sin.getCodBrigada().getIdBrigada());
            ps.setInt(2, sin.getIdSiniestro());

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Brigada asiganada al Siniestro");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el siniestro para actualizar");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el siniestro: " + ex.getMessage());
        }
    }

    public void actualizarBrigada(int idBrigada, boolean libre) {
        String sql = "UPDATE brigada SET libre = ? WHERE idBrigada = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, libre);
            ps.setInt(2, idBrigada);

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                // JOptionPane.showMessageDialog(null, "Brigada dado de baja");
            } else {
                JOptionPane.showMessageDialog(null, "error");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el estado de la brigada");
        }
    }

    public List<Siniestro> traerSiniestrosParaDarBaja() {
        List<Siniestro> siniestros = new ArrayList<>();
        try {
            String sql = "SELECT s.*, b.nombreBrigada FROM siniestro s "
                    + "LEFT JOIN brigada b ON s.codBrigada = b.idBrigada "
                    + "WHERE s.codBrigada IS NOT NULL";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Siniestro sin = new Siniestro();

                sin.setIdSiniestro(rs.getInt("IdSiniestro"));
                sin.setTipo(rs.getString("tipo"));
                sin.setFechaSiniestro(rs.getDate("fechaSiniestro").toLocalDate());
                sin.setCoordX(rs.getInt("coordX"));
                sin.setCoordY(rs.getInt("coordY"));
                sin.setDetalles(rs.getString("detalles"));

                Brigada bri = new Brigada();
                bri.setIdBrigada(rs.getInt("codBrigada"));
                bri.setNombreBrigada(rs.getString("nombreBrigada"));
                sin.setCodBrigada(bri);

                siniestros.add(sin);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Siniestro");
        }
        return siniestros;
    }

    public void actSiniestrosRes(LocalDate FechaResolucion, int puntuacion, boolean activo, int idSiniestro) {
        try {
            String sql = "UPDATE siniestro SET fechaResolucion = ?, puntuacion = ?, activo = ? WHERE idSiniestro = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(FechaResolucion));
            ps.setInt(2, puntuacion);
            ps.setBoolean(3, activo);
            ps.setInt(4, idSiniestro);
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Siniestro Resuelto");
            } else {
                JOptionPane.showMessageDialog(null, "error123");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Siniestro");
        }
    }

    public Siniestro traerSiniestroID(int id) {
        Siniestro bri = null;
        try {
            String sql = "SELECT * FROM siniestro WHERE idSiniestro= " + id;
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                bri = new Siniestro();
                BrigadaData cuar = new BrigadaData();
                bri.setIdSiniestro(rs.getInt("idSiniestro"));
                bri.setTipo(rs.getString("tipo"));
                bri.setFechaSiniestro(rs.getDate("fechaSiniestro").toLocalDate());
                bri.setCoordX(rs.getInt("coordX"));
                bri.setCoordY(rs.getInt("coordY"));
                bri.setDetalles(rs.getString("detalles"));
                bri.setFechaResolucion(rs.getDate("fechaResolucion").toLocalDate());
                bri.setPuntuacion(rs.getInt("puntuacion"));
                bri.setCodBrigada(cuar.traerBrigadaID(rs.getInt("codBrigada")));
                bri.setActivo(rs.getBoolean("activo"));
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla siniestro " + ex.getMessage());
        }
        return bri;
    }

    public String devolverDetalle(int id) {
        String detalles = "";
        try {
            String sql = "SELECT detalles FROM siniestro"
                    + " WHERE codBrigada = " + id;
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                detalles = rs.getString("detalles");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Siniestro " + ex.getMessage());
        }
        return detalles;
    }

    public List<Siniestro> traerResDeSiniestro() {
        List<Siniestro> siniestros = new ArrayList<>();
        try {
            String sql = "SELECT s.*, b.nombreBrigada FROM siniestro s "
                    + "LEFT JOIN brigada b ON s.codBrigada = b.idBrigada "
                    + "WHERE s.puntuacion IS NULL AND s.codBrigada IS NOT NULL AND activo = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Siniestro sin = new Siniestro();
                
                sin.setIdSiniestro(rs.getInt("IdSiniestro"));
                sin.setTipo(rs.getString("tipo"));
                sin.setFechaSiniestro(rs.getDate("fechaSiniestro").toLocalDate());
                sin.setCoordX(rs.getInt("coordX"));
                sin.setCoordY(rs.getInt("coordY"));
                sin.setDetalles(rs.getString("detalles"));
                
                Brigada bri = new Brigada();
                bri.setIdBrigada(rs.getInt("codBrigada"));
                bri.setNombreBrigada(rs.getString("nombreBrigada"));
                sin.setCodBrigada(bri);
                
                siniestros.add(sin);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Siniestro");
        }
        return siniestros;
    }

}
