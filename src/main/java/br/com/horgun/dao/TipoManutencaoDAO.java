/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.horgun.dao;

import br.com.horgun.model.TipoManutencao;
import br.com.horgun.repository.ITipoManutencaoDAO;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author savio
 */
@RequestScoped
public class TipoManutencaoDAO extends HibernateGenericDAO<TipoManutencao, Long> implements ITipoManutencaoDAO{
    
    public TipoManutencaoDAO() {
        super(TipoManutencao.class, Long.class);
    }
    
}
