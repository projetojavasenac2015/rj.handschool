/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rj.handschool.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.validator.constraints.NotEmpty;

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
    @NamedQuery(name = "Disciplina.findByNome", query = "SELECT d FROM Disciplina d WHERE d.nome = :nome"),
    @NamedQuery(name = "Disciplina.findByEmenta", query = "SELECT d FROM Disciplina d WHERE d.ementa = :ementa")})
public class Disciplina implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddisciplina")
    private Integer iddisciplina;
    @NotNull(message="Indique a situação")
    @Column(name = "ativo")
    private Character ativo;
    @Column(name = "data_hora_cadastro", updatable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraCadastro;
    @Column(name = "data_ult_atualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltAtualizacao;
    @NotEmpty(message="Informe o nome")
    @Size(min=8,message="Nome Muito Pequeno. Min* 8 caracteres")
    @Column(name = "nome")
    private String nome;
    @NotEmpty(message="Informe a ementa")
    @Column(name = "ementa")
    private String ementa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplina")
    private List<QuadroAvisos> quadroAvisosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplina")
    private List<AvaliacaoAluno> avaliacaoAlunoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplina")
    private List<ListaPresenca> listapresencaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplina")
    private List<Alocacao> alocacaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplina")
    private List<Modulo> moduloList;

    public Disciplina() {
    }

    public Disciplina(Integer iddisciplina) {
        this.iddisciplina = iddisciplina;
    }

    public Integer getIddisciplina() {
        return iddisciplina;
    }

    public void setIddisciplina(Integer iddisciplina) {
        this.iddisciplina = iddisciplina;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    @XmlTransient
    public List<QuadroAvisos> getQuadroAvisosList() {
        return quadroAvisosList;
    }

    public void setQuadroAvisosList(List<QuadroAvisos> quadroAvisosList) {
        this.quadroAvisosList = quadroAvisosList;
    }

    @XmlTransient
    public List<AvaliacaoAluno> getAvaliacaoAlunoList() {
        return avaliacaoAlunoList;
    }

    public void setAvaliacaoAlunoList(List<AvaliacaoAluno> avaliacaoAlunoList) {
        this.avaliacaoAlunoList = avaliacaoAlunoList;
    }

    @XmlTransient
    public List<ListaPresenca> getListapresencaList() {
        return listapresencaList;
    }

    public void setListapresencaList(List<ListaPresenca> listapresencaList) {
        this.listapresencaList = listapresencaList;
    }

    @XmlTransient
    public List<Alocacao> getAlocacaoList() {
        return alocacaoList;
    }

    public void setAlocacaoList(List<Alocacao> alocacaoList) {
        this.alocacaoList = alocacaoList;
    }

    @XmlTransient
    public List<Modulo> getModuloList() {
        return moduloList;
    }

    public void setModuloList(List<Modulo> moduloList) {
        this.moduloList = moduloList;
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
        return "rj.handschool.modelo.Disciplina[ iddisciplina=" + iddisciplina + " ]";
    }
    
}
