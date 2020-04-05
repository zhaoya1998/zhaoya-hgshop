package com.zhaoya.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

public class FileUtils {

	// ������
		@SuppressWarnings("resource")
		public static void downLoad(HttpServletResponse response, String filename) throws FileNotFoundException {
			/*
			 * // ���ر����ļ� String fileName = "Operator.doc".toString(); // �ļ���Ĭ�ϱ�����
			 */ // ��������
			InputStream inStream = new FileInputStream("e:\\pic\\" + filename);// �ļ��Ĵ��·��
			// ��������ĸ�ʽ
			response.reset();
			response.setContentType("bin");
			response.addHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");

			// ѭ��ȡ�����е�����
			byte[] b = new byte[1024];
			int len;
			try {
				while ((len = inStream.read(b)) > 0)
					response.getOutputStream().write(b, 0, len);
				inStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		/**
		 * �ϴ��ļ�
		 * 
		 * @param file
		 * @return
		 * @throws IllegalStateException
		 * @throws IOException
		 */
		public static String processFile(MultipartFile file) throws IllegalStateException, IOException {

			// ԭ�����ļ�����
			System.out.println("file.isEmpty() :" + file.isEmpty());
			System.out.println("file.name :" + file.getOriginalFilename());

			if (file.isEmpty() || "".equals(file.getOriginalFilename())
					|| file.getOriginalFilename().lastIndexOf('.') < 0) {
				return "";
			}

			String originName = file.getOriginalFilename();
			String suffixName = originName.substring(originName.lastIndexOf('.'));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String path = "e:/pic/" + sdf.format(new Date());
			File pathFile = new File(path);
			if (!pathFile.exists()) {
				pathFile.mkdir();
			}
			String destFileName = path + "/" + UUID.randomUUID().toString() + suffixName;
			File distFile = new File(destFileName);
			file.transferTo(distFile);// �ļ���浽���Ŀ¼�±�
			return destFileName.substring(7);
		}
}
