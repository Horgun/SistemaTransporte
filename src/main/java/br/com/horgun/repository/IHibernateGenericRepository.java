/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.horgun.repository;

import java.util.List;
import org.hibernate.Transaction;

/**
 *
 * @author savio
 * @param <DbObject> Objeto do banco
 * @param <Pk> Primary key do objeto
 */
public interface IHibernateGenericRepository<DbObject, Pk> extends IGenericRepository<DbObject, Pk> {
    
    void openSession();
    void closeSession();
    Transaction beginTransaction() throws Exception;
    void commitTransaction() throws Exception;
    
    List<DbObject> list(String query);
}
