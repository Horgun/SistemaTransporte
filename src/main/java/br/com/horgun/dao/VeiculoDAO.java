/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.horgun.dao;

import br.com.horgun.model.Veiculo;
import br.com.horgun.repository.IVeiculoDAO;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author savio
 */
@RequestScoped
public class VeiculoDAO extends HibernateGenericDAO<Veiculo, Long> implements IVeiculoDAO{
    
    public VeiculoDAO() {
        super(Veiculo.class, Long.class);
    }
    
}
