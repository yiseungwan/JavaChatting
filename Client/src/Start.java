import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Start extends Main {
	public Start() {
		setTitle("[채팅 클라이언트]");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		JTextField userName = new JTextField("대화명");
		userName.setSize(150, 30);
		
		JTextField IPText = new JTextField("127.0.0.1");
		JTextField portText = new JTextField("9876");
		portText.setSize(80, 30);

		JPanel panel1 = new JPanel(new BorderLayout());
		c.add(panel1, BorderLayout.NORTH);
		panel1.add(userName, BorderLayout.WEST);
		panel1.add(IPText, BorderLayout.CENTER);
		panel1.add(portText, BorderLayout.EAST);
		
//		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		c.add(textArea, BorderLayout.CENTER);
		
		JTextField input = new JTextField();
		input.setEnabled(false);
		input.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				send(userName.getText() + ": " + input.getText() + "\n");
				input.setText("");
				input.requestFocus();
			}			
		});
		
		JButton sendButton = new JButton("보내기");
		sendButton.setEnabled(false);
		
		sendButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				send(userName.getText() + ": " + input.getText() + "\n");
				input.setText("");
				input.requestFocus();
			}
		});
		
		JButton connectionButton = new JButton("접속하기");
		connectionButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(connectionButton.getText().equals("접속하기")) {
					int port = 9876;
					try {
						port = Integer.parseInt(portText.getText());
					} catch(Exception e2) {
						e2.printStackTrace();
					}
					startClient(IPText.getText(), port);
					textArea.append("[ 채팅방 접속 ]\n");
					connectionButton.setText("종료하기");
					input.setEnabled(true);
					sendButton.setEnabled(true);
					input.requestFocus();
				} else {
					stopClient();
					textArea.append("[ 채팅방 퇴장 ]\n");
					connectionButton.setText("접속하기");
					input.setEnabled(false);
					sendButton.setEnabled(false);
				}
			}
		});
		JPanel panel2 = new JPanel(new BorderLayout());
		c.add(panel2, BorderLayout.SOUTH);
		panel2.add(connectionButton, BorderLayout.WEST);
		panel2.add(input, BorderLayout.CENTER);
		panel2.add(sendButton, BorderLayout.EAST);
		
		setVisible(true);
		setSize(300, 300);
	}
}