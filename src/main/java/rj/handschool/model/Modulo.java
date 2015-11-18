/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rj.handschool.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Renan
 */
@Entity
@Table(name = "modulo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modulo.findAll", query = "SELECT m FROM Modulo m"),
    @NamedQuery(name = "Modulo.findByIdmodulo", query = "SELECT m FROM Modulo m WHERE m.moduloPK.idmodulo = :idmodulo"),
    @NamedQuery(name = "Modulo.findByAtivo", query = "SELECT m FROM Modulo m WHERE m.ativo = :ativo"),
    @NamedQuery(name = "Modulo.findByDataHoraCadastro", query = "SELECT m FROM Modulo m WHERE m.dataHoraCadastro = :dataHoraCadastro"),
    @NamedQuery(name = "Modulo.findByDataUltAtualizacao", query = "SELECT m FROM Modulo m WHERE m.dataUltAtualizacao = :dataUltAtualizacao"),
    @NamedQuery(name = "Modulo.findByDescricao", query = "SELECT m FROM Modulo m WHERE m.descricao = :descricao"),
    @NamedQuery(name = "Modulo.findByIdDisciplina", query = "SELECT m FROM Modulo m WHERE m.moduloPK.idDisciplina = :idDisciplina"),
    @NamedQuery(name = "Modulo.findByIdCurso", query = "SELECT m FROM Modulo m WHERE m.moduloPK.idCurso = :idCurso")})
public class Modulo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ModuloPK moduloPK;
    @NotNull(message="Indique a situação")
    @Column(name = "ativo")
    private Character ativo;
    @Column(name = "data_hora_cadastro", updatable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraCadastro;
    @Column(name = "data_ult_atualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltAtualizacao;
    @NotNull
    @NotEmpty(message="Informe a descrição do Módulo")
    @Size(min=8,message="Nome Muito Pequeno. Min* 8 caracteres")
    @Column(name = "descricao")
    private String descricao;
    @NotNull(message="Informe o Curso")
    @JoinColumn(name = "idcurso", referencedColumnName = "idcurso", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Curso curso;
    @Size(min=1,message="No minimo 1 Disciplina")
    @JoinColumn(name = "id_disciplina", referencedColumnName = "iddisciplina", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Disciplina disciplina;

    public Modulo() {
    }

    public Modulo(ModuloPK moduloPK) {
        this.moduloPK = moduloPK;
    }

    public Modulo(int idmodulo, int idDisciplina, int idCurso) {
        this.moduloPK = new ModuloPK(idmodulo, idDisciplina, idCurso);
    }

    public ModuloPK getModuloPK() {
        return moduloPK;
    }

    public void setModuloPK(ModuloPK moduloPK) {
        this.moduloPK = moduloPK;
    }

    public Character getAtivo() {
        return ativo;
    }

    public void setAtivo(Character ativo) {
        this.ativo = ativo;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (moduloPK != null ? moduloPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modulo)) {
            return false;
        }
        Modulo other = (Modulo) object;
        if ((this.moduloPK == null && other.moduloPK != null) || (this.moduloPK != null && !this.moduloPK.equals(other.moduloPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rj.handschool.modelo.Modulo[ moduloPK=" + moduloPK + " ]";
    }
    
}
