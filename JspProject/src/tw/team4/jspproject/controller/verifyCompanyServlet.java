package tw.team4.jspproject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.SendResult;

import tw.team4.jspproject.dao.CompanyDaoImpl;
import tw.team4.jspproject.javabean.CompanyJavabean;


@WebServlet("/jsp/team4/company/VerifyCompanyServlet")
public class verifyCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		
		CompanyDaoImpl compDao = new CompanyDaoImpl();
		
		
		try {
			compDao.createConn();
		//做DAO 連線
		boolean result = compDao.verifyPWD(password,account);
		
//		compDao.closeConn();@@@@@@@@@@
		//DAO
		if(result) {
			//////////////////////////
			ServletContext context =getServletContext();
			CompanyJavabean compJB = compDao.findbylog(password, account);
			context.setAttribute("compJB",compJB);
			
//			RequestDispatcher rd = request.getRequestDispatcher("company.jsp");
//			rd.forward(request, response);
//			
//			
			//@@@@@@@@@@@
			compDao.closeConn();
			//////////////////////////
			//連到加入資料庫 顯示JSP 抓資料
//			response.setHeader("Refresh", value);
//			out.println("登入成功<br/>");
			response.sendRedirect("Company.jsp");
			
		
			
//			timeout
//			sendredirect company.jsp
			
		}else {
			//失敗 連到errorpage 或sendredirect回新增頁
			out.write("登入失敗");
			//@@@@@@@@@@@@
			compDao.closeConn();
		}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//參考JAVASCRIPT
		
		out.close();
		
	}

}
