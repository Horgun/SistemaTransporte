/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.horgun.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author savio
 */
@Entity
public class Caixa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "caixa_gen", sequenceName = "caixa_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "caixa_gen")
    private Long id;

    private char naturezaCaixa;

    private String descricao;

    public Caixa() {
    }

    public Caixa(long id) {
        this.id = id;
    }

    public Caixa(Long id, char naturezaCaixa, String descricao) {
        this.id = id;
        this.naturezaCaixa = naturezaCaixa;
        this.descricao = descricao;
    }

    public char getNaturezaCaixa() {
        return naturezaCaixa;
    }

    public void setNaturezaCaixa(char naturezaCaixa) {
        this.naturezaCaixa = naturezaCaixa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caixa)) {
            return false;
        }
        Caixa other = (Caixa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.horgun.model.Caixa[ id=" + id + " ]";
    }

}
