package rj.handschool.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the disciplina_aluno database table.
 * 
 */
@Embeddable
public class DisciplinaAlunoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String matricula;

	@Column(insertable=false, updatable=false)
	private int iddisciplina;

	public DisciplinaAlunoPK() {
	}
	public String getMatricula() {
		return this.matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
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
		if (!(other instanceof DisciplinaAlunoPK)) {
			return false;
		}
		DisciplinaAlunoPK castOther = (DisciplinaAlunoPK)other;
		return 
			this.matricula.equals(castOther.matricula)
			&& (this.iddisciplina == castOther.iddisciplina);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.matricula.hashCode();
		hash = hash * prime + this.iddisciplina;
		
		return hash;
	}
}