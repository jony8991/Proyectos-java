
package bomberito.entidades;

import java.time.LocalDate;
import java.time.LocalTime;


public class Siniestro {

    private int idSiniestro;
    private String tipo;
    private LocalDate fechaSiniestro;
    private int coordX;
    private int coordY;
    private String detalles;
    private LocalDate fechaResolucion;
    private int puntuacion;
    private Brigada codBrigada;
    private boolean activo;
    private LocalTime horaSin;
    
    public Siniestro() {
    }

    public Siniestro(String tipo, LocalDate fechaSiniestro, int coordX, int coordY, String detalles, LocalDate fechaResolucion, int puntuacion, Brigada codBrigada, boolean activo,LocalTime horaSin) {
        this.tipo = tipo;
        this.fechaSiniestro = fechaSiniestro;
        this.coordX = coordX;
        this.coordY = coordY;
        this.detalles = detalles;
        this.fechaResolucion = fechaResolucion;
        this.puntuacion = puntuacion;
        this.codBrigada = codBrigada;
        this.activo = activo;
        this.horaSin = horaSin;
    }

    public Siniestro(String tipo, LocalDate fechaSiniestro, int coordX, int coordY, String detalles,boolean activo,LocalTime horaSin) {
        this.tipo = tipo;
        this.fechaSiniestro = fechaSiniestro;
        this.coordX = coordX;
        this.coordY = coordY;
        this.detalles = detalles;
        this.activo=activo;
        this.horaSin=horaSin;
    }

    public Siniestro(Brigada codBrigada, int idSiniestro) {
        this.codBrigada = codBrigada;
        this.idSiniestro = idSiniestro;
    }

    
    public int getIdSiniestro() {
        return idSiniestro;
    }

    public void setIdSiniestro(int idSiniestro) {
        this.idSiniestro = idSiniestro;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFechaSiniestro() {
        return fechaSiniestro;
    }

    public void setFechaSiniestro(LocalDate fechaSiniestro) {
        this.fechaSiniestro = fechaSiniestro;
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

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public LocalDate getFechaResolucion() {
        return fechaResolucion;
    }

    public void setFechaResolucion(LocalDate fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Brigada getCodBrigada() {
        return codBrigada;
    }

    public void setCodBrigada(Brigada codBrigada) {
        this.codBrigada = codBrigada;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public LocalTime getHoraSin() {
        return horaSin;
    }

    public void setHoraSin(LocalTime horaSin) {
        this.horaSin = horaSin;
    }
    
    
    
}
