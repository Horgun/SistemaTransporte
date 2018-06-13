package br.com.horgun.app;


import br.com.horgun.model.Funcionario;
import br.com.horgun.model.GrupoPermissao;
import br.com.horgun.model.Permissao;
import br.com.horgun.model.Usuario;
import br.com.horgun.util.PasswordEncryption;
import br.com.horgun.util.SaltGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.jboss.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author savio
 */
@Singleton
@Startup
public class ApplicationStart {
    private static Logger logger = Logger.getLogger(ApplicationStart.class);
    
    @Inject
    SessionFactory sessionFactory;

    @PostConstruct
    public void start(){
        //inicializa o session factory.
        logger.info("Iniciando aplicação");
        
        criaAdmin();
        criaPermissoes();
        
        rebuildHibernateSearchIndexes();
    }
    
    private void rebuildHibernateSearchIndexes(){
        FullTextSession fullTextSession = Search.getFullTextSession(sessionFactory.getCurrentSession());
        try {
            fullTextSession.createIndexer().startAndWait();
        } catch (InterruptedException ex) {
            java.util.logging.Logger.getLogger(ApplicationStart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void criaPermissoes(){
        logger.info("Criando grupos de permissões...");
        List<GrupoPermissao> gruposDePermissoes = new ArrayList<>();
        GrupoPermissao gp1 = new GrupoPermissao(null, "Administrador");
        gruposDePermissoes.add(gp1);
        
        logger.info("Criando permissões...");
        List<Permissao> permissoes = new ArrayList<>();
        
        Permissao p1 = new Permissao(null, "Cadastro de Usuários");
        permissoes.add(p1);
        Permissao p2 = new Permissao(null, "Cadastro de Funcionários");
        permissoes.add(p2);
        
        //atribuir permissoes
        gp1.setPermissoes(permissoes);
        
        Session s = sessionFactory.getCurrentSession();
        s.beginTransaction();
        
        for (Permissao permissao : permissoes) {
            s.save(permissao);
        }
        
        s.save(gp1);
        
        s.getTransaction().commit();
        
        logger.info("Permissões criadas.");
    }
    
    private void criaAdmin(){
        logger.info("Criando admin...");
        Session s = sessionFactory.getCurrentSession();
        
        Funcionario fAdmin = new Funcionario(null, "Administrador", "1", "", null, null);
        
        Usuario uAdmin = new Usuario();
        uAdmin.setUsername("admin");
        uAdmin.setSalt(SaltGenerator.getSalt());
        uAdmin.setPassword(PasswordEncryption.getEncrytedPassword("admin", "123456", uAdmin.getSalt()));
        uAdmin.setFuncionario(fAdmin);
        
        s.beginTransaction();
        s.save(fAdmin);
        s.save(uAdmin);
        
        s.getTransaction().commit();
        logger.info("Admin criado.");
    }
}
