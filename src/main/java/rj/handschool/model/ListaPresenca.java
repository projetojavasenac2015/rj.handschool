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
@Table(name = "Listapresenca")
@XmlRootElement
public class ListaPresenca implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ListapresencaPK listapresencaPK;
    @Column(name = "data_hora_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraCadastro;
    @Column(name = "data_ult_atualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltAtualizacao;
    @JoinColumn(name = "matricula", referencedColumnName = "matricula", insertable = false, updatable = false)
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
        @JoinColumn(name = "idcurso", referencedColumnName = "idcurso", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Turma turma;

    public ListaPresenca() {
    }

    public ListaPresenca(ListapresencaPK listapresencaPK) {
        this.listapresencaPK = listapresencaPK;
    }

    public ListaPresenca(int idlistapresenca, int idTurma, int idCurso, int idDisciplina, int idAulas, String matricula) {
        this.listapresencaPK = new ListapresencaPK(idlistapresenca, idTurma, idCurso, idDisciplina, idAulas,matricula);
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
        if (!(object instanceof ListaPresenca)) {
            return false;
        }
        ListaPresenca other = (ListaPresenca) object;
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
