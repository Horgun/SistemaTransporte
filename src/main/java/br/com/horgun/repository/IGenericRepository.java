/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.horgun.repository;

import java.util.List;

/**
 *
 * @author savio
 * @param <DbObject> Objeto do banco
 * @param <Pk> Primary Key do objeto
 */
public interface IGenericRepository <DbObject, Pk> {
    
    void save(DbObject o);
    void update(DbObject o);
    void delete(DbObject o);
    DbObject find(Pk pk);
    List<DbObject> list();
    void deleteById(Pk pk);
}
