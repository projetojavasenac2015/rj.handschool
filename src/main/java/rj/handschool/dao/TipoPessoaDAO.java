package rj.handschool.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rj.handschool.model.TipoPessoa;

@Repository
public class TipoPessoaDAO {
	
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
	
	
	public void insert(TipoPessoa tipoPessoa) throws Exception{
		
		try {
		   getSession().save(tipoPessoa);
		} catch (Exception e) {
    		throw new Exception("Erro ao Inserir TipoPessoa: "+e.getMessage());
		}
	}
	
	public void update(TipoPessoa tipoPessoa) throws Exception {
		try {
			   getSession().merge(tipoPessoa);
			} catch (Exception e) {
	    		throw new Exception("Erro ao Atualizar TipoPessoa: "+e.getMessage());
			}
		
	}
	
	public TipoPessoa findById(int id){
		return (TipoPessoa) getSession().get(TipoPessoa.class, id);	
	}
	
	@SuppressWarnings("unchecked")
	public List<TipoPessoa> findAll(){
		return getSession().createCriteria(TipoPessoa.class).list();
	}
	
	
}
