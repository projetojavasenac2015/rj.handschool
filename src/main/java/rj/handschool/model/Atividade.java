/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rj.handschool.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Renan
 */
@Entity
@Table(name = "atividade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Atividade.findAll", query = "SELECT a FROM Atividade a"),    
    })
public class Atividade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "idatividade")
    private int idatividade;
    @Basic(optional = false)
    @Column(name = "id_tipo_atividade")
    private int idTipoAtividade;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "atividade")
    private List<AtividadeAula> atividadeAulaList;
    
    @JoinColumn(name = "id_tipo_atividade", referencedColumnName = "idtipo_atividade", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoAtividade tipoAtividade;

    public Atividade() {
    }

	public int getIdatividade() {
		return idatividade;
	}

	public void setIdatividade(int idatividade) {
		this.idatividade = idatividade;
	}

	public int getIdTipoAtividade() {
		return idTipoAtividade;
	}

	public void setIdTipoAtividade(int idTipoAtividade) {
		this.idTipoAtividade = idTipoAtividade;
	}

	public List<AtividadeAula> getAtividadeAulaList() {
		return atividadeAulaList;
	}

	public void setAtividadeAulaList(List<AtividadeAula> atividadeAulaList) {
		this.atividadeAulaList = atividadeAulaList;
	}

	public TipoAtividade getTipoAtividade() {
		return tipoAtividade;
	}

	public void setTipoAtividade(TipoAtividade tipoAtividade) {
		this.tipoAtividade = tipoAtividade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atividadeAulaList == null) ? 0 : atividadeAulaList.hashCode());
		result = prime * result + idTipoAtividade;
		result = prime * result + idatividade;
		result = prime * result + ((tipoAtividade == null) ? 0 : tipoAtividade.hashCode());
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
		Atividade other = (Atividade) obj;
		if (atividadeAulaList == null) {
			if (other.atividadeAulaList != null)
				return false;
		} else if (!atividadeAulaList.equals(other.atividadeAulaList))
			return false;
		if (idTipoAtividade != other.idTipoAtividade)
			return false;
		if (idatividade != other.idatividade)
			return false;
		if (tipoAtividade == null) {
			if (other.tipoAtividade != null)
				return false;
		} else if (!tipoAtividade.equals(other.tipoAtividade))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Atividade [idatividade=" + idatividade + ", idTipoAtividade=" + idTipoAtividade + ", atividadeAulaList="
				+ atividadeAulaList + ", tipoAtividade=" + tipoAtividade + "]";
	}   
    
}
