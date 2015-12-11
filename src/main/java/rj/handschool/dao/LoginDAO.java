package rj.handschool.dao;

import java.util.List;

/*
 * Por: Farmy Silva
 * 
 */
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rj.handschool.model.Login;

@Repository
@Transactional
public class LoginDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	private Session getSession(){
		Session sess = getSessionFactory().getCurrentSession();
		if (sess == null) {
			sess = getSessionFactory().openSession();
		}
		return sess;
	}
	
	@Transactional
	public void insert(Login login)throws Exception{
		try {
			getSession().save(login);
		} catch (Exception e) {
			throw new Exception("Erro ao inserir Login: "+e.getMessage());
		}
	}
	
	public void update(Login login)throws Exception{
		try {
			getSession().merge(login);
		} catch (Exception e) {
			throw new Exception("Erro ao atualizar Login: "+e.getMessage());
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Login> findAll(){
		return  getSession().createCriteria(Login.class).list();		
	}
	
}
