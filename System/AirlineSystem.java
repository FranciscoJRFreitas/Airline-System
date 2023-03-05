package System;

import Exceptions.*;
import Persons.*;


import java.util.HashMap;

public class AirlineSystem {

    private HashMap<String, User> usersByEmail;
    private HashMap<String, Manager> managersByEmail;
    private HashMap<String, Admin> adminsByEmail;
    private HashMap<String, String> userByPass;



    public AirlineSystem(){
        usersByEmail = new HashMap<>();
        managersByEmail = new HashMap<>();
        userByPass = new HashMap<>();
        adminsByEmail = new HashMap<>();
    }

    private boolean hasUser(String email){return usersByEmail.containsKey(email);}
    private boolean hasManager(String email){return managersByEmail.containsKey(email);}
    private boolean hasAdmin(String email){return adminsByEmail.containsKey(email);}
    public void addPerson(String username, String email, String password, String gender, String userType) throws UserAlreadyExistsException, MissingInfoException {
        if (username.equals("") || password.equals("") || userType.equals("") || gender.equals(""))
            throw new MissingInfoException();

        switch (userType) {
            case "User":
                if (hasUser(email))
                    throw new UserAlreadyExistsException();
                else {
                    User u = new UserClass(username, email, password, gender);
                    usersByEmail.put(email, u);
                }
                break;
            case "Manager":
                if (hasManager(email))
                    throw new UserAlreadyExistsException();
                else {
                    Manager m = new ManagerClass(username, email, password, gender);
                    managersByEmail.put(email, m);
                }
                break;
            case "Admin":
                if (hasAdmin(email))
                    throw new UserAlreadyExistsException();
                else {
                    Admin a = new AdminClass(username, email, password, gender);
                    adminsByEmail.put(email, a);
                }
                break;
        }

    public void validate(String email, String password) throws MissingInfoException, UserNotExistsException, WrongDataException {
        if(email.equals("") || password.equals(""))
            throw new MissingInfoException();

        if (!(hasUser(email) || hasManager(email)))
            throw new UserNotExistsException();

        if(!(userByPass.get(email).equals(password)))
            throw new WrongDataException();
    }




}
