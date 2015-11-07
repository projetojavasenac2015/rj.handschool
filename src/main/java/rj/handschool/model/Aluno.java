package rj.handschool.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the aluno database table.
 * 
 */
@Entity
@NamedQuery(name="Aluno.findAll", query="SELECT a FROM Aluno a")
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String matricula;

	@Column(name="CARGA_HORARIA_CONCLUIDA")
	private int cargaHorariaConcluida;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_HORA_CADASTRO")
	private Date dataHoraCadastro;

	@Column(name="DESCONTO_TOTAL")
	private double descontoTotal;

	private String status;

	@Column(name="VALOR_CURSO")
	private double valorCurso;

	//bi-directional many-to-one association to Pessoa
	@ManyToOne
	@JoinColumn(name="IDPESSOA")
	private Pessoa pessoa;

	//bi-directional many-to-one association to Turma
	@ManyToOne
	@JoinColumn(name="IDTURMA")
	private Turma turma;

	//bi-directional many-to-one association to DisciplinaAluno
	@OneToMany(mappedBy="aluno")
	private List<DisciplinaAluno> disciplinaAlunos;

	//bi-directional many-to-one association to ListaPresenca
	@OneToMany(mappedBy="aluno")
	private List<ListaPresenca> listaPresencas;

	//bi-directional many-to-one association to Nota
	@OneToMany(mappedBy="aluno")
	private List<Nota> notas;

	//bi-directional many-to-one association to ResponsavelAluno
	@OneToMany(mappedBy="aluno")
	private List<ResponsavelAluno> responsavelAlunos;

	public Aluno() {
	}

	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getCargaHorariaConcluida() {
		return this.cargaHorariaConcluida;
	}

	public void setCargaHorariaConcluida(int cargaHorariaConcluida) {
		this.cargaHorariaConcluida = cargaHorariaConcluida;
	}

	public Date getDataHoraCadastro() {
		return this.dataHoraCadastro;
	}

	public void setDataHoraCadastro(Date dataHoraCadastro) {
		this.dataHoraCadastro = dataHoraCadastro;
	}

	public double getDescontoTotal() {
		return this.descontoTotal;
	}

	public void setDescontoTotal(double descontoTotal) {
		this.descontoTotal = descontoTotal;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getValorCurso() {
		return this.valorCurso;
	}

	public void setValorCurso(double valorCurso) {
		this.valorCurso = valorCurso;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Turma getTurma() {
		return this.turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public List<DisciplinaAluno> getDisciplinaAlunos() {
		return this.disciplinaAlunos;
	}

	public void setDisciplinaAlunos(List<DisciplinaAluno> disciplinaAlunos) {
		this.disciplinaAlunos = disciplinaAlunos;
	}

	public DisciplinaAluno addDisciplinaAluno(DisciplinaAluno disciplinaAluno) {
		getDisciplinaAlunos().add(disciplinaAluno);
		disciplinaAluno.setAluno(this);

		return disciplinaAluno;
	}

	public DisciplinaAluno removeDisciplinaAluno(DisciplinaAluno disciplinaAluno) {
		getDisciplinaAlunos().remove(disciplinaAluno);
		disciplinaAluno.setAluno(null);

		return disciplinaAluno;
	}

	public List<ListaPresenca> getListaPresencas() {
		return this.listaPresencas;
	}

	public void setListaPresencas(List<ListaPresenca> listaPresencas) {
		this.listaPresencas = listaPresencas;
	}

	public ListaPresenca addListaPresenca(ListaPresenca listaPresenca) {
		getListaPresencas().add(listaPresenca);
		listaPresenca.setAluno(this);

		return listaPresenca;
	}

	public ListaPresenca removeListaPresenca(ListaPresenca listaPresenca) {
		getListaPresencas().remove(listaPresenca);
		listaPresenca.setAluno(null);

		return listaPresenca;
	}

	public List<Nota> getNotas() {
		return this.notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	public Nota addNota(Nota nota) {
		getNotas().add(nota);
		nota.setAluno(this);

		return nota;
	}

	public Nota removeNota(Nota nota) {
		getNotas().remove(nota);
		nota.setAluno(null);

		return nota;
	}

	public List<ResponsavelAluno> getResponsavelAlunos() {
		return this.responsavelAlunos;
	}

	public void setResponsavelAlunos(List<ResponsavelAluno> responsavelAlunos) {
		this.responsavelAlunos = responsavelAlunos;
	}

	public ResponsavelAluno addResponsavelAluno(ResponsavelAluno responsavelAluno) {
		getResponsavelAlunos().add(responsavelAluno);
		responsavelAluno.setAluno(this);

		return responsavelAluno;
	}

	public ResponsavelAluno removeResponsavelAluno(ResponsavelAluno responsavelAluno) {
		getResponsavelAlunos().remove(responsavelAluno);
		responsavelAluno.setAluno(null);

		return responsavelAluno;
	}

}