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
@Table(name = "avaliacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Avaliacao.findAll", query = "SELECT a FROM Avaliacao a"),
    @NamedQuery(name = "Avaliacao.findByIdavaliacao", query = "SELECT a FROM Avaliacao a WHERE a.idavaliacao = :idavaliacao"),
    @NamedQuery(name = "Avaliacao.findByDataHoraCadastro", query = "SELECT a FROM Avaliacao a WHERE a.dataHoraCadastro = :dataHoraCadastro"),
    @NamedQuery(name = "Avaliacao.findByDataUltAtualizacao", query = "SELECT a FROM Avaliacao a WHERE a.dataUltAtualizacao = :dataUltAtualizacao"),
    @NamedQuery(name = "Avaliacao.findByIdTipoAvaliacao", query = "SELECT a FROM Avaliacao a WHERE a.tipoAvaliacao.idtipoAvaliacao = :idTipoAvaliacao")})
public class Avaliacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idavaliacao")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idavaliacao;

	@Column(name = "data_hora_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraCadastro;
    
    @Column(name = "data_ult_atualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltAtualizacao;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "avaliacao")
    private List<AvaliacaoAluno> avaliacaoAlunoList;
    
    @JoinColumn(name = "id_tipo_avaliacao", referencedColumnName = "idtipo_avaliacao")
    @ManyToOne(optional = false)
    private TipoAvaliacao tipoAvaliacao;
    
    @JoinColumn(name = "idaulas", referencedColumnName = "idaulas")
    @ManyToOne(optional = false)
    private Aulas aula;

    public Aulas getAula() {
		return aula;
	}

	public void setAula(Aulas aula) {
		this.aula = aula;
	}

	public Avaliacao() {
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
    public List<AvaliacaoAluno> getAvaliacaoAlunoList() {
        return avaliacaoAlunoList;
    }

    public void setAvaliacaoAlunoList(List<AvaliacaoAluno> avaliacaoAlunoList) {
        this.avaliacaoAlunoList = avaliacaoAlunoList;
    }

    public TipoAvaliacao getTipoAvaliacao() {
        return tipoAvaliacao;
    }

    public void setTipoAvaliacao(TipoAvaliacao tipoAvaliacao) {
        this.tipoAvaliacao = tipoAvaliacao;
    }


    @Override
	public String toString() {
		return "Avaliacao [idavaliacao=" + idavaliacao + ", dataHoraCadastro="
				+ dataHoraCadastro + ", dataUltAtualizacao="
				+ dataUltAtualizacao + ", avaliacaoAlunoList="
				+ avaliacaoAlunoList + ", tipoAvaliacao=" + tipoAvaliacao + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idavaliacao;
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
		Avaliacao other = (Avaliacao) obj;
		if (idavaliacao != other.idavaliacao)
			return false;
		return true;
	}

	public int getIdavaliacao() {
		return idavaliacao;
	}

	public void setIdavaliacao(int idavaliacao) {
		this.idavaliacao = idavaliacao;
	}
    
}
