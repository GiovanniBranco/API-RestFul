package org.serratec.library.services;

import java.util.List;
import java.util.stream.Collectors;

import org.serratec.library.config.MailConfig;
import org.serratec.library.exceptions.EntityNotFound;
import org.serratec.library.mapper.AuthorMapper;
import org.serratec.library.model.AuthorModel;
import org.serratec.library.model.dto.AuthorDto;
import org.serratec.library.repository.AuthorRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

	@Autowired
	AuthorRespository repository;

	@Autowired
	AuthorMapper mapper;

	@Autowired
	MailConfig mail;

	public List<AuthorDto> getAll() {
		return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
	}

	public AuthorModel getById(Long id) throws EntityNotFound {
		return repository.findById(id).orElseThrow(() -> new EntityNotFound(id + " não encontrado."));
	}

	public String create(AuthorDto author) {
		repository.save(mapper.toModel(author));

		return mail.sendEmail("giovannipbranco1@gmail.com", "Autor Criado", "Você é brabo mesmo, o autor foi criado!");
	}

	public AuthorDto update(Long id, AuthorDto dto) throws EntityNotFound {
		AuthorModel author = this.getById(id);

		if (dto.getName() != null) {
			author.setName(dto.getName());
		}

		return mapper.toDto(repository.save(author));
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
}
