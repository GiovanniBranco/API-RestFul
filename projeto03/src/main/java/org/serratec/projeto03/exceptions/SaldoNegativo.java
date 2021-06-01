package org.serratec.projeto03.exceptions;

public class SaldoNegativo extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5416717060854844655L;

	public SaldoNegativo() {
		super();
		
	}

	public SaldoNegativo(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public SaldoNegativo(String message, Throwable cause) {
		super(message, cause);
		
	}

	public SaldoNegativo(String message) {
		super(message);
		
	}

	public SaldoNegativo(Throwable cause) {
		super(cause);
		
	}
	
	
	
}
