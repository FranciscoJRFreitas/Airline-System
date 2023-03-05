package Exceptions;

public class WrongDataException extends Exception {

    private static final String MESSAGE = "Email or Password invalid.";



    public WrongDataException() {
        super(MESSAGE);

    }

    @Override
    public String getMessage() {
        return String.format(MESSAGE);
    }
}
