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

@Entity
@Table(name = "avaliacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Avaliacao.findAll", query = "SELECT a FROM Avaliacao a"),    
    @NamedQuery(name = "Avaliacao.findByDataHoraCadastro", query = "SELECT a FROM Avaliacao a WHERE a.dataHoraCadastro = :dataHoraCadastro"),
    @NamedQuery(name = "Avaliacao.findByDataUltAtualizacao", query = "SELECT a FROM Avaliacao a WHERE a.dataUltAtualizacao = :dataUltAtualizacao"),
    })
public class Avaliacao implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Basic(optional = false)
    @Column(name = "idavaliacao")
    private int idavaliacao;
    
    @Basic(optional = false)
    @Column(name = "id_tipo_avaliacao")
    private int idTipoAvaliacao;
    
    @Column(name = "data_hora_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraCadastro;
    
    @Column(name = "data_ult_atualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltAtualizacao;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "avaliacao")
    private List<AvaliacaoAluno> avaliacaoAlunoList;
    
    @JoinColumn(name = "id_tipo_avaliacao", referencedColumnName = "idtipo_avaliacao", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoAvaliacao tipoAvaliacao;

    public Avaliacao() {
    }

	public int getIdavaliacao() {
		return idavaliacao;
	}

	public void setIdavaliacao(int idavaliacao) {
		this.idavaliacao = idavaliacao;
	}

	public int getIdTipoAvaliacao() {
		return idTipoAvaliacao;
	}

	public void setIdTipoAvaliacao(int idTipoAvaliacao) {
		this.idTipoAvaliacao = idTipoAvaliacao;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((avaliacaoAlunoList == null) ? 0 : avaliacaoAlunoList.hashCode());
		result = prime * result + ((dataHoraCadastro == null) ? 0 : dataHoraCadastro.hashCode());
		result = prime * result + ((dataUltAtualizacao == null) ? 0 : dataUltAtualizacao.hashCode());
		result = prime * result + idTipoAvaliacao;
		result = prime * result + idavaliacao;
		result = prime * result + ((tipoAvaliacao == null) ? 0 : tipoAvaliacao.hashCode());
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
		if (avaliacaoAlunoList == null) {
			if (other.avaliacaoAlunoList != null)
				return false;
		} else if (!avaliacaoAlunoList.equals(other.avaliacaoAlunoList))
			return false;
		if (dataHoraCadastro == null) {
			if (other.dataHoraCadastro != null)
				return false;
		} else if (!dataHoraCadastro.equals(other.dataHoraCadastro))
			return false;
		if (dataUltAtualizacao == null) {
			if (other.dataUltAtualizacao != null)
				return false;
		} else if (!dataUltAtualizacao.equals(other.dataUltAtualizacao))
			return false;
		if (idTipoAvaliacao != other.idTipoAvaliacao)
			return false;
		if (idavaliacao != other.idavaliacao)
			return false;
		if (tipoAvaliacao == null) {
			if (other.tipoAvaliacao != null)
				return false;
		} else if (!tipoAvaliacao.equals(other.tipoAvaliacao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Avaliacao [idavaliacao=" + idavaliacao + ", idTipoAvaliacao=" + idTipoAvaliacao + ", dataHoraCadastro="
				+ dataHoraCadastro + ", dataUltAtualizacao=" + dataUltAtualizacao + ", avaliacaoAlunoList="
				+ avaliacaoAlunoList + ", tipoAvaliacao=" + tipoAvaliacao + "]";
	}
    
}
