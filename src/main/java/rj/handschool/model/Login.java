package rj.handschool.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "login")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Login.findAll", query = "SELECT l FROM Login l"),    
    @NamedQuery(name = "Login.findByAtivo", query = "SELECT l FROM Login l WHERE l.ativo = :ativo"),
   })
public class Login implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlogin")
    private int idlogin;    
     
    @Column(name = "ativo")
    private Character ativo;
    
    @JoinColumn(name = "idpessoa", referencedColumnName = "idpessoa")
    @ManyToOne(optional = false)
    private Pessoa pessoa;    
   

    public Login() {
    }


	public int getIdlogin() {
		return idlogin;
	}


	public void setIdlogin(int idlogin) {
		this.idlogin = idlogin;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idlogin;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Login other = (Login) obj;
		if (idlogin != other.idlogin)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Login [idlogin=" + idlogin + ", ativo=" + ativo + ", pessoa="
				+ pessoa + "]";
	}    
}
