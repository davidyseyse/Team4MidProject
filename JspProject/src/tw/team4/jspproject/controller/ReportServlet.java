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

@WebServlet("/ReportServlet.do")
public class ReportServlet extends HttpServlet {
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
		PrintWriter out = response.getWriter();
//		HttpSession session = request.getSession();
//		String sessionId = session.getId();
//		out.write("session ID:"+sessionId+"<br/>");

		try {
			ReportDao repDao = new ReportDao();
			repDao.createSQLServerJndiConn();

			String Companyid = request.getParameter("Companyid");
			int Storeid = Integer.parseInt(request.getParameter("Storeid"));
			String Storearea = request.getParameter("Storearea");
			String Storename = request.getParameter("Storename");
			String Productclass = request.getParameter("Productclass");
			String Productname = request.getParameter("Productname");
			String Salesdate = request.getParameter("Salesdate");
			int Salesamount = Integer.parseInt(request.getParameter("Salesamount"));
			int Productprice = Integer.parseInt(request.getParameter("Productprice"));
			String Payment = request.getParameter("Payment");
			String Activeitem = request.getParameter("Activeitem");

			// 新增
			if (Companyid != "") {
				ReportJavaBean repBean = new ReportJavaBean(Companyid, Storeid, Storearea, Storename, Productclass,
						Productname, Salesdate, Salesamount, Productprice, Payment, Activeitem);
				boolean result = repDao.insert(repBean);
				if (result) {

					out.write("Insert Profiles Success<br/>");
					out.write(Companyid + "," + Storeid + "," + Storearea + "," + Storename + "," + Productclass + ","
							+ Productname + "," + Salesdate + "," + Salesamount + "," + Productprice + "," + Payment
							+ "," + Activeitem + "<br/>");
					out.write("5秒後將移轉至資料網頁<br/>");
					response.setHeader("Refresh",
							"5" + ";URL=http://localhost:8085/JspProject/jsp/team4/report/Report.jsp");
					;

				} else {
					out.write("no result.<br/>");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
