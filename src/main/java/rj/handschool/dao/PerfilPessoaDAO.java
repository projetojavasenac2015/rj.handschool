package rj.handschool.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rj.handschool.model.Ambiente;
import rj.handschool.model.Perfil;
import rj.handschool.model.PerfilPessoa;
import rj.handschool.model.Professor;

@Repository
@Transactional
public class PerfilPessoaDAO {
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
	
	public int isExistis(Perfil pe, Professor pr){
		Query q = getSession().getNamedQuery("PerfilPessoa.findByProfessorPerfil");
		q.setParameter("idperfil",pe.getId());
		q.setParameter("idpessoa", pr.getIdpessoa());
		return q.list().size();
	}
	
	@Transactional
	public void insert(PerfilPessoa perfilpessoa) throws Exception{
		try {
			getSession().save(perfilpessoa);
		} catch (Exception e) {
    		throw new Exception("Erro ao Inserir Perfil da Pessoa: " + e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]>  findPessoaPerfilAll(){
		String query = "select data_acao as data_acao ";
		query += ",(select descricao from perfil where id_perfil = idperfil) as perfil ";
		query += ",(select nome from pessoa where id_pessoa = idpessoa) as pessoa ";
		query += "from perfilpessoa ";
		Query q = getSession().createSQLQuery(query);
		
		return q.list();
	}
}
