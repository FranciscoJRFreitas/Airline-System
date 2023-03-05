package Exceptions;

public class UserNotExistsException extends Exception {
    private static final String MESSAGE = "User does not exist";



    public UserNotExistsException() {
        super(MESSAGE);

    }

    @Override
    public String getMessage() {
        return String.format(MESSAGE);
    }
}
