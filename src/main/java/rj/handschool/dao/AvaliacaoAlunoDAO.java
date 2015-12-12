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

	public List<Object[]> findByMediaAvaliacao(int idturma, String matricula){
		String varname1 = ""
		+ "select avg(valor) as media, matricula, count(1) as qtd from avaliacao_aluno a "
		+ "inner join avaliacao b on a.id_avaliacao = b.idavaliacao "
		+ "inner join aulas c on c.idaulas = b.idaulas "
		+ "inner join auladisciplina d on d.idaulas = c.idaulas "
		+ "inner join disciplina e on e.iddisciplina  = d.iddisciplina "
		+ "inner join modulodisciplina f on e.iddisciplina = f.iddisciplina "
		+ "inner join modulo g on f.idmodulo = g.idmodulo "
		+ "inner join curso i on i.idcurso = g.idcurso "
		+ "inner join turma j on j.idcurso = i.idcurso "
		+ "where j.idturma =:turma "
		+ "and matricula =:matricula "
		+ "group by matricula";
		Query q = getSession().createSQLQuery(varname1);
		q.setParameter("turma",idturma);
		q.setParameter("matricula",matricula);
		return q.list();
	}
	
	public List<Object[]> findByQuadroAvaliacao(String matricula){
		String varname1 = ""
		+ "select data_aula, (select descricao from tipo_avaliacao where a.id_tipo_avaliacao = idtipo_avaliacao) "
		+ "as tipo, (select count(1) from avaliacao_aluno where id_avaliacao = a.idavaliacao) as alunos_avaliados "
		+ ",(select avg(valor) from avaliacao_aluno where id_avaliacao = a.idavaliacao) as média "
		+ ",(select count(1) from avaliacao_aluno where id_avaliacao = idavaliacao and valor = a.valor_min)  as reprovado "
		+ ",(select count(1) from avaliacao_aluno where id_avaliacao = idavaliacao and valor > a.valor_min)  as aprovado "
		+ "from avaliacao a "
		+ " inner join aulas b on a.idaulas = b.idaulas "
		+ " inner join alocacao c on b.idaulas = c.idaulas "
		+ " where matricula_professor =:matricula";
		Query q = getSession().createSQLQuery(varname1);
		q.setParameter("matricula", matricula);
		return q.list();
	}
}
