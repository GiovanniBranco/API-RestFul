package org.serratec.projeto03.exceptions;

public class ContaNotFound extends Exception{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9108984349530763365L;

	public ContaNotFound() {
		super();
		
	}

	public ContaNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public ContaNotFound(String message, Throwable cause) {
		super(message, cause);
		
	}

	public ContaNotFound(String message) {
		super(message);
		
	}

	public ContaNotFound(Throwable cause) {
		super(cause);
		
	}

}
