package rj.handschool.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rj.handschool.model.Aluno;
import rj.handschool.model.AvaliacaoAluno;;

@Repository
@Transactional
public class AvaliacaoAlunoDAO {
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
	
	public void insert(AvaliacaoAluno avaliacaoAluno) throws Exception{
		try {
			avaliacaoAluno.setData(new java.sql.Date(System.currentTimeMillis()));
			getSession().save(avaliacaoAluno);
		} catch (Exception e) {
			System.out.println("Erro ao Inserir Modulo: " + e.getMessage());
    		throw new Exception("Erro ao Inserir Modulo: " + e.getMessage());
		}
	}
	
	public void update(AvaliacaoAluno avaliacaoAluno) throws Exception {
		try {
			 getSession().merge(avaliacaoAluno);
			} catch (Exception e) {
	    		throw new Exception("Erro ao Atualizar Modulo: " + e.getMessage());
			}
	}
	
	public AvaliacaoAluno findById(AvaliacaoAluno avaliacaoAluno){
		return (AvaliacaoAluno) getSession().get(AvaliacaoAluno.class, avaliacaoAluno);	
	}
	
	@SuppressWarnings("unchecked")
	public List<AvaliacaoAluno> findAll(){
		return getSession().createCriteria(AvaliacaoAluno.class).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<AvaliacaoAluno> findAvalicaoAluno(Aluno aluno){
		Query q = getSession().getNamedQuery("AvaliacaoAluno.findByAluno");
		q.setParameter("aluno", aluno);
		return (List<AvaliacaoAluno>)q.list();
	}

}
