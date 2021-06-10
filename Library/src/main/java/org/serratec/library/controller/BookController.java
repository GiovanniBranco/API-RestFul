package org.serratec.library.controller;

import java.util.List;

import org.serratec.library.exceptions.EntityNotFound;
import org.serratec.library.model.BookModel;
import org.serratec.library.model.dto.BookDto;
import org.serratec.library.services.BookService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

//	@Autowired
//	CategoryService categoryService;
//	
//	@Autowired
//	AuthorService authorService;
	
	@Autowired
	BookService service;
	
	@GetMapping
	public ResponseEntity<List<BookDto>> getAll(@RequestParam(required = false, defaultValue = "id") String order){
		return new ResponseEntity<List<BookDto>>(service.getAll(order), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BookModel> getById(@PathVariable Long id) throws EntityNotFound {
		return new ResponseEntity<BookModel>(service.getById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<BookDto> create(@RequestBody BookDto book) throws EntityNotFound {
//		CategoryModel category =  categoryService.getById(book.getCategory().getId());
//		AuthorModel author =  authorService.getById(book.getAuthor().getId());
//		
//		
//		category.getName();
//		category.getDescription();
//		author.getName();
		return new ResponseEntity<BookDto>(service.create(book), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<BookDto> update (@PathVariable Long id, @RequestBody BookDto book) throws EntityNotFound {
		return new ResponseEntity<BookDto>(service.update(id, book), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		service.delete(id);
		return new ResponseEntity<String>("Deletado com sucesso", HttpStatus.OK);
	}
	
}
