package tw.team4.jspproject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.team4.jspproject.dao.MidProductDao;
import tw.team4.jspproject.javabean.MidProductJavaBean;


/**
 * Servlet implementation class MidInsertServlet
 */
@WebServlet("/MidInsertServlet.do")
public class MidInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private PrintWriter out;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request, response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		out = response.getWriter();
		String ProductName = request.getParameter("productName");			
		int ProductStuck = Integer.valueOf(request.getParameter("productStuck"));
		int ProductPrice = Integer.valueOf(request.getParameter("productPrice"));
		String ProductType = request.getParameter("productType");
		int StoreId =Integer.valueOf(request.getParameter("storeId"));
		int Discount = Integer.valueOf(request.getParameter("discount"));
		
		MidProductJavaBean list = new MidProductJavaBean(ProductName, ProductStuck, ProductPrice, ProductType, StoreId, Discount);
		request.setAttribute("list", list);
		
		MidProductDao pDao = new MidProductDao();
		try {
			pDao.createConn(out); 
			pDao.insertDB(list);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pDao.closeConn(out);
			} catch (SQLException e) {
		
				e.printStackTrace();
			}
		}	
		
		RequestDispatcher dis = request.getRequestDispatcher("jsp/team4/product/AddProduct.jsp");
		dis.forward(request, response);
		
	}
		
}