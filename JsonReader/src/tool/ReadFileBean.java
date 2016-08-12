package tool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadFileBean {
	/**��ȡjson�ļ��е�����
	 * @param source Ҫ��ȡ���ļ�
	 * @author Ѧ��ΰ*/
	public String readFromFile(File source){
		Scanner scanner=null;
		StringBuilder buffer=new StringBuilder();
		try {
			scanner=new Scanner(source,"utf-8");
			while (scanner.hasNextLine()) {
				buffer.append(scanner.nextLine());
			}
			return buffer.toString().substring(1);
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}finally{
			if(scanner!=null)
				scanner.close();
		}
	}
}
