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
    @NamedQuery(name = "Pessoa.findByIdpessoa", query = "SELECT p FROM Pessoa p WHERE p.idpessoa = :idpessoa"),
    @NamedQuery(name = "Pessoa.findByCpf", query = "SELECT p FROM Pessoa p WHERE p.cpf = :cpf"),
    @NamedQuery(name = "Pessoa.findByDataHoraCadastro", query = "SELECT p FROM Pessoa p WHERE p.dataHoraCadastro = :dataHoraCadastro"),
    @NamedQuery(name = "Pessoa.findByDataNascimento", query = "SELECT p FROM Pessoa p WHERE p.dataNascimento = :dataNascimento"),
    @NamedQuery(name = "Pessoa.findByDataUltAtualizacao", query = "SELECT p FROM Pessoa p WHERE p.dataUltAtualizacao = :dataUltAtualizacao"),
    @NamedQuery(name = "Pessoa.findByEmail", query = "SELECT p FROM Pessoa p WHERE p.email = :email"),
    @NamedQuery(name = "Pessoa.findByMatricula", query = "SELECT p FROM Pessoa p WHERE p.matricula = :matricula"),
    @NamedQuery(name = "Pessoa.findByMunicipioNascimento", query = "SELECT p FROM Pessoa p WHERE p.municipioNascimento = :municipioNascimento"),
    @NamedQuery(name = "Pessoa.findByNome", query = "SELECT p FROM Pessoa p WHERE p.nome = :nome"),
    @NamedQuery(name = "Pessoa.findByPaisNascimento", query = "SELECT p FROM Pessoa p WHERE p.paisNascimento = :paisNascimento"),
    @NamedQuery(name = "Pessoa.findByRg", query = "SELECT p FROM Pessoa p WHERE p.rg = :rg"),
    @NamedQuery(name = "Pessoa.findByRgDocumento", query = "SELECT p FROM Pessoa p WHERE p.rgDocumento = :rgDocumento"),
    @NamedQuery(name = "Pessoa.findBySenha", query = "SELECT p FROM Pessoa p WHERE p.senha = :senha")})
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpessoa")
    private Integer idpessoa;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "DATA_HORA_CADASTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraCadastro;
    @Column(name = "DATA_NASCIMENTO")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Column(name = "DATA_ULT_ATUALIZACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltAtualizacao;
    @Column(name = "email")
    private String email;
    @Column(name = "matricula")
    private String matricula;
    @Column(name = "MUNICIPIO_NASCIMENTO")
    private String municipioNascimento;
    @Column(name = "nome")
    private String nome;
    @Column(name = "PAIS_NASCIMENTO")
    private String paisNascimento;
    @Column(name = "rg")
    private String rg;
    @Column(name = "RG_DOCUMENTO")
    private String rgDocumento;
    @Column(name = "senha")
    private String senha;
    @JoinColumn(name = "IDTIPO_PESSOA", referencedColumnName = "IDTIPO_PESSOA")
    @ManyToOne
    private TipoPessoa idtipoPessoa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa")
    private List<Aluno> alunoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa")
    private List<Owner> ownerList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa")
    private List<Professor> professorList;
    @OneToMany(mappedBy = "idpessoa")
    private List<Login> loginList;

    public Pessoa() {
    }

    public Pessoa(Integer idpessoa) {
        this.idpessoa = idpessoa;
    }

    public Integer getIdpessoa() {
        return idpessoa;
    }

    public void setIdpessoa(Integer idpessoa) {
        this.idpessoa = idpessoa;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataHoraCadastro() {
        return dataHoraCadastro;
    }

    public void setDataHoraCadastro(Date dataHoraCadastro) {
        this.dataHoraCadastro = dataHoraCadastro;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
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

    public String getMunicipioNascimento() {
        return municipioNascimento;
    }

    public void setMunicipioNascimento(String municipioNascimento) {
        this.municipioNascimento = municipioNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPaisNascimento() {
        return paisNascimento;
    }

    public void setPaisNascimento(String paisNascimento) {
        this.paisNascimento = paisNascimento;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getRgDocumento() {
        return rgDocumento;
    }

    public void setRgDocumento(String rgDocumento) {
        this.rgDocumento = rgDocumento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoPessoa getIdtipoPessoa() {
        return idtipoPessoa;
    }

    public void setIdtipoPessoa(TipoPessoa idtipoPessoa) {
        this.idtipoPessoa = idtipoPessoa;
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
        hash += (idpessoa != null ? idpessoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.idpessoa == null && other.idpessoa != null) || (this.idpessoa != null && !this.idpessoa.equals(other.idpessoa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bd.Pessoa[ idpessoa=" + idpessoa + " ]";
    }
    
}
