package rj.handschool.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the forum database table.
 * 
 */
@Entity
@NamedQuery(name="Forum.findAll", query="SELECT f FROM Forum f")
public class Forum implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idforum;

	private String assunto;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_HORA_CADASTRO")
	private Date dataHoraCadastro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_ULT_ATUALIZACAO")
	private Date dataUltAtualizacao;

	private String descricao;

	private String idcurso;

	//bi-directional many-to-one association to Login
	@ManyToOne
	@JoinColumn(name="IDLOGIN")
	private Login login;

	//bi-directional many-to-one association to ForumComentario
	@OneToMany(mappedBy="forum")
	private List<ForumComentario> forumComentarios;

	public Forum() {
	}

	public int getIdforum() {
		return this.idforum;
	}

	public void setIdforum(int idforum) {
		this.idforum = idforum;
	}

	public String getAssunto() {
		return this.assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public Date getDataHoraCadastro() {
		return this.dataHoraCadastro;
	}

	public void setDataHoraCadastro(Date dataHoraCadastro) {
		this.dataHoraCadastro = dataHoraCadastro;
	}

	public Date getDataUltAtualizacao() {
		return this.dataUltAtualizacao;
	}

	public void setDataUltAtualizacao(Date dataUltAtualizacao) {
		this.dataUltAtualizacao = dataUltAtualizacao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getIdcurso() {
		return this.idcurso;
	}

	public void setIdcurso(String idcurso) {
		this.idcurso = idcurso;
	}

	public Login getLogin() {
		return this.login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public List<ForumComentario> getForumComentarios() {
		return this.forumComentarios;
	}

	public void setForumComentarios(List<ForumComentario> forumComentarios) {
		this.forumComentarios = forumComentarios;
	}

	public ForumComentario addForumComentario(ForumComentario forumComentario) {
		getForumComentarios().add(forumComentario);
		forumComentario.setForum(this);

		return forumComentario;
	}

	public ForumComentario removeForumComentario(ForumComentario forumComentario) {
		getForumComentarios().remove(forumComentario);
		forumComentario.setForum(null);

		return forumComentario;
	}

}