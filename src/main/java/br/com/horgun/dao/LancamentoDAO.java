/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.horgun.dao;

import br.com.horgun.model.Lancamento;
import br.com.horgun.repository.ILancamentoDAO;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author savio
 */
@RequestScoped
public class LancamentoDAO extends HibernateGenericDAO<Lancamento, Long> implements ILancamentoDAO{
    
    public LancamentoDAO() {
        super(Lancamento.class, Long.class);
    }
    
}
