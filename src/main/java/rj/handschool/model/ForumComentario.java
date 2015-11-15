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
@Table(name = "forum_comentario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ForumComentario.findAll", query = "SELECT f FROM ForumComentario f"),
    @NamedQuery(name = "ForumComentario.findByIdforumComentario", query = "SELECT f FROM ForumComentario f WHERE f.idforumComentario = :idforumComentario"),
    @NamedQuery(name = "ForumComentario.findByAtivo", query = "SELECT f FROM ForumComentario f WHERE f.ativo = :ativo"),
    @NamedQuery(name = "ForumComentario.findByComentario", query = "SELECT f FROM ForumComentario f WHERE f.comentario = :comentario"),
    @NamedQuery(name = "ForumComentario.findByDataHoraCadastro", query = "SELECT f FROM ForumComentario f WHERE f.dataHoraCadastro = :dataHoraCadastro"),
    @NamedQuery(name = "ForumComentario.findByDataUltAtualizacao", query = "SELECT f FROM ForumComentario f WHERE f.dataUltAtualizacao = :dataUltAtualizacao")})
public class ForumComentario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDFORUM_COMENTARIO")
    private Integer idforumComentario;
    @Basic(optional = false)
    @Column(name = "ativo")
    private short ativo;
    @Column(name = "comentario")
    private String comentario;
    @Column(name = "DATA_HORA_CADASTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraCadastro;
    @Column(name = "DATA_ULT_ATUALIZACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltAtualizacao;
    @JoinColumn(name = "IDFORUM", referencedColumnName = "idforum")
    @ManyToOne
    private Forum idforum;
    @JoinColumn(name = "IDLOGIN", referencedColumnName = "idlogin")
    @ManyToOne
    private Login idlogin;

    public ForumComentario() {
    }

    public ForumComentario(Integer idforumComentario) {
        this.idforumComentario = idforumComentario;
    }

    public ForumComentario(Integer idforumComentario, short ativo) {
        this.idforumComentario = idforumComentario;
        this.ativo = ativo;
    }

    public Integer getIdforumComentario() {
        return idforumComentario;
    }

    public void setIdforumComentario(Integer idforumComentario) {
        this.idforumComentario = idforumComentario;
    }

    public short getAtivo() {
        return ativo;
    }

    public void setAtivo(short ativo) {
        this.ativo = ativo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
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

    public Forum getIdforum() {
        return idforum;
    }

    public void setIdforum(Forum idforum) {
        this.idforum = idforum;
    }

    public Login getIdlogin() {
        return idlogin;
    }

    public void setIdlogin(Login idlogin) {
        this.idlogin = idlogin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idforumComentario != null ? idforumComentario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ForumComentario)) {
            return false;
        }
        ForumComentario other = (ForumComentario) object;
        if ((this.idforumComentario == null && other.idforumComentario != null) || (this.idforumComentario != null && !this.idforumComentario.equals(other.idforumComentario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bd.ForumComentario[ idforumComentario=" + idforumComentario + " ]";
    }
    
}
