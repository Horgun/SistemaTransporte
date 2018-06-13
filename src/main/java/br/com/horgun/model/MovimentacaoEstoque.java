/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.horgun.model;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author savio
 */
@Entity
public class MovimentacaoEstoque implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "movimentacaoestoque_gen", sequenceName = "movimentacaoestoque_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "movimentacaoestoque_gen")
    private Long id;
    
    private Date dataMovimentacao;
    
    private char tipoMovimentacao;
    
    private String tabela;
    private Long codMovimentacao;
    private int quantidade;
    
    @ManyToOne
    private Estoque estoque;

    public MovimentacaoEstoque() {
    }

    public MovimentacaoEstoque(long id) {
        this.id = id;
    }

    public MovimentacaoEstoque(Long id, Date dataMovimentacao, char tipoMovimentacao, String tabela, Long codMovimentacao, int quantidade, Estoque estoque) {
        this.id = id;
        this.dataMovimentacao = dataMovimentacao;
        this.tipoMovimentacao = tipoMovimentacao;
        this.tabela = tabela;
        this.codMovimentacao = codMovimentacao;
        this.quantidade = quantidade;
        this.estoque = estoque;
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
        if (!(object instanceof MovimentacaoEstoque)) {
            return false;
        }
        MovimentacaoEstoque other = (MovimentacaoEstoque) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.horgun.model.MovimentacaoEstoque[ id=" + id + " ]";
    }

    public Date getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(Date dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    public char getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(char tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public String getTabela() {
        return tabela;
    }

    public void setTabela(String tabela) {
        this.tabela = tabela;
    }

    public Long getCodMovimentacao() {
        return codMovimentacao;
    }

    public void setCodMovimentacao(Long codMovimentacao) {
        this.codMovimentacao = codMovimentacao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }
    
}
