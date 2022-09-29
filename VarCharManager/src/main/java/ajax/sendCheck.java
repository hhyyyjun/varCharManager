package ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MessageAPI.sendDAO;
import MessageAPI.sendVO;





/**
 * Servlet implementation class sendCheck
 */
@WebServlet("/sendCheck")
public class sendCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sendCheck() {
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
		System.out.println("sendCheck 시작");
		sendVO svo = new sendVO();
		sendDAO sdao = new sendDAO();
		System.out.println("sendCheck 통과");
		svo.setPhone(request.getParameter("randomNumber")); //랜덤한 인증번호
	//	vo.setCheckNum(request.getParameter("certificateInput")); //사용자가 입력한 숫자
		svo.setCheckNum(request.getParameter("checkNum")); //사용자가 입력한 숫자
		
		System.out.println("sendCheck 로그 : " + svo.getPhone() + " " + svo.getCheckNum());
		
		int result = sdao.sendCheck(svo);
		//요청했던 곳으로 인증번호를 보낼예정
		response.setContentType("application/x-json; charset=UTF-8");//
		response.getWriter().write(result+"");
		
	}

}
