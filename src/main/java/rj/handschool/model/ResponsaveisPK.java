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
public class ResponsaveisPK implements Serializable {
	private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "idresponsaveis")
    private int idresponsaveis;
    @Basic(optional = false)
    @Column(name = "aluno_idaluno")
    private int alunoIdaluno;
    @Basic(optional = false)
    @Column(name = "id_grauparentesco")
    private int idGrauparentesco;
    @Basic(optional = false)
    @Column(name = "grauparentesco")
    private String grauparentesco;

    public ResponsaveisPK() {
    }

    public ResponsaveisPK(int idresponsaveis, int alunoIdaluno, int idGrauparentesco, String grauparentesco) {
        this.idresponsaveis = idresponsaveis;
        this.alunoIdaluno = alunoIdaluno;
        this.idGrauparentesco = idGrauparentesco;
        this.grauparentesco = grauparentesco;
    }

    public int getIdresponsaveis() {
        return idresponsaveis;
    }

    public void setIdresponsaveis(int idresponsaveis) {
        this.idresponsaveis = idresponsaveis;
    }

    public int getAlunoIdaluno() {
        return alunoIdaluno;
    }

    public void setAlunoIdaluno(int alunoIdaluno) {
        this.alunoIdaluno = alunoIdaluno;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idresponsaveis;
        hash += (int) alunoIdaluno;
        hash += (int) idGrauparentesco;
        hash += (grauparentesco != null ? grauparentesco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResponsaveisPK)) {
            return false;
        }
        ResponsaveisPK other = (ResponsaveisPK) object;
        if (this.idresponsaveis != other.idresponsaveis) {
            return false;
        }
        if (this.alunoIdaluno != other.alunoIdaluno) {
            return false;
        }
        if (this.idGrauparentesco != other.idGrauparentesco) {
            return false;
        }
        if ((this.grauparentesco == null && other.grauparentesco != null) || (this.grauparentesco != null && !this.grauparentesco.equals(other.grauparentesco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rj.handschool.modelo.ResponsaveisPK[ idresponsaveis=" + idresponsaveis + ", alunoIdaluno=" + alunoIdaluno + ", idGrauparentesco=" + idGrauparentesco + ", grauparentesco=" + grauparentesco + " ]";
    }
    
}
