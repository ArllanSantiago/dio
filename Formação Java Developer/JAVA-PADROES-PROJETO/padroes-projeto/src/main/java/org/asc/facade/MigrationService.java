package org.asc.facade;

public class MigrationService {

    private MigrationService(){}

    private static MigrationService instance = new MigrationService();

    public static MigrationService getInstance(){
        return instance;
    }


    public static void save(ClientMigration clientMigration){
        System.out.println(String.format("[Migration]%s, Client saved",clientMigration.toString()));
    }
}
