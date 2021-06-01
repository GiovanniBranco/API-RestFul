package org.serratec.library.util;

import org.serratec.library.exceptions.BookNotFound;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(BookNotFound.class)
	public ResponseEntity<String> treatingBookNotFound(BookNotFound e) {
		return ResponseEntity.notFound()
				.header("x-error-msg", e.getMessage())
				.build();
	}
}
