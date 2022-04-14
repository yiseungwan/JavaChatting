import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.io.*;
import java.util.*;
import java.net.*;

public class Main extends JFrame {
	
	Socket socket;
	JPanel contentPane;
	JPanel panel_1 = new JPanel();
	JTextArea textArea;
	JTextArea userArea;
	JScrollPane scrollPane;
	JLabel userName = new JLabel("userName");
	String IPText = "127.0.0.1";
	int port = 9876;
	String InputNickName;
	String UserList = "";
	
	// 클라이언트 프로그램의 작동을 시작하는 메소드
	public void startClient(String IP, int port) {
		Thread thread = new Thread() {
			public void run() {
				try {
					socket = new Socket(IP, port);
					receive();
				} catch (Exception e) {
					if(!socket.isClosed()) {
						stopClient();
						System.out.println("[서버 접속 실패]");
					}
				}
			}
		};
		thread.start();
	}
	
	// 클라이언트 프로그램의 작동을 종료하는 메소드
	public void stopClient() {
		try {
			if(socket != null && !socket.isClosed()) {
				socket.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 서버로부터 메세지를 전달받는 메소드
	public void receive() {
		while(true) {
			try {
				InputStream in = socket.getInputStream();
				byte[] buffer = new byte[512];
				int length = in.read(buffer);
				if(length == -1) throw new IOException();
				String message = new String(buffer, 0, length, "UTF-8");
				// messageContent는 사용자:채팅내용▒사용자리스트  에서 사용자:채팅내용 을 의미함. textArea에 append해주는 항목
				String messageContent = message.split("▒")[0];
				// userArea 초기화. 초기화하지 않으면 기존에 있는 userArea에 새로운 userArea가 계속 append되서 알아볼 수 없음
				userArea.setText("");
				// userArea에 사용자 명단을 append
				userArea.append(message.split("▒")[1]);
				// textArea에 대화 내용을 append
				textArea.append(messageContent);
				
				scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
				
			} catch (Exception e) {
				stopClient();
				break;
			}
		}
	}
	
	// 서버로 메세지를 전송하는 메소드
	public void send(String message) {
		Thread thread = new Thread() {
			public void run() {
				try {
					OutputStream out = socket.getOutputStream();
					byte[] buffer = message.getBytes("UTF-8");
					out.write(buffer);
					out.flush();
				} catch (Exception e) {
					stopClient();
				}
			}
		};
		thread.start();
	}
	
	// 대화명 설정
	public void setName() {
		InputNickName = JOptionPane.showInputDialog("대화명을 입력하세요.");
		while(true) {
			if(InputNickName == null) {
				stopClient();
			}
			if(!InputNickName.equals("")) {
				userName.setText(InputNickName);
				userName.setEnabled(false);
				break;
			}
			else {
				JOptionPane.showMessageDialog(null, "대화명을 입력하세요.", "잘못된 대화명입니다.", JOptionPane.ERROR_MESSAGE);
				InputNickName = JOptionPane.showInputDialog("대화명을 입력하세요.");
			}
		}
	}
	
	public Main() {
		setName();
		startClient(IPText, port);
		
		setTitle("[채팅 클라이언트]");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 435, 35);
		contentPane.add(panel);
		panel.setLayout(null);
		
		userName.setForeground(Color.black);
		userName.setBackground(Color.white);
		userName.setEnabled(false);
		userName.setBounds(0, 0, 435, 35);
		panel.add(userName);
		
		JLabel userList = new JLabel("userList");
		userList.setEnabled(false);
		userList.setBounds(345, 0, 90, 35);
		panel.add(userList);
		panel_1.setBounds(0, 35, 345, 190);
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout());
		
		textArea = new JTextArea();
		textArea.setEnabled(true);
		textArea.setEditable(true);
		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(345, 35, 90, 190);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		userArea = new JTextArea();
		userArea.setBounds(0, 0, 90, 190);
		panel_2.add(userArea);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 225, 435, 35);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JTextField input = new JTextField();
		input.setBounds(0, 0, 350, 35);
		
		panel_3.add(input);
		input.setColumns(10);
		input.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField)e.getSource();
				send(userName.getText() + " : " + t.getText() + "\n");
				input.setText("");
				input.requestFocus();
			}
		});

		JButton btnSend = new JButton("전송");
		btnSend.setBounds(345, 0, 90, 35);
		btnSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				send(userName.getText() + " : " + input.getText() + "\n");
				input.setText("");
				input.requestFocus();
			}
		});
		panel_3.add(btnSend);
	}
	
	public static void main(String [] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
