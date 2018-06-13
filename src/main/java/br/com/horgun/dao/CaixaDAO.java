/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.horgun.dao;

import br.com.horgun.model.Caixa;
import br.com.horgun.repository.ICaixaDAO;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author savio
 */
@RequestScoped
public class CaixaDAO extends HibernateGenericDAO<Caixa, Long> implements ICaixaDAO{
    
    public CaixaDAO() {
        super(Caixa.class, Long.class);
    }
    
}
