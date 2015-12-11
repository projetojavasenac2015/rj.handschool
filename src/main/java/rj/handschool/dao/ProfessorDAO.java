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
	
	public List<Object[]> findByAlunoTurmaProfessor(String matriculaProfessor, int turma){
		String query = "  select  ";
		query += " j.nome, i.matricula, j.data_nascimento, j.email ";
		query += " from alocacao a ";
		query += " inner join auladisciplina b on a.idaulas = b.idaulas  ";
		query += " inner join disciplina c on b.iddisciplina = c.iddisciplina   ";
		query += " inner join modulodisciplina d on d.iddisciplina  = c.iddisciplina ";
		query += " inner join modulo e on e.idmodulo = d.idmodulo ";
		query += " inner join curso f on f.idcurso = e.idcurso ";
		query += " inner join turma g on g.idcurso = f.idcurso ";
		query += " inner join professor h on a.matricula_professor = h.matricula_professor ";
		query += " inner join aluno i on i.idturma = g.idturma ";
		query += " inner join pessoa j on i.idpessoa = i.idpessoa ";
		query += " where a.matricula_professor =:matriculaProfessor ";
		query += " and g.idturma =:turma ";
		query += " group by i.matricula";
		Query q = getSession().createSQLQuery(query);
		q.setParameter("matriculaProfessor",matriculaProfessor);
		q.setParameter("turma",turma);
		return q.list();
	}
	
}
