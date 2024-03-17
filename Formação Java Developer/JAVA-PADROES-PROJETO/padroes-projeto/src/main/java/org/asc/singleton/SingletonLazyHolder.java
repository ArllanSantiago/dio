package org.asc.singleton;

/**
 * Singleton "titular preguiçoso" :Utiliza uma classe interna para Instancia;
 * @see <a href = "stackoverflow.com/a/24018148">Referencia</a>
 * @author arllan
 *
 */
public class SingletonLazyHolder {

    private static class InstanceHolder{
        public static SingletonLazyHolder instancia = new SingletonLazyHolder();
    }


    private SingletonLazyHolder(){

    }

    public static SingletonLazyHolder getInstance(){
        return InstanceHolder.instancia ;
    }
}
