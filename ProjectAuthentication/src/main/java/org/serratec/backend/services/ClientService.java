package org.serratec.backend.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.serratec.backend.entity.ClientEntity;
import org.serratec.backend.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

	@Autowired
	ClientRepository repository;
	
	@Autowired
	BCryptPasswordEncoder bCrypt;
	
	public List<ClientEntity> getAll() {
		return repository.findAll();
	}

	public ClientEntity getById(Long id) throws EntityNotFoundException {
		return this.findById(id);
	}

	public ClientEntity create(ClientEntity entity) throws EntityNotFoundException {
		entity.setSenha(bCrypt.encode(entity.getSenha()));
		return  repository.save(entity);
	}

	public ClientEntity update(Long id, ClientEntity clientUpdate) throws EntityNotFoundException {
		ClientEntity client = this.findById(id);

		client.setUsername(clientUpdate.getUsername());
		client.setSenha(clientUpdate.getSenha());
		client.setNome(clientUpdate.getNome());
//		client.setEnderecos(clientUpdate.getEnderecos());

		return repository.save(client);
	}

	public void delete(Long id) throws EntityNotFoundException, DataIntegrityViolationException {
		try {
			if (this.findById(id) != null) {
				// service.delete(service.findById());
				repository.deleteById(id);
			}
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException(
					"Endereço com id: " + id + " está associada a um ou mais clientes favor verificar");
		}

	}

	public ClientEntity findById(Long id) throws EntityNotFoundException {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id + " não encontrado."));
	}
}
