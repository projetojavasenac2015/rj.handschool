package rj.handschool.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rj.handschool.model.Forum;

@Repository
public class ForumDAO {
	
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
	
	
	public void insert(Forum forum) throws Exception{
		
		try {
		   getSession().save(forum);
		} catch (Exception e) {
    		throw new Exception("Erro ao Inserir Forum: "+e.getMessage());
		}
	}
	
	public void update(Forum forum) throws Exception {
		try {
			   getSession().merge(forum);
			} catch (Exception e) {
	    		throw new Exception("Erro ao Atualizar Forum: "+e.getMessage());
			}
		
	}
	
	public Forum findById(int id){
		return (Forum) getSession().get(Forum.class, id);	
	}
	
	@SuppressWarnings("unchecked")
	public List<Forum> findAll(){
		return getSession().createCriteria(Forum.class).list();
	}
	
	
}
