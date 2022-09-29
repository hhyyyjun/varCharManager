package ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberDAO;
import member.MemberVO;

/**
 * Servlet implementation class Check
 */
@WebServlet("/IDCheck")
public class IDCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IDCheck() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("로그 : [" + request.getParameter("mid")+"]");

		MemberDAO mdao = new MemberDAO();
		MemberVO mvo = new MemberVO();

		mvo.setMid(request.getParameter("mid"));
		// 요청했던 곳으로 result 값을 보낼예정
		int result = mdao.check(mvo);
		// 데이터 파일로, UTF-8로 인코딩 하라는 뜻
		response.setContentType("application/x-json; charset = UTF-8");
		// 문자열만 올 수 있으므로 문자열로 직접 변경
		response.getWriter().write(result + "");
	}

}
