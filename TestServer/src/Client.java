import java.net.*;
import java.io.*;
import java.util.*;


public class Client extends Main{
	
	Socket socket;
	
	public Client(Socket socket) {
		this.socket = socket;
		receive();
	}
	
	// 반복적으로 클라이언트로부터 메세지를 받는 메소드
	public void receive() {
		Runnable thread = new Runnable() {
			@Override
			public void run() {
				try {
					while(true) {
						InputStream in = socket.getInputStream();
						byte[] buffer = new byte[512];
						
						int length = in.read(buffer);
						if(length == -1) throw new IOException();
						System.out.println("[메세지 수신 성공] "
								+ socket.getRemoteSocketAddress()
								+ ": " + Thread.currentThread().getName());
						
						String message = new String(buffer, 0, length, "UTF-8");
						String user_name = message.split(":")[0];
						
						// 입력된 user_name이 기존의 ArrayList와 중복되는지 확인하기 위한 flag
						Boolean flag = true;
						// 모든 ArrayList의 원소들을 순회하면서 user_name이 중복되는지 체크. 중복될 경우에는 flag = false
						for(int i = 0; i < Users.size(); i++) {
							if (Users.get(i).equals(user_name)) {
								flag = false;
							}
						}
						// flag가 true -> ArrayList와 user_name이 중복되지 않았다 -> ArrayList에 user_name을 add
						if (flag == true) {
							Users.add(user_name);
						}

						// 이 특수문자를 분기점으로 split을 통해 userList를 전송할 계획이라 분기점이 될 특수문자는 일상에서 쓰이지 않는 특수문자로 지정함
						String UserList = "▒";
						//UserList에 모든 Users를 더해주기.  user1 user2... 같이 저장됨
						for(var i = 0; i < Users.size(); i++) {
							// UserList에서는 ArrayList에서 원소들을 가져올 때마다 행바꿈을 해주는 \n를 더해줌. client에서 userArea에 넣기 쉽게 하기 위함
							UserList = UserList + Users.get(i) + "\n";
						}
						// message에 유저명, 메세지, 유저리스트까지 붙여줌. user: message▒user1 user2..
						message += UserList;
						// 모든 정보가 혼합된 message를 client로 send
						for(Client client : Main.clients) {
							client.send(message);
						}
					}
				} catch (Exception e) {
					try {
						System.out.println("[메시지 수신 오류] "
								+ socket.getRemoteSocketAddress()
								+ ": " + Thread.currentThread().getName());
						Main.clients.remove(Client.this);
						socket.close();
					} catch(Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		};
		Main.threadPool.submit(thread);
	}

	// 클라이언트에게 메세지를 전송하는 메소드
	public void send(String message) {
		Runnable thread = new Runnable() {
			@Override
			public void run() {
				try {
					OutputStream out = socket.getOutputStream();
					byte[] buffer = message.getBytes("UTF-8");
					out.write(buffer);
					out.flush();
				} catch (Exception e) {
					try {
						System.out.println("[메시지 송신 오류] "
								+ socket.getRemoteSocketAddress()
								+ ": " + Thread.currentThread().getName());
						Main.clients.remove(Client.this);
						socket.close();
					} catch(Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		};
		Main.threadPool.submit(thread);		
	}
}
