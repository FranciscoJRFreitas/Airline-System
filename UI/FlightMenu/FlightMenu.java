package UI.FlightMenu;

import Exceptions.*;
import System.AirlineSystem;
import UI.MainMenu.UserMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FlightMenu extends JFrame implements ActionListener {

    private static final String DATE_FORMAT = "dd-MM-yyyy";
    private JLabel flightNumberLabel, planeNumberLabel, originLabel, destinationLabel, departureDateLabel, arrivalDateLabel, pilotNameLabel;
    private JTextField flightNumberText, planeNumberText, originText, destinationText, departureDateText, arrivalDateText, pilotNameText;
    private JButton addButton;
    private JPanel mainPanel;

    private AirlineSystem sys;

    public FlightMenu(AirlineSystem sys) {
        this.sys = sys;
        setTitle("Add Flight");
        setSize(400, 300);

        mainPanel = new JPanel(new GridLayout(7, 2));
        flightNumberLabel = new JLabel("Flight Number:");
        planeNumberLabel = new JLabel("Plane Number:");
        originLabel = new JLabel("Origin:");
        destinationLabel = new JLabel("Destination:");
        departureDateLabel = new JLabel("Departure Date:");
        arrivalDateLabel = new JLabel("Arrival Date:");
        pilotNameLabel = new JLabel("Pilot Name:");
        flightNumberText = new JTextField();
        planeNumberText = new JTextField();
        originText = new JTextField();
        destinationText = new JTextField();
        departureDateText = new JTextField();
        arrivalDateText = new JTextField();
        pilotNameText = new JTextField();
        addButton = new JButton("Add Flight");
        addButton.addActionListener(this);

        mainPanel.add(flightNumberLabel);
        mainPanel.add(flightNumberText);
        mainPanel.add(planeNumberLabel);
        mainPanel.add(planeNumberText);
        mainPanel.add(originLabel);
        mainPanel.add(originText);
        mainPanel.add(destinationLabel);
        mainPanel.add(destinationText);
        mainPanel.add(departureDateLabel);
        mainPanel.add(departureDateText);
        mainPanel.add(arrivalDateLabel);
        mainPanel.add(arrivalDateText);
        mainPanel.add(pilotNameLabel);
        mainPanel.add(pilotNameText);
        mainPanel.add(addButton);

        add(mainPanel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        if (e.getSource() == addButton) {
            String flightNumber = flightNumberText.getText();
            String planeNumber = planeNumberText.getText();
            String origin = originText.getText();
            String destination = destinationText.getText();
            LocalDate departureDate = LocalDate.parse(departureDateText.getText(), formatter);
            LocalDate arrivalDate = LocalDate.parse(departureDateText.getText(), formatter);
            String pilotName = pilotNameText.getText();

            try {
                sys.addFlight(flightNumber,planeNumber, origin, destination, departureDate, arrivalDate, pilotName);
                JOptionPane.showMessageDialog(this, "Flight added");
                setVisible(false);
                new UserMenu(sys).run();
            }catch(FlightAlreadyInSystem er){
                JOptionPane.showMessageDialog(this, er.getMessage());
            }

            // Clear the text fields.
            flightNumberText.setText("");
            planeNumberText.setText("");
            originText.setText("");
            destinationText.setText("");
            departureDateText.setText("");
            arrivalDateText.setText("");
            pilotNameText.setText("");
        }
    }


}
