package UI.MainMenu;
import System.AirlineSystem;

import UI.FlightMenu.FlightMenu;
import UI.SignInUP.LoginOrRegister;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserMenu extends AbstractMenu{
    private JMenuItem addMenuItem, deleteMenuItem, editMenuItem;

    private AirlineSystem sys;

    public UserMenu(AirlineSystem sys) {
        super();
        super.run();
        addMenuItems();
        this.sys = sys;

        // add action listener to the logout menu item
        logoutMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle logout here
                // For example, close this window and open the login screen
                LoginOrRegister loginOrRegister = new LoginOrRegister(sys);
                loginOrRegister.run();
                dispose();
            }
        });

        addMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FlightMenu(sys);


            }


        });
    }

    @Override
    public void run() {
        setVisible(true);
    }

    @Override
    protected void addMenuItems() {
            addMenuItem = new JMenuItem("Add");
            deleteMenuItem = new JMenuItem("Delete");
            editMenuItem = new JMenuItem("Edit");

            // add menu items to the file menu
            fileMenu.add(addMenuItem);
            fileMenu.add(deleteMenuItem);
            fileMenu.add(editMenuItem);
    }

}