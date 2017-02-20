package cl.keanzato.app.exceptions;

public class ConexionException extends RuntimeException {

	private static final long serialVersionUID = -1889162374796376031L;

	/**
	 * @param message
	 * @param cause
	 */
	public ConexionException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public ConexionException(String message) {
		super(message);
	}
	
	
	
	
}
