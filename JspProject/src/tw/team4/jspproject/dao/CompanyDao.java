package tw.team4.jspproject.dao;

import java.sql.SQLException;

import tw.team4.jspproject.javabean.CompanyJavabean;

public interface CompanyDao {
	public void createConn() throws SQLException, ClassNotFoundException;
	public boolean addcomp(CompanyJavabean cjb) throws SQLException;
	public boolean uppdatecomp(CompanyJavabean cjb) throws SQLException;
	public CompanyJavabean findby (int companyId) throws SQLException;
	public CompanyJavabean findbylog(String pwd, String account) throws SQLException;
	public boolean deletecomp(CompanyJavabean cjb)throws SQLException;
	public void closeConn() throws SQLException;
	boolean verifyAccount(String account) throws SQLException;
	boolean verifyPWD(String pwd, String account) throws SQLException;
	
	
	
	
}
