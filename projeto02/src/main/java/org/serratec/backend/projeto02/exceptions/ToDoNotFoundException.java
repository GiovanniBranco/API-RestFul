package org.serratec.backend.projeto02.exceptions;

public class ToDoNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4795849089219685380L;

	public ToDoNotFoundException() {
		super();
		
	}

	public ToDoNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public ToDoNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public ToDoNotFoundException(String message) {
		super(message);
		
	}

	public ToDoNotFoundException(Throwable cause) {
		super(cause);
		
	}

	
}
