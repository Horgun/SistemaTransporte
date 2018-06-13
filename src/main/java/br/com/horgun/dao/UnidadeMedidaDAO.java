/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.horgun.dao;

import br.com.horgun.model.UnidadeMedida;
import br.com.horgun.repository.IUnidadeMedidaDAO;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author savio
 */
@RequestScoped
public class UnidadeMedidaDAO extends HibernateGenericDAO<UnidadeMedida, Long> implements IUnidadeMedidaDAO{
    
    public UnidadeMedidaDAO() {
        super(UnidadeMedida.class, Long.class);
    }
    
}
