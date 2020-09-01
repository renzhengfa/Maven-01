package org.lanqiao.utils;

import java.io.File;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Encoder;

/*
 * 下载功能工具类
 */

public class DownloadUtil {

	//根据图书名称下载图书
	public static void downLoad(String filePath, HttpServletRequest req, HttpServletResponse res) {
		
		//1.获得图书的输入流
		try {
			File file = new File(filePath);
//			FileInputStream in = new FileInputStream(file);
			InputStream in = req.getServletContext().getResourceAsStream(filePath);
			String filename = file.getName(); //解决中文文件名下载后乱码的问题
			String agent = req.getHeader("User-Agent");
			if (agent.contains("MSIE")) {
				// IE浏览器
				filename = URLEncoder.encode(filename, "utf-8");
				filename = filename.replace("+", " ");
			} else if (agent.contains("Firefox")) {
				// 火狐浏览器
				BASE64Encoder base64Encoder = new BASE64Encoder();
				filename = "=?utf-8?B?"
						+ base64Encoder.encode(filename.getBytes("utf-8")) + "?=";
			} else {
				// 其它浏览器
				filename = URLEncoder.encode(filename, "utf-8");				
			}
			//获取响应报文输出流对象  
			res.setCharacterEncoding("utf-8");
			res.setHeader("Content-Disposition","attachment; filename="+filename+"");  
			ServletOutputStream out = res.getOutputStream();
            byte[] b = new byte[1024];
            int len = 0;
            while((len = in.read(b)) > 0) {
            	//输出  
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
