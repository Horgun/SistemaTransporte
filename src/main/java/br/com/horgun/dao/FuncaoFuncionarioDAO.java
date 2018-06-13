/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.horgun.dao;

import br.com.horgun.model.FuncaoFuncionario;
import br.com.horgun.repository.IFuncaoFuncionarioDAO;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author savio
 */
@RequestScoped
public class FuncaoFuncionarioDAO extends HibernateGenericDAO<FuncaoFuncionario, Long> implements IFuncaoFuncionarioDAO{
    
    public FuncaoFuncionarioDAO() {
        super(FuncaoFuncionario.class, Long.class);
    }
    
}
