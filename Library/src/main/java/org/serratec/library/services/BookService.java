package org.serratec.library.services;

import java.util.List;
import java.util.Optional;

import org.serratec.library.exceptions.BookNotFound;
import org.serratec.library.mapper.BookMapper;
import org.serratec.library.model.BookModel;
import org.serratec.library.model.dto.BookDto;
import org.serratec.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	@Autowired
	BookRepository repository;
	
	@Autowired
	BookMapper mapper;
	
	public List<BookModel> getAll() {
		return repository.findAll();
	}
	
	public BookModel getById(Long id) throws BookNotFound {
		Optional<BookModel> book = repository.findById(id);
		
		if(book.isEmpty()) {
			throw new BookNotFound("Livro não encontrado!");
		}
		
		return book.get();
	}
	
	public BookModel create(BookModel book) {
		return repository.save(book);
	}
	
	public BookDto update(Long id, BookModel obj) throws BookNotFound {
		BookModel book = this.getById(id);
		
				
		if(obj.getAuthor() != null) {
			book.setAuthor(obj.getAuthor());	
		}
		if(obj.getTitle() != null) {
			book.setTitle(obj.getTitle());
		}
		if(obj.getType() != null) {
			book.setType(obj.getType());
		}
		if(obj.getDate() != null) {
			book.setDate(obj.getDate());
		}
		
		return mapper.toDto(repository.save(book));
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
