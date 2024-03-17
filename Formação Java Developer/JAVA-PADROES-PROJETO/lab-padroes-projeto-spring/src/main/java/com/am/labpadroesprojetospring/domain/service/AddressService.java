package com.am.labpadroesprojetospring.domain.service;

import com.am.labpadroesprojetospring.api.outside.viacep.ViaCepService;
import com.am.labpadroesprojetospring.domain.entity.Address;
import com.am.labpadroesprojetospring.domain.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
@RequiredArgsConstructor
public class AddressService implements BasicCrudService<Address,String>   {
    private final AddressRepository addressRepository ;
    private final ViaCepService viaCepService;
    @Override
    public Set<Address> all() {
        return new LinkedHashSet<Address>(addressRepository.findAll()) ;
    }

    @Override
    public Optional<Address> byId(String zipCode) {
        return addressRepository.findById(zipCode);
    }

    @Override
    public Address save(Address obj) throws IllegalArgumentException {
         if (this.byId(obj.getZipCode()).isEmpty()) {
            viaCepService.addressValid(obj.getZipCode());
             addressRepository.save(obj);
        };
        return obj;
    }

    @Override
    public Address update(Address obj, String zipCode) throws IllegalArgumentException {
        final Optional<Address> address = this.byId(zipCode);

        if (address.isEmpty())
            throw new IllegalArgumentException("Address not found");
        return this.save(obj);
    }

    @Override
    public void deleteAll(Set<Address> setObj) {
        addressRepository.deleteAll();
    }

    @Override
    public void deleteById(String zipCode) {
        addressRepository.deleteById(zipCode);
    }

}
