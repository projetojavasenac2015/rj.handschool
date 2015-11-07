package rj.handschool.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the forum_comentario database table.
 * 
 */
@Entity
@Table(name="forum_comentario")
@NamedQuery(name="ForumComentario.findAll", query="SELECT f FROM ForumComentario f")
public class ForumComentario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="IDFORUM_COMENTARIO")
	private int idforumComentario;

	private byte ativo;

	private String comentario;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_HORA_CADASTRO")
	private Date dataHoraCadastro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_ULT_ATUALIZACAO")
	private Date dataUltAtualizacao;

	//bi-directional many-to-one association to Login
	@ManyToOne
	@JoinColumn(name="IDLOGIN")
	private Login login;

	//bi-directional many-to-one association to Forum
	@ManyToOne
	@JoinColumn(name="IDFORUM")
	private Forum forum;

	public ForumComentario() {
	}

	public int getIdforumComentario() {
		return this.idforumComentario;
	}

	public void setIdforumComentario(int idforumComentario) {
		this.idforumComentario = idforumComentario;
	}

	public byte getAtivo() {
		return this.ativo;
	}

	public void setAtivo(byte ativo) {
		this.ativo = ativo;
	}

	public String getComentario() {
		return this.comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
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

	public Login getLogin() {
		return this.login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Forum getForum() {
		return this.forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}

}