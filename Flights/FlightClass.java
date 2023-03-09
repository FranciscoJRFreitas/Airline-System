package Flights;

import java.time.LocalDate;

public class FlightClass implements Flight {

    private String nVoo;
    private String nAirPlane;
    private String origin;
    private String destination;
    private LocalDate arrival;
    private LocalDate departure;
    private String pilotName;

    public FlightClass(String nVoo, String nAirPlane, String origin, String destination, LocalDate arrival, LocalDate departure, String pilotName) {
        this.nVoo = nVoo;
        this.nAirPlane = nAirPlane;
        this.origin = origin;
        this.destination = destination;
        this.arrival = arrival;
        this.departure = departure;
        this.pilotName = pilotName;
    }
    @Override
    public String getnVoo() {
        return nVoo;
    }
    @Override
    public String getnAirPlane() {
        return nAirPlane;
    }
    @Override
    public String getOrigin() {
        return origin;
    }
    @Override
    public String getDestination() {
        return destination;
    }
    @Override
    public LocalDate getArrival() {
        return arrival;
    }
    @Override
    public LocalDate getDeparture() {
        return departure;
    }
    @Override
    public String getPilotName() {
        return pilotName;
    }
}