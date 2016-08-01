package rj.handschool.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "perfilpessoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PerfilPessoa.findByProfessorPerfil", query = "SELECT a FROM PerfilPessoa a where a.idPerfil.Id = :idperfil and a.idPessoa.idpessoa = :idpessoa"),
     })
public class PerfilPessoa implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "data_acao", updatable= false,  columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date dataPerfil;
	
	@JoinColumn(name = "id_perfil", referencedColumnName = "idperfil")
    @ManyToOne(optional = false)
	private Perfil idPerfil;
	
	@JoinColumn(name = "id_pessoa", referencedColumnName = "idpessoa")
    @ManyToOne(optional = false)
	private Pessoa idPessoa;
	
	@Transient
    private Pessoa listaprofessor;
		
	@Transient
    private Perfil listaperfil;
			
	public Pessoa getListaprofessor() {
		return listaprofessor;
	}
	public void setListaprofessor(Pessoa listaprofessor) {
		this.listaprofessor = listaprofessor;
	}
	public Perfil getListaperfil() {
		return listaperfil;
	}
	public void setListaperfil(Perfil listaperfil) {
		this.listaperfil = listaperfil;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public Date getDataPerfil() {
		return dataPerfil;
	}

	public void setDataPerfil(Date dataPerfil) {
		this.dataPerfil = dataPerfil;
	}

	public Perfil getIdPerfil() {
		return idPerfil;
	}
	public void setIdPerfil(Perfil idPerfil) {
		this.idPerfil = idPerfil;
	}

	public Pessoa getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Pessoa idPessoa) {
		this.idPessoa = idPessoa;
	}

	public PerfilPessoa() {
		
	}
	
	public PerfilPessoa(Pessoa pessoa, Perfil perfil) {
		this.idPessoa = pessoa;
		this.idPerfil = perfil;
	}	
}
