package rj.handschool.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "notificacao")
public class Notificacao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idnotificacao;
	
	@NotEmpty
	@Column(name="notificacao", length=255)
	private String notificacao;
	
	@Column(columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
	private Date dataNotificacao;
	
	@JoinColumn(name = "id_turma", referencedColumnName = "idturma")
    @ManyToOne(optional = false)
	private Turma turma;
	
	@JoinColumn(name = "id_professor", referencedColumnName = "idpessoa")
    @ManyToOne(optional = false)
	private Professor professor;
	
	public Notificacao(){
		
	}
	
	public Notificacao(Turma turma, Professor professor, String notificacao){
		this.turma = turma;
		this.professor = professor;
		this.notificacao = notificacao;
	}

	public int getIdnotificacao() {
		return idnotificacao;
	}

	public void setIdnotificacao(int idnotificacao) {
		this.idnotificacao = idnotificacao;
	}

	public String getNotificacao() {
		return notificacao;
	}

	public void setNotificacao(String notificacao) {
		this.notificacao = notificacao;
	}

	public Date getDataNotificacao() {
		return dataNotificacao;
	}

	public void setDataNotificacao(Date dataNotificacao) {
		this.dataNotificacao = dataNotificacao;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Notificacao [idnotificacao=" + idnotificacao + ", notificacao="
				+ notificacao + ", dataNotificacao=" + dataNotificacao
				+ ", turma=" + turma + ", professor=" + professor + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idnotificacao;
		result = prime * result
				+ ((notificacao == null) ? 0 : notificacao.hashCode());
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
		Notificacao other = (Notificacao) obj;
		if (idnotificacao != other.idnotificacao)
			return false;
		if (notificacao == null) {
			if (other.notificacao != null)
				return false;
		} else if (!notificacao.equals(other.notificacao))
			return false;
		return true;
	}
}
