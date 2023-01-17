package PushnPop;

import java.sql.SQLException;

import javax.swing.*;

/**
 * @author PushnPop
 * @version 1.0
 * @throws SQLException
 * the main class through witch the program runs 
 *
 */

public class MainFinal {

  /**
  * initializes array of 6.  
  * */
  static int[] mycounter = {1, 1, 1, 1, 1, 1};

  public static void main(String[] args) throws SQLException {
    /*fills the static array "mycounter" with the last entry for each category using MessageFinal's
    getLastRows() method*/
	
    mycounter = MessageFinal.getLastRows();

    //creates the first frame of interface calling the GUI classes
    MenuBarFinal mb1 = new MenuBarFinal(new LoginFrameFinal());

  }
}
