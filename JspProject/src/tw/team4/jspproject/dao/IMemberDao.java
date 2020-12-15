package tw.team4.jspproject.dao;

import java.sql.SQLException;
import java.util.List;

import tw.team4.jspproject.javabean.Member;

public interface IMemberDao {
	public void createConn() throws Exception;
    public void closeConn() throws SQLException;
	List<Member> selectAll() throws SQLException;
	Member selectById(int id) throws SQLException;
	void insert(Member m) throws SQLException;
	int deleteById(int id) throws SQLException;
	int update(Member m) throws SQLException;
}
