package tw.team4.jspproject.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.team4.jspproject.dao.ReportDao;
import tw.team4.jspproject.javabean.ReportJavaBean;

@WebServlet("/ReportServletUpdate.do")
public class ReportServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processAction(request, response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		try {
			ReportDao repDao = new ReportDao();
			repDao.createSQLServerJndiConn();

			String Reportid = request.getParameter("Reportid");
			String Productclass = request.getParameter("Productclass");
			String Productname = request.getParameter("Productname");
			int Salesamount = Integer.parseInt(request.getParameter("Salesamount"));
			int Productprice = Integer.parseInt(request.getParameter("Productprice"));

			// 修改
			if (Reportid != "") {
//				System.out.println("Reportid==>" + Reportid);
				ReportJavaBean repup = new ReportJavaBean(Productclass, Productname, Salesamount, Productprice);
				repup.setReportid(Integer.parseInt(Reportid));
				boolean result = repDao.update(repup);
				if (result) {

					out.write("Update Profiles Success<br/>");
					out.write("5秒後將移轉至資料網頁<br/>");
					response.setHeader("Refresh",
							"5" + ";URL=http://localhost:8085/JspProject/jsp/team4/report/Report.jsp");

				} else {
					out.write("it is false.<br/>");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
