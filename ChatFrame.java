import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList; // import the ArrayList classpublic class ChatFrame {

    public class ChatFrame extends JFrame implements ActionListener{
        String category;
        JFrame frame =new JFrame();
        //MenuBar bar = new MenuBar();
        JLabel chatMess1 =new JLabel("YOU ARE WRITING");
        JLabel chatMess2 =new JLabel();
        JLabel prevMess =new JLabel("PREVIOUS MESSAGES" );
        Container container = getContentPane();
        JButton sentButton = new JButton("SEND");
        JButton   likeMessButton = new JButton  ("I like the message ");
        JTextArea textArea= new JTextArea(" Type your message here!");
        JButton backButton = new JButton("BACK");
        JTextPane showMess = new JTextPane();
        ArrayList<String> messages = new ArrayList<String>();
        JScrollPane jsp = new JScrollPane(showMess, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        String username;
        ArrayList<String> nameOfButtonLike = new ArrayList<String>();
        int count=1;



        public ChatFrame(String username, String category) {
            this.username=username;
            this.category=category;
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
            showMess.setEditable(false);
            chatMess2.setText("IN CATEGORY: " + category);
            setBackground();
        }


        private void setFont(){
            chatMess1.setFont(new java.awt.Font("Tahoma", 0, 16));
            chatMess2.setFont(new java.awt.Font("Tahoma", 0, 16));

        }

        private void setBackground(){
            container.setBackground(new Color(204,204,255));
            showMess.setBackground(new Color(204,204,255));
            textArea.setBackground(new Color(204,204,255));
            //likeMessButton.setBackground(new Color(204,204,255));
        }
        //DOKIMHHH
       // public void changeBackground(){
            //container.setBackground(new Color(253, 104, 104, 220));//kokkino
           // container.setBackground(new Color(238, 215, 133, 210));//kitrino
          //  container.setBackground(new Color(239, 161, 111, 220));//portokali
            //container.setBackground(new Color(115, 201, 82, 197));//prasino
           // container.setBackground(new Color(60, 175, 179, 192));//blue
           // container.setBackground(new Color(204,204,255));//default

      //  }


       /* public void setBackground(){
            container.setBackground(new Color(204,204,255));
            showMess.setBackground( new Color(204,204,255));
            textArea.setBackground( new Color(204,204,255));
            //likeMessButton.setBackground(new Color(204,204,255));*/
      //  }

        public void setLayoutManager() {
            container.setLayout(null);
        }

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
            likeMessButton.addActionListener(this);

        }



        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == backButton) {
               // new MenuFrame(username);
                new MenuBar(new MenuFrame(username));
                dispose();
            }

            if (e.getSource() == sentButton) {
                if( messages.isEmpty()){
                    messages.add(" "+ count +")  "+ username + ": " + textArea.getText()+ "\n");
                    count++;
                } else {
                    messages.add(count +")  "+username +": "+ textArea.getText()+ "\n");
                    count++;
                }
                showMess.setText(messages.toString().replaceAll("[\\[\\]//,]", ""));
                textArea.setText("");
            }

            if (e.getSource() == likeMessButton) {
                textArea.setText("I like the message ");
            }


        }


    }