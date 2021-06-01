package org.serratec.todolist.services;

import java.util.List;

import org.serratec.todolist.models.ToDoEntity;
import org.serratec.todolist.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {
	
	@Autowired
	ToDoRepository repository;
	
	public List<ToDoEntity> findAll(){
		return repository.findAll();
	}
	
	public ToDoEntity getById(Long id) {
//		if(repository.findById(id).isEmpty()) {
//		throw new
//	}
	return repository.findById(id).get();
	}
	
	public ToDoEntity create(ToDoEntity todo) {
		return repository.save(todo);
	}
	
	public ToDoEntity update(Long id, ToDoEntity todo) {
		ToDoEntity toDoEntity = getById(id);
		
		if (todo.getName() != null) {
			toDoEntity.setName(todo.getName());
		}
		return repository.save(toDoEntity);
	}
	
	public void delete(Long id) {
		ToDoEntity todo = getById(id);

			repository.delete(todo);
	}
}
