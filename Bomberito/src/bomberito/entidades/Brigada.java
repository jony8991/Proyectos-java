
package bomberito.entidades;


public class Brigada {
    private int idBrigada;
    private String nombreBrigada;
    private String especialidad;
    private boolean libre;
    private Cuartel nroCuartel;

    public Brigada() {
    }

    public Brigada(int idBrigada, String nombreBrigada) {
        this.idBrigada = idBrigada;
        this.nombreBrigada = nombreBrigada;
    }

    
    public Brigada(String nombreBrigada, String especialidad, boolean libre, Cuartel nroCuartel) {
        this.nombreBrigada = nombreBrigada;
        this.especialidad = especialidad;
        this.libre = libre;
        this.nroCuartel = nroCuartel;
    }

    public Brigada(String nombreBrigada) {
        this.nombreBrigada = nombreBrigada;
    }

    public Brigada(int idBrigada, String nombreBrigada, String especialidad) {
        this.idBrigada = idBrigada;
        this.nombreBrigada = nombreBrigada;
        this.especialidad = especialidad;
    }

   

    public int getIdBrigada() {
        return idBrigada;
    }

    public void setIdBrigada(int idBrigada) {
        this.idBrigada = idBrigada;
    }

    public String getNombreBrigada() {
        return nombreBrigada;
    }

    public void setNombreBrigada(String nombreBrigada) {
        this.nombreBrigada = nombreBrigada;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public boolean isLibre() {
        return libre;
    }

    public void setLibre(boolean libre) {
        this.libre = libre;
    }

    public Cuartel getNroCuartel() {
        return nroCuartel;
    }

    public void setNroCuartel(Cuartel nroCuartel) {
        this.nroCuartel = nroCuartel;
    }

    @Override
    public String toString() {
        return nombreBrigada;
    }
}
