package test;
/*
��������Ŀ�ľ��ǣ����ݸ������ֻ�β�ţ�4λ��������һ���Ĺ�������֡���������£�
1. ����������ţ����������ǽ��򣬶���5�֡����磺5678,4321������ӷֱ�׼��
2. ǰ����������ͬ���������������ͬ������3�֡����磺4888,6665,7777������ӷֵı�׼��
ע�⣺7777��Ϊ����������׼���Σ��������������������6�֡�
3. ����AABB����ABABģʽ�ļ�1�֡����磺2255,3939,7777���������ģʽ�����Զ����ӷ֡�
ע�⣺7777��Ϊ����������׼���Σ�����������׼��������2�֡�
4. ���У�6��8��9���κ�һ�����֣�ÿ����һ�μ�1�֡�����4326,6875,9918�����ϼӷֱ�׼�����У�6875����2�֣�9918����3�֡�
β�����յ÷־���ÿ����׼�ļӷ��ܺͣ�
Ҫ�����ӱ�׼����������ݣ��ڱ�׼�������������
�����ʽΪ����һ����һ������n��<100������ʾ�±��ж��������У���������n��4λһ������ݣ����ǵȴ�����ӷֵ��ֻ�β�š�
���磬���룺
14
3045
��.
��..
6789
8866
�������
0
0
��.
��
8
5
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question5 {
    //�ж��Ƿ�����
    public static boolean ctn1(char s[]) {
	char tmp[]=new char[4];
	for(int i=0;i<4;i++){tmp[i]=(char) (s[0]+i);}
	String s1=String.valueOf(s);
	String s2=String.valueOf(tmp);
	if(s1.equals(s2))
	    return true;
	else
	    return false;
    }
    public static boolean ctn2(char s[]) {
	char tmp[]=new char[4];
	for(int i=0;i<4;i++){tmp[i]=(char) (s[0]-i);}
	String s1=String.valueOf(s);
	String s2=String.valueOf(tmp);
	if(s1.equals(s2))
	    return true;
	else
	    return false;
    }
    //��������
    public static int LianHao(String string){
	int i=0;
	char s[]=new char[4];
	for(int j=0;j<4;j++)
	    s[j]=string.charAt(j);
	if(ctn1(s)||ctn2(s))
	    i=i+5;
	return i;
    }
    
    //�ж�ǰ3����ͬ
    public static boolean qiansan(String string) {
	String string2=string.substring(0,3);
	int i=0;
	if(string2.charAt(i)==string2.charAt(i+1)&&string2.charAt(i)==string2.charAt(i+2))
	    return true;
	else
	    return false;
    }
    //�жϺ�3����ͬ
    public static boolean housan(String string){
	String string2=string.substring(1,4);
	int i=0;
	if(string2.charAt(i)==string2.charAt(i+1)&&string2.charAt(i)==string2.charAt(i+2))
	    return true;
	else
	    return false;
    }
    //ѡ����Ƿ�����
    public static int sansan(String string){
	int i=0;
	if(qiansan(string))
	    i=i+3;
	if(housan(string))
	    i=i+3;
	return i;
    }
    //����AABB/ABAB����ʽ
    public static boolean isAABB(String string){
	if ((string.charAt(0)==string.charAt(1))&&(string.charAt(2)==string.charAt(3))) {
	    return true;
	}else {
	    return false;
	}
    }

    public static boolean isABAB(String string) {
	if ((string.charAt(0) == string.charAt(2)) && (string.charAt(1) == string.charAt(3))) {
	    return true;
	} else {
	    return false;
	}
    }
    public static int isAABBorABAB(String string){
	int i=0;
	if(isAABB(string))
	    i=i+1;
	if (isABAB(string)) 
	    i=i+1;
	return i;
    }
    //ͳ��6��8��9�ĳ��ִ���
    public static int a6(String string) {
	int i=0;
	for(int s=0;s<4;s++){
	    if(string.charAt(s)=='6')
		i++;
	}
	return i;
    }
    public static int a8(String string) {
	int i=0;
	for(int s=0;s<4;s++){
	    if(string.charAt(s)=='8')
		i++;
	}
	return i;
    }
    public static int a9(String string) {
	int i=0;
	for(int s=0;s<4;s++){
	    if(string.charAt(s)=='9')
		i++;
	}
	return i;
    }
    public static int  a689(String string) {
	return a6(string)+a8(string)+a9(string);
    }
    public static void main(String[] args) {
	//����Ҫ������ַ������ռ�β��4λ��
	int i=new Scanner(System.in).nextInt();
	List<String> strings=new ArrayList<String>();
	while (i>0) {
	    //System.out.println(i);
	    String string=new Scanner(System.in).nextLine();
	    strings.add(string);
	    i--;
	}
	for(String string:strings){
	    int k=LianHao(string)+sansan(string)+isAABBorABAB(string)+a689(string);
	    System.out.println(k);
	}
    }

}
