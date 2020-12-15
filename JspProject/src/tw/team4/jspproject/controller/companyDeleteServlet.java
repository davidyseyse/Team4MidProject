package tw.team4.jspproject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.team4.jspproject.dao.CompanyDaoImpl;
import tw.team4.jspproject.javabean.CompanyJavabean;


@WebServlet("/jsp/team4/company/companyDeleteServlet")
public class companyDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");


		String companyName = request.getParameter("companyName");

		CompanyJavabean compJB = new CompanyJavabean(companyName);
		//製作JAVABEAN丟資料
		CompanyDaoImpl compDao = new CompanyDaoImpl();
		try {
			compDao.createConn();
		
		//做DAO 連線
		boolean result = compDao.deletecomp(compJB);
		
		compDao.closeConn();
		//DAO
		if(result) {
			//連到加入資料庫 顯示JSP 抓資料
			out.write("刪除成功<br/>");
			
			
			response.setHeader("Refresh", "3;Enter.jsp");
			out.println("3秒後回到登入頁<br/>");
//			timeout
//			sendredirect company.jsp
			
		}else {
			//失敗 連到errorpage 或sendredirect回新增頁
			out.write("刪除失敗<br/>");
			response.setHeader("Refresh", "3");
		}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


		out.close();
	}

}
