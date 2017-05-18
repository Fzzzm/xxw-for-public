#include<iostream>
#include<vector>
#include<string>

using namespace std;

void print(string s) {
	cout << s << endl;
}

void println() {
	cout << endl;
}

struct X
{
	X() { cout << "���캯��X()" << endl; }
	X(const X&) { cout << "���캯��X(const X&)" << endl; }
	X& operator=(const X& rhs) { 
		cout << "������ֵ�����(const X& rhs)" << endl;
		return *this; 
	}
	~X() {
		cout << "��������~X()" << endl;
	}
};

void f1(X x) {}

void f2(X& x) {}

int main13_1() {
	print("�ֲ�����");
	X x;
	println();

	print("�����ò�������");
	f1(x);
	println();

	print("���ò�������");
	f2(x);
	println();

	print("��̬����");
	X* px = new X;
	println();

	print("��ӵ�������");
	vector<X> vx;
	vx.push_back(x);
	println();

	print("�ͷŶ�̬�������");
	delete px;
	println();

	print("��ӳ�ʼ���͸�ֵ");
	X y = x;
	y = x;
	println();

	print("�������");

	return 0;
}