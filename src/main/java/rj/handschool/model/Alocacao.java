/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rj.handschool.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Renan
 */
@Entity
@Table(name = "alocacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alocacao.findAll", query = "SELECT a FROM Alocacao a"),
    @NamedQuery(name = "Alocacao.findByIdalocacao", query = "SELECT a FROM Alocacao a WHERE a.alocacaoPK.idalocacao = :idalocacao"),
    @NamedQuery(name = "Alocacao.findByDataHoraCadastro", query = "SELECT a FROM Alocacao a WHERE a.dataHoraCadastro = :dataHoraCadastro"),
    @NamedQuery(name = "Alocacao.findByIdProfessor", query = "SELECT a FROM Alocacao a WHERE a.alocacaoPK.idProfessor = :idProfessor"),
    @NamedQuery(name = "Alocacao.findByIdDisciplina", query = "SELECT a FROM Alocacao a WHERE a.alocacaoPK.idDisciplina = :idDisciplina")})
public class Alocacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AlocacaoPK alocacaoPK;
    @Column(name = "data_hora_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraCadastro;
    @JoinColumn(name = "id_disciplina", referencedColumnName = "iddisciplina", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Disciplina disciplina;
    @JoinColumn(name = "id_professor", referencedColumnName = "idprofessor", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Professor professor;

    public Alocacao() {
    }

    public Alocacao(AlocacaoPK alocacaoPK) {
        this.alocacaoPK = alocacaoPK;
    }

    public Alocacao(int idalocacao, int idProfessor, int idDisciplina) {
        this.alocacaoPK = new AlocacaoPK(idalocacao, idProfessor, idDisciplina);
    }

    public AlocacaoPK getAlocacaoPK() {
        return alocacaoPK;
    }

    public void setAlocacaoPK(AlocacaoPK alocacaoPK) {
        this.alocacaoPK = alocacaoPK;
    }

    public Date getDataHoraCadastro() {
        return dataHoraCadastro;
    }

    public void setDataHoraCadastro(Date dataHoraCadastro) {
        this.dataHoraCadastro = dataHoraCadastro;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alocacaoPK != null ? alocacaoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alocacao)) {
            return false;
        }
        Alocacao other = (Alocacao) object;
        if ((this.alocacaoPK == null && other.alocacaoPK != null) || (this.alocacaoPK != null && !this.alocacaoPK.equals(other.alocacaoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rj.handschool.modelo.Alocacao[ alocacaoPK=" + alocacaoPK + " ]";
    }
    
}
