/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.horgun.dao;

import br.com.horgun.model.Empresa;
import br.com.horgun.repository.IEmpresaDAO;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author savio
 */
@RequestScoped
public class EmpresaDAO extends HibernateGenericDAO<Empresa, Long> implements IEmpresaDAO{
    
    public EmpresaDAO() {
        super(Empresa.class, Long.class);
    }
    
}
