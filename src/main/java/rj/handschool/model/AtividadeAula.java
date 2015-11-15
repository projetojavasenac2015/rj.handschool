/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rj.handschool.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Renan
 */
@Entity
@Table(name = "atividade_aula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AtividadeAula.findAll", query = "SELECT a FROM AtividadeAula a"),
    @NamedQuery(name = "AtividadeAula.findByIdatividadeAula", query = "SELECT a FROM AtividadeAula a WHERE a.atividadeAulaPK.idatividadeAula = :idatividadeAula"),
    @NamedQuery(name = "AtividadeAula.findByAulasIdaulas", query = "SELECT a FROM AtividadeAula a WHERE a.atividadeAulaPK.aulasIdaulas = :aulasIdaulas"),
    @NamedQuery(name = "AtividadeAula.findByIdAtividade", query = "SELECT a FROM AtividadeAula a WHERE a.atividadeAulaPK.idAtividade = :idAtividade")})
public class AtividadeAula implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AtividadeAulaPK atividadeAulaPK;
    @JoinColumn(name = "id_atividade", referencedColumnName = "idatividade", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Atividade atividade;
    @JoinColumn(name = "aulas_idaulas", referencedColumnName = "idaulas", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Aulas aulas;

    public AtividadeAula() {
    }

    public AtividadeAula(AtividadeAulaPK atividadeAulaPK) {
        this.atividadeAulaPK = atividadeAulaPK;
    }

    public AtividadeAula(int idatividadeAula, int aulasIdaulas, int idAtividade) {
        this.atividadeAulaPK = new AtividadeAulaPK(idatividadeAula, aulasIdaulas, idAtividade);
    }

    public AtividadeAulaPK getAtividadeAulaPK() {
        return atividadeAulaPK;
    }

    public void setAtividadeAulaPK(AtividadeAulaPK atividadeAulaPK) {
        this.atividadeAulaPK = atividadeAulaPK;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public Aulas getAulas() {
        return aulas;
    }

    public void setAulas(Aulas aulas) {
        this.aulas = aulas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (atividadeAulaPK != null ? atividadeAulaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AtividadeAula)) {
            return false;
        }
        AtividadeAula other = (AtividadeAula) object;
        if ((this.atividadeAulaPK == null && other.atividadeAulaPK != null) || (this.atividadeAulaPK != null && !this.atividadeAulaPK.equals(other.atividadeAulaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rj.handschool.modelo.AtividadeAula[ atividadeAulaPK=" + atividadeAulaPK + " ]";
    }
    
}
