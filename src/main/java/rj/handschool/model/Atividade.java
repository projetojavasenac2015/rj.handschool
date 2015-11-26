/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rj.handschool.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Renan
 */
@Entity
@Table(name = "atividade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Atividade.findAll", query = "SELECT a FROM Atividade a"),
    @NamedQuery(name = "Atividade.findByIdatividade", query = "SELECT a FROM Atividade a WHERE a.atividadePK.idatividade = :idatividade"),
    @NamedQuery(name = "Atividade.findByIdTipoAtividade", query = "SELECT a FROM Atividade a WHERE a.atividadePK.idTipoAtividade = :idTipoAtividade")})
public class Atividade implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AtividadePK atividadePK;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "atividade")
    private List<AtividadeAula> atividadeAulaList;
    
    @JoinColumn(name = "id_tipo_atividade", referencedColumnName = "idtipo_atividade")//, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoAtividade tipoAtividade;

    public Atividade() {
    }

    public Atividade(AtividadePK atividadePK) {
        this.atividadePK = atividadePK;
    }

    public Atividade(int idatividade, int idTipoAtividade) {
        this.atividadePK = new AtividadePK(idatividade, idTipoAtividade);
    }

    public AtividadePK getAtividadePK() {
        return atividadePK;
    }

    public void setAtividadePK(AtividadePK atividadePK) {
        this.atividadePK = atividadePK;
    }

    @XmlTransient
    public List<AtividadeAula> getAtividadeAulaList() {
        return atividadeAulaList;
    }

    public void setAtividadeAulaList(List<AtividadeAula> atividadeAulaList) {
        this.atividadeAulaList = atividadeAulaList;
    }

    public TipoAtividade getTipoAtividade() {
        return tipoAtividade;
    }

    public void setTipoAtividade(TipoAtividade tipoAtividade) {
        this.tipoAtividade = tipoAtividade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (atividadePK != null ? atividadePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Atividade)) {
            return false;
        }
        Atividade other = (Atividade) object;
        if ((this.atividadePK == null && other.atividadePK != null) || (this.atividadePK != null && !this.atividadePK.equals(other.atividadePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rj.handschool.modelo.Atividade[ atividadePK=" + atividadePK + " ]";
    }
    
}
