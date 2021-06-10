package org.serratec.library.services;

import java.util.List;
import java.util.stream.Collectors;

import org.serratec.library.exceptions.EntityNotFound;
import org.serratec.library.mapper.BookMapper;
import org.serratec.library.model.BookModel;
import org.serratec.library.model.dto.BookDto;
import org.serratec.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	
	
	@Autowired
	BookRepository repository;
	
	@Autowired
	BookMapper mapper;
	
	public List<BookDto> getAll(String order) {
		return repository.findAll(Sort.by(order)).stream().map(mapper::toDto).collect(Collectors.toList()); 
	}
	
	public BookModel getById(Long id) throws EntityNotFound {
		return repository.findById(id).orElseThrow(() -> new EntityNotFound(id + " não encontrado."));
	}
	
	public BookDto create(BookDto book) throws EntityNotFound {
		repository.save(mapper.toModel(book));

		return book;
	}
	
	public BookDto update(Long id, BookDto dto) throws EntityNotFound {
		BookModel book = this.getById(id);
		
				
		if(dto.getTitle() != null) {
			book.setTitle(dto.getTitle());
		}
		if(dto.getCategory() != null) {
			book.setCategory(dto.getCategory());
		}
		if(dto.getDate() != null) {
			book.setDate(dto.getDate());
		}
		
		return mapper.toDto(repository.save(book));
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
