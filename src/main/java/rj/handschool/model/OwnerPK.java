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
public class OwnerPK implements Serializable {
	private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "idowner")
    private int idowner;
    @Basic(optional = false)
    @Column(name = "id_pessoa")
    private int idPessoa;

    public OwnerPK() {
    }

    public OwnerPK(int idowner, int idPessoa) {
        this.idowner = idowner;
        this.idPessoa = idPessoa;
    }

    public int getIdowner() {
        return idowner;
    }

    public void setIdowner(int idowner) {
        this.idowner = idowner;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idowner;
        hash += (int) idPessoa;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OwnerPK)) {
            return false;
        }
        OwnerPK other = (OwnerPK) object;
        if (this.idowner != other.idowner) {
            return false;
        }
        if (this.idPessoa != other.idPessoa) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rj.handschool.modelo.OwnerPK[ idowner=" + idowner + ", idPessoa=" + idPessoa + " ]";
    }
    
}
