/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rj.handschool.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Renan
 */
@Entity
@Table(name = "acesso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acesso.findAll", query = "SELECT a FROM Acesso a"),
    @NamedQuery(name = "Acesso.findByIdacesso", query = "SELECT a FROM Acesso a WHERE a.idacesso = :idacesso"),
    @NamedQuery(name = "Acesso.findByAtivo", query = "SELECT a FROM Acesso a WHERE a.ativo = :ativo"),
    @NamedQuery(name = "Acesso.findByDataHoraCadastro", query = "SELECT a FROM Acesso a WHERE a.dataHoraCadastro = :dataHoraCadastro"),
    @NamedQuery(name = "Acesso.findByDataUltAtualizacao", query = "SELECT a FROM Acesso a WHERE a.dataUltAtualizacao = :dataUltAtualizacao"),
    @NamedQuery(name = "Acesso.findByNome", query = "SELECT a FROM Acesso a WHERE a.nome = :nome"),
    @NamedQuery(name = "Acesso.findByUrl", query = "SELECT a FROM Acesso a WHERE a.url = :url")})
public class Acesso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idacesso")
    private Integer idacesso;
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
    @Column(name = "url")
    private String url;
    @JoinColumn(name = "IDPERFIL", referencedColumnName = "idperfil")
    @ManyToOne
    private Perfil idperfil;

    public Acesso() {
    }

    public Acesso(Integer idacesso) {
        this.idacesso = idacesso;
    }

    public Acesso(Integer idacesso, short ativo) {
        this.idacesso = idacesso;
        this.ativo = ativo;
    }

    public Integer getIdacesso() {
        return idacesso;
    }

    public void setIdacesso(Integer idacesso) {
        this.idacesso = idacesso;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Perfil getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(Perfil idperfil) {
        this.idperfil = idperfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idacesso != null ? idacesso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acesso)) {
            return false;
        }
        Acesso other = (Acesso) object;
        if ((this.idacesso == null && other.idacesso != null) || (this.idacesso != null && !this.idacesso.equals(other.idacesso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bd.Acesso[ idacesso=" + idacesso + " ]";
    }
    
}
