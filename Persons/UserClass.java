package Persons;
public class UserClass extends PersonClass implements User{
    //lista das suas reservas


    public UserClass(String username, String email, String password, String gender){
        super(username, email, password, gender);


    }


    @Override
    public void bookFlight() {

    }

    @Override
    public void cancelBookFlight() {

    }

    @Override
    public void listMyFlights() {

    }
}
