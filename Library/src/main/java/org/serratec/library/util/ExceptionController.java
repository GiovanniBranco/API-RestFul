package org.serratec.library.util;

import org.serratec.library.exceptions.EntityNotFound;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(EntityNotFound.class)
	public ResponseEntity<String> treatingBookNotFound(EntityNotFound e) {
		return ResponseEntity.notFound()
				.header("x-error-msg", e.getMessage())
				.build();
	}
}
