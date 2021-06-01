package org.serratec.backend.projeto02.controllers;
import org.serratec.backend.projeto02.exceptions.ToDoNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionsController {
	
	@ExceptionHandler(ToDoNotFoundException.class)
	public ResponseEntity<String> tratandoToDoNotFoundException(ToDoNotFoundException exception){
		return ResponseEntity.notFound()
				.header("x-error-msg", exception.getMessage())
				.build();
	}
	
}
