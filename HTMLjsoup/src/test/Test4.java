package test;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Document document=Jsoup.connect("http://www.lagou.com/jobs/2169529.html?source=home_hot&i=home_hot-0").get();
			Element link=document.select("a").first();
			String text=document.body().text();//ȡ���ַ����е��ı�
			System.out.println(text);
			System.out.println("------------");
			String linkHref=link.attr("href");//ȡ�����ӵ�ַ
			System.out.println(linkHref);
			System.out.println("------------");
			String linkTextString=link.text();//ȡ�������ı�
			System.out.println(linkTextString);
			System.out.println("------------");
			String outLink=link.outerHtml();
			System.out.println(outLink);
			System.out.println("------------");
			String linkInnerH=link.html();//ȡ�������ڵ�html����
			System.out.println(linkInnerH);
			System.out.println("------------");
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

}
