/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rj.handschool.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "responsaveis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Responsaveis.findAll", query = "SELECT r FROM Responsaveis r"),
    @NamedQuery(name = "Responsaveis.findByNome", query = "SELECT r FROM Responsaveis r WHERE r.nome = :nome"),
    })
public class Responsaveis implements Serializable {
    private static final long serialVersionUID = 1L;
	
    @Basic(optional = false)
    @Column(name = "idresponsaveis")
    private int idresponsaveis;
    
    @Basic(optional = false)
    @Column(name = "id_grauparentesco")
    private int idGrauparentesco;
    
    @Basic(optional = false)
    @Column(name = "grauparentesco")
    private String grauparentesco;
    
    @Column(name = "nome")
    private String nome;
    @JoinColumns({
        @JoinColumn(name = "id_grauparentesco", referencedColumnName = "idgrauparentesco", insertable = false, updatable = false),
        @JoinColumn(name = "grauparentesco", referencedColumnName = "grauparentesco", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Grauparentesco grauparentesco1;
    @JoinColumn(name = "matricula", referencedColumnName = "matricula", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Aluno aluno;

    public Responsaveis() {
    }

	public int getIdresponsaveis() {
		return idresponsaveis;
	}

	public void setIdresponsaveis(int idresponsaveis) {
		this.idresponsaveis = idresponsaveis;
	}

	public int getIdGrauparentesco() {
		return idGrauparentesco;
	}

	public void setIdGrauparentesco(int idGrauparentesco) {
		this.idGrauparentesco = idGrauparentesco;
	}

	public String getGrauparentesco() {
		return grauparentesco;
	}

	public void setGrauparentesco(String grauparentesco) {
		this.grauparentesco = grauparentesco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Grauparentesco getGrauparentesco1() {
		return grauparentesco1;
	}

	public void setGrauparentesco1(Grauparentesco grauparentesco1) {
		this.grauparentesco1 = grauparentesco1;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aluno == null) ? 0 : aluno.hashCode());
		result = prime * result + ((grauparentesco == null) ? 0 : grauparentesco.hashCode());
		result = prime * result + ((grauparentesco1 == null) ? 0 : grauparentesco1.hashCode());
		result = prime * result + idGrauparentesco;
		result = prime * result + idresponsaveis;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Responsaveis other = (Responsaveis) obj;
		if (aluno == null) {
			if (other.aluno != null)
				return false;
		} else if (!aluno.equals(other.aluno))
			return false;
		if (grauparentesco == null) {
			if (other.grauparentesco != null)
				return false;
		} else if (!grauparentesco.equals(other.grauparentesco))
			return false;
		if (grauparentesco1 == null) {
			if (other.grauparentesco1 != null)
				return false;
		} else if (!grauparentesco1.equals(other.grauparentesco1))
			return false;
		if (idGrauparentesco != other.idGrauparentesco)
			return false;
		if (idresponsaveis != other.idresponsaveis)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Responsaveis [idresponsaveis=" + idresponsaveis + ", idGrauparentesco=" + idGrauparentesco
				+ ", grauparentesco=" + grauparentesco + ", nome=" + nome + ", grauparentesco1=" + grauparentesco1
				+ ", aluno=" + aluno + "]";
	}

}
