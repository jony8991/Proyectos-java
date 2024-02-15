package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Cliente")
    private int idCliente;

    @Column(name = "nombre", length = 30)
    private String nombre;

    @Column(name = "apellido", length = 30)
    private String apellido;

    @Column(name = "direccion", length = 50)
    private String direccion;

    @Column(name = "CUIT")
    private int cuit;

    @Column(name = "estado")
    private boolean estado;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String direccion, int cuit, boolean estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.cuit = cuit;
        this.estado = estado;
    }

    public Cliente(int idCliente, String nombre, String apellido, String direccion, int cuit, boolean estado) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.cuit = cuit;
        this.estado = estado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCuit() {
        return cuit;
    }

    public void setCuit(int cuit) {
        this.cuit = cuit;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "ID: " + idCliente + " Nombre: " + nombre + " Apellido: " + apellido + " CUIT: " + cuit 
                + " Direccion: " + direccion + " Estado: " + estado;
    }

    
}

	