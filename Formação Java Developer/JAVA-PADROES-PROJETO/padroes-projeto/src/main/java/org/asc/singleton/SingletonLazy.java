package org.asc.singleton;

/**
 * Singleton "Preguiçoso" : Instancia no momento do get
 * @author arllan

 */
public class SingletonLazy {

    private static  SingletonLazy instancia;

    private SingletonLazy(){
        super();
    }

    public static SingletonLazy  getInstance(){
        instancia =  instancia == null? new SingletonLazy(): instancia;
        return instancia;
    }
}
