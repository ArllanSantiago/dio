package org.asc.facade;

public class ClientMigration {

    private String name;
    private String cep;
    private String city;
    private boolean checkIn;


    public ClientMigration(){

    };

    public ClientMigration(String name, String cep, String city, boolean checkIn) {
        this.name = name;
        this.cep = cep;
        this.city = city;
        this.checkIn = checkIn;
    }

    @Override
    public String toString() {
        return "[ClientMigration] " +
                "name='" + name + '\'' +
                ", cep='" + cep + '\'' +
                ", city='" + city + '\'' +
                ", checkIn=" + checkIn ;
    }
}
