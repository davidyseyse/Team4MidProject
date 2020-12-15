package tw.team4.jspproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import tw.team4.jspproject.javabean.ReportJavaBean;

public class ReportDao {

	private Connection conn;

	public boolean createSQLServerJndiConn() throws NamingException, ClassNotFoundException, SQLException {
//		InitialContext context = new InitialContext();
//		DataSource ds = (DataSource) context.lookup("java:comp/env/connSQLServerJndi/Report");
//		conn = ds.getConnection();
//		System.out.println("conn status:" + !conn.isClosed());
//		boolean status = !conn.isClosed();
//		return status;
//	}
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(
				"jdbc:sqlserver://java20201019.database.windows.net:1433;databaseName=JavaDemo;user=team4sa@java20201019;password=Sa123456");
		if (!conn.isClosed()) {
			System.out.println("連線成功");
			return true;
		}
		return false;
	}

	// 新增
	public boolean insert(ReportJavaBean repBean) throws SQLException {
		String sqlstr = "Insert Into Report(Companyid,Storeid,Storearea,Storename,Productclass,Productname,Salesdate,Salesamount,Productprice,Payment,Activeitem) "
				+ "Values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement preState = conn.prepareStatement(sqlstr);
		preState.setString(1, repBean.getCompanyid());
		preState.setInt(2, repBean.getStoreid());
		preState.setString(3, repBean.getStorearea());
		preState.setString(4, repBean.getStorename());
		preState.setString(5, repBean.getProductclass());
		preState.setString(6, repBean.getProductname());
		preState.setString(7, repBean.getSalesdate());
		preState.setInt(8, repBean.getSalesamount());
		preState.setInt(9, repBean.getProductprice());
		preState.setString(10, repBean.getPayment());
		preState.setString(11, repBean.getActiveitem());
		int result = preState.executeUpdate();

		preState.close();

		if (result != 0) {
			return true;
		}
		return false;
	}

	// 找尋物件

	public ArrayList<ReportJavaBean> query() {
		ArrayList<ReportJavaBean> list = new ArrayList<ReportJavaBean>();
		String sqlstr = "Select * From Report";
		try {
			PreparedStatement preState = conn.prepareStatement(sqlstr);
			ResultSet reprs = preState.executeQuery();
			ReportJavaBean repBean = null;
			while (reprs.next()) {
				repBean = new ReportJavaBean(0);
				repBean.setReportid(reprs.getInt("Reportid"));
				repBean.setCompanyid(reprs.getString("Companyid"));
				repBean.setStoreid(reprs.getInt("Storeid"));
				repBean.setStorearea(reprs.getString("Storearea"));
				repBean.setStorename(reprs.getString("Storename"));
				repBean.setProductclass(reprs.getString("Productclass"));
				repBean.setProductname(reprs.getString("Productname"));
				repBean.setSalesdate(reprs.getString("Salesdate"));
				repBean.setSalesamount(reprs.getInt("Salesamount"));
				repBean.setProductprice(reprs.getInt("Productprice"));
				repBean.setPayment(reprs.getString("Payment"));
				repBean.setActiveitem(reprs.getString("Activeitem"));
//				repBean.setReportid(reprs.getInt(1));
//				repBean.setCompanyid(reprs.getString(2));
//				repBean.setStoreid(reprs.getInt(3));
//				repBean.setStorearea(reprs.getString(4));
//				repBean.setStorename(reprs.getString(5));
//				repBean.setProductclass(reprs.getString(6));
//				repBean.setProductname(reprs.getString(8));
//				repBean.setSalesdate(reprs.getString(9));
//				repBean.setSalesamount(reprs.getInt(13));
//				repBean.setProductprice(reprs.getInt(11));
//				repBean.setPayment(reprs.getString(14));
//				repBean.setActiveitem(reprs.getString(15));
				list.add(repBean);

			}
			preState.close();
			reprs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 修改
	public boolean update(ReportJavaBean reportJavaBean) throws SQLException {
		boolean result = false;
		String sqlstr = "Update Report SET Productclass=?,Productname=?,Salesamount=?,Productprice=? where Reportid=?";
		try {
			PreparedStatement repup = conn.prepareStatement(sqlstr);

			repup.setString(1, reportJavaBean.getProductclass());
			repup.setString(2, reportJavaBean.getProductname());
			repup.setInt(3, reportJavaBean.getSalesamount());
			repup.setInt(4, reportJavaBean.getProductprice());
			repup.setInt(5, reportJavaBean.getReportid());
			int count = repup.executeUpdate();
			if (count > 0)
				result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public void closeConn() throws SQLException {
		if (conn != null) {
			conn.close();
			System.out.println("connclose!");
		}
	}
}