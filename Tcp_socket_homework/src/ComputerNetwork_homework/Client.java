package ComputerNetwork_homework;

import java.io.*;
import java.net.*;

public class Client {

	public static void main(String [] args ) {
		
		try {
		
		System.out.println("Connetcing...");
		
		Socket Client_Socket = new Socket ("127.0.0.1", 13345); //make a socket and bind
			
		BufferedReader in_From_User = new BufferedReader(new InputStreamReader(System.in)); // ����ڷκ��� message�� �Է¹���.
	
		
		OutputStream out_to_server = Client_Socket.getOutputStream(); // connect
		InputStream in_to_Server = Client_Socket.getInputStream(); // connect
		
		PrintWriter sentence = new PrintWriter(new OutputStreamWriter(out_to_server)); // ������ ���� �޼��� ->send
		
		BufferedReader From_Server = new BufferedReader(new InputStreamReader(in_to_Server)); // �����κ��� ���� data ��ü
		
		String requst = null;
		
		
		while((requst = in_From_User.readLine()) != null) {
			
			sentence.println(requst); // �������� ����ڷκ��� ���� �޼����� ���� -> send
			sentence.flush(); // ����.
			
			String respone = null;
			
			respone = From_Server.readLine(); // �����κ��� ���� data. -> rec_v			
		
			System.out.println(respone);
		
		}
		
		sentence.close();
		From_Server.close();
		Client_Socket.close();
		
		}
		
		catch(Exception e) {
			
			System.out.println("Client ERROR is " + e);
		
		}
	
	}
	
}
