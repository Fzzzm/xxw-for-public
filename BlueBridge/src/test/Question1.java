package test;
/*�㷨�������ģ��������N����ͬ�ַ�������N���ַ�ȫ���У����յĽ��������N!�֡�
 * �磺���� A��B��C������ͬ���ַ�������Ϊ��
 * ABC��ACB��BAC��BCA��CAB��CBAһ��3!=3*2=6�������
 * �ο�˼·��http://blog.csdn.net/lemon_tree12138/article/details/50986990
 * */
import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {
	String str = "";
	System.out.println("������һ��û����ͬԪ�ص��ַ�����");
	Scanner scan = new Scanner(System.in);
	str = scan.nextLine();
	permutation(str.toCharArray(), 0,str.length()-1);
    }

    public static void permutation(char[] str, int cursor,int end) {
	if(cursor==end){
	    System.out.println(String.valueOf(str));
	}else{
	    for(int i=cursor;i<=end;i++){
		char tmp;
		tmp=str[cursor];
		str[cursor]=str[i];
		str[i]=tmp;
		permutation(str, cursor+1, end);
	    }
	}
    }
}
