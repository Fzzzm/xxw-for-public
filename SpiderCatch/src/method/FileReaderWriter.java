package method;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import bean.ZhiHuPicBean;

public class FileReaderWriter {

	// �����ļ��ķ�������ʱû��
	public static boolean createNewFile(String filePath) {
		boolean isSuccess = true;
		// ������"\\"תΪ"/",û���򲻲����κα仯
		String filePathTurn = filePath.replaceAll("\\\\", "/");
		// �ȹ��˵��ļ���
		int index = filePathTurn.lastIndexOf("/");
		String dir = filePathTurn.substring(0, index);
		// �ٴ����ļ���
		File fileDir = new File(dir);
		isSuccess = fileDir.mkdirs();
		// �����ļ�
		File file = new File(filePathTurn);
		try {
			isSuccess = file.createNewFile();
		} catch (IOException e) {
			isSuccess = false;
			e.printStackTrace();
		}
		return isSuccess;
	}

	// �����ļ�����д������
	public static boolean writeIntoFile(String content, String filePath, boolean isAppend) {
		boolean isSuccess = true;
		// �ȹ��˵��ļ���
		int index = filePath.lastIndexOf("/");
		String dir = filePath.substring(0, index);
		// �������ļ���·��
		File fileDir = new File(dir);
		fileDir.mkdirs();
		// �ٴ���·���µ��ļ�
		File file = null;
		try {
			file = new File(filePath);
			file.createNewFile();
		} catch (IOException e) {
			isSuccess = false;
			e.printStackTrace();
		}
		// д���ļ�
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file, isAppend);
			fileWriter.write(content);
			fileWriter.flush();
		} catch (IOException e) {
			isSuccess = false;
			e.printStackTrace();
		} finally {
			try {
				if (fileWriter != null)
					fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return isSuccess;
	}

	// ����zhiHuPicBean�������ļ��У�������ͼƬ
	public static boolean downLoadPics(ZhiHuPicBean zhiHuPicBean, String filePath) throws Exception {
		boolean isSuccess = true;
		// �ļ�·��+����
		String dir = filePath + zhiHuPicBean.getQuestion();
		// ����
		File fileDir = new File(dir);
		fileDir.mkdirs();
		// ��ȡ����ͼƬ·������
		ArrayList<String> zhiHuPics = zhiHuPicBean.getZhihuPicUrl();
		// ��ʼ��һ��������������ʾͼƬ���
		int i = 1;
		// ѭ������ͼƬ
		for (String zhiHuPic : zhiHuPics) {
			URL url = new URL(zhiHuPic);
			// ������������
			DataInputStream dis = new DataInputStream(url.openStream());
			String newImageName = dir + "/" + "ͼƬ" + i + ".jpg";
			// ����һ���µ��ļ�
			FileOutputStream fos = new FileOutputStream(new File(newImageName));
			byte[] buffer = new byte[1024];
			int length;
			System.out.println("��������......�� " + i + "��ͼƬ......���Ժ�");
			// ��ʼ�������
			while ((length = dis.read(buffer)) > 0) {
				fos.write(buffer, 0, length);
			}
			dis.close();
			fos.close();
			System.out.println("�� " + i + "��ͼƬ�������......");
			i++;
		}
		return isSuccess;
	}
}
