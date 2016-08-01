package rj.handschool.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rj.handschool.model.Aluno;
import rj.handschool.model.Notificacao;

@Repository
@Transactional
public class NotificacaoDAO {
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
	public void insert(Notificacao notificacao) throws Exception{
		try {
		   getSession().save(notificacao);
		} catch (Exception e) {
    		throw new Exception("Erro ao Inserir Notificação: " + e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Notificacao> findAll(){
		return getSession().createCriteria(Notificacao.class).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> find(){
		String sql = "select date(dataNotificacao) as data ";
		sql += " ,notificacao ";
		sql += " ,(select nome from pessoa where idpessoa = id_professor) as pessoa, id_professor ";
		sql += ",(select descricao from turma where idturma = id_turma) as turma, id_turma ";
		sql += "from notificacao order by 1 desc ";
		
		Query q = getSession().createSQLQuery(sql);
		return q.list();
	}
}
