package rj.handschool.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the disciplina_aluno database table.
 * 
 */
@Entity
@Table(name="disciplina_aluno")
@NamedQuery(name="DisciplinaAluno.findAll", query="SELECT d FROM DisciplinaAluno d")
public class DisciplinaAluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DisciplinaAlunoPK id;

	private String status;

	//bi-directional many-to-one association to Aluno
	@ManyToOne
	@JoinColumn(name="MATRICULA")
	private Aluno aluno;

	//bi-directional many-to-one association to Disciplina
	@ManyToOne
	@JoinColumn(name="IDDISCIPLINA")
	private Disciplina disciplina;

	public DisciplinaAluno() {
	}

	public DisciplinaAlunoPK getId() {
		return this.id;
	}

	public void setId(DisciplinaAlunoPK id) {
		this.id = id;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Aluno getAluno() {
		return this.aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Disciplina getDisciplina() {
		return this.disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

}