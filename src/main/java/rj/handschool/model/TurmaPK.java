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
public class TurmaPK implements Serializable {
	private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "idturma")
    private int idturma;
    @Basic(optional = false)
    @Column(name = "idcurso")
    private int idCurso;

    public TurmaPK() {
    }

    public TurmaPK(int idturma, int idCurso) {
        this.idturma = idturma;
        this.idCurso = idCurso;
    }

    public int getIdturma() {
        return idturma;
    }

    public void setIdturma(int idturma) {
        this.idturma = idturma;
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
        hash += (int) idturma;
        hash += (int) idCurso;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TurmaPK)) {
            return false;
        }
        TurmaPK other = (TurmaPK) object;
        if (this.idturma != other.idturma) {
            return false;
        }
        if (this.idCurso != other.idCurso) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rj.handschool.modelo.TurmaPK[ idturma=" + idturma + ", idCurso=" + idCurso + " ]";
    }
    
}
