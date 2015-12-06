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
@Table(name = "alocacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alocacao.findAll", query = "SELECT a FROM Alocacao a"),    
    @NamedQuery(name = "Alocacao.findByDataHoraCadastro", query = "SELECT a FROM Alocacao a WHERE a.dataHoraCadastro = :dataHoraCadastro"),
    })
public class Alocacao implements Serializable {
    private static final long serialVersionUID = 1L;

	@Basic(optional = false)
    @Column(name = "idalocacao")
    private int idalocacao;
	
    @Basic(optional = false)
    @Column(name = "matricula_professor")
    private String matricula_professor;
    
    @Basic(optional = false)
    @Column(name = "id_disciplina")
    private int idDisciplina;
    
    @Column(name = "data_hora_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraCadastro;
    
    @JoinColumn(name = "id_disciplina", referencedColumnName = "iddisciplina", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Disciplina listadisciplinas;
    				   
    @JoinColumn(name = "matricula_professor", referencedColumnName = "matricula_professor", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Professor professor;

    public Alocacao() {
    }

	public int getIdalocacao() {
		return idalocacao;
	}

	public void setIdalocacao(int idalocacao) {
		this.idalocacao = idalocacao;
	}

	public String getMatricula_professor() {
		return matricula_professor;
	}

	public void setMatricula_professor(String matricula_professor) {
		this.matricula_professor = matricula_professor;
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

	public Disciplina getListadisciplinas() {
		return listadisciplinas;
	}

	public void setListadisciplinas(Disciplina listadisciplinas) {
		this.listadisciplinas = listadisciplinas;
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
		result = prime * result + ((dataHoraCadastro == null) ? 0 : dataHoraCadastro.hashCode());
		result = prime * result + idDisciplina;
		result = prime * result + idalocacao;
		result = prime * result + ((listadisciplinas == null) ? 0 : listadisciplinas.hashCode());
		result = prime * result + ((matricula_professor == null) ? 0 : matricula_professor.hashCode());
		result = prime * result + ((professor == null) ? 0 : professor.hashCode());
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
		Alocacao other = (Alocacao) obj;
		if (dataHoraCadastro == null) {
			if (other.dataHoraCadastro != null)
				return false;
		} else if (!dataHoraCadastro.equals(other.dataHoraCadastro))
			return false;
		if (idDisciplina != other.idDisciplina)
			return false;
		if (idalocacao != other.idalocacao)
			return false;
		if (listadisciplinas == null) {
			if (other.listadisciplinas != null)
				return false;
		} else if (!listadisciplinas.equals(other.listadisciplinas))
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
		return true;
	}

	@Override
	public String toString() {
		return "Alocacao [idalocacao=" + idalocacao + ", matricula_professor=" + matricula_professor + ", idDisciplina="
				+ idDisciplina + ", dataHoraCadastro=" + dataHoraCadastro + ", listadisciplinas=" + listadisciplinas
				+ ", professor=" + professor + "]";
	}

}
