package bean;

import java.io.IOException;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JobInfo {
	//��������
	private String jobName;
	//��˾����
	private String jobCompany;
	//н�ʷ�Χ
	private String salary;
	//���н��
	private String minSalary;
	//���н��
	private String maxSalary;
	//�����ص�
	private String jobAddress;
	//��������
	private String experience;
	//ѧ��Ҫ��
	private String education;
	//����
	private String industry;
	//�������
	private String growth;
	private String getJobName(String string){
		String jobName=string.substring(0, string.indexOf(","));
		return jobName;
	}
	private String getJobComapany(String string){
		String[] strs=string.split("[,]");
		return strs[2].replace(strs[0]+"��Ƹ", "");
	}	
	public JobInfo(String url){
		jobName="";
		jobCompany="";
		salary="";
		minSalary="";
		maxSalary="";
		jobAddress="";
		experience="";
		education="";
		industry="";
		growth="";
		System.out.println("����ץȡְλ��Ϣ:"+url);
		try {
			Document document=Jsoup.connect(url).get();
			Element element=document.select("meta[name]").get(2);
			
			/*��ú��й������ơ���˾���Ƶ��ַ���,֮����Խ��н�һ���Ľ���*/
			String content=element.attr("content");
			jobName=getJobName(content);
			jobCompany=getJobComapany(content);
			
			/*��ù����ַ���*/
			salary=document.getElementsByTag("span").get(3).text();
			/*��������С�ַ���*/
			String[] salarys=salary.split("[-]");
			try {
				minSalary=salarys[0];
				maxSalary=salarys[1];
			} catch (ArrayIndexOutOfBoundsException e) {
				minSalary=null;
				maxSalary=null;
			}
			/*��ù�˾��ַ*/
			jobAddress=document.getElementsByTag("span").get(4).text();
			
			/*��ù�������*/
			experience=document.getElementsByTag("span").get(5).text();
			
			/*���ѧ��Ҫ��*/
			education=document.getElementsByTag("span").get(6).text();
			
			/*���������������*/
			Elements results=document.select(".c_feature").select("li");
			
			/*����*/
			industry=results.get(0).text().replace("���� ", "");
			
			/*����*/
			growth=results.get(3).text().replace("Ŀǰ�׶� ", "");
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void printInformation(){
		System.out.println("��������:"+jobName);
		System.out.println("��˾����:"+jobCompany);
		System.out.println("н�ʷ�Χ:"+salary);
		System.out.println("���н��:"+minSalary);
		System.out.println("���н��:"+maxSalary);
		System.out.println("�����ص�:"+jobAddress);
		System.out.println("��������:"+experience);
		System.out.println("ѧ��Ҫ��:"+education);
		System.out.println("��������:"+industry);
		System.out.println("�������:"+growth);
	}
	/**
	 * @return the jobName
	 */
	public String getJobName() {
		return jobName;
	}
	/**
	 * @param jobName the jobName to set
	 */
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	/**
	 * @return the jobCompany
	 */
	public String getJobCompany() {
		return jobCompany;
	}
	/**
	 * @param jobCompany the jobCompany to set
	 */
	public void setJobCompany(String jobCompany) {
		this.jobCompany = jobCompany;
	}
	/**
	 * @return the salary
	 */
	public String getSalary() {
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(String salary) {
		this.salary = salary;
	}
	/**
	 * @return the minSalary
	 */
	public String getMinSalary() {
		return minSalary;
	}
	/**
	 * @param minSalary the minSalary to set
	 */
	public void setMinSalary(String minSalary) {
		this.minSalary = minSalary;
	}
	/**
	 * @return the maxSalary
	 */
	public String getMaxSalary() {
		return maxSalary;
	}
	/**
	 * @param maxSalary the maxSalary to set
	 */
	public void setMaxSalary(String maxSalary) {
		this.maxSalary = maxSalary;
	}
	/**
	 * @return the jobAddress
	 */
	public String getJobAddress() {
		return jobAddress;
	}
	/**
	 * @param jobAddress the jobAddress to set
	 */
	public void setJobAddress(String jobAddress) {
		this.jobAddress = jobAddress;
	}
	/**
	 * @return the experience
	 */
	public String getExperience() {
		return experience;
	}
	/**
	 * @param experience the experience to set
	 */
	public void setExperience(String experience) {
		this.experience = experience;
	}
	/**
	 * @return the education
	 */
	public String getEducation() {
		return education;
	}
	/**
	 * @param education the education to set
	 */
	public void setEducation(String education) {
		this.education = education;
	}
	/**
	 * @return the industry
	 */
	public String getIndustry() {
		return industry;
	}
	/**
	 * @param industry the industry to set
	 */
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	/**
	 * @return the growth
	 */
	public String getGrowth() {
		return growth;
	}
	/**
	 * @param growth the growth to set
	 */
	public void setGrowth(String growth) {
		this.growth = growth;
	}
	
}
