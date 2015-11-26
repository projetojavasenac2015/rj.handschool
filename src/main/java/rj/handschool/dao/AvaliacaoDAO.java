package rj.handschool.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rj.handschool.model.Avaliacao;
import rj.handschool.model.TipoAvaliacao;


@Repository
@Transactional
public class AvaliacaoDAO {
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
	
	public void insert(Avaliacao avaliacao) throws Exception{
		try {
			avaliacao.setDataHoraCadastro(new java.sql.Date(System.currentTimeMillis()));
			getSession().save(avaliacao);
		} catch (Exception e) {
			System.out.println("Erro ao Inserir Modulo: " + e.getMessage());
    		throw new Exception("Erro ao Inserir Modulo: " + e.getMessage());
		}
	}
	
	public void update(Avaliacao avaliacao) throws Exception {
		try {
				avaliacao.setDataUltAtualizacao(new java.sql.Date(System.currentTimeMillis()));
				getSession().merge(avaliacao);
			} catch (Exception e) {
	    		throw new Exception("Erro ao Atualizar Modulo: " + e.getMessage());
			}
	}
	
	public Avaliacao findById(Avaliacao avaliacao){
		return (Avaliacao) getSession().get(Avaliacao.class, avaliacao);	
	}
	
	@SuppressWarnings("unchecked")
	public List<Avaliacao> findAll(){
		return getSession().createCriteria(Avaliacao.class).list();
	}	
	

	@SuppressWarnings("unchecked")
	public List<Avaliacao> findTipoAvaliacao(TipoAvaliacao tipoAvaliacao){
		Query q = getSession().getNamedQuery("Avaliacao.findByIdTipoAvaliacao");
		q.setParameter("tipoAvaliacao", tipoAvaliacao);
		return (List<Avaliacao>)q.list();
	}


}
