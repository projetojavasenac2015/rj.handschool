package rj.handschool.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tipo_registro database table.
 * 
 */
@Entity
@Table(name="tipo_registro")
@NamedQuery(name="TipoRegistro.findAll", query="SELECT t FROM TipoRegistro t")
public class TipoRegistro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="IDTIPO_REGISTRO")
	private int idtipoRegistro;

	private byte ativo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_HORA_CADASTRO")
	private Date dataHoraCadastro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_ULT_ATUALIZACAO")
	private Date dataUltAtualizacao;

	private String nome;

	//bi-directional many-to-one association to ListaPresenca
	@OneToMany(mappedBy="tipoRegistro")
	private List<ListaPresenca> listaPresencas;

	public TipoRegistro() {
	}

	public int getIdtipoRegistro() {
		return this.idtipoRegistro;
	}

	public void setIdtipoRegistro(int idtipoRegistro) {
		this.idtipoRegistro = idtipoRegistro;
	}

	public byte getAtivo() {
		return this.ativo;
	}

	public void setAtivo(byte ativo) {
		this.ativo = ativo;
	}

	public Date getDataHoraCadastro() {
		return this.dataHoraCadastro;
	}

	public void setDataHoraCadastro(Date dataHoraCadastro) {
		this.dataHoraCadastro = dataHoraCadastro;
	}

	public Date getDataUltAtualizacao() {
		return this.dataUltAtualizacao;
	}

	public void setDataUltAtualizacao(Date dataUltAtualizacao) {
		this.dataUltAtualizacao = dataUltAtualizacao;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<ListaPresenca> getListaPresencas() {
		return this.listaPresencas;
	}

	public void setListaPresencas(List<ListaPresenca> listaPresencas) {
		this.listaPresencas = listaPresencas;
	}

	public ListaPresenca addListaPresenca(ListaPresenca listaPresenca) {
		getListaPresencas().add(listaPresenca);
		listaPresenca.setTipoRegistro(this);

		return listaPresenca;
	}

	public ListaPresenca removeListaPresenca(ListaPresenca listaPresenca) {
		getListaPresencas().remove(listaPresenca);
		listaPresenca.setTipoRegistro(null);

		return listaPresenca;
	}

}