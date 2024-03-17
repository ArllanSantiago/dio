package org.asc.facade;

import org.correios.SearchService;
import org.legado.ClientService;
public class Facade {

    public Facade(){
        this.correios = new SearchService();
        this.legado = new ClientService();
    }

    private final SearchService correios;
    private final ClientService legado;
    public ClientMigration getClientMigration(String name, String cep){
        var city = this.correios.getCityByCep(cep);
        var checkIn = this.legado.checkIn(name,cep,city);

        return new ClientMigration(name,cep,city,checkIn);
    };

}
