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
public class ModuloPK implements Serializable {
	private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "idmodulo")
    private int idmodulo;
    @Basic(optional = false)
    @Column(name = "id_disciplina")
    private int idDisciplina;
    @Basic(optional = false)
    @Column(name = "id_curso")
    private int idCurso;

    public ModuloPK() {
    }

    public ModuloPK(int idmodulo, int idDisciplina, int idCurso) {
        this.idmodulo = idmodulo;
        this.idDisciplina = idDisciplina;
        this.idCurso = idCurso;
    }

    public int getIdmodulo() {
        return idmodulo;
    }

    public void setIdmodulo(int idmodulo) {
        this.idmodulo = idmodulo;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idmodulo;
        hash += (int) idDisciplina;
        hash += (int) idCurso;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModuloPK)) {
            return false;
        }
        ModuloPK other = (ModuloPK) object;
        if (this.idmodulo != other.idmodulo) {
            return false;
        }
        if (this.idDisciplina != other.idDisciplina) {
            return false;
        }
        if (this.idCurso != other.idCurso) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rj.handschool.modelo.ModuloPK[ idmodulo=" + idmodulo + ", idDisciplina=" + idDisciplina + ", idCurso=" + idCurso + " ]";
    }
    
}
