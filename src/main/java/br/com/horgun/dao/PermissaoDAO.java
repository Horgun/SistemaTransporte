/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.horgun.dao;

import br.com.horgun.model.Permissao;
import br.com.horgun.repository.IPermissaoDAO;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author savio
 */
@RequestScoped
public class PermissaoDAO extends HibernateGenericDAO<Permissao, Long> implements IPermissaoDAO{
    
    public PermissaoDAO() {
        super(Permissao.class, Long.class);
    }
    
}
