package rj.handschool.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rj.handschool.model.Aluno;

@Repository
public class AlunoDAO {
	
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
	
	
	public void insert(Aluno aluno) throws Exception{
		
		try {
		   getSession().save(aluno);
		} catch (Exception e) {
    		throw new Exception("Erro ao Inserir Aluno: "+e.getMessage());
		}
	}
	
	public void update(Aluno aluno) throws Exception {
		try {
			   getSession().merge(aluno);
			} catch (Exception e) {
	    		throw new Exception("Erro ao Atualizar Aluno: "+e.getMessage());
			}
		
	}
	
	public Aluno findById(int id){
		return (Aluno) getSession().get(Aluno.class, id);	
	}
	
	@SuppressWarnings("unchecked")
	public List<Aluno> findAll(){
		return getSession().createCriteria(Aluno.class).list();
	}
	
	
}
