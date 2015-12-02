package rj.handschool.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rj.handschool.model.TipoAvaliacao;

@Repository
@Transactional
public class TipoAvaliacaoDAO {
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
	
	public void insert(TipoAvaliacao tipoAvaliacao) throws Exception{
		try {
			tipoAvaliacao.setDataHoraCadastro(new java.sql.Date(System.currentTimeMillis()));
			getSession().save(tipoAvaliacao);
		} catch (Exception e) {
			System.out.println("Erro ao Inserir Modulo: " + e.getMessage());
    		throw new Exception("Erro ao Inserir Modulo: " + e.getMessage());
		}
	}
	
	public void update(TipoAvaliacao tipoAvaliacao) throws Exception {
		try {
			 tipoAvaliacao.setDataUltAtualizacao(new java.sql.Date(System.currentTimeMillis()));   
			 getSession().merge(tipoAvaliacao);
			} catch (Exception e) {
	    		throw new Exception("Erro ao Atualizar Modulo: " + e.getMessage());
			}
	}
	
	public TipoAvaliacao findById(TipoAvaliacao tipoAvaliacao){
		return (TipoAvaliacao) getSession().get(TipoAvaliacao.class, tipoAvaliacao);	
	}
	
	@SuppressWarnings("unchecked")
	public List<TipoAvaliacao> findAll(){
		return getSession().createCriteria(TipoAvaliacao.class).list();
	}
}
