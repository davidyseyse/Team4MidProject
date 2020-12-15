package tw.team4.jspproject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.sun.net.httpserver.HttpContext;

import tw.team4.jspproject.common.Utility;
import tw.team4.jspproject.dao.IMemberDao;
import tw.team4.jspproject.dao.MemberJDBCDao;
import tw.team4.jspproject.javabean.Member;
import tw.team4.jspproject.service.AccountService;

@WebServlet("/jsp/team4/account/AccountServlet.do")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		try {
			String val = request.getParameter("action");
			if (val != null && val.contentEquals("memberlist")) {
				processMemberListAction(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		try {
			String val = request.getParameter("action");
			if (val != null && val.equals("edit")) {
				processMemberEditAction(request, response);
			}
			else if (val != null && val.equals("delete")) {
				processMemberDeleteAction(request, response);
			}
			else if (val != null && val.equals("update")) {
				processMemberUpdateAction(request, response);
			}
			else {
				processAction(request, response);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	private void processAction(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		PrintWriter out = response.getWriter();

		String fullname = request.getParameter("fullname");
		String nickname = request.getParameter("nickname");
		String qid = request.getParameter("qid");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if (Utility.hasValue(fullname) && Utility.hasValue(nickname) && Utility.hasValue(qid) && Utility.hasValue(email)
				&& Utility.hasValue(password)) {
			SimpleDateFormat df = new SimpleDateFormat("YYYYMMddhhmmss");
			String temporderNumber = df.format(new Date()) + (int) (Math.random() * 2147483647);

			// TestOrderSystemBean orderSystemBean = new TestOrderSystemBean();
			Member member = new Member(fullname, nickname, qid, email, password);
			AccountService accountService = new AccountService(new MemberJDBCDao());
			accountService.insert(member);
			
			request.setAttribute("member", member);
			request.setAttribute("Added", true);
		} 
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/team4/account/Register.jsp");
		rd.forward(request, response);
	}
	

	private void processMemberListAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AccountService accountService = new AccountService(new MemberJDBCDao());
		List<Member> members = accountService.selectAllMembers();
		request.setAttribute("members", members);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/team4/account/MemberList.jsp");
		rd.forward(request, response);
	}
	
	private void processMemberDeleteAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AccountService accountService = new AccountService(new MemberJDBCDao());
		String id = request.getParameter("memberId");
		int result = accountService.deleteById(id);
		request.setAttribute("Deleted", (result==1)? true:false);
		//RequestDispatcher rd = request.getRequestDispatcher("/jsp/team4/account/AccountServlet.do?action=memberlist");
		processMemberListAction(request, response);
		
	}

	private void processMemberEditAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AccountService accountService = new AccountService(new MemberJDBCDao());
		String id = request.getParameter("memberId");
		Member member = accountService.selectById(id);
		request.setAttribute("member", member);
		
		HttpSession session = request.getSession();
		session.setAttribute("MemberEdit_MemberId", id);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/team4/account/MemberEdit.jsp");
		rd.forward(request, response);
	}
	

	private void processMemberUpdateAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AccountService accountService = new AccountService(new MemberJDBCDao());
		
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("MemberEdit_MemberId");
		Member member = new Member();
		member.setId(Integer.parseInt(id));
		member.setNickname(request.getParameter("nickname"));
		int result = accountService.update(member);
		request.setAttribute("Updated", (result==1)? true:false);
//		for (Part part : request.getParts()) {
//			member.setProfileImage1(part.getInputStream());
//        }
//		
//		if (request.getParts()!= null) {
//			Part part = request.getPart("profileImage1");
//			member.setProfileImage1(part.getInputStream());
//		}

		

		member = accountService.selectById(id);
		request.setAttribute("member", member);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/team4/account/MemberEdit.jsp");
		rd.forward(request, response);
		
	}


}
