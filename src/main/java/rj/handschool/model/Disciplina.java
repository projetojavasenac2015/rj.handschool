package rj.handschool.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the disciplina database table.
 * 
 */
@Entity
@NamedQuery(name="Disciplina.findAll", query="SELECT d FROM Disciplina d")
public class Disciplina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int iddisciplina;

	private byte ativo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_HORA_CADASTRO")
	private Date dataHoraCadastro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_ULT_ATUALIZACAO")
	private Date dataUltAtualizacao;

	private String descricao;

	private String ementa;

	private String nome;

	//bi-directional many-to-one association to Aula
	@OneToMany(mappedBy="disciplina")
	private List<Aula> aulas;

	//bi-directional many-to-one association to DisciplinaAluno
	@OneToMany(mappedBy="disciplina")
	private List<DisciplinaAluno> disciplinaAlunos;

	//bi-directional many-to-one association to DisciplinaCurso
	@OneToMany(mappedBy="disciplina")
	private List<DisciplinaCurso> disciplinaCursos;

	//bi-directional many-to-many association to Instrutor
	@ManyToMany(mappedBy="disciplinas")
	private List<Instrutor> instrutors;

	//bi-directional many-to-one association to Nota
	@OneToMany(mappedBy="disciplina")
	private List<Nota> notas;

	public Disciplina() {
	}

	public int getIddisciplina() {
		return this.iddisciplina;
	}

	public void setIddisciplina(int iddisciplina) {
		this.iddisciplina = iddisciplina;
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

	public List<Aula> getAulas() {
		return this.aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}

	public Aula addAula(Aula aula) {
		getAulas().add(aula);
		aula.setDisciplina(this);

		return aula;
	}

	public Aula removeAula(Aula aula) {
		getAulas().remove(aula);
		aula.setDisciplina(null);

		return aula;
	}

	public List<DisciplinaAluno> getDisciplinaAlunos() {
		return this.disciplinaAlunos;
	}

	public void setDisciplinaAlunos(List<DisciplinaAluno> disciplinaAlunos) {
		this.disciplinaAlunos = disciplinaAlunos;
	}

	public DisciplinaAluno addDisciplinaAluno(DisciplinaAluno disciplinaAluno) {
		getDisciplinaAlunos().add(disciplinaAluno);
		disciplinaAluno.setDisciplina(this);

		return disciplinaAluno;
	}

	public DisciplinaAluno removeDisciplinaAluno(DisciplinaAluno disciplinaAluno) {
		getDisciplinaAlunos().remove(disciplinaAluno);
		disciplinaAluno.setDisciplina(null);

		return disciplinaAluno;
	}

	public List<DisciplinaCurso> getDisciplinaCursos() {
		return this.disciplinaCursos;
	}

	public void setDisciplinaCursos(List<DisciplinaCurso> disciplinaCursos) {
		this.disciplinaCursos = disciplinaCursos;
	}

	public DisciplinaCurso addDisciplinaCurso(DisciplinaCurso disciplinaCurso) {
		getDisciplinaCursos().add(disciplinaCurso);
		disciplinaCurso.setDisciplina(this);

		return disciplinaCurso;
	}

	public DisciplinaCurso removeDisciplinaCurso(DisciplinaCurso disciplinaCurso) {
		getDisciplinaCursos().remove(disciplinaCurso);
		disciplinaCurso.setDisciplina(null);

		return disciplinaCurso;
	}

	public List<Instrutor> getInstrutors() {
		return this.instrutors;
	}

	public void setInstrutors(List<Instrutor> instrutors) {
		this.instrutors = instrutors;
	}

	public List<Nota> getNotas() {
		return this.notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	public Nota addNota(Nota nota) {
		getNotas().add(nota);
		nota.setDisciplina(this);

		return nota;
	}

	public Nota removeNota(Nota nota) {
		getNotas().remove(nota);
		nota.setDisciplina(null);

		return nota;
	}

}