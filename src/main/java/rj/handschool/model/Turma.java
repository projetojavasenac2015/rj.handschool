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
    @NamedQuery(name = "Turma.findByIdturma", query = "SELECT t FROM Turma t WHERE t.idturma = :idturma"),
    @NamedQuery(name = "Turma.findByAno", query = "SELECT t FROM Turma t WHERE t.ano = :ano"),
    @NamedQuery(name = "Turma.findByAtivo", query = "SELECT t FROM Turma t WHERE t.ativo = :ativo"),
    @NamedQuery(name = "Turma.findByDataHoraCadastro", query = "SELECT t FROM Turma t WHERE t.dataHoraCadastro = :dataHoraCadastro"),
    @NamedQuery(name = "Turma.findByDataUltAtualizacao", query = "SELECT t FROM Turma t WHERE t.dataUltAtualizacao = :dataUltAtualizacao"),
    @NamedQuery(name = "Turma.findByDescricaoTurma", query = "SELECT t FROM Turma t WHERE t.descricaoTurma = :descricaoTurma"),
    @NamedQuery(name = "Turma.findByQuantidadeAlunos", query = "SELECT t FROM Turma t WHERE t.quantidadeAlunos = :quantidadeAlunos")})
public class Turma implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idturma")
    private Integer idturma;
    @Basic(optional = false)
    @Column(name = "ano")
    private int ano;
    @Basic(optional = false)
    @Column(name = "ativo")
    private short ativo;
    @Column(name = "DATA_HORA_CADASTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraCadastro;
    @Column(name = "DATA_ULT_ATUALIZACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltAtualizacao;
    @Column(name = "DESCRICAO_TURMA")
    private String descricaoTurma;
    @Column(name = "QUANTIDADE_ALUNOS")
    private Integer quantidadeAlunos;
    @OneToMany(mappedBy = "idturma")
    private List<Aula> aulaList;
    @JoinColumn(name = "IDCURSO", referencedColumnName = "idcurso")
    @ManyToOne
    private Curso idcurso;
    @OneToMany(mappedBy = "idturma")
    private List<Notas> notasList;

    public Turma() {
    }

    public Turma(Integer idturma) {
        this.idturma = idturma;
    }

    public Turma(Integer idturma, int ano, short ativo) {
        this.idturma = idturma;
        this.ano = ano;
        this.ativo = ativo;
    }

    public Integer getIdturma() {
        return idturma;
    }

    public void setIdturma(Integer idturma) {
        this.idturma = idturma;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
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

    public String getDescricaoTurma() {
        return descricaoTurma;
    }

    public void setDescricaoTurma(String descricaoTurma) {
        this.descricaoTurma = descricaoTurma;
    }

    public Integer getQuantidadeAlunos() {
        return quantidadeAlunos;
    }

    public void setQuantidadeAlunos(Integer quantidadeAlunos) {
        this.quantidadeAlunos = quantidadeAlunos;
    }

    @XmlTransient
    public List<Aula> getAulaList() {
        return aulaList;
    }

    public void setAulaList(List<Aula> aulaList) {
        this.aulaList = aulaList;
    }

    public Curso getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(Curso idcurso) {
        this.idcurso = idcurso;
    }

    @XmlTransient
    public List<Notas> getNotasList() {
        return notasList;
    }

    public void setNotasList(List<Notas> notasList) {
        this.notasList = notasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idturma != null ? idturma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Turma)) {
            return false;
        }
        Turma other = (Turma) object;
        if ((this.idturma == null && other.idturma != null) || (this.idturma != null && !this.idturma.equals(other.idturma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bd.Turma[ idturma=" + idturma + " ]";
    }
    
}
