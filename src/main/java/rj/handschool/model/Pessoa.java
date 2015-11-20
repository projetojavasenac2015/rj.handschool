/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rj.handschool.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.Formula;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Renan
 */
@Entity
@Table(name = "pessoa")
@Inheritance(strategy=InheritanceType.JOINED)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p"),
    @NamedQuery(name = "Pessoa.findByDataHoraCadastro", query = "SELECT p FROM Pessoa p WHERE p.dataHoraCadastro = :dataHoraCadastro"),
    @NamedQuery(name = "Pessoa.findByDataUltAlteracao", query = "SELECT p FROM Pessoa p WHERE p.dataUltAlteracao = :dataUltAlteracao"),
    @NamedQuery(name = "Pessoa.findByDataNascimento", query = "SELECT p FROM Pessoa p WHERE p.dataNascimento = :dataNascimento"),
    @NamedQuery(name = "Pessoa.findByNome", query = "SELECT p FROM Pessoa p WHERE p.nome = :nome"),
    @NamedQuery(name = "Pessoa.findByRg", query = "SELECT p FROM Pessoa p WHERE p.rg = :rg"),
    @NamedQuery(name = "Pessoa.findByEmail", query = "SELECT p FROM Pessoa p WHERE p.email = :email"),
    @NamedQuery(name = "Pessoa.findBySenha", query = "SELECT p FROM Pessoa p WHERE p.senha = :senha")})
   
public abstract class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpessoa")
    protected int idpessoa;
    @Column(name = "data_hora_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date dataHoraCadastro;
    @Column(name = "data_ult_alteracao")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date dataUltAlteracao;
    @NotNull(message="Data de nascimento não informada")
    @DateTimeFormat(pattern="d/MM/yyyy")
    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    protected Date dataNascimento;
    @NotEmpty(message="Nome não informado")
    @Column(name = "nome")
    protected String nome;
    @NotNull @NotEmpty(message="RG Não Informado")
    @Column(name = "rg")
    protected String rg;
    @NotNull @NotEmpty(message="E-mail Não Informado")
    @Pattern(regexp = ".+@.+\\.[a-z]+")
    @Column(name = "email")
    private String email;
    @NotNull @NotEmpty(message="Senha não informada")
    @Size(min=4, max=12,message="A Senha é muito fraca ou está fora do intervalo permitido")
    @Column(name = "senha")
    protected String senha;
    @NotNull
    @JoinColumn(name = "id_tipo_pessoa", referencedColumnName = "idtipo_pessoa", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    protected TipoPessoa tipoPessoa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa")
    protected List<Login> loginList;
    @NotNull(message="CPF Nulo")
    @NotEmpty(message="CPF não informado")
    @Basic(optional = false)
    @Column(name = "cpf")
    protected String cpf;
    
    public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Pessoa() {
    }
    
    public int getIdpessoa() {
		return idpessoa;
	}

	public void setIdpessoa(int idpessoa) {
		this.idpessoa = idpessoa;
	}

	public Pessoa(int idpessoa) {
        this.idpessoa = idpessoa;
    }

    public Date getDataHoraCadastro() {
        return dataHoraCadastro;
    }

    public void setDataHoraCadastro(Date dataHoraCadastro) {
        this.dataHoraCadastro = dataHoraCadastro;
    }

    public Date getDataUltAlteracao() {
        return dataUltAlteracao;
    }

    public void setDataUltAlteracao(Date dataUltAlteracao) {
        this.dataUltAlteracao = dataUltAlteracao;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    @XmlTransient
    public List<Login> getLoginList() {
        return loginList;
    }

    public void setLoginList(List<Login> loginList) {
        this.loginList = loginList;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idpessoa;
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
		Pessoa other = (Pessoa) obj;
		if (idpessoa != other.idpessoa)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pessoa [idpessoa=" + idpessoa + ", dataHoraCadastro="
				+ dataHoraCadastro + ", dataUltAlteracao=" + dataUltAlteracao
				+ ", dataNascimento=" + dataNascimento + ", nome=" + nome
				+ ", rg=" + rg + ", email=" + email + ", senha=" + senha
				+ ", tipoPessoa=" + tipoPessoa + ","
				+ "loginList="
				+ loginList + "]";
	}
        
}
