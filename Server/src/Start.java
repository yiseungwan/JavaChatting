import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Start extends Main {
	private JTextArea textArea;
	private JPanel panel1;
	private JPanel panel2;
	public Start() {
		setTitle("[ä�� ����]");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		
		c.add(panel1, BorderLayout.CENTER);
		
		panel1.setLayout(new BorderLayout());
		panel1.add(scrollPane, BorderLayout.CENTER);  // JTextArea�� �߰��Ͽ� ��üȭ������ ����
		panel1.setPreferredSize(new Dimension(this.getWidth(), 150));  // panel�� heigth�� ����
		
		c.add(panel2, BorderLayout.SOUTH);
		panel2.setBackground(Color.LIGHT_GRAY);
		panel2.setPreferredSize(new Dimension(this.getWidth(), 50));  // panel�� heigth�� ����
		
		// ���� ���� ��ư ����
		JButton tb = new JButton("���� ����");
		panel2.add(tb);
		
		tb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tb.getText().equals("���� ����")) {
					startServer(IP, port);
					tb.setText("���� �ݱ�");
					textArea.append("[���� ����]\n");
				}
				else {
					stopServer();
					tb.setText("���� ����");
					textArea.append("[���� ����]\n");
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
