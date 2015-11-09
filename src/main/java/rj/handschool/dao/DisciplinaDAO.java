package rj.handschool.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rj.handschool.model.Disciplina;

@Repository
public class DisciplinaDAO {
	
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
	
	
	public void insert(Disciplina disciplina) throws Exception{
		
		try {
		   getSession().save(disciplina);
		} catch (Exception e) {
    		throw new Exception("Erro ao Inserir Disciplina: "+e.getMessage());
		}
	}
	
	public void update(Disciplina disciplina) throws Exception {
		try {
			   getSession().merge(disciplina);
			} catch (Exception e) {
	    		throw new Exception("Erro ao Atualizar Disciplina: "+e.getMessage());
			}
		
	}
	
	public Disciplina findById(int id){
		return (Disciplina) getSession().get(Disciplina.class, id);	
	}
	
	@SuppressWarnings("unchecked")
	public List<Disciplina> findAll(){
		return getSession().createCriteria(Disciplina.class).list();
	}
	
	
}
