package Persons;
public abstract class PersonClass implements Person {
    private String username;
    private String email;
    private String gender;

    private String password;


    public PersonClass(String username, String email, String password,  String gender) {
        this.username = username;
        this.email = email;
        this.gender = gender;
        this.password = password;
    }

    @Override
    public String getName() {
        return username;
    }
    @Override
    public void setName(String name) {
        this.username = name;
    }
    @Override
    public String getEmail() {
        return email;
    }
    @Override
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public void setPassword(String newPass){
        this.password = newPass;
    }

    @Override
    public String getPassword(){
        return password;
    }

}
