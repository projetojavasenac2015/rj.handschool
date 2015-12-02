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
import org.springframework.format.annotation.DateTimeFormat;

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
    
    @NotNull(message="Informe a Data")
    @Column(name = "data_aula")
    @DateTimeFormat(pattern="dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date dataAula;
    
    @NotNull(message="Informe o horário Inicial")
    @NotEmpty(message="Informe o horário Inicial")
    @Column(name = "hora_inicio")
    private String horaInicio;
    
    @NotNull(message="Informe o horário Final")
    @NotEmpty(message="Informe o horário Final")
    @Column(name = "hora_fim")
    private String horaFim;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aulas")
    private List<AtividadeAula> atividadeAulaList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aulas")
    private List<ListaPresenca> listapresencaList;
    
    @NotNull(message = "No mínimo 1 disciplina")
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "auladisciplina", joinColumns = @JoinColumn(name = "idaulas"), inverseJoinColumns = @JoinColumn(name = "iddisciplina"))
	private List<Disciplina> listadisciplinas = new ArrayList<Disciplina>();
    
    public List<Disciplina> getListadisciplinas() {
		return listadisciplinas;
	}

	public void setListadisciplinas(List<Disciplina> listadisciplinas) {
		this.listadisciplinas = listadisciplinas;
	}

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

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(String horaFim) {
		this.horaFim = horaFim;
	}

	public List<AtividadeAula> getAtividadeAulaList() {
		return atividadeAulaList;
	}

	public void setAtividadeAulaList(List<AtividadeAula> atividadeAulaList) {
        this.atividadeAulaList = atividadeAulaList;
    }

    @XmlTransient
    public List<ListaPresenca> getListapresencaList() {
        return listapresencaList;
    }

    public void setListapresencaList(List<ListaPresenca> listapresencaList) {
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
        // 
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
