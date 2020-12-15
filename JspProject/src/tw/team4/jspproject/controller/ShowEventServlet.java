package tw.team4.jspproject.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tw.team4.jspproject.javabean.EventBean;
import tw.team4.jspproject.service.EventSysImp;

/**
 * Servlet implementation class EventInputSystemProcessServlet
 */
@WebServlet("/jsp/team4/ticket/serviceShowEventServlet.do")
public class ShowEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processAction(request,response);
		} catch (ClassNotFoundException | IOException | SQLException | ParseException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				try {
					processAction(request,response);
				} catch (ClassNotFoundException | IOException | SQLException | ParseException | ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
	}


	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ParseException, ServletException, ClassNotFoundException {
		request.setCharacterEncoding("UTF-8");	
		response.setContentType("text/html;charset=UTF-8");
		EventSysImp eis = new EventSysImp();
		try {
			eis.createSQLServerJndiConn();
			ArrayList<EventBean> eventbean = eis.queryAll();
			request.setAttribute("eventbean", eventbean);
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		} finally{
			eis.closeConn();
		}
		
		RequestDispatcher dis = request.getRequestDispatcher("showAllEventPage.jsp");
		dis.forward(request, response);
		
	}

}
