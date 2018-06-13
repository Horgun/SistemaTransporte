/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.horgun.dao;

import br.com.horgun.repository.IHibernateGenericRepository;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author savio
 * @param <DbObject> Model Class
 * @param <Pk> Primary Key Class
 */
public class HibernateGenericDAO<DbObject, Pk> implements IHibernateGenericRepository<DbObject, Pk> {
    
    private final Class<DbObject> modelClass;
    private final Class<Pk> pkClass;
    @Inject
    private SessionFactory sessionFactory;
    protected Session currentSession;

    //<editor-fold desc="Session stuff">
    /**
     * Método para realizar operações em uma só sessão.
     * Deve Fechar a sessão chamando o método closeSession().
     */
    @Override
    public void openSession(){
        if (currentSession == null){
            currentSession = sessionFactory.openSession();
        }
    }
    
    @Override
    public void closeSession(){
        if (currentSession != null){
            currentSession.close();
            currentSession = null;
        }
    }
    
    protected boolean standaloneSession(){
        if (currentSession == null){
            openSession();
            return true;
        }
        return false;
    }
    
    @Override
    public Transaction beginTransaction(){
        if (currentSession != null){
            return currentSession.beginTransaction();
        }
        throw new RuntimeException("No open session!");
    }
    
    @Override
    public void commitTransaction(){
        if (currentSession != null){
            currentSession.getTransaction().commit();
        }
        else
            throw new RuntimeException("No open transaction!");
    }
    //</editor-fold>
    
    public HibernateGenericDAO(Class<DbObject> modelClass, Class<Pk> pkClass){
        this.modelClass = modelClass;
        this.pkClass = pkClass;
    }
    
    @Override
    public void save(DbObject o) {
        boolean shouldCloseSession = standaloneSession();
        boolean shouldCommit = !currentSession.getTransaction().isActive();
        
        if (shouldCommit) currentSession.beginTransaction();
        currentSession.save(o);
        if (shouldCommit) currentSession.getTransaction().commit();
        
        if (shouldCloseSession) closeSession();
    }

    @Override
    public void update(DbObject o) {
        boolean shouldCloseSession = standaloneSession();
        boolean shouldCommit = !currentSession.getTransaction().isActive();
        
        if (shouldCommit) currentSession.beginTransaction();
        currentSession.update(o);
        if (shouldCommit) currentSession.getTransaction().commit();
        
        if (shouldCloseSession) closeSession();
    }

    @Override
    public void delete(DbObject o) {
        boolean shouldCloseSession = standaloneSession();
        boolean shouldCommit = !currentSession.getTransaction().isActive();
        
        if (shouldCommit) currentSession.beginTransaction();
        currentSession.delete(o);
        if (shouldCommit) currentSession.getTransaction().commit();
        
        if (shouldCloseSession) closeSession();
    }

    @Override
    public DbObject find(Pk pk) {
        boolean shouldCloseSession = standaloneSession();
        boolean shouldCommit = !currentSession.getTransaction().isActive();
        
        if (shouldCommit) currentSession.beginTransaction();
        DbObject o = currentSession.find(modelClass, pk);
        if (shouldCommit) currentSession.getTransaction().commit();
        
        if (shouldCloseSession) closeSession();
        
        return o;
    }

    @Override
    public void deleteById(Pk pk) {
        boolean shouldCloseSession = standaloneSession();
        boolean shouldCommit = !currentSession.getTransaction().isActive();
        
        if (shouldCommit) currentSession.beginTransaction();
        currentSession.delete(currentSession.find(modelClass, pk));
        if (shouldCommit) currentSession.getTransaction().commit();
        
        if (shouldCloseSession) closeSession();
    }

    @Override
    public List<DbObject> list() {
        boolean shouldCloseSession = standaloneSession();
        boolean shouldCommit = !currentSession.getTransaction().isActive();
        
        if (shouldCommit) currentSession.beginTransaction();
        CriteriaBuilder cb = currentSession.getCriteriaBuilder();
        CriteriaQuery<DbObject> criteria = cb.createQuery(modelClass);
        criteria.from(modelClass);
        List<DbObject> list = currentSession.createQuery(criteria).getResultList();
        if (shouldCommit) currentSession.getTransaction().commit();
        
        if (shouldCloseSession) closeSession();
        
        return list;
    }

    @Override
    public List<DbObject> list(String query) {
        boolean shouldCloseSession = standaloneSession();
        boolean shouldCommit = !currentSession.getTransaction().isActive();
        
        if (shouldCommit) currentSession.beginTransaction();
        List<DbObject> list = currentSession.createQuery(query, modelClass).getResultList();
        if (shouldCommit) currentSession.getTransaction().commit();
        
        if (shouldCloseSession) closeSession();
        
        return list;
    }
}
