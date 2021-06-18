package ComputerNetwork_homework;

import java.io.*;
import java.net.*;


public class Server {

	public static void main(String args[]) throws Exception {
		
		try {
			
		String Client_of_Sentence = null;
		
		String result =  "�й��� ���޹޾ҽ��ϴ�."; // Client���� �Ѱ��� data
		
		ServerSocket server = new ServerSocket(13345);  // bind�� ���� port��ȣ�� �Ѱ���.
		// 11234��Ʈ���� �����ϴ� server�� socket����
		
		System.out.println("____Server_is_Wating____"); //������ ������̶�� ���� ��¿� �˷���.
				
		Socket Connetcion_Socket = server.accept(); // Client�� ������ ��û. �׷��� ������ �����Ѵ�. 
		
		OutputStream out = Connetcion_Socket.getOutputStream(); //out�� ����. (��û�� �޾Ƶ���)

        InputStream in = Connetcion_Socket.getInputStream(); //in�� ����. (��û�� �޾Ƶ���)
	
		PrintWriter Server_rst = new PrintWriter(new OutputStreamWriter(out)); // outputStream���� Client���� �����͸� �Ѱ��ֱ� ���ؼ� ����.�� 
    
		BufferedReader in_From_Client = new BufferedReader(new InputStreamReader(in)); 
		// Client�� ���� ���� ������ (rec_v)
		
		
		while((Client_of_Sentence = in_From_Client.readLine()) != null) {
	
		
			System.out.println("Client�κ��� ���� �й��� " + " " + Client_of_Sentence);
			//Client���� �й��� �����Ѵ�.
			
			Server_rst.println(result); // print_writer�� �̿��ؼ� Client���� server�� data�� ����. (send)
			System.out.println("Ŭ���̾�Ʈ���� �й��� �� �޾Ҵٰ� �����߽��ϴ�.");
			Server_rst.flush(); // ����.

		}
		
		
		in_From_Client.close();
		server.close();
		Server_rst.close();
		Connetcion_Socket.close();
		
		}
		
		catch(Exception e) { // ERROR�߻��� �߻��� ERROR�� ���.
			
			System.out.println("Server ERROR is " + e);
		
		}
	}
	
}
		
	
	

