/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rj.handschool.model;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name = "professor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Professor.findAll", query = "SELECT p FROM Professor p"),
    @NamedQuery(name = "Professor.findByMatriculaProfessor", query = "SELECT p FROM Professor p WHERE p.matriculaProfessor = :matricula"),
    @NamedQuery(name = "Professor.findByAtivo", query = "SELECT p FROM Professor p WHERE p.ativo = :ativo"),
    @NamedQuery(name = "Professor.findByDataHoraCadastro", query = "SELECT p FROM Professor p WHERE p.dataHoraCadastro = :dataHoraCadastro"),
    @NamedQuery(name = "Professor.findByDataUltAtualizacao", query = "SELECT p FROM Professor p WHERE p.dataUltAtualizacao = :dataUltAtualizacao"),
    @NamedQuery(name = "Professor.findByPessoa", query = "SELECT p FROM Professor p WHERE p.idpessoa = :idpessoa"),
   })
public class Professor extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "ativo")
    private Character ativo;
    
    @Column(name = "data_hora_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraCadastro;
    
    @Column(name = "data_ult_atualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltAtualizacao;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "professor")
    private List<QuadroAvisos> quadroAvisosList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "professor")
    private List<Alocacao> alocacaoList;
    
    @NotNull @NotEmpty(message="Matricula não informada")
    @Basic(optional = false)
    @Column(name = "matricula_professor", unique=true)
    private String matriculaProfessor;
    
    @NotNull(message = "No mínimo 1 disciplina")
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "professordisciplina", joinColumns = @JoinColumn(name = "idpessoa"), inverseJoinColumns = @JoinColumn(name = "iddisciplina"))
	private List<Disciplina> listadisciplinas = new ArrayList<Disciplina>();
    
    public List<Disciplina> getListadisciplinas() {
		return listadisciplinas;
	}

	public void setListadisciplinas(List<Disciplina> listadisciplinas) {
		this.listadisciplinas = listadisciplinas;
	}

	public String getMatriculaProfessor() {
		return matriculaProfessor;
	}

	public void setMatriculaProfessor(String matricula_processor) {
		this.matriculaProfessor = matricula_processor;
	}
    
    public Professor() {
    }

    public Professor(String matricula, TipoPessoa tipo){
		this.matriculaProfessor = matricula;
		this.tipoPessoa = tipo;
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

    @XmlTransient
    public List<QuadroAvisos> getQuadroAvisosList() {
        return quadroAvisosList;
    }

    public void setQuadroAvisosList(List<QuadroAvisos> quadroAvisosList) {
        this.quadroAvisosList = quadroAvisosList;
    }

    @XmlTransient
    public List<Alocacao> getAlocacaoList() {
        return alocacaoList;
    }

    public void setAlocacaoList(List<Alocacao> alocacaoList) {
        this.alocacaoList = alocacaoList;
    }
}
