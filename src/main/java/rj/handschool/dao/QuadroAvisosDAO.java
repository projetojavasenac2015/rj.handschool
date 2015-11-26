package rj.handschool.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rj.handschool.model.QuadroAvisos;

@Repository
@Transactional
public class QuadroAvisosDAO {
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
	
	public void insert(QuadroAvisos quadroAvisos) throws Exception{
		try {
			quadroAvisos.setDataHoraCadastro(new java.sql.Date(System.currentTimeMillis()));
			getSession().save(quadroAvisos);
		} catch (Exception e) {
			System.out.println("Erro ao Inserir Modulo: " + e.getMessage());
    		throw new Exception("Erro ao Inserir Modulo: " + e.getMessage());
		}
	}
	
	public void update(QuadroAvisos quadroAvisos) throws Exception {
		try {			 
			 getSession().merge(quadroAvisos);
			} catch (Exception e) {
	    		throw new Exception("Erro ao Atualizar Modulo: " + e.getMessage());
			}
	}
	
	public QuadroAvisos findById(QuadroAvisos quadroAvisos){
		return (QuadroAvisos) getSession().get(QuadroAvisos.class, quadroAvisos);	
	}
	
	@SuppressWarnings("unchecked")
	public List<QuadroAvisos> findAll(){
		return getSession().createCriteria(QuadroAvisos.class).list();
	}
	
	

}
