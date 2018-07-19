package exceptions;

public class BusinessObjectException extends Exception{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BusinessObjectException(String message, Throwable cause) {
	    	super(message, cause);
	    }
}
