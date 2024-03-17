package com.am.labpadroesprojetospring.domain.repository;

import com.am.labpadroesprojetospring.domain.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {
}
