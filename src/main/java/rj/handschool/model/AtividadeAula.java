package rj.handschool.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "atividade_aula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AtividadeAula.findAll", query = "SELECT a FROM AtividadeAula a"),
    @NamedQuery(name = "AtividadeAula.findByIdatividadeAula", query = "SELECT a FROM AtividadeAula a WHERE a.atividadeAulaPK.idatividadeAula = :idatividadeAula"),
    @NamedQuery(name = "AtividadeAula.findByAulasIdaulas", query = "SELECT a FROM AtividadeAula a WHERE a.atividadeAulaPK.aulasIdaulas = :aulasIdaulas"),
    @NamedQuery(name = "AtividadeAula.findByIdAtividade", query = "SELECT a FROM AtividadeAula a WHERE a.atividadeAulaPK.idAtividade = :idAtividade")})
public class AtividadeAula implements Serializable {
    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @Column(name = "idatividade_aula")
    private int idatividadeAula;
    
    @Basic(optional = false)
    @Column(name = "aulas_idaulas")
    private int aulasIdaulas;
    
    @Basic(optional = false)
    @Column(name = "id_atividade")
    private int idAtividade;
    
    @JoinColumns({
    	@JoinColumn(name = "id_atividade", referencedColumnName = "idatividade", insertable = false, updatable = false)
    	,@JoinColumn(name = "id_tipo_atividade", referencedColumnName = "id_tipo_atividade", insertable = false, updatable = false)
    })
    @ManyToOne(optional = false)
    private Atividade atividade;
    @JoinColumn(name = "aulas_idaulas", referencedColumnName = "idaulas", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Aulas aulas;

    public AtividadeAula() {
    }

	public int getIdatividadeAula() {
		return idatividadeAula;
	}

	public void setIdatividadeAula(int idatividadeAula) {
		this.idatividadeAula = idatividadeAula;
	}

	public int getAulasIdaulas() {
		return aulasIdaulas;
	}

	public void setAulasIdaulas(int aulasIdaulas) {
		this.aulasIdaulas = aulasIdaulas;
	}

	public int getIdAtividade() {
		return idAtividade;
	}

	public void setIdAtividade(int idAtividade) {
		this.idAtividade = idAtividade;
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	public Aulas getAulas() {
		return aulas;
	}

	public void setAulas(Aulas aulas) {
		this.aulas = aulas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atividade == null) ? 0 : atividade.hashCode());
		result = prime * result + ((aulas == null) ? 0 : aulas.hashCode());
		result = prime * result + aulasIdaulas;
		result = prime * result + idAtividade;
		result = prime * result + idatividadeAula;
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
		AtividadeAula other = (AtividadeAula) obj;
		if (atividade == null) {
			if (other.atividade != null)
				return false;
		} else if (!atividade.equals(other.atividade))
			return false;
		if (aulas == null) {
			if (other.aulas != null)
				return false;
		} else if (!aulas.equals(other.aulas))
			return false;
		if (aulasIdaulas != other.aulasIdaulas)
			return false;
		if (idAtividade != other.idAtividade)
			return false;
		if (idatividadeAula != other.idatividadeAula)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AtividadeAula [idatividadeAula=" + idatividadeAula + ", aulasIdaulas=" + aulasIdaulas + ", idAtividade="
				+ idAtividade + ", atividade=" + atividade + ", aulas=" + aulas + "]";
	}
      
}
