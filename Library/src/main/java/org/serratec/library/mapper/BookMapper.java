package org.serratec.library.mapper;

import org.serratec.library.model.BookModel;
import org.serratec.library.model.dto.BookDto;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
	public BookModel toModel(BookDto dto) {
		BookModel book = new BookModel();
		
		book.setTitle(dto.getTitle());
		book.setCategory(dto.getCategory());
		book.setDate(dto.getDate());
		
		return book;
	}

	public BookDto toDto(BookModel book) {
		BookDto dto = new BookDto();
		
		dto.setTitle(book.getTitle());
		dto.setDate(book.getDate());
		dto.setCategory(book.getCategory());
		
		return dto;
	}
}
