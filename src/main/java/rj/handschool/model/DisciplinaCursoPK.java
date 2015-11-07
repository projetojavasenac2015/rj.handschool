package rj.handschool.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the disciplina_curso database table.
 * 
 */
@Embeddable
public class DisciplinaCursoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int idcurso;

	@Column(insertable=false, updatable=false)
	private int iddisciplina;

	public DisciplinaCursoPK() {
	}
	public int getIdcurso() {
		return this.idcurso;
	}
	public void setIdcurso(int idcurso) {
		this.idcurso = idcurso;
	}
	public int getIddisciplina() {
		return this.iddisciplina;
	}
	public void setIddisciplina(int iddisciplina) {
		this.iddisciplina = iddisciplina;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DisciplinaCursoPK)) {
			return false;
		}
		DisciplinaCursoPK castOther = (DisciplinaCursoPK)other;
		return 
			(this.idcurso == castOther.idcurso)
			&& (this.iddisciplina == castOther.iddisciplina);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idcurso;
		hash = hash * prime + this.iddisciplina;
		
		return hash;
	}
}