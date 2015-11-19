package rj.handschool.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rj.handschool.model.Pessoa;

@Repository
@Transactional
public class PessoaDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	private Session getSession() {
		Session sess = getSessionFactory().getCurrentSession();
		if (sess == null) {
			sess = getSessionFactory().openSession();
		}
		return sess;
	}
	
	@Transactional
	public void insert(Pessoa pessoa) throws Exception{
		try {
		   getSession().save(pessoa);
		} catch (Exception e) {
    		throw new Exception("Erro ao Inserir Pessoa: " + e.getMessage());
		}
	}
	
	public void update(Pessoa pessoa) throws Exception {
		try {
			   getSession().merge(pessoa);
			} catch (Exception e) {
	    		throw new Exception("Erro ao Atualizar Pessoa: " + e.getMessage());
			}
	}
	
	public Pessoa findById(Pessoa pessoa){
		return (Pessoa) getSession().get(Pessoa.class, pessoa);	
	}
	
	@SuppressWarnings("unchecked")
	public List<Pessoa> findAll(){
		return getSession().createCriteria(Pessoa.class).list();
	}
}
