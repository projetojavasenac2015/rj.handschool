package rj.handschool.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rj.handschool.model.Perfil;

@Repository
@Transactional
public class PerfilDAO {
	
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
	public void insert(Perfil perfil) throws Exception{
		try {
			
			perfil.setDataHoraCadastro(new java.sql.Date(System.currentTimeMillis()));
			getSession().save(perfil);
		} catch (Exception e) {
    		throw new Exception("Erro ao Inserir Perfil: " + e.getMessage());
		}
	}
	
	public void update(Perfil perfil) throws Exception {
		try {
				perfil.setDataUltAlteracao(new java.sql.Date(System.currentTimeMillis()));
				getSession().merge(perfil);
			} catch (Exception e) {
	    		throw new Exception("Erro ao Atualizar Perfil: " + e.getMessage());
			}
	}
	
	//Não deletamos perfil também, deletamos pessoas
	
	public Perfil findById(int id){
		return (Perfil) getSession().get(Perfil.class, id);	
	}
	
	@SuppressWarnings("unchecked")
	public List<Perfil> findAll(){
		return getSession().createCriteria(Perfil.class).list();
	}
	
}
