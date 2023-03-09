package Exceptions;

public class FlightAlreadyInSystem extends Exception {
    private static final String MESSAGE = "Flight already in the system";



    public FlightAlreadyInSystem() {
        super(MESSAGE);

    }

    @Override
    public String getMessage() {
        return String.format(MESSAGE);
    }
}
