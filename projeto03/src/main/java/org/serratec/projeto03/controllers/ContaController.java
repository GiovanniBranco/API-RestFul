package org.serratec.projeto03.controllers;

import java.util.List;

import org.serratec.projeto03.exceptions.ContaNotFound;
import org.serratec.projeto03.models.Conta;
import org.serratec.projeto03.models.Operacao;
import org.serratec.projeto03.services.Api;
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
	Api service;
	
	@GetMapping
	public ResponseEntity<List<Conta>>getAll(){
		return new ResponseEntity<List<Conta>>(service.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Conta> getOne(@PathVariable Integer id) throws ContaNotFound {
		return new ResponseEntity<Conta> (service.getOne(id), HttpStatus.FOUND);
	}
	
	@PostMapping
	public ResponseEntity<Conta> create(@RequestBody Conta conta) {
		return new ResponseEntity<Conta> (service.create(conta), HttpStatus.CREATED);
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<Conta> atualizarSalddo(@PathVariable Integer id, @RequestBody Operacao operacao) throws ContaNotFound{
		return new ResponseEntity<Conta> (service.atualizarSaldo(id, operacao), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public Conta update(@PathVariable Integer id, @RequestBody Conta conta) throws ContaNotFound {
		return service.update(id, conta);
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) throws ContaNotFound {
		return service.delete(id);
	}
}



















