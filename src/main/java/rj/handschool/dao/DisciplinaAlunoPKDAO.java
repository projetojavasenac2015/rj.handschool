package rj.handschool.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rj.handschool.model.DisciplinaAlunoPK;

@Repository
public class DisciplinaAlunoPKDAO {
	
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
	
	
	public void insert(DisciplinaAlunoPK disciplinaAlunoPK) throws Exception{
		
		try {
		   getSession().save(disciplinaAlunoPK);
		} catch (Exception e) {
    		throw new Exception("Erro ao Inserir DisciplinaAlunoPK: "+e.getMessage());
		}
	}
	
	public void update(DisciplinaAlunoPK disciplinaAlunoPK) throws Exception {
		try {
			   getSession().merge(disciplinaAlunoPK);
			} catch (Exception e) {
	    		throw new Exception("Erro ao Atualizar DisciplinaAlunoPK: "+e.getMessage());
			}
		
	}
	
	public DisciplinaAlunoPK findById(int id){
		return (DisciplinaAlunoPK) getSession().get(DisciplinaAlunoPK.class, id);	
	}
	
	@SuppressWarnings("unchecked")
	public List<DisciplinaAlunoPK> findAll(){
		return getSession().createCriteria(DisciplinaAlunoPK.class).list();
	}
	
	
}
