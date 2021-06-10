package org.serratec.library.repository;

import org.serratec.library.model.AuthorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRespository extends JpaRepository<AuthorModel, Long>{

}
