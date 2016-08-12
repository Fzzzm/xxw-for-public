package bean;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import method.*;

public class ZhiHuBean {
	String question;// ����
	
	String questionDescription;// ��������
	
	String zhihuUrl;// ��ҳ����
	
	ArrayList<String> answers;// �洢���лش������

	// ���췽����ʼ������
	public ZhiHuBean(String url) {
		question = "";
		questionDescription = "";
		zhihuUrl = "";
		answers = new ArrayList<String>();
		// �ж�url�Ƿ�Ϸ�
		if (getRealUrl(url)) {
			System.out.println("����ץȡ֪�����ӣ�" + zhihuUrl);
			// ����url��ȡ���ʴ��ϸ��
			String content = Util.SendGet(zhihuUrl);
			Pattern pattern;
			Matcher matcher;
			// ƥ�����
			pattern = Pattern.compile("zh-question-title.+?<h2.+?>(.+?)</h2>");
			matcher = pattern.matcher(content);
			if (matcher.find()) {
				question = matcher.group(1);
			}
			// ƥ������
			pattern = Pattern.compile("zh-question-detail.+?<div.+?>(.*?)</div>");
			matcher = pattern.matcher(content);
			if (matcher.find()) {
				questionDescription = matcher.group(1);
			}
			// ƥ���
			pattern = Pattern.compile("/answer/content.+?<div.+?>(.*?)</div>");
			matcher = pattern.matcher(content);
			boolean isFind = matcher.find();
			while (isFind) {
				answers.add(matcher.group(1));
				isFind = matcher.find();
			}
		}
	}

	@Override
	public String toString() {
		return "���⣺" + question + "\n" + "������" + questionDescription + "\n" + "���ӣ�" + zhihuUrl + "\n�ش�" + answers
				+ "\n";
	}

	// ����url
	boolean getRealUrl(String url) {
		// ��http://www.zhihu.com/question/22355264/answer/21102139
		// ת����http://www.zhihu.com/question/22355264
		// ���򲻱�
		Pattern pattern = Pattern.compile("question/(.*?)/");
		Matcher matcher = pattern.matcher(url);
		if (matcher.find()) {
			zhihuUrl = "http://www.zhihu.com/question/" + matcher.group(1);
		} else {
			return false;
		}
		return true;
	}

	public String writeString() {
		String result = "";
		result += "���⣺" + question + "\r\n\r\n";
		result += "������" + questionDescription + "\r\n\r\n";
		result += "���ӣ�" + zhihuUrl + "\r\n\r\n";
		for (int i = 0; i < answers.size(); i++) {
			result += "�ش�" + i + "��" + answers.get(i) + "\r\n\r\n\r\n\r\n";
		}
		result += "\r\n\r\n\r\n\r\n";
		// �����е�html��ǩ����ɸѡ
		result = result.replaceAll("<br>", "\r\n");
		result = result.replaceAll("<.*?>", "");
		return result;
	}

}
