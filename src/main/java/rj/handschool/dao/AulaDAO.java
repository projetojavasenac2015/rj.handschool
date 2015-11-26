package rj.handschool.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rj.handschool.model.Aulas;
import rj.handschool.model.Modulo;
import rj.handschool.model.Perfil;;

@Repository
@Transactional
public class AulaDAO {
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

	@Transactional
	public void insert(Aulas aula) throws Exception{
		try {
		   getSession().save(aula);
		} catch (Exception e) {
    		throw new Exception("Erro ao Inserir a Aula: " + e.getMessage());
		}
	}
	
	public void update(Aulas aula) throws Exception {
		try {
			   getSession().merge(aula);
			} catch (Exception e) {
	    		throw new Exception("Erro ao Atualizar a Aula: " + e.getMessage());
			}
	}
	
	//Não deletamos perfil também, deletamos pessoas
	
	public Aulas findById(int id){
		return (Aulas) getSession().get(Aulas.class, id);	
	}
	
	@SuppressWarnings("unchecked")
	public List<Aulas> findAll(){
		return getSession().createCriteria(Aulas.class).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Aulas> findDataAula(Date dataAula){
		Query q = getSession().getNamedQuery("Aulas.findByDataAula");
		q.setParameter("dataAula", dataAula);
		return (List<Aulas>)q.list();
	}
}
