package tw.team4.jspproject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.team4.jspproject.dao.CompanyDaoImpl;
import tw.team4.jspproject.javabean.CompanyJavabean;

/**
 * Servlet implementation class CompanyUpdate2
 */
@WebServlet("/jsp/team4/company/CompanyUpdateServlet2")
public class CompanyUpdateServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		//設定好response資料類型
		ServletContext context =getServletContext();
		CompanyJavabean newJB= (CompanyJavabean) context.getAttribute("compJB");
		
//		Integer.parseInt(request.getParameter("companyId"));
		int companyId = newJB.getCompanyId();
		System.out.println(companyId);
		String companyName = request.getParameter("companyName");
//		String logo = request.getParameter("logo");
		String uniformNumbers = request.getParameter("uniformNumbers");
		String categories = request.getParameter("categories");
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
//		String busRC = request.getParameter("busRC");
		int bankId = Integer.parseInt(request.getParameter("bankId"));
		
		CompanyJavabean compJB = new CompanyJavabean(companyId,companyName,uniformNumbers,categories,
				account,password,email,phone,bankId);
		//製作JAVABEAN丟資料
		CompanyDaoImpl compDao = new CompanyDaoImpl();
		try {
			compDao.createConn();
		
		//做DAO 連線
		boolean result = compDao.uppdatecomp(compJB);
		
		
		//DAO
		if(result) {
			//連到加入資料庫 顯示JSP 抓資料
			out.write("修改成功<br/>");
			
			out.write("企業編號:" + compJB.getCompanyId() + "<br/>");
			out.write("企業名稱:" + compJB.getCompanyName() + "<br/>");
//			out.write("品牌圖示:" + compJB.getLogo() + "<br/>");
			out.write("統一編號:" + compJB.getUniformNumbers() + "<br/>");
			out.write("行業類別:" + compJB.getCategories() + "<br/>");
			out.write("帳號:" + compJB.getAccount() + "<br/>");
			out.write("密碼:" + compJB.getPassword() + "<br/>");
			out.write("信箱:" + compJB.getEmail() + "<br/>");
			out.write("公司電話:" + compJB.getPhone() + "<br/>");
//			out.write("營業登記證:" + compJB.getBusRC() + "<br/>");
			out.write("合作銀行:" + compJB.getBankId() + "<br/>");
			
			
//			timeout
//			sendredirect company.jsp
			response.setHeader("Refresh", "3;Enter.jsp");
			out.println("請重新登入<br/>");
			out.println("3秒後回到登入頁<br/>");
			
			compDao.closeConn();
		}else {
			//失敗 連到errorpage 或sendredirect回新增頁
			out.write("Update Fail.<br/>");
			compDao.closeConn();
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
