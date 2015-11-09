package rj.handschool.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rj.handschool.model.DisciplinaCursoPK;

@Repository
public class DisciplinaCursoPKDAO {
	
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
	
	
	public void insert(DisciplinaCursoPK disciplinaCursoPK) throws Exception{
		
		try {
		   getSession().save(disciplinaCursoPK);
		} catch (Exception e) {
    		throw new Exception("Erro ao Inserir DisciplinaCursoPK: "+e.getMessage());
		}
	}
	
	public void update(DisciplinaCursoPK disciplinaCursoPK) throws Exception {
		try {
			   getSession().merge(disciplinaCursoPK);
			} catch (Exception e) {
	    		throw new Exception("Erro ao Atualizar DisciplinaCursoPK: "+e.getMessage());
			}
		
	}
	
	public DisciplinaCursoPK findById(int id){
		return (DisciplinaCursoPK) getSession().get(DisciplinaCursoPK.class, id);	
	}
	
	@SuppressWarnings("unchecked")
	public List<DisciplinaCursoPK> findAll(){
		return getSession().createCriteria(DisciplinaCursoPK.class).list();
	}
	
	
}
