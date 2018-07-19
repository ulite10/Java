package exceptions;

import java.sql.SQLException;

public class CuentaException extends SQLException {
	 
    public CuentaException(String message) {
    	super(message);
    }
}