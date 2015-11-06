package rj.handschool.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the aulas database table.
 * 
 */
@Entity
@Table(name="aulas")
@NamedQuery(name="Aula.findAll", query="SELECT a FROM Aula a")
public class Aula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idaulas;

	private String data;

	@Column(name="HORARIO_INICIO")
	private String horarioInicio;

	@Column(name="HORARIO_TERMINO")
	private String horarioTermino;

	private String status;

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

	//bi-directional many-to-one association to ListaPresenca
	@OneToMany(mappedBy="aula")
	private List<ListaPresenca> listaPresencas;

	public Aula() {
	}

	public int getIdaulas() {
		return this.idaulas;
	}

	public void setIdaulas(int idaulas) {
		this.idaulas = idaulas;
	}

	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHorarioInicio() {
		return this.horarioInicio;
	}

	public void setHorarioInicio(String horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public String getHorarioTermino() {
		return this.horarioTermino;
	}

	public void setHorarioTermino(String horarioTermino) {
		this.horarioTermino = horarioTermino;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public List<ListaPresenca> getListaPresencas() {
		return this.listaPresencas;
	}

	public void setListaPresencas(List<ListaPresenca> listaPresencas) {
		this.listaPresencas = listaPresencas;
	}

	public ListaPresenca addListaPresenca(ListaPresenca listaPresenca) {
		getListaPresencas().add(listaPresenca);
		listaPresenca.setAula(this);

		return listaPresenca;
	}

	public ListaPresenca removeListaPresenca(ListaPresenca listaPresenca) {
		getListaPresencas().remove(listaPresenca);
		listaPresenca.setAula(null);

		return listaPresenca;
	}

}