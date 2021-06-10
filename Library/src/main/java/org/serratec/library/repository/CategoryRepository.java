package org.serratec.library.repository;

import org.serratec.library.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryModel, Long>{

}
