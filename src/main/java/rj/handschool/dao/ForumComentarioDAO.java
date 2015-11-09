package rj.handschool.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rj.handschool.model.ForumComentario;

@Repository
public class ForumComentarioDAO {
	
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
	
	
	public void insert(ForumComentario forumComentario) throws Exception{
		
		try {
		   getSession().save(forumComentario);
		} catch (Exception e) {
    		throw new Exception("Erro ao Inserir ForumComentario: "+e.getMessage());
		}
	}
	
	public void update(ForumComentario forumComentario) throws Exception {
		try {
			   getSession().merge(forumComentario);
			} catch (Exception e) {
	    		throw new Exception("Erro ao Atualizar ForumComentario: "+e.getMessage());
			}
		
	}
	
	public ForumComentario findById(int id){
		return (ForumComentario) getSession().get(ForumComentario.class, id);	
	}
	
	@SuppressWarnings("unchecked")
	public List<ForumComentario> findAll(){
		return getSession().createCriteria(ForumComentario.class).list();
	}
	
	
}
