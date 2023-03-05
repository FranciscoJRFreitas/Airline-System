import UI.LoginOrRegister;
import System.AirlineSystem;
public class Main {

    public static void main (String[] args){
        AirlineSystem fly = new AirlineSystem();

        LoginOrRegister loginOrRegisterUI = new LoginOrRegister(fly);
        loginOrRegisterUI.run();

    }
}