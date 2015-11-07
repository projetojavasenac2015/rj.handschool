package rj.handschool.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the lista_presenca database table.
 * 
 */
@Entity
@Table(name="lista_presenca")
@NamedQuery(name="ListaPresenca.findAll", query="SELECT l FROM ListaPresenca l")
public class ListaPresenca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="IDLISTA_PRESENCA")
	private int idlistaPresenca;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_HORA_CADASTRO")
	private Date dataHoraCadastro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_ULT_ATUALIZACAO")
	private Date dataUltAtualizacao;

	//bi-directional many-to-one association to Aluno
	@ManyToOne
	@JoinColumn(name="MATRICULA")
	private Aluno aluno;

	//bi-directional many-to-one association to TipoRegistro
	@ManyToOne
	@JoinColumn(name="IDTIPO_REGISTRO")
	private TipoRegistro tipoRegistro;

	//bi-directional many-to-one association to Aula
	@ManyToOne
	@JoinColumn(name="IDAULAS")
	private Aula aula;

	public ListaPresenca() {
	}

	public int getIdlistaPresenca() {
		return this.idlistaPresenca;
	}

	public void setIdlistaPresenca(int idlistaPresenca) {
		this.idlistaPresenca = idlistaPresenca;
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

	public Aluno getAluno() {
		return this.aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public TipoRegistro getTipoRegistro() {
		return this.tipoRegistro;
	}

	public void setTipoRegistro(TipoRegistro tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}

	public Aula getAula() {
		return this.aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

}