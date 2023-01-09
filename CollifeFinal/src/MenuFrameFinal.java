
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Menu Interface
 * @author PushnPop
 * @version 1.0
 * Creates the frame that the user interacts with, using java.swing 
 * and java.awt packages
 * 
 * */
public class MenuFrameFinal extends JFrame implements ActionListener {
    
	private static final long serialVersionUID = 1L;
	JLabel menuMess =new JLabel("SELECT A CATEGORY");
    Container container = getContentPane();

    JButton categoryGeneral = new JButton("GENERAL");
    JButton categoryVolunteer = new JButton("VOLUNTEER");
    JButton categoryNightlife = new JButton("NIGHTLIFE");
    JButton categoryTravel = new JButton("TRAVEL");
    JButton categoryFood = new JButton("FOOD");
    String uni[]={"UNIVERSITY  (OTHER)","AUEB","UOA","NTUA","UNIPI"};
    JComboBox categoryUniversity =new JComboBox(uni);
    JButton backButton = new JButton("BACK");
    JLabel picLabel = new JLabel(new ImageIcon("collige_logo.png"));

    String username;

   /**
    * Constructor - calls initComponents() method
    * 
    * */
    public MenuFrameFinal(String username) {
        this.username=username;
        initComponents();
    }

    private void initComponents() {
        setTitle("Collife");
        setVisible(true);
        setBounds(10, 10, 370, 600);
        setLocationRelativeTo(null); //centers the application window
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        setFont();
        setBackground(204,204,255);

    }

    void setLayoutManager() {
        container.setLayout(null);
    }

    
    void setFont(){
        menuMess.setFont(new Font("Tahoma", 0, 16));
    }

    /**
     * sets backround color
     * @param a,b,c RGB values of chosen color
     * 
     * */
    void setBackground(int a, int b, int c){
        container.setBackground(new Color(204,204,255));
    }

    /**
     * sets location ad size of displayed boxes
     **/
    void setLocationAndSize() {
        menuMess.setBounds(100,50, 200,150);
        categoryGeneral.setBounds(100, 150, 150, 30);
        categoryVolunteer.setBounds(100, 200, 150, 30);
        categoryNightlife.setBounds(100, 250, 150, 30);
        categoryTravel.setBounds(100, 300, 150, 30);
        categoryFood.setBounds(100, 350, 150, 30);
        categoryUniversity.setBounds(100, 400, 150, 30);
        backButton.setBounds(250,490,80,30);
        picLabel.setBounds(100,10, 150,90);
    }

    void addComponentsToContainer() {
        container.add(menuMess);
        container.add(categoryGeneral);
        container.add(categoryVolunteer);
        container.add(categoryNightlife);
        container.add(categoryTravel);
        container.add(categoryFood);
        container.add(categoryUniversity);
        container.add(backButton);
        container.add(picLabel);
    }

    
    /**
     * creates the action events that occur
     * */
    void addActionEvent() {
        backButton.addActionListener(this);
        categoryGeneral.addActionListener(this);
        categoryVolunteer.addActionListener(this);
        categoryNightlife.addActionListener(this);
        categoryTravel.addActionListener(this);
        categoryFood.addActionListener(this);
        categoryUniversity.addActionListener(this);
    }

    /**
     * calls the new ChatFrameFinal frame according to given parameters "username" and "category" 
     * @param e An ActionEvent object
     * 
     * **/
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            MenuBarFinal mb1 = new MenuBarFinal(new LoginFrameFinal());
            dispose();
        }

        if (e.getSource() == categoryGeneral) {
            //new ChatFrame(username, "GENERAL");
            new MenuBarFinal(new ChatFrameFinal(username, "GENERAL"));
        } else if (e.getSource()==categoryVolunteer) {
            new MenuBarFinal(new ChatFrameFinal(username, "VOLUNTEER"));
        } else if (e.getSource()==categoryNightlife) {
            new MenuBarFinal(new ChatFrameFinal(username, "NIGHTLIFE"));
        } else if (e.getSource()==categoryTravel) {
            new MenuBarFinal(new ChatFrameFinal(username, "TRAVEL"));
        } else if (e.getSource()==categoryFood) {
            new MenuBarFinal(new ChatFrameFinal(username, "FOOD"));
        } else if (e.getSource()==categoryUniversity) {
            new MenuBarFinal(new ChatFrameFinal(username, "UNIVERSITY"));
        }
        dispose();



    }


}