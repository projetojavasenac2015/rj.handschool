/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rj.handschool.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Renan
 */
@Entity
@Table(name = "aulas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aulas.findAll", query = "SELECT a FROM Aulas a"),
    @NamedQuery(name = "Aulas.findByIdaulas", query = "SELECT a FROM Aulas a WHERE a.idaulas = :idaulas"),
    @NamedQuery(name = "Aulas.findByAtivo", query = "SELECT a FROM Aulas a WHERE a.ativo = :ativo"),
    @NamedQuery(name = "Aulas.findByDataAula", query = "SELECT a FROM Aulas a WHERE a.dataAula = :dataAula"),
    @NamedQuery(name = "Aulas.findByHoraInicio", query = "SELECT a FROM Aulas a WHERE a.horaInicio = :horaInicio"),
    @NamedQuery(name = "Aulas.findByHoraFim", query = "SELECT a FROM Aulas a WHERE a.horaFim = :horaFim")})
public class Aulas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idaulas")
    private Integer idaulas;
    @Column(name = "ativo")
    private Character ativo;
    @Column(name = "data_aula")
    @Temporal(TemporalType.DATE)
    private Date dataAula;
    @Column(name = "hora_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaInicio;
    @Column(name = "hora_fim")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaFim;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aulas")
    private List<AtividadeAula> atividadeAulaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aulas")
    private List<Listapresenca> listapresencaList;

    public Aulas() {
    }

    public Aulas(Integer idaulas) {
        this.idaulas = idaulas;
    }

    public Integer getIdaulas() {
        return idaulas;
    }

    public void setIdaulas(Integer idaulas) {
        this.idaulas = idaulas;
    }

    public Character getAtivo() {
        return ativo;
    }

    public void setAtivo(Character ativo) {
        this.ativo = ativo;
    }

    public Date getDataAula() {
        return dataAula;
    }

    public void setDataAula(Date dataAula) {
        this.dataAula = dataAula;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(Date horaFim) {
        this.horaFim = horaFim;
    }

    @XmlTransient
    public List<AtividadeAula> getAtividadeAulaList() {
        return atividadeAulaList;
    }

    public void setAtividadeAulaList(List<AtividadeAula> atividadeAulaList) {
        this.atividadeAulaList = atividadeAulaList;
    }

    @XmlTransient
    public List<Listapresenca> getListapresencaList() {
        return listapresencaList;
    }

    public void setListapresencaList(List<Listapresenca> listapresencaList) {
        this.listapresencaList = listapresencaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idaulas != null ? idaulas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aulas)) {
            return false;
        }
        Aulas other = (Aulas) object;
        if ((this.idaulas == null && other.idaulas != null) || (this.idaulas != null && !this.idaulas.equals(other.idaulas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rj.handschool.modelo.Aulas[ idaulas=" + idaulas + " ]";
    }
    
}
