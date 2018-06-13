/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.horgun.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
    
/**
 *
 * @author savio
 */
@Entity
public class Manutencao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "manutencao_gen", sequenceName = "manutencao_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "manutencao_gen")
    private Long id;
    
    @ManyToMany
    private List<TipoManutencao> tiposManutencao;

    private Date dataManutencao;
    
    private Date dataProximaManutencao;
    
    private float kmManutencao;
    private float kmProximaManutencao;
    
    @ManyToOne
    private Veiculo veiculo;
    
    private String observacoes;
    private String categoriaManutencao;
    
    @ManyToOne
    private PrestadoraDeServico prestadoraDeServico;
    
    private String responsavel;

    public Manutencao() {
    }

    public Manutencao(long id) {
        this.id = id;
    }

    public Manutencao(Long id, List<TipoManutencao> tiposManutencao, Date dataManutencao, Date dataProximaManutencao, float kmManutencao, float kmProximaManutencao, Veiculo veiculo, String observacoes, String categoriaManutencao, PrestadoraDeServico prestadoraDeServico, String responsavel) {
        this.id = id;
        this.tiposManutencao = tiposManutencao;
        this.dataManutencao = dataManutencao;
        this.dataProximaManutencao = dataProximaManutencao;
        this.kmManutencao = kmManutencao;
        this.kmProximaManutencao = kmProximaManutencao;
        this.veiculo = veiculo;
        this.observacoes = observacoes;
        this.categoriaManutencao = categoriaManutencao;
        this.prestadoraDeServico = prestadoraDeServico;
        this.responsavel = responsavel;
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
        if (!(object instanceof Manutencao)) {
            return false;
        }
        Manutencao other = (Manutencao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.horgun.model.Manutencao[ id=" + id + " ]";
    }

    public List<TipoManutencao> getTiposManutencao() {
        return tiposManutencao;
    }

    public void setTiposManutencao(List<TipoManutencao> tiposManutencao) {
        this.tiposManutencao = tiposManutencao;
    }

    public Date getDataManutencao() {
        return dataManutencao;
    }

    public void setDataManutencao(Date dataManutencao) {
        this.dataManutencao = dataManutencao;
    }

    public Date getDataProximaManutencao() {
        return dataProximaManutencao;
    }

    public void setDataProximaManutencao(Date dataProximaManutencao) {
        this.dataProximaManutencao = dataProximaManutencao;
    }

    public float getKmManutencao() {
        return kmManutencao;
    }

    public void setKmManutencao(float kmManutencao) {
        this.kmManutencao = kmManutencao;
    }

    public float getKmProximaManutencao() {
        return kmProximaManutencao;
    }

    public void setKmProximaManutencao(float kmProximaManutencao) {
        this.kmProximaManutencao = kmProximaManutencao;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getCategoriaManutencao() {
        return categoriaManutencao;
    }

    public void setCategoriaManutencao(String categoriaManutencao) {
        this.categoriaManutencao = categoriaManutencao;
    }

    public PrestadoraDeServico getPrestadoraDeServico() {
        return prestadoraDeServico;
    }

    public void setPrestadoraDeServico(PrestadoraDeServico prestadoraDeServico) {
        this.prestadoraDeServico = prestadoraDeServico;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }
    
}
