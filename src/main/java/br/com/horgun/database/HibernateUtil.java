/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.horgun.database;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.jboss.logging.Logger;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author savio
 */
public class HibernateUtil {
    private static final Logger logger = Logger.getLogger(HibernateUtil.class);
    private static final SessionFactory sessionFactory;
    
    static {
        // A SessionFactory is set up once for an application!
	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
	try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
            logger.info("SessionFactory criada.");
        }catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy( registry );
            logger.error("Problema ao criar SessionFactory.");
            throw new ExceptionInInitializerError("Erro no SessionFactory.\n" + e.getMessage());
	}
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
