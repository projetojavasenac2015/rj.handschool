package rj.handschool.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rj.handschool.model.Professor;
import rj.handschool.model.ProfessorPK;

@Repository
@Transactional
public class ProfessorDAO {

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
	public void insert(Professor professor) throws Exception{
		try {
		   getSession().save(professor);
		} catch (Exception e) {
    		throw new Exception("Erro ao Inserir Curso: " + e.getMessage());
		}
	}
	
	public void update(Professor professor) throws Exception {
		try {
			   getSession().merge(professor);
			} catch (Exception e) {
	    		throw new Exception("Erro ao Atualizar Curso: " + e.getMessage());
			}
	}	
	
	public Professor findById(ProfessorPK professorPK){
		return (Professor) getSession().get(Professor.class, professorPK);	
	}
	
	@SuppressWarnings("unchecked")
	public List<Professor> findAll(){
		return getSession().createCriteria(Professor.class).list();
	}
	
}
