package bean;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import method.*;
/**
 * ֪���û�bean
 * 
 * @author KKys
 *
 */

public class ZhiHuUserBean {

	String name;// �û�����
	
	String location;// ��ס��;
	
	String business;// ��ҵ
	
	String employment;// ��˾
	
	String position;// ְλ;
	
	String education;// ��ѧ
	
	String major;// רҵ
	
	String userInfo;// ���˼��
	
	int answersNum;// �ش�����
	
	Long starsNum;// ����ͬ��
	
	Long thxNum;// ����л��

	// ���췽����ʼ������
	public ZhiHuUserBean(String url) {
		//��ʼ��Ϊ���ַ���
		name = "";
		location = "";
		business = "";
		employment = "";
		position = "";
		education = "";
		major = "";
		userInfo = "";
		System.out.println("����ץȡ�û����ӣ�" + url);
		// ����url��ȡ���û�����ϸ����
		String content = Util.SendGet(url);
		Pattern pattern;
		Matcher matcher;
		// ƥ������
		pattern = Pattern.compile("class=\"name\">(.+?)</span>");
		matcher = pattern.matcher(content);
		if (matcher.find()) {
			name = matcher.group(1);
		}
		// ƥ���ס��
		pattern = Pattern.compile("location item.+?title=\"(.+?)\"");
		matcher = pattern.matcher(content);
		if (matcher.find()) {
			location = matcher.group(1);
		}
		// ƥ����ҵ
		pattern = Pattern.compile("business item.+?title=\"(.+?)\"");
		matcher = pattern.matcher(content);
		if (matcher.find()) {
			business = matcher.group(1);
		}
		// ƥ�乫˾
		pattern = Pattern.compile("employment item.+?title=\"(.+?)\"");
		matcher = pattern.matcher(content);
		if (matcher.find()) {
			employment = matcher.group(1);
		}
		// ƥ��ְλ
		pattern = Pattern.compile("position item.+?title=\"(.+?)\"");
		matcher = pattern.matcher(content);
		if (matcher.find()) {
			position = matcher.group(1);
		}
		// ƥ���ѧ
		pattern = Pattern.compile("education item.+?title=\"(.+?)\"");
		matcher = pattern.matcher(content);
		if (matcher.find()) {
			education = matcher.group(1);
		}
		// ƥ��רҵ
		pattern = Pattern.compile("education-extra item.+?title=\"(.+?)\"");
		matcher = pattern.matcher(content);
		if (matcher.find()) {
			major = matcher.group(1);
		}
		// ƥ����˼��
		pattern = Pattern.compile("fold-item.+?content\">(.*?)</span>");
		matcher = pattern.matcher(content);
		if (matcher.find()) {
			userInfo = matcher.group(1).replaceAll("<.*?>", "");;
		}
		// ƥ��ش�����
		pattern = Pattern.compile("answers\">.+?>(.*?)</span>");
		matcher = pattern.matcher(content);
		if (matcher.find()) {
			answersNum = Integer.parseInt(matcher.group(1));
		}
		// ƥ�䱻����
		pattern = Pattern.compile("zm-profile-header-user-agree.+?strong>(.*?)</strong>");
		matcher = pattern.matcher(content);
		if (matcher.find()) {
			starsNum = Long.parseLong(matcher.group(1));
		}
		// ƥ�䱻��л��
		pattern = Pattern.compile("zm-profile-header-user-thanks.+?strong>(.*?)</strong>");
		matcher = pattern.matcher(content);
		if (matcher.find()) {
			thxNum = Long.parseLong(matcher.group(1));
		}
	}

	@Override
	public String toString() {
		return "������" + name + "\n" + "��ס�أ�" + location + "\n" + "��ҵ��" + business + "\n��˾��" + employment
				+ "\nְλ��"+ position + "\n��ѧ��"+ education + "\nרҵ��"+ major + 
				"\n���˼�飺"+ userInfo + "\n�ش�����" + answersNum+"\n����������"+ starsNum+"\n���ղ�����"+ thxNum;
	}
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public String getBusiness() {
		return business;
	}



	public void setBusiness(String business) {
		this.business = business;
	}



	public String getEmployment() {
		return employment;
	}



	public void setEmployment(String employment) {
		this.employment = employment;
	}



	public String getPosition() {
		return position;
	}



	public void setPosition(String position) {
		this.position = position;
	}



	public String getEducation() {
		return education;
	}



	public void setEducation(String education) {
		this.education = education;
	}



	public String getMajor() {
		return major;
	}



	public void setMajor(String major) {
		this.major = major;
	}


	public int getAnswersNum() {
		return answersNum;
	}



	public void setAnswersNum(int answersNum) {
		this.answersNum = answersNum;
	}



	public Long getStarsNum() {
		return starsNum;
	}



	public void setStarsNum(Long starsNum) {
		this.starsNum = starsNum;
	}



	public Long getThxNum() {
		return thxNum;
	}



	public void setThxNum(Long thxNum) {
		this.thxNum = thxNum;
	}

	public String getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}
	
	
}

