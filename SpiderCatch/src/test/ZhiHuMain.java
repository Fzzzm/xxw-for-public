package test;

import method.*;


/**
 * ������
 * ����1��ץȡ֪��ָ�������µ�ͼƬ������ 
 * ����2����ȡ֪��ָ�����������о���������ߵ�Ʊ�˵�������Ϣ�������뵽�������ݿ�
 * ����3��ץȡ֪���Ƽ����ݲ�д�뱾��
 * ѡ������һ��������ֻ�轫urlƥ�䵽��ǰ��������
 * 
 * @author KKys
 *
 */
public class ZhiHuMain {

	public static void main(String[] args) throws Exception {
		
		//������Ҫץȡҳ���url����ʽ��������
		//��ǰurl��Ӧ����һ
		//String url = "https://www.zhihu.com/question/28594126";
		String url="https://www.zhihu.com/topic/19601705/top-answers";
		/*
		 * ����һ��ץȡ֪��ͼƬ�������ص������ļ���
		 * ���ص�ַ��Spider.downloadPic���޸�
		 * url����"https://www.zhihu.com/question/28594126";
		 */
		//Spider.downloadPic(url);
		
		
		/*
		 * ����������ȡָ�����������о���������ߵ�Ʊ�˵���Ϣ�������뵽�������ݿ�
		 * ���ݿ���Ϣ��Spider.getTopUserInfo���޸�
		 * url����"https://www.zhihu.com/topic/19570261/top-answers"
		 */
		Spider.getTopUserInfo(url);
		
		
		/*
		 * ����������֪���Ƽ������ݣ�������txt�ļ�
		 * ���ص�ַ��Spider.downloadCommend���޸�
		 * url:"https://www.zhihu.com/explore/recommendations"
		 */
//		Spider.downloadCommend(url);
	}
}

