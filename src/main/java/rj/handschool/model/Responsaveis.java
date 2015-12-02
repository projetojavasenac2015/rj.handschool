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
@Table(name = "responsaveis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Responsaveis.findAll", query = "SELECT r FROM Responsaveis r"),
    @NamedQuery(name = "Responsaveis.findByIdresponsaveis", query = "SELECT r FROM Responsaveis r WHERE r.responsaveisPK.idresponsaveis = :idresponsaveis"),
    @NamedQuery(name = "Responsaveis.findByNome", query = "SELECT r FROM Responsaveis r WHERE r.nome = :nome"),
    @NamedQuery(name = "Responsaveis.findByIdGrauparentesco", query = "SELECT r FROM Responsaveis r WHERE r.responsaveisPK.idGrauparentesco = :idGrauparentesco"),
    @NamedQuery(name = "Responsaveis.findByGrauparentesco", query = "SELECT r FROM Responsaveis r WHERE r.responsaveisPK.grauparentesco = :grauparentesco")})
public class Responsaveis implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ResponsaveisPK responsaveisPK;
    @Column(name = "nome")
    private String nome;
    @JoinColumns({
        @JoinColumn(name = "id_grauparentesco", referencedColumnName = "idgrauparentesco", insertable = false, updatable = false),
        @JoinColumn(name = "grauparentesco", referencedColumnName = "grauparentesco", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Grauparentesco grauparentesco1;
    @JoinColumn(name = "matricula", referencedColumnName = "matricula", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Aluno aluno;

    public Responsaveis() {
    }

    public Responsaveis(ResponsaveisPK responsaveisPK) {
        this.responsaveisPK = responsaveisPK;
    }

    public Responsaveis(int idresponsaveis,  int idGrauparentesco, String grauparentesco) {
        this.responsaveisPK = new ResponsaveisPK(idresponsaveis, idGrauparentesco, grauparentesco);
    }

    public ResponsaveisPK getResponsaveisPK() {
        return responsaveisPK;
    }

    public void setResponsaveisPK(ResponsaveisPK responsaveisPK) {
        this.responsaveisPK = responsaveisPK;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Grauparentesco getGrauparentesco1() {
        return grauparentesco1;
    }

    public void setGrauparentesco1(Grauparentesco grauparentesco1) {
        this.grauparentesco1 = grauparentesco1;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (responsaveisPK != null ? responsaveisPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // 
        if (!(object instanceof Responsaveis)) {
            return false;
        }
        Responsaveis other = (Responsaveis) object;
        if ((this.responsaveisPK == null && other.responsaveisPK != null) || (this.responsaveisPK != null && !this.responsaveisPK.equals(other.responsaveisPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rj.handschool.modelo.Responsaveis[ responsaveisPK=" + responsaveisPK + " ]";
    }
    
}
