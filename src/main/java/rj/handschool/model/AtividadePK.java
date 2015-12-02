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
public class AtividadePK implements Serializable {
	private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "idatividade")
    private int idatividade;
    @Basic(optional = false)
    @Column(name = "id_tipo_atividade")
    private int idTipoAtividade;

    public AtividadePK() {
    }

    public AtividadePK(int idatividade, int idTipoAtividade) {
        this.idatividade = idatividade;
        this.idTipoAtividade = idTipoAtividade;
    }

    public int getIdatividade() {
        return idatividade;
    }

    public void setIdatividade(int idatividade) {
        this.idatividade = idatividade;
    }

    public int getIdTipoAtividade() {
        return idTipoAtividade;
    }

    public void setIdTipoAtividade(int idTipoAtividade) {
        this.idTipoAtividade = idTipoAtividade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idatividade;
        hash += (int) idTipoAtividade;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // 
        if (!(object instanceof AtividadePK)) {
            return false;
        }
        AtividadePK other = (AtividadePK) object;
        if (this.idatividade != other.idatividade) {
            return false;
        }
        if (this.idTipoAtividade != other.idTipoAtividade) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rj.handschool.modelo.AtividadePK[ idatividade=" + idatividade + ", idTipoAtividade=" + idTipoAtividade + " ]";
    }
    
}
