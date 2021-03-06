package org.serratec.backend.projeto02.service;

import java.util.HashSet;
import java.util.Set;

import org.serratec.backend.projeto02.exceptions.ToDoNotFoundException;
import org.serratec.backend.projeto02.model.ToDoEntity;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {
	Set<ToDoEntity> tarefas = new HashSet<ToDoEntity>();

	//Adiciona tarefas
	public ToDoEntity adicionarEvento(ToDoEntity obj) {	
		for (ToDoEntity toDoEntity : tarefas) {
			if(toDoEntity.equals(obj)) {
				System.out.println("Id já cadastrado");
				return null;
			}
		}
		tarefas.add(obj);
		return obj;
	}

	//Cria a Lista de tarefas
	public Set<ToDoEntity> listar(){	
		return tarefas;	
	}

	
	//Faz a leitura apenas de um objeto específico
	public ToDoEntity readOne(Integer id) throws ToDoNotFoundException{
		for (ToDoEntity toDoEntity : tarefas) {
			if(toDoEntity.getId() == id) {
				return toDoEntity;
			}
		}
		throw new ToDoNotFoundException("Não foi possível localizar o ID: " + id);
	}
	
	//Atualiza os valores de um objeto
	public void update (ToDoEntity obj, Integer id) throws ToDoNotFoundException{
		for (ToDoEntity toDoEntity : tarefas) {
			if(toDoEntity.getId() == id) {
				if(obj.getName() != null) {
					toDoEntity.setName(obj.getName());					
				}
				else if (obj.getDescription() != null) {
					toDoEntity.setDescription(obj.getDescription());	
				}
				break;
			}
			else {
				throw new ToDoNotFoundException("Não foi possível localizar o ID: " + id);				
			}
		}
	}
	
	//Remove tarefas
	public void deletarTarefa(Integer id) throws ToDoNotFoundException {
		for (ToDoEntity toDoEntity : tarefas) {
			if(toDoEntity.getId().equals(id)) {
				tarefas.remove(toDoEntity);
				break;
			}else {
				throw new ToDoNotFoundException("Não foi possível localizar o ID: " + id);		
			}
		}
	}
}
