package org.serratec.library.controller;

import java.util.List;

import org.serratec.library.exceptions.EntityNotFound;
import org.serratec.library.model.CategoryModel;
import org.serratec.library.model.dto.CategoryDto;
import org.serratec.library.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryService service;
	
	@GetMapping
	public ResponseEntity<List<CategoryDto>> getAll(){
		return new ResponseEntity<List<CategoryDto>>(service.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoryModel> getById(@PathVariable Long id) throws EntityNotFound {
		return new ResponseEntity<CategoryModel>(service.getById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<CategoryDto> create(@RequestBody CategoryDto category) {
		return new ResponseEntity<CategoryDto>(service.create(category), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CategoryDto> update(@PathVariable Long id, @RequestBody CategoryDto category) throws EntityNotFound {
		return new ResponseEntity<CategoryDto>(service.update(id, category), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		service.delete(id);
		return new ResponseEntity<String>("Categoria com " +id +" deletada com sucesso!", HttpStatus.OK);
	}
}
