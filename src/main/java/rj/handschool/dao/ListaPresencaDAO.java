package rj.handschool.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rj.handschool.model.ListaPresenca;

@Repository
public class ListaPresencaDAO {
	
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
	
	
	public void insert(ListaPresenca listaPresenca) throws Exception{
		
		try {
		   getSession().save(listaPresenca);
		} catch (Exception e) {
    		throw new Exception("Erro ao Inserir ListaPresenca: "+e.getMessage());
		}
	}
	
	public void update(ListaPresenca listaPresenca) throws Exception {
		try {
			   getSession().merge(listaPresenca);
			} catch (Exception e) {
	    		throw new Exception("Erro ao Atualizar ListaPresenca: "+e.getMessage());
			}
		
	}
	
	public ListaPresenca findById(int id){
		return (ListaPresenca) getSession().get(ListaPresenca.class, id);	
	}
	
	@SuppressWarnings("unchecked")
	public List<ListaPresenca> findAll(){
		return getSession().createCriteria(ListaPresenca.class).list();
	}
	
	
}
