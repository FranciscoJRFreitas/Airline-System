package System;

import Events.RegisterPersonEvent;
import UI.LoginOrRegister;

import java.util.ArrayList;
import java.util.HashMap;

public class ArlineSystem {

    private HashMap<String, User> usersByUsername;
    private HashMap<String, Admin> adminByID;
    private RegisterPersonEvent registerPerson;
    

    public ArlineSystem(){
        usersByUsername = new HashMap<>();
        adminByID = new HashMap<>();
        registerPerson = new RegisterPersonEvent();
    }

    private boolean hasUser(String email){return usersByUsername.containsKey(email);}
    private boolean hasAdmin(String email){return adminByID.containsKey(email);}

    public void addPerson() throws UserAlreadyExistsException {
        String username = registerPerson.getUsername();
        String email = registerPerson.getEmail();
        String gender = registerPerson.getGender();
        String userType = registerPerson.getUserType();
        if(userType.equals("User")) {
            if (hasUser(email))
                throw new UserAlreadyExistsException();
            else {
                User p = new UserClass(username, email, gender);
                usersByUsername.put(email, p);
            }
        }else if(userType.equals("Admin")){
            if(hasAdmin(email))
                throw new UserAlreadyExistsException();
            else{

                Admin a = new AdminClass()
            }


        }

    }




}
