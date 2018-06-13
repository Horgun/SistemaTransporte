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
public class Veiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "veiculo_gen", sequenceName = "veiculo_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "veiculo_gen")
    private Long id;
    
    private String renavam;
    private String placa;
    private String chassi;
    private String marca;
    private String modelo;
    private int anoFabricacao;
    private int anoModelo;
    private String categoria;
    private String cor;
    private String especie;
    private String nomeProprietario;
    private String documentoProprietario;
    private String numFrota;

    public Veiculo() {
    }

    public Veiculo(long id) {
        this.id = id;
    }

    public Veiculo(Long id, String renavam, String placa, String chassi, String marca, String modelo, int anoFabricacao, int anoModelo, String categoria, String cor, String especie, String nomeProprietario, String documentoProprietario, String numFrota) {
        this.id = id;
        this.renavam = renavam;
        this.placa = placa;
        this.chassi = chassi;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.anoModelo = anoModelo;
        this.categoria = categoria;
        this.cor = cor;
        this.especie = especie;
        this.nomeProprietario = nomeProprietario;
        this.documentoProprietario = documentoProprietario;
        this.numFrota = numFrota;
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
        if (!(object instanceof Veiculo)) {
            return false;
        }
        Veiculo other = (Veiculo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.horgun.model.Veiculo[ id=" + id + " ]";
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public int getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(int anoModelo) {
        this.anoModelo = anoModelo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getNomeProprietario() {
        return nomeProprietario;
    }

    public void setNomeProprietario(String nomeProprietario) {
        this.nomeProprietario = nomeProprietario;
    }

    public String getDocumentoProprietario() {
        return documentoProprietario;
    }

    public void setDocumentoProprietario(String documentoProprietario) {
        this.documentoProprietario = documentoProprietario;
    }

    public String getNumFrota() {
        return numFrota;
    }

    public void setNumFrota(String numFrota) {
        this.numFrota = numFrota;
    }
    
}
