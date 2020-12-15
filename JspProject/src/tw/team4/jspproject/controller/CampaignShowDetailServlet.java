package tw.team4.jspproject.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.team4.jspproject.dao.DaoCampaign;
import tw.team4.jspproject.javabean.Campaign;

/**
 * Servlet implementation class CampaignShowDetailServlet
 */
@WebServlet("/jsp/team4/campaign/CampaignShowDetailServlet")
public class CampaignShowDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int campId = Integer.parseInt(request.getParameter("campId"));
		
		DaoCampaign dao = new DaoCampaign();
		try {
			dao.createConnection();
			Campaign camp = dao.queryById(campId);
			System.out.println(camp);
			request.setAttribute("camp", camp);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		RequestDispatcher dis = request.getRequestDispatcher("CampaignBO.jsp");
		dis.forward(request, response);
	}

}