package org.serratec.library.repository;

import org.serratec.library.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookModel, Long>{
	
}
