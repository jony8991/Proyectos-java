package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Incidente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Incidente")
    private int idIncidente;

    @Column(name = "detalles", length = 100)
    private String detalles;

    @ManyToOne
    @JoinColumn(name = "idEspecialidad")
    private Especialidad especialidad;

    @Column(name = "fechaCreacion")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaCreacion;

    @Column(name = "fechaResolucion")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaResolucion;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "idTecnico")
    private Tecnico tecnico;

    @Column(name = "estado")
    private boolean estado;

    public Incidente() {
    }

    public Incidente(String detalles, Especialidad especialidad, Date fechaCreacion, Date fechaResolucion, Cliente cliente, Tecnico tecnico, boolean estado) {
        this.detalles = detalles;
        this.especialidad = especialidad;
        this.fechaCreacion = fechaCreacion;
        this.fechaResolucion = fechaResolucion;
        this.cliente = cliente;
        this.tecnico = tecnico;
        this.estado = estado;
    }

    public Incidente(int idIncidente, String detalles, Especialidad especialidad, Date fechaCreacion, Date fechaResolucion, Cliente cliente, Tecnico tecnico, boolean estado) {
        this.idIncidente = idIncidente;
        this.detalles = detalles;
        this.especialidad = especialidad;
        this.fechaCreacion = fechaCreacion;
        this.fechaResolucion = fechaResolucion;
        this.cliente = cliente;
        this.tecnico = tecnico;
        this.estado = estado;
    }

    public int getIdIncidente() {
        return idIncidente;
    }

    public void setIdIncidente(int idIncidente) {
        this.idIncidente = idIncidente;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaResolucion() {
        return fechaResolucion;
    }

    public void setFechaResolucion(Date fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "ID: " + idIncidente + " Detalles: " + detalles + " idEspecialidad" + especialidad + " Alta: " + fechaCreacion + " Baja: " +
                fechaResolucion + " idCliente: " + cliente + " idTecnico: " + tecnico + " Estado: " + estado;
    }

    
}
