package tw.team4.jspproject.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.team4.jspproject.dao.DaoCampaign;
import tw.team4.jspproject.javabean.Campaign;

/**
 * Servlet implementation class CampaignUpdateServlet
 */
@WebServlet("/jsp/team4/campaign/CampaignUpdateServlet")
public class CampaignUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		
		request.setCharacterEncoding("UTF-8");
		int campId = Integer.parseInt(request.getParameter("campId"));
		String title = request.getParameter("title");
		String startDate = request.getParameter("startDate");
		String startTime = request.getParameter("startTime");
		String StartDateTime = startDate+" "+startTime+":00";
		
		Timestamp StartDateTimeStamp = Timestamp.valueOf(StartDateTime);
		
		String endDate = request.getParameter("endDate");
		String endTime = request.getParameter("endTime");
		String endDateTime = endDate+" "+endTime+":00";
		
		Timestamp endDateTimeStamp = Timestamp.valueOf(endDateTime);
		
		Boolean status = Boolean.valueOf(request.getParameter("status"));	
		String description = request.getParameter("description");
		//----------------------------------------------------------------		

		Campaign camp =  new Campaign(campId,title,description,StartDateTimeStamp,endDateTimeStamp,status);
		
		
		DaoCampaign dao = new DaoCampaign();
		try {		
			dao.createConnection();			
			dao.update(camp);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		request.setAttribute("camp", camp);
		request.setAttribute("isUpdate", true);
		
		RequestDispatcher rd = request.getRequestDispatcher("showResult.jsp");
		
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}		

}
