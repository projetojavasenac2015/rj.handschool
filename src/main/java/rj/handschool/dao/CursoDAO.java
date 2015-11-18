package rj.handschool.dao;

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
public class CursoDAO {
	
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
		public void insert(Curso curso) throws Exception{
			try {
				curso.setDataHoraCadastro(new java.sql.Date(System.currentTimeMillis()));
				getSession().save(curso);
			} catch (Exception e) {
	    		throw new Exception("Erro ao Inserir Curso: " + e.getMessage());
			}
		}
		
		public void update(Curso curso) throws Exception {
			try {
					curso.setDataUltAtualizacao(new java.sql.Date(System.currentTimeMillis()));
					getSession().merge(curso);
				} catch (Exception e) {
		    		throw new Exception("Erro ao Atualizar Curso: " + e.getMessage());
				}
		}
		
		public void remove(int id) throws Exception {
			try {
					Query q = getSession().getNamedQuery("Curso.DeleteForID");
					q.setParameter("id", id).executeUpdate();
				} catch (Exception e) {
		    		throw new Exception("Erro ao Deletar o Curso: " + e.getMessage());
				}
		}
		
		public Curso findById(int id){
			return (Curso) getSession().get(Curso.class, id);	
		}
		
		@SuppressWarnings("unchecked")
		public List<Curso> findAll(){
			return getSession().createCriteria(Curso.class).list();
		}
		
		@SuppressWarnings("unchecked")
		public List<Curso> findUltimosCadastrados(int qtd){
			Query q = getSession().getNamedQuery("Curso.findUltimosCadastrados");
			q.setMaxResults(qtd);
			List<Curso> lista_curso = (List<Curso>)q.list();
			return lista_curso;
		}
	
}
