package UI.MainMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserMenu extends AbstractMenu{
    private JMenuItem addMenuItem, deleteMenuItem, editMenuItem;

    public UserMenu() {
            super();
            super.run();
            addMenuItems();

            // add action listener to the logout menu item
            logoutMenuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Handle logout here
                    // For example, close this window and open the login screen
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