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
public class PessoaPK implements Serializable {
	private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "idpessoa")
    private int idpessoa;
    @Basic(optional = false)
    @Column(name = "cpf")
    private int cpf;
    @Basic(optional = false)
    @Column(name = "id_tipo_pessoa")
    private int idTipoPessoa;

    public PessoaPK() {
    }

    public PessoaPK(int idpessoa, int cpf, int idTipoPessoa) {
        this.idpessoa = idpessoa;
        this.cpf = cpf;
        this.idTipoPessoa = idTipoPessoa;
    }

    public int getIdpessoa() {
        return idpessoa;
    }

    public void setIdpessoa(int idpessoa) {
        this.idpessoa = idpessoa;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getIdTipoPessoa() {
        return idTipoPessoa;
    }

    public void setIdTipoPessoa(int idTipoPessoa) {
        this.idTipoPessoa = idTipoPessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idpessoa;
        hash += (int) cpf;
        hash += (int) idTipoPessoa;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PessoaPK)) {
            return false;
        }
        PessoaPK other = (PessoaPK) object;
        if (this.idpessoa != other.idpessoa) {
            return false;
        }
        if (this.cpf != other.cpf) {
            return false;
        }
        if (this.idTipoPessoa != other.idTipoPessoa) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rj.handschool.modelo.PessoaPK[ idpessoa=" + idpessoa + ", cpf=" + cpf + ", idTipoPessoa=" + idTipoPessoa + " ]";
    }
    
}
