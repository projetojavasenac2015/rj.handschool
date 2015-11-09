package rj.handschool.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rj.handschool.model.Perfil;

@Repository
public class PerfilDAO {
	
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
	
	
	public void insert(Perfil perfil) throws Exception{
		
		try {
		   getSession().save(perfil);
		} catch (Exception e) {
    		throw new Exception("Erro ao Inserir Perfil: "+e.getMessage());
		}
	}
	
	public void update(Perfil perfil) throws Exception {
		try {
			   getSession().merge(perfil);
			} catch (Exception e) {
	    		throw new Exception("Erro ao Atualizar Perfil: "+e.getMessage());
			}
		
	}
	
	public Perfil findById(int id){
		return (Perfil) getSession().get(Perfil.class, id);	
	}
	
	@SuppressWarnings("unchecked")
	public List<Perfil> findAll(){
		return getSession().createCriteria(Perfil.class).list();
	}
	
	
}
