package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Especialidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Especialidad")
    private int idEspecialidad;

    @Column(name = "version", length = 30)
    private String version;

    @Column(name = "OS", length = 30)
    private String OS;

    public Especialidad() {
    }

    public Especialidad(String version, String OS) {
        this.version = version;
        this.OS = OS;
    }

    public Especialidad(int idEspecialidad, String version, String OS) {
        this.idEspecialidad = idEspecialidad;
        this.version = version;
        this.OS = OS;
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    @Override
    public String toString() {
        return "ID: " + idEspecialidad + " OS: " + OS + " Version: " + version;
    }

    
}
