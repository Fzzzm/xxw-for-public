package test;

import java.util.Scanner;
import java.util.Vector;

/*
    ��ʵ�ʵĿ��������У����ַ����Ĵ���������ı������
    ����Ŀ����Ҫ�������û�����Ĵ����д�������������£�
    1.��ÿ�����ʵ�����ĸ��Ϊ��д��
    2.����������ĸ֮�����»����ַ���_���ֿ���ʹ�ø�����
    3.�ѵ����м��ж���ո�ĵ���Ϊ1���ո�
    ���磺
    �û����룺
    you and     me what  cpp2005program
    ����������
    You And Me What Cpp_2005_program
    �û����룺
    this is     a      99cat
    ����������
    This Is A 99_cat
    ���Ǽ��裺�û�����Ĵ���ֻ��Сд��ĸ���ո�����֣�������������ĸ����š�
    ÿ�����ʼ���1�������ո�ָ���
    �����û�����Ĵ����Ȳ�����200���ַ���
 */
public class Question2 {
    public static void process(String string) {
	Vector<Character> result = new Vector<Character>();
	for (int i = 0; i < string.length(); i++) {
	    result.add(string.charAt(i));
	}

	// �Ƚ����е�������ĸת��Ϊ��д
	result.set(0, result.get(0).toUpperCase(result.get(0)));// �ַ�����һ����ĸ����Ϊ��д
	for (int i = 1; i < result.size(); i++) {
	    if (result.get(i - 1) == ' ') {
		result.set(i, result.get(i).toUpperCase(result.get(i)));
	    }
	}

	// �������Ŀո�
	int index1 = 0;
	while (index1 <= result.size() - 1) {
	    if (result.elementAt(index1) == ' ' && result.elementAt(index1 + 1) == ' ') {
		result.remove(index1);
		index1--;
	    }
	    index1++;
	}

	// �����������֡���ĸ֮����ӡ�_������
	int index = 0;
	while (index <= result.size() - 1) {
	    // �������ַ�Ϊ����,�ͽ����жϲ���
	    if (result.get(index).isDigit(result.get(index))) {
		if ((result.get(index - 1) >= 'a' && result.get(index - 1) <= 'z')
			|| (result.get(index - 1) >= 'A' && result.get(index - 1) <= 'Z')) {
		    result.add(index, '_');
		    index++;
		}
		if ((result.get(index + 1) >= 'a' && result.get(index + 1) <= 'z')
			|| (result.get(index + 1) >= 'A' && result.get(index + 1) <= 'Z')) {
		    result.add(index + 1, '_');
		    index++;
		}
	    }
	    index++;
	}

	// ����ַ���
	for (int i = 0; i < result.size(); i++) {
	    System.out.print(result.get(i));
	}
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	System.out.println("������һ���ַ���");
	Scanner scanner = new Scanner(System.in);
	String string = scanner.nextLine();
	process(string);
    }
}
