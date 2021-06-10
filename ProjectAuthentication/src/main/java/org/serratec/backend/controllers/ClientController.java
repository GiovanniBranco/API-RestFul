package org.serratec.backend.controllers;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.serratec.backend.entity.ClientEntity;
import org.serratec.backend.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

	@Autowired
	ClientService service;

	@GetMapping("/client")
	public ResponseEntity<List<ClientEntity>> getAll() {
		return new ResponseEntity<List<ClientEntity>>(service.getAll(), HttpStatus.OK);
	}

	@GetMapping("/client/{id}")
	public ResponseEntity<ClientEntity> getById(@PathVariable Long id) throws EntityNotFoundException {
		return new ResponseEntity<ClientEntity>(service.getById(id), HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<ClientEntity> create(@RequestBody ClientEntity dto) throws EntityNotFoundException {
		return new ResponseEntity<ClientEntity>(service.create(dto), HttpStatus.CREATED);
	}

	@PutMapping("/client/{id}")
	public ResponseEntity<ClientEntity> update(@PathVariable Long id, @RequestBody ClientEntity dto)
			throws EntityNotFoundException {
		return new ResponseEntity<ClientEntity>(service.update(id, dto), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/client/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) throws EntityNotFoundException, DataIntegrityViolationException {
		service.delete(id);
		return new ResponseEntity<String>("Cliente com " + id +" deletado com sucesso!", HttpStatus.OK);
	}
}
