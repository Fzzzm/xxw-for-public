#include<iostream>
#include<stdexcept>
#include<fstream>
#include<string>
#include<vector>
#include<sstream>

using namespace std;

int main8_1_1() {
	ifstream in("C:\\Users\\xxw\\Desktop\\test.txt");
	if (!in) {
		cout << "�޷����ļ�" << endl;
		return -1;
	}
	string line;
	vector<string> lines;
	//while (getline(in,line))//����Ϊ��λ
	while (in>>line)//�Ե���Ϊ��λ
	{
		lines.push_back(line);
	}
	in.close();

	for (auto it = lines.cbegin(); it != lines.cend();it++) {
		cout << *it << endl;
	}
	return 0;
}

ifstream& f(ifstream& in) {
	string v;
	while (in>>v,!in.eof())
	{
		if (in.bad())
			throw runtime_error("IO����");
		if (in.fail()) {
			cerr << "���ݴ���������" << endl;
			in.clear();
			in.ignore(100,'\n');
			continue;
		}
		cout << v << endl;
	}
	in.clear();
	return in;
}

int main8_1_2() {
	ifstream in("C:\\Users\\xxw\\Desktop\\test.txt");
	if (!in) {
		cerr << "�޷����ļ�" << endl;
		return -1;
	}
	

	string line;
	vector<string> lines;
	while (getline(in,line))
	{
		lines.push_back(line);
	}

	for (auto it = lines.cbegin(); it != lines.cend();it++) {
		istringstream line_str(*it);
		string word;
		while (line_str>>word)
		{
			cout << word << "\t";
		}
		cout << endl;
	}
	return 0;
}

int main8_1_3() {
	return 0;
}