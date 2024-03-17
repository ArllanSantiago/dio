package org.correios;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SearchService {
    public SearchService() {
    }

    private final Map<String, String> db = new HashMap<String, String>(){{
        put("50710390","Recife");
        put("53401441","Paulista");
        put("53510470","Abreu e Lima");
    }};

    public String getCityByCep(String cep){
        System.out.println("[correios][city] " + db.get(cep));
        return db.get(cep);
    }
}
