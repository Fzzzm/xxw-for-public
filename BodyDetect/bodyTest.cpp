#include "opencv2/objdetect/objdetect.hpp"
#include "opencv2/highgui/highgui.hpp"
#include "opencv2/imgproc/imgproc.hpp"

#include <iostream>
#include <stdio.h>

using namespace std;
using namespace cv;
int main() {

	VideoCapture cap(0);

	if (!cap.isOpened()) {
		cout << "���������ʧ��!";
		return -1;
	}

	//����ѵ���ļ����ļ�Ӧ�ڹ����ļ�Ŀ¼��


	CascadeClassifier upperbody;
	CascadeClassifier lowerbody;
	CascadeClassifier fullbody;


	upperbody.load("C:\\Users\\xxw\\Desktop\\upperbody.xml");
	lowerbody.load("C:\\Users\\xxw\\Desktop\\lowerbody.xml");
	fullbody.load("C:\\Users\\xxw\\Desktop\\fullbody.xml");
	if (upperbody.empty()) {
		cout << "file not found" << endl;
		return -1;
	}
	if (lowerbody.empty()) {
		cout << "file not found" << endl;
		return -1;
	}
	if (fullbody.empty()) {
		cout << "file not found" << endl;
		return -1;
	}

	vector<Rect> upper;
	vector<Rect> lower;
	vector<Rect> full;

	while (char(waitKey(1)) != 'q' && cap.isOpened()) {
		double t0 = getTickCount();
		Mat frame;
		cap >> frame;
		if (frame.empty()) {
			cout << "��Ƶ����!";
			break;
		}

		upperbody.detectMultiScale(frame, upper, 1.3, 4, 0, Size(50, 50));
		lowerbody.detectMultiScale(frame, lower, 1.3, 4, 0, Size(50, 50));
		fullbody.detectMultiScale(frame,full,1.3,4,0,Size(50,50));

		if (full.size() != 0) {

			for (int i = 0; i < full.size(); i++) {

				cout << "=============Detected full body!=============" << endl;

				Point full_rect_1(full[i].x, full[i].y);
				Point full_rect_2(full[i].x + full[i].width, full[i].y + full[i].height);

				//Ȧ��ȫ��
				rectangle(frame, full_rect_1, full_rect_2, Scalar(0, 255, 0));
				putText(frame, "full body", full_rect_1, FONT_HERSHEY_SIMPLEX,
					1, Scalar(0, 255, 0), 1, 5, false);
			}
		}

		if (upper.size() != 0) {

			for (int i = 0; i < upper.size(); i++) {

				cout << "=============Detected upper body!=============" << endl;

				Point upper_rect_1(upper[i].x, upper[i].y);
				Point upper_rect_2(upper[i].x + upper[i].width, upper[i].y + upper[i].height);

				//Ȧ���ϰ���
				rectangle(frame, upper_rect_1, upper_rect_2, Scalar(0, 255, 0));
				putText(frame, "upper body", upper_rect_1, FONT_HERSHEY_SIMPLEX,
					1, Scalar(0, 255, 0), 1, 5, false);
			}
		}

		if (lower.size() != 0) {

			for (int i = 0; i < lower.size(); i++) {

				cout << "=============Detected a lower body!=============" << endl;

				Point lower_rect_1(lower[i].x, lower[i].y);
				Point lower_rect_2(lower[i].x + lower[i].width, lower[i].y + lower[i].height);

				//Ȧ���°���
				rectangle(frame, lower_rect_1, lower_rect_2, Scalar(0, 255, 0));
				putText(frame, "lower body", lower_rect_1, FONT_HERSHEY_SIMPLEX,
					1, Scalar(0, 255, 0), 1, 5, false);
			}
		}

		imshow("Video Capture", frame);
		cout << "Frame rate = " << getTickFrequency() / (getTickCount() - t0) << endl;
	}
	return 0;
}