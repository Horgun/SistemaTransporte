/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.horgun.dao;

import br.com.horgun.model.Abastecimento;
import br.com.horgun.repository.IAbastecimentoDAO;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author savio
 */
@RequestScoped
public class AbastecimentoDAO extends HibernateGenericDAO<Abastecimento, Long> implements IAbastecimentoDAO{
    
    public AbastecimentoDAO() {
        super(Abastecimento.class, Long.class);
    }
    
}
