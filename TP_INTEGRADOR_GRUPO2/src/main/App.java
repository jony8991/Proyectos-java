package main;
import dao.ClienteDAO;
import dao.EspecialidadDAO;
import dao.IncidenteDAO;
import dao.TecnicoDAO;
import entidades.Cliente;
import entidades.Especialidad;
import entidades.Incidente;
import entidades.Tecnico;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {

    public static void main(String[] args) {
    	SessionFactory sessionFactory;
    	Configuration configuration = new Configuration();
    	configuration.configure();	
    	ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
    	sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    	Session session = sessionFactory.openSession();
 
    	session.beginTransaction();

        // Crear DAO para cada entidad
        ClienteDAO clienteDAO = new ClienteDAO();
        TecnicoDAO tecnicoDAO = new TecnicoDAO();
        IncidenteDAO incidenteDAO = new IncidenteDAO();
        EspecialidadDAO especialidadDAO = new EspecialidadDAO();

        // Cargar datos de prueba


        // Especialidades
        Especialidad especialidad1 = new Especialidad("Version1", "OS1");
        Especialidad especialidad2 = new Especialidad("Version2", "OS2");
        Especialidad especialidad3 = new Especialidad("Version3", "OS3");
        Especialidad especialidad4 = new Especialidad("Version4", "OS4");
        Especialidad especialidad5 = new Especialidad("Version5", "OS5");
        
        especialidadDAO.Add(especialidad1);
        especialidadDAO.Add(especialidad2);
        especialidadDAO.Add(especialidad3);
        especialidadDAO.Add(especialidad4);
        especialidadDAO.Add(especialidad5);
        
        // Técnicos
        Tecnico tecnico1 = new Tecnico("NombreTecnico1", "ApellidoTecnico1", "Documento1", especialidad1, true);
        Tecnico tecnico2 = new Tecnico("NombreTecnico2", "ApellidoTecnico2", "Documento2", especialidad2, true);
        Tecnico tecnico3 = new Tecnico("NombreTecnico3", "ApellidoTecnico3", "Documento3", especialidad3, true);
        Tecnico tecnico4 = new Tecnico("NombreTecnico4", "ApellidoTecnico4", "Documento4", especialidad4, true);
        Tecnico tecnico5 = new Tecnico("NombreTecnico5", "ApellidoTecnico5", "Documento5", especialidad5, true);

        tecnicoDAO.Add(tecnico1);
        tecnicoDAO.Add(tecnico2);
        tecnicoDAO.Add(tecnico3);
        tecnicoDAO.Add(tecnico4);
        tecnicoDAO.Add(tecnico5);
        
        // Clientes
        Cliente cliente1 = new Cliente("Nombre1", "Apellido1", "Direccion1", 4923940, true);
        Cliente cliente2 = new Cliente("Nombre2", "Apellido2", "Direccion2", 1249129, true);
        Cliente cliente3 = new Cliente("Nombre3", "Apellido3", "Direccion3", 4924230, true);
        Cliente cliente4 = new Cliente("Nombre4", "Apellido4", "Direccion4", 4923023, true);
        Cliente cliente5 = new Cliente("Nombre5", "Apellido5", "Direccion5", 2192402, true);

        clienteDAO.Add(cliente1);
        clienteDAO.Add(cliente2);
        clienteDAO.Add(cliente3);
        clienteDAO.Add(cliente4);
        clienteDAO.Add(cliente5);
       
        // Incidentes
        java.util.Date fecha = new java.util.Date(2022,01,03);
        
        Incidente incidente1 = new Incidente();
        incidente1.setDetalles("Problema con la aplicación X");
        incidente1.setFechaCreacion(fecha);
        incidente1.setFechaResolucion(null);
        incidente1.setEstado(true);

        Incidente incidente2 = new Incidente();
        incidente2.setDetalles("Error en el sistema operativo Y");
        incidente2.setFechaCreacion(fecha);
        incidente2.setFechaResolucion(null);
        incidente2.setEstado(true);

        Incidente incidente3 = new Incidente();
        incidente3.setDetalles("Fallo en la aplicación Z");
        incidente3.setFechaCreacion(fecha);
        incidente3.setFechaResolucion(null);
        incidente3.setEstado(true);

        Incidente incidente4 = new Incidente();
        incidente4.setDetalles("Problema de conectividad en el servidor");
        incidente4.setFechaCreacion(fecha);
        incidente4.setFechaResolucion(null);
        incidente4.setEstado(true);

        Incidente incidente5 = new Incidente();
        incidente5.setDetalles("No se puede acceder a la base de datos");
        incidente5.setFechaCreacion(fecha);
        incidente5.setFechaResolucion(null);
        incidente5.setEstado(true);

        incidenteDAO.Add(incidente1);
        incidenteDAO.Add(incidente2);
        incidenteDAO.Add(incidente3);
        incidenteDAO.Add(incidente4);
        incidenteDAO.Add(incidente5);
        
    }
}

