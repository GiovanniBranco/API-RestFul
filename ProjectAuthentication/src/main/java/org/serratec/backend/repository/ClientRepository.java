package org.serratec.backend.repository;

import org.serratec.backend.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, Long>{

}
