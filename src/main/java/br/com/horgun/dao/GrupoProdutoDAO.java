/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.horgun.dao;

import br.com.horgun.model.GrupoProduto;
import br.com.horgun.repository.IGrupoProdutoDAO;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author savio
 */
@RequestScoped
public class GrupoProdutoDAO extends HibernateGenericDAO<GrupoProduto, Long> implements IGrupoProdutoDAO{
    
    public GrupoProdutoDAO() {
        super(GrupoProduto.class, Long.class);
    }
    
}
