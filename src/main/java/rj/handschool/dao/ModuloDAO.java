package rj.handschool.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rj.handschool.model.Modulo;
import rj.handschool.model.ModuloPK;

@Repository
@Transactional
public class ModuloDAO {
	
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
	public void insert(Modulo modulo) throws Exception{
		try {
		   getSession().save(modulo);
		} catch (Exception e) {
    		throw new Exception("Erro ao Inserir Modulo: " + e.getMessage());
		}
	}
	
	public void update(Modulo modulo) throws Exception {
		try {
			   getSession().merge(modulo);
			} catch (Exception e) {
	    		throw new Exception("Erro ao Atualizar Modulo: " + e.getMessage());
			}
	}
	
	public void remove(ModuloPK moduloPK) throws Exception {
		try {
				Query q = getSession().getNamedQuery("Modulo.DeleteForID");
				q.setParameter("moduloPK", moduloPK).executeUpdate();
			} catch (Exception e) {
	    		throw new Exception("Erro ao Deletar o Modulo: " + e.getMessage());
			}
	}
	
	public Modulo findById(ModuloPK moduloPK){
		return (Modulo) getSession().get(Modulo.class, moduloPK);	
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


}
