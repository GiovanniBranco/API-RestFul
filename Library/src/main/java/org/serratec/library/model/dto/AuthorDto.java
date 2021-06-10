package org.serratec.library.model.dto;

import java.util.List;

public class AuthorDto {
	private String name;
	private List<BookDto> books;

	public String getName() {
		return name;
	}

	public List<BookDto> getBooks() {
		return books;
	}

	public void setName(String name) {
		this.name = name;
	}
}
