/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.horgun.controller.Usuario;

import br.com.horgun.model.Funcionario;
import br.com.horgun.model.GrupoPermissao;
import br.com.horgun.model.Permissao;
import br.com.horgun.model.Usuario;
import br.com.horgun.repository.IHibernateGenericRepository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.jboss.logging.Logger;

/**
 *
 * @author savio
 */
@Named
@ViewScoped
public class CadastroUsuarioController implements Serializable {

    private static Logger logger = Logger.getLogger(CadastroUsuarioController.class);

    private Usuario usuario;
    private String nomeFuncionario;
    private List<Funcionario> funcionariosEncontrados;
    private List<Permissao> permissoes;
    private List<GrupoPermissao> gruposDePermissoes;
    private Set<Permissao> permissoesSelecionadas;
    private List<GrupoPermissao> gruposSelecionados;
    private String selectedPermissionsString;

    @PostConstruct
    public void init() {
        logger.info("Criado novo bean");
        usuario = new Usuario();
        funcionariosEncontrados = new ArrayList<>();
        gruposSelecionados = new ArrayList<>();
        permissoesSelecionadas = new HashSet<>();
        carregarGruposDePermissoes();
        carregarTodasAsPermissoes();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public List<Funcionario> getFuncionariosEncontrados() {
        return funcionariosEncontrados;
    }

    public void setFuncionariosEncontrados(List<Funcionario> funcionariosEncontrados) {
        this.funcionariosEncontrados = funcionariosEncontrados;
    }

    public void mostrarFuncionarios() {
        //buscar no banco
        FullTextSession fts = Search.getFullTextSession(sessionFactory.getCurrentSession());
        sessionFactory.getCurrentSession().beginTransaction();
        QueryBuilder qb = fts.getSearchFactory().buildQueryBuilder().forEntity(Funcionario.class).get();
        org.apache.lucene.search.Query q = qb.keyword().fuzzy().onField("nome").matching(nomeFuncionario).createQuery();
        Query<Funcionario> hq = fts.createFullTextQuery(q, Funcionario.class);
        hq.setMaxResults(10);
        hq.setFirstResult(0);
        funcionariosEncontrados = new ArrayList<>(hq.list());
        sessionFactory.getCurrentSession().getTransaction().commit();
    }

    public void limparFuncionarios() {
        funcionariosEncontrados.clear();
        usuario.setFuncionario(null);
        logger.info("limpou funcionarios");
    }

    public void selecionarFuncionario(Funcionario f) {
        usuario.setFuncionario(f);
        nomeFuncionario = f.getNome();

    }

    public List<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(List<Permissao> permissoes) {
        this.permissoes = permissoes;
    }

    private void carregarTodasAsPermissoes() {
        Query<Permissao> q = sessionFactory.getCurrentSession().createQuery("from Permissao p");
        permissoes = q.list();
    }

    private void carregarGruposDePermissoes() {
        //sessionFactory.getCurrentSession().beginTransaction();
        Query<GrupoPermissao> q = sessionFactory.getCurrentSession().createQuery("from GrupoPermissao gp");
        gruposDePermissoes = q.list();
        //sessionFactory.getCurrentSession().getTransaction().commit();
    }

    public void selecionarTodosOsGrupos(boolean selecionar) {
        if (selecionar) {
            gruposSelecionados.addAll(gruposDePermissoes);
            for (GrupoPermissao gp : gruposDePermissoes) {
                for (Permissao p : gp.getPermissoes()) {
                    permissoesSelecionadas.add(p);
                }
            }
        } else {
            gruposSelecionados.clear();
            for (GrupoPermissao gp : gruposDePermissoes) {
                for (Permissao p : gp.getPermissoes()) {
                    permissoesSelecionadas.remove(p);
                }
            }
        }
    }

    public void selecionarGrupo(GrupoPermissao gp, boolean selecionar) {
        if (selecionar) {
            gruposSelecionados.add(gp);
            for (Permissao p : gp.getPermissoes()) {
                permissoesSelecionadas.add(p);
            }
        } else {
            gruposSelecionados.remove(gp);
            for (Permissao p : gp.getPermissoes()) {
                permissoesSelecionadas.remove(p);
            }
        }
    }

    public void selecionarTodasAsPermissoes(boolean selecionar) {
        if (selecionar) {
            permissoesSelecionadas.addAll(permissoes);
        } else {
            permissoesSelecionadas.clear();
        }
    }

    public void selecionarPermissao(Permissao p, boolean selecionar) {
        if (selecionar) {
            permissoesSelecionadas.add(p);
        } else {
            permissoesSelecionadas.remove(p);
        }
    }

    public void getSelectedPermissions() {
        String positions = "[";
        for (int i = 0; i < permissoes.size(); i++) {
            if (permissoesSelecionadas.contains(permissoes.get(i))) {
                positions += "{\"pos\": " + 1 + "}, ";
            }
            else{
                positions += "{\"pos\": " + 0 + "}, ";
            }
        }
        if (positions.length() > 2) {
            positions = positions.substring(0, positions.length() - 2);
        }
        positions += "]";
        selectedPermissionsString = positions;
        System.out.println("debug: " + selectedPermissionsString);
    }

    public List<GrupoPermissao> getGruposDePermissoes() {
        return gruposDePermissoes;
    }

    public void setGruposDePermissoes(List<GrupoPermissao> gruposDePermissoes) {
        this.gruposDePermissoes = gruposDePermissoes;
    }

    public Set<Permissao> getPermissoesSelecionadas() {
        return permissoesSelecionadas;
    }

    public void setPermissoesSelecionadas(Set<Permissao> permissoesSelecionadas) {
        this.permissoesSelecionadas = permissoesSelecionadas;
    }

    public List<GrupoPermissao> getGruposSelecionados() {
        return gruposSelecionados;
    }

    public void setGruposSelecionados(List<GrupoPermissao> gruposSelecionados) {
        this.gruposSelecionados = gruposSelecionados;
    }

    public void setSelectedPermissionsString(String selectedPermissionsString) {
        this.selectedPermissionsString = selectedPermissionsString;
    }

    public String getSelectedPermissionsString() {
        return selectedPermissionsString;
    }

}
