package dao;

import org.hibernate.Session;

import entidades.Cliente;
import dao.ConfigHibernate;




public class ClienteDAO {

	public void Add(Cliente cliente)
	{
		ConfigHibernate ch = new ConfigHibernate();
		Session session= ch.abrirConexion();
		     
	    session.beginTransaction();
	    session.save(cliente);
	    
	    session.getTransaction().commit();    
		ch.cerrarSession();
	}
	
	public Cliente ReadOne(int id)
	{
		ConfigHibernate config = new ConfigHibernate();
		Session session= config.abrirConexion();
		
		session.beginTransaction();
		Cliente cliente=(Cliente)session.get(Cliente.class,id);
        
        config.cerrarSession();
        
        return cliente;
	}
	
	public void Update(Cliente cliente)
	{
		ConfigHibernate config = new ConfigHibernate();
		Session session= config.abrirConexion();
		
        session.beginTransaction();
        session.update(cliente);
        session.getTransaction().commit();        
        
        config.cerrarSession();
	}
	
	public void Delete(Cliente cliente)
	{
		ConfigHibernate config = new ConfigHibernate();
		Session session= config.abrirConexion();
		
        session.beginTransaction();
        session.delete(cliente);
        session.getTransaction().commit();        
        
        config.cerrarSession();
	}
}
