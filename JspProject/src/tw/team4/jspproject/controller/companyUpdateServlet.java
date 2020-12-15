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

import tw.team4.jspproject.dao.CompanyDaoImpl;
import tw.team4.jspproject.javabean.CompanyJavabean;


@WebServlet("/jsp/team4/company/companyUpdateServlet")
public class companyUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		
//		ServletContext context =getServletContext();
//		CompanyJavabean newJB= (CompanyJavabean) context.getAttribute("compJB");
//		
		CompanyDaoImpl compDao = new CompanyDaoImpl();
		
		try {
			compDao.createConn();
		
		CompanyJavabean compJB = compDao.findbylog(password, account);
		
		
//		int companyId = compJB.getCompanyId();
//		String companyName = compJB.getCompanyName();
////		String logo = compJB.getLogo();
//		String uniformNumbers = compJB.getUniformNumbers();
//		String categories = compJB.getCategories();
//		String returnAccount = compJB.getAccount();
//		String returnPassword = compJB.getPassword();
//		String email = compJB.getEmail();
//		String phone = compJB.getPhone();
////		String busRC = compJB.getBusRC();
//		int bankId = compJB.getBankId();
		
		
		request.setAttribute("compJB",compJB);
//		request.setAttribute("oNum", orderSystemBean.getOrderNumber());
//		request.setAttribute("customer", orderSystemBean.getCustomer());
//		request.setAttribute("shipAddress", orderSystemBean.getShipAddress());
//		request.setAttribute("phone", orderSystemBean.getPhone());
		
		RequestDispatcher rd = request.getRequestDispatcher("CompanyUpdate.jsp");
		rd.forward(request, response);	
		
		compDao.closeConn();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
