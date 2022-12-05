import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFrame extends JFrame implements ActionListener{

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

	public MenuFrame(String username) {
		this.username=username;
		initComponents();
	}

	private void initComponents() {
		setTitle("Collife");
		setVisible(true);
		setBounds(10, 10, 370, 600);
		setLocationRelativeTo(null);// center the application window
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
    	addActionEvent();
    	setFont();
    	setBackground();

    }

	public void setLayoutManager() {
        container.setLayout(null);
    }


    private void setFont(){
    	menuMess.setFont(new java.awt.Font("Tahoma", 0, 16));
	}

	private void setBackground(){
		container.setBackground(new Color(204,204,255));
	}

	public void setLocationAndSize() {
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

	public void addComponentsToContainer() {
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

	public void addActionEvent() {
	 	backButton.addActionListener(this);
	 	categoryGeneral.addActionListener(this);
	 	categoryVolunteer.addActionListener(this);
	 	categoryNightlife.addActionListener(this);
	 	categoryTravel.addActionListener(this);
	 	categoryFood.addActionListener(this);
	 	categoryUniversity.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == backButton) {
			 new LoginFrame();
			 dispose();
		}

		if (e.getSource()==categoryGeneral) {
			new ChatFrame(username, "GENERAL");
		} else if (e.getSource()==categoryVolunteer) {
			new ChatFrame(username, "VOLUNTEER");
		} else if (e.getSource()==categoryNightlife) {
				new ChatFrame(username, "NIGHTLIFE");
		} else if (e.getSource()==categoryTravel) {
				new ChatFrame(username, "TRAVEL");
		} else if (e.getSource()==categoryFood) {
				new ChatFrame(username, "FOOD");
		} else if (e.getSource()==categoryUniversity) {
				new ChatFrame(username, "UNIVERSITY");
		}
			dispose();



	}
}