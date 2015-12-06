package rj.handschool.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rj.handschool.model.Aulas;;

@Repository
@Transactional
public class AulaDAO {
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
	public void insert(Aulas aula) throws Exception{
		try {
		   aula.setAtivo('1');
		   getSession().save(aula);
		} catch (Exception e) {
    		throw new Exception("Erro ao Inserir a Aula: " + e.getMessage());
		}
	}
	
	public void update(Aulas aula) throws Exception {
		try {
			   getSession().merge(aula);
			} catch (Exception e) {
	    		throw new Exception("Erro ao Atualizar a Aula: " + e.getMessage());
			}
	}
	
	//Não deletamos perfil também, deletamos pessoas
	
	public Aulas findById(int id){
		return (Aulas) getSession().get(Aulas.class, id);	
	}
	
	@SuppressWarnings("unchecked")
	public List<Aulas> findAll(){
		return getSession().createCriteria(Aulas.class).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Aulas> findDataAula(Date dataAula){
		Query q = getSession().getNamedQuery("Aulas.findByDataAula");
		q.setParameter("dataAula", dataAula);
		return (List<Aulas>)q.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<String>  findVerificaHorarios(String data, int iddisciplina){
		String query = "SELECT concat(hora_inicio, '-', hora_fim) as horario FROM aulas a ";
		query += " inner join auladisciplina b on a.idaulas = b.idaulas ";
		query += " inner join disciplina c on b.iddisciplina = c.iddisciplina ";
		query += " where c.iddisciplina =:iddisciplina ";
		query += " and a.data_aula =:dataAula";
		Query q = getSession().createSQLQuery(query);

		q.setParameter("dataAula", data);
		q.setParameter("iddisciplina", iddisciplina);
		return (List<String>)q.list();
	}
	
	public List<Object[]> findByAulasNaoAlocadas(int iddisciplina, String data){
		String query = " select date_format(data_aula,'%d/%m/%Y') as data_aula ";
		query += " , hora_inicio, hora_fim ";
		query += " ,(select nome from ambiente where idambiente = a.idambiente) as ambiente, a.idaulas ";
		query += " from aulas a ";
		query += " inner join auladisciplina b on a.idaulas = b.idaulas ";
		query += " where b.iddisciplina =:iddisciplina ";
		query += " and data_aula=:data and b.idaulas not in(select idaulas from alocacao)";
		Query q = getSession().createSQLQuery(query);
		q.setParameter("iddisciplina",iddisciplina);
		q.setParameter("data",data);
		return q.list();
	}
}
