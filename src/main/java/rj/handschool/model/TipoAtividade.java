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
@Table(name = "tipo_atividade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoAtividade.findAll", query = "SELECT t FROM TipoAtividade t"),
    @NamedQuery(name = "TipoAtividade.findByIdtipoAtividade", query = "SELECT t FROM TipoAtividade t WHERE t.tipoAtividadePK.idtipoAtividade = :idtipoAtividade"),
    @NamedQuery(name = "TipoAtividade.findByDescricao", query = "SELECT t FROM TipoAtividade t WHERE t.descricao = :descricao"),
    @NamedQuery(name = "TipoAtividade.findByDataHoraCadastro", query = "SELECT t FROM TipoAtividade t WHERE t.dataHoraCadastro = :dataHoraCadastro"),
    @NamedQuery(name = "TipoAtividade.findByIdTipoAvaliacao", query = "SELECT t FROM TipoAtividade t WHERE t.tipoAtividadePK.idTipoAvaliacao = :idTipoAvaliacao")})
public class TipoAtividade implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TipoAtividadePK tipoAtividadePK;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "data_hora_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraCadastro;
    @JoinColumn(name = "id_tipo_avaliacao", referencedColumnName = "idtipo_avaliacao", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoAvaliacao tipoAvaliacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoAtividade")
    private List<Atividade> atividadeList;

    public TipoAtividade() {
    }

    public TipoAtividade(TipoAtividadePK tipoAtividadePK) {
        this.tipoAtividadePK = tipoAtividadePK;
    }

    public TipoAtividade(int idtipoAtividade, int idTipoAvaliacao) {
        this.tipoAtividadePK = new TipoAtividadePK(idtipoAtividade, idTipoAvaliacao);
    }

    public TipoAtividadePK getTipoAtividadePK() {
        return tipoAtividadePK;
    }

    public void setTipoAtividadePK(TipoAtividadePK tipoAtividadePK) {
        this.tipoAtividadePK = tipoAtividadePK;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataHoraCadastro() {
        return dataHoraCadastro;
    }

    public void setDataHoraCadastro(Date dataHoraCadastro) {
        this.dataHoraCadastro = dataHoraCadastro;
    }

    public TipoAvaliacao getTipoAvaliacao() {
        return tipoAvaliacao;
    }

    public void setTipoAvaliacao(TipoAvaliacao tipoAvaliacao) {
        this.tipoAvaliacao = tipoAvaliacao;
    }

    @XmlTransient
    public List<Atividade> getAtividadeList() {
        return atividadeList;
    }

    public void setAtividadeList(List<Atividade> atividadeList) {
        this.atividadeList = atividadeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoAtividadePK != null ? tipoAtividadePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoAtividade)) {
            return false;
        }
        TipoAtividade other = (TipoAtividade) object;
        if ((this.tipoAtividadePK == null && other.tipoAtividadePK != null) || (this.tipoAtividadePK != null && !this.tipoAtividadePK.equals(other.tipoAtividadePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rj.handschool.modelo.TipoAtividade[ tipoAtividadePK=" + tipoAtividadePK + " ]";
    }
    
}
