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
@Table(name = "tipo_avaliacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoAvaliacao.findAll", query = "SELECT t FROM TipoAvaliacao t"),
    @NamedQuery(name = "TipoAvaliacao.findByIdtipoAvaliacao", query = "SELECT t FROM TipoAvaliacao t WHERE t.idtipoAvaliacao = :idtipoAvaliacao"),
    @NamedQuery(name = "TipoAvaliacao.findByAtivo", query = "SELECT t FROM TipoAvaliacao t WHERE t.ativo = :ativo"),
    @NamedQuery(name = "TipoAvaliacao.findByDataHoraCadastro", query = "SELECT t FROM TipoAvaliacao t WHERE t.dataHoraCadastro = :dataHoraCadastro"),
    @NamedQuery(name = "TipoAvaliacao.findByDataUltAtualizacao", query = "SELECT t FROM TipoAvaliacao t WHERE t.dataUltAtualizacao = :dataUltAtualizacao"),
    @NamedQuery(name = "TipoAvaliacao.findByNome", query = "SELECT t FROM TipoAvaliacao t WHERE t.nome = :nome")})
public class TipoAvaliacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDTIPO_AVALIACAO")
    private Integer idtipoAvaliacao;
    @Basic(optional = false)
    @Column(name = "ativo")
    private short ativo;
    @Column(name = "DATA_HORA_CADASTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraCadastro;
    @Column(name = "DATA_ULT_ATUALIZACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltAtualizacao;
    @Column(name = "nome")
    private String nome;
    @OneToMany(mappedBy = "idtipoAvaliacao")
    private List<Notas> notasList;

    public TipoAvaliacao() {
    }

    public TipoAvaliacao(Integer idtipoAvaliacao) {
        this.idtipoAvaliacao = idtipoAvaliacao;
    }

    public TipoAvaliacao(Integer idtipoAvaliacao, short ativo) {
        this.idtipoAvaliacao = idtipoAvaliacao;
        this.ativo = ativo;
    }

    public Integer getIdtipoAvaliacao() {
        return idtipoAvaliacao;
    }

    public void setIdtipoAvaliacao(Integer idtipoAvaliacao) {
        this.idtipoAvaliacao = idtipoAvaliacao;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
        hash += (idtipoAvaliacao != null ? idtipoAvaliacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
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
        return "bd.TipoAvaliacao[ idtipoAvaliacao=" + idtipoAvaliacao + " ]";
    }
    
}
