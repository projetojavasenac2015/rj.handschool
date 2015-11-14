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
public class DisciplinaCursoPK implements Serializable {
	private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "idcurso")
    private int idcurso;
    @Basic(optional = false)
    @Column(name = "iddisciplina")
    private int iddisciplina;

    public DisciplinaCursoPK() {
    }

    public DisciplinaCursoPK(int idcurso, int iddisciplina) {
        this.idcurso = idcurso;
        this.iddisciplina = iddisciplina;
    }

    public int getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }

    public int getIddisciplina() {
        return iddisciplina;
    }

    public void setIddisciplina(int iddisciplina) {
        this.iddisciplina = iddisciplina;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idcurso;
        hash += (int) iddisciplina;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DisciplinaCursoPK)) {
            return false;
        }
        DisciplinaCursoPK other = (DisciplinaCursoPK) object;
        if (this.idcurso != other.idcurso) {
            return false;
        }
        if (this.iddisciplina != other.iddisciplina) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bd.DisciplinaCursoPK[ idcurso=" + idcurso + ", iddisciplina=" + iddisciplina + " ]";
    }
    
}
