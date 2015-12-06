package rj.handschool.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rj.handschool.model.Ambiente;


@Repository
@Transactional
public class AmbienteDAO {
	
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
		public void insert(Ambiente ambiente) throws Exception{
			try {
				ambiente.setDataHoraCadastro(new java.sql.Date(System.currentTimeMillis()));
				getSession().save(ambiente);
			} catch (Exception e) {
	    		throw new Exception("Erro ao Inserir Ambiente: " + e.getMessage());
			}
		}
		@Transactional
		public void update(Ambiente ambiente) throws Exception {
			try {
					ambiente.setDataUltAtualizacao(new java.sql.Date(System.currentTimeMillis()));
					getSession().merge(ambiente);
				} catch (Exception e) {
		    		throw new Exception("Erro ao Atualizar Ambiente: " + e.getMessage());
				}
		}
		
		@SuppressWarnings("unchecked")
		public List<Ambiente> findAll(){
			return getSession().createCriteria(Ambiente.class).list();
		}

		public Ambiente findById(int id){
			return (Ambiente) getSession().get(Ambiente.class, id);	
		}
}
