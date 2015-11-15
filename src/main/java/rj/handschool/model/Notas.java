/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rj.handschool.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Renan
 */
@Entity
@Table(name = "notas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notas.findAll", query = "SELECT n FROM Notas n"),
    @NamedQuery(name = "Notas.findByIdnota", query = "SELECT n FROM Notas n WHERE n.idnota = :idnota"),
    @NamedQuery(name = "Notas.findByAnoVigente", query = "SELECT n FROM Notas n WHERE n.anoVigente = :anoVigente"),
    @NamedQuery(name = "Notas.findByDataHoraCadastro", query = "SELECT n FROM Notas n WHERE n.dataHoraCadastro = :dataHoraCadastro"),
    @NamedQuery(name = "Notas.findByDataUltAtualizacao", query = "SELECT n FROM Notas n WHERE n.dataUltAtualizacao = :dataUltAtualizacao"),
    @NamedQuery(name = "Notas.findByValor", query = "SELECT n FROM Notas n WHERE n.valor = :valor"),
    @NamedQuery(name = "Notas.findByMatriculaAluno", query = "SELECT n FROM Notas n WHERE n.matriculaAluno = :matriculaAluno"),
    @NamedQuery(name = "Notas.findByMatricula", query = "SELECT n FROM Notas n WHERE n.matricula = :matricula")})
public class Notas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idnota")
    private Integer idnota;
    @Column(name = "ANO_VIGENTE")
    private Integer anoVigente;
    @Column(name = "DATA_HORA_CADASTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraCadastro;
    @Column(name = "DATA_ULT_ATUALIZACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltAtualizacao;
    @Basic(optional = false)
    @Column(name = "valor")
    private double valor;
    @Column(name = "MATRICULA_ALUNO")
    private String matriculaAluno;
    @Column(name = "MATRICULA")
    private String matricula;
    @JoinColumn(name = "IDDISCIPLINA", referencedColumnName = "iddisciplina")
    @ManyToOne
    private Disciplina iddisciplina;
    @JoinColumn(name = "IDTIPO_AVALIACAO", referencedColumnName = "IDTIPO_AVALIACAO")
    @ManyToOne
    private TipoAvaliacao idtipoAvaliacao;
    @JoinColumn(name = "IDTURMA", referencedColumnName = "idturma")
    @ManyToOne
    private Turma idturma;

    public Notas() {
    }

    public Notas(Integer idnota) {
        this.idnota = idnota;
    }

    public Notas(Integer idnota, double valor) {
        this.idnota = idnota;
        this.valor = valor;
    }

    public Integer getIdnota() {
        return idnota;
    }

    public void setIdnota(Integer idnota) {
        this.idnota = idnota;
    }

    public Integer getAnoVigente() {
        return anoVigente;
    }

    public void setAnoVigente(Integer anoVigente) {
        this.anoVigente = anoVigente;
    }

    public Date getDataHoraCadastro() {
        return dataHoraCadastro;
    }

    public void setDataHoraCadastro(Date dataHoraCadastro) {
        this.dataHoraCadastro = dataHoraCadastro;
    }

    public Date getDataUltAtualizacao() {
        return dataUltAtualizacao;
    }

    public void setDataUltAtualizacao(Date dataUltAtualizacao) {
        this.dataUltAtualizacao = dataUltAtualizacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getMatriculaAluno() {
        return matriculaAluno;
    }

    public void setMatriculaAluno(String matriculaAluno) {
        this.matriculaAluno = matriculaAluno;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Disciplina getIddisciplina() {
        return iddisciplina;
    }

    public void setIddisciplina(Disciplina iddisciplina) {
        this.iddisciplina = iddisciplina;
    }

    public TipoAvaliacao getIdtipoAvaliacao() {
        return idtipoAvaliacao;
    }

    public void setIdtipoAvaliacao(TipoAvaliacao idtipoAvaliacao) {
        this.idtipoAvaliacao = idtipoAvaliacao;
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
        hash += (idnota != null ? idnota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notas)) {
            return false;
        }
        Notas other = (Notas) object;
        if ((this.idnota == null && other.idnota != null) || (this.idnota != null && !this.idnota.equals(other.idnota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bd.Notas[ idnota=" + idnota + " ]";
    }
    
}
