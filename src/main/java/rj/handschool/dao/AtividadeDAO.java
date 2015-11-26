package rj.handschool.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rj.handschool.model.Atividade;
import rj.handschool.model.TipoAtividade;

@Repository
@Transactional
public class AtividadeDAO {
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
	
	public void insert(Atividade atividade) throws Exception{
		try {			
			getSession().save(atividade);
		} catch (Exception e) {
			System.out.println("Erro ao Inserir Modulo: " + e.getMessage());
    		throw new Exception("Erro ao Inserir Modulo: " + e.getMessage());
		}
	}
	
	public void update(Atividade atividade) throws Exception {
		try {
			   getSession().merge(atividade);
			} catch (Exception e) {
	    		throw new Exception("Erro ao Atualizar Modulo: " + e.getMessage());
			}
	}
	
	public Atividade findById(Atividade atividade){
		return (Atividade) getSession().get(Atividade.class, atividade);	
	}
	
	@SuppressWarnings("unchecked")
	public List<Atividade> findAll(){
		return getSession().createCriteria(Atividade.class).list();
	}	
	

	@SuppressWarnings("unchecked")
	public List<Atividade> findAtividadePorTipo(TipoAtividade tipoAtividade){
		Query q = getSession().getNamedQuery("Atividade.findByIdTipoAtividade");
		q.setParameter("tipoAtividade", tipoAtividade);
		return (List<Atividade>)q.list();
	}

}
