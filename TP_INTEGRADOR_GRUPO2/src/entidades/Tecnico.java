package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Tecnico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Tecnico")
    private int idTecnico;

    @Column(name = "nombre", length = 30)
    private String nombre;

    @Column(name = "apellido", length = 30)
    private String apellido;

    @Column(name = "documento", length = 30)
    private String documento;

    @ManyToOne
    @JoinColumn(name = "idEspecialidad")
    private Especialidad especialidad;

    @Column(name = "estado")
    private boolean estado;

    public Tecnico() {
    }

    public Tecnico(String nombre, String apellido, String documento, Especialidad especialidad, boolean estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.especialidad = especialidad;
        this.estado = estado;
    }

    public Tecnico(int idTecnico, String nombre, String apellido, String documento, Especialidad especialidad, boolean estado) {
        this.idTecnico = idTecnico;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.especialidad = especialidad;
        this.estado = estado;
    }

    public int getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(int idTecnico) {
        this.idTecnico = idTecnico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "ID: " + idTecnico + " Nombre: " + nombre + " Apellido: " + apellido + " Documento: " + documento +
                " Especialidad: " + especialidad + " Estado: " + estado;
    }

    
}