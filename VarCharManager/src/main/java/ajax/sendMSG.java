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
 * Servlet implementation class sendMSG
 */
@WebServlet("/sendMSG")
public class sendMSG extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sendMSG() {
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
		
		sendVO svo = new sendVO();
		System.out.println("sendVO 통과");
		sendDAO sdao = new sendDAO();
		System.out.println("sendMSG 통과");
		
		svo.setPhone(request.getParameter("phone"));//사용자의 번호를 vo에 저장
		int randomNumber = sdao.sendmsg(svo);
		
		//요청했던 곳으로 인증번호를 보낼예정
		response.setContentType("application/x-json; charset=UTF-8");//
		response.getWriter().write(randomNumber+"");
	}

}
