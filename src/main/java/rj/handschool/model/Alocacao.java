/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rj.handschool.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Renan
 */
@Entity
@Table(name = "alocacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alocacao.findAll", query = "SELECT a FROM Alocacao a"),
    @NamedQuery(name = "Alocacao.findByIdalocacao", query = "SELECT a FROM Alocacao a WHERE a.idalocacao = :idalocacao"),
    @NamedQuery(name = "Alocacao.findByDataHoraCadastro", query = "SELECT a FROM Alocacao a WHERE a.dataHoraCadastro = :dataHoraCadastro")
    })
public class Alocacao implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "idalocacao")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idalocacao;
  
	@Column(name = "data_hora_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraCadastro;
	    
    @JoinColumn(name = "idaulas", referencedColumnName = "idaulas")
    @ManyToOne(optional = false)
    private Aulas aula;
    
    @Transient
    private Disciplina listadisciplinas;
    				   
    @JoinColumn(name = "matricula_professor", referencedColumnName = "matricula_professor")
    @ManyToOne(optional = false)
    private Professor professor;

    public Alocacao() {
    }
   
    public Alocacao(int idalocacao) {
    	this.idalocacao = idalocacao;
    }
    
    public Alocacao(String matricula_prof, int iddisciplina) {
    	this.professor = new Professor(matricula_prof);
    	this.listadisciplinas =  new Disciplina(iddisciplina);
    }
    
    public Alocacao(Professor prof, Aulas aula) {
    	this.professor = prof;
    	this.aula =  aula;
    }
    
    public int getIdalocacao() {
  		return idalocacao;
  	}

  	public void setIdalocacao(int idalocacao) {
  		this.idalocacao = idalocacao;
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
		result = prime * result + idalocacao;
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
		if (idalocacao != other.idalocacao)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Alocacao [idalocacao=" + idalocacao + ", dataHoraCadastro="
				+ dataHoraCadastro + ", listadisciplinas=" + listadisciplinas
				+ ", professor=" + professor + "]";
	}
    
}
