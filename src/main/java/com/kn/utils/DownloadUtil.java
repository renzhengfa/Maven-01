package com.kn.utils;

import sun.misc.BASE64Encoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.InputStream;
import java.net.URLEncoder;

/*
 * ���ع��ܹ�����
 */

public class DownloadUtil {

    //����ͼ����������ͼ��
    public static void downLoad(String filePath, HttpServletRequest req, HttpServletResponse res) {

        //1.���ͼ���������
        try {
            File file = new File(filePath);
//			FileInputStream in = new FileInputStream(file);
            InputStream in = req.getServletContext().getResourceAsStream(filePath);
            String filename = file.getName(); //��������ļ������غ����������
            String agent = req.getHeader("User-Agent");
            if (agent.contains("MSIE")) {
                // IE�����
                filename = URLEncoder.encode(filename, "utf-8");
                filename = filename.replace("+", " ");
            } else if (agent.contains("Firefox")) {
                // ��������
                BASE64Encoder base64Encoder = new BASE64Encoder();
                filename = "=?utf-8?B?"
                        + base64Encoder.encode(filename.getBytes("utf-8")) + "?=";
            } else {
                // ���������
                filename = URLEncoder.encode(filename, "utf-8");
            }
            //��ȡ��Ӧ�������������
            res.setCharacterEncoding("utf-8");
            res.setHeader("Content-Disposition", "attachment; filename=" + filename + "");
            ServletOutputStream out = res.getOutputStream();
            byte[] b = new byte[1024];
            int len = 0;
            while ((len = in.read(b)) > 0) {
                //���
                out.write(b, 0, len);
            }
            in.close();
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
