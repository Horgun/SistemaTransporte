/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.horgun.dao;

import br.com.horgun.model.PrestadoraDeServico;
import br.com.horgun.repository.IPrestadoraDeServicoDAO;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author savio
 */
@RequestScoped
public class PrestadoraDeServicoDAO extends HibernateGenericDAO<PrestadoraDeServico, Long> implements IPrestadoraDeServicoDAO{
    
    public PrestadoraDeServicoDAO() {
        super(PrestadoraDeServico.class, Long.class);
    }
    
}
