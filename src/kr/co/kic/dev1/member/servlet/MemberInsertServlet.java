package kr.co.kic.dev1.member.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import kr.co.kic.dev1.dao.MemberDao;
import kr.co.kic.dev1.dto.MemberDto;

/**
 * Servlet implementation class MemberInsertServlet
 */
@WebServlet("/member/join")
public class MemberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//request 객체를 사용하기 전에 코딩해야 한다.
		//파라미터중에서 한글을 보내는 경우는 반드시 코딩해야 한다.
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		MemberDao dao = MemberDao.getInstance();
		//MemberDto m = new MemberDto(id,email,password);
		MemberDto m = new MemberDto();
		boolean isSuccess = dao.insert(m);
		if(isSuccess) {
			response.sendRedirect("/member/join/success");
		}else {
			response.sendRedirect("/member/join.html");
		}
		
		
			
		
		
	}

}
