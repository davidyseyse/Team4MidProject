package tw.team4.jspproject.service;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import tw.elainehsueh.project.event.EventInputSystemBean;
import tw.team4.jspproject.javabean.AttractionBean;
import tw.team4.jspproject.javabean.EventBean;
import tw.team4.jspproject.javabean.ExhibitionBean;
import tw.team4.jspproject.javabean.PriceBean;

public class EventSysImp{
	private Connection conn;
	private PrintWriter out;
	
	public void createSQLServerJndiConn() throws NamingException, SQLException, ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		  String urlstr ="jdbc:sqlserver://java20201019.database.windows.net:1433;"
		    + "database=JavaDemo;user=team4sa@java20201019;password=Sa123456;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;"
		    + "loginTimeout=30;";
		  conn = DriverManager.getConnection(urlstr);
		
		
//		InitialContext context = new InitialContext();
//		DataSource ds = (DataSource)context.lookup("java:comp/env/connProjectServerJndi/orderService");
//		conn = ds.getConnection();
//		boolean status1=!conn.isClosed();
//		System.out.println(status1);
	}


	
	public void closeConn() throws SQLException {
		if(conn!=null) {
			conn.close();
		}

	}
	
	
	public void addEvent(EventBean eb) throws SQLException {
//		java.util.Date javaDate = new java.util.Date();
//		long javaTime = javaDate.getTime();
//		java.sql.Date sqlDate = new java.sql.Date(javaTime);	
		String sqlstr = "Insert into Event(typeId, eventName, eventLocation, organizationId, companyId) Values(?,?,?,?,?)";
		PreparedStatement preState = conn.prepareStatement(sqlstr);
		preState.setInt(1,eb.getTypeId());
		preState.setString(2,eb.getEventName());
		preState.setString(3,eb.getEventLocation());
		preState.setInt(4, eb.getOrganizationId());
		preState.setInt(5, eb.getCompanyId());
		preState.execute();
		preState.close();
	}
	
	public void updateEvent(EventBean eb)throws SQLException{
		String sqlstr = "Update Event set typeId=?, eventName=?, eventLocation=?, organizationId=?, companyId=? where id="+eb.getEventId();
		PreparedStatement preState = conn.prepareStatement(sqlstr);
		preState.setInt(1,eb.getTypeId());
		preState.setString(2,eb.getEventName());
		preState.setString(3,eb.getEventLocation());
		preState.setInt(4, eb.getOrganizationId());
		preState.setInt(5, eb.getCompanyId());
		preState.execute();
		preState.close();
		
	}
	
	public void addExhibition(ExhibitionBean ebb) throws SQLException {
		String eventstr = "select top 1 id from event order by Id desc";
		PreparedStatement preStateE = conn.prepareStatement(eventstr);
		ResultSet rs = preStateE.executeQuery();
		int eventId = 0;
		while(rs.next()) {
	    	eventId=rs.getInt(1);}
		rs.close();
	    preStateE.close();
		
		String sqlstr = "Insert into exhibition(eventId,onSaleDate,offSaleDate,commDate,dueDate,description,cardId) Values (?,?,?,?,?,?,?)";
		PreparedStatement preState = conn.prepareStatement(sqlstr);
		preState.setInt(1, eventId);
		preState.setTimestamp(2, ebb.getOnSaleDate());
		preState.setTimestamp(3, ebb.getOffSaleDate());
		preState.setDate(4, ebb.getCommDate());
		preState.setDate(5, ebb.getDueDate());
		preState.setString(6, ebb.getDescription());
		preState.setInt(7, ebb.getCardId());
		preState.execute();
		preState.close();

	}
	
	
	public void updateExhibition(ExhibitionBean ebb) throws SQLException {
	
		String sqlstr = "Update exhibition set onSaleDate=?,offSaleDate=?,commDate=?,dueDate=?,description=?,cardId=? where id="+ebb.getEventId();
		PreparedStatement preState = conn.prepareStatement(sqlstr);
		preState.setTimestamp(1, ebb.getOnSaleDate());
		preState.setTimestamp(2, ebb.getOffSaleDate());
		preState.setDate(3, ebb.getCommDate());
		preState.setDate(4, ebb.getDueDate());
		preState.setString(5, ebb.getDescription());
		preState.setInt(6, ebb.getCardId());
		preState.execute();
		preState.close();

	}
	
	
	
	public void addAttraction(AttractionBean ab) throws SQLException {
//		java.util.Date javaDate = new java.util.Date();
//		long javaTime = javaDate.getTime();
//		java.sql.Date sqlDate = new java.sql.Date(javaTime);	
		String eventstr = "select top 1 id from event order by Id desc";
		PreparedStatement preStateE = conn.prepareStatement(eventstr);
		ResultSet rs = preStateE.executeQuery();
		int eventId = 0;
		while(rs.next()) {
	    	eventId=rs.getInt(1);}
		rs.close();
	    preStateE.close();
		
		String sqlstr = "Insert into attraction(eventId,onSaleDate,offSaleDate,commDate,dueDate,description) Values (?,?,?,?,?,?)";
		PreparedStatement preState = conn.prepareStatement(sqlstr);
		preState.setInt(1, eventId);
		preState.setTimestamp(2, ab.getOnSaleDate());
		preState.setTimestamp(3, ab.getOffSaleDate());
		preState.setDate(4, ab.getCommDate());
		preState.setDate(5, ab.getDueDate());
		preState.setString(6, ab.getDescription());
		preState.execute();
		preState.close();

	}
	
	public void updateAttraction(AttractionBean ab) throws SQLException {
		String sqlstr = "Update attraction set onSaleDate=?,offSaleDate=?,commDate=?,dueDate=?,description=? where id="+ab.getEventId();
		PreparedStatement preState = conn.prepareStatement(sqlstr);
		preState.setTimestamp(1, ab.getOnSaleDate());
		preState.setTimestamp(2, ab.getOffSaleDate());
		preState.setDate(3, ab.getCommDate());
		preState.setDate(4, ab.getDueDate());
		preState.setString(5, ab.getDescription());
		preState.execute();
		preState.close();

	}
	
	public void addPrice(PriceBean pb) throws SQLException{
		String eventstr = "select top 1 id from event order by Id desc";
		PreparedStatement preStateE = conn.prepareStatement(eventstr);
		ResultSet rs = preStateE.executeQuery();
		int eventId = 0;
		while(rs.next()) {
	    	eventId=rs.getInt(1);}
		rs.close();
	    preStateE.close();
	    
	    String sqlstr = "Insert into price(eventId,name,cost)values(?,?,?)";
		PreparedStatement preState = conn.prepareStatement(sqlstr);
		
		preState.setInt(1, eventId);
		preState.setString(2, pb.getName());
		preState.setInt(3, pb.getCost());
		preState.execute();
		preState.close();
	    
	}
	
	public void deletePrice(int eventId) throws SQLException{
		String eventstr = "DELETE FROM Price WHERE eventId="+eventId;
		PreparedStatement preStateE = conn.prepareStatement(eventstr);
		preStateE.execute();
	    preStateE.close();
	    
	}
	
	public void updatePrice(PriceBean pb) throws SQLException{
		
		String sqlstr = "Insert into price(eventId,name,cost)values(?,?,?)";
		PreparedStatement preState = conn.prepareStatement(sqlstr);
		
		preState.setInt(1, pb.getEventId());
		preState.setString(2, pb.getName());
		preState.setInt(3, pb.getCost());
		preState.execute();
		preState.close();
	    
	}

	
	public EventBean queryOneEvent(int id) throws SQLException {
		EventBean eb =null;
		String sqlstr = "Select * from event where id=?";
		PreparedStatement preState = conn.prepareStatement(sqlstr);
		preState.setInt(1,id);
		ResultSet rs = preState.executeQuery();
		
		
	    while(rs.next()) {
	    	int eventId=rs.getInt(1);
	    	int typeId=rs.getInt("typeId");
	    	String eventName = rs.getString("eventName");
			String eventLocation = rs.getString("eventLocation");
			byte[] eventImage = rs.getBytes("eventImage");
			int organizationId = rs.getInt("organizationId");
			int companyId = rs.getInt("companyId");
			eb = new EventBean(eventId,typeId,eventName,eventLocation,eventImage,organizationId,companyId);
	    }
	    rs.close();
	    preState.close();
		return eb;
	}
	
	public ExhibitionBean queryOneExhibition(int id) throws SQLException {
		ExhibitionBean ebb =null;
		String sqlstr = "Select * from exhibition where eventid=?";
		PreparedStatement preState = conn.prepareStatement(sqlstr);
		preState.setInt(1,id);
		ResultSet rs = preState.executeQuery();
		
		
	    while(rs.next()) {
	    	int exhibitionId=rs.getInt(1);
	    	int eventId=rs.getInt("eventId");
			Timestamp onSaleDate = rs.getTimestamp("onSaleDate");
			Timestamp offSaleDate = rs.getTimestamp("offSaleDate");
			Date commDate = rs.getDate("commDate");
			Date dueDate = rs.getDate("dueDate");
			String description = rs.getString("description");
			int cardId=rs.getInt("cardId");
			ebb = new ExhibitionBean(exhibitionId,eventId,onSaleDate,offSaleDate,commDate,dueDate,description,cardId);
	    }
	    rs.close();
	    preState.close();
		return ebb;
	}
	
	public AttractionBean queryOneAttraction(int id) throws SQLException {
		AttractionBean ab =null;
		String sqlstr = "Select * from attraction where eventid=?";
		PreparedStatement preState = conn.prepareStatement(sqlstr);
		preState.setInt(1,id);
		ResultSet rs = preState.executeQuery();
		
		
	    while(rs.next()) {
	    	int attractionId=rs.getInt(1);
	    	int eventId=rs.getInt("eventId");
			Timestamp onSaleDate = rs.getTimestamp("onSaleDate");
			Timestamp offSaleDate = rs.getTimestamp("offSaleDate");
			Date commDate = rs.getDate("commDate");
			Date dueDate = rs.getDate("dueDate");
			String description = rs.getString("description");
			ab = new AttractionBean(attractionId,eventId,onSaleDate,offSaleDate,commDate,dueDate,description);
	    }
	    rs.close();
	    preState.close();
		return ab;
	}
	
	public ArrayList<PriceBean> queryOnePrice(int id) throws SQLException {
		ArrayList<PriceBean> list = new ArrayList<PriceBean>();
		String sqlstr = "Select * from price where eventid=?";
		PreparedStatement preState = conn.prepareStatement(sqlstr);
		preState.setInt(1,id);
		ResultSet rs = preState.executeQuery();
		
		
	    while(rs.next()) {
	    	int priceId=rs.getInt(1);
	    	int eventId=rs.getInt("eventId");
	    	String name = rs.getString("name");
	    	int cost=rs.getInt("cost");
	    	PriceBean pb = new PriceBean(priceId,eventId,name,cost);
	    	list.add(pb);
	    }
	    rs.close();
	    preState.close();
		return list;
	}
	
	public ArrayList<EventBean> queryAll() throws SQLException {
		ArrayList<EventBean> list = new ArrayList<EventBean>();
		String sqlstr = "Select * from event";
		PreparedStatement preState = conn.prepareStatement(sqlstr);
	    ResultSet rs = preState.executeQuery();
		
	    while(rs.next()) {
	    	int eventId=rs.getInt(1);
	    	int typeId=rs.getInt("typeId");
	    	String eventName = rs.getString("eventName");
			String eventLocation = rs.getString("eventLocation");
			byte[] eventImage = rs.getBytes("eventImage");
			int organizationId = rs.getInt("organizationId");
			int companyId = rs.getInt("companyId");
			EventBean eb = new EventBean(eventId,typeId,eventName,eventLocation,eventImage,organizationId,companyId);
			list.add(eb);	
	    
	    }
	    rs.close();
	    preState.close();
		return list;
	}

}
