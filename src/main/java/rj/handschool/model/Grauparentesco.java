/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rj.handschool.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Renan
 */
@Entity
@Table(name = "grauparentesco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grauparentesco.findAll", query = "SELECT g FROM Grauparentesco g"),
    @NamedQuery(name = "Grauparentesco.findByIdgrauparentesco", query = "SELECT g FROM Grauparentesco g WHERE g.grauparentescoPK.idgrauparentesco = :idgrauparentesco"),
    @NamedQuery(name = "Grauparentesco.findByGrauparentesco", query = "SELECT g FROM Grauparentesco g WHERE g.grauparentescoPK.grauparentesco = :grauparentesco")})
public class Grauparentesco implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GrauparentescoPK grauparentescoPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grauparentesco1")
    private List<Responsaveis> responsaveisList;

    public Grauparentesco() {
    }

    public Grauparentesco(GrauparentescoPK grauparentescoPK) {
        this.grauparentescoPK = grauparentescoPK;
    }

    public Grauparentesco(int idgrauparentesco, String grauparentesco) {
        this.grauparentescoPK = new GrauparentescoPK(idgrauparentesco, grauparentesco);
    }

    public GrauparentescoPK getGrauparentescoPK() {
        return grauparentescoPK;
    }

    public void setGrauparentescoPK(GrauparentescoPK grauparentescoPK) {
        this.grauparentescoPK = grauparentescoPK;
    }

    @XmlTransient
    public List<Responsaveis> getResponsaveisList() {
        return responsaveisList;
    }

    public void setResponsaveisList(List<Responsaveis> responsaveisList) {
        this.responsaveisList = responsaveisList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grauparentescoPK != null ? grauparentescoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // 
        if (!(object instanceof Grauparentesco)) {
            return false;
        }
        Grauparentesco other = (Grauparentesco) object;
        if ((this.grauparentescoPK == null && other.grauparentescoPK != null) || (this.grauparentescoPK != null && !this.grauparentescoPK.equals(other.grauparentescoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rj.handschool.modelo.Grauparentesco[ grauparentescoPK=" + grauparentescoPK + " ]";
    }
    
}
