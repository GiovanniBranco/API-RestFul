package org.serratec.library.mapper;

import org.serratec.library.model.BookModel;
import org.serratec.library.model.dto.BookDto;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
	public BookModel toModel(BookDto dto) {
		BookModel book = new BookModel();
		
		book.setAuthor(dto.getAuthor());
		book.setTitle(dto.getTitle());
		book.setType(dto.getType());
		book.setDate(dto.getDate());
		
		return book;
	}

	public BookDto toDto(BookModel book) {
		BookDto dto = new BookDto();
		
		dto.setAuthor(book.getAuthor());
		dto.setTitle(book.getTitle());
		dto.setType(book.getType());
		dto.setDate(book.getDate());
		
		return dto;
	}
}
