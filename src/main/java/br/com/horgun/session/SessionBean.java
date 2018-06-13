/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.horgun.session;

import br.com.horgun.model.Usuario;
import br.com.horgun.repository.IUsuarioDAO;
import br.com.horgun.util.PasswordEncryption;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author savio
 */
@Named(value = "sessionBean")
@SessionScoped
public class SessionBean implements Serializable {
    
    @Inject
    private IUsuarioDAO usuarioDAO;
    private boolean loggedIn;
    private Usuario usuario;

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    /**
     * Creates a new instance of SessionBean
     */
    public SessionBean() {
        this.usuario = null;
        this.loggedIn = false;
    }
    
    public boolean login(String username, String password){
        Usuario usuarioLogin = usuarioDAO.findByUsername(username);
        if (usuarioLogin != null){
            String loginPass = PasswordEncryption.getEncrytedPassword(
                    usuarioLogin.getUsername()
                    , password
                    , usuarioLogin.getSalt());
            if (loginPass.equals(usuarioLogin.getPassword())){
                this.usuario = usuarioLogin;
                this.loggedIn = true;
                return true;
            }
        }
        this.usuario = null;
        this.loggedIn = false;
        return false;
        
    }
    
    public void logout(){
        this.usuario = null;
        this.loggedIn = false;
    }
    
}
