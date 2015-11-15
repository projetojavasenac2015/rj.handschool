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
public class GrauparentescoPK implements Serializable {
	private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "idgrauparentesco")
    private int idgrauparentesco;
    @Basic(optional = false)
    @Column(name = "grauparentesco")
    private String grauparentesco;

    public GrauparentescoPK() {
    }

    public GrauparentescoPK(int idgrauparentesco, String grauparentesco) {
        this.idgrauparentesco = idgrauparentesco;
        this.grauparentesco = grauparentesco;
    }

    public int getIdgrauparentesco() {
        return idgrauparentesco;
    }

    public void setIdgrauparentesco(int idgrauparentesco) {
        this.idgrauparentesco = idgrauparentesco;
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
        hash += (int) idgrauparentesco;
        hash += (grauparentesco != null ? grauparentesco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrauparentescoPK)) {
            return false;
        }
        GrauparentescoPK other = (GrauparentescoPK) object;
        if (this.idgrauparentesco != other.idgrauparentesco) {
            return false;
        }
        if ((this.grauparentesco == null && other.grauparentesco != null) || (this.grauparentesco != null && !this.grauparentesco.equals(other.grauparentesco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rj.handschool.modelo.GrauparentescoPK[ idgrauparentesco=" + idgrauparentesco + ", grauparentesco=" + grauparentesco + " ]";
    }
    
}
