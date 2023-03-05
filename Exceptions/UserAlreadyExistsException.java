package Exceptions;
/**
 * <code>Exception</code> thrown when a user already exists in the application.
 *
 *
 */
public class UserAlreadyExistsException extends Exception {

    private static final String MESSAGE = "User %s already exists.";

    private String email;

    public UserAlreadyExistsException(String email) {
        super(MESSAGE);
        this.email = email;
    }

    @Override
    public String getMessage() {
        return String.format(MESSAGE, email);
    }
}
