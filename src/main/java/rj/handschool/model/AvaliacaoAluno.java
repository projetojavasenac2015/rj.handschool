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
@Table(name = "avaliacao_aluno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AvaliacaoAluno.findAll", query = "SELECT a FROM AvaliacaoAluno a"),
    @NamedQuery(name = "AvaliacaoAluno.findByIdavaliacaoAluno", query = "SELECT a FROM AvaliacaoAluno a WHERE a.avaliacaoAlunoPK.idavaliacaoAluno = :idavaliacaoAluno"),
    @NamedQuery(name = "AvaliacaoAluno.findByData", query = "SELECT a FROM AvaliacaoAluno a WHERE a.data = :data"),
    @NamedQuery(name = "AvaliacaoAluno.findByValor", query = "SELECT a FROM AvaliacaoAluno a WHERE a.valor = :valor"),
    @NamedQuery(name = "AvaliacaoAluno.findByIdAluno", query = "SELECT a FROM AvaliacaoAluno a WHERE a.avaliacaoAlunoPK.idAluno = :idAluno"),
    @NamedQuery(name = "AvaliacaoAluno.findByIdAvaliacao", query = "SELECT a FROM AvaliacaoAluno a WHERE a.avaliacaoAlunoPK.idAvaliacao = :idAvaliacao"),
    @NamedQuery(name = "AvaliacaoAluno.findByIdDisciplina", query = "SELECT a FROM AvaliacaoAluno a WHERE a.avaliacaoAlunoPK.idDisciplina = :idDisciplina")})
public class AvaliacaoAluno implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AvaliacaoAlunoPK avaliacaoAlunoPK;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Double valor;
    @JoinColumn(name = "id_disciplina", referencedColumnName = "iddisciplina", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Disciplina disciplina;
    @JoinColumns({
    	@JoinColumn(name = "id_avaliacao", referencedColumnName = "idavaliacao", insertable = false, updatable = false)
    	,@JoinColumn(name = "id_tipo_avaliacao", referencedColumnName = "id_tipo_avaliacao", insertable = false, updatable = false)
    })
    @ManyToOne(optional = false)
    private Avaliacao avaliacao;
    @JoinColumns({
    	@JoinColumn(name = "id_aluno", referencedColumnName = "idaluno", insertable = false, updatable = false)
    	,@JoinColumn(name = "matricula", referencedColumnName = "matricula", insertable = false, updatable = false)
    	,@JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa", insertable = false, updatable = false)
    })
    @ManyToOne(optional = false)
    private Aluno aluno;

    public AvaliacaoAluno() {
    }

    public AvaliacaoAluno(AvaliacaoAlunoPK avaliacaoAlunoPK) {
        this.avaliacaoAlunoPK = avaliacaoAlunoPK;
    }

    public AvaliacaoAluno(int idavaliacaoAluno, int idAluno, int idAvaliacao, int idDisciplina) {
        this.avaliacaoAlunoPK = new AvaliacaoAlunoPK(idavaliacaoAluno, idAluno, idAvaliacao, idDisciplina);
    }

    public AvaliacaoAlunoPK getAvaliacaoAlunoPK() {
        return avaliacaoAlunoPK;
    }

    public void setAvaliacaoAlunoPK(AvaliacaoAlunoPK avaliacaoAlunoPK) {
        this.avaliacaoAlunoPK = avaliacaoAlunoPK;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (avaliacaoAlunoPK != null ? avaliacaoAlunoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AvaliacaoAluno)) {
            return false;
        }
        AvaliacaoAluno other = (AvaliacaoAluno) object;
        if ((this.avaliacaoAlunoPK == null && other.avaliacaoAlunoPK != null) || (this.avaliacaoAlunoPK != null && !this.avaliacaoAlunoPK.equals(other.avaliacaoAlunoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rj.handschool.modelo.AvaliacaoAluno[ avaliacaoAlunoPK=" + avaliacaoAlunoPK + " ]";
    }
    
}
