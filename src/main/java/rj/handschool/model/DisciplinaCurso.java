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
@Table(name = "disciplina_curso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DisciplinaCurso.findAll", query = "SELECT d FROM DisciplinaCurso d"),
    @NamedQuery(name = "DisciplinaCurso.findByIdcurso", query = "SELECT d FROM DisciplinaCurso d WHERE d.disciplinaCursoPK.idcurso = :idcurso"),
    @NamedQuery(name = "DisciplinaCurso.findByIddisciplina", query = "SELECT d FROM DisciplinaCurso d WHERE d.disciplinaCursoPK.iddisciplina = :iddisciplina"),
    @NamedQuery(name = "DisciplinaCurso.findByAtivo", query = "SELECT d FROM DisciplinaCurso d WHERE d.ativo = :ativo"),
    @NamedQuery(name = "DisciplinaCurso.findByDataHoraCadastro", query = "SELECT d FROM DisciplinaCurso d WHERE d.dataHoraCadastro = :dataHoraCadastro"),
    @NamedQuery(name = "DisciplinaCurso.findByDataUltAtualizacao", query = "SELECT d FROM DisciplinaCurso d WHERE d.dataUltAtualizacao = :dataUltAtualizacao")})
public class DisciplinaCurso implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DisciplinaCursoPK disciplinaCursoPK;
    @Basic(optional = false)
    @Column(name = "ativo")
    private short ativo;
    @Column(name = "DATA_HORA_CADASTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraCadastro;
    @Column(name = "DATA_ULT_ATUALIZACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltAtualizacao;
    @JoinColumn(name = "idcurso", referencedColumnName = "idcurso", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Curso curso;
    @JoinColumn(name = "iddisciplina", referencedColumnName = "iddisciplina", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Disciplina disciplina;

    public DisciplinaCurso() {
    }

    public DisciplinaCurso(DisciplinaCursoPK disciplinaCursoPK) {
        this.disciplinaCursoPK = disciplinaCursoPK;
    }

    public DisciplinaCurso(DisciplinaCursoPK disciplinaCursoPK, short ativo) {
        this.disciplinaCursoPK = disciplinaCursoPK;
        this.ativo = ativo;
    }

    public DisciplinaCurso(int idcurso, int iddisciplina) {
        this.disciplinaCursoPK = new DisciplinaCursoPK(idcurso, iddisciplina);
    }

    public DisciplinaCursoPK getDisciplinaCursoPK() {
        return disciplinaCursoPK;
    }

    public void setDisciplinaCursoPK(DisciplinaCursoPK disciplinaCursoPK) {
        this.disciplinaCursoPK = disciplinaCursoPK;
    }

    public short getAtivo() {
        return ativo;
    }

    public void setAtivo(short ativo) {
        this.ativo = ativo;
    }

    public Date getDataHoraCadastro() {
        return dataHoraCadastro;
    }

    public void setDataHoraCadastro(Date dataHoraCadastro) {
        this.dataHoraCadastro = dataHoraCadastro;
    }

    public Date getDataUltAtualizacao() {
        return dataUltAtualizacao;
    }

    public void setDataUltAtualizacao(Date dataUltAtualizacao) {
        this.dataUltAtualizacao = dataUltAtualizacao;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
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
        hash += (disciplinaCursoPK != null ? disciplinaCursoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DisciplinaCurso)) {
            return false;
        }
        DisciplinaCurso other = (DisciplinaCurso) object;
        if ((this.disciplinaCursoPK == null && other.disciplinaCursoPK != null) || (this.disciplinaCursoPK != null && !this.disciplinaCursoPK.equals(other.disciplinaCursoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bd.DisciplinaCurso[ disciplinaCursoPK=" + disciplinaCursoPK + " ]";
    }
    
}
