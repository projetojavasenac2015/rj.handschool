package rj.handschool.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rj.handschool.model.Alocacao;
import rj.handschool.model.Disciplina;

@Repository
@Transactional
public class AlocacaoDAO {
	
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
	public void insert(Alocacao alocacao) throws Exception{
		try {
			alocacao.setDataHoraCadastro(new java.sql.Date(System.currentTimeMillis()));
			getSession().save(alocacao);
		} catch (Exception e) {
			System.out.println("Erro ao Inserir Modulo: " + e.getMessage());
    		throw new Exception("Erro ao Inserir Modulo: " + e.getMessage());
		}
	}
	
	public void update(Alocacao alocacao) throws Exception {
		try {
			   getSession().merge(alocacao);
			} catch (Exception e) {
	    		throw new Exception("Erro ao Atualizar Modulo: " + e.getMessage());
			}
	}
	
	public Alocacao findById(Alocacao alocacao){
		return (Alocacao) getSession().get(Alocacao.class, alocacao);	
	}
	
	@SuppressWarnings("unchecked")
	public List<Alocacao> findAll(){
		return getSession().createCriteria(Alocacao.class).list();
	}	
	
	@SuppressWarnings("unchecked")
	public List<Alocacao> findAlocacaoPorDisciplina(Disciplina disciplina){
		Query q = getSession().getNamedQuery("Alocacao.findByIdDisciplina");
		q.setParameter("disciplina", disciplina);
		return (List<Alocacao>)q.list();
	}
}
