package PushnPop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Login Interface
 * 
 * @author PushnPop
 * 
 * @version 1.0
 * {Creates the frame that the user interacts with, using java.swing 
 *  and java.awt packages}
 *
 */
public class LoginFrameFinal extends JFrame implements ActionListener {
    
  static String username;	
  JFrame frm = new JFrame("COLLIFE");
  JLabel welcomeMess = new JLabel("WELCOME TO COLLIFE :)");
  Container container = getContentPane();
  JLabel userLabel = new JLabel("USERNAME:");
  JLabel passwordLabel = new JLabel("PASSWORD:");
  JTextField userTextField = new JTextField(" e.g. Username");
  JPasswordField passwordField = new JPasswordField();
  JButton loginButton = new JButton("LOGIN");
  JButton signinButton = new JButton("SIGN UP");
  JCheckBox showPassword = new JCheckBox("Show Password");
  JLabel picLabel = new JLabel(new ImageIcon("collige_logo.png"));
  JMenuBar mb = new JMenuBar();

  /**
    * Constructor - calls initComponents() method
  * */
  LoginFrameFinal() {
    initComponents();
  }
    
    /**
     * initializes objects of classes LoginFinal and SignInFinal
     * */
  LoginFinal l = new LoginFinal();
  SignInFinal s = new SignInFinal();

  private void initComponents() {
    setTitle("Collife");
    setBounds(10, 10, 370, 600);
    frm.setJMenuBar(mb);

    setLocationRelativeTo(null); // center the application window
    setVisible(true);
    setLayoutManager();
    setLocationAndSize();
    addComponentsToContainer();
    addActionEvent();
    setBackground(204, 204, 255);
    setFont();
  }

  public void setLayoutManager() {
    container.setLayout(null);
  }

  private void setBackground(int a, int b, int c) {
    container.setBackground(new Color(a, b, c));
    showPassword.setBackground(new Color(a, b, c));
  }

  private void setFont() {
    welcomeMess.setFont(new Font("Tahoma", 0, 16));
  }

  public void setLocationAndSize() {
    userLabel.setBounds(50, 150, 100, 30);
    passwordLabel.setBounds(50, 220, 100, 30);
    userTextField.setBounds(150, 150, 150, 30);
    passwordField.setBounds(150, 220, 150, 30);
    showPassword.setBounds(150, 250, 150, 30);
    loginButton.setBounds(50, 300, 100, 30);
    signinButton.setBounds(200, 300, 100, 30);
    welcomeMess.setBounds(90, 50, 200, 150);
    picLabel.setBounds(100, 10, 150, 90);
  }

  public void addComponentsToContainer() {
    container.add(userLabel);
    container.add(welcomeMess);
    container.add(passwordLabel);
    container.add(userTextField);
    container.add(passwordField);
    container.add(showPassword);
    container.add(loginButton);
    container.add(signinButton);
    container.add(picLabel);
  }

/**
     * creates the action events that occur
     * 
     * */
  public void addActionEvent() {
    loginButton.addActionListener(this);
    signinButton.addActionListener(this);
    showPassword.addActionListener(this);
    userTextField.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent evt) {
        userTextField.setText("");
      }
    });
  }


    /**
     * calls LoginFinal and realizes the Login of the user.
     * @param e An ActionEvent object
     *
     * */
  @Override
    public void actionPerformed(ActionEvent e) {
       
    //when loginButton is pressed
    if (e.getSource() == loginButton) {  
        	
      boolean check = l.logTheUser(userTextField, passwordField);	
      username = userTextField.getText();
      if (check) {
        new MenuBarFinal(new MenuFrameFinal(username)); //creates the new frame
        dispose(); // disposes of the previous frame
      }
    }
        
    //when signinButton is pressed
    if (e.getSource() == signinButton) {
      s.signTheUser(userTextField, passwordField);
         
    }
    //when showPassword JCheckBox is clicked
    if (e.getSource() == showPassword) {
      if (showPassword.isSelected()) {
        passwordField.setEchoChar((char) 0);
      } else {
        passwordField.setEchoChar('*');
      }
    }
  }
}
