package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginForm extends JFrame implements ActionListener {
    private JLabel usernameLabel, passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginForm() {
        setTitle("Login Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setResizable(false);
        setLocationRelativeTo(null);

        // create components
        usernameLabel = new JLabel("          Username:");
        passwordLabel = new JLabel("          Password:");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");

        // set layout
        setLayout(new GridLayout(3, 2));

        // add components
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(new JLabel(""));
        add(loginButton);

        // add action listener to button
        loginButton.addActionListener(this);

        // show the frame
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
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
}
