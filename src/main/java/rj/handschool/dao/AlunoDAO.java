package rj.handschool.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rj.handschool.model.Aluno;

@Repository
@Transactional
public class AlunoDAO {
	
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
	public void insert(Aluno aluno) throws Exception{
		try {
		   getSession().save(aluno);
		   getSession().flush();
		} catch (Exception e) {
    		throw new Exception("Erro ao Inserir Aluno: " + e.getMessage());
		}
	}
	@Transactional
	public void update(Aluno aluno) throws Exception {
		try {
			   getSession().merge(aluno);
			} catch (Exception e) {
	    		throw new Exception("Erro ao Atualizar Aluno: " + e.getMessage());
			}
	}

	@SuppressWarnings("unchecked")
	public List<Aluno> findAll(){
		return getSession().createCriteria(Aluno.class).list();
	}
	
	public int findAlunoJaMatriculado(Aluno aluno){
		Query q = getSession().getNamedQuery("Aluno.findAlgumAlunoMatriculado");
		return ((Long)q.setParameter("matricula",aluno.getMatricula()).uniqueResult()).intValue();
	}
	
	public Aluno findByMatricula(Aluno aluno){
		Query q = getSession().getNamedQuery("Aluno.findByMatricula");
		q.setParameter("matricula",aluno.getMatricula());
		return (Aluno)q.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Aluno> findByNaoMatriculado(){
		Query q = getSession().getNamedQuery("Aluno.findByNaoMatriculado");
		return (List<Aluno>)q.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> findByAlunosMatriculadosTurma(int idturma){
		Query q = getSession().getNamedQuery("Aluno.findByAlunosMatriculadosTurma");
		q.setParameter("idturma", idturma);
		return q.list();
	}
	
	public void EfetuarMatricula(int idturma, String matricula){
		Query q = getSession().createSQLQuery("Update aluno set idturma=:turma where matricula= :matricula");
		q.setParameter("turma", idturma);
		q.setParameter("matricula", matricula);
		q.executeUpdate();
	}
}
