package com.twentyat.exception;

/**
 * Exception Class for all other exception other then Illegal Exception 
 * 
 * @author Bipin Sutariya
 *
 */
public class TwentyAtProviderException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TwentyAtProviderException() {
		super();
	}

	public TwentyAtProviderException(String message, Throwable cause) {
		super(message, cause);
	}

	public TwentyAtProviderException(String message) {
		super(message);
	}

	public TwentyAtProviderException(Throwable cause) {
		super(cause);
	}

}
