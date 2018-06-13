/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.horgun.controller;

import br.com.horgun.session.SessionBean;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author savio
 */
@Named
@ViewScoped
public class LoginController implements Serializable {
    private String username;
    private String password;
    @Inject
    private SessionBean sb;
    
    @PostConstruct
    public void init(){
        username = "";
        password = "";
    }
    
    public String entrar(){
        boolean entrou = sb.login(username, password);
        
        if (!entrou){
            return "failure";
        }
        else{
            return "success";
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
