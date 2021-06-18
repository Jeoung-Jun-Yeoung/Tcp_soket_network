package ComputerNetwork_homework;

import java.io.*;
import java.net.*;

public class Client {

	public static void main(String [] args ) {
		
		try {
		
		System.out.println("Connetcing...");
		
		Socket Client_Socket = new Socket ("127.0.0.1", 13345); //make a socket and bind
			
		BufferedReader in_From_User = new BufferedReader(new InputStreamReader(System.in)); // 사용자로부터 message를 입력받음.
	
		
		OutputStream out_to_server = Client_Socket.getOutputStream(); // connect
		InputStream in_to_Server = Client_Socket.getInputStream(); // connect
		
		PrintWriter sentence = new PrintWriter(new OutputStreamWriter(out_to_server)); // 서버로 보낼 메세지 ->send
		
		BufferedReader From_Server = new BufferedReader(new InputStreamReader(in_to_Server)); // 서버로부터 받은 data 객체
		
		String requst = null;
		
		
		while((requst = in_From_User.readLine()) != null) {
			
			sentence.println(requst); // 서버에게 사용자로부터 받은 메세지를 보냄 -> send
			sentence.flush(); // 비우기.
			
			String respone = null;
			
			respone = From_Server.readLine(); // 서버로부터 받은 data. -> rec_v			
		
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
