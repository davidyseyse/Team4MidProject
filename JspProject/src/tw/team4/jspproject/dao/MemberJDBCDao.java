package tw.team4.jspproject.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import tw.team4.jspproject.javabean.Member;

public class MemberJDBCDao implements IMemberDao {
	private Connection conn;

	@Override
	public void createConn() throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		//String urlstr = "jdbc:sqlserver://localhost:1433;databaseName=Demo;user=user1106;password=P@ssw0rd";
        String urlstr = "jdbc:sqlserver://java20201019.database.windows.net:1433;database=JavaDemo;user=team4sa@java20201019;password=Sa123456;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30";
		conn = DriverManager.getConnection(urlstr);        

        boolean status = !conn.isClosed();
        System.out.println("Connection Status:" + status);
	}

	@Override
	public void closeConn() throws SQLException {
		if (conn != null) {
			conn.close();
			System.out.println("JDBC連線已關閉");
		}
	}

	@Override
	public List<Member> selectAll() throws SQLException {
		String sqlstr = "Select * From Member ";
		PreparedStatement preState = conn.prepareStatement(sqlstr);
		ResultSet rs = preState.executeQuery();
		List<Member> members = new LinkedList<Member>();
		while(rs.next()) {
			//用建構子
			Member m = new Member();
			m.setId(rs.getInt(1));
			m.setFullname(rs.getString(2));
			m.setNickname(rs.getString(3));
			m.setQid(rs.getString(4));
			m.setMobile(rs.getString(5));
			m.setCountry(rs.getString(6));
			m.setCity(rs.getString(7));
			m.setAddress(rs.getString(8));
			m.setEmail(rs.getString(9));
			m.setPassword(rs.getString(10));
			m.setMobileVerifCode(rs.getString(11));
			m.setEmaileVerifCode(rs.getString(12));
			m.setProfileImage1(rs.getBinaryStream(13));
			m.setProfileImage2(rs.getBinaryStream(14));
			m.setProfileImage3(rs.getBinaryStream(15));
			m.setActive(rs.getBoolean(16));
			m.setCreatedDate(rs.getDate(17));
			m.setModifieddDate(rs.getDate(18));
			members.add(m);
		}
		
		rs.close();
		preState.close();
		return members;	
	}
	
	@Override
	public Member selectById(int id) throws SQLException {
		String sqlstr = "Select * From Member WHERE id=?";
		PreparedStatement preState = conn.prepareStatement(sqlstr);
		preState.setInt(1, id);
		ResultSet rs = preState.executeQuery();
		
		Member m = null;
		if(rs.next()) {
			m = new Member();
			m.setId(rs.getInt(1));
			m.setFullname(rs.getString(2));
			m.setNickname(rs.getString(3));
			m.setQid(rs.getString(4));
			m.setMobile(rs.getString(5));
			m.setCountry(rs.getString(6));
			m.setCity(rs.getString(7));
			m.setAddress(rs.getString(8));
			m.setEmail(rs.getString(9));
			m.setPassword(rs.getString(10));
			m.setMobileVerifCode(rs.getString(11));
			m.setEmaileVerifCode(rs.getString(12));
			m.setProfileImage1(rs.getBinaryStream(13));
			m.setProfileImage2(rs.getBinaryStream(14));
			m.setProfileImage3(rs.getBinaryStream(15));
			m.setActive(rs.getBoolean(16));
			m.setCreatedDate(rs.getDate(17));
			m.setModifieddDate(rs.getDate(18));
		}
		
		rs.close();
		preState.close();
		return m;	
	}
	
	@Override
	public void insert(Member m) throws SQLException {
        String sqlstr = "Insert Into Member(Fullname,Nickname,Qid,Email,Password,EmailVerifCode,Active,CreatedDate,ModifiedDate) "
        			 + " Values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement preState = conn.prepareStatement(sqlstr);
		
		preState.setString(1, m.getFullname());
		preState.setString(2, m.getNickname());
		preState.setString(3, m.getQid());
		preState.setString(4, m.getEmail());
		preState.setString(5, m.getPassword());
		preState.setString(6, "XXX123Ver");
		preState.setBoolean(7, false);
		preState.setTimestamp(8,  new Timestamp(System.currentTimeMillis()));
		preState.setTimestamp(9, new Timestamp(System.currentTimeMillis()));
		
		preState.execute();		
		preState.close();
	}
	
	@Override
	public int deleteById(int id) throws SQLException {
		String sqlstr = "Delete From Member WHERE id=?";
		PreparedStatement preState = conn.prepareStatement(sqlstr);
		preState.setInt(1, id);
		int result = preState.executeUpdate();
		preState.close();
		return result;	
	}
	
	@Override
	public int update(Member m) throws SQLException {
        String sqlstr = "UPDATE Member SET Nickname = ?, ModifiedDate = ? WHERE Id = ?";
		PreparedStatement preState = conn.prepareStatement(sqlstr);
		
		preState.setString(1, m.getNickname());
		//preState.setBinaryStream(2, m.getProfileImage1());
		preState.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
		preState.setInt(3, m.getId());
		
		int result = preState.executeUpdate();
		preState.close();
		return result;	
	}

//	@Override
//	public ArrayList<Lottery> selectLottery(int uBatchNum) throws SQLException {
//		String sqlstr = "Select * From Lottery where batchNum=?";
//		PreparedStatement preState = conn.prepareStatement(sqlstr);
//		preState.setInt(1, uBatchNum);
//		ResultSet rs = preState.executeQuery();
//		
//		ArrayList<Lottery> LotteryLst=new ArrayList<Lottery>();
//		while(rs.next()) {
//			LotteryLst.add(new Lottery(rs.getInt(2), rs.getInt(4), rs.getInt(6), rs.getInt(8),rs.getInt(10),rs.getInt(12)));
//		}
//		
//		rs.close();
//		preState.close();
//		if(!LotteryLst.isEmpty()) {
//			return LotteryLst;
//		}else {
//			return null;
//		}
//	}

}
