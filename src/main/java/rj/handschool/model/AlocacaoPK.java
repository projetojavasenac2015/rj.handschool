/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rj.handschool.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Renan
 */
@Embeddable
public class AlocacaoPK implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(name = "idalocacao")
    private int idalocacao;
    @Basic(optional = false)
    @Column(name = "id_professor")
    private int idProfessor;
    @Basic(optional = false)
    @Column(name = "id_disciplina")
    private int idDisciplina;

    public AlocacaoPK() {
    }

    public AlocacaoPK(int idalocacao, int idProfessor, int idDisciplina) {
        this.idalocacao = idalocacao;
        this.idProfessor = idProfessor;
        this.idDisciplina = idDisciplina;
    }

    public int getIdalocacao() {
        return idalocacao;
    }

    public void setIdalocacao(int idalocacao) {
        this.idalocacao = idalocacao;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idalocacao;
        hash += (int) idProfessor;
        hash += (int) idDisciplina;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlocacaoPK)) {
            return false;
        }
        AlocacaoPK other = (AlocacaoPK) object;
        if (this.idalocacao != other.idalocacao) {
            return false;
        }
        if (this.idProfessor != other.idProfessor) {
            return false;
        }
        if (this.idDisciplina != other.idDisciplina) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rj.handschool.modelo.AlocacaoPK[ idalocacao=" + idalocacao + ", idProfessor=" + idProfessor + ", idDisciplina=" + idDisciplina + " ]";
    }
    
}
