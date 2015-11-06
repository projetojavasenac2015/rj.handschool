package rj.handschool.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the login database table.
 * 
 */
@Entity
@NamedQuery(name="Login.findAll", query="SELECT l FROM Login l")
public class Login implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idlogin;

	private byte ativo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_HORA_CADASTRO")
	private Date dataHoraCadastro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_ULT_ATUALIZACAO")
	private Date dataUltAtualizacao;

	private String email;

	private String matricula;

	private String senha;

	//bi-directional many-to-one association to Forum
	@OneToMany(mappedBy="login")
	private List<Forum> forums;

	//bi-directional many-to-one association to ForumComentario
	@OneToMany(mappedBy="login")
	private List<ForumComentario> forumComentarios;

	//bi-directional many-to-one association to Pessoa
	@ManyToOne
	@JoinColumn(name="IDPESSOA")
	private Pessoa pessoa;

	//bi-directional many-to-one association to Perfil
	@ManyToOne
	@JoinColumn(name="IDPERFIL")
	private Perfil perfil;

	public Login() {
	}

	public int getIdlogin() {
		return this.idlogin;
	}

	public void setIdlogin(int idlogin) {
		this.idlogin = idlogin;
	}

	public byte getAtivo() {
		return this.ativo;
	}

	public void setAtivo(byte ativo) {
		this.ativo = ativo;
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Forum> getForums() {
		return this.forums;
	}

	public void setForums(List<Forum> forums) {
		this.forums = forums;
	}

	public Forum addForum(Forum forum) {
		getForums().add(forum);
		forum.setLogin(this);

		return forum;
	}

	public Forum removeForum(Forum forum) {
		getForums().remove(forum);
		forum.setLogin(null);

		return forum;
	}

	public List<ForumComentario> getForumComentarios() {
		return this.forumComentarios;
	}

	public void setForumComentarios(List<ForumComentario> forumComentarios) {
		this.forumComentarios = forumComentarios;
	}

	public ForumComentario addForumComentario(ForumComentario forumComentario) {
		getForumComentarios().add(forumComentario);
		forumComentario.setLogin(this);

		return forumComentario;
	}

	public ForumComentario removeForumComentario(ForumComentario forumComentario) {
		getForumComentarios().remove(forumComentario);
		forumComentario.setLogin(null);

		return forumComentario;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

}