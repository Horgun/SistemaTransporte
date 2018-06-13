/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.horgun.controller;

import br.com.horgun.session.SessionBean;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author savio
 */
@Named
@ViewScoped
public class IndexController implements Serializable{
    
    @Inject
    SessionBean sessionBean;
    
    public IndexController() {
    }
    
    public String logout(){
        sessionBean.logout();
        return "sair";
    }
    
}
