package rj.handschool.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rj.handschool.model.Instrutor;

@Repository
public class InstrutorDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		Session sess = getSessionFactory().getCurrentSession();
		if (sess == null) {
			sess = getSessionFactory().openSession();
		}
		return sess;
	}

	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	
	public void insert(Instrutor instrutor) throws Exception{
		
		try {
		   getSession().save(instrutor);
		} catch (Exception e) {
    		throw new Exception("Erro ao Inserir Instrutor: "+e.getMessage());
		}
	}
	
	public void update(Instrutor instrutor) throws Exception {
		try {
			   getSession().merge(instrutor);
			} catch (Exception e) {
	    		throw new Exception("Erro ao Atualizar Instrutor: "+e.getMessage());
			}
		
	}
	
	public Instrutor findById(int id){
		return (Instrutor) getSession().get(Instrutor.class, id);	
	}
	
	@SuppressWarnings("unchecked")
	public List<Instrutor> findAll(){
		return getSession().createCriteria(Instrutor.class).list();
	}
	
	
}
