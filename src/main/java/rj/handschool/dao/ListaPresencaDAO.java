package rj.handschool.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rj.handschool.model.ListaPresenca;

@Repository
@Transactional
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
			listaPresenca.setDataHoraCadastro(new java.sql.Date(System.currentTimeMillis()));
			getSession().save(listaPresenca);
		} catch (Exception e) {
			System.out.println("Erro ao Inserir Modulo: " + e.getMessage());
    		throw new Exception("Erro ao Inserir Modulo: " + e.getMessage());
		}
	}
	
	public void update(ListaPresenca listaPresenca) throws Exception {
		try {
			listaPresenca.setDataUltAtualizacao(new java.sql.Date(System.currentTimeMillis()));   
			 getSession().merge(listaPresenca);
			} catch (Exception e) {
	    		throw new Exception("Erro ao Atualizar Modulo: " + e.getMessage());
			}
	}
	
	public ListaPresenca findById(ListaPresenca listaPresenca){
		return (ListaPresenca) getSession().get(ListaPresenca.class, listaPresenca);	
	}
	
	@SuppressWarnings("unchecked")
	public List<ListaPresenca> findAll(){
		return getSession().createCriteria(ListaPresenca.class).list();
	}	
	
}
