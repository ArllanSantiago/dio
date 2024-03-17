package com.am.labpadroesprojetospring.api.outside.viacep;

import com.am.labpadroesprojetospring.domain.entity.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ViaCepService {
    private final ViaCepApi viaCepApi;


    public Address searchAddress(String zipCode){
        final Address address = viaCepApi.consultarCep(zipCode);
        return address;
    }

    public void addressValid(String zipCode){
        var address = this.searchAddress(zipCode);
        if (address == null)
            throw new IllegalArgumentException("Address not exists");
    }
}
