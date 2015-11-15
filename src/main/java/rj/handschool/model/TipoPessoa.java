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
@Table(name = "tipo_pessoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPessoa.findAll", query = "SELECT t FROM TipoPessoa t"),
    @NamedQuery(name = "TipoPessoa.findByIdtipoPessoa", query = "SELECT t FROM TipoPessoa t WHERE t.idtipoPessoa = :idtipoPessoa"),
    @NamedQuery(name = "TipoPessoa.findByAtivo", query = "SELECT t FROM TipoPessoa t WHERE t.ativo = :ativo"),
    @NamedQuery(name = "TipoPessoa.findByDataHoraCadastro", query = "SELECT t FROM TipoPessoa t WHERE t.dataHoraCadastro = :dataHoraCadastro"),
    @NamedQuery(name = "TipoPessoa.findByDataUltAtualizacao", query = "SELECT t FROM TipoPessoa t WHERE t.dataUltAtualizacao = :dataUltAtualizacao"),
    @NamedQuery(name = "TipoPessoa.findByDescricao", query = "SELECT t FROM TipoPessoa t WHERE t.descricao = :descricao")})
public class TipoPessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipo_pessoa")
    private Integer idtipoPessoa;
    @Column(name = "ativo")
    private Character ativo;
    @Column(name = "data_hora_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraCadastro;
    @Column(name = "data_ult_atualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltAtualizacao;
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoPessoa")
    private List<Pessoa> pessoaList;

    public TipoPessoa() {
    }

    public TipoPessoa(Integer idtipoPessoa) {
        this.idtipoPessoa = idtipoPessoa;
    }

    public Integer getIdtipoPessoa() {
        return idtipoPessoa;
    }

    public void setIdtipoPessoa(Integer idtipoPessoa) {
        this.idtipoPessoa = idtipoPessoa;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<Pessoa> getPessoaList() {
        return pessoaList;
    }

    public void setPessoaList(List<Pessoa> pessoaList) {
        this.pessoaList = pessoaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoPessoa != null ? idtipoPessoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPessoa)) {
            return false;
        }
        TipoPessoa other = (TipoPessoa) object;
        if ((this.idtipoPessoa == null && other.idtipoPessoa != null) || (this.idtipoPessoa != null && !this.idtipoPessoa.equals(other.idtipoPessoa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rj.handschool.modelo.TipoPessoa[ idtipoPessoa=" + idtipoPessoa + " ]";
    }
    
}
