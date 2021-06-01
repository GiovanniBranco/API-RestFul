package org.serratec.projeto03.util;

import org.serratec.projeto03.exceptions.ContaNotFound;
import org.serratec.projeto03.exceptions.SaldoNegativo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController{
	
	@ExceptionHandler(ContaNotFound.class)
	
	public ResponseEntity<String> tratarNotFound(ContaNotFound expection){
		return ResponseEntity.notFound()
				.header("x-error-msg", expection.getMessage())
				.build();
	}
	
	@ExceptionHandler(SaldoNegativo.class)
	
	public ResponseEntity<String> saldoNegativo(SaldoNegativo e){
		return ResponseEntity.badRequest()
				.header("x-error-msg", e.getMessage())
				.build();
	}
}
