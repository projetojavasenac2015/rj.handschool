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
@Table(name = "quadro_avisos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QuadroAvisos.findAll", query = "SELECT q FROM QuadroAvisos q"),
    @NamedQuery(name = "QuadroAvisos.findByIdquadroAvisos", query = "SELECT q FROM QuadroAvisos q WHERE q.quadroAvisosPK.idquadroAvisos = :idquadroAvisos"),
    @NamedQuery(name = "QuadroAvisos.findByDataHoraCadastro", query = "SELECT q FROM QuadroAvisos q WHERE q.dataHoraCadastro = :dataHoraCadastro"),
    @NamedQuery(name = "QuadroAvisos.findByAviso", query = "SELECT q FROM QuadroAvisos q WHERE q.aviso = :aviso"),
    @NamedQuery(name = "QuadroAvisos.findByIdTurma", query = "SELECT q FROM QuadroAvisos q WHERE q.quadroAvisosPK.idTurma = :idTurma"),
    @NamedQuery(name = "QuadroAvisos.findByIdCurso", query = "SELECT q FROM QuadroAvisos q WHERE q.quadroAvisosPK.idCurso = :idCurso"),
    @NamedQuery(name = "QuadroAvisos.findByIdDisciplina", query = "SELECT q FROM QuadroAvisos q WHERE q.quadroAvisosPK.idDisciplina = :idDisciplina")})
public class QuadroAvisos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected QuadroAvisosPK quadroAvisosPK;
    
    @Column(name = "data_hora_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraCadastro;
    
    @Column(name = "aviso")
    private String aviso;
    
    @JoinColumn(name = "id_disciplina", referencedColumnName = "iddisciplina", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Disciplina disciplina;
    
    @JoinColumn(name = "id_turma", referencedColumnName = "idturma", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Turma turma;
    
    @JoinColumn(name = "matricula_professor", referencedColumnName = "matricula_professor", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Professor professor;

    public QuadroAvisos() {
    }

    public QuadroAvisos(QuadroAvisosPK quadroAvisosPK) {
        this.quadroAvisosPK = quadroAvisosPK;
    }

    public QuadroAvisos(int idquadroAvisos, String matricula_professor, int idTurma, int idCurso, int idDisciplina) {
        this.quadroAvisosPK = new QuadroAvisosPK(idquadroAvisos, matricula_professor, idTurma, idCurso, idDisciplina);
    }

    public QuadroAvisosPK getQuadroAvisosPK() {
        return quadroAvisosPK;
    }

    public void setQuadroAvisosPK(QuadroAvisosPK quadroAvisosPK) {
        this.quadroAvisosPK = quadroAvisosPK;
    }

    public Date getDataHoraCadastro() {
        return dataHoraCadastro;
    }

    public void setDataHoraCadastro(Date dataHoraCadastro) {
        this.dataHoraCadastro = dataHoraCadastro;
    }

    public String getAviso() {
        return aviso;
    }

    public void setAviso(String aviso) {
        this.aviso = aviso;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
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
        hash += (quadroAvisosPK != null ? quadroAvisosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // 
        if (!(object instanceof QuadroAvisos)) {
            return false;
        }
        QuadroAvisos other = (QuadroAvisos) object;
        if ((this.quadroAvisosPK == null && other.quadroAvisosPK != null) || (this.quadroAvisosPK != null && !this.quadroAvisosPK.equals(other.quadroAvisosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rj.handschool.modelo.QuadroAvisos[ quadroAvisosPK=" + quadroAvisosPK + " ]";
    }
    
}
