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
@Table(name = "lista_presenca")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ListaPresenca.findAll", query = "SELECT l FROM ListaPresenca l"),
    @NamedQuery(name = "ListaPresenca.findByIdlistaPresenca", query = "SELECT l FROM ListaPresenca l WHERE l.idlistaPresenca = :idlistaPresenca"),
    @NamedQuery(name = "ListaPresenca.findByDataHoraCadastro", query = "SELECT l FROM ListaPresenca l WHERE l.dataHoraCadastro = :dataHoraCadastro"),
    @NamedQuery(name = "ListaPresenca.findByDataUltAtualizacao", query = "SELECT l FROM ListaPresenca l WHERE l.dataUltAtualizacao = :dataUltAtualizacao"),
    @NamedQuery(name = "ListaPresenca.findByMatricula", query = "SELECT l FROM ListaPresenca l WHERE l.matricula = :matricula")})
public class ListaPresenca implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDLISTA_PRESENCA")
    private Integer idlistaPresenca;
    @Column(name = "DATA_HORA_CADASTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraCadastro;
    @Column(name = "DATA_ULT_ATUALIZACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltAtualizacao;
    @Column(name = "MATRICULA")
    private String matricula;
    @JoinColumn(name = "IDAULAS", referencedColumnName = "idaulas")
    @ManyToOne
    private Aula idaulas;
    @JoinColumn(name = "IDTIPO_REGISTRO", referencedColumnName = "IDTIPO_REGISTRO")
    @ManyToOne
    private TipoRegistro idtipoRegistro;

    public ListaPresenca() {
    }

    public ListaPresenca(Integer idlistaPresenca) {
        this.idlistaPresenca = idlistaPresenca;
    }

    public Integer getIdlistaPresenca() {
        return idlistaPresenca;
    }

    public void setIdlistaPresenca(Integer idlistaPresenca) {
        this.idlistaPresenca = idlistaPresenca;
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Aula getIdaulas() {
        return idaulas;
    }

    public void setIdaulas(Aula idaulas) {
        this.idaulas = idaulas;
    }

    public TipoRegistro getIdtipoRegistro() {
        return idtipoRegistro;
    }

    public void setIdtipoRegistro(TipoRegistro idtipoRegistro) {
        this.idtipoRegistro = idtipoRegistro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlistaPresenca != null ? idlistaPresenca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListaPresenca)) {
            return false;
        }
        ListaPresenca other = (ListaPresenca) object;
        if ((this.idlistaPresenca == null && other.idlistaPresenca != null) || (this.idlistaPresenca != null && !this.idlistaPresenca.equals(other.idlistaPresenca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bd.ListaPresenca[ idlistaPresenca=" + idlistaPresenca + " ]";
    }
    
}
