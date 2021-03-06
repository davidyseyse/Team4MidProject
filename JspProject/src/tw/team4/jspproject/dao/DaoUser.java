package tw.team4.jspproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import tw.team4.jspproject.javabean.User;

public class DaoUser {
	private Connection conn;
	
	public boolean createConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String urlstr ="jdbc:sqlserver://java20201019.database.windows.net:1433;"
		    + "database=JavaDemo;user=team4sa@java20201019;password=Sa123456;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;"
		    + "loginTimeout=30;";
		conn = DriverManager.getConnection(urlstr);
		
		if (!conn.isClosed()){
			return true;
		}
		
		return false;
	}
	
	public User queryUser(String userId, String userPassword) throws SQLException {
		
		String sql = "select * from Users where userId=? and userPassword=?";
		PreparedStatement state = conn.prepareStatement(sql);
		state.setString(1,userId);
		state.setString(2,userPassword);
		ResultSet rs = state.executeQuery();
		if (rs.next()) {
			
			int id = rs.getInt("id");
			String name = rs.getString("userName");
			User u = new User(id,userId,userPassword,name);
			return u;
			
		}
			
		return null;
		
	}
	
	public void close() throws SQLException {
		if(conn!=null) {
			conn.close();
		}else {
			System.out.println("no connection");
		}
	}
}
