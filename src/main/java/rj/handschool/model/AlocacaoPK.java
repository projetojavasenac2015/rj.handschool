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
    @Column(name = "matricula_professor")
    private String matricula_professor;
    @Basic(optional = false)
    @Column(name = "id_disciplina")
    private int idDisciplina;

    public AlocacaoPK() {
    }

    public AlocacaoPK(int idalocacao, String matricula_professor, int idDisciplina) {
        this.idalocacao = idalocacao;
        this.matricula_professor = matricula_professor;
        this.idDisciplina = idDisciplina;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idalocacao;
        hash += (int) idDisciplina;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // 
        if (!(object instanceof AlocacaoPK)) {
            return false;
        }
        AlocacaoPK other = (AlocacaoPK) object;
        if (this.idalocacao != other.idalocacao) {
            return false;
        }
        if (this.matricula_professor != other.matricula_professor) {
            return false;
        }
        if (this.idDisciplina != other.idDisciplina) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rj.handschool.modelo.AlocacaoPK[ idalocacao=" + idalocacao + ", matricula_professor=" + matricula_professor + ", idDisciplina=" + idDisciplina + " ]";
    }
    
}
