package rj.handschool.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rj.handschool.model.TipoAvaliacao;

@Repository
public class TipoAvaliacaoDAO {
	
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
	
	
	public void insert(TipoAvaliacao tipoAvaliacao) throws Exception{
		
		try {
		   getSession().save(tipoAvaliacao);
		} catch (Exception e) {
    		throw new Exception("Erro ao Inserir TipoAvaliacao: "+e.getMessage());
		}
	}
	
	public void update(TipoAvaliacao tipoAvaliacao) throws Exception {
		try {
			   getSession().merge(tipoAvaliacao);
			} catch (Exception e) {
	    		throw new Exception("Erro ao Atualizar TipoAvaliacao: "+e.getMessage());
			}
		
	}
	
	public TipoAvaliacao findById(int id){
		return (TipoAvaliacao) getSession().get(TipoAvaliacao.class, id);	
	}
	
	@SuppressWarnings("unchecked")
	public List<TipoAvaliacao> findAll(){
		return getSession().createCriteria(TipoAvaliacao.class).list();
	}
	
	
}
