package ComputerNetwork_homework;

import java.io.*;
import java.net.*;


public class Server {

	public static void main(String args[]) throws Exception {
		
		try {
			
		String Client_of_Sentence = null;
		
		String result =  "학번을 전달받았습니다."; // Client에게 넘겨줄 data
		
		ServerSocket server = new ServerSocket(13345);  // bind를 통해 port번호를 넘겨줌.
		// 11234포트에서 동작하는 server의 socket생성
		
		System.out.println("____Server_is_Wating____"); //서버가 대기중이라는 것을 출력에 알려줌.
				
		Socket Connetcion_Socket = server.accept(); // Client가 연결을 요청. 그러면 소켓을 생성한다. 
		
		OutputStream out = Connetcion_Socket.getOutputStream(); //out을 연결. (요청을 받아들임)

        InputStream in = Connetcion_Socket.getInputStream(); //in을 연결. (요청을 받아들임)
	
		PrintWriter Server_rst = new PrintWriter(new OutputStreamWriter(out)); // outputStream으로 Client에게 데이터를 넘겨주기 위해서 생성.ㄴ 
    
		BufferedReader in_From_Client = new BufferedReader(new InputStreamReader(in)); 
		// Client로 부터 받은 데이터 (rec_v)
		
		
		while((Client_of_Sentence = in_From_Client.readLine()) != null) {
	
		
			System.out.println("Client로부터 받은 학번은 " + " " + Client_of_Sentence);
			//Client에게 학번을 전송한다.
			
			Server_rst.println(result); // print_writer를 이용해서 Client에게 server의 data를 전송. (send)
			System.out.println("클라이언트에게 학번을 잘 받았다고 전달했습니다.");
			Server_rst.flush(); // 비우기.

		}
		
		
		in_From_Client.close();
		server.close();
		Server_rst.close();
		Connetcion_Socket.close();
		
		}
		
		catch(Exception e) { // ERROR발생시 발생한 ERROR를 출력.
			
			System.out.println("Server ERROR is " + e);
		
		}
	}
	
}
		
	
	

