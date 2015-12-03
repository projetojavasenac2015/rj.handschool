/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rj.handschool.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LoginPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
    @Basic(optional = false)
    @Column(name = "idlogin")
    private int idlogin;    
       
    @Basic(optional = false)
    @Column(name = "idpessoa")
    private int idPessoa;

    public LoginPK() {
    }

    public LoginPK(int idlogin, int idPerfil, int idPessoa) {
        this.idlogin = idlogin;
        this.idPessoa = idPessoa;
    }

    public int getIdlogin() {
        return idlogin;
    }

    public void setIdlogin(int idlogin) {
        this.idlogin = idlogin;
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
        hash += (int) idlogin;       
        hash += (int) idPessoa;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // 
        if (!(object instanceof LoginPK)) {
            return false;
        }
        LoginPK other = (LoginPK) object;
        if (this.idlogin != other.idlogin) {
            return false;
        }       
        if (this.idPessoa != other.idPessoa) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rj.handschool.modelo.LoginPK[ idlogin=" + idlogin + ", idPessoa=" + idPessoa + " ]";
    }
    
}
