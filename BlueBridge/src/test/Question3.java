package test;
/*
 * ���������ʽ��
���� x ���� = ���� x ������
����ʾ��������λ����˵���һ����λ������һ����λ����
���û���޶����������������Ӻܶࡣ
��Ŀǰ���޶��ǣ���9�����飬��ʾ1~9��9�����֣�������0��
����ʽ��1��9��ÿ�����ֳ�����ֻ����һ�Σ�
���磺
46 x 79 = 23 x 158
54 x 69 = 27 x 138
54 x 93 = 27 x 186
.....
���̣�������п��ܵ������
ע�⣺
��ߵ���������������ͬһ��������Ҫ�ظ������
��ͬ���������˳����Ҫ*/
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Question3 {
    static List<String> strings1=new ArrayList<String>();//���ڴ洢��������Ҫ���ȫ����
    static Vector<String> vector=new Vector<String>();//�洢��������Ҫ���ȫ����
    static List<String> strings2=new ArrayList<String>();//�洢���غ�Ľ��
    //�������е�ȫ���У���������Ҫ���ȫ���д���string1
    public static void generateAllSorts(char[] root,int index){
	if (index == 8) {
	    String string = String.valueOf(root);
	    if(yes(string))
		strings1.add(string);
	} else {
	    for (int i = index; i <=8; i++) {
		char tmp = root[index];
		root[index] = root[i];
		root[i] = tmp;
		generateAllSorts(root, index + 1);
	    }
	}
    }
    //�ж�ÿ��ȫ�����Ƿ�����Ҫ��
    public static boolean yes(String string){
	String s1=string.substring(0, 2);
	String s2=string.substring(2, 4);
	String s3=string.substring(4, 6);
	String s4=string.substring(6, 9);
	int a=Integer.valueOf(s1);
	int b=Integer.valueOf(s2);
	int c=Integer.valueOf(s3);
	int d=Integer.valueOf(s4);
	if(a*b==c*d)
	    return true;
	else {
	    return false;
	}
    }
    //��������Ҫ���ȫ�����У������ֵ���������
    public static void removeDouble() {
	// ��ֵ
	for (int i = 0; i < strings1.size(); i++) {
	    vector.add(strings1.get(i));
	}
	// �����ظ���
	for (int i = 0; i < vector.size(); i++) {
	    for (int j = i; j < vector.size(); j++) {
		if (vector.get(i).equals(vector.get(j))) {
		    vector.remove(j);
		}
	    }
	}

	// ��ֵstring2
	for (int i = 0; i < vector.size(); i++) {
	    strings2.add(vector.get(i));
	}
    }
    public static void main(String[] args) {
	char[] roots={'1','2','3','4','5','6','7','8','9'};
	// TODO Auto-generated method stub
	//������������Ҫ����ַ���
	generateAllSorts(roots, 0);

	//����
	removeDouble();
	
	//��ӡ
	for(String string:strings2){
	    System.out.println(string);
	}
    }
}
