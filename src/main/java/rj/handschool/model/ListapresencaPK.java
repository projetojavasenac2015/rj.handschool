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
public class ListapresencaPK implements Serializable {
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
    
    public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public ListapresencaPK() {
    }

    public ListapresencaPK(int idlistapresenca, int idTurma, int idCurso, int idDisciplina, int idAulas, String matricula) {
        this.idlistapresenca = idlistapresenca;
        this.idTurma = idTurma;
        this.idCurso = idCurso;
        this.idDisciplina = idDisciplina;
        this.idAulas = idAulas;
        this.matricula = matricula;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idlistapresenca;
        hash += (int) idTurma;
        hash += (int) idCurso;
        hash += (int) idDisciplina;
        hash += (int) idAulas;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // 
        if (!(object instanceof ListapresencaPK)) {
            return false;
        }
        ListapresencaPK other = (ListapresencaPK) object;
        if (this.idlistapresenca != other.idlistapresenca) {
            return false;
        }
        if (this.idTurma != other.idTurma) {
            return false;
        }
        if (this.idCurso != other.idCurso) {
            return false;
        }
        if (this.idDisciplina != other.idDisciplina) {
            return false;
        }
        if (this.idAulas != other.idAulas) {
            return false;
        }
        
        if (this.matricula != other.matricula) {
            return false;
        }
        return true;
    }
}
