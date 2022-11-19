import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class ChatFrame extends JFrame implements ActionListener{

	JLabel chatMess =new JLabel("WRITE YOUR IDEAS IN CATEGORY:" );
	JLabel prevMess =new JLabel("PREVIOUS MESSAGES" );
	Container container = getContentPane();
	JButton sentButton = new JButton("SENT");
	JTextArea textArea= new JTextArea(" Type your message here!");
	JButton backButton = new JButton("BACK");
	JTextPane showMess = new JTextPane();

	public ChatFrame() {
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
	    chatMess.setFont(new java.awt.Font("Tahoma", 0, 16));
	    container.setBackground(new Color(204,204,255));
	    //showMess.setBackground(new Color(204,204,255));
	    showMess.setEditable(false);
	    textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		//showMess.setLineWrap(true);
		//showMess.setWrapStyleWord(true);
    }

	public void setLayoutManager() {
        container.setLayout(null);
    }

	public void setLocationAndSize() {
		chatMess.setBounds(40,15, 300,150);
		textArea.setBounds(25, 400, 200,50);
	 	sentButton.setBounds(240, 410, 90, 30);
	 	backButton.setBounds(240, 500, 90, 30);
	 	prevMess.setBounds(100, 65, 240, 150);
	 	showMess.setBounds(25, 155, 300, 210);
	}

	public void addComponentsToContainer() {
		container.add(chatMess);
		container.add(sentButton);
		container.add(backButton);
		container.add(textArea);
		container.add(prevMess);
		container.add(showMess);
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
			 new MenuFrame();
			 dispose();
		}
		if (e.getSource() == sentButton)
			showMess.setText(": " + textArea.getText());
	}
}