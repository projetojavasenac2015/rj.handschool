package rj.handschool.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rj.handschool.model.TipoRegistro;

@Repository
public class TipoRegistroDAO {
	
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
	
	
	public void insert(TipoRegistro tipoRegistro) throws Exception{
		
		try {
		   getSession().save(tipoRegistro);
		} catch (Exception e) {
    		throw new Exception("Erro ao Inserir TipoRegistro: "+e.getMessage());
		}
	}
	
	public void update(TipoRegistro tipoRegistro) throws Exception {
		try {
			   getSession().merge(tipoRegistro);
			} catch (Exception e) {
	    		throw new Exception("Erro ao Atualizar TipoRegistro: "+e.getMessage());
			}
		
	}
	
	public TipoRegistro findById(int id){
		return (TipoRegistro) getSession().get(TipoRegistro.class, id);	
	}
	
	@SuppressWarnings("unchecked")
	public List<TipoRegistro> findAll(){
		return getSession().createCriteria(TipoRegistro.class).list();
	}
	
	
}
