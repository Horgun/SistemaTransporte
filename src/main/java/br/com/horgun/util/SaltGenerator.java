/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.horgun.util;

import java.security.SecureRandom;
import java.util.Random;

/**
 *
 * @author savio
 */
public class SaltGenerator {
    private static final Random RANDOM = new SecureRandom();

    /**
     *Tamanho padrao do SALT utilizado no sistema.
     */
    public static final int DEFAULT_SALT_SIZE = 16;
    
    public static byte[] getSalt(){
        byte[] salt = new byte[DEFAULT_SALT_SIZE];
        RANDOM.nextBytes(salt);
        return salt;
    }
    
    public static byte[] getSalt(int size){
        byte[] salt = new byte[size];
        RANDOM.nextBytes(salt);
        return salt;
    }
}
