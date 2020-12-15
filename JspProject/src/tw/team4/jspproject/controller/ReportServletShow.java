package tw.team4.jspproject.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.team4.jspproject.dao.ReportDao;
import tw.team4.jspproject.javabean.ReportJavaBean;

@WebServlet("/ReportServletShow.do")
public class ReportServletShow extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processAction(request, response);
		System.out.println("測試");
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter out = response.getWriter();

		try {
			ReportDao repDao = new ReportDao();
			repDao.createSQLServerJndiConn();

			// 尋找所有
			ArrayList<ReportJavaBean> lista = repDao.query();

			request.setAttribute("list", lista);
			System.out.println("lista:" + lista.size());
			request.getRequestDispatcher("jsp/team4/report/Report.jsp").forward(request, response);

			repDao.closeConn();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
