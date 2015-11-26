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
@Table(name = "avaliacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Avaliacao.findAll", query = "SELECT a FROM Avaliacao a"),
    @NamedQuery(name = "Avaliacao.findByIdavaliacao", query = "SELECT a FROM Avaliacao a WHERE a.avaliacaoPK.idavaliacao = :idavaliacao"),
    @NamedQuery(name = "Avaliacao.findByDataHoraCadastro", query = "SELECT a FROM Avaliacao a WHERE a.dataHoraCadastro = :dataHoraCadastro"),
    @NamedQuery(name = "Avaliacao.findByDataUltAtualizacao", query = "SELECT a FROM Avaliacao a WHERE a.dataUltAtualizacao = :dataUltAtualizacao"),
    @NamedQuery(name = "Avaliacao.findByIdTipoAvaliacao", query = "SELECT a FROM Avaliacao a WHERE a.avaliacaoPK.idTipoAvaliacao = :idTipoAvaliacao")})
public class Avaliacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AvaliacaoPK avaliacaoPK;
    
    @Column(name = "data_hora_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraCadastro;
    
    @Column(name = "data_ult_atualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltAtualizacao;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "avaliacao")
    private List<AvaliacaoAluno> avaliacaoAlunoList;
    
    @JoinColumn(name = "id_tipo_avaliacao", referencedColumnName = "idtipo_avaliacao", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoAvaliacao tipoAvaliacao;

    public Avaliacao() {
    }

    public Avaliacao(AvaliacaoPK avaliacaoPK) {
        this.avaliacaoPK = avaliacaoPK;
    }

    public Avaliacao(int idavaliacao, int idTipoAvaliacao) {
        this.avaliacaoPK = new AvaliacaoPK(idavaliacao, idTipoAvaliacao);
    }

    public AvaliacaoPK getAvaliacaoPK() {
        return avaliacaoPK;
    }

    public void setAvaliacaoPK(AvaliacaoPK avaliacaoPK) {
        this.avaliacaoPK = avaliacaoPK;
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

    @XmlTransient
    public List<AvaliacaoAluno> getAvaliacaoAlunoList() {
        return avaliacaoAlunoList;
    }

    public void setAvaliacaoAlunoList(List<AvaliacaoAluno> avaliacaoAlunoList) {
        this.avaliacaoAlunoList = avaliacaoAlunoList;
    }

    public TipoAvaliacao getTipoAvaliacao() {
        return tipoAvaliacao;
    }

    public void setTipoAvaliacao(TipoAvaliacao tipoAvaliacao) {
        this.tipoAvaliacao = tipoAvaliacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (avaliacaoPK != null ? avaliacaoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Avaliacao)) {
            return false;
        }
        Avaliacao other = (Avaliacao) object;
        if ((this.avaliacaoPK == null && other.avaliacaoPK != null) || (this.avaliacaoPK != null && !this.avaliacaoPK.equals(other.avaliacaoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rj.handschool.modelo.Avaliacao[ avaliacaoPK=" + avaliacaoPK + " ]";
    }
    
}
