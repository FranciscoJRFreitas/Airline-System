package Exceptions;

public class MissingInfoException extends Exception{
    private static final String MESSAGE = "Missing information";



    public MissingInfoException() {
        super(MESSAGE);

    }

    @Override
    public String getMessage() {
        return String.format(MESSAGE);
    }
}
