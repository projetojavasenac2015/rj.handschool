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
@Table(name = "login")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Login.findAll", query = "SELECT l FROM Login l"),
    @NamedQuery(name = "Login.findByIdlogin", query = "SELECT l FROM Login l WHERE l.idlogin = :idlogin"),
    @NamedQuery(name = "Login.findByAtivo", query = "SELECT l FROM Login l WHERE l.ativo = :ativo"),
    @NamedQuery(name = "Login.findByDataHoraCadastro", query = "SELECT l FROM Login l WHERE l.dataHoraCadastro = :dataHoraCadastro"),
    @NamedQuery(name = "Login.findByDataUltAtualizacao", query = "SELECT l FROM Login l WHERE l.dataUltAtualizacao = :dataUltAtualizacao"),
    @NamedQuery(name = "Login.findByEmail", query = "SELECT l FROM Login l WHERE l.email = :email"),
    @NamedQuery(name = "Login.findByMatricula", query = "SELECT l FROM Login l WHERE l.matricula = :matricula"),
    @NamedQuery(name = "Login.findBySenha", query = "SELECT l FROM Login l WHERE l.senha = :senha")})
public class Login implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlogin")
    private Integer idlogin;
    @Basic(optional = false)
    @Column(name = "ativo")
    private short ativo;
    @Column(name = "DATA_HORA_CADASTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraCadastro;
    @Column(name = "DATA_ULT_ATUALIZACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltAtualizacao;
    @Column(name = "email")
    private String email;
    @Column(name = "matricula")
    private String matricula;
    @Column(name = "senha")
    private String senha;
    @OneToMany(mappedBy = "idlogin")
    private List<Forum> forumList;
    @OneToMany(mappedBy = "idlogin")
    private List<ForumComentario> forumComentarioList;
    @JoinColumn(name = "IDPERFIL", referencedColumnName = "idperfil")
    @ManyToOne
    private Perfil idperfil;
    @JoinColumn(name = "IDPESSOA", referencedColumnName = "idpessoa")
    @ManyToOne
    private Pessoa idpessoa;

    public Login() {
    }

    public Login(Integer idlogin) {
        this.idlogin = idlogin;
    }

    public Login(Integer idlogin, short ativo) {
        this.idlogin = idlogin;
        this.ativo = ativo;
    }

    public Integer getIdlogin() {
        return idlogin;
    }

    public void setIdlogin(Integer idlogin) {
        this.idlogin = idlogin;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @XmlTransient
    public List<Forum> getForumList() {
        return forumList;
    }

    public void setForumList(List<Forum> forumList) {
        this.forumList = forumList;
    }

    @XmlTransient
    public List<ForumComentario> getForumComentarioList() {
        return forumComentarioList;
    }

    public void setForumComentarioList(List<ForumComentario> forumComentarioList) {
        this.forumComentarioList = forumComentarioList;
    }

    public Perfil getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(Perfil idperfil) {
        this.idperfil = idperfil;
    }

    public Pessoa getIdpessoa() {
        return idpessoa;
    }

    public void setIdpessoa(Pessoa idpessoa) {
        this.idpessoa = idpessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlogin != null ? idlogin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Login)) {
            return false;
        }
        Login other = (Login) object;
        if ((this.idlogin == null && other.idlogin != null) || (this.idlogin != null && !this.idlogin.equals(other.idlogin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bd.Login[ idlogin=" + idlogin + " ]";
    }
    
}
