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
@Table(name = "aulas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aula.findAll", query = "SELECT a FROM Aula a"),
    @NamedQuery(name = "Aula.findByIdaulas", query = "SELECT a FROM Aula a WHERE a.idaulas = :idaulas"),
    @NamedQuery(name = "Aula.findByData", query = "SELECT a FROM Aula a WHERE a.data = :data"),
    @NamedQuery(name = "Aula.findByHorarioInicio", query = "SELECT a FROM Aula a WHERE a.horarioInicio = :horarioInicio"),
    @NamedQuery(name = "Aula.findByHorarioTermino", query = "SELECT a FROM Aula a WHERE a.horarioTermino = :horarioTermino"),
    @NamedQuery(name = "Aula.findByStatus", query = "SELECT a FROM Aula a WHERE a.status = :status"),
    @NamedQuery(name = "Aula.findByMatricula", query = "SELECT a FROM Aula a WHERE a.matricula = :matricula")})
public class Aula implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idaulas")
    private Integer idaulas;
    @Column(name = "data")
    private String data;
    @Column(name = "HORARIO_INICIO")
    private String horarioInicio;
    @Column(name = "HORARIO_TERMINO")
    private String horarioTermino;
    @Column(name = "status")
    private String status;
    @Column(name = "MATRICULA")
    private String matricula;
    @OneToMany(mappedBy = "idaulas")
    private List<ListaPresenca> listaPresencaList;
    @JoinColumn(name = "IDDISCIPLINA", referencedColumnName = "iddisciplina")
    @ManyToOne
    private Disciplina iddisciplina;
    @JoinColumn(name = "IDTURMA", referencedColumnName = "idturma")
    @ManyToOne
    private Turma idturma;

    public Aula() {
    }

    public Aula(Integer idaulas) {
        this.idaulas = idaulas;
    }

    public Integer getIdaulas() {
        return idaulas;
    }

    public void setIdaulas(Integer idaulas) {
        this.idaulas = idaulas;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(String horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public String getHorarioTermino() {
        return horarioTermino;
    }

    public void setHorarioTermino(String horarioTermino) {
        this.horarioTermino = horarioTermino;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @XmlTransient
    public List<ListaPresenca> getListaPresencaList() {
        return listaPresencaList;
    }

    public void setListaPresencaList(List<ListaPresenca> listaPresencaList) {
        this.listaPresencaList = listaPresencaList;
    }

    public Disciplina getIddisciplina() {
        return iddisciplina;
    }

    public void setIddisciplina(Disciplina iddisciplina) {
        this.iddisciplina = iddisciplina;
    }

    public Turma getIdturma() {
        return idturma;
    }

    public void setIdturma(Turma idturma) {
        this.idturma = idturma;
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
        if (!(object instanceof Aula)) {
            return false;
        }
        Aula other = (Aula) object;
        if ((this.idaulas == null && other.idaulas != null) || (this.idaulas != null && !this.idaulas.equals(other.idaulas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bd.Aula[ idaulas=" + idaulas + " ]";
    }
    
}
