package org.serratec.library.controller;

import java.util.List;

import org.serratec.library.exceptions.EntityNotFound;
import org.serratec.library.model.AuthorModel;
import org.serratec.library.model.dto.AuthorDto;
import org.serratec.library.services.AuthorService;
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
@RequestMapping("/author")
public class AuthorController {
	
	@Autowired
	AuthorService service;

	
	@GetMapping
	public ResponseEntity<List<AuthorDto>> getAll(){
		return new ResponseEntity<List<AuthorDto>>(service.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AuthorModel> getById(@PathVariable Long id) throws EntityNotFound {
		return new ResponseEntity<AuthorModel>(service.getById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> create(@RequestBody AuthorDto author) {
		return new ResponseEntity<String>(service.create(author), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AuthorDto> update(@PathVariable Long id, @RequestBody AuthorDto author) throws EntityNotFound {
		return new ResponseEntity<AuthorDto>(service.update(id, author), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		service.delete(id);
		return new ResponseEntity<String>("Autor/Autora com  " +id +" deletado/deletada com sucesso!", HttpStatus.OK);
	}
}
