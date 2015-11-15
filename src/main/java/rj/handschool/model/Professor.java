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
@Table(name = "professor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Professor.findAll", query = "SELECT p FROM Professor p"),
    @NamedQuery(name = "Professor.findByIdprofessor", query = "SELECT p FROM Professor p WHERE p.professorPK.idprofessor = :idprofessor"),
    @NamedQuery(name = "Professor.findByMatricula", query = "SELECT p FROM Professor p WHERE p.professorPK.matricula = :matricula"),
    @NamedQuery(name = "Professor.findByAtivo", query = "SELECT p FROM Professor p WHERE p.ativo = :ativo"),
    @NamedQuery(name = "Professor.findByDataHoraCadastro", query = "SELECT p FROM Professor p WHERE p.dataHoraCadastro = :dataHoraCadastro"),
    @NamedQuery(name = "Professor.findByDataUltAtualizacao", query = "SELECT p FROM Professor p WHERE p.dataUltAtualizacao = :dataUltAtualizacao"),
    @NamedQuery(name = "Professor.findByIdPessoa", query = "SELECT p FROM Professor p WHERE p.professorPK.idPessoa = :idPessoa")})
public class Professor implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProfessorPK professorPK;
    @Column(name = "ativo")
    private Character ativo;
    @Column(name = "data_hora_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraCadastro;
    @Column(name = "data_ult_atualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltAtualizacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "professor")
    private List<QuadroAvisos> quadroAvisosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "professor")
    private List<Alocacao> alocacaoList;
    @JoinColumns({
    	@JoinColumn(name = "id_pessoa", referencedColumnName = "idpessoa", insertable = false, updatable = false)
    	,@JoinColumn(name = "cpf", referencedColumnName = "cpf", insertable = false, updatable = false)
    	,@JoinColumn(name = "id_tipo_pessoa", referencedColumnName = "id_tipo_pessoa", insertable = false, updatable = false)
    })
    @ManyToOne(optional = false)
    private Pessoa pessoa;

    public Professor() {
    }

    public Professor(ProfessorPK professorPK) {
        this.professorPK = professorPK;
    }

    public Professor(int idprofessor, String matricula, int idPessoa) {
        this.professorPK = new ProfessorPK(idprofessor, matricula, idPessoa);
    }

    public ProfessorPK getProfessorPK() {
        return professorPK;
    }

    public void setProfessorPK(ProfessorPK professorPK) {
        this.professorPK = professorPK;
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

    public Date getDataUltAtualizacao() {
        return dataUltAtualizacao;
    }

    public void setDataUltAtualizacao(Date dataUltAtualizacao) {
        this.dataUltAtualizacao = dataUltAtualizacao;
    }

    @XmlTransient
    public List<QuadroAvisos> getQuadroAvisosList() {
        return quadroAvisosList;
    }

    public void setQuadroAvisosList(List<QuadroAvisos> quadroAvisosList) {
        this.quadroAvisosList = quadroAvisosList;
    }

    @XmlTransient
    public List<Alocacao> getAlocacaoList() {
        return alocacaoList;
    }

    public void setAlocacaoList(List<Alocacao> alocacaoList) {
        this.alocacaoList = alocacaoList;
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
        hash += (professorPK != null ? professorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Professor)) {
            return false;
        }
        Professor other = (Professor) object;
        if ((this.professorPK == null && other.professorPK != null) || (this.professorPK != null && !this.professorPK.equals(other.professorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rj.handschool.modelo.Professor[ professorPK=" + professorPK + " ]";
    }
    
}
