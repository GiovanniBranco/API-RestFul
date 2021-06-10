package org.serratec.library.model.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.serratec.library.model.AuthorModel;
import org.serratec.library.model.CategoryModel;


public class BookDto {
	@NotNull
	@Size(min = 5, max = 30)
	private String title;
	
	private CategoryModel category;
	
	@NotNull
	@Size(min = 10, max = 40)
	private AuthorModel author;
	
	@Past
	private LocalDate date;
	

	public CategoryModel getCategory() {
		return category;
	}

	public void setCategory(CategoryModel category) {
		this.category = category;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public AuthorModel getAuthor() {
		return author;
	}
	public void setAuthor(AuthorModel authorModel) {
		this.author = authorModel;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}

}
