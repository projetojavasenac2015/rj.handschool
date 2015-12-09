/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rj.handschool.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Renan
 */
@Entity
@Table(name = "Listapresenca")
@XmlRootElement
public class ListaPresenca implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idlistapresenca")
    private int idlistapresenca;
    
    @Column(name = "data_hora_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraCadastro;
    
    @Column(name = "data_ult_atualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltAtualizacao;
    
    @JoinColumn(name = "matricula", referencedColumnName = "matricula")
    @ManyToOne(optional = false)
    private Aluno aluno;
    
    @JoinColumn(name = "id_aulas", referencedColumnName = "idaulas")
    @ManyToOne(optional = false)
    private Aulas aulas;
    
    @javax.persistence.Transient
    private Disciplina disciplina;
    
    @javax.persistence.Transient
    private Turma turma;

    @Column(name = "situacao")
    private Character situacao;
    
    public ListaPresenca() {
    }
    
    public ListaPresenca(Aluno aluno, Aulas aulas, Character situacao) {
    	this.aluno = aluno;
    	this.aulas = aulas;
    	this.situacao = situacao;
    }

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListaPresenca other = (ListaPresenca) obj;
		if (idlistapresenca != other.idlistapresenca)
			return false;
		return true;
	}

	public int getIdlistapresenca() {
		return idlistapresenca;
	}

	public void setIdlistapresenca(int idlistapresenca) {
		this.idlistapresenca = idlistapresenca;
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

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Aulas getAulas() {
        return aulas;
    }

    public void setAulas(Aulas aulas) {
        this.aulas = aulas;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idlistapresenca;
		return result;
	}

}
