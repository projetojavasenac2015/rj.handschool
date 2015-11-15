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
public class AvaliacaoPK implements Serializable {
	private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "idavaliacao")
    private int idavaliacao;
    @Basic(optional = false)
    @Column(name = "id_tipo_avaliacao")
    private int idTipoAvaliacao;

    public AvaliacaoPK() {
    }

    public AvaliacaoPK(int idavaliacao, int idTipoAvaliacao) {
        this.idavaliacao = idavaliacao;
        this.idTipoAvaliacao = idTipoAvaliacao;
    }

    public int getIdavaliacao() {
        return idavaliacao;
    }

    public void setIdavaliacao(int idavaliacao) {
        this.idavaliacao = idavaliacao;
    }

    public int getIdTipoAvaliacao() {
        return idTipoAvaliacao;
    }

    public void setIdTipoAvaliacao(int idTipoAvaliacao) {
        this.idTipoAvaliacao = idTipoAvaliacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idavaliacao;
        hash += (int) idTipoAvaliacao;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AvaliacaoPK)) {
            return false;
        }
        AvaliacaoPK other = (AvaliacaoPK) object;
        if (this.idavaliacao != other.idavaliacao) {
            return false;
        }
        if (this.idTipoAvaliacao != other.idTipoAvaliacao) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rj.handschool.modelo.AvaliacaoPK[ idavaliacao=" + idavaliacao + ", idTipoAvaliacao=" + idTipoAvaliacao + " ]";
    }
    
}
