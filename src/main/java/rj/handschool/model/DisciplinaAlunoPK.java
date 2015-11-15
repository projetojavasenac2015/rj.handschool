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
public class DisciplinaAlunoPK implements Serializable {
	private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "iddisciplina")
    private int iddisciplina;
    @Basic(optional = false)
    @Column(name = "matricula")
    private String matricula;

    public DisciplinaAlunoPK() {
    }

    public DisciplinaAlunoPK(int iddisciplina, String matricula) {
        this.iddisciplina = iddisciplina;
        this.matricula = matricula;
    }

    public int getIddisciplina() {
        return iddisciplina;
    }

    public void setIddisciplina(int iddisciplina) {
        this.iddisciplina = iddisciplina;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) iddisciplina;
        hash += (matricula != null ? matricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DisciplinaAlunoPK)) {
            return false;
        }
        DisciplinaAlunoPK other = (DisciplinaAlunoPK) object;
        if (this.iddisciplina != other.iddisciplina) {
            return false;
        }
        if ((this.matricula == null && other.matricula != null) || (this.matricula != null && !this.matricula.equals(other.matricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bd.DisciplinaAlunoPK[ iddisciplina=" + iddisciplina + ", matricula=" + matricula + " ]";
    }
    
}
