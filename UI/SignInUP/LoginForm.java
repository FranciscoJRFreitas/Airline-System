package UI.SignInUP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Exceptions.MissingInfoException;
import Exceptions.UserNotExistsException;
import Exceptions.WrongDataException;
import System.AirlineSystem;
import UI.MainMenu.UserMenu;

public class LoginForm extends JFrame implements ActionListener {
    private JLabel emailLabel, passwordLabel;

    private JTextField emailField;
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
        emailLabel = new JLabel("          Email:");
        passwordLabel = new JLabel("          Password:");
        emailField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");
        goBackButton = new JButton("Go back");

        // add action listener to button
        loginButton.addActionListener(this);
        goBackButton.addActionListener(this);

        // set layout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);

        c.gridx = 0;
        c.gridy = 1;
        panel.add(emailLabel, c);

        c.gridx = 1;
        c.gridy = 1;
        panel.add(emailField, c);

        c.gridx = 0;
        c.gridy = 3;
        panel.add(passwordLabel, c);

        c.gridx = 1;
        c.gridy = 3;
        panel.add(passwordField, c);

        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 1;
        panel.add(goBackButton, c);

        c.gridx = 1;
        c.gridy = 4;
        c.gridwidth = 1;
        panel.add(loginButton, c);

        // add panel to the frame
        add(panel);

        // pack the frame and show it
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == loginButton) {
            // get username and password from fields
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            // do login validation
            try {
                sys.validate(email, password);
                JOptionPane.showMessageDialog(this, "Login successful");
            }catch(MissingInfoException | UserNotExistsException | WrongDataException er){
                JOptionPane.showMessageDialog(this, er.getMessage());
            }

            new UserMenu().run();

        }

        if (e.getSource() == goBackButton) {
            // Open the register UI
            LoginOrRegister loginOrRegister = new LoginOrRegister(sys);
            loginOrRegister.run();
            dispose();
        }
    }
}
