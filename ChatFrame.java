//TODO o kataskevastis prepei na dexetai kai tin katigoria

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList; // import the ArrayList class


public class ChatFrame extends JFrame implements ActionListener{

	JLabel chatMess =new JLabel("YOU ARE WRITING IN CATEGORY:" );
	JLabel prevMess =new JLabel("PREVIOUS MESSAGES" );
	Container container = getContentPane();
	JButton sentButton = new JButton("SENT");
	JTextArea textArea= new JTextArea(" Type your message here!");
	JButton backButton = new JButton("BACK");
	JTextPane showMess = new JTextPane();
	ArrayList<String> messages = new ArrayList<String>();
	JScrollPane jsp = new JScrollPane(showMess, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	String username;


	public ChatFrame(String username) {
		this.username=username;
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
	    chatMess.setFont(new java.awt.Font("Tahoma", 0, 12));
	    container.setBackground(new Color(204,204,255));
	    showMess.setBackground(new Color(204,204,255));
	    showMess.setEditable(false);

	    //textArea.setLineWrap(true);
		//textArea.setWrapStyleWord(true);
		//showMess.setLineWrap(true);
		//showMess.setWrapStyleWord(true);
		//showMess.getDocument().putProperty(DefaultEditorKit.EndOfLineStringProperty, "\n");

    }

	public void setLayoutManager() {
        container.setLayout(null);
    }

	public void setLocationAndSize() {
		chatMess.setBounds(40,15, 300,150);
	 	sentButton.setBounds(240, 410, 90, 30);
	 	backButton.setBounds(240, 500, 90, 30);
	 	prevMess.setBounds(100, 65, 240, 150);
	 	jsp.setBounds(25, 155, 300, 210);
	 	scroll.setBounds(25, 400, 200,50);
	}

	public void addComponentsToContainer() {
		container.add(chatMess);
		container.add(sentButton);
		container.add(backButton);
		container.add(scroll);
		container.add(prevMess);
		container.add(jsp);

	}

	public void addActionEvent() {
		textArea.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent evt) {
		textArea.setText("");
		}
		});
		sentButton.addActionListener(this);
	 	backButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
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
		}
	}


}