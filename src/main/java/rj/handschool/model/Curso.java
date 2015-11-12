package rj.handschool.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the curso database table.
 * 
 */
@Entity
@NamedQuery(name="Curso.findAll", query="SELECT c FROM Curso c")
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idcurso;

	//private boolean ativo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_HORA_CADASTRO")
	private Date dataHoraCadastro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_ULT_ATUALIZACAO")
	private Date dataUltAtualizacao;

	private String descricao;

	private String ementa;

	private String nome;

	//bi-directional many-to-one association to DisciplinaCurso
	@OneToMany(mappedBy="curso")
	private List<DisciplinaCurso> disciplinaCursos;

	//bi-directional many-to-one association to Turma
	@OneToMany(mappedBy="curso")
	private List<Turma> turmas;

	public Curso() {
	}

	public int getIdcurso() {
		return this.idcurso;
	}

	public void setIdcurso(int idcurso) {
		this.idcurso = idcurso;
	}

	//public boolean getAtivo() {
	//	return this.ativo;
	//}

	//public void setAtivo(boolean ativo) {
	///	this.ativo = ativo;
	//}

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

	public String getEmenta() {
		return this.ementa;
	}

	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<DisciplinaCurso> getDisciplinaCursos() {
		return this.disciplinaCursos;
	}

	public void setDisciplinaCursos(List<DisciplinaCurso> disciplinaCursos) {
		this.disciplinaCursos = disciplinaCursos;
	}

	public DisciplinaCurso addDisciplinaCurso(DisciplinaCurso disciplinaCurso) {
		getDisciplinaCursos().add(disciplinaCurso);
		disciplinaCurso.setCurso(this);

		return disciplinaCurso;
	}

	public DisciplinaCurso removeDisciplinaCurso(DisciplinaCurso disciplinaCurso) {
		getDisciplinaCursos().remove(disciplinaCurso);
		disciplinaCurso.setCurso(null);

		return disciplinaCurso;
	}

	public List<Turma> getTurmas() {
		return this.turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public Turma addTurma(Turma turma) {
		getTurmas().add(turma);
		turma.setCurso(this);

		return turma;
	}

	public Turma removeTurma(Turma turma) {
		getTurmas().remove(turma);
		turma.setCurso(null);

		return turma;
	}

}