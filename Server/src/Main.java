import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.*;


public class Main extends JFrame {
	
	public static ExecutorService threadPool;
	public static Vector<Client> clients = new Vector<Client>();
	String IP = "127.0.0.1";
	int port = 9876;
	
	ServerSocket serverSocket;
	
	// ������ �������� Ŭ���̾�Ʈ�� ������ ��ٸ��� �޼ҵ�
	public void startServer(String IP, int port) {
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(IP, port));
		} catch(Exception e) {
			e.printStackTrace();
			if(!serverSocket.isClosed())
				stopServer();
			return;
		}
		
		// Ŭ���̾�Ʈ�� ������ ������ ��� ��ٸ��� ������
		Runnable thread = new Runnable() {
			@Override
			public void run() {
				while(true) {
					try {
						Socket socket = serverSocket.accept();
						clients.add(new Client(socket));
						System.out.println("[Ŭ���̾�Ʈ ����] "
								+ socket.getRemoteSocketAddress()
								+ ": " + Thread.currentThread().getName());
					} catch(Exception e) {
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
	
	// ������ �۵��� ������Ű�� �޼ҵ�
	public void stopServer() {
		try {
			// �۵����� ��� ���� �ݱ�
			Iterator<Client> iterator = clients.iterator();
			while(iterator.hasNext()) {
				Client client = iterator.next();
				client.socket.close();
				iterator.remove();
			}
			// ���� ���� ��ü �ݱ�
			if(serverSocket != null && !serverSocket.isClosed())
				serverSocket.close();
			// ������Ǯ �����ϱ�
			if(threadPool != null && !threadPool.isShutdown())
				threadPool.shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
//	// ui�� �����ϰ� ���������� ���α׷��� ������Ű�� �޼ҵ�
//	public void start(Stage primaryStage) {
//		
//	}
	
	// ���α׷��� ������
	public static void main(String[] args) {
		new Start();
	}
}
