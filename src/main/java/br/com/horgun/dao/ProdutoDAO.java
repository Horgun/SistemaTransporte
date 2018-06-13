/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.horgun.dao;

import br.com.horgun.model.Produto;
import br.com.horgun.repository.IProdutoDAO;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author savio
 */
@RequestScoped
public class ProdutoDAO extends HibernateGenericDAO<Produto, Long> implements IProdutoDAO{
    
    public ProdutoDAO() {
        super(Produto.class, Long.class);
    }
    
}
