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
@Table(name = "quadro_avisos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QuadroAvisos.findAll", query = "SELECT q FROM QuadroAvisos q"),    
    @NamedQuery(name = "QuadroAvisos.findByDataHoraCadastro", query = "SELECT q FROM QuadroAvisos q WHERE q.dataHoraCadastro = :dataHoraCadastro"),
    @NamedQuery(name = "QuadroAvisos.findByAviso", query = "SELECT q FROM QuadroAvisos q WHERE q.aviso = :aviso"),
    })
public class QuadroAvisos implements Serializable {
    private static final long serialVersionUID = 1L;
	
    @Basic(optional = false)
    @Column(name = "idquadro_avisos")
    private int idquadroAvisos;
    
    @Basic(optional = false)
    @Column(name = "matricula_professor")
    private String matricula_professor;
    
    @Basic(optional = false)
    @Column(name = "id_turma")
    private int idTurma;
    
    @Basic(optional = false)
    @Column(name = "idcurso")
    private int idCurso;
    
    @Basic(optional = false)
    @Column(name = "id_disciplina")
    private int idDisciplina;

    
    @Column(name = "data_hora_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraCadastro;
    
    @Column(name = "aviso")
    private String aviso;
    
    @JoinColumn(name = "id_disciplina", referencedColumnName = "iddisciplina", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Disciplina disciplina;
    
    @JoinColumn(name = "id_turma", referencedColumnName = "idturma", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Turma turma;
    
    @JoinColumn(name = "matricula_professor", referencedColumnName = "matricula_professor", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Professor professor;

    public QuadroAvisos() {
    }

	public int getIdquadroAvisos() {
		return idquadroAvisos;
	}

	public void setIdquadroAvisos(int idquadroAvisos) {
		this.idquadroAvisos = idquadroAvisos;
	}

	public String getMatricula_professor() {
		return matricula_professor;
	}

	public void setMatricula_professor(String matricula_professor) {
		this.matricula_professor = matricula_professor;
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

	public Date getDataHoraCadastro() {
		return dataHoraCadastro;
	}

	public void setDataHoraCadastro(Date dataHoraCadastro) {
		this.dataHoraCadastro = dataHoraCadastro;
	}

	public String getAviso() {
		return aviso;
	}

	public void setAviso(String aviso) {
		this.aviso = aviso;
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

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aviso == null) ? 0 : aviso.hashCode());
		result = prime * result + ((dataHoraCadastro == null) ? 0 : dataHoraCadastro.hashCode());
		result = prime * result + ((disciplina == null) ? 0 : disciplina.hashCode());
		result = prime * result + idCurso;
		result = prime * result + idDisciplina;
		result = prime * result + idTurma;
		result = prime * result + idquadroAvisos;
		result = prime * result + ((matricula_professor == null) ? 0 : matricula_professor.hashCode());
		result = prime * result + ((professor == null) ? 0 : professor.hashCode());
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
		QuadroAvisos other = (QuadroAvisos) obj;
		if (aviso == null) {
			if (other.aviso != null)
				return false;
		} else if (!aviso.equals(other.aviso))
			return false;
		if (dataHoraCadastro == null) {
			if (other.dataHoraCadastro != null)
				return false;
		} else if (!dataHoraCadastro.equals(other.dataHoraCadastro))
			return false;
		if (disciplina == null) {
			if (other.disciplina != null)
				return false;
		} else if (!disciplina.equals(other.disciplina))
			return false;
		if (idCurso != other.idCurso)
			return false;
		if (idDisciplina != other.idDisciplina)
			return false;
		if (idTurma != other.idTurma)
			return false;
		if (idquadroAvisos != other.idquadroAvisos)
			return false;
		if (matricula_professor == null) {
			if (other.matricula_professor != null)
				return false;
		} else if (!matricula_professor.equals(other.matricula_professor))
			return false;
		if (professor == null) {
			if (other.professor != null)
				return false;
		} else if (!professor.equals(other.professor))
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
		return "QuadroAvisos [idquadroAvisos=" + idquadroAvisos + ", matricula_professor=" + matricula_professor
				+ ", idTurma=" + idTurma + ", idCurso=" + idCurso + ", idDisciplina=" + idDisciplina
				+ ", dataHoraCadastro=" + dataHoraCadastro + ", aviso=" + aviso + ", disciplina=" + disciplina
				+ ", turma=" + turma + ", professor=" + professor + "]";
	}

}
