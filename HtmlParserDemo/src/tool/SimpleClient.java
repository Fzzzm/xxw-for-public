package tool;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleClient {

	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
		try{
		Socket s1=new Socket("localhost",8000);
		System.out.println("��һ�����ӳɹ�");
		Socket s2=new Socket("localhost",8000);
		System.out.println("�ڶ������ӳɹ�");
		Socket s3=new Socket("localhost",8000);
		System.out.println("���������ӳɹ�");
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

}
