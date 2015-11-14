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
@Table(name = "forum")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Forum.findAll", query = "SELECT f FROM Forum f"),
    @NamedQuery(name = "Forum.findByIdforum", query = "SELECT f FROM Forum f WHERE f.idforum = :idforum"),
    @NamedQuery(name = "Forum.findByAssunto", query = "SELECT f FROM Forum f WHERE f.assunto = :assunto"),
    @NamedQuery(name = "Forum.findByDataHoraCadastro", query = "SELECT f FROM Forum f WHERE f.dataHoraCadastro = :dataHoraCadastro"),
    @NamedQuery(name = "Forum.findByDataUltAtualizacao", query = "SELECT f FROM Forum f WHERE f.dataUltAtualizacao = :dataUltAtualizacao"),
    @NamedQuery(name = "Forum.findByDescricao", query = "SELECT f FROM Forum f WHERE f.descricao = :descricao"),
    @NamedQuery(name = "Forum.findByIdcurso", query = "SELECT f FROM Forum f WHERE f.idcurso = :idcurso")})
public class Forum implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idforum")
    private Integer idforum;
    @Column(name = "assunto")
    private String assunto;
    @Column(name = "DATA_HORA_CADASTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraCadastro;
    @Column(name = "DATA_ULT_ATUALIZACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltAtualizacao;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "idcurso")
    private String idcurso;
    @JoinColumn(name = "IDLOGIN", referencedColumnName = "idlogin")
    @ManyToOne
    private Login idlogin;
    @OneToMany(mappedBy = "idforum")
    private List<ForumComentario> forumComentarioList;

    public Forum() {
    }

    public Forum(Integer idforum) {
        this.idforum = idforum;
    }

    public Integer getIdforum() {
        return idforum;
    }

    public void setIdforum(Integer idforum) {
        this.idforum = idforum;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
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

    public String getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(String idcurso) {
        this.idcurso = idcurso;
    }

    public Login getIdlogin() {
        return idlogin;
    }

    public void setIdlogin(Login idlogin) {
        this.idlogin = idlogin;
    }

    @XmlTransient
    public List<ForumComentario> getForumComentarioList() {
        return forumComentarioList;
    }

    public void setForumComentarioList(List<ForumComentario> forumComentarioList) {
        this.forumComentarioList = forumComentarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idforum != null ? idforum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Forum)) {
            return false;
        }
        Forum other = (Forum) object;
        if ((this.idforum == null && other.idforum != null) || (this.idforum != null && !this.idforum.equals(other.idforum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bd.Forum[ idforum=" + idforum + " ]";
    }
    
}
