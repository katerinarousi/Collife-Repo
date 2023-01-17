package PushnPop;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class MenuBarFinal extends JMenuBar implements ActionListener {

  JMenuBar mb;

  //Build the menu
  JMenu exit;
  JMenu  help;

  //a group of JMenuItems
  JMenuItem about;
  JMenuItem logout;

  //constructor
  MenuBarFinal(JFrame frame) {

    about = new JMenuItem("About");
    logout = new JMenuItem("Log out");
    about.addActionListener(this);
    logout.addActionListener(this);

    mb = new JMenuBar();
    exit = new JMenu("Exit");
    help = new JMenu("Help");

    exit.add(logout);
    help.add(about);

    mb.add(exit);
    mb.add(help);

    frame.setJMenuBar(mb); //sets the menu bar into the frame
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == logout) {
      int result = JOptionPane.showConfirmDialog(null,
                    "Do you want to log out of Collife ?", "Log out", JOptionPane.YES_NO_OPTION);
      if (result == JOptionPane.YES_OPTION)	{
        System.exit(0);
      }
    } else if (e.getSource() == about) {
      JOptionPane.showMessageDialog(null, "Developed by: Dimitra Gerontaki" + "\r\n" 
          + "Maria Kontogiannopoulou" + "\r\n" + "Elina Nikolopoulou" + "\r\n" 
          + "Kiriaki Parastatidou" + "\r\n" + "Foivos Proestakis" + "\r\n" + "Katerina Rousi"
          + "\r\n" + "Zoi Spyridi" + "\r\n" +  "Alkistis Sytilidou");
    }
  }
}
