package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegisterForm extends JFrame implements ActionListener {
    private JLabel nameLabel, emailLabel, passwordLabel, userTypeLabel, sexLabel;
    private JTextField nameField, emailField;
    private JPasswordField passwordField;
    private JComboBox<String> userTypeBox;
    private JRadioButton maleButton, femaleButton;
    private ButtonGroup sexGroup;
    private JButton registerButton;

    public RegisterForm() {
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
        sexLabel = new JLabel("Sex:");

        nameField = new JTextField(20);
        emailField = new JTextField(20);
        passwordField = new JPasswordField(20);

        String[] userTypes = {"Admin", "Manager", "User"};
        userTypeBox = new JComboBox<>(userTypes);

        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");
        sexGroup = new ButtonGroup();
        sexGroup.add(maleButton);
        sexGroup.add(femaleButton);

        registerButton = new JButton("Register");

        // add action listener to button
        registerButton.addActionListener(this);

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

        // show the frame
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // get username and password from fields
        String name = nameField.getText();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        String userType = userTypeBox.getSelectedItem().toString();
        String sex = "";

        // get selected radio button's label
        if (maleButton.isSelected()) {
            sex = maleButton.getText();
        } else if (femaleButton.isSelected()) {
            sex = femaleButton.getText();
        }

        System.out.printf("name: %s email: %s password: %s userType: %s sex: %s\n", name, email, password, userType, sex);

    }
}
