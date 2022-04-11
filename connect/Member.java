package com.chat.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

import com.chat.VO.MemberVO;

//���� Ŭ������ ȸ������ �������� ���� ȸ�����������͸� �޾ƿ� ������ ���̺� �����ϴ� ����
public class Member {

//-------------------------------���� �޼���--------------------------------------
	public static void main(String[] args) {
		
		//�׽�Ʈ��
		//getConnection();	//���� ȣ��
		//createMember("GGG", "�迬��", "5678");	//������ �ƴ��� �׽�Ʈ�� ���̵����� ����
		//getMember();
		
	}//�޼��� ��
	
	//-------------------------------getConnection() �޼���--------------------------------------
	public static Connection getConnection() {	//mariaDB���� ������ con�̶�� ������ �����Ͽ� �����ҋ� ��� �ϱ� ���� �޼���
		try {
			//DB ���� �۾�
			String uri = "jdbc:mariadb://127.0.0.1:3306/chat";	//db���� ->  uri: ip�ּ�	/�����ͺ��̽���(chat)
			String userid = "supervisor"; //������DB�� ����� ����
			String userpw = "1111"; //������DB�� ����� ��й�ȣ
			String query = "select no, userid, username, userpw, regdate from ch_member";	//������ ���̺� ������
			Class.forName("org.mariadb.jdbc.Driver"); //(jdbc�ȿ� Driver���) /Class.forName() ->�� �̿��ؼ� ����̹� �ε�/Class.forName()�� Ŭ�����δ� ��� �༮�� ���ؼ� �ش� �����ͺ��̽� ����̹��� �ε��� �� �����ͺ��̽����� ���ῡ ���ؼ��� �ƹ��� ���۵� ���� ����
			Connection con = DriverManager.getConnection(uri, userid, userpw);	// DB���� ������  con ������ ����
			System.out.println("THE Connection Successfull");
			return con;
		}catch(Exception e){
			System.out.println(e.getMessage( ));
			return null;
		}
	}//getConnection�޼��� ��
	
