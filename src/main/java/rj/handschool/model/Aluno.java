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
@Table(name = "aluno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aluno.findAll", query = "SELECT a FROM Aluno a"),
    @NamedQuery(name = "Aluno.findByIdaluno", query = "SELECT a FROM Aluno a WHERE a.alunoPK.idaluno = :idaluno"),
    @NamedQuery(name = "Aluno.findByMatricula", query = "SELECT a FROM Aluno a WHERE a.alunoPK.matricula = :matricula"),
    @NamedQuery(name = "Aluno.findByAtivo", query = "SELECT a FROM Aluno a WHERE a.ativo = :ativo"),
    @NamedQuery(name = "Aluno.findByDataHoraCadastro", query = "SELECT a FROM Aluno a WHERE a.dataHoraCadastro = :dataHoraCadastro"),
    @NamedQuery(name = "Aluno.findByIdPessoa", query = "SELECT a FROM Aluno a WHERE a.alunoPK.idPessoa = :idPessoa")})
public class Aluno implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AlunoPK alunoPK;
    @Column(name = "ativo")
    private Character ativo;
    @Column(name = "data_hora_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraCadastro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aluno")
    private List<AvaliacaoAluno> avaliacaoAlunoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aluno")
    private List<ListaPresenca> listapresencaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aluno")
    private List<Responsaveis> responsaveisList;
    @JoinColumns({
    	@JoinColumn(name = "id_pessoa", referencedColumnName = "idpessoa", insertable = false, updatable = false)
    	,@JoinColumn(name = "id_tipo_pessoa", referencedColumnName = "idTipoPessoa", insertable = false, updatable = false)
    	,@JoinColumn(name = "cpf", referencedColumnName = "cpf", insertable = false, updatable = false)
    })
    @ManyToOne(optional = false)
    private Pessoa pessoa;

    public Aluno() {
    }

    public Aluno(AlunoPK alunoPK) {
        this.alunoPK = alunoPK;
    }

    public Aluno(int idaluno, String matricula, int idPessoa) {
        this.alunoPK = new AlunoPK(idaluno, matricula, idPessoa);
    }

    public AlunoPK getAlunoPK() {
        return alunoPK;
    }

    public void setAlunoPK(AlunoPK alunoPK) {
        this.alunoPK = alunoPK;
    }

    public Character getAtivo() {
        return ativo;
    }

    public void setAtivo(Character ativo) {
        this.ativo = ativo;
    }

    public Date getDataHoraCadastro() {
        return dataHoraCadastro;
    }

    public void setDataHoraCadastro(Date dataHoraCadastro) {
        this.dataHoraCadastro = dataHoraCadastro;
    }

    @XmlTransient
    public List<AvaliacaoAluno> getAvaliacaoAlunoList() {
        return avaliacaoAlunoList;
    }

    public void setAvaliacaoAlunoList(List<AvaliacaoAluno> avaliacaoAlunoList) {
        this.avaliacaoAlunoList = avaliacaoAlunoList;
    }

    @XmlTransient
    public List<ListaPresenca> getListapresencaList() {
        return listapresencaList;
    }

    public void setListapresencaList(List<ListaPresenca> listapresencaList) {
        this.listapresencaList = listapresencaList;
    }

    @XmlTransient
    public List<Responsaveis> getResponsaveisList() {
        return responsaveisList;
    }

    public void setResponsaveisList(List<Responsaveis> responsaveisList) {
        this.responsaveisList = responsaveisList;
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
        hash += (alunoPK != null ? alunoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aluno)) {
            return false;
        }
        Aluno other = (Aluno) object;
        if ((this.alunoPK == null && other.alunoPK != null) || (this.alunoPK != null && !this.alunoPK.equals(other.alunoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rj.handschool.modelo.Aluno[ alunoPK=" + alunoPK + " ]";
    }
    
}
