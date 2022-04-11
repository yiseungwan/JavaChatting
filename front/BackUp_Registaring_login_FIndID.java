/*package com.chat.front;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import com.chat.connect.Member;



public class BackUp_Registaring_login_FIndID extends JButton{

	private JFrame frame;
	private JTextField inputName;
	private JPasswordField inputPassword;
	private JTextField inputID;
	private final Action action = new SwingAction();
	private JButton btn_SignUp;
	private JLabel ID;
	private JLabel Name;
	private JLabel Password;
	private JPanel LogPanel;
	private JButton toSignUp;
	private JPanel LoginPanel;
	private JPanel Lpanel;
	private JButton btn_toRegistration;
	private JLabel login_text;
	private JTextField Login_inputId;
	private JLabel Login_Pass;
	private JPasswordField Login_inputPass;
	private JButton btn_login;
	private JPanel Find_Idpanel;
	private JLabel id_find;
	private JButton btn_toFindId;
	private JLabel output_idText;
	private JTextField textField;
	private JLabel outPut_id;
	private JLabel BacktoLogin_1;
	private JButton btn_backToLoging;
	private JLabel output_id;

	*//**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					BackUp_Registaring_login_FIndID window = new BackUp_Registaring_login_FIndID();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BackUp_Registaring_login_FIndID() {
		initialize();
		frame.setLocationRelativeTo(null);//����� �߾ӿ� ��ġ
		
	}

	*//**
	 * Initialize the contents of the frame.
	 *//*
	private void initialize() {
		
		//----------------------------WindowBuilder�� ���� form����----------------------------
		frame = new JFrame();
		frame.setTitle("\uD68C\uC6D0\uAC00\uC785");
		frame.setPreferredSize(new Dimension(500, 800));
		frame.setSize(500, 800);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//================================================================�г�========================================================================
		JPanel SignUpPanel = new JPanel();	//ȸ������ �г�
		Member member = new Member();	//MemberŬ�������� ������ DB���� ������ ��ü�� ����� ���������� �����ϱ� ���� ����
		LoginPanel = new JPanel();		//�α��� �г�
		
		//backgraound 1���
		File f =new File("./image/Background.jpg");	//background �̹����� ������ ���� ���� �ҷ���
		System.out.println(f.exists()?"Exists":"doesnt exist");	//���� ���翩�� Ȯ��
		frame.pack();	//pack()�޼���-> "JFrame" �� ���빰�� �˸°� ������ ũ�⸦ ����
		//DB���� �ҷ��� ������ ����Ʈ��ü ����
		ArrayList<String> DBdata = Member.getRegistrationMember();
		frame.getContentPane().setLayout(null);
		Find_Idpanel = new JPanel();	//���̵� ã�� �г�
		
		
		//----------------------------------���̵� ã�� ���------------------------
		Find_Idpanel.setBackground(Color.WHITE);
		Find_Idpanel.setBounds(0, 0, 497, 763);
		frame.getContentPane().add(Find_Idpanel);
		Find_Idpanel.setLayout(null);
		Find_Idpanel.setVisible(false);
		
		id_find = new JLabel("\uC774\uB984\uC744 \uC785\uB825\uD558\uC138\uC694!");
		id_find.setForeground(SystemColor.activeCaptionBorder);
		id_find.setFont(new Font("�޸յձ�������", Font.PLAIN, 20));
		id_find.setBackground(SystemColor.activeCaptionBorder);
		id_find.setBounds(107, 212, 206, 39);
		Find_Idpanel.add(id_find);
		
		btn_backToLoging = new JButton("");
		btn_backToLoging.setIcon(new ImageIcon("C:\\Users\\hijic\\Desktop\\eclipseSave\\MiniProject\\image\\backToLogin _1.png"));
		btn_backToLoging.setBorderPainted(false);
		btn_backToLoging.setBounds(297, 527, 62, 22);
		Find_Idpanel.add(btn_backToLoging);
		//--------------------���̵� ã�⿡�� �α��� �������� �̵� ��ư-------------
		btn_backToLoging.addActionListener(new ActionListener() { //���̵� ã�⿡�� �α������� �̵� ��ư ��
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Find_Idpanel.setVisible(false);
				LoginPanel.setVisible(true);
				
			}
		});//���̵� ã�⿡�� �α������� �̵� ��ư ��
		

		
		
		JPanel Output_Id = new JPanel();
		Output_Id.setBounds(107, 372, 276, 119);
		Find_Idpanel.add(Output_Id);
		Output_Id.setLayout(null);
		
		outPut_id = new JLabel("\uC77C\uCE58\uD558\uB294 ID\uAC00 \uC5C6\uC2B5\uB2C8\uB2E4..");
		outPut_id.setHorizontalAlignment(SwingConstants.CENTER);
		outPut_id.setForeground(UIManager.getColor("CheckBox.darkShadow"));
		outPut_id.setFont(new Font("�޸յձ�������", Font.PLAIN, 15));
		outPut_id.setBounds(14, 50, 248, 31);
		Output_Id.add(outPut_id);
		
		output_id = new JLabel("ID");
		output_id.setForeground(SystemColor.controlDkShadow);
		output_id.setFont(new Font("�޸յձ�������", Font.PLAIN, 16));
		output_id.setBackground(SystemColor.activeCaptionBorder);
		output_id.setBounds(122, 12, 31, 39);
		Output_Id.add(output_id);
		
		textField = new JTextField();
		textField.setFont(new Font("���� ���", Font.PLAIN, 20));
		textField.setBackground(SystemColor.control);
		textField.setBounds(107, 251, 276, 39);
		Find_Idpanel.add(textField);
		textField.setColumns(10);
		textField.setBorder(null);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\hijic\\Desktop\\eclipseSave\\MiniProject\\image\\Find_Id.png"));
		btnNewButton_1.setBounds(107, 302, 167, 37);
		Find_Idpanel.add(btnNewButton_1);
		btnNewButton_1.setBorder(null);
		
		BacktoLogin_1 = new JLabel("\uC544\uC774\uB514\uB97C \uCC3E\uC73C\uC168\uB098\uC694?");
		BacktoLogin_1.setForeground(SystemColor.activeCaptionBorder);
		BacktoLogin_1.setFont(new Font("�޸յձ�������", Font.PLAIN, 15));
		BacktoLogin_1.setBackground(SystemColor.activeCaptionBorder);
		BacktoLogin_1.setBounds(134, 517, 161, 39);
		Find_Idpanel.add(BacktoLogin_1);
		
		// -------------------���̵� ã�� ��ư �׼�-------------------
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String inputName = textField.getText();
				
				while(true) {
					if(Member.getMemberId(inputName) != null) {
						outPut_id.setText(Member.getMemberId(inputName));
						break;
					}else {
						outPut_id.setText("��ġ�ϴ� ���̵� �����ϴ�!");
						break;
					}
				}
			}
		});//���̵� ã�� ��ư �޼��� ��
	
		
		//------------------�α��� ���---------------
		
		LoginPanel.setBounds(0, 0, 497, 761);
		frame.getContentPane().add(LoginPanel);
		LoginPanel.setLayout(null);
		
		Lpanel = new JPanel();
		Lpanel.setBounds(260, 9, 1, 1);
		Lpanel.setLayout(null);
		Lpanel.setBackground(Color.WHITE);
		LoginPanel.add(Lpanel);
		
		login_text = new JLabel("ID");
		login_text.setBounds(91, 203, 38, 39);
		LoginPanel.add(login_text);
		login_text.setForeground(SystemColor.activeCaptionBorder);
		login_text.setFont(new Font("Dialog", Font.PLAIN, 16));
		login_text.setBackground(SystemColor.activeCaptionBorder);
		
		Login_inputId = new JTextField();
		Login_inputId.setBounds(91, 254, 276, 39);
		LoginPanel.add(Login_inputId);
		Login_inputId.setFont(new Font("����", Font.PLAIN, 12));
		Login_inputId.setColumns(10);
		Login_inputId.setBackground(SystemColor.menu);
		
		Login_Pass = new JLabel("Password");
		Login_Pass.setBounds(91, 300, 94, 39);
		LoginPanel.add(Login_Pass);
		Login_Pass.setForeground(SystemColor.activeCaptionBorder);
		Login_Pass.setFont(new Font("Dialog", Font.PLAIN, 16));
		Login_Pass.setBackground(SystemColor.activeCaptionBorder);
		
		Login_inputPass = new JPasswordField();
		Login_inputPass.setBounds(91, 350, 276, 39);
		LoginPanel.add(Login_inputPass);
		Login_inputPass.setFont(new Font("����", Font.PLAIN, 12));
		Login_inputPass.setBackground(SystemColor.menu);
		
		btn_login = new JButton("");
		btn_login.setHorizontalAlignment(SwingConstants.CENTER);
		btn_login.setBackground(Color.YELLOW);
		btn_login.setBounds(91, 401, 296, 95);
		LoginPanel.add(btn_login);
		
		btn_toFindId = new JButton("\uC544\uC774\uB514\uCC3E\uAE30");
		btn_toFindId.setHorizontalAlignment(SwingConstants.CENTER);
		btn_toFindId.setBackground(Color.GREEN);
		btn_toFindId.setBounds(91, 632, 296, 95);
		LoginPanel.add(btn_toFindId);
		
		btn_toRegistration = new JButton("");
		btn_toRegistration.setBounds(91, 518, 296, 95);
		LoginPanel.add(btn_toRegistration);
		btn_toRegistration.setBackground(Color.RED);
		btn_toRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		
		
		//=============================================�α��ο��� ���̵� ã�� �������̵� ��ư �׼�=========================================================
		btn_toFindId.addActionListener(new ActionListener() {//��ư�� �������� ȸ����������
			
			@Override
			public void actionPerformed(ActionEvent e) {//�׼��� ���� ���� ����	//�Է¹��� ������ ���� ������ ����
				
				
				LoginPanel.setVisible(false);
				Find_Idpanel.setVisible(true);
			}
		});
		
		//=============================================�α��ο��� ȸ������ �������̵� ��ư �׼�=========================================================
		btn_toRegistration.addActionListener(new ActionListener() {//��ư�� �������� ȸ����������
			
			@Override
			public void actionPerformed(ActionEvent e) {//�׼��� ���� ���� ����	//�Է¹��� ������ ���� ������ ����
				
				
				LoginPanel.setVisible(false);
				SignUpPanel.setVisible(true);
			}
		});
		
		
		// -------------------�α��� ��ư �׼�-------------------
		btn_login.addActionListener(new ActionListener() {// ��ư�� �������� �׼��� ���ϵ��� �ϴ� �޼���
		
			@Override
			public void actionPerformed(ActionEvent e) {// �׼��� ���� ���� ���� //�Է¹��� ������ ���� ������ ����
				String newLogId = Login_inputId.getText(); // id�Է°� newId ������ ����
				String newLogPw = Login_inputPass.getText(); // �н����� �Է°� newPw ������ ����
		
				while (true) {
					if (Member.getLoginMember(newLogId).equals(newLogPw) && !newLogId.trim().equals("")
							&& !newLogPw.trim().equals("")) {
		
						LoginPanel.setVisible(false);
						// ����ȭ���� ������ setVisible(true) ��ġ �ڸ�
						break;
					} else {
						JOptionPane.showMessageDialog(null, "���̵�� ��й�ȣ�� ��ġ���� �ʽ��ϴ�!");
						break;
					}
		
				} // while �� ��
			} // actionPerformed ��
		}); // addActionListener() ��
		
		
		
		
		
		//======================================================================ȸ������ ���====================================================================
		
		SignUpPanel.setBounds(0, 0, 484, 761);
		frame.getContentPane().add(SignUpPanel);
		SignUpPanel.setLayout(null);
		
		//background ���� �г� ����
		ImagePanel Bpanel = new ImagePanel(new ImageIcon("./image/Background_1.png").getImage());
		Bpanel.setBounds(0, 0, 486, 763);
		SignUpPanel.add(Bpanel);
		Bpanel.setLayout(null);
		
		ID = new JLabel("ID");
		ID.setBounds(107, 247, 38, 39);
		Bpanel.add(ID);
		ID.setForeground(SystemColor.activeCaptionBorder);
		ID.setBackground(SystemColor.activeCaptionBorder);
		ID.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		
		inputID = new JTextField();
		inputID.setBounds(107, 284, 276, 39);
		Bpanel.add(inputID);
		inputID.setFont(new Font("����", Font.PLAIN, 12));
		inputID.setBackground(SystemColor.control);
		inputID.setColumns(10);
		inputID.setBorder(null);
		
		Name = new JLabel("Name");
		Name.setBounds(107, 334, 94, 39);
		Bpanel.add(Name);
		Name.setForeground(SystemColor.activeCaptionBorder);
		Name.setBackground(SystemColor.activeCaptionBorder);
		Name.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		
		inputName = new JTextField();
		inputName.setBounds(107, 373, 276, 39);
		Bpanel.add(inputName);
		inputName.setFont(new Font("����", Font.PLAIN, 12));
		inputName.setBackground(SystemColor.control);
		inputName.setColumns(10);
		inputName.setBorder(null);
		
		Password = new JLabel("Password");
		Password.setBounds(107, 422, 94, 39);
		Bpanel.add(Password);
		Password.setForeground(SystemColor.activeCaptionBorder);
		Password.setBackground(SystemColor.activeCaptionBorder);
		Password.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		
		inputPassword = new JPasswordField();
		inputPassword.setBounds(107, 463, 276, 39);
		Bpanel.add(inputPassword);
		inputPassword.setFont(new Font("����", Font.PLAIN, 12));
		inputPassword.setBackground(SystemColor.control);
		inputPassword.setBorder(null);
		
			
			btn_SignUp = new JButton("");
			btn_SignUp.setBounds(108, 579, 277, 67);
			Bpanel.add(btn_SignUp);
			btn_SignUp.setIcon(new ImageIcon("C:\\Users\\hijic\\Desktop\\eclipseSave\\MiniProject\\image\\btn_submit.png"));
			btn_SignUp.setHorizontalAlignment(btn_SignUp.CENTER);
			btn_SignUp.setBorderPainted(false);
			
			JLabel BacktoLogin = new JLabel("\uC774\uBBF8 \uC544\uC774\uB514\uAC00 \uC788\uC73C\uC2E0\uAC00\uC694?");
			BacktoLogin.setBounds(118, 658, 200, 39);
			BacktoLogin.setForeground(SystemColor.activeCaptionBorder);
			BacktoLogin.setFont(new Font("�޸յձ�������", Font.PLAIN, 15));
			BacktoLogin.setBackground(SystemColor.activeCaptionBorder);
			Bpanel.add(BacktoLogin);
			
			
			//--------------------ȸ�����Կ��� �α��� �������� �̵� ��ư-------------
			JButton btnNewButton = new JButton("");
			btnNewButton.setBounds(314, 668, 62, 22);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SignUpPanel.setVisible(false);
					LoginPanel.setVisible(true);
				}
			});	//�α������� �̵� ��ư �׼� ��
			btnNewButton.setIcon(new ImageIcon("C:\\Users\\hijic\\Desktop\\eclipseSave\\MiniProject\\image\\backToLogin _1.png"));
			btnNewButton.setBorderPainted(false);
			Bpanel.add(btnNewButton);
			
			
			//=============================================ȸ������ �׼�=========================================================
			btn_SignUp.addActionListener(new ActionListener() {//��ư�� �������� �׼��� ���ϵ��� �ϴ� �޼���
				@Override
				public void actionPerformed(ActionEvent e) {	//�׼��� ���� ���� ����	//�Է¹��� ������ ���� ������ ����
					String newId = inputID.getText();	//id�Է°� newId ������ ����
					String newName = inputName.getText();	//�̸� �Է°� newName ������ ����
					String newPw = inputPassword.getText();	//�н����� �Է°� newPw ������ ����
					
					
					//�������� ���� �Է��� ���� ���������̺� ����Ǿ��ִ� ������ �ߺ��Ǵ��� ���θ� �Ǵ��Ͽ� �ߺ�X->����� ���Լ��� �޽��� ���/ �ߺ�O-> �ߺ����� �˸��� �޽��� ���/
					System.out.println("=====================1==========================");
					try {
					while(true) {	//�ݺ����� ���� �迭�� ��� ���� ��
					if(!DBdata.contains(newId) && !newId.trim().equals("") && !newName.trim().equals("") && !newPw.trim().equals("")) { //�Է��� ���̵��� DB���� ������ �����Ͱ�(�迭)�� ���ؼ� ������ �ź� ��� ������ �����ϵ���	//������ ����->���̵� ��ġ���� �ʰ� �̸��� null���� �ƴϰ� ��й�ȣ�� null���� �ƴҶ� (������ ��� trime()�޼���� ����)->member.createMember(newId, newName, newPw);����
						//String�� ����->      this.value = "".value; //Initializes a newly created {@code String} object so that it represents-> ��Ʈ�� Ÿ���� ���ο� ��ü�� �����Ҷ� ""�̷��� �ʱ�ȭ �ȴ�, �� null�� �ƴ� '��'���� �ʱ�ȭ �ǰ� �׷��� equals���� ���Ҷ� null������ �������� ������ �߻��ϰ�  ""�񱳽� �۵� �ߴ���..
						member.createMember(newId, newName, newPw);
						System.out.println(DBdata.toString());
						System.out.println("=====================2==========================");
						JOptionPane.showMessageDialog(null, "ȸ�������� �����Ͽ����ϴ�");
						System.out.println("=====================3==========================");
						SignUpPanel.setVisible(false);	//ȸ������ ���� �� �����ͺ��̽��� ����� ��  ���̻� ȸ�������г��� �������� �ʰ���
						break;
					}else {// ���̵� ��й�ȣ�� �ٸ� ���
						JOptionPane.showMessageDialog(null, "�Է��� ���̵� �̹� �����ϰų� \n �ۼ��� �Ϸ���� �ʾҽ��ϴ�");
						System.out.println("=====================4==========================");
						break;
					}
					}//WHile�� ��
					}catch(Exception e1) {
						e1.printStackTrace();
					}
					
					
				}//actionPerformed ��
			});	//addActionListener�� 
			
			
				
				
			SignUpPanel.setVisible(false);
		
		
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}//�ҽ� ���� ��
//--------------------------------------------background panel----------------------------------------------

class ImagePanel extends JPanel{	//panel�� ��׶��� �̹����� ���� �ϱ� ���� Ŭ���� ����
		private Image img;
		
		public ImagePanel(Image img) {
			this.img=img;
			setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
			setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
			setLayout(null);
		}//������ ��
		public void paintComponent(Graphics g) {
			g.drawImage(img, 0, 0, null);
		}
	
}
/////////////////////
 ���� �Ұ�
panelClock2.setLayout(null);

JButton Clock2 = new JButton("");
Clock2.setIcon(new ImageIcon("C:\\Users\\Nam\\Desktop\\clock2.jpg"));
Clock2.setBounds(0, 0, 433, 433);
panelClock2.add(Clock2);



panelClock2.setVisible(false);

btnBCU.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		panel_beaconU.setVisible(false);
		panel_beaconE.setVisible(true);
		
	}
});
btnBCE.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		panel_beaconU.setVisible(true);
		panel_beaconE.setVisible(false);
		
	}
});

Clock1.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		panelClock1.setVisible(false);
		panelClock2.setVisible(true);
		
	}
});
Clock2.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		panelClock1.setVisible(true);
		panelClock2.setVisible(false);
		
	}
});
*/