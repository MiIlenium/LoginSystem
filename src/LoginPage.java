import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;

public class LoginPage implements ActionListener {
    //UI Frame
    JFrame frame = new JFrame();
    //Buttons
    JButton loginButton = new JButton("Login");
    JButton registerButton = new JButton("Register");
    //Fields to input text
    JTextField userNameField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    //Labels
    JLabel userNameLabel = new JLabel("Username:");
    JLabel userPasswordLabel = new JLabel("Password:");
    JLabel messageLable = new JLabel();

    HashMap<String, String> loginInfo;

    public LoginPage() {
        //this.loginInfo = loginCredentials;

        //set frames to the login window (x, y, width, height)
        userNameLabel.setBounds(50,100,75,25);
        userPasswordLabel.setBounds(50,150,75,25);
        userNameField.setBounds(125,100,200,25);
        userPasswordField.setBounds(125,150,200,25);
        messageLable.setBounds(125,250,1000,35);
        messageLable.setFont(new Font(null, Font.ITALIC,25));

        //set frames to the buttons (setFocusable(false) disables the frames while clicking on the button)
        loginButton.setBounds(125,200,100,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);
        registerButton.setBounds(225,200,100,25);
        registerButton.setFocusable(false);
        registerButton.addActionListener(this);

        //Adding elements to the frame
        frame.add(userNameLabel);
        frame.add(userPasswordLabel);
        frame.add(userNameField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(registerButton);
        frame.add(messageLable);

        //set frame settings (size, close on, layout and visibility)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Reads file and writes it into the hashmap
        Registration register = new Registration(userNameField.getText(), String.valueOf(userPasswordField.getPassword()));
        ReadFile rd = new ReadFile();

        //passes HashMap to constructor for validation
        ValidateUser vd = new ValidateUser(rd.HashMapFromTextFile());
        UserExistance checkExistance = new UserExistance();

        //if "register" button is clicked write user data into .txt file
        if(e.getSource() == registerButton){
            if(checkExistance.IfUserExits(userNameField.getText())){
                messageLable.setForeground(Color.red);
                messageLable.setText("User with this username already exist");
            }else{
                try {
                    register.writeToFile(userNameField.getText(), String.valueOf(userPasswordField.getPassword()));
                } catch (IOException ex) {
                }
                //output text on success
                messageLable.setForeground(Color.green);
                messageLable.setText("Register has been successful! You can login now!");
            }

        }
        //"Login" button is clicked read the .txt file and validate whether Username and Password is valid
        if(e.getSource() == loginButton){
            String userName = userNameField.getText();
            String userPassword = String.valueOf(userPasswordField.getPassword());
            if(vd.validateUserName(userName)){
                if(vd.validateUserPassword(userName, userPassword)){
                    //output text on success
                    messageLable.setForeground(Color.green);
                    messageLable.setText("You have been logged in.");
                }
            }else{
                //output text on failed
                messageLable.setForeground(Color.red);
                messageLable.setText("Username or password is incorrect. Please try again.");
            }
        }
    }
}
