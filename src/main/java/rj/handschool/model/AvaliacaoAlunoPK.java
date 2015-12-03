/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rj.handschool.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Renan
 */
@Embeddable
public class AvaliacaoAlunoPK implements Serializable {
	private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "idavaliacao_aluno")
    private int idavaliacaoAluno;
    @Basic(optional = false)
    @Column(name = "id_avaliacao")
    private int idAvaliacao;
    @Basic(optional = false)
    @Column(name = "id_disciplina")
    private int idDisciplina;
    @Basic(optional = false)
    @Column(name = "matricula")
    private String matricula;
    
    public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public AvaliacaoAlunoPK() {
    }

    public AvaliacaoAlunoPK(int idavaliacaoAluno,  int idAvaliacao, int idDisciplina, String matricula) {
        this.idavaliacaoAluno = idavaliacaoAluno;
        this.idAvaliacao = idAvaliacao;
        this.idDisciplina = idDisciplina;
        this.matricula = matricula;
    }

    public int getIdavaliacaoAluno() {
        return idavaliacaoAluno;
    }

    public void setIdavaliacaoAluno(int idavaliacaoAluno) {
        this.idavaliacaoAluno = idavaliacaoAluno;
    }

    public int getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(int idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idavaliacaoAluno;
        hash += (int) idAvaliacao;
        hash += (int) idDisciplina;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // 
        if (!(object instanceof AvaliacaoAlunoPK)) {
            return false;
        }
        AvaliacaoAlunoPK other = (AvaliacaoAlunoPK) object;
        if (this.idavaliacaoAluno != other.idavaliacaoAluno) {
            return false;
        }
      
        if (this.idAvaliacao != other.idAvaliacao) {
            return false;
        }
        if (this.idDisciplina != other.idDisciplina) {
            return false;
        }
        
        if (this.matricula != other.matricula) {
            return false;
        }
        return true;
    }    
}
