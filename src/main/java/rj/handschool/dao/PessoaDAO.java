package rj.handschool.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rj.handschool.model.Pessoa;
import rj.handschool.model.PessoaPK;

@Repository
@Transactional
public class PessoaDAO {
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
	public void insert(Pessoa pessoa) throws Exception{
		try {
		   getSession().save(pessoa);
		} catch (Exception e) {
    		throw new Exception("Erro ao Inserir Pessoa: " + e.getMessage());
		}
	}
	
	public void update(Pessoa pessoa) throws Exception {
		try {
			   getSession().merge(pessoa);
			} catch (Exception e) {
	    		throw new Exception("Erro ao Atualizar Pessoa: " + e.getMessage());
			}
	}
	
	public void remove(PessoaPK pessoaPk) throws Exception {
		try {
				Query q = getSession().getNamedQuery("Pessoa.DeleteForPessoaPK");
				q.setParameter("pessoaPk", pessoaPk).executeUpdate();
			} catch (Exception e) {
	    		throw new Exception("Erro ao Deletar o Pessoa: " + e.getMessage());
			}
	}
	
	public Pessoa findById(PessoaPK pessoaPk){
		return (Pessoa) getSession().get(Pessoa.class, pessoaPk);	
	}
	
	@SuppressWarnings("unchecked")
	public List<Pessoa> findAll(){
		return getSession().createCriteria(Pessoa.class).list();
	}
}
