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
@Table(name = "pessoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p"),
    @NamedQuery(name = "Pessoa.findByIdpessoa", query = "SELECT p FROM Pessoa p WHERE p.pessoaPK.idpessoa = :idpessoa"),
    @NamedQuery(name = "Pessoa.findByCpf", query = "SELECT p FROM Pessoa p WHERE p.pessoaPK.cpf = :cpf"),
    @NamedQuery(name = "Pessoa.findByDataHoraCadastro", query = "SELECT p FROM Pessoa p WHERE p.dataHoraCadastro = :dataHoraCadastro"),
    @NamedQuery(name = "Pessoa.findByDataUltAlteracao", query = "SELECT p FROM Pessoa p WHERE p.dataUltAlteracao = :dataUltAlteracao"),
    @NamedQuery(name = "Pessoa.findByDataNascimento", query = "SELECT p FROM Pessoa p WHERE p.dataNascimento = :dataNascimento"),
    @NamedQuery(name = "Pessoa.findByNome", query = "SELECT p FROM Pessoa p WHERE p.nome = :nome"),
    @NamedQuery(name = "Pessoa.findByRg", query = "SELECT p FROM Pessoa p WHERE p.rg = :rg"),
    @NamedQuery(name = "Pessoa.findByEmail", query = "SELECT p FROM Pessoa p WHERE p.email = :email"),
    @NamedQuery(name = "Pessoa.findBySenha", query = "SELECT p FROM Pessoa p WHERE p.senha = :senha"),
    @NamedQuery(name = "Pessoa.findByIdTipoPessoa", query = "SELECT p FROM Pessoa p WHERE p.pessoaPK.idTipoPessoa = :idTipoPessoa")})
	@NamedQuery(name = "Pessoa.DeleteForPessoaPK", query = "DELETE FROM Pessoa p WHERE p.pessoaPK = :pessoaPK ")
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PessoaPK pessoaPK;
    @Column(name = "data_hora_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraCadastro;
    @Column(name = "data_ult_alteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltAlteracao;
    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Column(name = "nome")
    private String nome;
    @Column(name = "rg")
    private String rg;
    @Column(name = "email")
    private String email;
    @Column(name = "senha")
    private String senha;
    @JoinColumn(name = "id_tipo_pessoa", referencedColumnName = "idtipo_pessoa", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoPessoa tipoPessoa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa")
    private List<Aluno> alunoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa")
    private List<Owner> ownerList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa")
    private List<Professor> professorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa")
    private List<Login> loginList;

    public Pessoa() {
    }

    public Pessoa(PessoaPK pessoaPK) {
        this.pessoaPK = pessoaPK;
    }

    public Pessoa(int idpessoa, int cpf, int idTipoPessoa) {
        this.pessoaPK = new PessoaPK(idpessoa, cpf, idTipoPessoa);
    }

    public PessoaPK getPessoaPK() {
        return pessoaPK;
    }

    public void setPessoaPK(PessoaPK pessoaPK) {
        this.pessoaPK = pessoaPK;
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
    public List<Aluno> getAlunoList() {
        return alunoList;
    }

    public void setAlunoList(List<Aluno> alunoList) {
        this.alunoList = alunoList;
    }

    @XmlTransient
    public List<Owner> getOwnerList() {
        return ownerList;
    }

    public void setOwnerList(List<Owner> ownerList) {
        this.ownerList = ownerList;
    }

    @XmlTransient
    public List<Professor> getProfessorList() {
        return professorList;
    }

    public void setProfessorList(List<Professor> professorList) {
        this.professorList = professorList;
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
        int hash = 0;
        hash += (pessoaPK != null ? pessoaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.pessoaPK == null && other.pessoaPK != null) || (this.pessoaPK != null && !this.pessoaPK.equals(other.pessoaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rj.handschool.modelo.Pessoa[ pessoaPK=" + pessoaPK + " ]";
    }
    
}
