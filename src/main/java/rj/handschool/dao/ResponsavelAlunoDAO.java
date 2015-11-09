package rj.handschool.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rj.handschool.model.ResponsavelAluno;

@Repository
public class ResponsavelAlunoDAO {
	
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
	
	
	public void insert(ResponsavelAluno responsavelAluno) throws Exception{
		
		try {
		   getSession().save(responsavelAluno);
		} catch (Exception e) {
    		throw new Exception("Erro ao Inserir ResponsavelAluno: "+e.getMessage());
		}
	}
	
	public void update(ResponsavelAluno responsavelAluno) throws Exception {
		try {
			   getSession().merge(responsavelAluno);
			} catch (Exception e) {
	    		throw new Exception("Erro ao Atualizar ResponsavelAluno: "+e.getMessage());
			}
		
	}
	
	public ResponsavelAluno findById(int id){
		return (ResponsavelAluno) getSession().get(ResponsavelAluno.class, id);	
	}
	
	@SuppressWarnings("unchecked")
	public List<ResponsavelAluno> findAll(){
		return getSession().createCriteria(ResponsavelAluno.class).list();
	}
	
	
}
