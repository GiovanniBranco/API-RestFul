package org.serratec.library.controller;

import java.util.List;

import org.serratec.library.exceptions.BookNotFound;
import org.serratec.library.model.BookModel;
import org.serratec.library.model.dto.BookDto;
import org.serratec.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookService service;
	
	@GetMapping
	public List<BookModel> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public BookModel getById(@PathVariable Long id) throws BookNotFound {
		return service.getById(id);
	}
	
	@PostMapping
	public BookModel create(@RequestBody BookModel book) {
		return service.create(book);
	}
	
	@PutMapping("/{id}")
	public BookDto update (@PathVariable Long id, @RequestBody BookModel book) throws BookNotFound {
		return service.update(id, book);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
}
