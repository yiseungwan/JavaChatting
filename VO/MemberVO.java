
//������� �� ������Ʈ���� VO�� ����ϰ� ���� �ʴ� ��
package com.chat.VO;

//DB�� ����� ���������̺� (ch_member)
public class MemberVO {

		private int no;
		private String userid;
		private String username;
		private String userpw;
		private String regdate;
		
		//--------------------constructor-----------------------
		public MemberVO(int no,String userid,String username,String userpw, String regdate) {
			this.no = no;
			this.userid = userid;
			this.username = username;
			this.userpw = userpw;
			this.regdate = regdate;
			
		}
		//---------------------getter setter---------------------
		public int getNo() {
			return no;
		}
		public String getUserid() {
			return userid;
		}
		public void setUserid(String userid) {
			this.userid = userid;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getUserpw() {
			return userpw;
		}
		public void setUserpw(String userpw) {
			this.userpw = userpw;
		}
		public String getRegdate() {
			return regdate;
		}
		
		
}
