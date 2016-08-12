package tool;

import java.util.HashSet;
import java.util.Set;

public class LinkQueue {
	//�ѷ��ʵ�url����
	private static Set visitedUrl=new HashSet();//��hash��ķ�ʽ�洢
	//�����ʵ�url����
	private static Queue unVisitedUrl=new Queue();
	//���url����
	private static Queue getUnVisitedUrl(){
		return unVisitedUrl;
	}
	//��ӵ����ʵ�url������
	public static void addVisitedUrl(String url){
		visitedUrl.add(url);
	}
	//�Ƴ����ʹ���url
	public static void removeVisitedUrl(String url){
		visitedUrl.remove(url);
	}
	//δ���ʵ�url������
	public static Object unVisitedUrlDeQueue(){
		return unVisitedUrl.deQueue();
	}
	//��֤ÿurlֻ������һ��
	public static void addUnvisitedUrl(String url){
		if(url!=null&!url.trim().equals("")
				&&!visitedUrl.contains(url)
				&&!unVisitedUrl.contains(url)){
			unVisitedUrl.enQueue(url);
		}
	}
	//����Ѿ����ʵ�url��Ŀ
	public static int getVisitedUrlNum(){
		return visitedUrl.size();
	}
	//�ж�δ���ʵ�url�����Ƿ�Ϊ��
	public static boolean unVisitedUrlIsEmpty(){
		return unVisitedUrl.empty();
	}
}
