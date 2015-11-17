package rj.handschool.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rj.handschool.model.Owner;
import rj.handschool.model.OwnerPK;

@Repository
@Transactional
public class OwnerDAO {
	
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
	public void insert(Owner owner) throws Exception{
		try {
		   getSession().save(owner);
		} catch (Exception e) {
    		throw new Exception("Erro ao Inserir Owner: " + e.getMessage());
		}
	}
	
	public void update(Owner owner) throws Exception {
		try {
			   getSession().merge(owner);
			} catch (Exception e) {
	    		throw new Exception("Erro ao Atualizar Owner: " + e.getMessage());
			}
	}
	
	//Não deletamos Owner, deletamos pessoa
	
	public Owner findById(Owner ownerPK){
		return (Owner) getSession().get(Owner.class, ownerPK);	
	}
	
	@SuppressWarnings("unchecked")
	public List<Owner> findAll(){
		return getSession().createCriteria(Owner.class).list();
	}
}
