 
import javax.swing.*;



import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginFrame extends JFrame implements ActionListener {

    Connection conn= null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
       
    
    public LoginFrame() {
    	initComponents();
    	conn = SQLiteConnection.ConnectDb();
    	
    }
    
	JFrame frm = new JFrame("COLLIFE");
	JLabel welcomeMess =new JLabel("WELCOME TO COLLIFE :)");
    Container container = getContentPane();
    JLabel userLabel = new JLabel("USERNAME:");
    JLabel passwordLabel = new JLabel("PASSWORD:");
    JTextField userTextField = new JTextField(" e.g. Username");
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton signinButton = new JButton("SIGN UP");
    JCheckBox showPassword = new JCheckBox("Show Password");
	JLabel picLabel = new JLabel(new ImageIcon("collige_logo.png"));

  	

     private void initComponents() {
		setTitle("Collife");
		setBounds(10, 10, 370, 600);
		setLocationRelativeTo(null); // center the application window
		setVisible(true);
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
		setBackground();
        setFont();
        }

    public void setLayoutManager() {
	    container.setLayout(null);
    }


    private void setBackground(){
		container.setBackground(new Color(204,204,255));
		showPassword.setBackground(new Color(204, 204, 255));
	}

    private void setFont(){
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
        welcomeMess.setBounds(90,50, 200,150);
        picLabel.setBounds(100,10, 150,90);
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

    public void addActionEvent() {
        loginButton.addActionListener(this);
        signinButton.addActionListener(this);
        showPassword.addActionListener(this);
        userTextField .addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent evt) {
		userTextField .setText("");
		}
		});
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource() == loginButton) {
          
           
           
            	
            	String sql = "SELECT * from Users WHERE username LIKE ? AND password LIKE ?; ";
            	
            	try {
            		pst = conn.prepareStatement(sql);
                	pst.setString(1, userTextField.getText());
                	pst.setString(2, passwordField.getText());
            		
                	rs=pst.executeQuery();
                	
                	if(rs.next()) {
                		JOptionPane.showMessageDialog(null,"LOGIN SUCCESSFULL");
                		new MenuFrame(userTextField.getText());
                        dispose();
                        //JOptionPane.showMessageDialog(this, "Login Successful");
                	} else {
                		JOptionPane.showMessageDialog(null, "Invalid Username or Password. Try again!");
                	}
                	pst.close();
                	rs.close();
            		
            	} catch (Exception e1) {
            		
            	}
            	
         
        }
        //Coding Part of SIGN IN button
        if (e.getSource() == signinButton) {
           
        
      //INSERT TO DATABASE//
    	
        String sql = "INSERT INTO Users(username,password) VALUES (?,?)";
        
        try {
        	pst = conn.prepareStatement(sql);
        	pst.setString(1, userTextField.getText());
        	pst.setString(2, passwordField.getText());
        	
        	pst.execute();
        	
      // CHECK IF USERNAME ALREADY EXISTS //
        	
        	
        	
        	
        	    if (CheckUsernameExists.CheckIfExists(userTextField.getText()) == true) {
        		    JOptionPane.showMessageDialog(null, "Username already exists! Try again!");	
        	    }
        	
        	
      // VALIDATE USERNAME USING REGULAR EXPRESSION //	
        	
        	
        	if (userTextField.getText() != null) {
        		if (ValidateUsername.isValidUsername(userTextField.getText()) == false) {
            		JOptionPane.showMessageDialog(null, "Username invalid");
            	}            	
        	}
        	
        	JOptionPane.showMessageDialog(null, "Registration successfull");
        	
        	
        	pst.close();
        		
        	
        }catch (Exception e1){
        	JOptionPane.showMessageDialog(null, e1);
        	System.out.println("Registration NOT");
        	
        }
        userTextField.setText("");
        passwordField.setText("");
        
       
        }
       //Coding Part of showPassword JCheckBox
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
    	}
	}
}
