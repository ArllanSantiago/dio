package com.am.labpadroesprojetospring.api.mapper;

import com.am.labpadroesprojetospring.api.dto.response.ClientResponse;
import com.am.labpadroesprojetospring.api.outside.viacep.ViaCepApi;
import com.am.labpadroesprojetospring.api.dto.request.ClientRequest;
import com.am.labpadroesprojetospring.domain.entity.Address;
import com.am.labpadroesprojetospring.domain.entity.Client;
import com.am.labpadroesprojetospring.domain.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.Optional;


@Controller
@RequiredArgsConstructor
public class ClientMapper  {
    private final ViaCepApi viaCepApi;
    private final AddressService addressService;

    public Client toClient(ClientRequest clientRequest){
        final Optional<Address> opAddress = addressService.byId(clientRequest.getZipCode());
        final Address address = opAddress.isPresent()? opAddress.get(): viaCepApi.consultarCep(clientRequest.getZipCode());
        address.setComplement(clientRequest.getComplement());

        return Client.builder()
          .name(clientRequest.getName())
          .address(address)
          .build();
    }

    public ClientResponse toClientResponse(Client client){
        Address address = Address.builder()
                .zipCode(client.getAddress().getZipCode())
                .ddd(client.getAddress().getDdd())
                .uf(client.getAddress().getUf())
                .complement(client.getAddress().getComplement())
                .city(client.getAddress().getCity())
                .district(client.getAddress().getDistrict())
                .build();


        Address address2 = client.getAddress();
        return ClientResponse.builder()
                .name(client.getName())
                .address(address)
                .build();
    }

}
