/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.horgun.dao;

import br.com.horgun.model.Usuario;
import br.com.horgun.repository.IUsuarioDAO;
import javax.enterprise.context.RequestScoped;
import org.hibernate.Transaction;

/**
 *
 * @author savio
 */
@RequestScoped
public class UsuarioDAO extends HibernateGenericDAO<Usuario, Long> implements IUsuarioDAO{
    
    public UsuarioDAO() {
        super(Usuario.class, Long.class);
    }

    @Override
    public Usuario findByUsername(String username) {
        boolean shouldCloseSession = standaloneSession();
        
        Transaction t = currentSession.beginTransaction();
        Usuario u = currentSession.createQuery(
                String.format("from Usuario u where u.username = ?", username
                        .toLowerCase()), Usuario.class)
                .uniqueResult();
        
        if (shouldCloseSession) closeSession();
        
        return u;
    }
    
}
