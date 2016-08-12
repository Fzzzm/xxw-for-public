package tool;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import com.sleepycat.je.rep.monitor.NewMasterEvent;

public class DownLoadFile {
	/**
	 * ����url����ҳ����������Ҫ�������ҳ���ļ�����ȥ��url�еķ��ļ����ַ�
	 * */
	public String getFilrNameByUrl(String url,String contentType){
		url=url.substring(7);//ȥ����http://���߸��ַ�
		if(contentType.indexOf("html")!=-1){
			url=url.replaceAll("[\\?/:*|<>\"]", "_")+".html";
			return url;
		}
		else {
			return url.replaceAll("[\\?/:*|<>\"]", 
					"_")+"."+contentType.substring(contentType.lastIndexOf("/")+1);
		}
	}
	
	private void saveToLocal(byte[] date,String filePath){
		try {
			DataOutputStream out=new DataOutputStream(new
			FileOutputStream(new File(filePath)));
			for (int i = 0; i < date.length; i++) {
				out.write(date[i]);
			}
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public String downloadFile(String url){
		String filePath=null;
		HttpClient httpClient=new HttpClient();
		httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
		GetMethod getMethod=new GetMethod(url);
		getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 5000);
		getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, 
				new DefaultHttpMethodRetryHandler());
		try {
			int status=httpClient.executeMethod(getMethod);
			if(status!=HttpStatus.SC_OK){
				System.err.println("Method failed"+getMethod.getStatusLine());
				filePath=null;
			}
			byte[] responseBody=getMethod.getResponseBody();
			filePath="E:\\temp\\"+getFilrNameByUrl(url, 
					getMethod.getResponseHeader("Content-Type").getValue());
			saveToLocal(responseBody, filePath);
		} catch (HttpException e) {
			// TODO: handle exception
			System.out.println("�������������ַ");
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			getMethod.releaseConnection();
		}
		return filePath;
	}
}
