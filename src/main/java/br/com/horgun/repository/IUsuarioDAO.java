/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.horgun.repository;

import br.com.horgun.model.Usuario;

/**
 *
 * @author savio
 */
public interface IUsuarioDAO extends IHibernateGenericRepository<Usuario, Long> {
    
    Usuario findByUsername(String username);
}
