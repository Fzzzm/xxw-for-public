package method;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import bean.HouseInfo;

public class Analysis {
	DBHelper dbHelper=new DBHelper();
	Connection connection=dbHelper.getConnection();
	/**����ÿ��page�ϵ���Ϣ*/
	public void analysis(String string){
		try {
			Statement statement=connection.createStatement();
			Document document=Jsoup.connect(string).get();
			Elements elements=document.getElementsByClass("zu-itemmod");
			HouseInfo houseInfo=null;
			for(Element element:elements){
				/*��ú��з�����ϸ��Ϣ���ַ���*/
				String result=element.getElementsByTag("address").text();
				int a=result.indexOf(" ");
				//int c=result.indexOf("-");
				Elements elements2=element.getElementsByTag("p");
				String[] strings=elements2.first().text().split("\\|");
				//������������
				String district=result.substring(a+2, a+4);
				//����С��
				String address=result.substring(0, a);
				//��������۸�int��������
				int price=Integer.valueOf(element.getElementsByClass("zu-side").first().getElementsByTag("strong").text());
				//��������
				String houseType=strings[0];
				//��������
				String rentType=strings[1];
				//װ������
				String decoration=strings[2];
				houseInfo=new HouseInfo(houseType, rentType, decoration, address, district, price);
				String sql="insert into test.houseInfo(address,decoration,district,houseType,price,rentType)values(' "
						+houseInfo.getAddress()+"','"+houseInfo.getDecoration()+"','"+houseInfo.getDistrict()+"','"+
						houseInfo.getHouseType()+"',"+houseInfo.getPrice()+",'"+houseInfo.getRentType()+"')";
				if (statement.execute(sql)) {
					System.out.println("failed...");
				}else {
					System.out.println("success!");
				}
				houseInfo.printInformation();//��ӡ��Ϣ
			}
			//dbHelper.close();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
