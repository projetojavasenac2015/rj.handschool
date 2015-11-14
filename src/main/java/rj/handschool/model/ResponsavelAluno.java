/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rj.handschool.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Renan
 */
@Entity
@Table(name = "responsavel_aluno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResponsavelAluno.findAll", query = "SELECT r FROM ResponsavelAluno r"),
    @NamedQuery(name = "ResponsavelAluno.findByIdrespaluno", query = "SELECT r FROM ResponsavelAluno r WHERE r.idrespaluno = :idrespaluno"),
    @NamedQuery(name = "ResponsavelAluno.findByNome", query = "SELECT r FROM ResponsavelAluno r WHERE r.nome = :nome"),
    @NamedQuery(name = "ResponsavelAluno.findByParentesco", query = "SELECT r FROM ResponsavelAluno r WHERE r.parentesco = :parentesco"),
    @NamedQuery(name = "ResponsavelAluno.findByMatricula", query = "SELECT r FROM ResponsavelAluno r WHERE r.matricula = :matricula")})
public class ResponsavelAluno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrespaluno")
    private Integer idrespaluno;
    @Column(name = "nome")
    private String nome;
    @Column(name = "parentesco")
    private String parentesco;
    @Column(name = "MATRICULA")
    private String matricula;

    public ResponsavelAluno() {
    }

    public ResponsavelAluno(Integer idrespaluno) {
        this.idrespaluno = idrespaluno;
    }

    public Integer getIdrespaluno() {
        return idrespaluno;
    }

    public void setIdrespaluno(Integer idrespaluno) {
        this.idrespaluno = idrespaluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrespaluno != null ? idrespaluno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResponsavelAluno)) {
            return false;
        }
        ResponsavelAluno other = (ResponsavelAluno) object;
        if ((this.idrespaluno == null && other.idrespaluno != null) || (this.idrespaluno != null && !this.idrespaluno.equals(other.idrespaluno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bd.ResponsavelAluno[ idrespaluno=" + idrespaluno + " ]";
    }
    
}
