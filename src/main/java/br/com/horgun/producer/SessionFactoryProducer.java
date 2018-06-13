/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.horgun.producer;

import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.jboss.logging.Logger;

/**
 *
 * @author savio
 */

@ApplicationScoped
public class SessionFactoryProducer implements Serializable {
    
    private static Logger logger = Logger.getLogger(SessionFactoryProducer.class);
    
    @Produces @ApplicationScoped
    public static SessionFactory getSessionFactory(){
        // A SessionFactory is set up once for an application!
	StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
        SessionFactory sessionFactory = null;
	try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
            logger.info("SessionFactory criada.");
        }catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy( registry );
            logger.error("Problema ao criar SessionFactory.");
            throw new RuntimeException(e);
//            throw new ExceptionInInitializerError("Erro no SessionFactory.\n" + e.getMessage());
	}
        return sessionFactory;
    }
    
    public void closeSessionFactory(@Disposes SessionFactory sf){
        sf.close();
    }
}
