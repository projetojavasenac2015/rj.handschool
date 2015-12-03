/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rj.handschool.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Renan
 */
@Entity
@Table(name = "ambiente")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Ambiente.findAll", query = "SELECT c FROM Ambiente c order by c.nome "),
	@NamedQuery(name = "Ambiente.findByIdAmbiente", query = "SELECT d FROM Ambiente d WHERE d.idambiente = :idambiente")
})

public class Ambiente implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idambiente")
	private Integer idambiente;
	@NotNull(message = "Indique a situação")
	@Column(name = "ativo")
	private Character ativo;
	@Column(name = "data_hora_cadastro", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHoraCadastro;
	@Column(name = "data_ult_atualizacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUltAtualizacao;
	@NotNull
	@NotEmpty(message = "Informe o Ambiente")
	@Size(min = 5, message = "Nome Muito Pequeno. Min* 5 caracteres")
	@Column(name = "nome")
	private String nome;
	@Column(name = "descricao")
	private String descricao;
	
	public Ambiente() {
	}

	public Ambiente(Integer idambiente) {
		this.idambiente = idambiente;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idambiente == null) ? 0 : idambiente.hashCode());
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
		Ambiente other = (Ambiente) obj;
		if (idambiente == null) {
			if (other.idambiente != null)
				return false;
		} else if (!idambiente.equals(other.idambiente))
			return false;
		return true;
	}

	public Integer getIdambiente() {
		return idambiente;
	}

	public void setIdambiente(Integer idambiente) {
		this.idambiente = idambiente;
	}
}
