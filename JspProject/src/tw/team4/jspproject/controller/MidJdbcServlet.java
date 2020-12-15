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

@WebServlet("/MidJdbcServlet.do")
public class MidJdbcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PrintWriter out;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request, response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html;charset=UTF-8");
		out = response.getWriter();
		MidProductDao pDao = new MidProductDao();
		try {
			pDao.createConn(out); 
			ArrayList<MidProductJavaBean> list = pDao.queryAll();
			request.setAttribute("list", list);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pDao.closeConn(out);
			} catch (SQLException e) {
		
				e.printStackTrace();
			}
		}	
		
		RequestDispatcher dis = request.getRequestDispatcher("jsp/team4/product/TestMid.jsp");
		dis.forward(request, response);
		
	}
		
		
	
	

	
}









