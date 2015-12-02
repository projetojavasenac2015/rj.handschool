package rj.handschool.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rj.handschool.model.Turma;

@Repository
@Transactional
public class TurmaDAO {

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
	public void insert(Turma turma) throws Exception {
		try {
			turma.setDataHoraCadastro(new java.sql.Date(System
					.currentTimeMillis()));
			getSession().save(turma);
		} catch (Exception e) {
			throw new Exception("Erro ao Inserir Turma: " + e.getMessage());
		}
	}

	public void update(Turma turma) throws Exception {
		try {
			getSession().merge(turma);
		} catch (Exception e) {
			throw new Exception("Erro ao Atualizar Turma: " + e.getMessage());
		}
	}

	public void remove(Turma turma) throws Exception {
		try {
			Query q = getSession().getNamedQuery("Turma.DeleteForID");
			q.setParameter("turma", turma).executeUpdate();
		} catch (Exception e) {
			throw new Exception("Erro ao Deletar o Curso: " + e.getMessage());
		}
	}

	public Turma findById(Turma turma) {
		return (Turma) getSession().get(Turma.class, turma);
	}

	@SuppressWarnings("unchecked")
	public List<Turma> findAll() {
		return getSession().createCriteria(Turma.class).list();
	}

	@SuppressWarnings("unchecked")
	public List<Turma> findUltimosCadastrados(int qtd) {
		Query q = getSession().getNamedQuery("Turma.findUltimosCadastrados");
		q.setMaxResults(qtd);
		List<Turma> lista_turma = (List<Turma>) q.list();
		return lista_turma;
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> findByPorCurso(int idcurso) {
		Query q = getSession().getNamedQuery("Turma.findByPorCurso");
		q.setParameter("idcurso", idcurso);
		return q.list();
	}
}
