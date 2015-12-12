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
		String varname1 = ""
		+ "select j.nome, a.matricula, j.data_nascimento,j.email  from aluno a "
		+ "inner join pessoa j on j.idpessoa = a.idpessoa "
		+ "inner join turma b on a.idturma = b.idturma "
		+ "inner join curso c on c.idcurso = b.idcurso "
		+ "inner join modulo d on d.idcurso = c.idcurso "
		+ "inner join modulodisciplina e on e.idmodulo  = d.idmodulo "
		+ "inner join disciplina f on e.iddisciplina  = f.iddisciplina "
		+ "inner join auladisciplina g on g.iddisciplina = f.iddisciplina "
		+ "inner join aulas h on h.idaulas = g.idaulas "
		+ "inner join alocacao i on i.idaulas = h.idaulas "
		+ "where matricula_professor =:matriculaProfessor "
		+ "and b.idturma =:turma group by a.matricula";

		Query q = getSession().createSQLQuery(varname1);
		q.setParameter("matriculaProfessor",matriculaProfessor);
		q.setParameter("turma",turma);
		return q.list();
	}
	
	public Professor findById(int idpessoa){
		Query q = getSession().getNamedQuery("Professor.findById");
		q.setParameter("id",idpessoa);
		return (Professor)q.uniqueResult();
	}
	
}
