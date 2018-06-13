/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.horgun.dao;

import br.com.horgun.model.GrupoPermissao;
import br.com.horgun.repository.IGrupoPermissaoDAO;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author savio
 */
@RequestScoped
public class GrupoPermissaoDAO extends HibernateGenericDAO<GrupoPermissao, Long> implements IGrupoPermissaoDAO{
    
    public GrupoPermissaoDAO() {
        super(GrupoPermissao.class, Long.class);
    }
    
}
