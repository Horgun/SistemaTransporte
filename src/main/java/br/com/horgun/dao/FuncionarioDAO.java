/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.horgun.dao;

import br.com.horgun.model.Funcionario;
import br.com.horgun.repository.IFuncionarioDAO;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author savio
 */
@RequestScoped
public class FuncionarioDAO extends HibernateGenericDAO<Funcionario, Long> implements IFuncionarioDAO{
    
    public FuncionarioDAO() {
        super(Funcionario.class, Long.class);
    }
    
}
