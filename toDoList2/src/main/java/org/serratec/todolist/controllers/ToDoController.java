package org.serratec.todolist.controllers;

import java.util.List;

import org.serratec.todolist.models.ToDoEntity;
import org.serratec.todolist.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	ToDoService service;
	
	@GetMapping
	public List<ToDoEntity> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public ToDoEntity getById(@PathVariable Long id) {
		return service.getById(id);
	}
	
	@PostMapping
	public ToDoEntity create(@RequestBody ToDoEntity todo) {
		return service.create(todo);
	}
	
	@PutMapping("/{id}")
	public ToDoEntity update(@PathVariable Long id, @RequestBody ToDoEntity todo) {
		return service.update(id, todo);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}
