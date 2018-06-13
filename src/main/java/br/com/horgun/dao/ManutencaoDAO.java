/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.horgun.dao;

import br.com.horgun.model.Manutencao;
import br.com.horgun.repository.IManutencaoDAO;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author savio
 */
@RequestScoped
public class ManutencaoDAO extends HibernateGenericDAO<Manutencao, Long> implements IManutencaoDAO{
    
    public ManutencaoDAO() {
        super(Manutencao.class, Long.class);
    }
    
}
