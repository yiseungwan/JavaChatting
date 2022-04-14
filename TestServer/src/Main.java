import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


import java.io.*;
import java.net.*;
import java.net.ServerSocket;
import java.util.*;
import java.util.concurrent.*;


public class Main extends JFrame {
	
	public static ExecutorService threadPool;
	public static Vector<Client> clients = new Vector<Client>();
	// 접속해있는 user들을 저장해놓는 ArrayList
	public static ArrayList<String> Users = new ArrayList<String>();
//	public static HashMap<String, String> Users = new HashMap<String, String>();
	
	ServerSocket serverSocket;
	
	// 서버를 구동시켜 클라이언트의 연결을 기다리는 메소드
	public void startServer(String IP, int port) {
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(IP, port));
		} catch (Exception e) {
			e.printStackTrace();
			if(!serverSocket.isClosed())
				stopServer();
			return;
		}
	
		// 클라이언트가 접속할 때까지 계속 기다리는 쓰레드
		Runnable thread = new Runnable() {
			@Override
			public void run() {
				while(true) {
					try {
						Socket socket = serverSocket.accept();
						clients.add(new Client(socket));
						System.out.println("[클라이언트 접속] "
								+ socket.getRemoteSocketAddress()
								+ ": " + Thread.currentThread().getName());
					} catch (Exception e) {
						if(!serverSocket.isClosed())
							stopServer();
						break;
					}
				}
			}
		};
		threadPool = Executors.newCachedThreadPool();
		threadPool.submit(thread);
	}
	
	// 서버의 작동을 중지시키는 메소드
	public void stopServer() {
		try {
			// 작동중인 모든 소켓 닫기
			Iterator<Client> iterator = clients.iterator();
			while(iterator.hasNext()) {
				Client client = iterator.next();
				client.socket.close();
				iterator.remove();
			}
			// 서버 소켓 객체 닫기
			if(serverSocket != null && !serverSocket.isClosed())
				serverSocket.close();
			// 쓰레드풀 종료하기
			if(threadPool != null && !threadPool.isShutdown())
				threadPool.shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// 프로그램 진입점
	public static void main(String[] args) {
		new Start();
	}
}
