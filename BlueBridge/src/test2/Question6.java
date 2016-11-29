package test2;
/*
 * ����Ĵ��������ж�һ�����е������Ƿ�ƥ����νƥ����ָ��ͬ���͵����ű������Һ�Ӧ�������໥�����������ܽ���
���磺
..(..[..]..)..  �������
..(...[...)....].... �ǽ�ֹ��
���� main �����еĲ���������Ӧ�������
false
true
false
false*/
import java.util.Stack;

public class Question6 {
    static boolean isGoodBracket(String string){
	Stack<Character> stack=new Stack<Character>();
	for(int i=0;i<string.length();i++){
	    char tmp=string.charAt(i);
	    if(tmp=='(')
		stack.push(')');
	    if(tmp=='[')
		stack.push(']');
	    if(tmp=='{')
		stack.push('}');
	    if(tmp==')'||tmp==']'||tmp=='}'){
		if(stack.size()==0)
		    return false;
		if(stack.pop()!=tmp)
		    return false;
	    }
	}
	if(stack.size()!=0)
	    return false;
	return true;
    }
    public static void main(String[] args) {
	System.out.println(isGoodBracket("...(..[.)..].{.(..).}..."));
	System.out.println(isGoodBracket("...(..[...].(.).).{.(..).}..."));
	System.out.println(isGoodBracket(".....[...].(.).){.(..).}..."));
	System.out.println(isGoodBracket("...(..[...].(.).){.(..)...."));
    }
}
