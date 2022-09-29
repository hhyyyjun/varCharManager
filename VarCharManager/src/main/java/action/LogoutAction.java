package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction implements Action	{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		HttpSession session = request.getSession();
		// 09.01 준선이 코드 중 네이버 API 활용 코드
		// 로그아웃 할 때 네이버로 로그인 했는지 구분을 위해 사용
		// 세션을 저장한 곳은 naver로그인 Action에 있음
		if(request.getParameter("naver")==null) {
				session.invalidate();
		}else {
			String naver=(String)session.getAttribute("naver");
			if(naver.equals("naver")) {
				
			}
			
		}
		//System.out.println(session.getAttribute("naver"));


		forward = new ActionForward();
		forward.setPath("main.do");
		forward.setRedirect(true);
		System.out.println("LogoutAction 성공 == 로그아웃 성공");
		return forward;

	}
}
