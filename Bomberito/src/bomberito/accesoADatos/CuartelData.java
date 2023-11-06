
package bomberito.accesoADatos;

import bomberito.entidades.Cuartel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class CuartelData {

    private Connection con = null;

    public CuartelData() {
        con = Conexion.getConexion();
    }

    public void nuevoCuartel(Cuartel cuartelito) {
        String sql = "INSERT INTO cuartel(nombreCuartel,direccion, coordX, coordY,telefono, correo)"
                + "VALUE (?,?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cuartelito.getNombreCuartel());
            ps.setString(2, cuartelito.getDireccion());
            ps.setInt(3, cuartelito.getCoordX());
            ps.setInt(4, cuartelito.getCoordY());
            ps.setString(5, cuartelito.getTelefono());
            ps.setString(6, cuartelito.getCorreo());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                cuartelito.setIdCuartel(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Cuartel guardado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cuartel");
        }
    }
    
    public Cuartel traerCuartelID(int id){
            Cuartel cuart = new Cuartel();
        try {
            String sql = "SELECT * FROM cuartel WHERE idCuartel= "+id;
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cuart.setIdCuartel(rs.getInt("idCuartel"));
                cuart.setNombreCuartel(rs.getString("nombreCuartel"));
                cuart.setDireccion(rs.getString("direccion"));
                cuart.setCoordX(rs.getInt("coordX"));
                cuart.setCoordY(rs.getInt("coordY"));
                cuart.setTelefono(rs.getString("telefono"));
                cuart.setCorreo(rs.getString("correo"));
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla cuartel " + ex.getMessage());
        }
        return cuart;
        }
    
    public List<Cuartel> traerCuarteles() {
        List<Cuartel> cuartelitos = new ArrayList<>();
        try {
            String sql = "Select * FROM cuartel";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Cuartel cu = new Cuartel();
                
                cu.setIdCuartel(rs.getInt("idCuartel"));
                cu.setNombreCuartel(rs.getString("nombreCuartel"));
                cu.setDireccion(rs.getString("direccion"));
                cu.setCoordX(rs.getInt("coordX"));
                cu.setCoordY(rs.getInt("coordY"));
                cu.setTelefono(rs.getString("telefono"));
                cu.setCorreo(rs.getString("correo"));
                cuartelitos.add(cu);
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla cuartel " + ex.getMessage());
        }
        return cuartelitos;
    }
    
        public void modificarCuartel(Cuartel cuartelito){
        String sql = "UPDATE cuartel SET nombreCuartel=?, direccion=?, coordX=?, coordY=?, telefono=?, correo=?"
                + " WHERE idCuartel=?";        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, cuartelito.getNombreCuartel());
            ps.setString(2, cuartelito.getDireccion());
            ps.setInt(3, cuartelito.getCoordX());
            ps.setInt(4,cuartelito.getCoordY());
            ps.setString(5, cuartelito.getTelefono());
            ps.setString(6, cuartelito.getCorreo());
            ps.setInt(7, cuartelito.getIdCuartel());
            int exito=ps.executeUpdate();
            if (exito==1) {
                JOptionPane.showMessageDialog(null, "Cuartel modificado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cuartel para modificar");
        }
    }      
}
