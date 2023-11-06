
package bomberito.accesoADatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import bomberito.entidades.Bombero;
import java.util.ArrayList;
import java.util.List;


public class BomberoData {
        //instanciamos la conecccion
    private Connection con=null;
    
    //conexcion
    public BomberoData(){
        con=Conexion.getConexion();
    }
    
    public void nuevoBombero(Bombero bomberito){
        String verificarDNI = "SELECT dni FROM bombero WHERE dni = ?";
        try {
            PreparedStatement psDNI = con.prepareStatement(verificarDNI);
            psDNI.setInt(1, bomberito.getDni());
            ResultSet dniResultado = psDNI.executeQuery();
            if (dniResultado.next()) {
                JOptionPane.showMessageDialog(null, "El DNI ya existe en la base de datos. No se puede agregar.");
            } else {
                String sql = "INSERT INTO bombero(dni,apellido,nombre,fechaNacimiento,grupoSanguineo, celular, codBrigada, activo)"
                        + "VALUE (?,?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, bomberito.getDni());
                ps.setString(2, bomberito.getApellido());
                ps.setString(3, bomberito.getNombre());
                ps.setDate(4, Date.valueOf(bomberito.getFechaNacimiento()));
                ps.setString(5, bomberito.getGrupoSanguineo());
                ps.setString(6, bomberito.getCelular());
                ps.setInt(7, bomberito.getCodBrigada().getIdBrigada());
                ps.setBoolean(8, true);
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    bomberito.setIdBombero(rs.getInt(1));
                    JOptionPane.showMessageDialog(null, "Bombero guardado");
                }
                ps.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla bombero");
        }
    }
    
    public List<Bombero> traerBomberos() {
        List<Bombero> bomberitos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM bombero WHERE activo = 1 ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Bombero bom = new Bombero();
                BrigadaData briDa = new BrigadaData();
                bom.setIdBombero(rs.getInt("idBombero"));
                bom.setDni(rs.getInt("dni"));
                bom.setApellido(rs.getString("apellido"));
                bom.setNombre(rs.getString("nombre"));
                bom.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                bom.setGrupoSanguineo(rs.getString("grupoSanguineo"));
                bom.setCelular(rs.getString("celular"));
                bom.setCodBrigada(briDa.traerBrigadaID(rs.getInt("codBrigada")));
                bom.setActivo(rs.getBoolean("activo"));
                bomberitos.add(bom);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla bombero " + ex.getMessage());
        }
        return bomberitos;
    }
    
        public List<Bombero> traerBomberosInactivos() {
        List<Bombero> bomberitos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM bombero WHERE activo = 0 ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Bombero bom = new Bombero();
                BrigadaData briDa = new BrigadaData();
                bom.setIdBombero(rs.getInt("idBombero"));
                bom.setDni(rs.getInt("dni"));
                bom.setApellido(rs.getString("apellido"));
                bom.setNombre(rs.getString("nombre"));
                bom.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                bom.setGrupoSanguineo(rs.getString("grupoSanguineo"));
                bom.setCelular(rs.getString("celular"));
                bom.setCodBrigada(briDa.traerBrigadaID(rs.getInt("codBrigada")));
                bom.setActivo(rs.getBoolean("activo"));
                bomberitos.add(bom);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla bombero " + ex.getMessage());
        }
        return bomberitos;
    }
    
    public void modificarBombero(Bombero bomberito){
        String sql = "UPDATE bombero SET dni=?, apellido=?, nombre=?, fechaNacimiento=?, grupoSanguineo=?, celular=?, codBrigada=?"
                + " WHERE idBombero=?";        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, bomberito.getDni());
            ps.setString(2, bomberito.getApellido());
            ps.setString(3, bomberito.getNombre());
            ps.setDate(4,Date.valueOf(bomberito.getFechaNacimiento()));
            ps.setString(5, bomberito.getGrupoSanguineo());
            ps.setString(6, bomberito.getCelular());
            ps.setInt(7, bomberito.getCodBrigada().getIdBrigada());
            ps.setInt(8, bomberito.getIdBombero());
            int exito=ps.executeUpdate();
            if (exito==1) {
                JOptionPane.showMessageDialog(null, "Bombero modificado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla bombero para modificar");
        }
    }
    
    public void bajaBombero(int id) {
        String sql = "UPDATE bombero SET activo=0, codBrigada=null WHERE idBombero=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Bombero dado de baja");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla bombero");
        }
    }

    public int bomberosEnUnaBrigada(int id) {
        int count = 0;
        try {
            String sql = "SELECT COUNT(*) FROM bombero WHERE codBrigada="+id;
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                count = result.getInt(1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error mortal!!");
        }

        return count;
    }
}
