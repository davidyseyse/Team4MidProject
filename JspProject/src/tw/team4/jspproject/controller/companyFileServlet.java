package tw.team4.jspproject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/jsp/team4/company/companyFileServlet")
public class companyFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getlogo(request,response);
	}
	private void getlogo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		Part part = request.getPart("logo");
		part.getInputStream();
		
//		
//		String headerValue = part.getHeader("Content-Disposition");
////		//out.write("headerValue:"+headerValue+"<br/>");
//		String fileName = headerValue.substring(headerValue.indexOf("filename=\"")+10,headerValue.lastIndexOf("\""));
////		//out.write("fileName1:"+fileName+"<br/>");
//		fileName= spliteData(fileName);//方法
////		//out.write("fileName2:"+fileName+"<br/>");
//		
//		if(!"".equals(fileName)&& part.getContentType()!=null) {
//			part.write(fileName);
//			out.write("Single File Upload Success.<br/>");
//			
//		}
		
		
		
		out.close();
		
	}
//	private String spliteData(String fileName) {
//		LinkedList<String> list1 = new LinkedList<String>();
//		
//		StringTokenizer st1 = new StringTokenizer(fileName,"\\");
//		
//		while(st1.hasMoreTokens())	{
//			list1.add(st1.nextToken());
//		}
//				
//				
//		return list1.getLast();
//	}

}
