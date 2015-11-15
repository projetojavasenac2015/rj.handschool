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
public class TipoAtividadePK implements Serializable {
	private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "idtipo_atividade")
    private int idtipoAtividade;
    @Basic(optional = false)
    @Column(name = "id_tipo_avaliacao")
    private int idTipoAvaliacao;

    public TipoAtividadePK() {
    }

    public TipoAtividadePK(int idtipoAtividade, int idTipoAvaliacao) {
        this.idtipoAtividade = idtipoAtividade;
        this.idTipoAvaliacao = idTipoAvaliacao;
    }

    public int getIdtipoAtividade() {
        return idtipoAtividade;
    }

    public void setIdtipoAtividade(int idtipoAtividade) {
        this.idtipoAtividade = idtipoAtividade;
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
        hash += (int) idtipoAtividade;
        hash += (int) idTipoAvaliacao;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoAtividadePK)) {
            return false;
        }
        TipoAtividadePK other = (TipoAtividadePK) object;
        if (this.idtipoAtividade != other.idtipoAtividade) {
            return false;
        }
        if (this.idTipoAvaliacao != other.idTipoAvaliacao) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rj.handschool.modelo.TipoAtividadePK[ idtipoAtividade=" + idtipoAtividade + ", idTipoAvaliacao=" + idTipoAvaliacao + " ]";
    }
    
}
