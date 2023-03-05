package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import System.AirlineSystem;

public class LoginForm extends JFrame implements ActionListener {
    private JLabel usernameLabel, passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton goBackButton;
    private AirlineSystem sys;

    public LoginForm(AirlineSystem sys) {
        this.sys = sys;

    }

    public void run() {
        setTitle("Login Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setResizable(false);
        setLocationRelativeTo(null);

        // create components
        usernameLabel = new JLabel("          Username:");
        passwordLabel = new JLabel("          Password:");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");
        goBackButton = new JButton("Go back");

        // add action listener to button
        loginButton.addActionListener(this);
        goBackButton.addActionListener(this);

        // set layout
        setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        //TODO

        c.gridx = 0;
        c.gridy = 1;
        add(passwordLabel, c);

        c.gridx = 1;
        c.gridy = 2;
        add(passwordField, c);

        c.gridx = 0;
        c.gridy = 2;
        add(passwordLabel, c);

        c.gridx = 1;
        c.gridy = 2;
        add(passwordField, c);

        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 1;
        add(goBackButton, c);

        // show the frame
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == loginButton) {
            // get username and password from fields
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // do login validation
            if (username.equals("admin") && password.equals("password")) {
                JOptionPane.showMessageDialog(this, "Login successful");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password");
            }

        }

        if (e.getSource() == goBackButton) {
            // Open the register UI
            LoginOrRegister loginOrRegister = new LoginOrRegister(sys);
            loginOrRegister.run();
            dispose();
        }
    }
}
