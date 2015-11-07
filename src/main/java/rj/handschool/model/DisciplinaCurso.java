package rj.handschool.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the disciplina_curso database table.
 * 
 */
@Entity
@Table(name="disciplina_curso")
@NamedQuery(name="DisciplinaCurso.findAll", query="SELECT d FROM DisciplinaCurso d")
public class DisciplinaCurso implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DisciplinaCursoPK id;

	private byte ativo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_HORA_CADASTRO")
	private Date dataHoraCadastro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_ULT_ATUALIZACAO")
	private Date dataUltAtualizacao;

	//bi-directional many-to-one association to Curso
	@ManyToOne
	@JoinColumn(name="IDCURSO")
	private Curso curso;

	//bi-directional many-to-one association to Disciplina
	@ManyToOne
	@JoinColumn(name="IDDISCIPLINA")
	private Disciplina disciplina;

	public DisciplinaCurso() {
	}

	public DisciplinaCursoPK getId() {
		return this.id;
	}

	public void setId(DisciplinaCursoPK id) {
		this.id = id;
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

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Disciplina getDisciplina() {
		return this.disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

}