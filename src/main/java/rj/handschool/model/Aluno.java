/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rj.handschool.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Renan
 */
@Entity
@Table(name = "aluno")
@PrimaryKeyJoinColumn(name="idpessoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aluno.findAll", query = "SELECT a FROM Aluno a"),
    @NamedQuery(name = "Aluno.findAlgumAlunoMatriculado", query = "SELECT count(*) FROM Aluno a where a.matricula = :matricula"),
    @NamedQuery(name = "Aluno.findByMatricula", query = "SELECT a FROM Aluno a WHERE a.matricula = :matricula"),
    @NamedQuery(name = "Aluno.findByAtivo", query = "SELECT a FROM Aluno a WHERE a.ativo = :ativo"),
    @NamedQuery(name = "Aluno.findByDataHoraCadastro", query = "SELECT a FROM Aluno a WHERE a.dataHoraCadastro = :dataHoraCadastro"),
    })
public class Aluno extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "ativo")
    private Character ativo;
    @Column(name = "data_hora_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraCadastro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aluno")
    private List<AvaliacaoAluno> avaliacaoAlunoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aluno")
    private List<ListaPresenca> listapresencaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aluno")
    private List<Responsaveis> responsaveisList;
    @NotNull @NotEmpty(message="Matricula não informada")
    @Basic(optional = false)
    @Column(name = "matricula", unique=true)
    private String matricula;
    
    public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Aluno(String matricula, TipoPessoa tipo){
		this.matricula = matricula;
		this.tipoPessoa = tipo;
	}
	
	public Aluno() {
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

    @XmlTransient
    public List<AvaliacaoAluno> getAvaliacaoAlunoList() {
        return avaliacaoAlunoList;
    }

    public void setAvaliacaoAlunoList(List<AvaliacaoAluno> avaliacaoAlunoList) {
        this.avaliacaoAlunoList = avaliacaoAlunoList;
    }

    @XmlTransient
    public List<ListaPresenca> getListapresencaList() {
        return listapresencaList;
    }

    public void setListapresencaList(List<ListaPresenca> listapresencaList) {
        this.listapresencaList = listapresencaList;
    }

    @XmlTransient
    public List<Responsaveis> getResponsaveisList() {
        return responsaveisList;
    }

    public void setResponsaveisList(List<Responsaveis> responsaveisList) {
        this.responsaveisList = responsaveisList;
    }

    
}
