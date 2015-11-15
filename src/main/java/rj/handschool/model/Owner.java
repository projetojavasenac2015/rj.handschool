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
@Table(name = "owner")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Owner.findAll", query = "SELECT o FROM Owner o"),
    @NamedQuery(name = "Owner.findByIdowner", query = "SELECT o FROM Owner o WHERE o.ownerPK.idowner = :idowner"),
    @NamedQuery(name = "Owner.findByNome", query = "SELECT o FROM Owner o WHERE o.nome = :nome"),
    @NamedQuery(name = "Owner.findByFuncao", query = "SELECT o FROM Owner o WHERE o.funcao = :funcao"),
    @NamedQuery(name = "Owner.findByIdPessoa", query = "SELECT o FROM Owner o WHERE o.ownerPK.idPessoa = :idPessoa")})
public class Owner implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OwnerPK ownerPK;
    @Column(name = "nome")
    private String nome;
    @Column(name = "funcao")
    private String funcao;
    @JoinColumns({
    	@JoinColumn(name = "id_pessoa", referencedColumnName = "idpessoa", insertable = false, updatable = false)
    	,@JoinColumn(name = "cpf", referencedColumnName = "cpf", insertable = false, updatable = false)
    	,@JoinColumn(name = "id_tipo_pessoa", referencedColumnName = "id_tipo_pessoa", insertable = false, updatable = false)
    })
    @ManyToOne(optional = false)
    private Pessoa pessoa;

    public Owner() {
    }

    public Owner(OwnerPK ownerPK) {
        this.ownerPK = ownerPK;
    }

    public Owner(int idowner, int idPessoa) {
        this.ownerPK = new OwnerPK(idowner, idPessoa);
    }

    public OwnerPK getOwnerPK() {
        return ownerPK;
    }

    public void setOwnerPK(OwnerPK ownerPK) {
        this.ownerPK = ownerPK;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ownerPK != null ? ownerPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Owner)) {
            return false;
        }
        Owner other = (Owner) object;
        if ((this.ownerPK == null && other.ownerPK != null) || (this.ownerPK != null && !this.ownerPK.equals(other.ownerPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rj.handschool.modelo.Owner[ ownerPK=" + ownerPK + " ]";
    }
    
}
