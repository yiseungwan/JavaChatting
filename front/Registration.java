package com.chat.front;

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
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.List;

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

import com.chat.client.Client;
import com.chat.connect.Member;



public class Registration extends JButton{

	private JFrame frmChat;
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
	private JPanel Find_IDpanel;
	private JLabel id_find;
	private JButton btn_toFindId;
	private JLabel output_idText;
	private JTextField find_inputName;
	private JLabel outPut_id;
	private JLabel BacktoLogin_1;
	private JButton btn_backToLoging1;
	private JLabel output_id;
	private JButton btn_toFindPW;
	private JTextField find_inputId;
	private JPanel Output_pw;
	private JLabel outPut_pw;
	private JLabel output_pw;
	private JButton btn_FIndPwButton;
	private JButton btn_backToLoging3;
	private JLabel BacktoLogin_2;
	private JPanel find_id_backPenel;
	private JPanel Cpanel;
	private JPanel Fpanel_1;
	private JPanel Logo_panel;
	List<String> tmp= new ArrayList<String>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					Registration window = new Registration();
					window.frmChat.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Registration() {
		initialize();
		frmChat.setLocationRelativeTo(null);//����� �߾ӿ� ��ġ
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//----------------------------WindowBuilder�� ���� form����----------------------------
		frmChat = new JFrame();
		frmChat.setTitle("Chat");
		frmChat.setPreferredSize(new Dimension(500, 800));
		frmChat.setSize(500, 800);
		frmChat.setResizable(false);
		frmChat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Member member = new Member();	//MemberŬ�������� ������ DB���� ������ ��ü�� ����� ���������� �����ϱ� ���� ����
		
		//================================================================�г� ��========================================================================
		
		//backgraound 1���
		File f =new File("./image/Background.jpg");	//background �̹����� ������ ���� ���� �ҷ���
		System.out.println(f.exists()?"Exists":"doesnt exist");	//���� ���翩�� Ȯ��
		frmChat.pack();	//pack()�޼���-> "JFrame" �� ���빰�� �˸°� ������ ũ�⸦ ����
		//DB���� �ҷ��� ������ ����Ʈ��ü ����
		ArrayList<String> DBdata = Member.getRegistrationMember();
		frmChat.getContentPane().setLayout(null);
		
				
				/*
				 //background ���� �г� ����
				ImagePanel Bpanel = new ImagePanel(new ImageIcon("./image/SignUp_Background_1.png").getImage());
				Bpanel.setBounds(0, 0, 497, 763);
				SignUpPanel.add(Bpanel);
				Bpanel.setLayout(null); 
				 */
		
		//======================================================================ȸ������ ���====================================================================
		
		JPanel SignUpPanel = new JPanel();	//ȸ������ �г�
		SignUpPanel.setBounds(0, 0, 497, 761);
		frmChat.getContentPane().add(SignUpPanel);
		SignUpPanel.setLayout(null);
		
		//background ���� �г� ����
		ImagePanel Bpanel = new ImagePanel(new ImageIcon("./image/SignUp_Background_1.png").getImage());
		Bpanel.setBounds(0, 0, 497, 763);
		SignUpPanel.add(Bpanel);
		Bpanel.setLayout(null);
		
		ID = new JLabel("ID");
		ID.setBounds(107, 247, 38, 39);
		Bpanel.add(ID);
		ID.setForeground(SystemColor.activeCaptionBorder);
		ID.setBackground(SystemColor.activeCaptionBorder);
		ID.setFont(new Font("Arial Black", Font.PLAIN, 16));
		
		inputID = new JTextField();
		inputID.setForeground(UIManager.getColor("CheckBox.darkShadow"));
		inputID.setBounds(107, 284, 276, 39);
		Bpanel.add(inputID);
		inputID.setFont(new Font("�޸յձ�������", Font.PLAIN, 15));
		inputID.setBackground(SystemColor.control);
		inputID.setColumns(10);
		inputID.setBorder(null);
		
		Name = new JLabel("Name");
		Name.setBounds(107, 334, 94, 39);
		Bpanel.add(Name);
		Name.setForeground(SystemColor.activeCaptionBorder);
		Name.setBackground(SystemColor.activeCaptionBorder);
		Name.setFont(new Font("Arial Black", Font.PLAIN, 16));
		
		inputName = new JTextField();
		inputName.setForeground(UIManager.getColor("CheckBox.darkShadow"));
		inputName.setBounds(107, 373, 276, 39);
		Bpanel.add(inputName);
		inputName.setFont(new Font("�޸յձ�������", Font.PLAIN, 15));
		inputName.setBackground(SystemColor.control);
		inputName.setColumns(10);
		inputName.setBorder(null);
		
		Password = new JLabel("Password");
		Password.setBounds(107, 422, 94, 39);
		Bpanel.add(Password);
		Password.setForeground(SystemColor.activeCaptionBorder);
		Password.setBackground(SystemColor.activeCaptionBorder);
		Password.setFont(new Font("Arial Black", Font.PLAIN, 16));
		
		inputPassword = new JPasswordField();
		inputPassword.setBounds(107, 463, 276, 39);
		Bpanel.add(inputPassword);
		inputPassword.setFont(new Font("����", Font.PLAIN, 12));
		inputPassword.setBackground(SystemColor.control);
		inputPassword.setBorder(null);
		
			
			btn_SignUp = new JButton("");
			btn_SignUp.setBounds(108, 579, 276, 69);
			Bpanel.add(btn_SignUp);
			btn_SignUp.setIcon(new ImageIcon("C:\\Users\\aaa\\eclipse-workspace\\MiniProject_2\\image\\btn_submit.png"));
			btn_SignUp.setHorizontalAlignment(btn_SignUp.CENTER);
			btn_SignUp.setBorderPainted(false);
			
			JLabel BacktoLogin = new JLabel("\uC774\uBBF8 \uC544\uC774\uB514\uAC00 \uC788\uC73C\uC2E0\uAC00\uC694?");
			BacktoLogin.setBounds(118, 658, 200, 39);
			BacktoLogin.setForeground(Color.LIGHT_GRAY);
			BacktoLogin.setFont(new Font("�޸յձ�������", Font.PLAIN, 15));
			BacktoLogin.setBackground(SystemColor.windowBorder);
			Bpanel.add(BacktoLogin);
			
			
			//--------------------ȸ�����Կ��� �α��� �������� �̵� ��ư-------------
			JButton btn_backToLoging2 = new JButton("");
			btn_backToLoging2.setBounds(314, 668, 62, 22);
			btn_backToLoging2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SignUpPanel.setVisible(false);
					LoginPanel.setVisible(true);
				}
			});	//�α������� �̵� ��ư �׼� ��
			btn_backToLoging2.setIcon(new ImageIcon("C:\\Users\\aaa\\eclipse-workspace\\MiniProject\\image\\backToLogin _1.png"));
			btn_backToLoging2.setBorderPainted(false);
			Bpanel.add(btn_backToLoging2);
			
			
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
						LoginPanel.setVisible(true);
						
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
			
		/*	//background ���� �г� ����
			ImagePanel Lpanel = new ImagePanel(new ImageIcon("./image/Login_background.png").getImage());
			Lpanel.setBounds(0, 0, 497, 763);
			LoginPanel.add(Lpanel);
			Lpanel.setLayout(null);*/
			LoginPanel = new JPanel();		//�α��� �г�
			LoginPanel.setBackground(Color.WHITE);
			
				
				//------------------�α��� ���---------------
				
				LoginPanel.setBounds(0, 0, 497, 761);
				frmChat.getContentPane().add(LoginPanel);
				LoginPanel.setLayout(null);
				
				
				Lpanel = new JPanel();
				Lpanel.setBounds(260, 9, 1, 1);
				Lpanel.setLayout(null);
				Lpanel.setBackground(Color.WHITE);
				LoginPanel.add(Lpanel);
				
				login_text = new JLabel("ID");
				login_text.setBounds(94, 287, 38, 39);
				LoginPanel.add(login_text);
				login_text.setForeground(Color.GRAY);
				login_text.setFont(new Font("Arial Black", Font.PLAIN, 20));
				login_text.setBackground(SystemColor.activeCaptionBorder);
				
				Login_inputId = new JTextField();
				Login_inputId.setBounds(94, 325, 317, 45);
				Login_inputId.setForeground(UIManager.getColor("CheckBox.darkShadow"));
				LoginPanel.add(Login_inputId);
				Login_inputId.setFont(new Font("�޸յձ�������", Font.PLAIN, 15));
				Login_inputId.setColumns(10);
				Login_inputId.setBackground(SystemColor.menu);
				Login_inputId.setBorder(null);
				
				Login_Pass = new JLabel("Password");
				Login_Pass.setBounds(94, 382, 133, 39);
				LoginPanel.add(Login_Pass);
				Login_Pass.setForeground(Color.GRAY);
				Login_Pass.setFont(new Font("Arial Black", Font.PLAIN, 20));
				Login_Pass.setBackground(SystemColor.activeCaptionBorder);
				
				Login_inputPass = new JPasswordField();
				Login_inputPass.setBounds(94, 421, 317, 45);
				Login_inputPass.setForeground(UIManager.getColor("CheckBox.darkShadow"));
				LoginPanel.add(Login_inputPass);
				Login_inputPass.setFont(new Font("����ü", Font.PLAIN, 15));
				Login_inputPass.setBackground(SystemColor.menu);
				Login_inputPass.setBorder(null);
				
				btn_login = new JButton("");
				btn_login.setBounds(94, 495, 317, 53);
				btn_login.setIcon(new ImageIcon("C:\\Users\\aaa\\eclipse-workspace\\MiniProject\\image\\Login.png"));
				btn_login.setHorizontalAlignment(SwingConstants.CENTER);
				btn_login.setBackground(Color.WHITE);
				btn_login.setBorderPainted(false);
				LoginPanel.add(btn_login);
				
				btn_toFindId = new JButton("");
				btn_toFindId.setBounds(133, 627, 105, 23);
				btn_toFindId.setIcon(new ImageIcon("C:\\Users\\aaa\\eclipse-workspace\\MiniProject\\image\\btn_find_id.png"));
				btn_toFindId.setHorizontalAlignment(SwingConstants.CENTER);
				btn_toFindId.setBackground(Color.WHITE);
				LoginPanel.add(btn_toFindId);
				btn_toFindId.setBorder(null);
				
				btn_toFindPW = new JButton("");
				btn_toFindPW.setIcon(new ImageIcon("C:\\Users\\aaa\\eclipse-workspace\\MiniProject\\image\\btn_find_pw.png"));
				btn_toFindPW.setHorizontalAlignment(SwingConstants.CENTER);
				btn_toFindPW.setBorder(null);
				btn_toFindPW.setBackground(Color.WHITE);
				btn_toFindPW.setBounds(253, 627, 127, 24);
				LoginPanel.add(btn_toFindPW);
				
				btn_toRegistration = new JButton("");
				btn_toRegistration.setBounds(94, 560, 315, 55);
				btn_toRegistration.setIcon(new ImageIcon("C:\\Users\\aaa\\eclipse-workspace\\MiniProject\\image\\SignUp.png"));
				LoginPanel.add(btn_toRegistration);
				btn_toRegistration.setBackground(new Color(255, 255, 255));
				btn_toRegistration.setHorizontalAlignment(SwingConstants.CENTER);
				btn_toRegistration.setBorderPainted(false);
				
				
				//�α��� �ΰ� �̹���
				ImagePanel Logo_Panel = new ImagePanel(new ImageIcon("./image/Login_Logo_1.png").getImage());
				Logo_Panel.setBounds(103, 68, 331, 209);
				LoginPanel.add(Logo_Panel);
				
				
				//=============================================�α��ο��� ���̵� ã�� �������̵� ��ư �׼�=========================================================
				btn_toFindId.addActionListener(new ActionListener() {//��ư�� �������� ȸ����������
					
					@Override
					public void actionPerformed(ActionEvent e) {//�׼��� ���� ���� ����	//�Է¹��� ������ ���� ������ ����
						
						
						LoginPanel.setVisible(false);
						Find_IDpanel.setVisible(true);
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
						while(true) {
							if(!tmp.iterator().hasNext())
							{
								break;
							}
							else {
								if(!tmp.iterator().next().equals(newLogId)) {
									tmp.add(newLogId);
									Client frame = new Client();
									frame.setVisible(true);
								}
							}
						}
						while (true) {
							if (Member.getLoginMember(newLogId).equals(newLogPw) && !newLogId.trim().equals("")
									&& !newLogPw.trim().equals("")) {
				
								LoginPanel.setVisible(false);
//								new Client();
//								Client client = new Client();
								Client frame = new Client();
								frame.setVisible(true);
								// ����ȭ���� ������ setVisible(true) ��ġ �ڸ�
								break;
							} else {
								JOptionPane.showMessageDialog(null, "���̵�� ��й�ȣ�� ��ġ���� �ʽ��ϴ�!");
								break;
							}
				
						} // while �� ��
					} // actionPerformed ��
				}); // addActionListener() ��
							

			
			//----------------------------------���̵� ã�� ���------------------------
			Find_IDpanel = new JPanel();	//���̵� ã�� �г�
			
			Find_IDpanel.setBackground(Color.WHITE);
			Find_IDpanel.setBounds(0, 0, 497, 763);
			frmChat.getContentPane().add(Find_IDpanel);
			Find_IDpanel.setLayout(null);
			Find_IDpanel.setVisible(false);
			
			id_find = new JLabel("\uC774\uB984\uC744 \uC785\uB825\uD558\uC138\uC694!");
			id_find.setForeground(SystemColor.activeCaptionBorder);
			id_find.setFont(new Font("�޸յձ�������", Font.BOLD, 20));
			id_find.setBackground(SystemColor.activeCaptionBorder);
			id_find.setBounds(107, 212, 206, 39);
			Find_IDpanel.add(id_find);
			
			btn_backToLoging1 = new JButton("");
			btn_backToLoging1.setIcon(new ImageIcon("C:\\Users\\aaa\\eclipse-workspace\\MiniProject\\image\\backToLogin _1.png"));
			btn_backToLoging1.setBorderPainted(false);
			btn_backToLoging1.setBounds(297, 527, 62, 22);
			Find_IDpanel.add(btn_backToLoging1);
			//--------------------���̵� ã�⿡�� �α��� �������� �̵� ��ư-------------
			btn_backToLoging1.addActionListener(new ActionListener() { //���̵� ã�⿡�� �α������� �̵� ��ư ��
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Find_IDpanel.setVisible(false);
					LoginPanel.setVisible(true);
					
				}
			});//���̵� ã�⿡�� �α������� �̵� ��ư ��
			

			
			
			JPanel Output_Id = new JPanel();
			Output_Id.setBounds(107, 372, 276, 119);
			Find_IDpanel.add(Output_Id);
			Output_Id.setLayout(null);
			
			outPut_id = new JLabel("");
			outPut_id.setHorizontalAlignment(SwingConstants.CENTER);
			outPut_id.setForeground(UIManager.getColor("CheckBox.darkShadow"));
			outPut_id.setFont(new Font("�޸յձ�������", Font.PLAIN, 15));
			outPut_id.setBounds(14, 50, 248, 31);
			Output_Id.add(outPut_id);
			
			output_id = new JLabel("ID");
			output_id.setHorizontalAlignment(SwingConstants.CENTER);
			output_id.setForeground(SystemColor.controlDkShadow);
			output_id.setFont(new Font("�޸յձ�������", Font.PLAIN, 16));
			output_id.setBackground(SystemColor.activeCaptionBorder);
			output_id.setBounds(14, 12, 248, 39);
			Output_Id.add(output_id);
			
			find_inputName = new JTextField();
			find_inputName.setFont(new Font("�޸յձ�������", Font.PLAIN, 20));
			find_inputName.setBackground(SystemColor.control);
			find_inputName.setBounds(107, 251, 276, 39);
			Find_IDpanel.add(find_inputName);
			find_inputName.setColumns(10);
			find_inputName.setBorder(null);
			
			JButton btn_FIndIdButton = new JButton("");
			btn_FIndIdButton.setIcon(new ImageIcon("C:\\Users\\aaa\\eclipse-workspace\\MiniProject\\image\\Find_Id.png"));
			btn_FIndIdButton.setBounds(107, 302, 168, 37);
			Find_IDpanel.add(btn_FIndIdButton);
			btn_FIndIdButton.setBorder(null);
			
			BacktoLogin_1 = new JLabel("\uC544\uC774\uB514\uB97C \uCC3E\uC73C\uC168\uB098\uC694?");
			BacktoLogin_1.setForeground(SystemColor.activeCaptionBorder);
			BacktoLogin_1.setFont(new Font("�޸յձ�������", Font.BOLD, 15));
			BacktoLogin_1.setBackground(SystemColor.activeCaptionBorder);
			BacktoLogin_1.setBounds(134, 517, 161, 39);
			Find_IDpanel.add(BacktoLogin_1);
			
			
			
			//----------------------------------���̵� ã�� background ���------------------------
			ImagePanel Fpanel_1 = new ImagePanel(new ImageIcon("./image/Find_background_form_1.png").getImage());
			Fpanel_1.setBounds(0, 0, 497, 763);
			Find_IDpanel.add(Fpanel_1);
			Bpanel.setLayout(null);
			Find_IDpanel.setVisible(false);

			
			JLabel id_find_1 = new JLabel("\uC544\uC774\uB514\uB97C \uC785\uB825\uD558\uC138\uC694!");
			id_find_1.setBounds(105, 214, 206, 39);
			id_find_1.setForeground(SystemColor.activeCaptionBorder);
			id_find_1.setFont(new Font("�޸յձ�������", Font.BOLD, 20));
			id_find_1.setBackground(SystemColor.activeCaptionBorder);
			
			
			//----------------------------------��й�ȣ ã�� ���------------------------
			JPanel FInd_PWpanel = new JPanel();
			FInd_PWpanel.setBackground(Color.WHITE);
			FInd_PWpanel.setBounds(0, 0, 497, 761);
			frmChat.getContentPane().add(FInd_PWpanel);
			FInd_PWpanel.setLayout(null);
			FInd_PWpanel.add(id_find_1);
			
					
					find_inputId = new JTextField();
					find_inputId.setBounds(105, 253, 276, 39);
					find_inputId.setForeground(Color.DARK_GRAY);
					find_inputId.setFont(new Font("�޸յձ�������", Font.PLAIN, 20));
					find_inputId.setColumns(10);
					find_inputId.setBorder(null);
					find_inputId.setBackground(SystemColor.menu);
					FInd_PWpanel.add(find_inputId);
					
					Output_pw = new JPanel();
					Output_pw.setBounds(105, 372, 276, 119);
					Output_pw.setLayout(null);
					FInd_PWpanel.add(Output_pw);
					
					outPut_pw = new JLabel("");
					outPut_pw.setHorizontalAlignment(SwingConstants.CENTER);
					outPut_pw.setForeground(SystemColor.controlDkShadow);
					outPut_pw.setFont(new Font("�޸յձ�������", Font.PLAIN, 15));
					outPut_pw.setBounds(14, 50, 248, 31);
					Output_pw.add(outPut_pw);
					
					output_pw = new JLabel("PASSWORD");
					output_pw.setHorizontalAlignment(SwingConstants.CENTER);
					output_pw.setForeground(SystemColor.controlDkShadow);
					output_pw.setFont(new Font("�޸յձ�������", Font.PLAIN, 16));
					output_pw.setBackground(SystemColor.activeCaptionBorder);
					output_pw.setBounds(14, 12, 248, 39);
					Output_pw.add(output_pw);
					
					// -------------------��й�ȣ ã�� ��ư �׼�-------------------
					btn_FIndPwButton = new JButton("");
					btn_FIndPwButton.setIcon(new ImageIcon("C:\\Users\\aaa\\eclipse-workspace\\MiniProject\\image\\btn_find_pw_1.png"));
					btn_FIndPwButton.setBounds(105, 304, 180, 38);
					btn_FIndPwButton.setBorder(null);
					btn_FIndPwButton.addActionListener(new ActionListener() {
						
						public void actionPerformed(ActionEvent e) {	
							String inputId = find_inputId.getText();	//Member Ŭ�������� ���� getMemberId()�޼��带 ���ؼ� �Է��� Id�� �����ϰ� pw�� ��ȯ����
							
							while(true) {
								if(Member.getMemberId(inputId) != null) {
									outPut_pw.setText(Member.getMemberPw(inputId));
									break;
								}else {
									outPut_pw.setText("��ġ�ϴ� ���̵� ������ �����ϴ�!");
									break;
								}
							}
						}
					});	//��й�ȣ ã�� ��ư �׼� ��
					
							//-----------��й�ȣ ã�� ���������� ���ã�� ��ư-----------
							btn_FIndPwButton.setBorder(null);
							FInd_PWpanel.add(btn_FIndPwButton);
							
							btn_backToLoging3 = new JButton("");
							btn_backToLoging3.setBounds(308, 525, 62, 22);
							btn_backToLoging3.setIcon(new ImageIcon("C:\\Users\\aaa\\eclipse-workspace\\MiniProject\\image\\backToLogin _1.png"));
							btn_backToLoging3.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
								}
							});
							btn_backToLoging3.setBorderPainted(false);
							FInd_PWpanel.add(btn_backToLoging3);
							
							//--------------------��й�ȣ ã�⿡�� �α��� �������� �̵� ��ư-------------
							btn_backToLoging3.addActionListener(new ActionListener() { //���̵� ã�⿡�� �α������� �̵� ��ư ��
								
								@Override
								public void actionPerformed(ActionEvent e) {
									FInd_PWpanel.setVisible(false);
									LoginPanel.setVisible(true);
									
								}
							});//��й�ȣ ã�⿡�� �α������� �̵� ��ư ��
							
							BacktoLogin_2 = new JLabel("\uBE44\uBC00\uBC88\uD638\uB97C \uCC3E\uC73C\uC168\uB098\uC694?");
							BacktoLogin_2.setBounds(133, 515, 194, 39);
							BacktoLogin_2.setForeground(Color.LIGHT_GRAY);
							BacktoLogin_2.setFont(new Font("�޸յձ�������", Font.BOLD, 15));
							BacktoLogin_2.setBackground(SystemColor.activeCaptionBorder);
							FInd_PWpanel.add(BacktoLogin_2);
							
							
							//--------------------���̵�ã�� background �̹���-----------	//find_background_form
							ImagePanel Fpanel_2 = new ImagePanel(new ImageIcon("./image/Find_background_form_1.png").getImage());
							Fpanel_2.setBounds(0, 0, 497, 761);
							FInd_PWpanel.add(Fpanel_2);
							FInd_PWpanel.setVisible(false);
			
			//=============================================�α��ο��� ��й�ȣ ã�� �������̵� ��ư �׼�=========================================================
			btn_toFindPW.addActionListener(new ActionListener() {//��ư�� �������� ȸ����������
				
				@Override
				public void actionPerformed(ActionEvent e) {//�׼��� ���� ���� ����	//�Է¹��� ������ ���� ������ ����
					
					
					LoginPanel.setVisible(false);
					FInd_PWpanel.setVisible(true);
				}
			});
			
			// -------------------���̵� ã�� ��ư �׼�-------------------
			btn_FIndIdButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String inputName = find_inputName.getText();
					
					while(true) {
						if(Member.getMemberId(inputName) != null) {
							outPut_id.setText(Member.getMemberId(inputName));
							break;
						}else {
							outPut_id.setText("��ġ�ϴ� ������ �����ϴ�");
							break;
						}
					}
				}
			});//���̵� ã�� ��ư �޼��� ��
			
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
/* ���� �Ұ�
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

			
		
			
 		//background ���� �г� ����
		ImagePanel Find_IDpanel = new ImagePanel(new ImageIcon("./image/Find_background.png").getImage());
		ImagePanel Bpanel = new ImagePanel(new ImageIcon("./image/SignUp_Background_1.png").getImage());
		Bpanel.setBounds(0, 0, 497, 763);
		SignUpPanel.add(Bpanel);
		Bpanel.setLayout(null);
		
			
*/