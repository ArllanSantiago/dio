package com.am.labpadroesprojetospring.domain.repository;

import com.am.labpadroesprojetospring.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
}
