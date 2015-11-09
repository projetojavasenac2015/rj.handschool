package rj.handschool.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rj.handschool.model.Turma;

@Repository
public class TurmaDAO {
	
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
	
	
	public void insert(Turma turma) throws Exception{
		
		try {
		   getSession().save(turma);
		} catch (Exception e) {
    		throw new Exception("Erro ao Inserir Turma: "+e.getMessage());
		}
	}
	
	public void update(Turma turma) throws Exception {
		try {
			   getSession().merge(turma);
			} catch (Exception e) {
	    		throw new Exception("Erro ao Atualizar Turma: "+e.getMessage());
			}
		
	}
	
	public Turma findById(int id){
		return (Turma) getSession().get(Turma.class, id);	
	}
	
	@SuppressWarnings("unchecked")
	public List<Turma> findAll(){
		return getSession().createCriteria(Turma.class).list();
	}
	
	
}
