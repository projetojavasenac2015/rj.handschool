package rj.handschool.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rj.handschool.model.ListaPresenca;

@Repository
@Transactional
public class ListaPresencaDAO {
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


	public void insert(ListaPresenca listaPresenca) throws Exception{
		try {
			listaPresenca.setDataHoraCadastro(new java.sql.Date(System.currentTimeMillis()));
			getSession().save(listaPresenca);
		} catch (Exception e) {
			System.out.println("Erro ao Inserir Modulo: " + e.getMessage());
    		throw new Exception("Erro ao Inserir Modulo: " + e.getMessage());
		}
	}
	
	public void update(ListaPresenca listaPresenca) throws Exception {
		try {
			listaPresenca.setDataUltAtualizacao(new java.sql.Date(System.currentTimeMillis()));   
			 getSession().merge(listaPresenca);
			} catch (Exception e) {
	    		throw new Exception("Erro ao Atualizar Modulo: " + e.getMessage());
			}
	}
	
	public ListaPresenca findById(ListaPresenca listaPresenca){
		return (ListaPresenca) getSession().get(ListaPresenca.class, listaPresenca);	
	}
	
	@SuppressWarnings("unchecked")
	public List<ListaPresenca> findAll(){
		return getSession().createCriteria(ListaPresenca.class).list();
	}	
	
	@SuppressWarnings("unchecked")
	public List<Object[]> findByListaPresenca(int idturma, int iddisciplina, String dataaula,String matricula) {
		String sql = " select k.matricula, (select nome from pessoa where idpessoa = k.idpessoa) as nome_aluno ";
		sql+=" ,a.descricao, e.nome, h.data_aula, hora_inicio, hora_fim, a.idturma,e.iddisciplina,p.matricula_professor, h.idaulas ";
		sql+=" from aluno k  ";
		sql+=" inner join turma a on k.idturma = a.idturma ";
		sql+=" inner join curso b on a.idcurso= b.idcurso ";
		sql+=" inner join modulo c on b.idcurso = c.idcurso ";
		sql+=" inner join modulodisciplina d on c.idmodulo =  d.idmodulo ";
		sql+=" inner join disciplina e on e.iddisciplina = d.iddisciplina ";
		sql+=" inner join auladisciplina t on e.iddisciplina = t.iddisciplina  ";
		sql+=" inner join aulas h on h.idaulas = t.idaulas  ";
		sql+=" inner join alocacao p on p.idaulas = h.idaulas ";
		sql+=" where a.idturma =:turma";
		sql+=" and e.iddisciplina =:disciplina  ";
		sql+=" and h.data_aula =:dataula";
		sql+=" and p.matricula_professor =:matricula";
		Query q = getSession().createSQLQuery(sql);
		q.setParameter("turma", idturma);
		q.setParameter("disciplina", iddisciplina);
		q.setParameter("dataula", dataaula);
		q.setParameter("matricula", matricula);
		return q.list();
	}
}
