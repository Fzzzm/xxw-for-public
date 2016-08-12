package bean;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import method.Util;

/**
 * ֪��ͼƬbean
 * 
 * @author KKys
 *
 */
public class ZhiHuPicBean {

    String zhihuUrl;// ��ҳ����
    
	String question;// ����;
	
	ArrayList<String> zhihuPicUrl;// ͼƬ����

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public ArrayList<String> getZhihuPicUrl() {
		return zhihuPicUrl;
	}

	public void setZhihuPicUrl(ArrayList<String> zhihuPicUrl) {
		this.zhihuPicUrl = zhihuPicUrl;
	}

	// ���췽����ʼ������
	public ZhiHuPicBean(String url) {
		zhihuUrl = "";
		zhihuPicUrl = new ArrayList<String>();
		// �ж�url�Ƿ�Ϸ�
		if (getRealUrl(url)) {
			System.out.println("����ץȡ֪�����ӣ�" + url);
			// ����url��ȡ���ʴ��ϸ��
			String content = Util.SendGet(url);
			Pattern pattern;
			Matcher matcher;
			// ƥ�����
			pattern = Pattern.compile("zh-question-title.+?<h2.+?>(.+?)</h2>");
			matcher = pattern.matcher(content);
			if (matcher.find()) {
				question = matcher.group(1);
			}
			// ƥ���
			pattern = Pattern.compile("</noscript><img.+?src=\"(https.+?)\".+?");
			matcher = pattern.matcher(content);
			boolean isFind = matcher.find();
			while (isFind) {
				zhihuPicUrl.add(matcher.group(1));
				isFind = matcher.find();
			}
		}
	}

	// ����url
	boolean getRealUrl(String url) {
		// ��http://www.zhihu.com/question/22355264/answer/21102139
		// ת����http://www.zhihu.com/question/22355264
		// ���򲻱�
		Pattern pattern = Pattern.compile("question/(.*?)");
		Matcher matcher = pattern.matcher(url);
		if (matcher.find()) {
			url = "http://www.zhihu.com/question/" + matcher.group(1);
		} else {
			return false;
		}
		return true;
	}
}
