package org.lanqiao.web.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.lanqiao.service.BookService;
import org.lanqiao.serviceImpl.BookServiceImpl;

@WebServlet("/uploadImg")
@MultipartConfig
public class UploadImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//处理中文乱码
		request.setCharacterEncoding("UTF-8");
		
		//获取文件路径
		Part img_part = request.getPart("myImg");
		Part file_part = request.getPart("myFile");
		
		//获取头
		String img_header = img_part.getHeader("Content-Disposition");
		String file_header = file_part.getHeader("Content-Disposition");
		
		//获取各自的名字
		String[] imgarr = img_header.split("\"");
		String imgName = imgarr[imgarr.length-1];
		String[] filearr = file_header.split("\"");
		String fileName = filearr[filearr.length-1];
		
		
		
		
		//获取将图片及文件写到的地方
		String imgrelPath = this.getServletContext().getRealPath("/bookes/images" + "/" + imgName);
		String filerelPath = this.getServletContext().getRealPath("/bookes/txts" + "/" + fileName);
		
		//写入文件
		img_part.write(imgrelPath);
		file_part.write(filerelPath);
		
		//获取保存数据库的路径
		String imgPath = "/bookes/images" + "/" + imgName;
		//String filePath = "/bookes/txts" + "/" + fileName;
		//封装其他信息
		String bookname = request.getParameter("bookName").trim();
		String author = request.getParameter("author").trim();
		String strprice = request.getParameter("price").trim();
		//将价格转化为double类型数据
		double price = Double.parseDouble(strprice);
		String type = request.getParameter("type").trim();
		//将type变为对应类型的id
		int cid = Integer.parseInt(type);
		String subscript = request.getParameter("subscript").trim();
		//获取系统时间
		Date date = new Date();
		//转化为YYYY-MM-dd hh:mm:ss格式
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
		String created = format.format(date);
		
		//调用service层向数据库插入数据
		BookService bookservice = new BookServiceImpl();
		int i = bookservice.addBook(bookname, author, price, imgPath, subscript, created);
		if(i != 0) {
			//图书添加成功
			//添加图书类别
			int j = bookservice.addBookCategory(cid, bookname);
			if(j != 0) {
				//图书和分类都添加成功
				request.setAttribute("alertSuccessInfo", "图书添加成功");
				//转发到添加图书页面
				request.getRequestDispatcher("/management/addBook.jsp").forward(request, response);
			}else {
				//图书添加成功,但是分类添加失败
				request.setAttribute("alertErrorInfo", "图书添加成功,但是分类信息添加失败");
				//转发到添加图书页面
				request.getRequestDispatcher("/management/addBook.jsp").forward(request, response);
			}
		}else {
			//图书添加失败
			request.setAttribute("alertErrorInfo", "图书添加失败");
			//转发到添加图书页面
			request.getRequestDispatcher("/management/addBook.jsp").forward(request, response);
		}
		
		
		/*System.out.println(bookname);
		System.out.println(author);
		System.out.println(price);
		System.out.println(type);
		System.out.println(subscript);
		System.out.println(imgPath);
		System.out.println(filePath);*/
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}