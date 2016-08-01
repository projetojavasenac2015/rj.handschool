package rj.handschool.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rj.handschool.model.Perfil;
import rj.handschool.model.Professor;

@Repository
@Transactional
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
	
	@SuppressWarnings("unchecked")
	public List<Perfil> findAll(){
		return getSession().createCriteria(Perfil.class).list();
	}
	
	public Perfil findById(Perfil perfil){
		return (Perfil) getSession().get(Perfil.class, perfil);	
	}
	
	public Perfil findById(long id){
		Query q = getSession().getNamedQuery("Perfil.findById");
		q.setParameter("id",id);
		return (Perfil)q.uniqueResult();	
	}
}
