/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rj.handschool.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "avaliacao_aluno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AvaliacaoAluno.findAll", query = "SELECT a FROM AvaliacaoAluno a"),
    @NamedQuery(name = "AvaliacaoAluno.findByAluno", query = "SELECT a FROM AvaliacaoAluno a WHERE a.aluno = :aluno"),    
    @NamedQuery(name = "AvaliacaoAluno.findByData", query = "SELECT a FROM AvaliacaoAluno a WHERE a.data = :data"),
    @NamedQuery(name = "AvaliacaoAluno.findByValor", query = "SELECT a FROM AvaliacaoAluno a WHERE a.valor = :valor"),
   })
public class AvaliacaoAluno implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Basic(optional = false)
    @Column(name = "idavaliacao_aluno")
    private int idavaliacaoAluno;
    
    @Basic(optional = false)
    @Column(name = "id_avaliacao")
    private int idAvaliacao;
    
    @Basic(optional = false)
    @Column(name = "id_disciplina")
    private int idDisciplina;
    
    @Basic(optional = false)
    @Column(name = "matricula")
    private String matricula;
    
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
    
    @JoinColumn(name = "matricula", referencedColumnName = "matricula", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Aluno aluno;
    
    public AvaliacaoAluno() {
    }

	public int getIdavaliacaoAluno() {
		return idavaliacaoAluno;
	}

	public void setIdavaliacaoAluno(int idavaliacaoAluno) {
		this.idavaliacaoAluno = idavaliacaoAluno;
	}

	public int getIdAvaliacao() {
		return idAvaliacao;
	}

	public void setIdAvaliacao(int idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}

	public int getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aluno == null) ? 0 : aluno.hashCode());
		result = prime * result + ((avaliacao == null) ? 0 : avaliacao.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((disciplina == null) ? 0 : disciplina.hashCode());
		result = prime * result + idAvaliacao;
		result = prime * result + idDisciplina;
		result = prime * result + idavaliacaoAluno;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
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
		AvaliacaoAluno other = (AvaliacaoAluno) obj;
		if (aluno == null) {
			if (other.aluno != null)
				return false;
		} else if (!aluno.equals(other.aluno))
			return false;
		if (avaliacao == null) {
			if (other.avaliacao != null)
				return false;
		} else if (!avaliacao.equals(other.avaliacao))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (disciplina == null) {
			if (other.disciplina != null)
				return false;
		} else if (!disciplina.equals(other.disciplina))
			return false;
		if (idAvaliacao != other.idAvaliacao)
			return false;
		if (idDisciplina != other.idDisciplina)
			return false;
		if (idavaliacaoAluno != other.idavaliacaoAluno)
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AvaliacaoAluno [idavaliacaoAluno=" + idavaliacaoAluno + ", idAvaliacao=" + idAvaliacao
				+ ", idDisciplina=" + idDisciplina + ", matricula=" + matricula + ", data=" + data + ", valor=" + valor
				+ ", disciplina=" + disciplina + ", avaliacao=" + avaliacao + ", aluno=" + aluno + "]";
	}    
}
