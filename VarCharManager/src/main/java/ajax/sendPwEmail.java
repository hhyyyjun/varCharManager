package ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emailAPI.emailPwDAO;
import emailAPI.emailVO;
import member.MemberVO;

/**
 * Servlet implementation class sendPwEmail
 */
@WebServlet("/sendPwEmail")
public class sendPwEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sendPwEmail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		emailVO evo = new emailVO();
		System.out.println("emailVO 통과");
		emailPwDAO edao = new emailPwDAO();
		System.out.println("emailDAO 통과");
		
		evo.setEmail(request.getParameter("email"));//사용자의 email을 vo에 저장
		MemberVO mvo = new MemberVO();
		mvo.setMid(request.getParameter("mid")); //사용자의 id를 가져와서 mvo에 set
		mvo.setMemail(request.getParameter("email")); //사용자의 email를 가져와서 mvo에 set
		System.out.println(mvo);
		
		String randomPw = edao.sendPwMail(mvo);

		System.out.println("mvo에 저장된 비밀번호 : "  + mvo.getMpw());
		
		//요청했던 곳으로 비밀번호를 보낼예정
		response.setContentType("text/html; charset=UTF-8");//
		response.getWriter().write(randomPw+"");
	}
}
