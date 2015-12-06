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

@Entity
@Table(name = "grauparentesco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grauparentesco.findAll", query = "SELECT g FROM Grauparentesco g"),
   })
public class Grauparentesco implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Basic(optional = false)
    @Column(name = "idgrauparentesco")
    private int idgrauparentesco;
    
    @Basic(optional = false)
    @Column(name = "grauparentesco")
    private String grauparentesco;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grauparentesco1")
    private List<Responsaveis> responsaveisList;

    public Grauparentesco() {
    }

	public int getIdgrauparentesco() {
		return idgrauparentesco;
	}

	public void setIdgrauparentesco(int idgrauparentesco) {
		this.idgrauparentesco = idgrauparentesco;
	}

	public String getGrauparentesco() {
		return grauparentesco;
	}

	public void setGrauparentesco(String grauparentesco) {
		this.grauparentesco = grauparentesco;
	}

	public List<Responsaveis> getResponsaveisList() {
		return responsaveisList;
	}

	public void setResponsaveisList(List<Responsaveis> responsaveisList) {
		this.responsaveisList = responsaveisList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((grauparentesco == null) ? 0 : grauparentesco.hashCode());
		result = prime * result + idgrauparentesco;
		result = prime * result + ((responsaveisList == null) ? 0 : responsaveisList.hashCode());
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
		Grauparentesco other = (Grauparentesco) obj;
		if (grauparentesco == null) {
			if (other.grauparentesco != null)
				return false;
		} else if (!grauparentesco.equals(other.grauparentesco))
			return false;
		if (idgrauparentesco != other.idgrauparentesco)
			return false;
		if (responsaveisList == null) {
			if (other.responsaveisList != null)
				return false;
		} else if (!responsaveisList.equals(other.responsaveisList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Grauparentesco [idgrauparentesco=" + idgrauparentesco + ", grauparentesco=" + grauparentesco
				+ ", responsaveisList=" + responsaveisList + "]";
	}

}
