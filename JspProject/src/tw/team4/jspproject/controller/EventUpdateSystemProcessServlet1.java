package tw.team4.jspproject.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tw.team4.jspproject.javabean.EventBean;
import tw.team4.jspproject.javabean.ExhibitionBean;
import tw.team4.jspproject.javabean.PriceBean;
import tw.team4.jspproject.service.EventSysImp;

/**
 * Servlet implementation class EventInputSystemProcessServlet
 */
@WebServlet("/jsp/team4/ticket/EventUpdateSystemProcessServlet1.do")
public class EventUpdateSystemProcessServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processAction(request,response);
		} catch (ClassNotFoundException | IOException | SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				try {
					processAction(request,response);
				} catch (ClassNotFoundException | IOException | SQLException | ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
	}


	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ParseException, ClassNotFoundException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();		
		//event
		Integer eventId=Integer.valueOf(request.getParameter("eventId"));
		Integer typeId=Integer.valueOf(request.getParameter("typeId"));
		String eventName = request.getParameter("eventName");
		String eventLocation = request.getParameter("eventLocation");
		byte[] eventImage= request.getParameter("eventImage").getBytes();
		Integer organizationId = Integer.valueOf(request.getParameter("organizationId"));
		Integer companyId = Integer.valueOf(request.getParameter("companyId"));
		
		//exhibition
		String onSaleD = request.getParameter("onSaleD");
		String onSaleT = request.getParameter("onSaleT");
		String onSaleDate = onSaleD+" "+onSaleT+":00";
		Timestamp onSaleDateTimeStamp = Timestamp.valueOf(onSaleDate);
		
		String offSaleD = request.getParameter("offSaleD");
		String offSaleT = request.getParameter("offSaleT");
		String offSaleDate = offSaleD+" "+offSaleT+":00";
		Timestamp offSaleDateTimeStamp = Timestamp.valueOf(offSaleDate);
		
		Date commDate = Date.valueOf(request.getParameter("commDate"));
		Date dueDate = Date.valueOf(request.getParameter("dueDate"));
		String description = request.getParameter("description");
		EventSysImp eis = new EventSysImp();
		
		Integer cardId = Integer.valueOf(request.getParameter("cardId"));
		
		EventBean eb = new EventBean(eventId,typeId,eventName,eventLocation,eventImage,organizationId,companyId);
		ExhibitionBean exb = new ExhibitionBean(eventId,onSaleDateTimeStamp,offSaleDateTimeStamp,commDate,dueDate,description,cardId);
		try {
			eis.createSQLServerJndiConn();
			eis.updateEvent(eb);
			eis.updateExhibition(exb);
			eis.deletePrice(eventId);
			//price
			String[] priceNameList = request.getParameterValues("priceName");
			String[] priceCostList = request.getParameterValues("priceCost");
			for(int i=0;i<priceNameList.length;i++) {
				String name = priceNameList[i];
				int cost = Integer.parseInt(priceCostList[i]);
				PriceBean pb = new PriceBean(eventId,name,cost);
				eis.updatePrice(pb);
			}
			session.setAttribute("pricename", priceNameList);
			session.setAttribute("pricecost", priceCostList);
			
			session.setAttribute("event", eb);
			session.setAttribute("exhibition", exb);
			
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		} finally{
			eis.closeConn();
		}
		
		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter out = response.getWriter();
		response.sendRedirect("eventShowPage1.jsp");
		
	}

}
