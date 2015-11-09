package rj.handschool.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rj.handschool.model.Aula;

@Repository
public class AulaDAO {
	
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
	
	
	public void insert(Aula aula) throws Exception{
		
		try {
		   getSession().save(aula);
		} catch (Exception e) {
    		throw new Exception("Erro ao Inserir Aula: "+e.getMessage());
		}
	}
	
	public void update(Aula aula) throws Exception {
		try {
			   getSession().merge(aula);
			} catch (Exception e) {
	    		throw new Exception("Erro ao Atualizar Aula: "+e.getMessage());
			}
		
	}
	
	public Aula findById(int id){
		return (Aula) getSession().get(Aula.class, id);	
	}
	
	@SuppressWarnings("unchecked")
	public List<Aula> findAll(){
		return getSession().createCriteria(Aula.class).list();
	}
	
	
}
