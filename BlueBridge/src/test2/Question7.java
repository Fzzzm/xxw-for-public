package test2;

import java.util.Scanner;

public class Question7 {
    public static void main(String[] args) {  
	double n=2;//��ͼ��ƽ����������
	double a=0;//���
	double b=2;//�����ƽ����
	while(Math.abs(a-b)>1E-5){
	    a=(a+b)/2;
	    b=n/a;
	}
	System.out.println(a);
    } 
 
}
