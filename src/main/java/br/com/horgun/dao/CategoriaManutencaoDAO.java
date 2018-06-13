/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.horgun.dao;

import br.com.horgun.model.CategoriaManutencao;
import br.com.horgun.repository.ICategoriaManutencaoDAO;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author savio
 */
@RequestScoped
public class CategoriaManutencaoDAO extends HibernateGenericDAO<CategoriaManutencao, Long> implements ICategoriaManutencaoDAO{
    
    public CategoriaManutencaoDAO() {
        super(CategoriaManutencao.class, Long.class);
    }
    
}
