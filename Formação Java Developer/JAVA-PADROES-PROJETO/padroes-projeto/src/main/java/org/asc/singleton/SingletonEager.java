package org.asc.singleton;

/**
 * Singleton "Apressado" : Instancia no momento da criação da classe
 * @author arllan

 */
public class SingletonEager {

    private static SingletonEager instancia = new SingletonEager();

    private SingletonEager(){

    }

    public static SingletonEager getInstance(){
        return instancia;
    }
}
