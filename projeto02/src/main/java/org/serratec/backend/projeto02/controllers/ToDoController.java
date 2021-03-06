package org.serratec.backend.projeto02.controllers;

import java.util.Set;

import org.serratec.backend.projeto02.exceptions.ToDoNotFoundException;
import org.serratec.backend.projeto02.model.ToDoEntity;
import org.serratec.backend.projeto02.service.ToDoService;
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
@RequestMapping("/todo")
public class ToDoController {

	@Autowired /* Realiza a injeção de dependência da classe service; */
	ToDoService service;

	//Função de GET;
	@GetMapping
	public Set<ToDoEntity> toDo() {
		/* Puxo o método da classe service sem a necessidade de instanciar a classe */
		return service.listar();
	}

	@GetMapping("/{id}")
	public ToDoEntity lerTarefa(@PathVariable Integer id) throws ToDoNotFoundException {
		return service.readOne(id);
	}
	
	//Função de POST;
	@PostMapping
	public ResponseEntity<ToDoEntity> adicionarTarefa(@RequestBody ToDoEntity obj) {
		service.adicionarEvento(obj);
		return new ResponseEntity<ToDoEntity>(service.adicionarEvento(obj), HttpStatus.CREATED) ;
	}
	
	
	//Atualizar tarefa
	@PutMapping ("/{id}")
	public void update(@RequestBody ToDoEntity tarefa, @PathVariable Integer id) throws ToDoNotFoundException {
		service.update(tarefa, id);
		toDo();
	}

	
	//Função de DELETE;
	@DeleteMapping ("/remove/{id}")
	public void removerTarefa(@PathVariable Integer id) throws ToDoNotFoundException {
		service.deletarTarefa(id);
	}
}
