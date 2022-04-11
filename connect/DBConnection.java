package com.chat.connect;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.chat.VO.MemberVO;

//Dynamic Web Project : JSP�� ���� ������ ���������� ������ �� ���ø����̼� ���� �ÿ� ����ϴ� ������Ʈ
//DATABASE�� JAVA ����  (DB���� Ȯ�ο� Ŭ����)
public class DBConnection  {
	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException{
	
	//---------------------------------------MariaDB ����------------------------------------------------	
	//DB �����ؼ� �����͸� �ҷ����̴� �۾�
	String uri = "jdbc:mariadb://127.0.0.1:3306/chat";	//db���� ->  uri: ip�ּ�	/�����ͺ��̽���(chat)
	String userid = "supervisor"; //������DB�� ����� ����
	String userpw = "1111"; //������DB�� ����� ��й�ȣ
	String query = "select no, userid, username,userpw, regdate from ch_member";	//������ ���̺� ������
	Class.forName("org.mariadb.jdbc.Driver"); //(jdbc�ȿ� Driver���) /Class.forName() ->�� �̿��ؼ� ����̹� �ε�/Class.forName()�� Ŭ�����δ� ��� �༮�� ���ؼ� �ش� �����ͺ��̽� ����̹��� �ε��� �� �����ͺ��̽����� ���ῡ ���ؼ��� �ƹ��� ���۵� ���� ����
	
	//----------------------------------------DB������ ��üȭ------------------------------------------------	
	Connection con; //Connection�������̽�->Ư�������� ���� Ŀ�ؼ��� Connection �������̽��� ������ Ŭ������ ��ü�� ǥ��
	Statement stmt;	//Statement�������̽��� Connection ��ü�� ���� ���α׷��� ���ϵǴ� ��ü�� ���� �����Ǵ� ������ �޼ҵ� ������ ���� (���� X �߰������ʿ�)->Statement��ü�� �Ķ���Ͱ� ���� SQL�� ���޿� ����
	ResultSet rs;	//ResultSet�������̽� ->SQL������ SELECT���� ����� ������ ��� ������->������� ResultSet ��ȯ(�������̽��� ���� �ּ��� ��ȯ ��������)(SQL ���ǿ� ���� ������ ���̺� �������)/ ResultSet��ü->'Ŀ��(cursor)��� �Ҹ��°��� ������ ����(Ư�� �࿡ ���� ������ ����)/Ŀ����->ResultSet��ü�� ������ ���ִ� ���� ��ġ�� ���� (���� ��α� https://codedragon.tistory.com/5975)
	
	
	try {	//DB�� ��Ʈ��ũ ������ ���� ��� ������ �߻��� �� �ֽ��ϴ�. �̿� **�ݵ��** try-catch ������ ������ ��� StackTrace�� ���� ���� Exception�� �߻��� ��ġ�� ��Ȯ�� �� �� �ֵ����ؾ� ��
	
	con = DriverManager.getConnection(uri, userid, userpw);	//DriverManager.getConnection() ���� ���� ���
	stmt = con.createStatement();	//createStatement �� static parsing ���� sql���� parsing �� �� �Էµ� �ش� ���� sql���� binding�Ͽ� ���� parsing �Ͽ� �����Ѵ�
	rs = stmt.executeQuery(query);	//������ ������ �־���	//��ü�ǰ��� ��ȯ  
	
	List<MemberVO> list = new ArrayList<>();	//DB�� �����Ͱ��� ������ ����
	
	//----------------------------------------DB���� Ȯ�ο� ������ ���------------------------------------------------	
	while(rs.next()) {	//���ڵ�(������ ����)�� While���� ���� ��� �޾ƿ�	//������ ����� ���� ��Ҹ� �����մϴ�.
		
		rs.getString("userid"); // Result��ü�� �̿� -> SELECT���� ����� getString()�޼��带 �̿��Ͽ� �̾ƿ�
		
		list.add(new MemberVO(rs.getInt("no"),
								rs.getString("userid"),
								rs.getString("username"),
								rs.getString("userpw"),
								rs.getString("regdate")));
	}//while�� ��
	
	 
	//DB�� ������ ���������� �ƴ��� Ȯ�ο� ������ ��� 
	for(MemberVO member: list)		//���� for���� Ȱ���Ͽ� �迭�� ��� ������ ������ ���������� ������ ���
		System.out.println("�����ȣ = " +member.getNo()
				+", ���̵� = " + member.getUserid()
				+", �̸� = " + member.getUsername()
				+", �н����� = " + member.getUserpw()
				+", ���Գ�¥ = " + member.getRegdate());
	
	//    ResultSet, Statement, Connection�� null�� �ƴ϶��, �� ��� �����͸� �޾ƿ��� �� ���α׷��� ���Ͽ� ���Ǿ��ٸ�, ���ҽ� ������ ���� �ݵ�� ����.
	if(rs != null)rs.close();
	if(stmt != null)stmt.close();
	if(con != null)con.close();
	
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	}//���θ޼��� ��
	
	
}//Ŭ���� ��
