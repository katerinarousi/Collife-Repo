
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuBarFinal extends JMenuBar implements ActionListener {
    JMenuBar mb;
    //Build the menu
    JMenu exit;
    JMenu settings;
    JMenu  help;
    //a group of JMenuItems
    JMenuItem colour;
    JMenuItem profile;
    JMenuItem about;
    JMenuItem logout;

    //constructor
    MenuBarFinal(JFrame frame) {
        colour = new JMenuItem("Colour");
        profile = new JMenuItem("Profile");
        about = new JMenuItem("About");
        logout = new JMenuItem("Log out");
        colour.addActionListener(this);
        profile.addActionListener(this);
        about.addActionListener(this);
        logout.addActionListener(this);

        mb=new JMenuBar();

        exit = new JMenu("Exit") ;
        settings = new JMenu("Settings");
        help = new JMenu("Help");

        exit.add(logout);
        settings.add(colour);
        settings.add(profile);
        help.add(about);

        mb.add(exit);
        mb.add(settings);
        mb.add(help);

        frame.setJMenuBar(mb);// sets the menu bar into the frame
    }
    

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logout) {
            int result = JOptionPane.showConfirmDialog(null,
                    "Do you want to log out of Collife ?", "Log out", JOptionPane.YES_NO_OPTION);
            if(result == JOptionPane.YES_OPTION){
                System.exit(0);
            }

        } else if (e.getSource() == colour) {
            Object answer = JOptionPane.showInputDialog(null,
                    "Select a colour for background",
                    "Background colour", JOptionPane.QUESTION_MESSAGE,
                    null, new String[] { "Red","Orange", "Yellow","Green","Blue","Purple (Default)" },"Purple (Default)");

            if (answer=="Green"){

				LoginFrameFinal log= new LoginFrameFinal();
            	log.container.setBackground(new Color(115, 201, 82, 197));
            	log.showPassword.setBackground(new Color(115, 201, 82, 197));
            	MenuBarFinal mb1 = new MenuBarFinal(log);
            } else if (answer=="Purple (Default)") {

				LoginFrameFinal log= new LoginFrameFinal();

            	log.container.setBackground(new Color(204,204,255));
            	log.showPassword.setBackground(new Color(204,204,255));
            	MenuBarFinal mb1 = new MenuBarFinal(log);
            	}

            //edw prepei na mpei ena if pou na allazei to background analoga to input
        }else if (e.getSource() == profile) {
            JOptionPane.showMessageDialog(null, "Account information:" + "\r\n" + "Username:" + LoginFrameFinal.username + "\r\n" + "Active status: On",
                    "About",JOptionPane.INFORMATION_MESSAGE);
        }else if (e.getSource() == about) {
            JOptionPane.showMessageDialog(null, "Developed by: Dimitra Gerontaki" +"\r\n" + " Maria Kontogiannopoulou"+ "\r\n"+ "Elina Nikolopoulou"+" Kiriaki Parastatidou"+ "\r\n" +  " Foivos Proestakis"+ "\r\n" + "Katerina Rousi"+ "\r\n" + "Zoi Spyridi" + "\r\n" +  " Alkistis Sytilidou");
        }
    }


}