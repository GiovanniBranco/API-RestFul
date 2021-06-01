package org.serratec.projeto03.controllers;

import java.util.List;

import org.serratec.projeto03.exceptions.ContaNotFound;
import org.serratec.projeto03.exceptions.SaldoNegativo;
import org.serratec.projeto03.model.dto.ContaDto;
import org.serratec.projeto03.models.ContaEntity;
import org.serratec.projeto03.models.Operacao;
import org.serratec.projeto03.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conta")
public class ContaController {
	
	@Autowired
	ContaService service;
	
	@GetMapping
	public ResponseEntity<List<ContaEntity>>getAll(){
		return new ResponseEntity<List<ContaEntity>>(service.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ContaEntity> getOne(@PathVariable Integer id) throws ContaNotFound {
		return new ResponseEntity<ContaEntity> (service.getById(id), HttpStatus.OK);
	}
	
//	@GetMapping("/{name}")
//	public ResponseEntity<List<ContaEntity>> getByName(@PathVariable String titular) throws ContaNotFound {
//		return new ResponseEntity<List<ContaEntity>> (service.getByName(titular), HttpStatus.OK);
//	}

	@PostMapping
	public ResponseEntity<ContaEntity> create(@RequestBody ContaEntity conta) {
		return new ResponseEntity<ContaEntity> (service.create(conta), HttpStatus.CREATED);
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<ContaDto> atualizarSalddo(@PathVariable Integer id, @RequestBody Operacao operacao) throws ContaNotFound, SaldoNegativo{
		return new ResponseEntity<ContaDto> (service.atualizarSaldo(id, operacao), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ContaEntity> update(@PathVariable Integer id, @RequestBody ContaEntity conta) throws ContaNotFound {
		return new ResponseEntity<ContaEntity> (service.update(id, conta), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id){
		return new ResponseEntity<String> (service.delete(id), HttpStatus.OK);
	}
}