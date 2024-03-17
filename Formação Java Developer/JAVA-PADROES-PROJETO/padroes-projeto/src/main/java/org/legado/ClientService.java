package org.legado;

public class ClientService {
    public ClientService() {
    }

    public static boolean checkIn(String name, String cep, String city ){
        System.out.println(String.format("[legado][checkIn] %s acabou de visitar a cidade %s - %s",name,cep,city));
        return true;
    }
}
