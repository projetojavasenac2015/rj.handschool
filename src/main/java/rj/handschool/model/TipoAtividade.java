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
@Table(name = "tipo_atividade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoAtividade.findAll", query = "SELECT t FROM TipoAtividade t"),
    @NamedQuery(name = "TipoAtividade.findByIdtipoAtividade", query = "SELECT t FROM TipoAtividade t WHERE t.idtipoAtividade = :idtipoAtividade"),
    @NamedQuery(name = "TipoAtividade.findByDescricao", query = "SELECT t FROM TipoAtividade t WHERE t.descricao = :descricao"),
    @NamedQuery(name = "TipoAtividade.findByDataHoraCadastro", query = "SELECT t FROM TipoAtividade t WHERE t.dataHoraCadastro = :dataHoraCadastro"),
    })
public class TipoAtividade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipo_atividade")
    private int idtipoAtividade;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "data_hora_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraCadastro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoAtividade")
    private List<Atividade> atividadeList;

    public TipoAtividade() {
    }
  
    public TipoAtividade(int idtipoAtividade) {
        this.idtipoAtividade = idtipoAtividade;
    }
 
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataHoraCadastro() {
        return dataHoraCadastro;
    }

    public void setDataHoraCadastro(Date dataHoraCadastro) {
        this.dataHoraCadastro = dataHoraCadastro;
    }

    public int getIdtipoAtividade() {
        return idtipoAtividade;
    }

    public void setIdtipoAtividade(int idtipoAtividade) {
        this.idtipoAtividade = idtipoAtividade;
    }

    @XmlTransient
    public List<Atividade> getAtividadeList() {
        return atividadeList;
    }

    public void setAtividadeList(List<Atividade> atividadeList) {
        this.atividadeList = atividadeList;
    }

	@Override
	public String toString() {
		return "TipoAtividade [idtipoAtividade=" + idtipoAtividade
				+ ", descricao=" + descricao + ", dataHoraCadastro="
				+ dataHoraCadastro + ", atividadeList=" + atividadeList + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idtipoAtividade;
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
		TipoAtividade other = (TipoAtividade) obj;
		if (idtipoAtividade != other.idtipoAtividade)
			return false;
		return true;
	}
}
