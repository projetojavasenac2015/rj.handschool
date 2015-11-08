package rj.handschool.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



import rj.handschool.model.Login;

@Repository
public class LoginDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Login findById(int id){
		return (Login) getSession().get(Login.class, id);	
	}
	
	public Login findByEmail(String email) throws Exception {
		try {
			return (Login)	getSession().createCriteria(Login.class)
					.add(Restrictions.eq("email", email)).uniqueResult();

			
			
		}catch(Exception e){
	     throw new Exception("Erro ao Procurar Login por E-mail: "+e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Login> findAll(){
		return getSession().createCriteria(Login.class).list();
	}
	
	
public void update(Login login) throws Exception {
		
		try {
			getSession().merge(login);
		} catch (Exception e) {
			throw new Exception("Erro ao Inserir Login: "+e.getMessage());
		}
	}
	
public void insert(Login login) throws Exception{
		try {
		   getSession().save(login);
			
		} catch (Exception e) {
			throw new Exception("Erro ao Inserir Login: "+e.getMessage());
    	}
}

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

}
