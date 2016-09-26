#include<iostream>
#include<string>
#include<highgui.h>
#include<cv.h>
using namespace cv;
using namespace std;
IplImage* callback(IplImage* image);
int main() {
	char path[] = "C:\\Users\\xxw\\Desktop\\test.avi";//�洢��·��
	IplImage*  image = 0;

	//CvVideoWriter* writer = writer = cvCreateVideoWriter(path, CV_FOURCC('M', 'J', 'P', 'G'),fps, cvSize(frameW, frameW), isColor);
	//���ַ������Ƽ�����Ϊ�Լ�ָ�����ļ����뷽ʽϵͳ���ܲ�֧��

	CvCapture* capture = cvCaptureFromCAM(0);//ͨ������ͷ�ռ���Ƶ

	if(!capture){
		cout << "����ͷ��ʼ��ʧ��"<< endl;
		return -1;
	}

	cvNamedWindow("main",1);//�������ڣ�����ʵʱ��ʾ�ɼ���ͼ��

	image = cvQueryFrame(capture);	//����Ƶ�ж�ȡÿһ֡��ͼ�񣬴�����Ƶ�С���Ϊ��Ƶ�ı�����������ͼ��
	CvVideoWriter*  writer = cvCreateVideoWriter(path, -1, 25, cvSize(image->width, image->height));//�����ļ�д�����writer

	while (capture)
	{
		image = callback(cvQueryFrame(capture));
		cvWriteFrame(writer,image);
		cvShowImage("main",image);
		//if (cvWaitKey(1) == 'q')//������µ�Ϊq�����˳�
		if (cvWaitKey(1)=='q')
			break;
	}

	//�ͷŸ�����Դ����c++�Ķ���
	cvReleaseCapture(&capture);
	cvReleaseVideoWriter(&writer);
	cvDestroyWindow("main");

	return 0;
}

IplImage* callback(IplImage* image) {
	IplImage* image1 = image;
	int i, j;

	assert(image);

	for ( i = 0; i < image1->height; i+=10)
	{
		for (j = (image1->widthStep)*i; j < (image1->widthStep)*(i + 1);j+=image1->nChannels)
		{
			image1->imageData[j] = (char)255;
			image1->imageData[j + 1] = 0;
			image1->imageData[j + 2] = 0;
		}
	}
	return image1;
}