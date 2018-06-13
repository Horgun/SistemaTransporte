package br.com.horgun.app;


import br.com.horgun.model.Funcionario;
import br.com.horgun.model.GrupoPermissao;
import br.com.horgun.model.Permissao;
import br.com.horgun.model.Usuario;
import br.com.horgun.repository.IFuncionarioDAO;
import br.com.horgun.repository.IGrupoPermissaoDAO;
import br.com.horgun.repository.IPermissaoDAO;
import br.com.horgun.repository.IUsuarioDAO;
import br.com.horgun.util.PasswordEncryption;
import br.com.horgun.util.SaltGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.ejb.Singleton;
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
    
    @Inject private SessionFactory sessionFactory;
    @Inject private IUsuarioDAO usuarioDAO;
    @Inject private IFuncionarioDAO funcionarioDAO;
    @Inject private IPermissaoDAO permissaoDAO;
    @Inject private IGrupoPermissaoDAO grupoPermissaoDAO;

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
    
    private void criaAdmin(){
        logger.info("Criando admin...");
        
        Funcionario fAdmin = new Funcionario(null, "Administrador", "1", "", null, null);
        
        Usuario uAdmin = new Usuario();
        uAdmin.setUsername("admin");
        uAdmin.setSalt(SaltGenerator.getSalt());
        uAdmin.setPassword(PasswordEncryption.getEncrytedPassword("admin", "123456", uAdmin.getSalt()));
        uAdmin.setFuncionario(fAdmin);
        
        funcionarioDAO.save(fAdmin);
        usuarioDAO.save(uAdmin);
        
        logger.info("Admin criado.");
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
        
        permissaoDAO.openSession();
        permissaoDAO.beginTransaction();
        for (Permissao permissao : permissoes) {
            permissaoDAO.save(permissao);
        }
        permissaoDAO.commitTransaction();
        permissaoDAO.closeSession();
        
        grupoPermissaoDAO.save(gp1);
        
        logger.info("Permissões criadas.");
    }
    
}
