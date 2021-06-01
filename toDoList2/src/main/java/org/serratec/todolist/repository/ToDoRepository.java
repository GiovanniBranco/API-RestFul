package org.serratec.todolist.repository;

import org.serratec.todolist.models.ToDoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDoEntity, Long>{

}
