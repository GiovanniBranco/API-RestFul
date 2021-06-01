package org.serratec.library.exceptions;

public class BookNotFound extends Exception{

	private static final long serialVersionUID = -6696215848178242845L;

	public BookNotFound() {
		super();		
	}

	public BookNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);		
	}

	public BookNotFound(String message, Throwable cause) {
		super(message, cause);		
	}

	public BookNotFound(String message) {
		super(message);
	}

	public BookNotFound(Throwable cause) {
		super(cause);
	}
	
}
