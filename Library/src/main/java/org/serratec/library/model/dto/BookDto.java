package org.serratec.library.model.dto;

import java.time.LocalDate;

import org.serratec.library.enums.BookType;


public class BookDto {
	private String title;
	private BookType type;
	private String author;
	private LocalDate date;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public BookType getType() {
		return type;
	}
	public void setType(BookType type) {
		this.type = type;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}

}
