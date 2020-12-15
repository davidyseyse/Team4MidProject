package tw.team4.jspproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tw.team4.jspproject.javabean.CompanyJavabean;

public class CompanyDaoImpl implements CompanyDao {
	
	//連線 新insert刪delete修update查query關連線

	private Connection conn;

	@Override
	public void createConn() throws SQLException, ClassNotFoundException{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String urlstr="jdbc:sqlserver://java20201019.database.windows.net:1433;databaseName=JavaDemo;user=team4sa;password=Sa123456";
		conn=DriverManager.getConnection(urlstr);
//		boolean status =!conn.isClosed();

	}

	@Override
	public boolean addcomp(CompanyJavabean cjb) throws SQLException {
		//新增門市資訊(id 到時候會設流水號)
		
		String sqlstr = "Insert into Company(CompanyName,Logo,UniformNumbers,Categories,CmpAcc,CmpPwd,Email,CompanyPhone,BusRC,BankId)Values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement prestate = conn.prepareStatement(sqlstr);
		
		
		
		prestate.setString(1, cjb.getCompanyName());
		prestate.setBlob(2, cjb.getLogo());
		prestate.setString(3, cjb.getUniformNumbers());
		prestate.setString(4, cjb.getCategories());
		prestate.setString(5, cjb.getAccount());
		prestate.setString(6, cjb.getPassword());
		prestate.setString(7, cjb.getEmail());
		prestate.setString(8, cjb.getPhone());
		prestate.setBlob(9, cjb.getBusRC());
		prestate.setInt(10, cjb.getBankId());
		
		prestate.execute();
		prestate.close();
		return true;

	}

//	@Override
//	public void uppdatecomp(CompanyJavabean cjb) throws SQLException {
//		//透過CompanyId更新門市資訊
//		String sqlstr = "Update Company set CompanyName = ?, Logo =?, UniformNumbers =? , Categories =? , CmpAcc =? , CmpPwd =? , Email =? , CompanyPhone =? , BusRC =? , BankId =? where getCompanyId=?";
//		PreparedStatement prestate = conn.prepareStatement(sqlstr);
//		
//		prestate.setString(1, cjb.getCompanyName());
//		prestate.setBlob(2, cjb.getLogo());
//		prestate.setString(3, cjb.getUniformNumbers());
//		prestate.setString(4, cjb.getCategories());
//		prestate.setString(5, cjb.getAccount());
//		prestate.setString(6, cjb.getPassword());
//		prestate.setString(7, cjb.getEmail());
//		prestate.setString(8, cjb.getPhone());
//		prestate.setBlob(9, cjb.getBusRC());
//		prestate.setInt(10, cjb.getBankId());
//		prestate.setInt(11, cjb.getCompanyId());
//		prestate.execute();
//		prestate.close();
//
//	}
	
	@Override
	public boolean uppdatecomp(CompanyJavabean cjb) throws SQLException {
		//透過CompanyId更新company資訊
		String sqlstr = "Update Company set CompanyName = ?, UniformNumbers =? , Categories =? , CmpAcc =? , CmpPwd =? , Email =? , CompanyPhone =? , BankId =? where CompanyId=?";
		PreparedStatement prestate = conn.prepareStatement(sqlstr);
		
		prestate.setString(1, cjb.getCompanyName());
		prestate.setString(2, cjb.getUniformNumbers());
		prestate.setString(3, cjb.getCategories());
		prestate.setString(4, cjb.getAccount());
		prestate.setString(5, cjb.getPassword());
		prestate.setString(6, cjb.getEmail());
		prestate.setString(7, cjb.getPhone());
		prestate.setInt(8, cjb.getBankId());
		prestate.setInt(9, cjb.getCompanyId());
		prestate.execute();
		prestate.close();
		
		return true;
	}

	@Override
	public CompanyJavabean findbylog(String pwd ,String account) throws SQLException {
		
//		String sqlstr = "select * from Company where CmpPwd=? and CmpAcc=?";
//		PreparedStatement prestate = conn.prepareStatement(sqlstr);
		PreparedStatement prestate = conn.prepareStatement("select * from Company where CmpPwd=? and CmpAcc=?");
		prestate.setString(1, pwd);
		prestate.setString(2, account);
		ResultSet rs = prestate.executeQuery();
		
		
		CompanyJavabean a = null;
		if(rs.next()) {
//			a= new CompanyJavabean(rs.getInt(1),rs.getString(2),rs.getBlob(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getBlob(10),rs.getInt(11));
			a= new CompanyJavabean(rs.getInt(1),rs.getString(2),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(11));
		}
		rs.close();
		prestate.close();
		return a;
	}
	
	@Override
	public CompanyJavabean findby(int companyId) throws SQLException {
		//透過CompanyId搜尋門市資訊
		String sqlstr = "select* from Company where CompanyId =?";
		PreparedStatement prestate = conn.prepareStatement(sqlstr);
		prestate.setInt(1, companyId);
		ResultSet rs = prestate.executeQuery();
		
		
		CompanyJavabean a = null;
		if(rs.next()) {
			a= new CompanyJavabean(rs.getInt(1),rs.getString(2),rs.getBlob(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getBlob(10),rs.getInt(11));
			
		}
		rs.close();
		prestate.close();
		return a;
	}

//	@Override
//	public void deletecomp(CompanyJavabean cjb) throws SQLException {
//		//刪除門市資訊
//		String sqlstr = "delete from Company where CompanyId = ? and CompanyName = ?";
//		PreparedStatement prestate = conn.prepareStatement(sqlstr);
//		prestate.setInt(1, cjb.getCompanyId());
//		prestate.setString(2, cjb.getCompanyName());
//		prestate.executeUpdate();
//		prestate.close();
//
//	}
	
	@Override
	public boolean deletecomp(CompanyJavabean cjb) throws SQLException {
		//刪除門市資訊
		String sqlstr = "delete from Company where CompanyName = ?";
		PreparedStatement prestate = conn.prepareStatement(sqlstr);
		prestate.setString(1, cjb.getCompanyName());
		prestate.executeUpdate();
		prestate.close();

		return true;
	}
	
	@Override
	public boolean verifyAccount(String account) throws SQLException {
		
		PreparedStatement prestate = conn.prepareStatement("select * from Company where CmpAcc=? ");
		prestate.setString(1, account);
		ResultSet rs = prestate.executeQuery();
			
		if(rs.next()) {
			rs.close();
			prestate.close();	
			return true;	
		}else {
			rs.close();
			prestate.close();
			return false;
		}
	}
	

	@Override
	public boolean verifyPWD(String pwd ,String account) throws SQLException {
		PreparedStatement prestate = conn.prepareStatement("select * from Company where CmpPwd=? and CmpAcc=?");
		prestate.setString(1, pwd);
		prestate.setString(2, account);
		
		ResultSet rs = prestate.executeQuery();
		if(rs.next()) {
			rs.close();
			prestate.close();
			return true;			
		}else {
			rs.close();
			prestate.close();
			return false;
		}
	}
	

	@Override
	public void closeConn() throws SQLException {
		if(conn!=null) {
			conn.close();		
		}

	}

}
