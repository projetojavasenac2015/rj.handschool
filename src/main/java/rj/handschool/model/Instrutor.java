package rj.handschool.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the instrutor database table.
 * 
 */
@Entity
@NamedQuery(name="Instrutor.findAll", query="SELECT i FROM Instrutor i")
public class Instrutor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String matricula;

	private byte ativo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_HORA_CADASTRO")
	private Date dataHoraCadastro;

	//bi-directional many-to-one association to Aula
	@OneToMany(mappedBy="instrutor")
	private List<Aula> aulas;

	//bi-directional many-to-one association to Pessoa
	@ManyToOne
	@JoinColumn(name="IDPESSOA")
	private Pessoa pessoa;

	//bi-directional many-to-many association to Disciplina
	@ManyToMany
	@JoinTable(
		name="instrutor_disciplina"
		, joinColumns={
			@JoinColumn(name="MATRICULA")
			}
		, inverseJoinColumns={
			@JoinColumn(name="IDDISCIPLINA")
			}
		)
	private List<Disciplina> disciplinas;

	//bi-directional many-to-one association to Nota
	@OneToMany(mappedBy="instrutor")
	private List<Nota> notas;

	public Instrutor() {
	}

	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
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

	public List<Aula> getAulas() {
		return this.aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}

	public Aula addAula(Aula aula) {
		getAulas().add(aula);
		aula.setInstrutor(this);

		return aula;
	}

	public Aula removeAula(Aula aula) {
		getAulas().remove(aula);
		aula.setInstrutor(null);

		return aula;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Disciplina> getDisciplinas() {
		return this.disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public List<Nota> getNotas() {
		return this.notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	public Nota addNota(Nota nota) {
		getNotas().add(nota);
		nota.setInstrutor(this);

		return nota;
	}

	public Nota removeNota(Nota nota) {
		getNotas().remove(nota);
		nota.setInstrutor(null);

		return nota;
	}

}