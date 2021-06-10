package org.serratec.library.exceptions;

public class EntityNotFound extends Exception{

	private static final long serialVersionUID = -6696215848178242845L;

	public EntityNotFound() {
		super();		
	}

	public EntityNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);		
	}

	public EntityNotFound(String message, Throwable cause) {
		super(message, cause);		
	}

	public EntityNotFound(String message) {
		super(message);
	}

	public EntityNotFound(Throwable cause) {
		super(cause);
	}
	
}
