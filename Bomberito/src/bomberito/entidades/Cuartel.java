
package bomberito.entidades;


public class Cuartel {
    private int idCuartel;
    private String nombreCuartel;
    private String direccion;
    private int coordX;
    private int coordY;
    private String telefono;
    private String correo;

    public Cuartel(String nombreCuartel) {
        this.nombreCuartel = nombreCuartel;
    }

    public Cuartel(int idCuartel, String nombreCuartel) {
        this.idCuartel = idCuartel;
        this.nombreCuartel = nombreCuartel;
    }

    
    
    public Cuartel() {
    }

    public Cuartel(String nombreCuartel, String direccion, int coordX, int coordY, String telefono, String correo) {
        this.nombreCuartel = nombreCuartel;
        this.direccion = direccion;
        this.coordX = coordX;
        this.coordY = coordY;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Cuartel(int idCuartel, String nombreCuartel, String direccion, int coordX, int coordY, String telefono, String correo) {
        this.idCuartel = idCuartel;
        this.nombreCuartel = nombreCuartel;
        this.direccion = direccion;
        this.coordX = coordX;
        this.coordY = coordY;
        this.telefono = telefono;
        this.correo = correo;
    }


    public int getIdCuartel() {
        return idCuartel;
    }

    public void setIdCuartel(int idCuartel) {
        this.idCuartel = idCuartel;
    }

    public String getNombreCuartel() {
        return nombreCuartel;
    }

    public void setNombreCuartel(String nombreCuartel) {
        this.nombreCuartel = nombreCuartel;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCoordX() {
        return coordX;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return nombreCuartel;
    }
    
    
}
