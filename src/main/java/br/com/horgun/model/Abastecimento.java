/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.horgun.model;

import java.io.Serializable;
import java.sql.Time;
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
public class Abastecimento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "abastecimento_gen", sequenceName = "abastecimento_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "abastecimento_gen")
    private Long id;

    @ManyToOne
    private Veiculo veiculo;

    @ManyToOne
    private PrestadoraDeServico postoCombustivel;

    @ManyToOne
    private Funcionario responsavel;

    private float km;

    private float litragem;

    private float valorPorLitro;

    private float valorTotal;

    private Date dataAbastecimento;

    private Time hora;

    public Abastecimento() {
    }
    
    public Abastecimento(long id) {
        this.id = id;
    }

    public Abastecimento(Long id, Veiculo veiculo, PrestadoraDeServico postoCombustivel, Funcionario responsavel, float km, float litragem, float valorPorLitro, float valorTotal, Date dataAbastecimento, Time hora) {
        this.id = id;
        this.veiculo = veiculo;
        this.postoCombustivel = postoCombustivel;
        this.responsavel = responsavel;
        this.km = km;
        this.litragem = litragem;
        this.valorPorLitro = valorPorLitro;
        this.valorTotal = valorTotal;
        this.dataAbastecimento = dataAbastecimento;
        this.hora = hora;
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
        if (!(object instanceof Abastecimento)) {
            return false;
        }
        Abastecimento other = (Abastecimento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.horgun.model.Abastecimento[ id=" + id + " ]";
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public PrestadoraDeServico getPostoCombustivel() {
        return postoCombustivel;
    }

    public void setPostoCombustivel(PrestadoraDeServico postoCombustivel) {
        this.postoCombustivel = postoCombustivel;
    }

    public Funcionario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Funcionario responsavel) {
        this.responsavel = responsavel;
    }

    public float getKm() {
        return km;
    }

    public void setKm(float km) {
        this.km = km;
    }

    public float getLitragem() {
        return litragem;
    }

    public void setLitragem(float litragem) {
        this.litragem = litragem;
    }

    public float getValorPorLitro() {
        return valorPorLitro;
    }

    public void setValorPorLitro(float valorPorLitro) {
        this.valorPorLitro = valorPorLitro;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getDataAbastecimento() {
        return dataAbastecimento;
    }

    public void setDataAbastecimento(Date dataAbastecimento) {
        this.dataAbastecimento = dataAbastecimento;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

}
