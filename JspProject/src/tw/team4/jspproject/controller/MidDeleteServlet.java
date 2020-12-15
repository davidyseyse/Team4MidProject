package tw.team4.jspproject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.team4.jspproject.dao.MidProductDao;

/**
 * Servlet implementation class MidDeleteServlet
 */
@WebServlet("/MidDeleteServlet.do")
public class MidDeleteServlet extends HttpServlet {
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
		
		
		String list = ProductName;
		request.setAttribute("list", list);
		
		MidProductDao pDao = new MidProductDao();
		try {
			pDao.createConn(out); 
			int a =pDao.deleteDB(list);
			if(a==1)
				out.write("刪除成功");
			else
				out.write("刪除失敗");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pDao.closeConn(out);
			} catch (SQLException e) {
		
				e.printStackTrace();
			}
			
		}	
		
		RequestDispatcher dis = request.getRequestDispatcher("jsp/team4/product/DeleteProduct.jsp");
		dis.forward(request, response);
		
	}
		
}