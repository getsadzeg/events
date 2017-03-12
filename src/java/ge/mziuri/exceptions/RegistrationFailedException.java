
package ge.mziuri.exceptions;
import ge.mziuri.enums.RegistrationFailedExceptionType;

public class RegistrationFailedException extends Exception {

    
    public RegistrationFailedException() {
    }

    
    public RegistrationFailedException(String msg, RegistrationFailedExceptionType type) {
        super(msg);
    }
}
