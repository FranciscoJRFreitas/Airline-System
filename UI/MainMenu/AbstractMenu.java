package UI.AbstractMenu;

import javax.swing.*;

public abstract class AbstractMenu extends JFrame {
    protected JMenuBar menuBar;
    protected JMenu fileMenu, editMenu, helpMenu;
    protected JMenuItem logoutMenuItem;

    public AbstractMenu() {
        setTitle("Menu Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        helpMenu = new JMenu("Help");

        // add menus to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        // create a logout menu item and add it to the file menu
        logoutMenuItem = new JMenuItem("Logout");
        fileMenu.add(logoutMenuItem);

        // set menu bar for the frame
        setJMenuBar(menuBar);

        // set size and location
        setSize(500, 300);
        setLocationRelativeTo(null);

        // show the frame
        setVisible(true);
    }

    // abstract method for adding menu items
    protected abstract void addMenuItems();
}

