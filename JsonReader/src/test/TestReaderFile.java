package test;

import java.io.File;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import tool.ReadFileBean;

public class TestReaderFile {
	public static void main(String args[]){
		ReadFileBean reader=new ReadFileBean();
		File file=new File("C:\\Users\\xxw\\Desktop\\hello.json");
		//System.out.println(reader.readFromFile(file));
		String json=reader.readFromFile(file);
		try {
			JSONObject jsonObject=new JSONObject(json);
			//System.out.println(jsonObject.getString("content"));
			JSONObject result=new JSONObject(jsonObject.getString("content"));
			String result2=result.getString("positionResult");
			JSONObject results2=new JSONObject(result2);
			JSONArray results=results2.getJSONArray("result");
			for (int i = 0; i < results.length(); i++) {
				JSONObject jsonObject2=results.getJSONObject(i);
				System.out.println("��"+i+"����Ϣ");
				System.out.println("����ְλ��"+jsonObject2.getString("positionName"));
				System.out.println("ѧ��Ҫ��"+jsonObject2.getString("education"));
				System.out.println("�����ص㣺"+jsonObject2.getString("city"));
				System.out.println("�ɳ������"+jsonObject2.getString("financeStage"));
				System.out.println(jsonObject2.getString("createTime"));
				System.out.println("---------------------------");
			}
		} catch (JSONException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
