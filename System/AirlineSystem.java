package System;

import Exceptions.*;
import Persons.*;


import java.util.HashMap;

public class AirlineSystem {

    private HashMap<String, User> usersByUsername;
    private HashMap<String, Admin> adminByID;



    public AirlineSystem(){
        usersByUsername = new HashMap<>();
        adminByID = new HashMap<>();

    }

    private boolean hasUser(String email){return usersByUsername.containsKey(email);}
    private boolean hasAdmin(String email){return adminByID.containsKey(email);}

    public void addPerson(String username, String email, String password, String gender, String userType) throws UserAlreadyExistsException {
        if(userType.equals("User")) {
            if (hasUser(email))
                throw new UserAlreadyExistsException(email);
            else {
                User p = new UserClass(username, email, gender);
                usersByUsername.put(email, p);
            }
        }else if(userType.equals("Admin")){
            if(hasAdmin(email))
                throw new UserAlreadyExistsException(email);
            else{

                Admin a = new AdminClass(username, email, gender);
                adminByID.put(email, a);
            }


        }

    }




}
