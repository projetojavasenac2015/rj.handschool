/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rj.handschool.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Renan
 */
@Entity
@Table(name = "owner")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Owner.findAll", query = "SELECT o FROM Owner o"),
    @NamedQuery(name = "Owner.findByNome", query = "SELECT o FROM Owner o WHERE o.nome = :nome"),
    @NamedQuery(name = "Owner.findByFuncao", query = "SELECT o FROM Owner o WHERE o.funcao = :funcao"),
    })
public class Owner extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "nome")
    private String nome;
    @Column(name = "funcao")
    private String funcao;
    
    public Owner() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}
