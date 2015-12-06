/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rj.handschool.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "Listapresenca")
@XmlRootElement
public class ListaPresenca implements Serializable {
    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @Column(name = "idlistapresenca")
    private int idlistapresenca;
    
    @Basic(optional = false)
    @Column(name = "id_turma")
    private int idTurma;
    
    @Basic(optional = false)
    @Column(name = "idcurso")
    private int idCurso;
    
    @Basic(optional = false)
    @Column(name = "id_disciplina")
    private int idDisciplina;
    
    @Basic(optional = false)
    @Column(name = "id_aulas")
    private int idAulas;
    
    @Basic(optional = false)
    @Column(name = "matricula")
    private String matricula;
  
    
    @Column(name = "data_hora_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraCadastro;
    
    @Column(name = "data_ult_atualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltAtualizacao;
    
    @JoinColumn(name = "matricula", referencedColumnName = "matricula", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Aluno aluno;
    
    @JoinColumn(name = "id_aulas", referencedColumnName = "idaulas", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Aulas aulas;
    
    @JoinColumn(name = "id_disciplina", referencedColumnName = "iddisciplina", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Disciplina disciplina;
    
    @JoinColumn(name = "id_turma", referencedColumnName = "idturma", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Turma turma;

    public ListaPresenca() {
    }

	public int getIdlistapresenca() {
		return idlistapresenca;
	}

	public void setIdlistapresenca(int idlistapresenca) {
		this.idlistapresenca = idlistapresenca;
	}

	public int getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public int getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public int getIdAulas() {
		return idAulas;
	}

	public void setIdAulas(int idAulas) {
		this.idAulas = idAulas;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Date getDataHoraCadastro() {
		return dataHoraCadastro;
	}

	public void setDataHoraCadastro(Date dataHoraCadastro) {
		this.dataHoraCadastro = dataHoraCadastro;
	}

	public Date getDataUltAtualizacao() {
		return dataUltAtualizacao;
	}

	public void setDataUltAtualizacao(Date dataUltAtualizacao) {
		this.dataUltAtualizacao = dataUltAtualizacao;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Aulas getAulas() {
		return aulas;
	}

	public void setAulas(Aulas aulas) {
		this.aulas = aulas;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aluno == null) ? 0 : aluno.hashCode());
		result = prime * result + ((aulas == null) ? 0 : aulas.hashCode());
		result = prime * result + ((dataHoraCadastro == null) ? 0 : dataHoraCadastro.hashCode());
		result = prime * result + ((dataUltAtualizacao == null) ? 0 : dataUltAtualizacao.hashCode());
		result = prime * result + ((disciplina == null) ? 0 : disciplina.hashCode());
		result = prime * result + idAulas;
		result = prime * result + idCurso;
		result = prime * result + idDisciplina;
		result = prime * result + idTurma;
		result = prime * result + idlistapresenca;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((turma == null) ? 0 : turma.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListaPresenca other = (ListaPresenca) obj;
		if (aluno == null) {
			if (other.aluno != null)
				return false;
		} else if (!aluno.equals(other.aluno))
			return false;
		if (aulas == null) {
			if (other.aulas != null)
				return false;
		} else if (!aulas.equals(other.aulas))
			return false;
		if (dataHoraCadastro == null) {
			if (other.dataHoraCadastro != null)
				return false;
		} else if (!dataHoraCadastro.equals(other.dataHoraCadastro))
			return false;
		if (dataUltAtualizacao == null) {
			if (other.dataUltAtualizacao != null)
				return false;
		} else if (!dataUltAtualizacao.equals(other.dataUltAtualizacao))
			return false;
		if (disciplina == null) {
			if (other.disciplina != null)
				return false;
		} else if (!disciplina.equals(other.disciplina))
			return false;
		if (idAulas != other.idAulas)
			return false;
		if (idCurso != other.idCurso)
			return false;
		if (idDisciplina != other.idDisciplina)
			return false;
		if (idTurma != other.idTurma)
			return false;
		if (idlistapresenca != other.idlistapresenca)
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		if (turma == null) {
			if (other.turma != null)
				return false;
		} else if (!turma.equals(other.turma))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ListaPresenca [idlistapresenca=" + idlistapresenca + ", idTurma=" + idTurma + ", idCurso=" + idCurso
				+ ", idDisciplina=" + idDisciplina + ", idAulas=" + idAulas + ", matricula=" + matricula
				+ ", dataHoraCadastro=" + dataHoraCadastro + ", dataUltAtualizacao=" + dataUltAtualizacao + ", aluno="
				+ aluno + ", aulas=" + aulas + ", disciplina=" + disciplina + ", turma=" + turma + "]";
	}

    
}
