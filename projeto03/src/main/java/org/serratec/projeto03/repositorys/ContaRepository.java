package org.serratec.projeto03.repositorys;

import java.util.List;

import org.serratec.projeto03.models.ContaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<ContaEntity, Integer>{
	
	List<ContaEntity> findByTitularOrderById(String titular);
}
