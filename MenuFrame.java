import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFrame extends JFrame{


JLabel menuMess =new JLabel("SELECT A CATEGORY");
Container container = getContentPane();
JButton categoryGeneral = new JButton("GENERAL");
JButton categoryVolunteer = new JButton("VOLUNTEER");
JButton categoryNightlife = new JButton("NIGHTLIFE");
JButton categoryTravel = new JButton("TRAVEL");
JButton categoryFood = new JButton("FOOD");
JButton categoryUniversity = new JButton("UNIVERSITY");



public MenuFrame() {
	setTitle("Collife");
	setVisible(true);
	setBounds(10, 10, 370, 600);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(true);
	setLayoutManager();
	setLocationAndSize();
	addComponentsToContainer();
    //addActionEvent();

}

public void setLayoutManager() {
        container.setLayout(null);

    }

public void setLocationAndSize() {
	menuMess.setBounds(100,50, 150,15);
	categoryGeneral.setBounds(100, 150, 150, 30);
	categoryVolunteer.setBounds(100, 200, 150, 30);
	categoryNightlife.setBounds(100, 250, 150, 30);
	categoryTravel.setBounds(100, 300, 150, 30);
 	categoryFood.setBounds(100, 350, 150, 30);
 	categoryUniversity.setBounds(100, 400, 150, 30);
	}

	public void addComponentsToContainer() {
		container.add(menuMess);
		container.add(categoryGeneral);
		container.add(categoryVolunteer);
		container.add(categoryNightlife);
		container.add(categoryTravel);
		container.add(categoryFood);
		container.add(categoryUniversity);
		}



}