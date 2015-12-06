package rj.handschool.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rj.handschool.model.Disciplina;

@Repository
@Transactional
public class DisciplinaDAO {
	
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
		public void insert(Disciplina disciplina) throws Exception{
			try {
			   disciplina.setDataHoraCadastro(new java.sql.Date(System.currentTimeMillis()));
			   getSession().save(disciplina);
			} catch (Exception e) {
	    		throw new Exception("Erro ao Inserir Disciplina: " + e.getMessage());
			}
		}
		
		public void update(Disciplina disciplina) throws Exception {
			try {
				   disciplina.setDataUltAtualizacao(new java.sql.Date(System.currentTimeMillis()));
				   getSession().merge(disciplina);
				} catch (Exception e) {
		    		throw new Exception("Erro ao Atualizar Disciplina: " + e.getMessage());
				}
		}
		
		public void remove(int id) throws Exception {
			try {
					Query q = getSession().getNamedQuery("Disciplina.DeleteForID");
					q.setParameter("id", id).executeUpdate();
				} catch (Exception e) {
		    		throw new Exception("Erro ao Deletar o Disciplina: " + e.getMessage());
				}
		}
		
		public Disciplina findById(int id){
			return (Disciplina) getSession().get(Disciplina.class, id);	
		}
		
		@SuppressWarnings("unchecked")
		public List<Disciplina> findAll(){
			return getSession().createCriteria(Disciplina.class).list();
		}
		
		@SuppressWarnings("unchecked")
		public List<Object[]> findByDisciplinaTurma(int idturma) {
			String sql = " select e.iddisciplina,e.nome ";
			sql+=" from turma a ";
			sql+=" inner join curso b on a.idcurso= b.idcurso  ";
			sql+=" inner join modulo c on b.idcurso = c.idcurso  ";
			sql+=" inner join modulodisciplina d on c.idmodulo =  d.idmodulo ";
			sql+=" inner join disciplina e on e.iddisciplina = d.iddisciplina ";
			sql+=" where a.idturma =:turma ";
			Query q = getSession().createSQLQuery(sql);
			q.setParameter("turma", idturma);
			return q.list();
		}
}