	//----------------------------------createMember()-> ������ ����-----------------------------------------
	//DB�� ���� �޼���(ȸ������ ���� ����)
	public static void createMember(String inputUserid, String inputUsername, String inputUserpw) {
		try {
			Connection con = getConnection();	//��������(DB port,����� ����,����� ��й�ȣ)�� ȣ���Ͽ� ���� ->DB�� ���� �ϱ� ����
			PreparedStatement insert = con.prepareStatement(""
					+"INSERT INTO ch_member"		//���̺��:ch_member
					+"(userid, username, userpw)"	//������ ������ Į����
					+"VALUE "						//���� �� ������ ��
					+"('"+inputUserid+"', '"+inputUsername+"','"+inputUserpw+"')");	//�����͸� ���� �ֱ����� ������ �ۼ� (�Է��� ���̵�,�̸�,��й�ȣ�� ����)
			insert.executeUpdate(); //����  ������ ������ ����
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}//createMember�޼��� ��
	
	//----------------------------------getRegistrationMember()-> ������ ȣ�� ������ ���� �ʿ�-----------------------------------------
	//DB�� ���� �޼���(ȸ������ ���� ����)
	public static ArrayList<String> getRegistrationMember() {
		try {
			Connection con = getConnection();	//��������(DB port,����� ����,����� ��й�ȣ)�� ȣ���Ͽ� ���� ->DB�� ���� �ϱ� ����	
			
			//Statement, PreparedStatement �������̽� ������-> �� �������̽� ��� SQL ���ǹ� ����(�ݵ�� try-catch�Ǵ� throwsó�� �ʼ�),
			//������)Statement ��ü�� �����Ǹ� ->executeQuery( ) �޼ҵ带 ȣ���Ͽ� SQL���� �����ų �� �ִ�. �޼ҵ��� �μ��� SQL���� ���� String��ü�� �����Ѵ�.
			//������)PreparedStatement ->Connection ��ü�� preparedStatement( ) �޼ҵ带 ����ؼ� ����, Statement ��ü�� SQL�� ����� �� �Ź� �������� �м��ؾ� �ϴ� �ݸ�, PreparedStatement ��ü�� �� �� �м��Ǹ� ������ �����ϴ�.

			PreparedStatement statement = con.prepareStatement("SELECT userid FROM ch_member");		//�������� �ҷ����� ���� ������
			ResultSet results = statement.executeQuery();	// ResultSet�������̽� ->��ɿ� ���� ��ȯ�� ��, ������("Select * from ch_member")�� ���� ����� ������ ���̺��� ���� �������µ� ������ ������� ResultSet��ü��
			ArrayList<String> list_id = new ArrayList<String>();	//�ҷ��� DB�� ����Ʈ�� ����
			while(results.next()) {	//next()->���������� �ݺ��ؼ� add()�޼���� ���� list�迭�� ����
				list_id.add(results.getString("userid"));	
									}
			System.out.println(list_id.toString());	// ���������� �Ҿ�� ������ �׽�Ʈ
			return list_id;	//ArrayListŸ���� list�� �迭���·� ����� ���̵� ����-> list�� ��ȯ 
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}//getRegistrationMember()�޼��� ��

	//----------------------------------getLoginMember()-> ������ ȣ��( ID �Է�--> �ش� ���̵���PW ��ȯ) ��-----------------------------------------
	//DB�� ���� �޼���(ȸ������ ���� ����)
	public static String getLoginMember(String a) {	//�Ķ���Ͱ��� �̿��Ͽ� �Է¹��� ���̵� ���� where ���ǹ����� ������ �־ �ش� ���̵� �´� userpw ���� �������� ���
		try {
			Connection con = getConnection();	//��������(DB port,����� ����,����� ��й�ȣ)�� ȣ���Ͽ� ���� ->DB�� ���� �ϱ� ����	
			
			//Statement, PreparedStatement �������̽� ������-> �� �������̽� ��� SQL ���ǹ� ����(�ݵ�� try-catch�Ǵ� throwsó�� �ʼ�),
			//������)Statement ��ü�� �����Ǹ� ->executeQuery( ) �޼ҵ带 ȣ���Ͽ� SQL���� �����ų �� �ִ�. �޼ҵ��� �μ��� SQL���� ���� String��ü�� �����Ѵ�.
			//������)PreparedStatement ->Connection ��ü�� preparedStatement( ) �޼ҵ带 ����ؼ� ����, Statement ��ü�� SQL�� ����� �� �Ź� �������� �м��ؾ� �ϴ� �ݸ�, PreparedStatement ��ü�� �� �� �м��Ǹ� ������ �����ϴ�.
			
			String getPass="";
			PreparedStatement statement = con.prepareStatement("SELECT userpw FROM ch_member WHERE userid= '"+a +"'");		//�������� �ҷ����� ���� ������
			ResultSet results = statement.executeQuery();	// ResultSet�������̽� ->��ɿ� ���� ��ȯ�� ��, ������("Select * from ch_member")�� ���� ����� ������ ���̺��� ���� �������µ� ������ ������� ResultSet��ü��
			
			while(results.next()) {	//next()->���������� �ݺ��ؼ� add()�޼���� ���� list�迭�� ����
				getPass = results.getString("userpw");
				System.out.println(getPass);
			}
			/*
			ArrayList<String> list = new ArrayList<String>();	//�ҷ��� DB�� ����Ʈ�� �����ϱ� ���� ArrayList ����
			}
			*/
			//System.out.println(list.toString());	// ���������� �Ҿ�� ������ �׽�Ʈ
			return getPass;	//ArrayListŸ���� list�� �迭���·� ����� ���̵� ����-> list�� ��ȯ 
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}//getLoginMember()�޼��� ��
		
		//----------------------------------getLoginMember()-> ������ ȣ��( ID �Է�--> �ش� ���̵���PW ��ȯ) ��-----------------------------------------
		//DB�� ���� �޼���(ȸ������ ���� ����)
		public static String getMemberId(String a) {	//�Ķ���Ͱ��� �̿��Ͽ� �Է¹��� ���̵� ���� where ���ǹ����� ������ �־ �ش� �̸��� �´� ID ���� �������� ���
			try {
				Connection con = getConnection();	//��������(DB port,����� ����,����� ��й�ȣ)�� ȣ���Ͽ� ���� ->DB�� ���� �ϱ� ����	
				
				String getId="";
				PreparedStatement statement = con.prepareStatement("SELECT userid FROM ch_member WHERE username= '"+a +"'");		//��������(Id) �ҷ����� ���� ������
				ResultSet results = statement.executeQuery();	// ResultSet�������̽� ->��ɿ� ���� ��ȯ�� ��, ������("Select * from ch_member")�� ���� ����� ������ ���̺��� ���� �������µ� ������ ������� ResultSet��ü��
				
				while(results.next()) {	//next()->���������� �ݺ��ؼ� add()�޼���� ���� list�迭�� ����
					getId = results.getString("userid");
					System.out.println(getId);
				}
			
				return getId;	//ArrayListŸ���� list�� �迭���·� ����� ���̵� ����-> list�� ��ȯ 
				
			}catch (Exception e) {
				System.out.println(e.getMessage());
				return null;
			}
		
	}//getMemberId()�޼��� ��
		
		//----------------------------------getMemberPw()-> ������ ȣ��( ID �Է�--> �ش� ���̵���PW ��ȯ) ��-----------------------------------------
		//DB�� ���� �޼���(ȸ������ ���� ����)
		public static String getMemberPw(String a) {	//�Ķ���Ͱ��� �̿��Ͽ� �Է¹��� ���̵� ���� where ���ǹ����� ������ �־ �ش� �̸��� �´� ID ���� �������� ���
			try {
				Connection con = getConnection();	//��������(DB port,����� ����,����� ��й�ȣ)�� ȣ���Ͽ� ���� ->DB�� ���� �ϱ� ����	
				
				String getPw="";
				PreparedStatement statement = con.prepareStatement("SELECT userpw FROM ch_member WHERE userid= '"+a +"'");		//��������(Id) �ҷ����� ���� ������
				ResultSet results = statement.executeQuery();	// ResultSet�������̽� ->��ɿ� ���� ��ȯ�� ��, ������("Select * from ch_member")�� ���� ����� ������ ���̺��� ���� �������µ� ������ ������� ResultSet��ü��
				
				while(results.next()) {	//next()->���������� �ݺ��ؼ� add()�޼���� ���� list�迭�� ����
					getPw = results.getString("userpw");
					System.out.println(getPw);
				}
				
				return getPw;	//ArrayListŸ���� list�� �迭���·� ����� ���̵� ����-> list�� ��ȯ 
				
			}catch (Exception e) {
				System.out.println(e.getMessage());
				return null;
			}
			
		}//getMemberId()�޼��� ��

}//Ŭ���� ��