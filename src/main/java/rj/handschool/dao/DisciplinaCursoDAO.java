package rj.handschool.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rj.handschool.model.DisciplinaCurso;

@Repository
public class DisciplinaCursoDAO {
	
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
	
	
	public void insert(DisciplinaCurso disciplinaCurso) throws Exception{
		
		try {
		   getSession().save(disciplinaCurso);
		} catch (Exception e) {
    		throw new Exception("Erro ao Inserir DisciplinaCurso: "+e.getMessage());
		}
	}
	
	public void update(DisciplinaCurso disciplinaCurso) throws Exception {
		try {
			   getSession().merge(disciplinaCurso);
			} catch (Exception e) {
	    		throw new Exception("Erro ao Atualizar DisciplinaCurso: "+e.getMessage());
			}
		
	}
	
	public DisciplinaCurso findById(int id){
		return (DisciplinaCurso) getSession().get(DisciplinaCurso.class, id);	
	}
	
	@SuppressWarnings("unchecked")
	public List<DisciplinaCurso> findAll(){
		return getSession().createCriteria(DisciplinaCurso.class).list();
	}
	
	
}
