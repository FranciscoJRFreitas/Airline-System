package UI.SignInUP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Exceptions.MissingInfoException;
import Exceptions.UserAlreadyExistsException;
import System.AirlineSystem;

public class RegisterForm extends JFrame implements ActionListener {

    private JLabel nameLabel, emailLabel, passwordLabel, userTypeLabel, sexLabel;
    private JTextField nameField, emailField;
    private JPasswordField passwordField;
    private JComboBox<String> userTypeBox;
    private JRadioButton maleButton, femaleButton;
    private ButtonGroup genderGroup;
    private JButton registerButton;
    private JButton goBackButton;
    private AirlineSystem sys;

    public RegisterForm(AirlineSystem sys) {
        this.sys = sys;

    }

    public void run() {
        setTitle("Registration Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setResizable(false);
        setLocationRelativeTo(null);

        // create components
        nameLabel = new JLabel("Name:");
        emailLabel = new JLabel("Email:");
        passwordLabel = new JLabel("Password:");
        userTypeLabel = new JLabel("Type of User:");
        sexLabel = new JLabel("Gender:");

        nameField = new JTextField(20);
        emailField = new JTextField(20);
        passwordField = new JPasswordField(20);

        String[] userTypes = {"Admin", "Manager", "User"};
        userTypeBox = new JComboBox<>(userTypes);

        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");
        goBackButton = new JButton("Go Back");
        genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);

        registerButton = new JButton("Register");

        // add action listener to button
        registerButton.addActionListener(this);
        goBackButton.addActionListener(this);

        // set layout
        setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(5, 5, 5, 5);
        add(nameLabel, c);

        c.gridx = 1;
        c.gridy = 0;
        add(nameField, c);

        c.gridx = 0;
        c.gridy = 1;
        add(emailLabel, c);

        c.gridx = 1;
        c.gridy = 1;
        add(emailField, c);

        c.gridx = 0;
        c.gridy = 2;
        add(passwordLabel, c);

        c.gridx = 1;
        c.gridy = 2;
        add(passwordField, c);

        c.gridx = 0;
        c.gridy = 3;
        add(userTypeLabel, c);

        c.gridx = 1;
        c.gridy = 3;
        add(userTypeBox, c);

        c.gridx = 0;
        c.gridy = 4;
        add(sexLabel, c);

        c.gridx = 1;
        c.gridy = 4;
        add(maleButton, c);

        c.gridx = 2;
        c.gridy = 4;
        add(femaleButton, c);

        c.gridx = 1;
        c.gridy = 5;
        c.gridwidth = 2;
        add(registerButton, c);

        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 1;
        add(goBackButton, c);

        // show the frame
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == registerButton) {
            // get username and password from fields

            String username = nameField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            String userType = userTypeBox.getSelectedItem().toString();
            String gender = "";


            // get selected radio button's label
            if (maleButton.isSelected()) {
                gender = maleButton.getText();
            } else if (femaleButton.isSelected()) {
                gender = femaleButton.getText();
            }

                try {
                    sys.addPerson(username, email, password, gender, userType);
                    JOptionPane.showMessageDialog(this, "Account created succesfully!");
                } catch (UserAlreadyExistsException | MissingInfoException er) {
                    JOptionPane.showMessageDialog(this, er.getMessage());
                }


                System.out.printf("username: %s email: %s password: %s userType: %s sex: %s\n", username, email, password, userType, gender);

            }

            if (e.getSource() == goBackButton) {
                // Open the register UI
                LoginOrRegister loginOrRegister = new LoginOrRegister(sys);
                loginOrRegister.run();
                dispose();
            }
    }

}
