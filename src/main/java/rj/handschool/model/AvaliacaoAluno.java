/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rj.handschool.model;

import java.io.Serializable;
import java.math.BigInteger;
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
    @NamedQuery(name = "AvaliacaoAluno.findByAluno", query = "SELECT a FROM AvaliacaoAluno a WHERE a.aluno = :aluno"),
    @NamedQuery(name = "AvaliacaoAluno.findByIdavaliacaoAluno", query = "SELECT a FROM AvaliacaoAluno a WHERE a.idavaliacaoAluno = :idavaliacaoAluno"),
    @NamedQuery(name = "AvaliacaoAluno.findByData", query = "SELECT a FROM AvaliacaoAluno a WHERE a.data = :data"),
    @NamedQuery(name = "AvaliacaoAluno.findByValor", query = "SELECT a FROM AvaliacaoAluno a WHERE a.valor = :valor"),
    @NamedQuery(name = "AvaliacaoAluno.findByIdAvaliacao", query = "SELECT a FROM AvaliacaoAluno a WHERE a.idavaliacaoAluno = :idAvaliacao")
    })
public class AvaliacaoAluno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idavaliacao_aluno")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idavaliacaoAluno;
    
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Double valor;
    
	@JoinColumn(name = "id_avaliacao", referencedColumnName = "idavaliacao")
    @ManyToOne(optional = false)
    private Avaliacao avaliacao;
    
    @JoinColumn(name = "matricula", referencedColumnName = "matricula")
    @ManyToOne(optional = false)
    private Aluno aluno;
    
    @Transient
    private BigInteger qtdAvaliacoes;
    
    public BigInteger getQtdAvaliacoes() {
		return qtdAvaliacoes;
	}
    @Transient
    private BigInteger qtdAprovados;
    public BigInteger getQtdAprovados() {
		return qtdAprovados;
	}

	public void setQtdAprovados(BigInteger qtdAprovados) {
		this.qtdAprovados = qtdAprovados;
	}

	public BigInteger getQtdReprovados() {
		return qtdReprovados;
	}

	public void setQtdReprovados(BigInteger qtdReprovados) {
		this.qtdReprovados = qtdReprovados;
	}
	@Transient
    private BigInteger qtdReprovados;
    
	public void setQtdAvaliacoes(BigInteger qtdAvaliacoes) {
		this.qtdAvaliacoes = qtdAvaliacoes;
	}

	@Transient
    private TipoAvaliacao tipoAvaliacao;
    
    public TipoAvaliacao getTipoAvaliacao() {
		return tipoAvaliacao;
	}

	public void setTipoAvaliacao(TipoAvaliacao tipoAvaliacao) {
		this.tipoAvaliacao = tipoAvaliacao;
	}

	public AvaliacaoAluno() {
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

	public int getIdavaliacaoAluno() {
		return idavaliacaoAluno;
	}

	public void setIdavaliacaoAluno(int idavaliacaoAluno) {
		this.idavaliacaoAluno = idavaliacaoAluno;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idavaliacaoAluno;
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
		if (idavaliacaoAluno != other.idavaliacaoAluno)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AvaliacaoAluno [idavaliacaoAluno=" + idavaliacaoAluno
				+ ", data=" + data + ", valor=" + valor + ", avaliacao="
				+ avaliacao + ", aluno=" + aluno + "]";
	}

    
}
