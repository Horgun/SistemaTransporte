/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.horgun.dao;

import br.com.horgun.model.LocalEstoque;
import br.com.horgun.repository.ILocalEstoqueDAO;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author savio
 */
@RequestScoped
public class LocalEstoqueDAO extends HibernateGenericDAO<LocalEstoque, Long> implements ILocalEstoqueDAO{
    
    public LocalEstoqueDAO() {
        super(LocalEstoque.class, Long.class);
    }
    
}
