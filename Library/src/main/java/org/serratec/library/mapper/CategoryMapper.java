package org.serratec.library.mapper;

import org.serratec.library.model.CategoryModel;
import org.serratec.library.model.dto.CategoryDto;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
	
	public CategoryModel toModel(CategoryDto dto) {
		CategoryModel category = new CategoryModel();
		category.setName(dto.getName());
		category.setDescription(dto.getDescription());

		return category;
	}

	public CategoryDto toDto(CategoryModel category) {
		CategoryDto dto = new CategoryDto();
		
		dto.setName(category.getName());
		dto.setDescription(category.getDescription());
		
		return dto;
	}
}
