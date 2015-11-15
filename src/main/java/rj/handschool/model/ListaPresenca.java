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
@Table(name = "listapresenca")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Listapresenca.findAll", query = "SELECT l FROM Listapresenca l"),
    @NamedQuery(name = "Listapresenca.findByIdlistapresenca", query = "SELECT l FROM Listapresenca l WHERE l.listapresencaPK.idlistapresenca = :idlistapresenca"),
    @NamedQuery(name = "Listapresenca.findByDataHoraCadastro", query = "SELECT l FROM Listapresenca l WHERE l.dataHoraCadastro = :dataHoraCadastro"),
    @NamedQuery(name = "Listapresenca.findByDataUltAtualizacao", query = "SELECT l FROM Listapresenca l WHERE l.dataUltAtualizacao = :dataUltAtualizacao"),
    @NamedQuery(name = "Listapresenca.findByIdTurma", query = "SELECT l FROM Listapresenca l WHERE l.listapresencaPK.idTurma = :idTurma"),
    @NamedQuery(name = "Listapresenca.findByIdCurso", query = "SELECT l FROM Listapresenca l WHERE l.listapresencaPK.idCurso = :idCurso"),
    @NamedQuery(name = "Listapresenca.findByIdDisciplina", query = "SELECT l FROM Listapresenca l WHERE l.listapresencaPK.idDisciplina = :idDisciplina"),
    @NamedQuery(name = "Listapresenca.findByIdAulas", query = "SELECT l FROM Listapresenca l WHERE l.listapresencaPK.idAulas = :idAulas"),
    @NamedQuery(name = "Listapresenca.findByIdAluno", query = "SELECT l FROM Listapresenca l WHERE l.listapresencaPK.idAluno = :idAluno")})
public class Listapresenca implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ListapresencaPK listapresencaPK;
    @Column(name = "data_hora_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraCadastro;
    @Column(name = "data_ult_atualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltAtualizacao;
    @JoinColumn(name = "id_aluno", referencedColumnName = "idaluno", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Aluno aluno;
    @JoinColumn(name = "id_aulas", referencedColumnName = "idaulas", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Aulas aulas;
    @JoinColumn(name = "id_disciplina", referencedColumnName = "iddisciplina", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Disciplina disciplina;
    @JoinColumns({
        @JoinColumn(name = "id_turma", referencedColumnName = "idturma", insertable = false, updatable = false),
        @JoinColumn(name = "id_curso", referencedColumnName = "id_curso", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Turma turma;

    public Listapresenca() {
    }

    public Listapresenca(ListapresencaPK listapresencaPK) {
        this.listapresencaPK = listapresencaPK;
    }

    public Listapresenca(int idlistapresenca, int idTurma, int idCurso, int idDisciplina, int idAulas, int idAluno) {
        this.listapresencaPK = new ListapresencaPK(idlistapresenca, idTurma, idCurso, idDisciplina, idAulas, idAluno);
    }

    public ListapresencaPK getListapresencaPK() {
        return listapresencaPK;
    }

    public void setListapresencaPK(ListapresencaPK listapresencaPK) {
        this.listapresencaPK = listapresencaPK;
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

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Aulas getAulas() {
        return aulas;
    }

    public void setAulas(Aulas aulas) {
        this.aulas = aulas;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (listapresencaPK != null ? listapresencaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Listapresenca)) {
            return false;
        }
        Listapresenca other = (Listapresenca) object;
        if ((this.listapresencaPK == null && other.listapresencaPK != null) || (this.listapresencaPK != null && !this.listapresencaPK.equals(other.listapresencaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rj.handschool.modelo.Listapresenca[ listapresencaPK=" + listapresencaPK + " ]";
    }
    
}
