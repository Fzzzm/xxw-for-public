package test;
/*
 * Excel����õİ칫�����ÿ����Ԫ����Ψһ�ĵ�ַ��ʾ�����磺��12�е�4�б�ʾΪ����D12������5�е�255�б�ʾΪ��IU5����9 I 21 U
��ʵ�ϣ�Excel�ṩ�����ֵ�ַ��ʾ����������һ�ֱ�ʾ������RC��ʽ��ַ��
��12�е�4�б�ʾΪ����R12C4������5�е�255�б�ʾΪ��R5C255����
��������ǣ���д����ʵ�ִ�RC��ַ��ʽ�������ַ��ʽ��ת����
�����롢�����ʽҪ��
�û�������һ������n��n<100������ʾ��������n���������ݡ�
���������n��������RC��ʽ��Excel��Ԫ���ַ��ʾ����
���������n�����ݣ�ÿ����ת����ĳ����ַ��ʾ����
���磺�û����룺
2
R12C4
R5C255
�����Ӧ�������
D12
IU5*/
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question4 {
    static char[] alphabet={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    static List<String> strings=new ArrayList<String>();
    public static String change(int i){
	String string="";
	int a=i/26;
	int b=i%26;
	string=change2(a)+change2(b);
	return string;
    }
    public static String change2(int i){
	if(i==0)
	    return "";
	else {
	    return String.valueOf(alphabet[i-1]);
	}
    }
    public static String change(String string){
	String string2="";
	//�ֽ��ַ���
	int a=0;//������¼'R'��λ��
	int b=0;//������¼'C'��λ��
	for(int k=0;k<string.length();k++){
	    if(string.charAt(k)=='R')a=k;
	    if(string.charAt(k)=='C')b=k;
	}
	String s1=string.substring(a+1, b);
	String s2=string.substring(b+1,string.length());
	//int c=Integer.valueOf(s1);
	int d=Integer.valueOf(s2);
	string2=change(d)+s1;
	return string2;
    }
    public static void main(String[] args) {
	//��ʼ������
	System.out.println("���������ݵ���Ŀ");
	int i=new Scanner(System.in).nextInt();
	System.out.println("������"+i+"������");
	for(int n=0;n<i;n++){
	    String string=new Scanner(System.in).nextLine();
	    String tmp=change(string);
	    strings.add(tmp);
	}
	
	//��ӡ���
	for(int j=0;j<strings.size();j++){
	    System.out.println(strings.get(j));
	}
    }

}
