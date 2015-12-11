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
	
	@SuppressWarnings("unchecked")
	public List<String>  findAulasDisciplinasTurma(int idturma, int iddisciplina, String matricula){
		String query = "SELECT date_format(data_aula,'%m/%d/%Y') as data FROM aulas a ";
		query += " inner join auladisciplina b on a.idaulas = b.idaulas ";
		query += " inner join disciplina c on b.iddisciplina = c.iddisciplina ";
		query += " inner join modulodisciplina d on d.iddisciplina =  b.iddisciplina  ";
		query += " inner join modulo e on e.idmodulo = d.idmodulo ";
		query += " inner join curso f on f.idcurso = e.idcurso ";
		query += " inner join turma g on g.idcurso = f.idcurso";
		query += " inner join alocacao h on h.idaulas = a.idaulas ";
		query += " where c.iddisciplina =:iddisciplina ";
		query += " and h.matricula_professor=:matricula ";
		query += " and g.idturma =:idturma  and date(data_aula) >= current_Date group by data_aula , g.idturma";
		query += " order by data_aula asc ";
		Query q = getSession().createSQLQuery(query);

		q.setParameter("idturma", idturma);
		q.setParameter("iddisciplina", iddisciplina);
		q.setParameter("matricula", matricula);
		return (List<String>)q.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<String>  findAulasDisciplinasTurma(int idturma, int iddisciplina, String matricula, String data){
		String query = "SELECT concat(a.idaulas,'?',hora_inicio,'-',hora_fim) as horario FROM aulas a ";
		query += " inner join auladisciplina b on a.idaulas = b.idaulas ";
		query += " inner join disciplina c on b.iddisciplina = c.iddisciplina ";
		query += " inner join modulodisciplina d on d.iddisciplina =  b.iddisciplina  ";
		query += " inner join modulo e on e.idmodulo = d.idmodulo ";
		query += " inner join curso f on f.idcurso = e.idcurso ";
		query += " inner join turma g on g.idcurso = f.idcurso";
		query += " inner join alocacao h on h.idaulas = a.idaulas ";
		query += " where c.iddisciplina =:iddisciplina ";
		query += " and h.matricula_professor=:matricula ";
		query += " and g.idturma =:idturma  and data_aula =:data_aula ";
		Query q = getSession().createSQLQuery(query);

		q.setParameter("idturma", idturma);
		q.setParameter("iddisciplina", iddisciplina);
		q.setParameter("matricula", matricula);
		q.setParameter("data_aula", data);
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
	
	public List<Object[]> findByALunoAulas(int idaula, int id_tipo_avaliacao){
		String query = " select i.matricula, (select nome from pessoa where i.idpessoa = idpessoa) as nome ";
		query += " ,i.idpessoa ";
		query += ",(select situacao from listapresenca z where z.matricula = i.matricula = z.id_aulas = a.idaulas) as situacao_aula ";
		query += " ,j.idavaliacao ";
		query += " from aulas a ";
		query += " inner join auladisciplina b ON a.idaulas = b.idaulas ";
		query += " inner join disciplina c ON b.iddisciplina = c.iddisciplina ";
		query += " inner join modulodisciplina d ON d.iddisciplina = b.iddisciplina ";
		query += " inner join modulo e ON e.idmodulo = d.idmodulo ";
		query += " inner join curso f ON f.idcurso = e.idcurso ";
		query += " inner join turma g ON g.idcurso = f.idcurso ";
		query += " inner join alocacao h ON h.idaulas = a.idaulas ";
		query += " inner join aluno i on i.idturma = g.idturma ";
		query += " inner join avaliacao j on j.idaulas = a.idaulas ";
		query += " where h.idaulas =:idaula and j.id_tipo_avaliacao =:id_tipo_avaliacao order by 2 asc  ";
		Query q = getSession().createSQLQuery(query);
		q.setParameter("idaula",idaula);
		q.setParameter("id_tipo_avaliacao",id_tipo_avaliacao);
		return q.list();
	}
}
