package org.serratec.library.services;

import java.util.List;
import java.util.stream.Collectors;

import org.serratec.library.exceptions.EntityNotFound;
import org.serratec.library.mapper.CategoryMapper;
import org.serratec.library.model.CategoryModel;
import org.serratec.library.model.dto.CategoryDto;
import org.serratec.library.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository repository;
	
	@Autowired
	CategoryMapper mapper;
	
	
	public List<CategoryDto> getAll() {
		return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList()); 
	}
	
	public CategoryModel getById(Long id) throws EntityNotFound {
		return repository.findById(id).orElseThrow(() -> new EntityNotFound(id + " não encontrado."));
	}
	
	public CategoryDto create(CategoryDto category) {
		repository.save(mapper.toModel(category));
		return category;
	}
	
	public CategoryDto update(Long id, CategoryDto dto) throws EntityNotFound {
		CategoryModel category = this.getById(id);
		
				
		if(dto.getName() != null) {
			category.setName(dto.getName());	
		}
		if(dto.getDescription() != null) {
			category.setDescription(dto.getDescription());
		}
	
		return mapper.toDto(repository.save(category));
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
}
