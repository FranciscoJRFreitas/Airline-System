package Flights;

import java.time.LocalDate;

public interface Flight {

    String getnVoo();

    String getnAirPlane();

    String getOrigin();

    String getDestination();

    LocalDate getArrival();

    LocalDate getDeparture();

    String getPilotName();
}
