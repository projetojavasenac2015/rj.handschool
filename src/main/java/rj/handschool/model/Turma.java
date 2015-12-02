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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Renan
 */
@Entity
@Table(name = "turma")
@NamedQueries({
    @NamedQuery(name = "Turma.findAll", query = "SELECT t FROM Turma t"),
    @NamedQuery(name = "Turma.findByIdturma", query = "SELECT t FROM Turma t WHERE t.idturma = :idturma"),
    @NamedQuery(name = "Turma.findByAtivo", query = "SELECT t FROM Turma t WHERE t.ativo = :ativo"),
    @NamedQuery(name = "Turma.findByDataHoraCadastro", query = "SELECT t FROM Turma t WHERE t.dataHoraCadastro = :dataHoraCadastro"),
    @NamedQuery(name = "Turma.findByDataUltAtualizacao", query = "SELECT t FROM Turma t WHERE t.dataUltAtualizacao = :dataUltAtualizacao"),
    @NamedQuery(name = "Turma.findByQuantidadeAlunos", query = "SELECT t FROM Turma t WHERE t.quantidadeAlunos = :quantidadeAlunos")
    ,@NamedQuery(name = "Turma.findByPorCurso", query = "SELECT t.quantidadeAlunos, t.ativo, t.descricao, t.ano, t.idturma FROM Turma t WHERE t.curso.idcurso = :idcurso and t.ativo = 1")
})
public class Turma implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idturma",nullable = false,unique = true)
    private Integer idturma;
    @Column(name = "ativo")
    @NotNull(message = "Indique a situação")
    private Character ativo;
    @Column(name = "data_hora_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraCadastro;
    @Column(name = "data_ult_atualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltAtualizacao;
    @NotNull(message="Informe a Quantidade de Alunos")
    @Column(name = "quantidade_alunos")
    private Integer quantidadeAlunos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "turma", fetch=FetchType.LAZY)
    private List<QuadroAvisos> quadroAvisosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "turma")
    private List<ListaPresenca> listapresencaList;
    @NotNull(message="Informe o Curso")
    @JoinColumn(name = "idcurso", referencedColumnName = "idcurso")
    @ManyToOne(optional = false)
    private Curso curso;
    @Column(name="descricao")
    @NotEmpty(message="Turma sem descrição")
    private String descricao;
    @Column(name="ano")
    @NotNull(message="Informe o Ano")
    private int ano;
    @Column(name = "fechada")
    private Character fechada;
    
    public Character getFechada() {
		return fechada;
	}

	public void setFechada(Character fechada) {
		this.fechada = fechada;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Turma() {
    }
	
	public Turma(Integer idturma) {
		this.idturma = idturma;
	}
	
	public Integer getIdturma() {
		return idturma;
	}

	public void setIdturma(Integer idturma) {
		this.idturma = idturma;
	}

	public Turma(String descricao){
		this.descricao = descricao;
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

    public Integer getQuantidadeAlunos() {
        return quantidadeAlunos;
    }

    public void setQuantidadeAlunos(Integer quantidadeAlunos) {
        this.quantidadeAlunos = quantidadeAlunos;
    }

    @XmlTransient
    public List<QuadroAvisos> getQuadroAvisosList() {
        return quadroAvisosList;
    }

    public void setQuadroAvisosList(List<QuadroAvisos> quadroAvisosList) {
        this.quadroAvisosList = quadroAvisosList;
    }

    @XmlTransient
    public List<ListaPresenca> getListapresencaList() {
        return listapresencaList;
    }

    public void setListapresencaList(List<ListaPresenca> listapresencaList) {
        this.listapresencaList = listapresencaList;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
	public int hashCode() {
		int hash = 0;
		hash += (idturma != null ? idturma.hashCode() : 0);
		return hash;
	}
		
	@Override
	public boolean equals(Object object) {	
		if (!(object instanceof Curso)) {
			return false;
		}
		Turma other = (Turma) object;
		if ((this.idturma == null && other.idturma != null)
				|| (this.idturma != null && !this.idturma.equals(other.idturma))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Turma [idturma=" + idturma + ", ativo=" + ativo
				+ ", dataHoraCadastro=" + dataHoraCadastro
				+ ", dataUltAtualizacao=" + dataUltAtualizacao
				+ ", quantidadeAlunos=" + quantidadeAlunos
				+ ", quadroAvisosList=" + quadroAvisosList
				+ ", listapresencaList=" + listapresencaList + ", curso="
				+ curso + ", descricao=" + descricao + ", ano=" + ano + "]";
	}

    
}
