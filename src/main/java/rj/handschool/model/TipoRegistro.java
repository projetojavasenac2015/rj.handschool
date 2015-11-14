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
@Table(name = "tipo_registro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoRegistro.findAll", query = "SELECT t FROM TipoRegistro t"),
    @NamedQuery(name = "TipoRegistro.findByIdtipoRegistro", query = "SELECT t FROM TipoRegistro t WHERE t.idtipoRegistro = :idtipoRegistro"),
    @NamedQuery(name = "TipoRegistro.findByAtivo", query = "SELECT t FROM TipoRegistro t WHERE t.ativo = :ativo"),
    @NamedQuery(name = "TipoRegistro.findByDataHoraCadastro", query = "SELECT t FROM TipoRegistro t WHERE t.dataHoraCadastro = :dataHoraCadastro"),
    @NamedQuery(name = "TipoRegistro.findByDataUltAtualizacao", query = "SELECT t FROM TipoRegistro t WHERE t.dataUltAtualizacao = :dataUltAtualizacao"),
    @NamedQuery(name = "TipoRegistro.findByNome", query = "SELECT t FROM TipoRegistro t WHERE t.nome = :nome")})
public class TipoRegistro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDTIPO_REGISTRO")
    private Integer idtipoRegistro;
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
    @OneToMany(mappedBy = "idtipoRegistro")
    private List<ListaPresenca> listaPresencaList;

    public TipoRegistro() {
    }

    public TipoRegistro(Integer idtipoRegistro) {
        this.idtipoRegistro = idtipoRegistro;
    }

    public TipoRegistro(Integer idtipoRegistro, short ativo) {
        this.idtipoRegistro = idtipoRegistro;
        this.ativo = ativo;
    }

    public Integer getIdtipoRegistro() {
        return idtipoRegistro;
    }

    public void setIdtipoRegistro(Integer idtipoRegistro) {
        this.idtipoRegistro = idtipoRegistro;
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
    public List<ListaPresenca> getListaPresencaList() {
        return listaPresencaList;
    }

    public void setListaPresencaList(List<ListaPresenca> listaPresencaList) {
        this.listaPresencaList = listaPresencaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoRegistro != null ? idtipoRegistro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoRegistro)) {
            return false;
        }
        TipoRegistro other = (TipoRegistro) object;
        if ((this.idtipoRegistro == null && other.idtipoRegistro != null) || (this.idtipoRegistro != null && !this.idtipoRegistro.equals(other.idtipoRegistro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bd.TipoRegistro[ idtipoRegistro=" + idtipoRegistro + " ]";
    }
    
}
