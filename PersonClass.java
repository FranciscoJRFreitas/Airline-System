public class PersonClass implements Person{
    private String name;
    private String email;
    private String gender;
    private String userType;

    public PersonClass(String name, String email, String gender, String userType) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.userType = userType;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
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
    public String getUserType() {
        return userType;
    }
    @Override
    public void setUserType(String userType) {
        this.userType = userType;
    }
}
