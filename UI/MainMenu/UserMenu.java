package UI.MainMenu;

import Flights.Flight;
import System.AirlineSystem;
import UI.FlightMenu.FlightMenu;
import UI.SignInUP.LoginOrRegister;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

public class UserMenu extends AbstractMenu{
    private JMenuItem addMenuItem, deleteMenuItem, editMenuItem;

    private AirlineSystem sys;

    private Iterator<Flight> flightIterator;

    private UserMenu t;


    public UserMenu(AirlineSystem sys) {

        super();
        super.run();
        addMenuItems();
        this.sys = sys;
        t = this;
        createUI();

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
                UserMenu.super.setVisible(false);
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





    public void createUI() {


        // Create a new JPanel to hold the JTable
        JPanel panel = new JPanel(new BorderLayout());

        // Create a new JTable with column names
        String[] columnNames = {"Flight Number", "Departure", "Arrival", "Departure Time", "Arrival Time"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);

        // Create a new JScrollPane and add the JTable to it
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the JScrollPane to the JPanel
        panel.add(scrollPane, BorderLayout.CENTER);

        // Add the JPanel to the JFrame
        super.add(panel);

        // Create a new Thread to load the data into the JTable
        Thread loadDataThread = new Thread(new Runnable() {
            @Override
            public void run() {
                flightIterator = sys.listFlights();
                // Load the flight data from the iterator
                while (flightIterator.hasNext()) {
                    Flight flight = flightIterator.next();
                    Object[] row = {flight.getnVoo(), flight.getDeparture(), flight.getArrival(), flight.getDestination(), flight.getOrigin()};
                    model.addRow(row);
                }
            }
        });

        // Start the thread to load the data
        loadDataThread.start();

        // Set the JFrame visible
        super.setVisible(true);
    }

}