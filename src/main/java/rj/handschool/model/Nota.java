package rj.handschool.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the notas database table.
 * 
 */
@Entity
@Table(name="notas")
@NamedQuery(name="Nota.findAll", query="SELECT n FROM Nota n")
public class Nota implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idnota;

	@Column(name="ANO_VIGENTE")
	private int anoVigente;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_HORA_CADASTRO")
	private Date dataHoraCadastro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_ULT_ATUALIZACAO")
	private Date dataUltAtualizacao;

	private double valor;

	//bi-directional many-to-one association to Aluno
	@ManyToOne
	@JoinColumn(name="MATRICULA_ALUNO")
	private Aluno aluno;

	//bi-directional many-to-one association to Turma
	@ManyToOne
	@JoinColumn(name="IDTURMA")
	private Turma turma;

	//bi-directional many-to-one association to Disciplina
	@ManyToOne
	@JoinColumn(name="IDDISCIPLINA")
	private Disciplina disciplina;

	//bi-directional many-to-one association to Instrutor
	@ManyToOne
	@JoinColumn(name="MATRICULA")
	private Instrutor instrutor;

	//bi-directional many-to-one association to TipoAvaliacao
	@ManyToOne
	@JoinColumn(name="IDTIPO_AVALIACAO")
	private TipoAvaliacao tipoAvaliacao;

	public Nota() {
	}

	public int getIdnota() {
		return this.idnota;
	}

	public void setIdnota(int idnota) {
		this.idnota = idnota;
	}

	public int getAnoVigente() {
		return this.anoVigente;
	}

	public void setAnoVigente(int anoVigente) {
		this.anoVigente = anoVigente;
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

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Aluno getAluno() {
		return this.aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Turma getTurma() {
		return this.turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Disciplina getDisciplina() {
		return this.disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Instrutor getInstrutor() {
		return this.instrutor;
	}

	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}

	public TipoAvaliacao getTipoAvaliacao() {
		return this.tipoAvaliacao;
	}

	public void setTipoAvaliacao(TipoAvaliacao tipoAvaliacao) {
		this.tipoAvaliacao = tipoAvaliacao;
	}

}