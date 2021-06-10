package org.serratec.library.mapper;

import org.serratec.library.model.AuthorModel;
import org.serratec.library.model.dto.AuthorDto;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {
	public AuthorModel toModel(AuthorDto dto) {
		AuthorModel author = new AuthorModel();
		
		author.setName(dto.getName());
		return author;
	}

	public AuthorDto toDto(AuthorModel author) {
		AuthorDto dto = new AuthorDto();
		
		dto.setName(author.getName());		
		return dto;
	}
}
