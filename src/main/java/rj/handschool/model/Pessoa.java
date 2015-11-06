package rj.handschool.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the pessoa database table.
 * 
 */
@Entity
@NamedQuery(name="Pessoa.findAll", query="SELECT p FROM Pessoa p")
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idpessoa;

	private String cpf;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_HORA_CADASTRO")
	private Date dataHoraCadastro;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_NASCIMENTO")
	private Date dataNascimento;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_ULT_ATUALIZACAO")
	private Date dataUltAtualizacao;

	private String email;

	private String matricula;

	@Column(name="MUNICIPIO_NASCIMENTO")
	private String municipioNascimento;

	private String nome;

	@Column(name="PAIS_NASCIMENTO")
	private String paisNascimento;

	private String rg;

	@Column(name="RG_DOCUMENTO")
	private String rgDocumento;

	private String senha;

	//bi-directional many-to-one association to Aluno
	@OneToMany(mappedBy="pessoa")
	private List<Aluno> alunos;

	//bi-directional many-to-one association to Instrutor
	@OneToMany(mappedBy="pessoa")
	private List<Instrutor> instrutors;

	//bi-directional many-to-one association to Login
	@OneToMany(mappedBy="pessoa")
	private List<Login> logins;

	//bi-directional many-to-one association to TipoPessoa
	@ManyToOne
	@JoinColumn(name="IDTIPO_PESSOA")
	private TipoPessoa tipoPessoa;

	public Pessoa() {
	}

	public int getIdpessoa() {
		return this.idpessoa;
	}

	public void setIdpessoa(int idpessoa) {
		this.idpessoa = idpessoa;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataHoraCadastro() {
		return this.dataHoraCadastro;
	}

	public void setDataHoraCadastro(Date dataHoraCadastro) {
		this.dataHoraCadastro = dataHoraCadastro;
	}

	public Date getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Date getDataUltAtualizacao() {
		return this.dataUltAtualizacao;
	}

	public void setDataUltAtualizacao(Date dataUltAtualizacao) {
		this.dataUltAtualizacao = dataUltAtualizacao;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMunicipioNascimento() {
		return this.municipioNascimento;
	}

	public void setMunicipioNascimento(String municipioNascimento) {
		this.municipioNascimento = municipioNascimento;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPaisNascimento() {
		return this.paisNascimento;
	}

	public void setPaisNascimento(String paisNascimento) {
		this.paisNascimento = paisNascimento;
	}

	public String getRg() {
		return this.rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getRgDocumento() {
		return this.rgDocumento;
	}

	public void setRgDocumento(String rgDocumento) {
		this.rgDocumento = rgDocumento;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Aluno> getAlunos() {
		return this.alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Aluno addAluno(Aluno aluno) {
		getAlunos().add(aluno);
		aluno.setPessoa(this);

		return aluno;
	}

	public Aluno removeAluno(Aluno aluno) {
		getAlunos().remove(aluno);
		aluno.setPessoa(null);

		return aluno;
	}

	public List<Instrutor> getInstrutors() {
		return this.instrutors;
	}

	public void setInstrutors(List<Instrutor> instrutors) {
		this.instrutors = instrutors;
	}

	public Instrutor addInstrutor(Instrutor instrutor) {
		getInstrutors().add(instrutor);
		instrutor.setPessoa(this);

		return instrutor;
	}

	public Instrutor removeInstrutor(Instrutor instrutor) {
		getInstrutors().remove(instrutor);
		instrutor.setPessoa(null);

		return instrutor;
	}

	public List<Login> getLogins() {
		return this.logins;
	}

	public void setLogins(List<Login> logins) {
		this.logins = logins;
	}

	public Login addLogin(Login login) {
		getLogins().add(login);
		login.setPessoa(this);

		return login;
	}

	public Login removeLogin(Login login) {
		getLogins().remove(login);
		login.setPessoa(null);

		return login;
	}

	public TipoPessoa getTipoPessoa() {
		return this.tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

}