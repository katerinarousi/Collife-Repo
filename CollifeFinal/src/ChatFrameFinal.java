import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList; // import the ArrayList classpublic class ChatFrame {

/**
 * Chat Interface
 * @author PushnPop
 * @version 1.0
 * Creates the frame that the user interacts with, using java.swing 
 * and java.awt packages
 * 
 * */
    public class ChatFrameFinal extends JFrame implements ActionListener{
       
    	String category;
        JFrame frame = new JFrame();
        JLabel chatMess1 = new JLabel("YOU ARE WRITING");
        JLabel chatMess2 = new JLabel();
        JLabel prevMess = new JLabel("PREVIOUS MESSAGES" );
        Container container = getContentPane();
        JButton sentButton = new JButton("SEND");
        JButton likeMessButton = new JButton  ("I like the message ");
        JTextArea textArea = new JTextArea(" Type your message here!");
        JButton backButton = new JButton("BACK");
        static JTextPane showMess = new JTextPane();
        ArrayList<String> messages = new ArrayList<String>();
        JScrollPane jsp = new JScrollPane(showMess, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        String username;
        ArrayList<String> nameOfButtonLike = new ArrayList<String>();
        int count=1;
        int number;
        MessageFinal m = new MessageFinal();
        
        /**
         * Constructor - calls initComponents() method
         * @param username Sets the username as stated
         * @param category Sets the category as stated
         * 
         * */
        public ChatFrameFinal(String username, String category) {
            this.username=username;
            this.category=category;
            initComponents();

        }
        
        /**
         * @param category A string that states the category that the user interacts with
         * @return number An int that corresponds at an array index starting at 0 for category "GENERAL"
         * 
         * */
        public int numbercategory (String cat) {
        	switch (cat) {
			case "GENERAL":
			   number = 0;
               break;
			case "VOLUNTEER":
			   number = 1;
               break;
			case "NIGHTLIFE":
				number = 2;
               break;
			case "TRAVEL":
				number = 3;
			   break;
			case "FOOD":
				number = 4;
               break;
            case "UNIVERSITY":
            	number = 5;
               break;
			default:
				number = -1;
		  }
        	return number;     
         }




        private void initComponents() {
            setTitle("Collife");
            setVisible(true);
            setBounds(10, 10, 370, 600);
            setLocationRelativeTo(null);
            setLayoutManager();
            setLocationAndSize();
            addComponentsToContainer();
            addActionEvent();
            setFont();
            showMess.setEditable(false);
            chatMess2.setText("IN CATEGORY: " + category);
            setBackground();
        }


        private void setFont(){
            chatMess1.setFont(new java.awt.Font("Tahoma", 0, 16));
            chatMess2.setFont(new java.awt.Font("Tahoma", 0, 16));

        }

        /**
         * sets backround color
         * @param a,b,c RGB values of chosen color
         * 
         * */
        private void setBackground(){
            container.setBackground(new Color(204,204,255));
            showMess.setBackground(new Color(204,204,255));
            textArea.setBackground(new Color(204,204,255));
            //likeMessButton.setBackground(new Color(204,204,255));
        }
        //DOKIMHHH
        public void changeBackground(){
            container.setBackground(new Color(253, 104, 104, 220));//kokkino
            container.setBackground(new Color(238, 215, 133, 210));//kitrino
            container.setBackground(new Color(239, 161, 111, 220));//portokali
            container.setBackground(new Color(115, 201, 82, 197));//prasino
            container.setBackground(new Color(60, 175, 179, 192));//blue
            container.setBackground(new Color(204,204,255));//default

        }


       /* public void setBackground(){
            container.setBackground(new Color(204,204,255));
            showMess.setBackground( new Color(204,204,255));
            textArea.setBackground( new Color(204,204,255));
            likeMessButton.setBackground(new Color(204,204,255));
      //  }*/

        public void setLayoutManager() {
            container.setLayout(null);
        }

        
        /**
         *sets location ad size of displayed boxes
         **/
        public void setLocationAndSize() {
            chatMess1.setBounds(100,-20, 300,150);
            chatMess2.setBounds(75,10, 300,150);
            sentButton.setBounds(250, 410, 80, 30);
            backButton.setBounds(250,490,80,30);
            prevMess.setBounds(100, 65, 240, 150);
            jsp.setBounds(25, 155, 300, 210);
            scroll.setBounds(25, 400, 200,50);
            likeMessButton.setBounds(25, 455, 200,20);
        }

        public void addComponentsToContainer() {
            container.add(chatMess1);
            container.add(chatMess2);
            container.add(sentButton);
            container.add(backButton);
            container.add(scroll);
            container.add(prevMess);
            container.add(jsp);
            container.add(likeMessButton);

        }

        /**
         * creates the action events that occur
         * */
        public void addActionEvent() {
        	
        	m.selectmessage(category);//displays all the messages of the category from the database using object of class MessageFinal
        	
            textArea.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    if (" Type your message here!".equals(textArea.getText())) {
                        textArea.setText("");
                    }
                }
            });
            sentButton.addActionListener(this);
            backButton.addActionListener(this);
            likeMessButton.addActionListener(this);

        }

        
        /**
         *  
         * @param e An ActionEvent object
         * 
         * **/
        public void actionPerformed(ActionEvent e) {
        	
           /**
            * if backButton is pressed, calls the new MenuFrameFinal Frame using the parameter "username"
            * */
           	if (e.getSource() == backButton) {
                new MenuBarFinal(new MenuFrameFinal(username));
                dispose();
            }

           	/**
           	 * {if sentButton is pressed, check if an Arraylist containing the messages of the category is empty}
           	 * 
           	 * */
            if (e.getSource() == sentButton) {
            	
                if( m.a.isEmpty()) {
                	
                	/* if there are no messages, add a new entry in the Arraylist (a) containing the new message*/
                	m.a.add(" "+ (MainFinal.mycounter[numbercategory(category)] + 1) + ")  "
                			 + username + ": " + textArea.getText()+ "\n"); 
                	//message consists of the identification number corresponding to the category, the username of the user and the text components
                    
                	 MainFinal.mycounter[numbercategory(category)] ++; //increases the lastEntryOnCategory array by 1 (in said category)
      
                     try {
                    	 // inserts the message in the database using the insertMessage method of class MessageFinal
						m.insertMessage(m.getID((MainFinal.mycounter[number] + 1), category), username, m.a.get(m.a.size() - 1), category);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
                     
            
                } else {

                	/*add a new entry in the Arraylist (a) containing the new message*/
                	m.a.add((MainFinal.mycounter[numbercategory(category)] + 1) +")  "+ username +": "+ textArea.getText()+ "\n");
                	//message consists of the identification number corresponding to the category, the username of the user and the text components
                	
                	MainFinal.mycounter[numbercategory(category)] ++; //increases the lastEntryOnCategory array by 1 (in said category)
                    try {
                    	// inserts the message in the database using the insertMessage method of class MessageFinal
    					m.insertMessage(m.getID((MainFinal.mycounter[number] + 1), category), username, m.a.get(m.a.size() - 1), category);
    				} catch (SQLException e1) {
    					e1.printStackTrace();
    				}
    				
                }
                showMess.setText(m.a.toString().replaceAll("[\\[\\]//,]", "")); // displays the message the user just sent
                textArea.setText("");
            }

            //realizes like feature
            if (e.getSource() == likeMessButton) {
                textArea.setText("I like the message ");
            }


        }


    }