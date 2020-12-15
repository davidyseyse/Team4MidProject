package tw.team4.jspproject.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.team4.jspproject.javabean.AttractionBean;
import tw.team4.jspproject.javabean.EventBean;
import tw.team4.jspproject.javabean.ExhibitionBean;
import tw.team4.jspproject.javabean.PriceBean;
import tw.team4.jspproject.service.EventSysImp;

@WebServlet("/jsp/team4/ticket/detailEventServlet.do")
public class detailEventServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processAction(request,response);
		} catch (ClassNotFoundException | ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processAction(request,response);
		} catch (ClassNotFoundException | ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
		request.setCharacterEncoding("UTF-8");	
		response.setContentType("text/html;charset=UTF-8");
		EventSysImp eis = new EventSysImp();	
		
		Integer eventId=Integer.valueOf(request.getParameter("eventId"));
		Integer typeId=Integer.valueOf(request.getParameter("typeId"));
		
		try {
			eis.createSQLServerJndiConn();
			EventBean event = eis.queryOneEvent(eventId);
			request.setAttribute("event", event);
			ArrayList<PriceBean> arr =eis.queryOnePrice(eventId);
			String[] priceNameList = new String[arr.size()];
			int[] priceCostList = new int[arr.size()];
			for(int i=0;i<arr.size();i++) {
				PriceBean price = arr.get(i);
				String name = price.getName();
				Integer cost = price.getCost();
				priceNameList[i]=name;
				priceCostList[i]=cost;
			}
			request.setAttribute("pricename", priceNameList);
			request.setAttribute("pricecost", priceCostList);
			
			switch(typeId) { 
	        case 1: 
				ExhibitionBean exhibition = eis.queryOneExhibition(eventId);
				request.setAttribute("exhibition", exhibition);
				break; 
	        case 2:
	        	AttractionBean attraction = eis.queryOneAttraction(eventId);
				request.setAttribute("attraction", attraction);
	            break; 
	        
	        default: 
	            break;
	    } 
			
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				eis.closeConn();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		if(typeId==1) {
			RequestDispatcher dis = request.getRequestDispatcher("eventShowPage1.jsp");
			dis.forward(request, response);
		}else if(typeId==2) {
			RequestDispatcher dis = request.getRequestDispatcher("eventShowPage2.jsp");
			dis.forward(request, response);
		}

	}
	
	
}
