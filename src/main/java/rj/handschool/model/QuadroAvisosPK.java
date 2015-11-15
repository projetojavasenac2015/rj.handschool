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
public class QuadroAvisosPK implements Serializable {
	private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "idquadro_avisos")
    private int idquadroAvisos;
    @Basic(optional = false)
    @Column(name = "id_professor")
    private int idProfessor;
    @Basic(optional = false)
    @Column(name = "id_turma")
    private int idTurma;
    @Basic(optional = false)
    @Column(name = "id_curso")
    private int idCurso;
    @Basic(optional = false)
    @Column(name = "id_disciplina")
    private int idDisciplina;

    public QuadroAvisosPK() {
    }

    public QuadroAvisosPK(int idquadroAvisos, int idProfessor, int idTurma, int idCurso, int idDisciplina) {
        this.idquadroAvisos = idquadroAvisos;
        this.idProfessor = idProfessor;
        this.idTurma = idTurma;
        this.idCurso = idCurso;
        this.idDisciplina = idDisciplina;
    }

    public int getIdquadroAvisos() {
        return idquadroAvisos;
    }

    public void setIdquadroAvisos(int idquadroAvisos) {
        this.idquadroAvisos = idquadroAvisos;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idquadroAvisos;
        hash += (int) idProfessor;
        hash += (int) idTurma;
        hash += (int) idCurso;
        hash += (int) idDisciplina;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuadroAvisosPK)) {
            return false;
        }
        QuadroAvisosPK other = (QuadroAvisosPK) object;
        if (this.idquadroAvisos != other.idquadroAvisos) {
            return false;
        }
        if (this.idProfessor != other.idProfessor) {
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
        return true;
    }

    @Override
    public String toString() {
        return "rj.handschool.modelo.QuadroAvisosPK[ idquadroAvisos=" + idquadroAvisos + ", idProfessor=" + idProfessor + ", idTurma=" + idTurma + ", idCurso=" + idCurso + ", idDisciplina=" + idDisciplina + " ]";
    }
    
}
