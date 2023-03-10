package UI.SignInUP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import System.AirlineSystem;

public class LoginOrRegister extends JFrame implements ActionListener {
    private JButton loginButton;
    private JButton registerButton;
    private AirlineSystem sys;



    public LoginOrRegister(AirlineSystem sys) {
        this.sys = sys;
    }

    public void run() {
        // Set up the frame
        setTitle("Login or Register");
        setSize(200, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the buttons
        loginButton = new JButton("Log in");
        registerButton = new JButton("Register");

        // Add action listeners to the buttons
        loginButton.addActionListener(this);
        registerButton.addActionListener(this);

        // Create the panel and add the buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3, 10, 10));
        panel.add(loginButton);
        panel.add(registerButton);

        // Add the panel to the frame
        getContentPane().add(panel, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Check which button was clicked
        if (e.getSource() == loginButton) {
            // Open the login UI
            LoginForm loginUI = new LoginForm(sys);
            loginUI.run();
            dispose();
        } else if (e.getSource() == registerButton) {
            // Open the register UI
            RegisterForm registerUI = new RegisterForm(sys);
            registerUI.run();
            dispose();
        }
    }
}
