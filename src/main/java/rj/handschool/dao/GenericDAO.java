package rj.handschool.dao;

import java.io.Serializable;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rj.handschool.model.Curso;

@Repository
@Transactional
public class GenericDAO<T> implements Serializable{
	
	@Autowired
	private SessionFactory sessionFactory;
	private Class<T> persistentClass;
	
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
	 public void insert(T entity) throws Exception{
			try {
			   getSession().save(entity);
			} catch (Exception e) {
	    		throw new Exception("Erro ao Inserir: " + e.getMessage());
			}
		}
	
	 public void update(T entity) throws Exception {
			try {
				   getSession().merge(entity);
				} catch (Exception e) {
		    		throw new Exception("Erro ao Atualizar: " + e.getMessage());
				}
		}

	 public void remove(T entity) throws Exception {
		 try {
			   getSession().delete(entity);
			} catch (Exception e) {
	    		throw new Exception("Erro ao Remover: " + e.getMessage());
			}
		}
	 
	 
	 @SuppressWarnings("unchecked")
		public List<T> findAll(){
			return getSession().createCriteria(persistentClass).list();
		}
		
		@SuppressWarnings("unchecked")
		public List<T> findUltimosCadastrados(int qtd){
			Query q = getSession().getNamedQuery("Curso.findUltimosCadastrados");
			q.setMaxResults(qtd);
			List<T> lista_curso = (List<T>)q.list();
			return lista_curso;
		}	
}
