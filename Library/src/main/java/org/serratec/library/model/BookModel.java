package org.serratec.library.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

@Entity
@Table(name="BOOK")
public class BookModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String title;
	
	@Past
	private LocalDate date;
	//Usar para cadastrar já com a data atual;
//	private LocalDate date = LocalDate.now(); 


	// Puxando id da entidade CategoryModel e sendo feito o referenciamento
	@ManyToOne
	@JoinColumn(referencedColumnName = "id") 
	private CategoryModel category;
	
	@ManyToMany(mappedBy = "books")
	private List<AuthorModel> authors;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public CategoryModel getCategory() {
		return category;
	}

	public void setCategory(CategoryModel category) {
		this.category = category;
	}

	public List<AuthorModel> getAuthors() {
		return authors;
	}

	public void setAuthors(List<AuthorModel> authors) {
		this.authors = authors;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

}
