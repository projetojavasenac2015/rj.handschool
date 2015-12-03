package rj.handschool.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rj.handschool.model.Professor;

@Repository
@Transactional
public class ProfessorDAO {

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
	public void insert(Professor professor) throws Exception{
		try {
				professor.setDataHoraCadastro(new java.sql.Date(System.currentTimeMillis()));
				getSession().save(professor);
		} catch (Exception e) {
    		throw new Exception("Erro ao Inserir Curso: " + e.getMessage());
		}
	}
	
	public void update(Professor professor) throws Exception {
		try {
				professor.setDataUltAtualizacao(new java.sql.Date(System.currentTimeMillis()));
				getSession().merge(professor);
			} catch (Exception e) {
	    		throw new Exception("Erro ao Atualizar Curso: " + e.getMessage());
			}
	}	
	
	public Professor findById(Professor professor){
		return (Professor) getSession().get(Professor.class, professor);	
	}
	
	@SuppressWarnings("unchecked")
	public List<Professor> findAll(){
		return getSession().createCriteria(Professor.class).list();
	}
	
	public Professor findByMatricula(Professor professor){
		Query q = getSession().getNamedQuery("Professor.findByMatriculaProfessor");
		q.setParameter("matricula",professor.getMatriculaProfessor());
		return (Professor)q.uniqueResult();
	}
	
	public List<Object[]> findByDisciplina(int iddisciplina){
		String query = " select matricula_professor, nome";
		query += " from professor a ";
		query += " inner join pessoa b ON a.idpessoa = b.idpessoa ";
		query += " inner join professordisciplina c ON c.idpessoa = a.idpessoa ";
		query += " where c.iddisciplina = :iddisciplina ";
		Query q = getSession().createSQLQuery(query);
		q.setParameter("iddisciplina",iddisciplina);
		return q.list();
	}
	
}
