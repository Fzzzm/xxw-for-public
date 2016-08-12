package method;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bean.ZhiHuBean;

public class Util {
	public static String SendGet(String url) {
		// ����һ���ַ��������洢��ҳ����
		String result = "";
		// ����һ�������ַ�������
		BufferedReader in = null;
		try {
			// ��stringת��url����
			URL realUrl = new URL(url);
			// ��ʼ��һ�����ӵ��Ǹ�url������
			URLConnection connection = realUrl.openConnection();
			// ��ʼʵ�ʵ�����
			connection.connect();
			// ��ʼ�� BufferedReader����������ȡURL����Ӧ
			in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
			// ������ʱ�洢ץȡ����ÿһ�е�����
			String line;
			while ((line = in.readLine()) != null) {
				// ����ץȡ����ÿһ�в�����洢��result����
				result += line;
			}
		} catch (Exception e) {
			System.out.println("����GET��������쳣��" + e);
			e.printStackTrace();
		}
		// ʹ��finally���ر�������
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	// ֻƥ��url
	public static ArrayList<ZhiHuBean> GetRecommendations(String content) {
		// Ԥ����һ��ArrayList���洢���
		ArrayList<ZhiHuBean> results = new ArrayList<ZhiHuBean>();
		Pattern urlPattern = Pattern.compile("<h2>.+?question_link.+?href=\"(.+?)\".+?</h2>");
		Matcher urlMatcher = urlPattern.matcher(content);
		// ���������Ҫ����ƥ�䵽
		boolean isFind = urlMatcher.find();
		while (isFind) {
			// ����һ��֪���������洢ץȡ������Ϣ
			ZhiHuBean zhuhuTemp = new ZhiHuBean(urlMatcher.group(1));
			// ��ӳɹ�ƥ��Ľ��
			results.add(zhuhuTemp);
			// ����������һ��ƥ�����
			isFind = urlMatcher.find();
		}
		return results;
	}
	
	//�洢��ǰ����ҳ���µ��û�url
	public static List<String> getUserUrl(String url) {
		//�½�һ��List����û�url�б�
		List<String> userUrls = new ArrayList<String>();
		String content = Util.SendGet(url);
		Pattern pattern;
		Matcher matcher;
		// �û�url
		pattern = Pattern.compile("author-link.+?href=\"(.*?)\">");
		matcher = pattern.matcher(content);
		boolean isFind = matcher.find();
		while (isFind) {
			userUrls.add(matcher.group(1));
			isFind = matcher.find();
		}
		return userUrls;
	}
}
