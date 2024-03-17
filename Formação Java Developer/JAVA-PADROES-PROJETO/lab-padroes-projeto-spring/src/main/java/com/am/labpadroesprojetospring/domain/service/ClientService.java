package com.am.labpadroesprojetospring.domain.service;

import com.am.labpadroesprojetospring.domain.entity.Address;
import com.am.labpadroesprojetospring.domain.entity.Client;
import com.am.labpadroesprojetospring.domain.repository.AddressRepository;
import com.am.labpadroesprojetospring.domain.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
@RequiredArgsConstructor
public class ClientService implements BasicCrudService<Client,Long> {
    private final ClientRepository clientRepository;
    private final AddressService addressService;
    private final AddressRepository addressRepository;
    @Override
    public Set<Client> all() {
        return new LinkedHashSet<Client>(clientRepository.findAll());
    }

    @Override
    public Optional<Client> byId(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public Client save(Client obj) throws IllegalArgumentException {
        final Optional<Client> opClientCurrent = clientRepository.findById(obj.getId());
        if(opClientCurrent.isPresent())
            throw new IllegalArgumentException("Client already registered");

        addressHandler(obj);

        return clientRepository.save(obj);
    }
    protected  void addressHandler(Client obj){
        final Optional<Address> opAddress = addressRepository.findById(obj.getAddress().getZipCode());
        if (opAddress.isEmpty()){
            final Address address = addressRepository.save(obj.getAddress());
            obj.setAddress(address);
        }
    }
    @Override
    public Client update(Client obj, Long id) throws IllegalArgumentException {
        final Client clientCurrent = clientRepository.findById(id).orElseThrow(()-> new IllegalArgumentException(String.format("Client with id %s, not found!",id)));
        obj.updateId(clientCurrent.getId());

        addressHandler(obj);

        return clientRepository.save(obj);
    }

    @Override
    public void deleteAll(Set<Client> clients) {
        clientRepository.deleteAll();
    }

    @Override
    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }
}
