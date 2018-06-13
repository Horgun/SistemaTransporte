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
public class TipoManutencao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "tipomanutencao_gen", sequenceName = "tipomanutencao_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "tipomanutencao_gen")
    private Long id;
    
    private String descricao;
    private float kmValidade;
    private int mesesValidade;

    public TipoManutencao() {
    }

    public TipoManutencao(long id) {
        this.id = id;
    }

    public TipoManutencao(Long id, String descricao, float kmValidade, int mesesValidade) {
        this.id = id;
        this.descricao = descricao;
        this.kmValidade = kmValidade;
        this.mesesValidade = mesesValidade;
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
        if (!(object instanceof TipoManutencao)) {
            return false;
        }
        TipoManutencao other = (TipoManutencao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.horgun.model.TipoManutencao[ id=" + id + " ]";
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getKmValidade() {
        return kmValidade;
    }

    public void setKmValidade(float kmValidade) {
        this.kmValidade = kmValidade;
    }

    public int getMesesValidade() {
        return mesesValidade;
    }

    public void setMesesValidade(int mesesValidade) {
        this.mesesValidade = mesesValidade;
    }
    
}
