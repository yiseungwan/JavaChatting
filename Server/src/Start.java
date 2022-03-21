import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Start extends Main {
	private JTextArea textArea;
	private JPanel panel1;
	private JPanel panel2;
	public Start() {
		setTitle("[채팅 서버]");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		
		c.add(panel1, BorderLayout.CENTER);
		
		panel1.setLayout(new BorderLayout());
		panel1.add(scrollPane, BorderLayout.CENTER);  // JTextArea를 추가하여 전체화면으로 설정
		panel1.setPreferredSize(new Dimension(this.getWidth(), 150));  // panel의 heigth갑 설정
		
		c.add(panel2, BorderLayout.SOUTH);
		panel2.setBackground(Color.LIGHT_GRAY);
		panel2.setPreferredSize(new Dimension(this.getWidth(), 50));  // panel의 heigth갑 설정
		
		// 서버 여는 버튼 생성
		JButton tb = new JButton("서버 시작");
		panel2.add(tb);
		
		tb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tb.getText().equals("서버 시작")) {
					startServer(IP, port);
					tb.setText("서버 닫기");
					textArea.append("[서버 시작]\n");
				}
				else {
					stopServer();
					tb.setText("서버 시작");
					textArea.append("[서버 종료]\n");
				}
			}
		});
		
		setSize(500, 500);
		setVisible(true);
		
	}		
	
	public static void main(String [] args) {
		new Start();
	}

}
