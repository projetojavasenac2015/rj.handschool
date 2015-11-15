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
public class ProfessorPK implements Serializable {
	private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "idprofessor")
    private int idprofessor;
    @Basic(optional = false)
    @Column(name = "matricula")
    private String matricula;
    @Basic(optional = false)
    @Column(name = "id_pessoa")
    private int idPessoa;

    public ProfessorPK() {
    }

    public ProfessorPK(int idprofessor, String matricula, int idPessoa) {
        this.idprofessor = idprofessor;
        this.matricula = matricula;
        this.idPessoa = idPessoa;
    }

    public int getIdprofessor() {
        return idprofessor;
    }

    public void setIdprofessor(int idprofessor) {
        this.idprofessor = idprofessor;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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
        hash += (int) idprofessor;
        hash += (matricula != null ? matricula.hashCode() : 0);
        hash += (int) idPessoa;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProfessorPK)) {
            return false;
        }
        ProfessorPK other = (ProfessorPK) object;
        if (this.idprofessor != other.idprofessor) {
            return false;
        }
        if ((this.matricula == null && other.matricula != null) || (this.matricula != null && !this.matricula.equals(other.matricula))) {
            return false;
        }
        if (this.idPessoa != other.idPessoa) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rj.handschool.modelo.ProfessorPK[ idprofessor=" + idprofessor + ", matricula=" + matricula + ", idPessoa=" + idPessoa + " ]";
    }
    
}
