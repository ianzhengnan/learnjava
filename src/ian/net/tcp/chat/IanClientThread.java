package ian.net.tcp.chat;

import java.io.BufferedReader;
import java.io.IOException;

public class IanClientThread extends Thread{

	BufferedReader br = null;

	public IanClientThread(BufferedReader br){
		this.br = br;
	}

	public void run(){
		try{
			String line = null;
			// 不断地从输入流中读取数据，并将这些信息打印
			while((line = br.readLine()) != null){
				System.out.println(line);
			}
		}catch(IOException ex){
			ex.printStackTrace();
		}finally{
			try{
				if (br != null) {
					br.close();
				}
			}catch(IOException ex){
				ex.printStackTrace();
			}
		}
	}
}