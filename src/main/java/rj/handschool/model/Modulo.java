/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rj.handschool.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Renan
 */
@Entity
@Table(name = "modulo")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
		@NamedQuery(name = "Modulo.findAll", query = "SELECT m FROM Modulo m"),
		@NamedQuery(name = "Modulo.findByIdmodulo", query = "SELECT m FROM Modulo m WHERE m.idmodulo = :idmodulo"),
		@NamedQuery(name = "Modulo.findByAtivo", query = "SELECT m FROM Modulo m WHERE m.ativo = :ativo"),
		@NamedQuery(name = "Modulo.findByDataHoraCadastro", query = "SELECT m FROM Modulo m WHERE m.dataHoraCadastro = :dataHoraCadastro"),
		@NamedQuery(name = "Modulo.findByDataUltAtualizacao", query = "SELECT m FROM Modulo m WHERE m.dataUltAtualizacao = :dataUltAtualizacao"),
		@NamedQuery(name = "Modulo.findByDescricao", query = "SELECT m FROM Modulo m WHERE m.descricao = :descricao"),
		@NamedQuery(name = "Modulo.findByIdCurso", query = "SELECT m FROM Modulo m WHERE m.curso.idcurso = :idcurso") })
public class Modulo implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idmodulo")
	@XmlElement
	private Integer idmodulo;

	@NotNull(message = "Indique a situação")
	@Column(name = "ativo")
	@XmlElement
	private Character ativo;

	@Column(name = "data_hora_cadastro", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@XmlElement
	private Date dataHoraCadastro;

	@Column(name = "data_ult_atualizacao")
	@Temporal(TemporalType.TIMESTAMP)
	@XmlElement
	private Date dataUltAtualizacao;

	@NotNull
	@NotEmpty(message = "Informe a descrição do Módulo")
	@Size(min = 8, message = "Nome Muito Pequeno. Min* 8 caracteres")
	@Column(name = "descricao")
	@XmlElement
	private String descricao;

	@NotNull(message = "Informe o Curso")
	@JoinColumn(name = "idcurso", referencedColumnName = "idcurso")
	@ManyToOne(optional = false)
	@XmlElement
	private Curso curso;

	@NotNull(message = "No mínimo 1 disciplina")
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "modulodisciplina", joinColumns = @JoinColumn(name = "idmodulo"), inverseJoinColumns = @JoinColumn(name = "iddisciplina"))
	private List<Disciplina> listadisciplinas = new ArrayList<Disciplina>();

	public List<Disciplina> getListadisciplinas() {
		return listadisciplinas;
	}

	public void setListadisciplinas(List<Disciplina> listadisciplinas) {
		this.listadisciplinas = listadisciplinas;
	}

	public Modulo() {
	}

	public Modulo(Integer idmodulo) {
		this.idmodulo = idmodulo;
	}

	public Integer getIdmodulo() {
		return idmodulo;
	}

	public void setIdmodulo(Integer idmodulo) {
		this.idmodulo = idmodulo;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idmodulo == null) ? 0 : idmodulo.hashCode());
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
		Modulo other = (Modulo) obj;
		if (idmodulo == null) {
			if (other.idmodulo != null)
				return false;
		} else if (!idmodulo.equals(other.idmodulo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Modulo [idmodulo=" + idmodulo + ", ativo=" + ativo
				+ ", dataHoraCadastro=" + dataHoraCadastro
				+ ", dataUltAtualizacao=" + dataUltAtualizacao + ", descricao="
				+ descricao + ", curso=" + curso + "]";
	}

}
