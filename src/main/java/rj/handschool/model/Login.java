/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rj.handschool.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Renan
 */
@Entity
@Table(name = "login")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Login.findAll", query = "SELECT l FROM Login l"),
    @NamedQuery(name = "Login.findByIdlogin", query = "SELECT l FROM Login l WHERE l.loginPK.idlogin = :idlogin"),
    @NamedQuery(name = "Login.findByAtivo", query = "SELECT l FROM Login l WHERE l.ativo = :ativo"),
    @NamedQuery(name = "Login.findByIdPerfil", query = "SELECT l FROM Login l WHERE l.loginPK.idPerfil = :idPerfil"),
    @NamedQuery(name = "Login.findByIdPessoa", query = "SELECT l FROM Login l WHERE l.loginPK.idPessoa = :idPessoa")})
public class Login implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LoginPK loginPK;
    @Column(name = "ativo")
    private Character ativo;
    @JoinColumn(name = "id_pessoa", referencedColumnName = "idpessoa", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pessoa pessoa;
    @JoinColumn(name = "id_perfil", referencedColumnName = "idperfil", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Perfil perfil;

    public Login() {
    }

    public Login(LoginPK loginPK) {
        this.loginPK = loginPK;
    }

    public Login(int idlogin, int idPerfil, int idPessoa) {
        this.loginPK = new LoginPK(idlogin, idPerfil, idPessoa);
    }

    public LoginPK getLoginPK() {
        return loginPK;
    }

    public void setLoginPK(LoginPK loginPK) {
        this.loginPK = loginPK;
    }

    public Character getAtivo() {
        return ativo;
    }

    public void setAtivo(Character ativo) {
        this.ativo = ativo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (loginPK != null ? loginPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Login)) {
            return false;
        }
        Login other = (Login) object;
        if ((this.loginPK == null && other.loginPK != null) || (this.loginPK != null && !this.loginPK.equals(other.loginPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rj.handschool.modelo.Login[ loginPK=" + loginPK + " ]";
    }
    
}
