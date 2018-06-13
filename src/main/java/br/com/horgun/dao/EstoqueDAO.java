/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.horgun.dao;

import br.com.horgun.model.Estoque;
import br.com.horgun.repository.IEstoqueDAO;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author savio
 */
@RequestScoped
public class EstoqueDAO extends HibernateGenericDAO<Estoque, Long> implements IEstoqueDAO{
    
    public EstoqueDAO() {
        super(Estoque.class, Long.class);
    }
    
}
