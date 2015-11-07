package rj.handschool.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tipo_avaliacao database table.
 * 
 */
@Entity
@Table(name="tipo_avaliacao")
@NamedQuery(name="TipoAvaliacao.findAll", query="SELECT t FROM TipoAvaliacao t")
public class TipoAvaliacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="IDTIPO_AVALIACAO")
	private int idtipoAvaliacao;

	private byte ativo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_HORA_CADASTRO")
	private Date dataHoraCadastro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_ULT_ATUALIZACAO")
	private Date dataUltAtualizacao;

	private String nome;

	//bi-directional many-to-one association to Nota
	@OneToMany(mappedBy="tipoAvaliacao")
	private List<Nota> notas;

	public TipoAvaliacao() {
	}

	public int getIdtipoAvaliacao() {
		return this.idtipoAvaliacao;
	}

	public void setIdtipoAvaliacao(int idtipoAvaliacao) {
		this.idtipoAvaliacao = idtipoAvaliacao;
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

	public List<Nota> getNotas() {
		return this.notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	public Nota addNota(Nota nota) {
		getNotas().add(nota);
		nota.setTipoAvaliacao(this);

		return nota;
	}

	public Nota removeNota(Nota nota) {
		getNotas().remove(nota);
		nota.setTipoAvaliacao(null);

		return nota;
	}

}