
//TODO o kataskevastis prepei na dexetai kai tin katigoria

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList; // import the ArrayList class


public class ChatFrame extends JFrame implements ActionListener{
	String category;
	JLabel chatMess1 =new JLabel("YOU ARE WRITING");
	JLabel chatMess2 =new JLabel();
	JLabel prevMess =new JLabel("PREVIOUS MESSAGES" );
	Container container = getContentPane();
	JButton sentButton = new JButton("SENT");
	JTextArea textArea= new JTextArea(" Type your message here!");
	JButton backButton = new JButton("BACK");
	JTextPane showMess = new JTextPane();
	ArrayList<String> messages = new ArrayList<String>();
	JScrollPane jsp = new JScrollPane(showMess, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	String username;
	ArrayList<String> nameOfButtonLike = new ArrayList<String>();



	public ChatFrame(String username, String category) {
		this.username=username;
		this.category=category;
		initComponents();
	}

	private void initComponents() {
		setTitle("Collife");
		setVisible(true);
		setBounds(10, 10, 370, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setResizable(true);
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
	    addActionEvent();
	    chatMess1.setFont(new java.awt.Font("Tahoma", 0, 16));
	    chatMess2.setFont(new java.awt.Font("Tahoma", 0, 16));
	    container.setBackground(new Color(204,204,255));
	    showMess.setBackground(new Color(204,204,255));
	    textArea.setBackground(new Color(204,204,255));
	    showMess.setEditable(false);

	    chatMess2.setText("IN CATEGORY: " + category);

	    //textArea.setLineWrap(true);
		//textArea.setWrapStyleWord(true);
		//showMess.setLineWrap(true);
		//showMess.setWrapStyleWord(true);
		//scroll.getDocument().putProperty(DefaultEditorKit.EndOfLineStringProperty, "\n");

    }

	public void setLayoutManager() {
        container.setLayout(null);
    }

	public void setLocationAndSize() {
		chatMess1.setBounds(75,-20, 300,150);
		chatMess2.setBounds(75,10, 300,150);
	 	sentButton.setBounds(250, 410, 80, 30);
	 	backButton.setBounds(250,470,80,30);
	 	prevMess.setBounds(100, 65, 240, 150);
	 	jsp.setBounds(25, 155, 300, 210);
	 	scroll.setBounds(25, 400, 200,100);
	}

	public void addComponentsToContainer() {
		container.add(chatMess1);
		container.add(chatMess2);
		container.add(sentButton);
		container.add(backButton);
		container.add(scroll);
		container.add(prevMess);
		container.add(jsp);

	}

	public void addActionEvent() {
		textArea.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent evt) {
			if (" Type your message here!".equals(textArea.getText())) {
				textArea.setText("");
			}
		}
		});
		sentButton.addActionListener(this);
	 	backButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		int count=0;

		if (e.getSource() == backButton) {
			 new MenuFrame(username);
			 dispose();
		}

		if (e.getSource() == sentButton) {
			if( messages.isEmpty()){
				messages.add("  "+ username + ": " + textArea.getText()+ "\n");
			}else {
				messages.add( " "+username +": "+ textArea.getText()+ "\n");
			}
			showMess.setText(messages.toString().replaceAll("[\\[\\]//,]", ""));
			textArea.setText("");





			/*count++;
			nameOfButtonLike.add("likeButton" + count);
			String bLike=nameOfButtonLike.get(count);
			JButton bLike = new JButton("like");
			container.add(bLike);
			bLike.setBounds(25, 155+count*5, 300, 210); */


		}
	}


}
