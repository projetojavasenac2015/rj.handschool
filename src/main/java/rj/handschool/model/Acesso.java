package rj.handschool.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the acesso database table.
 * 
 */
@Entity
@NamedQuery(name="Acesso.findAll", query="SELECT a FROM Acesso a")
public class Acesso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idacesso;

	private byte ativo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_HORA_CADASTRO")
	private Date dataHoraCadastro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_ULT_ATUALIZACAO")
	private Date dataUltAtualizacao;

	private String nome;

	private String url;

	//bi-directional many-to-one association to Perfil
	@ManyToOne
	@JoinColumn(name="IDPERFIL")
	private Perfil perfil;

	public Acesso() {
	}

	public int getIdacesso() {
		return this.idacesso;
	}

	public void setIdacesso(int idacesso) {
		this.idacesso = idacesso;
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

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

}