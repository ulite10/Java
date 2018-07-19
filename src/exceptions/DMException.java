package exceptions;

import java.sql.SQLException;

public class DMException extends SQLException {
	 
    public DMException(String message, Throwable cause) {
    	super(message, cause);
    }
}
