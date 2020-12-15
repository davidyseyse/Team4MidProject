package tw.team4.jspproject.service;

import java.sql.SQLException;
import java.util.List;

import tw.team4.jspproject.dao.IMemberDao;
import tw.team4.jspproject.dao.MemberJDBCDao;
import tw.team4.jspproject.javabean.Member;

public class AccountService {
	private IMemberDao memberDao;
	
	
	public AccountService(IMemberDao memberDao) throws Exception {
		this.memberDao = memberDao;
		
	}
	
	public void insert(Member member) throws Exception {
		memberDao.createConn();
		memberDao.insert(member);
		memberDao.closeConn();
	}
	
	public List<Member> selectAllMembers() throws Exception {
		memberDao.createConn();
		List<Member> members = memberDao.selectAll();
		memberDao.closeConn();
		return members;
	}
	
	public Member selectById(String id) throws Exception {
		int memberId = Integer.parseInt(id);
		memberDao.createConn();
		Member member = memberDao.selectById(memberId);
		memberDao.closeConn();
		return member;
	}
	
	public int deleteById(String id) throws Exception {
		int memberId = Integer.parseInt(id);
		memberDao.createConn();
		int result = memberDao.deleteById(memberId);
		memberDao.closeConn();
		return result;
	}

	public int update(Member member) throws Exception {
		memberDao.createConn();
		int result = memberDao.update(member);
		memberDao.closeConn();
		return result;
	}
	
	
}
