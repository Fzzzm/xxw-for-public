package method;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.ZhiHuBean;
import bean.ZhiHuPicBean;
import bean.ZhiHuUserBean;

public class Spider {

	/**
	 * ��֪��ͼƬ�������ص�����
	 * @throws Exception 
	 */
	public static void downloadPic(String url) throws Exception {
		// ���췽����url����ȡZhiHuPicBean
		ZhiHuPicBean myZhihu = new ZhiHuPicBean(url);
		// ��ȡZhiHuPicBean�е�ͼƬ�б�
		ArrayList<String> picList = myZhihu.getZhihuPicUrl();
		// ��ӡ���
		System.out.println("");
		System.out.println("���⣺" + myZhihu.getQuestion());
		System.out.println("");
		// ѭ�����ڿ���̨��ӡͼƬ��ַ
		for (String zhiHuPic : picList) {
			System.out.println(zhiHuPic);
		}
		System.out.println("");
		//��������·��
		String addr = "D:/֪������/";
		System.out.println("������ʼ����ͼƬ��"+addr+myZhihu.getQuestion());
		System.out.println("");
		System.out.println("��ʼ����................");
		System.out.println("");
		// ��ͼƬ���ص������ļ���
		FileReaderWriter.downLoadPics(myZhihu, addr);
		System.out.println("");
		System.out.println("ͼƬ������ϣ��뵽"+addr+myZhihu.getQuestion()+"��ȥ�����ɣ�����");
	}


	/**
	 * ��ȡָ�����������о���������ߵ�Ʊ�˵���Ϣ
	 * @throws Exception 
	 */
	public static void getTopUserInfo(String url) throws Exception {
		//������ʼҳΪ��һҳ
		int page = 1;
		//����baseUrl
		String baseUrl = "https://www.zhihu.com";
		/**
		 * jdbc�Ĵ����ò�����
		 * 1.driverClassName:com.mysql.jdbc.Driver
		 * 2.url:jdbc:mysql://localhost:3306/mydb
		 * 3.username:root
		 * 4.password:123
		 */
		Class.forName("com.mysql.jdbc.Driver");//����������(ע��������)
		String mySqlUrl="jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8";
		//String mySqlUrl = "jdbc:mysql://localhost:3306/user_info";
		String username = "root";
		String password = "******";
		
		//�õ����Ӷ���
		Connection con = DriverManager.getConnection(mySqlUrl, username, password);
			
		/*�����ݿ�������ɾ����
		 * 1.ͨ��Connection���󴴽�Statement
		 *   Statement���ķ����������Ĺ��ܾ��������ݿⷢ��sql��䣡
		 * 2.��������int executeUpdate(String sql),����Ӱ���˼���
		 */
		//ͨ��Connection �õ�Statement;
		Statement stmt = con.createStatement();
		
		//ѭ�������һҳ���ֱ���ȡÿһҳ�Ļش���������һ���û�
		for (page = 1;page<=50;page++){
			// ���弴�����ʵ����ӣ���ʼ��һҳ
			String nowUrl = url+"?page="+page;
			List<String> userUrls = Util.getUserUrl(nowUrl);
			// ѭ���������Ӳ���ȡ�û���Ϣ
			for(String userUrl:userUrls){
				//��ʼ���ظ�ֵ
				ZhiHuUserBean user = new ZhiHuUserBean(baseUrl+userUrl);
				//��ӡ��ǰ�û���Ϣ
				System.out.println(user);
				//ʹ��Statement����sql���
				String sql = "INSERT INTO user(name,location,business,employment,position,education,major,userInfo,answersNum,starsNum,thxNum)"
						+ " VALUES('"+user.getName()+"','"+user.getLocation()+"','"+user.getBusiness()+"','"
						+user.getEmployment()+"','"+user.getPosition()+"','"+user.getEducation()+"','"
						+user.getMajor()+"','"+user.getUserInfo()+"',"+user.getAnswersNum()+","
						+user.getStarsNum()+","+user.getThxNum()+")";
				//ִ��sql
				stmt.executeUpdate(sql);
				System.out.println("��Ϣ�������ݿ�ɹ���");
				System.out.println();
			}
		}
	}


	/**
	 * ��֪���Ƽ�������
	 */
	public static void downloadCommend(String url){
		 // �������Ӳ���ȡҳ������
		 String content = Util.SendGet(url);
		 // ��ȡ��ҳ������е�֪������
		 ArrayList<ZhiHuBean> myZhihu = Util.GetRecommendations(content);
		 for (ZhiHuBean zhihu : myZhihu) {
		 FileReaderWriter.writeIntoFile(zhihu.writeString(),"D:/֪���༭�Ƽ�.txt",true);
		 }
	}
}
