/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.horgun.dao;

import br.com.horgun.model.MovimentacaoEstoque;
import br.com.horgun.repository.IMovimentacaoEstoqueDAO;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author savio
 */
@RequestScoped
public class MovimentacaoEstoqueDAO extends HibernateGenericDAO<MovimentacaoEstoque, Long> implements IMovimentacaoEstoqueDAO{
    
    public MovimentacaoEstoqueDAO() {
        super(MovimentacaoEstoque.class, Long.class);
    }
    
}
