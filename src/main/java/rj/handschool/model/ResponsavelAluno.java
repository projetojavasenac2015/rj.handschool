package rj.handschool.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the responsavel_aluno database table.
 * 
 */
@Entity
@Table(name="responsavel_aluno")
@NamedQuery(name="ResponsavelAluno.findAll", query="SELECT r FROM ResponsavelAluno r")
public class ResponsavelAluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idrespaluno;

	private String nome;

	private String parentesco;

	//bi-directional many-to-one association to Aluno
	@ManyToOne
	@JoinColumn(name="MATRICULA")
	private Aluno aluno;

	public ResponsavelAluno() {
	}

	public int getIdrespaluno() {
		return this.idrespaluno;
	}

	public void setIdrespaluno(int idrespaluno) {
		this.idrespaluno = idrespaluno;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getParentesco() {
		return this.parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public Aluno getAluno() {
		return this.aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}