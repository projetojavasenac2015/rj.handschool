package rj.handschool.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rj.handschool.model.Modulo;

@Repository
@Transactional
public class ModuloDAO {	
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
	
	public void insert(Modulo modulo) throws Exception{
		try {
			modulo.setDataHoraCadastro(new java.sql.Date(System.currentTimeMillis()));
			getSession().save(modulo);
		} catch (Exception e) {
			System.out.println("Erro ao Inserir Modulo: " + e.getMessage());
    		throw new Exception("Erro ao Inserir Modulo: " + e.getMessage());
		}
	}
	
	public void update(Modulo modulo) throws Exception {
		try {
			 modulo.setDataUltAtualizacao(new java.sql.Date(System.currentTimeMillis()));   
			 getSession().merge(modulo);
			} catch (Exception e) {
	    		throw new Exception("Erro ao Atualizar Modulo: " + e.getMessage());
			}
	}
	
	public Modulo findById(Modulo modulo){
		return (Modulo) getSession().get(Modulo.class, modulo);	
	}
	
	@SuppressWarnings("unchecked")
	public List<Modulo> findAll(){
		return getSession().createCriteria(Modulo.class).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Modulo> findUltimosCadastrados(int qtd){
		Query q = getSession().getNamedQuery("Modulo.findUltimosCadastrados");
		q.setMaxResults(qtd);
		List<Modulo> lista_modulo = (List<Modulo>)q.list();
		return lista_modulo;
	}

	@SuppressWarnings("unchecked")
	public List<Modulo> findModuloPorCurso(int idcurso){
		Query q = getSession().getNamedQuery("Modulo.findByIdCurso");
		q.setParameter("idcurso", idcurso);
		return (List<Modulo>)q.list();
	}

}
