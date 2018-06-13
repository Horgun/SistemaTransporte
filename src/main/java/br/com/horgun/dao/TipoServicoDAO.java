/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.horgun.dao;

import br.com.horgun.model.TipoServico;
import br.com.horgun.repository.ITipoServicoDAO;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author savio
 */
@RequestScoped
public class TipoServicoDAO extends HibernateGenericDAO<TipoServico, Long> implements ITipoServicoDAO{
    
    public TipoServicoDAO() {
        super(TipoServico.class, Long.class);
    }
    
}
