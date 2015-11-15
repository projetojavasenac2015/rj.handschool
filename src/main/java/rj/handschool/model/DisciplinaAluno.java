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
@Table(name = "disciplina_aluno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DisciplinaAluno.findAll", query = "SELECT d FROM DisciplinaAluno d"),
    @NamedQuery(name = "DisciplinaAluno.findByIddisciplina", query = "SELECT d FROM DisciplinaAluno d WHERE d.disciplinaAlunoPK.iddisciplina = :iddisciplina"),
    @NamedQuery(name = "DisciplinaAluno.findByMatricula", query = "SELECT d FROM DisciplinaAluno d WHERE d.disciplinaAlunoPK.matricula = :matricula"),
    @NamedQuery(name = "DisciplinaAluno.findByStatus", query = "SELECT d FROM DisciplinaAluno d WHERE d.status = :status")})
public class DisciplinaAluno implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DisciplinaAlunoPK disciplinaAlunoPK;
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "iddisciplina", referencedColumnName = "iddisciplina", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Disciplina disciplina;

    public DisciplinaAluno() {
    }

    public DisciplinaAluno(DisciplinaAlunoPK disciplinaAlunoPK) {
        this.disciplinaAlunoPK = disciplinaAlunoPK;
    }

    public DisciplinaAluno(int iddisciplina, String matricula) {
        this.disciplinaAlunoPK = new DisciplinaAlunoPK(iddisciplina, matricula);
    }

    public DisciplinaAlunoPK getDisciplinaAlunoPK() {
        return disciplinaAlunoPK;
    }

    public void setDisciplinaAlunoPK(DisciplinaAlunoPK disciplinaAlunoPK) {
        this.disciplinaAlunoPK = disciplinaAlunoPK;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (disciplinaAlunoPK != null ? disciplinaAlunoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DisciplinaAluno)) {
            return false;
        }
        DisciplinaAluno other = (DisciplinaAluno) object;
        if ((this.disciplinaAlunoPK == null && other.disciplinaAlunoPK != null) || (this.disciplinaAlunoPK != null && !this.disciplinaAlunoPK.equals(other.disciplinaAlunoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bd.DisciplinaAluno[ disciplinaAlunoPK=" + disciplinaAlunoPK + " ]";
    }
    
}
