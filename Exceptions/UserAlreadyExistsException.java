package Exceptions;
/**
 * <code>Exception</code> thrown when a user already exists in the application.
 *
 *
 */
public class UserAlreadyExistsException extends Exception {

    private static final String MESSAGE = "User already exists.";

    public UserAlreadyExistsException() {
        super(MESSAGE);
    }

    @Override
    public String getMessage() {
        return String.format(MESSAGE);
    }
}
