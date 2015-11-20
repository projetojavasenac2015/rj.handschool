package rj.handschool.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rj.handschool.model.Aluno;
import rj.handschool.model.TipoPessoa;

@Repository
@Transactional
public class AlunoDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	private Session getSession() {
		Session sess = getSessionFactory().getCurrentSession();
		if (sess == null) {
			sess = getSessionFactory().openSession();
		}
		return sess;
	}		
	
	@Transactional
	public void insert(Aluno aluno) throws Exception{
		try {
		   aluno.setTipoPessoa(TipoPessoa.Aluno);
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
		return q.setParameter("matricula",aluno.getMatricula()).getFetchSize();
	}
}
