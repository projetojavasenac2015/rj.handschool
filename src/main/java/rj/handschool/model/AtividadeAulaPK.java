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
public class AtividadeAulaPK implements Serializable {
	private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "idatividade_aula")
    private int idatividadeAula;
    @Basic(optional = false)
    @Column(name = "aulas_idaulas")
    private int aulasIdaulas;
    @Basic(optional = false)
    @Column(name = "id_atividade")
    private int idAtividade;

    public AtividadeAulaPK() {
    }

    public AtividadeAulaPK(int idatividadeAula, int aulasIdaulas, int idAtividade) {
        this.idatividadeAula = idatividadeAula;
        this.aulasIdaulas = aulasIdaulas;
        this.idAtividade = idAtividade;
    }

    public int getIdatividadeAula() {
        return idatividadeAula;
    }

    public void setIdatividadeAula(int idatividadeAula) {
        this.idatividadeAula = idatividadeAula;
    }

    public int getAulasIdaulas() {
        return aulasIdaulas;
    }

    public void setAulasIdaulas(int aulasIdaulas) {
        this.aulasIdaulas = aulasIdaulas;
    }

    public int getIdAtividade() {
        return idAtividade;
    }

    public void setIdAtividade(int idAtividade) {
        this.idAtividade = idAtividade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idatividadeAula;
        hash += (int) aulasIdaulas;
        hash += (int) idAtividade;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // 
        if (!(object instanceof AtividadeAulaPK)) {
            return false;
        }
        AtividadeAulaPK other = (AtividadeAulaPK) object;
        if (this.idatividadeAula != other.idatividadeAula) {
            return false;
        }
        if (this.aulasIdaulas != other.aulasIdaulas) {
            return false;
        }
        if (this.idAtividade != other.idAtividade) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rj.handschool.modelo.AtividadeAulaPK[ idatividadeAula=" + idatividadeAula + ", aulasIdaulas=" + aulasIdaulas + ", idAtividade=" + idAtividade + " ]";
    }
    
}
