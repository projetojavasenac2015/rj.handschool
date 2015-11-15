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
@Table(name = "disciplina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Disciplina.findAll", query = "SELECT d FROM Disciplina d"),
    @NamedQuery(name = "Disciplina.findByIddisciplina", query = "SELECT d FROM Disciplina d WHERE d.iddisciplina = :iddisciplina"),
    @NamedQuery(name = "Disciplina.findByAtivo", query = "SELECT d FROM Disciplina d WHERE d.ativo = :ativo"),
    @NamedQuery(name = "Disciplina.findByDataHoraCadastro", query = "SELECT d FROM Disciplina d WHERE d.dataHoraCadastro = :dataHoraCadastro"),
    @NamedQuery(name = "Disciplina.findByDataUltAtualizacao", query = "SELECT d FROM Disciplina d WHERE d.dataUltAtualizacao = :dataUltAtualizacao"),
    @NamedQuery(name = "Disciplina.findByDescricao", query = "SELECT d FROM Disciplina d WHERE d.descricao = :descricao"),
    @NamedQuery(name = "Disciplina.findByEmenta", query = "SELECT d FROM Disciplina d WHERE d.ementa = :ementa"),
    @NamedQuery(name = "Disciplina.findByNome", query = "SELECT d FROM Disciplina d WHERE d.nome = :nome")})
public class Disciplina implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddisciplina")
    private Integer iddisciplina;
    @Basic(optional = false)
    @Column(name = "ativo")
    private short ativo;
    @Column(name = "DATA_HORA_CADASTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraCadastro;
    @Column(name = "DATA_ULT_ATUALIZACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltAtualizacao;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "ementa")
    private String ementa;
    @Column(name = "nome")
    private String nome;
    @OneToMany(mappedBy = "iddisciplina")
    private List<Aula> aulaList;
    @OneToMany(mappedBy = "iddisciplina")
    private List<Notas> notasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplina")
    private List<Alocacao> alocacaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplina")
    private List<DisciplinaCurso> disciplinaCursoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplina")
    private List<Modulo> moduloList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplina")
    private List<DisciplinaAluno> disciplinaAlunoList;

    public Disciplina() {
    }

    public Disciplina(Integer iddisciplina) {
        this.iddisciplina = iddisciplina;
    }

    public Disciplina(Integer iddisciplina, short ativo) {
        this.iddisciplina = iddisciplina;
        this.ativo = ativo;
    }

    public Integer getIddisciplina() {
        return iddisciplina;
    }

    public void setIddisciplina(Integer iddisciplina) {
        this.iddisciplina = iddisciplina;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public List<Aula> getAulaList() {
        return aulaList;
    }

    public void setAulaList(List<Aula> aulaList) {
        this.aulaList = aulaList;
    }

    @XmlTransient
    public List<Notas> getNotasList() {
        return notasList;
    }

    public void setNotasList(List<Notas> notasList) {
        this.notasList = notasList;
    }

    @XmlTransient
    public List<Alocacao> getAlocacaoList() {
        return alocacaoList;
    }

    public void setAlocacaoList(List<Alocacao> alocacaoList) {
        this.alocacaoList = alocacaoList;
    }

    @XmlTransient
    public List<DisciplinaCurso> getDisciplinaCursoList() {
        return disciplinaCursoList;
    }

    public void setDisciplinaCursoList(List<DisciplinaCurso> disciplinaCursoList) {
        this.disciplinaCursoList = disciplinaCursoList;
    }

    @XmlTransient
    public List<Modulo> getModuloList() {
        return moduloList;
    }

    public void setModuloList(List<Modulo> moduloList) {
        this.moduloList = moduloList;
    }

    @XmlTransient
    public List<DisciplinaAluno> getDisciplinaAlunoList() {
        return disciplinaAlunoList;
    }

    public void setDisciplinaAlunoList(List<DisciplinaAluno> disciplinaAlunoList) {
        this.disciplinaAlunoList = disciplinaAlunoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddisciplina != null ? iddisciplina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Disciplina)) {
            return false;
        }
        Disciplina other = (Disciplina) object;
        if ((this.iddisciplina == null && other.iddisciplina != null) || (this.iddisciplina != null && !this.iddisciplina.equals(other.iddisciplina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bd.Disciplina[ iddisciplina=" + iddisciplina + " ]";
    }
    
}
