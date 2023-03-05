public class UserClass extends PersonClass implements User{
    //lista das suas reservas


    public UserClass(String name, String email, String gender, String userType){
        super(name, email, gender, userType);


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
