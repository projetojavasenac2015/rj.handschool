/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rj.handschool.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Renan
 */
@Entity
@Table(name = "turma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Turma.findAll", query = "SELECT t FROM Turma t"),
    @NamedQuery(name = "Turma.findByIdturma", query = "SELECT t FROM Turma t WHERE t.turmaPK.idturma = :idturma"),
    @NamedQuery(name = "Turma.findByAtivo", query = "SELECT t FROM Turma t WHERE t.ativo = :ativo"),
    @NamedQuery(name = "Turma.findByDataHoraCadastro", query = "SELECT t FROM Turma t WHERE t.dataHoraCadastro = :dataHoraCadastro"),
    @NamedQuery(name = "Turma.findByDataUltAtualizacao", query = "SELECT t FROM Turma t WHERE t.dataUltAtualizacao = :dataUltAtualizacao"),
    @NamedQuery(name = "Turma.findByQuantidadeAlunos", query = "SELECT t FROM Turma t WHERE t.quantidadeAlunos = :quantidadeAlunos"),
    @NamedQuery(name = "Turma.findByIdCurso", query = "SELECT t FROM Turma t WHERE t.turmaPK.idCurso = :idCurso")})
public class Turma implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TurmaPK turmaPK;
    @Column(name = "ativo")
    private Character ativo;
    @Column(name = "data_hora_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraCadastro;
    @Column(name = "data_ult_atualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltAtualizacao;
    @Column(name = "quantidade_alunos")
    private Integer quantidadeAlunos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "turma")
    private List<QuadroAvisos> quadroAvisosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "turma")
    private List<ListaPresenca> listapresencaList;
    @JoinColumn(name = "idcurso", referencedColumnName = "idcurso", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Curso curso;

    public Turma() {
    }

    public Turma(TurmaPK turmaPK) {
        this.turmaPK = turmaPK;
    }

    public Turma(int idturma, int idCurso) {
        this.turmaPK = new TurmaPK(idturma, idCurso);
    }

    public TurmaPK getTurmaPK() {
        return turmaPK;
    }

    public void setTurmaPK(TurmaPK turmaPK) {
        this.turmaPK = turmaPK;
    }

    public Character getAtivo() {
        return ativo;
    }

    public void setAtivo(Character ativo) {
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

    public Integer getQuantidadeAlunos() {
        return quantidadeAlunos;
    }

    public void setQuantidadeAlunos(Integer quantidadeAlunos) {
        this.quantidadeAlunos = quantidadeAlunos;
    }

    @XmlTransient
    public List<QuadroAvisos> getQuadroAvisosList() {
        return quadroAvisosList;
    }

    public void setQuadroAvisosList(List<QuadroAvisos> quadroAvisosList) {
        this.quadroAvisosList = quadroAvisosList;
    }

    @XmlTransient
    public List<ListaPresenca> getListapresencaList() {
        return listapresencaList;
    }

    public void setListapresencaList(List<ListaPresenca> listapresencaList) {
        this.listapresencaList = listapresencaList;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (turmaPK != null ? turmaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Turma)) {
            return false;
        }
        Turma other = (Turma) object;
        if ((this.turmaPK == null && other.turmaPK != null) || (this.turmaPK != null && !this.turmaPK.equals(other.turmaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rj.handschool.modelo.Turma[ turmaPK=" + turmaPK + " ]";
    }
    
}
