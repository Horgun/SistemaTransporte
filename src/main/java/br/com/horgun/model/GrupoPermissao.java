/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.horgun.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author savio
 */
@Entity
public class GrupoPermissao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "grupopermissao_gen", sequenceName = "grupopermissao_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "grupopermissao_gen")
    private Long id;

    private String descricao;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Permissoes_Grupos")
    private List<Permissao> permissoes;

    public GrupoPermissao() {
    }

    public GrupoPermissao(long id) {
        this.id = id;
    }
    
    public GrupoPermissao(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public GrupoPermissao(Long id, String descricao, List<Permissao> permissoes) {
        this.id = id;
        this.descricao = descricao;
        this.permissoes = permissoes;
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
        if (!(object instanceof GrupoPermissao)) {
            return false;
        }
        GrupoPermissao other = (GrupoPermissao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.horgun.model.GrupoPermissao[ id=" + id + " ]";
    }

    public List<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(List<Permissao> permissoes) {
        this.permissoes = permissoes;
    }

}
