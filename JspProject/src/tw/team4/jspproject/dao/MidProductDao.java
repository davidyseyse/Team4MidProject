package tw.team4.jspproject.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tw.team4.jspproject.javabean.MidProductJavaBean;

public class MidProductDao {
	private Connection conn;

	
	public void createConn(PrintWriter out) throws ClassNotFoundException, SQLException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String urlstr ="jdbc:sqlserver://java20201019.database.windows.net:1433;"
				+ "database=JavaDemo;user=team4sa@java20201019;password=Sa123456;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;"
				+ "loginTimeout=30;";
		conn = DriverManager.getConnection(urlstr);

	}	
	
//	public void queryDb(PrintWriter out) throws SQLException {
//		String sqlstr = "Select * From Product";
//	    PreparedStatement preState = conn.prepareStatement(sqlstr);
//	    
//	    ResultSet rs = preState.executeQuery();
//	    
//	    while(rs.next()) {
//	    	out.write(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3)
//	    	+ " " + rs.getString(4)+ " " + rs.getInt(5)+ " " + rs.getInt(6)
//	    	+ "<br/>");
//	    	
//	    }
//	    alterDB
//	    rs.close();
//	    preState.close();
//	}	
	public void insertDB(MidProductJavaBean pro) throws SQLException {
		String sqlstr = "insert into Product(ProductName, ProductStuck, ProductPrice, ProductType, StoreId, Discount)values(?,?,?,?,?,?)";
	    PreparedStatement preState = conn.prepareStatement(sqlstr);

	    preState.setString(1,pro.getProductName());
	    preState.setInt(2,pro.getProductStuck());
	    preState.setInt(3, pro.getProductPrice());
	    preState.setString(4, pro.getProductType());
	    preState.setInt(5,pro.getStoreId());
	    preState.setInt(6,pro.getDiscount());
	    preState.execute();
	}	
	public void alterDB(MidProductJavaBean pro) throws SQLException {
		String sqlstr = "update Product SET ProductStuck=?,ProductPrice=?,ProductType=?,StoreId=?,Discount=? where ProductName=? ";
	    PreparedStatement preState = conn.prepareStatement(sqlstr);

	    
	    preState.setInt(1,pro.getProductStuck());
	    preState.setInt(2, pro.getProductPrice());
	    preState.setString(3, pro.getProductType());
	    preState.setInt(4,pro.getStoreId());
	    preState.setInt(5,pro.getDiscount());
	    preState.setString(6,pro.getProductName());
	    preState.execute();
	}	
	public int deleteDB(String ProductName) throws SQLException {
		
		String sqlstr = "DELETE FROM Product WHERE ProductName=?";
	    PreparedStatement preState = conn.prepareStatement(sqlstr);
	    
	    preState.setString(1,ProductName);
	    preState.execute();
	    return 1;
	}	
	
	public ArrayList<MidProductJavaBean> queryAll() throws SQLException {
		ArrayList<MidProductJavaBean> list = new ArrayList<MidProductJavaBean>();
		String sqlstr = "select * from Product";
		PreparedStatement state = conn.prepareStatement(sqlstr);
		ResultSet res = state.executeQuery();
		
		while(res.next()) {
			
			String ProductName = res.getString("ProductName");
			int ProductStuck = res.getInt("ProductStuck");
			int ProductPrice = res.getInt("ProductPrice");
			String ProductType = res.getString("ProductType");
			int StoreId = res.getInt("StoreId");
			int Discount = res.getInt("Discount");
			
			
			
			MidProductJavaBean pro = new MidProductJavaBean(ProductName, ProductStuck, ProductPrice, ProductType, StoreId, Discount);
			
			list.add(pro);	
			
		}
		
		
		return list;
	}
	
	public void closeConn(PrintWriter out) throws SQLException {
		if(conn!=null) {
			conn.close();
//			out.write("Connection Closed.<br/>");
//			System.out.println("bye");
		}
	}
}
