package Persons;
public class AdminClass extends PersonClass implements Admin{
    //coisas do admin

    public AdminClass(String name, String email, String password, String gender) {
        super(name, email, password, gender);
    }

    @Override
    public void addFlight() {

    }

    @Override
    public void setFlightInfo() {

    }

    @Override
    public void removeFlight() {

    }

    @Override
    public void viewAllReservation() {

    }
}
