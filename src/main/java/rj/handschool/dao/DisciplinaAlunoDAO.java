package rj.handschool.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rj.handschool.model.DisciplinaAluno;

@Repository
public class DisciplinaAlunoDAO {
	
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
	
	
	public void insert(DisciplinaAluno disciplinaAluno) throws Exception{
		
		try {
		   getSession().save(disciplinaAluno);
		} catch (Exception e) {
    		throw new Exception("Erro ao Inserir Pessoa: "+e.getMessage());
		}
	}
	
	public void update(DisciplinaAluno disciplinaAluno) throws Exception {
		try {
			   getSession().merge(disciplinaAluno);
			} catch (Exception e) {
	    		throw new Exception("Erro ao Atualizar DisciplinaAluno: "+e.getMessage());
			}
		
	}
	
	public DisciplinaAluno findById(int id){
		return (DisciplinaAluno) getSession().get(DisciplinaAluno.class, id);	
	}
	
	@SuppressWarnings("unchecked")
	public List<DisciplinaAluno> findAll(){
		return getSession().createCriteria(DisciplinaAluno.class).list();
	}
	
	
}
