package org.serratec.library.model.dto;

import java.util.List;

public class CategoryDto {
	private String name;
	private String description;
	private List<BookDto> books;
	
	
	public List<BookDto> getBooks() {
		return books;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
