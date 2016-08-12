package method;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;



import bean.JobInfo;

public class Spider {
	public void getInformation() throws Exception{
		DBHelper helper=new DBHelper();
		Connection connection=helper.getConnection();
		Statement statement=connection.createStatement();
		 int page=1;
		 String baseUrl="http://www.lagou.com/zhaopin/";//һ��Ҫ��httpͷ������Ȼ���ִ���
		 for(page=1;page<=30;page++){
			 String nowUrl=baseUrl+page+"/";
			 List<String> users=Util.getUserUrl(nowUrl);
			 for(String userUrl:users){
				 JobInfo jobInfo=new JobInfo("http://"+userUrl);//һ��Ҫ��httpͷ������Ȼ���ִ���
				 jobInfo.printInformation();
				 String sqlString="insert into test.job(jobname,jobcompany,salary,minsalary,maxsalary,jobaddress,experience,education,industry,growth) values('"
				 +jobInfo.getJobName()+"','"+jobInfo.getJobCompany()+"','"+jobInfo.getSalary()+"','"+jobInfo.getMinSalary()+"','"+jobInfo.getMaxSalary()+
				 "','"+jobInfo.getJobAddress()+"','"+jobInfo.getExperience()+"','"+jobInfo.getEducation()+"','"+jobInfo.getIndustry()+"','"+jobInfo.getGrowth()+"')";
				 if(statement.execute(sqlString)){
					 System.out.println("ִ��ʧ��");
				 }else {
					System.out.println("ִ�гɹ�");
				 }
				 System.out.println("-----------------------");
			 }
		 }
		 connection.close();
	}
}
