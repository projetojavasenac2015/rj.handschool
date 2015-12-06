/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rj.handschool.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Renan
 */
@Entity
@Table(name = "tipo_avaliacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoAvaliacao.findAll", query = "SELECT t FROM TipoAvaliacao t"),
    @NamedQuery(name = "TipoAvaliacao.findByIdtipoAvaliacao", query = "SELECT t FROM TipoAvaliacao t WHERE t.idtipoAvaliacao = :idtipoAvaliacao"),
    @NamedQuery(name = "TipoAvaliacao.findByAtivo", query = "SELECT t FROM TipoAvaliacao t WHERE t.ativo = :ativo"),
    @NamedQuery(name = "TipoAvaliacao.findByDataHoraCadastro", query = "SELECT t FROM TipoAvaliacao t WHERE t.dataHoraCadastro = :dataHoraCadastro"),
    @NamedQuery(name = "TipoAvaliacao.findByDataUltAtualizacao", query = "SELECT t FROM TipoAvaliacao t WHERE t.dataUltAtualizacao = :dataUltAtualizacao"),
    @NamedQuery(name = "TipoAvaliacao.findByDescricao", query = "SELECT t FROM TipoAvaliacao t WHERE t.descricao = :descricao")})
public class TipoAvaliacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipo_avaliacao")
    private Integer idtipoAvaliacao;
    
    @Column(name = "ativo")
    private Character ativo;
    
    @Column(name = "data_hora_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraCadastro;
    
    @Column(name = "data_ult_atualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltAtualizacao;
    
    @Column(name = "descricao")
    @NotEmpty(message="Informe o Tipo")
    private String descricao;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoAvaliacao")
    private List<Avaliacao> avaliacaoList;
    
    public TipoAvaliacao() {
    }

    public TipoAvaliacao(Integer idtipoAvaliacao) {
        this.idtipoAvaliacao = idtipoAvaliacao;
    }

    public Integer getIdtipoAvaliacao() {
        return idtipoAvaliacao;
    }

    public void setIdtipoAvaliacao(Integer idtipoAvaliacao) {
        this.idtipoAvaliacao = idtipoAvaliacao;
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
    public List<Avaliacao> getAvaliacaoList() {
        return avaliacaoList;
    }

    public void setAvaliacaoList(List<Avaliacao> avaliacaoList) {
        this.avaliacaoList = avaliacaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoAvaliacao != null ? idtipoAvaliacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // 
        if (!(object instanceof TipoAvaliacao)) {
            return false;
        }
        TipoAvaliacao other = (TipoAvaliacao) object;
        if ((this.idtipoAvaliacao == null && other.idtipoAvaliacao != null) || (this.idtipoAvaliacao != null && !this.idtipoAvaliacao.equals(other.idtipoAvaliacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rj.handschool.modelo.TipoAvaliacao[ idtipoAvaliacao=" + idtipoAvaliacao + " ]";
    }
    
}
