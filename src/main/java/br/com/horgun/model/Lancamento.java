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
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author savio
 */
@Entity
public class Lancamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "lancamento_gen", sequenceName = "lancamento_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "lancamento_gen")
    private Long id;

    private String observacoes;

    @ManyToOne
    private Caixa caixa;

    private float valotTotal;
    private String numDocumento;

    @ManyToOne
    private PrestadoraDeServico prestadoraDeServico;

    public Lancamento() {
    }

    public Lancamento(long id) {
        this.id = id;
    }

    public Lancamento(Long id, String observacoes, Caixa caixa, float valotTotal, String numDocumento, PrestadoraDeServico prestadoraDeServico) {
        this.id = id;
        this.observacoes = observacoes;
        this.caixa = caixa;
        this.valotTotal = valotTotal;
        this.numDocumento = numDocumento;
        this.prestadoraDeServico = prestadoraDeServico;
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
        if (!(object instanceof Lancamento)) {
            return false;
        }
        Lancamento other = (Lancamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.horgun.model.Lancamento[ id=" + id + " ]";
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    public float getValotTotal() {
        return valotTotal;
    }

    public void setValotTotal(float valotTotal) {
        this.valotTotal = valotTotal;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public PrestadoraDeServico getPrestadoraDeServico() {
        return prestadoraDeServico;
    }

    public void setPrestadoraDeServico(PrestadoraDeServico prestadoraDeServico) {
        this.prestadoraDeServico = prestadoraDeServico;
    }

}
