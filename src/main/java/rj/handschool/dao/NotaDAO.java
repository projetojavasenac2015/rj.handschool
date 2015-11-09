package rj.handschool.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rj.handschool.model.Nota;

@Repository
public class NotaDAO {
	
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
	
	
	public void insert(Nota nota) throws Exception{
		
		try {
		   getSession().save(nota);
		} catch (Exception e) {
    		throw new Exception("Erro ao Inserir Nota: "+e.getMessage());
		}
	}
	
	public void update(Nota nota) throws Exception {
		try {
			   getSession().merge(nota);
			} catch (Exception e) {
	    		throw new Exception("Erro ao Atualizar Nota: "+e.getMessage());
			}
		
	}
	
	public Nota findById(int id){
		return (Nota) getSession().get(Nota.class, id);	
	}
	
	@SuppressWarnings("unchecked")
	public List<Nota> findAll(){
		return getSession().createCriteria(Nota.class).list();
	}
	
	
}
