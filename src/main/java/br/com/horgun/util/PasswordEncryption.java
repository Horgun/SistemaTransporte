/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.horgun.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author savio
 */
public class PasswordEncryption {
    
    public static String getEncrytedPassword(String user, String password, byte[] salt){
        String encrypted = null;
        
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update((password + user).getBytes());
            md.update(salt);
            byte[] res = md.digest();
            encrypted = Base64.getEncoder().encodeToString(res);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(PasswordEncryption.class.getName()).log(Level.SEVERE, null, ex);
        }
        return encrypted;
    }
    
}
