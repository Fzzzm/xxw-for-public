package test;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test6 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Document document=Jsoup.connect("http://www.lagou.com/jobs/857555.html").get();
			Element element=document.select("meta[name]").get(2);
			
			/*��ú��й������ơ���˾���Ƶ��ַ���,֮����Խ��н�һ���Ľ���*/
			System.out.println(element.attr("content"));
			
			/*��ù����ַ���*/
			Element salary=document.getElementsByTag("span").get(3);
			System.out.println(salary.text());
			
			/*��ù�˾��ַ*/
			Element address=document.getElementsByTag("span").get(4);
			System.out.println(address.text());
			
			/*��ù�������*/
			Element experience=document.getElementsByTag("span").get(5);
			System.out.println(experience.text());
			
			/*���ѧ��Ҫ��*/
			Element education=document.getElementsByTag("span").get(6);
			System.out.println(education.text());	
			
			/*���������������*/
			Elements results=document.select(".c_feature").select("li");
			
			/*����*/
			System.out.println(results.get(0).text());
			
			/*����*/
			System.out.println(results.get(3).text());
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
