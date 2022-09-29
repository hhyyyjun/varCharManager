package ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emailAPI.emailIdDAO;
import emailAPI.emailVO;
import member.MemberVO;

/**
 * Servlet implementation class sendEmaile
 */
@WebServlet("/sendIdEmail")
public class sendIdEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sendIdEmail() {
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
		emailIdDAO edao = new emailIdDAO();
		System.out.println("emailDAO 통과");
		
		evo.setEmail(request.getParameter("email"));//사용자의 email을 vo에 저장
		MemberVO mvo = new MemberVO();
		mvo.setMname(request.getParameter("name"));
		mvo.setMemail(request.getParameter("email"));
		System.out.println(mvo);
		String mid = edao.sendIdMail(mvo);
		
		//요청했던 곳으로 아이디를 보낼예정
		response.setContentType("text/html; charset=UTF-8");//
		response.getWriter().write(mid+"");
	}
	
	

}
